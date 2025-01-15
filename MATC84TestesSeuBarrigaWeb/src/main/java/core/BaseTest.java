package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.LoginPage;
import pages.MenuPage;

public class BaseTest {

    private final LoginPage page = new LoginPage();
    private final MenuPage menuPage = new MenuPage();

    @BeforeEach
    public void buildUp() {
        page.logar("lucassousa@email.com", "123");
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) throws IOException {
        //screenshot final do teste
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshots" + File.separator + 
                                             testInfo.getDisplayName() + ".jpg"));

        //reset massa de dados
        menuPage.acessarHome();
        page.clickReset();

        if (Properties.FECHAR_BROWSER) {
            killDriver();
        }
    }
}

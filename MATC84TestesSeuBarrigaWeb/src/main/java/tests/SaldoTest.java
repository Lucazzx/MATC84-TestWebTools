package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import core.BaseTest;
import pages.HomePage;
import pages.MenuPage;

public class SaldoTest extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final HomePage homePage = new HomePage();

    @Test
    public void testeSaldoConta() {
        menuPage.acessarHome();
        assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
    }
}

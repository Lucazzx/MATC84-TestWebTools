package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Properties.TipoExecucao;

public class DriverFactory {
	private DriverFactory() {}

	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		
		if(Properties.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Properties.browser) {
				case FIREFOX: driver = new FirefoxDriver();break;
				case CHROME: driver = new ChromeDriver();break;
			}
		}
		
		if (Properties.TIPO_EXECUCAO == TipoExecucao.GRID) {
		    MutableCapabilities cap = null;

		    switch (Properties.browser) {
		        case FIREFOX:
		            FirefoxOptions firefoxOptions = new FirefoxOptions();
		            cap = firefoxOptions;
		            break;
		        case CHROME:
		            ChromeOptions chromeOptions = new ChromeOptions();
		            cap = chromeOptions;
		            break;
		    }

		    try {
				driver = new RemoteWebDriver(new URL("http://192.168.249.22:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.out.println("Falha na Conexão com GRID");
				e.printStackTrace();
			}
		}
		
		if (Properties.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
		    MutableCapabilities cap = null;

		    switch (Properties.browser) {
		        case FIREFOX:
		            FirefoxOptions firefoxOptions = new FirefoxOptions();
		            cap = firefoxOptions;
		            break;
		        case CHROME:
		            ChromeOptions chromeOptions = new ChromeOptions();
		            cap = chromeOptions;
		            break;
		    }

		    try {
				driver = new RemoteWebDriver(new URL("https://oauth-lucassousas-03422:4b637956-20f8-4cce-8312-dac521628e78@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.out.println("Falha na Conexão com GRID");
				e.printStackTrace();
			}
		}
		
		
		//driver.manage().window().minimize();	
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}

}
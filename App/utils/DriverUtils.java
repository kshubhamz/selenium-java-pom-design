package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverUtils {
	private static WebDriver driver;

	private DriverUtils() {

	}

	/**
	 * Get instanced WebDriver
	 * 
	 * @return WebDriver
	 * @author shubhamkumar
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Create instance of WebDriver with window maximized, 30 sec of
	 * implicit wait and 10 sec of script timeout
	 * 
	 * @param browserName browser to be used
	 * @param privateMode
	 * @author shubhamkumar
	 */
	public static void setDriver(String browserName, boolean privateMode) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions optionsC = new ChromeOptions();
			if (privateMode) {
				optionsC.addArguments("--incognito");
			}
			driver = new ChromeDriver(optionsC);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			FirefoxOptions optionsF = new FirefoxOptions();
			if (privateMode) {
				optionsF.addArguments("-private");
			}
			driver = new FirefoxDriver(optionsF);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./Driver/edgedriver.exe");
			EdgeOptions optionE = new EdgeOptions();
			if (privateMode) {
				optionE.addArguments("-inprivate");
			}
			driver = new EdgeDriver(optionE);
			break;
		case "safari":
			System.setProperty("webdriver.safari.driver", "./Driver/safaridriver.exe");
			driver = new SafariDriver();
			break;
		case "opera":
			System.setProperty("webdriver.opera.driver", "./Driver/operadriver.exe");
			OperaOptions optionO = new OperaOptions();
			if (privateMode) {
				optionO.addArguments("-private");
			}
			driver = new OperaDriver(optionO);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions optionsC1 = new ChromeOptions();
			if (privateMode) {
				optionsC1.addArguments("--incognito");
			}
			driver = new ChromeDriver(optionsC1);
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

}

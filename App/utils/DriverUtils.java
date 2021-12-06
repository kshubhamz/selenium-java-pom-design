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
	private static final int scriptTimeOut = 10;
	private static final int implicitWait = 30;

	private DriverUtils() {

	}

	/**
	 * Get instanced WebDriver
	 * 
	 * @return {@code WebDriver}
	 * @author Shubham Kumar
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Create instance of WebDriver with window maximized, 30 sec of implicit wait
	 * and 10 sec of script timeout
	 * 
	 * @param browserName browser to be used
	 * @param privateMode
	 * @author Shubham Kumar
	 */
	public static void setDriver(String browserName, boolean privateMode, boolean headless) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions optionsC = new ChromeOptions();
			if (privateMode) {
				optionsC.addArguments("--incognito");
			}
			optionsC.setHeadless(headless);
			driver = new ChromeDriver(optionsC);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			FirefoxOptions optionsF = new FirefoxOptions();
			if (privateMode) {
				optionsF.addArguments("-private");
			}
			optionsF.setHeadless(headless);
			driver = new FirefoxDriver(optionsF);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./Driver/edgedriver.exe");
			EdgeOptions optionE = new EdgeOptions();
			if (privateMode) {
				optionE.addArguments("-inprivate");
			}
			optionE.setHeadless(headless);
			driver = new EdgeDriver(optionE);
			break;
		case "safari":
			System.setProperty("webdriver.safari.driver", "./Driver/safaridriver.exe");
			driver = new SafariDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions optionsC1 = new ChromeOptions();
			if (privateMode) {
				optionsC1.addArguments("--incognito");
			}
			optionsC1.setHeadless(headless);
			driver = new ChromeDriver(optionsC1);
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}

	/**
	 * Turns implicit wait off the current instance of driver i.e. sets it to 0ms
	 * 
	 * @author Shubham Kumar
	 */
	public static void turnImplicitWaitOff() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));
	}

	/**
	 * Turns implicit wait on the current instance of driver i.e. sets it to 30s
	 * i.e. default for the current suite
	 * 
	 * @author Shubham Kumar
	 */
	public static void turnImplicitWaitOn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}

	/**
	 * Sets scriptTimeout of the current instance of the driver to specified time
	 * 
	 * @param timeInSeconds
	 * @author Shubham Kumar
	 */
	public static void setScriptTimeout(int timeInSeconds) {
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeInSeconds));
	}

	/**
	 * Sets scriptTimeout of the current instance of the driver to 10s i.e. default
	 * script timeout for the current suite
	 * 
	 * @author Shubham Kumar
	 */
	public static void resetScriptTimeout() {
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeOut));
	}

}

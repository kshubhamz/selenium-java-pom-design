package lib;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import types.TestObj;
import utils.DriverUtils;

/**
 * Class for handling Synchronisation during Test Execution
 * 
 * @author Shubham Kumar
 * @version 2.1
 *
 */
public class Waits {
	private WebDriver driver;
	private DriverUtils driverUtils;
	private Log log;
	private Commons commons;

	public Waits(TestBase t) {
		this.driver = (WebDriver) t.testObj.get(TestObj.DRIVER);
		this.driverUtils = (DriverUtils) t.testObj.get(TestObj.DRIVER_UTILS);
		this.log = (Log) t.testObj.get(TestObj.LOG);
		this.commons = (Commons) t.testObj.get(TestObj.COMMONS);
	}

	/**
	 * Pause the execution for the specified time
	 * 
	 * @param timeInseconds
	 * @author Shubham Kumar
	 */
	public void waitFor(int timeInseconds) {
		try {
			int timeInMs = timeInseconds * 1000;
			log.info("Waiting for " + timeInseconds + " second..");
			Thread.sleep(timeInMs);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Wait till the current page loads for a max time of time specified
	 * 
	 * @param maxTime in Seconds
	 * @author Shubham Kumar
	 */
	public void waitForPageLoad(int maxTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofSeconds(1))
				.until(input -> commons.getReadyStateOfDocument().equalsIgnoreCase("complete"));
	}

	/**
	 * Wait till the page with the specified title loads for a max time of time
	 * specified
	 * 
	 * @param pageTitle
	 * @param maxTime   in Seconds
	 * @author Shubham Kumar
	 */
	public void waitForPageLoad(String pageTitle, int maxTime) {
		log.info("waiting for " + pageTitle + " to load..");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofSeconds(1)).until(input -> commons.getTitleOfPage().equalsIgnoreCase(pageTitle));
		waitForPageLoad(maxTime);
		log.info(pageTitle + " loaded successfully..");
	}

	/**
	 * Wait till the element with specified selector is visible
	 * 
	 * @param selector
	 * @param maxTime
	 * @author Shubham Kumar
	 */
	public void waitForVisibilityOf(By selector, int maxTime) {
		driverUtils.turnImplicitWaitOff();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofMillis(5)).until(ExpectedConditions.visibilityOfElementLocated(selector));
		wait.pollingEvery(Duration.ofMillis(5)).until(ExpectedConditions.elementToBeClickable(selector));
		driverUtils.turnImplicitWaitOn();
	}

	/**
	 * Wait till the element with specified selector is invisible
	 * 
	 * @param selector
	 * @param maxTime
	 * @author Shubham Kumar
	 */
	public void waitForInvisibilityOf(By selector, int maxTime) {
		driverUtils.turnImplicitWaitOff();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofMillis(5)).until(ExpectedConditions.invisibilityOfElementLocated(selector));
		driverUtils.turnImplicitWaitOn();
	}

	public void waitForInvisibilityOfLoader(int maxTime) throws Exception {
		throw new Exception("This method is not yet implemented");
	}

}

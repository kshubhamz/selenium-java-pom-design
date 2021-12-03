package lib;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverUtils;

/**
 * Class for handling Synchronisation during Test Execution
 * 
 * @author Shubham Kumar
 * @version 2.0
 *
 */
public class Waits {
	private static WebDriver driver = DriverUtils.getDriver();

	private Waits() {

	}

	/**
	 * Pause the execution for the specified time
	 * 
	 * @param timeInseconds
	 * @author Shubham Kumar
	 */
	public static void waitFor(int timeInseconds) {
		try {
			int timeInMs = timeInseconds * 1000;
			Log.info("Waiting for " + timeInseconds + " second..");
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
	public static void waitForPageLoad(int maxTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofSeconds(1))
				.until(input -> JSHelper.getReadyStateOfDocument().equalsIgnoreCase("complete"));
	}

	/**
	 * Wait till the page with the specified title loads for a max time of time
	 * specified
	 * 
	 * @param pageTitle
	 * @param maxTime   in Seconds
	 * @author Shubham Kumar
	 */
	public static void waitForPageLoad(String pageTitle, int maxTime) {
		Log.info("waiting for " + pageTitle + " to load..");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofSeconds(1)).until(input -> JSHelper.getTitleOfPage().equalsIgnoreCase(pageTitle));
		waitForPageLoad(maxTime);
		Log.info(pageTitle + " loaded successfully..");
	}

	/**
	 * Wait till the element with specified selector is visible
	 * 
	 * @param selector
	 * @param maxTime
	 * @author Shubham Kumar
	 */
	public static void waitForVisibilityOf(By selector, int maxTime) {
		DriverUtils.turnImplicitWaitOff();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofMillis(5)).until(ExpectedConditions.visibilityOfElementLocated(selector));
		wait.pollingEvery(Duration.ofMillis(5)).until(ExpectedConditions.elementToBeClickable(selector));
		DriverUtils.turnImplicitWaitOn();
	}

	/**
	 * Wait till the element with specified selector is invisible
	 * 
	 * @param selector
	 * @param maxTime
	 * @author Shubham Kumar
	 */
	public static void waitForInvisibilityOf(By selector, int maxTime) {
		DriverUtils.turnImplicitWaitOff();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
		wait.pollingEvery(Duration.ofMillis(5)).until(ExpectedConditions.invisibilityOfElementLocated(selector));
		DriverUtils.turnImplicitWaitOn();
	}

	public static void waitForInvisibilityOfLoader(int maxTime) throws Exception {
		throw new Exception("This method is not yet implemented");
	}

}

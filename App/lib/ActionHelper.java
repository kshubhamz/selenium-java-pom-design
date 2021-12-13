package lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.DriverUtils;

/**
 * Class for performing various actions or combination of actions on Client side
 * 
 * @author Shubham Kumar
 * @version 2.0
 *
 */
public class ActionHelper {
	private static WebDriver driver = DriverUtils.getDriver();

	private ActionHelper() {

	}

	/**
	 * Moves to the specified element
	 * 
	 * @param el
	 * @author Shubham Kumar
	 */
	public static void moveTo(WebElement el) {
		new Actions(driver).moveToElement(el);
	}

	/**
	 * Moves to the specified selector
	 * 
	 * @param selector
	 * @author Shubham Kumar
	 */
	public static void moveTo(By selector) {
		new Actions(driver).moveToElement(driver.findElement(selector));
	}

	/**
	 * Moves to the element and perform a click on the element
	 * 
	 * @param el
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void mouseClickOn(WebElement el, String name) {
		new Actions(driver).moveToElement(el).click().build().perform();
		Log.info("Clicked on " + name);
	}

	/**
	 * Moves to the selector and perform a click on the selector
	 * 
	 * @param selector
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void mouseClickOn(By selector, String name) {
		new Actions(driver).moveToElement(driver.findElement(selector)).click().build().perform();
		Log.info("Clicked on " + name);
	}

	/**
	 * Clicks on the specified element
	 * 
	 * @param el
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void click(WebElement el, String name) {
		el.click();
		Log.info("Clicked on " + name);
	}

	/**
	 * Clicks on the specified selector
	 * 
	 * @param selector
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void click(By selector, String name) {
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
	}

	/**
	 * Clicks on the element and then captures the current view
	 * 
	 * @param el
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void clickAndCaptureScreen(WebElement el, String name) {
		el.click();
		Log.info("Clicked on " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Clicks on the selector and then captures the current view
	 * 
	 * @param selector
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void clickAndCaptureScreen(By selector, String name) {
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Clicks on the element and then waits for the loader to disappear
	 * 
	 * @param el
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void clickAndWaitForLoaderDisappear(WebElement el, String name, int maxTime) throws Exception {
		el.click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
	}

	/**
	 * Clicks on the selector and then waits for the loader to disappear
	 * 
	 * @param selector
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void clickAndWaitForLoaderDisappear(By selector, String name, int maxTime) throws Exception {
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
	}

	/**
	 * Clicks on the element and then waits for the loader to disappear and then
	 * captures the current view
	 * 
	 * @param el
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void clickAndWaitForLoaderDisappearAndCaptureScreen(WebElement el, String name, int maxTime)
			throws Exception {
		el.click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
		Commons.captureScreenshot();
	}

	/**
	 * Clicks on the selector and then waits for the loader to disappear and then
	 * captures the current view
	 * 
	 * @param selector
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void clickAndWaitForLoaderDisappearAndCaptureScreen(By selector, String name, int maxTime)
			throws Exception {
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll the element to center of view and then click on the element
	 * 
	 * @param el
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void scrollAndClick(WebElement el, String name) {
		JSHelper.scrollToCenterOfView(el);
		el.click();
		Log.info("Clicked on " + name);
	}

	/**
	 * Scroll the selector to center of view and then click on the selector
	 * 
	 * @param selector
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void scrollAndClick(By selector, String name) {
		JSHelper.scrollToCenterOfView(selector);
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
	}

	/**
	 * Scroll the element to center of view and then click on the element and then
	 * captures the current view
	 * 
	 * @param el
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void scrollAndClickAndCaptureScreen(WebElement el, String name) {
		JSHelper.scrollToCenterOfView(el);
		el.click();
		Log.info("Clicked on " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll the selector to center of view and then click on the selector and then
	 * captures the current view
	 * 
	 * @param selector
	 * @param name
	 * @author Shubham Kumar
	 */
	public static void scrollAndClickAndCaptureScreen(By selector, String name) {
		JSHelper.scrollToCenterOfView(selector);
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll the element to center of view and then click on the element and then
	 * wait for loader to disappear
	 * 
	 * @param el
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void scrollAndClickAndWaitForLoaderDisappear(WebElement el, String name, int maxTime)
			throws Exception {
		JSHelper.scrollToCenterOfView(el);
		el.click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
	}

	/**
	 * Scroll the selector to center of view and then click on the selector and then
	 * wait for loader to disappear
	 * 
	 * @param selector
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void scrollAndClickAndWaitForLoaderDisappear(By selector, String name, int maxTime) throws Exception {
		JSHelper.scrollToCenterOfView(selector);
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
	}

	/**
	 * Scroll the element to center of view and then click on the element and then
	 * wait for loader to disappear then captures the current view
	 * 
	 * @param el
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void scrollAndClickAndWaitForLoaderDisappearAndCaptureScreen(WebElement el, String name, int maxTime)
			throws Exception {
		JSHelper.scrollToCenterOfView(el);
		el.click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll the selector to center of view and then click on the selector and then
	 * wait for loader to disappear then captures the current view
	 * 
	 * @param selector
	 * @param name
	 * @param maxTime
	 * @throws Exception
	 * @author Shubham Kumar
	 */
	public static void scrollAndClickAndWaitForLoaderDisappearAndCaptureScreen(By selector, String name, int maxTime)
			throws Exception {
		JSHelper.scrollToCenterOfView(selector);
		driver.findElement(selector).click();
		Log.info("Clicked on " + name);
		Waits.waitFor(1);
		Waits.waitForInvisibilityOfLoader(maxTime);
		Commons.captureScreenshot();
	}

	/**
	 * Enters the specified text in input type element
	 * 
	 * @param el
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void enterText(WebElement el, String name, String value) {
		el.sendKeys(value);
		Log.info("Entered " + value + " in " + name);
	}

	/**
	 * Enters the specified text in input type selector
	 * 
	 * @param selector
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void enterText(By selector, String name, String value) {
		driver.findElement(selector).sendKeys(value);
		Log.info("Entered " + value + " in " + name);
	}

	/**
	 * Enters the specified text in input type element and then captures the current
	 * view
	 * 
	 * @param el
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void enterTextAndCaptureScreen(WebElement el, String name, String value) {
		el.sendKeys(value);
		Log.info("Entered " + value + " in " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Enters the specified text in input type selector and then captures the
	 * current view
	 * 
	 * @param selector
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void enterTextAndCaptureScreen(By selector, String name, String value) {
		driver.findElement(selector).sendKeys(value);
		Log.info("Entered " + value + " in " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll and enters specified text in input type element
	 * 
	 * @param el
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void scrollAndEnterText(WebElement el, String name, String value) {
		JSHelper.scrollToCenterOfView(el);
		el.sendKeys(value);
		Log.info("Entered " + value + " in " + name);
	}

	/**
	 * Scroll and enters specified text in input type selector
	 * 
	 * @param selector
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void scrollAndEnterText(By selector, String name, String value) {
		JSHelper.scrollToCenterOfView(selector);
		driver.findElement(selector).sendKeys(value);
		Log.info("Entered " + value + " in " + name);
	}

	/**
	 * Scroll and enters specified text in input type element and then captures the
	 * current view
	 * 
	 * @param el
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void scrollAndEnterTextAndCaptureScreen(WebElement el, String name, String value) {
		JSHelper.scrollToCenterOfView(el);
		el.sendKeys(value);
		Log.info("Entered " + value + " in " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll and enters specified text in input type selector and then captures the
	 * current view
	 * 
	 * @param selector
	 * @param name
	 * @param value
	 * @author Shubham Kumar
	 */
	public static void scrollAndEnterTextAndCaptureScreen(By selector, String name, String value) {
		JSHelper.scrollToCenterOfView(selector);
		driver.findElement(selector).sendKeys(value);
		Log.info("Entered " + value + " in " + name);
		Commons.captureScreenshot();
	}

	/**
	 * Selects specified option from the dropdown element
	 * 
	 * @param el
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void selectFromDropdownByVisibleText(WebElement el, String option, String dropdownName) {
		new Select(el).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
	}

	/**
	 * Selects specified option from the dropdown selector
	 * 
	 * @param selector
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void selectFromDropdownByVisibleText(By selector, String option, String dropdownName) {
		new Select(driver.findElement(selector)).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
	}

	/**
	 * Selects specified option from the dropdown element and then captures the
	 * current view
	 * 
	 * @param el
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void selectFromDropdownByVisibleTextAndCaptureScreen(WebElement el, String option,
			String dropdownName) {
		new Select(el).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
		Commons.captureScreenshot();
	}

	/**
	 * Selects specified option from the dropdown selector and then captures the
	 * current view
	 * 
	 * @param selector
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void selectFromDropdownByVisibleTextAndCaptureScreen(By selector, String option,
			String dropdownName) {
		new Select(driver.findElement(selector)).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll and Selects specified option from the dropdown element
	 * 
	 * @param el
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void scrollAndSelectFromDropdownByVisibleText(WebElement el, String option, String dropdownName) {
		JSHelper.scrollToCenterOfView(el);
		new Select(el).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
	}

	/**
	 * Scroll and Selects specified option from the dropdown selector
	 * 
	 * @param selector
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void scrollAndSelectFromDropdownByVisibleText(By selector, String option, String dropdownName) {
		JSHelper.scrollToCenterOfView(selector);
		new Select(driver.findElement(selector)).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
	}

	/**
	 * Scroll and Selects specified option from the dropdown element and then
	 * captures the current view
	 * 
	 * @param el
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void scrollAndSelectFromDropdownByVisibleTextAndCaptureScreen(WebElement el, String option,
			String dropdownName) {
		JSHelper.scrollToCenterOfView(el);
		new Select(el).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
		Commons.captureScreenshot();
	}

	/**
	 * Scroll and Selects specified option from the dropdown selector and then
	 * captures the current view
	 * 
	 * @param selector
	 * @param option
	 * @param dropdownName
	 * @author Shubham Kumar
	 */
	public static void scrollAndSelectFromDropdownByVisibleTextAndCaptureScreen(By selector, String option,
			String dropdownName) {
		JSHelper.scrollToCenterOfView(selector);
		new Select(driver.findElement(selector)).selectByVisibleText(option);
		Log.info("Selected from " + dropdownName + " - " + option);
		Commons.captureScreenshot();
	}

	/**
	 * Selects from dropdown element by partial text
	 * 
	 * @param el
	 * @param partialText
	 * @author Shubham Kumar
	 */
	public static void selectFromDropdownByPartialText(WebElement el, String partialText) {
		Select dropdown = new Select(el);
		List<WebElement> options = dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(partialText)) {
				dropdown.selectByIndex(i);
				break;
			}
		}
	}

	/**
	 * Selects from dropdown selector by partial text
	 * 
	 * @param selector
	 * @param partialText
	 * @author Shubham Kumar
	 */
	public static void selectFromDropdownByPartialText(By selector, String partialText) {
		Select dropdown = new Select(driver.findElement(selector));
		List<WebElement> options = dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(partialText)) {
				dropdown.selectByIndex(i);
				break;
			}
		}
	}

}

package lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import types.TestObj;

/**
 * Class for performing various actions or combination of actions on Client side
 * 
 * @version 2.1
 */

public class ActionHelper {
	private WebDriver driver;
	private Commons commons;
	private Waits waits;
	private Log log;

	public ActionHelper(TestBase t) {
		this.driver = (WebDriver) t.testObj.get(TestObj.DRIVER);
		this.commons = (Commons) t.testObj.get(TestObj.COMMONS);
		this.waits = (Waits) t.testObj.get(TestObj.WAITS);
		this.log = (Log) t.testObj.get(TestObj.LOG);
	}

	/**
	 * Scroll the provided WebElement to center of viewport
	 * 
	 * @param el
	 * @return {@code ActionHelper}
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper scrollTo(WebElement el) {
		commons.scrollToCenterOfView(el);
		return this;
	}

	/**
	 * Scroll the provided selector to center of viewport
	 * 
	 * @param el
	 * @return {@code ActionHelper}
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper scrollTo(By selector) {
		commons.scrollToCenterOfView(selector);
		return this;
	}

	/**
	 * Capture current view
	 * 
	 * @return {@code ActionHelper}
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper captureScreen() {
		commons.captureScreenshot();
		return this;
	}

	/**
	 * Pause for 1 second
	 * 
	 * @return {@code ActionHelper}
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper pause() {
		waits.waitFor(1);
		return this;
	}

	/**
	 * Wait for loader to disappear
	 * 
	 * @param maxTime
	 * @return {@code ActionHelper}
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper waitForLoader(int maxTime) throws Exception {
		waits.waitForInvisibilityOfLoader(maxTime);
		return this;
	}

	/**
	 * Moves to the specified element
	 * 
	 * @param el
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper moveTo(WebElement el) {
		new Actions(driver).moveToElement(el);
		return this;
	}

	/**
	 * Moves to the specified selector
	 * 
	 * @param selector
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper moveTo(By selector) {
		new Actions(driver).moveToElement(driver.findElement(selector));
		return this;
	}

	/**
	 * Moves to the element and perform a click on the element
	 * 
	 * @param el
	 * @param name
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper mouseClickOn(WebElement el, String name) {
		new Actions(driver).moveToElement(el).click().build().perform();
		log.info("Clicked on " + name);
		return this;
	}

	/**
	 * Moves to the selector and perform a click on the selector
	 * 
	 * @param selector
	 * @param name
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper mouseClickOn(By selector, String name) {
		new Actions(driver).moveToElement(driver.findElement(selector)).click().build().perform();
		log.info("Clicked on " + name);
		return this;
	}

	/**
	 * Clicks on the specified element
	 * 
	 * @param el
	 * @param name
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper click(WebElement el, String name) {
		el.click();
		log.info("Clicked on " + name);
		return this;
	}

	/**
	 * Clicks on the specified selector
	 * 
	 * @param selector
	 * @param name
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper click(By selector, String name) {
		driver.findElement(selector).click();
		log.info("Clicked on " + name);
		return this;
	}

	/**
	 * Enters the specified text in input type element
	 * 
	 * @param el
	 * @param name
	 * @param value
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper enterText(WebElement el, String name, String value) {
		el.sendKeys(value);
		log.info("Entered " + value + " in " + name);
		return this;
	}

	/**
	 * Enters the specified text in input type selector
	 * 
	 * @param selector
	 * @param name
	 * @param value
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper enterText(By selector, String name, String value) {
		driver.findElement(selector).sendKeys(value);
		log.info("Entered " + value + " in " + name);
		return this;
	}

	/**
	 * Selects specified option from the dropdown element
	 * 
	 * @param el
	 * @param option
	 * @param dropdownName
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper selectFromDropdownByVisibleText(WebElement el, String option, String dropdownName) {
		new Select(el).selectByVisibleText(option);
		log.info("Selected from " + dropdownName + " - " + option);
		return this;
	}

	/**
	 * Selects specified option from the dropdown selector
	 * 
	 * @param selector
	 * @param option
	 * @param dropdownName
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper selectFromDropdownByVisibleText(By selector, String option, String dropdownName) {
		new Select(driver.findElement(selector)).selectByVisibleText(option);
		log.info("Selected from " + dropdownName + " - " + option);
		return this;
	}

	/**
	 * Selects from dropdown element by partial text
	 * 
	 * @param el
	 * @param partialText
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper selectFromDropdownByPartialText(WebElement el, String partialText) {
		Select dropdown = new Select(el);
		List<WebElement> options = dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(partialText)) {
				dropdown.selectByIndex(i);
				break;
			}
		}
		return this;
	}

	/**
	 * Selects from dropdown selector by partial text
	 * 
	 * @param selector
	 * @param partialText
	 * @return {@code ActionHelper}
	 * @author Shubham Kumar
	 */
	public ActionHelper selectFromDropdownByPartialText(By selector, String partialText) {
		Select dropdown = new Select(driver.findElement(selector));
		List<WebElement> options = dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(partialText)) {
				dropdown.selectByIndex(i);
				break;
			}
		}
		return this;
	}

}

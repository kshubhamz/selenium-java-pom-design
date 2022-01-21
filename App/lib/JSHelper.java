package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;
import types.TestObj;

/**
 * Class for executing JavaScript on Client side
 * 
 * @author Shubham Kumar
 * @version 2.1
 */
class JSHelper {
	private WebDriver driver ;
	private JavascriptExecutor scriptExecutor;

	protected JSHelper(TestBase t) {
		this.driver = (WebDriver) t.testObj.get(TestObj.DRIVER);
		this.scriptExecutor = (JavascriptExecutor) this.driver;
	}

	/**
	 * Executes a script to get inner height of client
	 * 
	 * @return {@code Integer} Rounded value of height
	 * @author Shubham Kumar
	 */
	public int getInnerHeightOfBroserWindow() {
		String innerHeight = scriptExecutor.executeScript("return window.innerHeight;").toString();
		return Math.round(Float.parseFloat(innerHeight));
	}

	/**
	 * Executes a script to get inner width of client
	 * 
	 * @return {@code Integer} Rounded value of width
	 * @author Shubham Kumar
	 */
	public int getInnerWidthOfBroserWindow() {
		String innerHeight = scriptExecutor.executeScript("return window.innerWidth;").toString();
		return Math.round(Float.parseFloat(innerHeight));
	}

	/**
	 * Executes a script to get the y-cord of the bottom right corner of the element
	 * w.r.t browser inner window
	 * 
	 * @param el
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getBottomLocationOf(WebElement el) {
		String bottomLocation = scriptExecutor.executeScript("return arguments[0].getBoundingClientRect().bottom;", el)
				.toString();
		return Math.round(Float.parseFloat(bottomLocation));
	}

	/**
	 * Executes a script to get the y-cord of the bottom right corner of the locator
	 * w.r.t browser inner window
	 * 
	 * @param selector
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getBottomLocationOf(By selector) {
		String bottomLocation = scriptExecutor
				.executeScript("return arguments[0].getBoundingClientRect().bottom;", driver.findElement(selector))
				.toString();
		return Math.round(Float.parseFloat(bottomLocation));
	}

	/**
	 * Executes a script to get the y-cord of the top left corner of the element
	 * w.r.t browser inner window
	 * 
	 * @param el
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getTopLocationOf(WebElement el) {
		String topLocation = scriptExecutor.executeScript("return arguments[0].getBoundingClientRect().top;", el)
				.toString();
		return Math.round(Float.parseFloat(topLocation));
	}

	/**
	 * Executes a script to get the y-cord of the top left corner of the locator
	 * w.r.t browser inner window
	 * 
	 * @param selector
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getTopLocationOf(By selector) {
		String topLocation = scriptExecutor
				.executeScript("return arguments[0].getBoundingClientRect().top;", driver.findElement(selector))
				.toString();
		return Math.round(Float.parseFloat(topLocation));
	}

	/**
	 * Executes a script to get the x-cord of the top left corner of the element
	 * w.r.t browser inner window
	 * 
	 * @param el
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getLeftLocationOf(WebElement el) {
		String leftLocation = scriptExecutor.executeScript("return arguments[0].getBoundingClientRect().left;", el)
				.toString();
		return Math.round(Float.parseFloat(leftLocation));
	}

	/**
	 * Executes a script to get the x-cord of the top left corner of the selector
	 * w.r.t browser inner window
	 * 
	 * @param selector
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getLeftLocationOf(By selector) {
		String leftLocation = scriptExecutor
				.executeScript("return arguments[0].getBoundingClientRect().left;", driver.findElement(selector))
				.toString();
		return Math.round(Float.parseFloat(leftLocation));
	}

	/**
	 * Executes a script to get the x-cord of the bottom right corner of the element
	 * w.r.t browser inner window
	 * 
	 * @param el
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getRightLocationOf(WebElement el) {
		String rightLocation = scriptExecutor.executeScript("return arguments[0].getBoundingClientRect().right;", el)
				.toString();
		return Math.round(Float.parseFloat(rightLocation));
	}

	/**
	 * Executes a script to get the x-cord of the bottom right corner of the
	 * selector w.r.t browser inner window
	 * 
	 * @param selector
	 * @return {@code Integer} Rounded value of the coordinate
	 * @author Shubham Kumar
	 */
	public int getRightLocationOf(By selector) {
		String rightLocation = scriptExecutor
				.executeScript("return arguments[0].getBoundingClientRect().right;", driver.findElement(selector))
				.toString();
		return Math.round(Float.parseFloat(rightLocation));
	}

	/**
	 * Executes a script to get the client height of the element
	 * 
	 * @param el
	 * @return {@code Integer} Rounded value of the height
	 * @author Shubham Kumar
	 */
	public int getHeightOf(WebElement el) {
		String height = scriptExecutor.executeScript("return arguments[0].getBoundingClientRect().height;", el)
				.toString();
		return Math.round(Float.parseFloat(height));
	}

	/**
	 * Executes a script to get the client height of the selector
	 * 
	 * @param selector
	 * @return {@code Integer} Rounded value of the height
	 * @author Shubham Kumar
	 */
	public int getHeightOf(By selector) {
		String height = scriptExecutor
				.executeScript("return arguments[0].getBoundingClientRect().height;", driver.findElement(selector))
				.toString();
		return Math.round(Float.parseFloat(height));
	}

	/**
	 * Executes a script to get the client width of the element
	 * 
	 * @param el
	 * @return {@code Integer} Rounded value of the width
	 * @author Shubham Kumar
	 */
	public int getWidthOf(WebElement el) {
		String width = scriptExecutor.executeScript("return arguments[0].getBoundingClientRect().width;", el)
				.toString();
		return Math.round(Float.parseFloat(width));
	}

	/**
	 * Executes a script to get the client width of the selector
	 * 
	 * @param selector
	 * @return {@code Integer} Rounded value of the width
	 * @author Shubham Kumar
	 */
	public int getWidthOf(By selector) {
		String width = scriptExecutor
				.executeScript("return arguments[0].getBoundingClientRect().width;", driver.findElement(selector))
				.toString();
		return Math.round(Float.parseFloat(width));
	}

	/**
	 * Executes a script to open url in new tab
	 * 
	 * @param url
	 * @author Shubham Kumar
	 */
	public void openNewTab(String url) {
		scriptExecutor.executeScript("window.open(`" + url + "`);");
	}

	/**
	 * Executes a script to scroll the element to vertical & horizontal center
	 * 
	 * @param el
	 * @author Shubham Kumar
	 */
	public void scrollToCenterOfView(WebElement el) {
		scriptExecutor.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", el);
	}

	/**
	 * Executes a script to scroll the selector to vertical & horizontal center
	 * 
	 * @param selector
	 * @author Shubham Kumar
	 */
	public void scrollToCenterOfView(By selector) {
		scriptExecutor.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});",
				driver.findElement(selector));
	}

	/**
	 * Executes a script to get the absence of the XPath in DOM
	 * 
	 * @param xpath
	 * @return {@code Boolean} value of the XPath absence
	 * @author Shubham Kumar
	 */
	public boolean getAbsenceOfXpath(By xpath) {
		String xpathExpression = xpath.toString().substring(10).replace("\"", "\\\"");
		return (boolean) scriptExecutor.executeScript("return document.evaluate(\"count(" + xpathExpression
				+ ")\", document, null, XPathResult.ANY_TYPE, null).numberValue === 0;");
	}

	/**
	 * Executes a script to get the ready state of the document
	 * 
	 * @return {@code String} ready state of the document
	 * @author Shubham Kumar
	 */
	String getReadyStateOfDocument() {
		return scriptExecutor.executeScript("return document.readyState;").toString().trim();
	}

	/**
	 * Executes a script to get text content of an element
	 * 
	 * @param el
	 * @return {@code String} value of text content
	 * @author Shubham Kumar
	 */
	public String getInnerTextOf(WebElement el) {
		return scriptExecutor.executeScript("return arguments[0].textContent;", el).toString();
	}

	/**
	 * Executes a script to get text content of an selector
	 * 
	 * @param selector
	 * @return {@code String} value of text content
	 * @author Shubham Kumar
	 */
	public String getInnerTextOf(By selector) {
		return scriptExecutor.executeScript("return arguments[0].textContent;", driver.findElement(selector))
				.toString();
	}

	/**
	 * Gets the title of the page
	 * 
	 * @return {@code String} Title of the page
	 * @author Shubham Kumar
	 */
	public String getTitleOfPage() {
		return scriptExecutor.executeScript("return document.title;").toString();
	}

}

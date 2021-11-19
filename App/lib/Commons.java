package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utils.DriverUtils;

/**
 * Class for storing Common Functions for Test Execution
 * 
 * @author Shubham Kumar
 * @version 2.0
 *
 */
public class Commons extends JSHelper {
	private static WebDriver driver = DriverUtils.getDriver();

	private Commons() {

	}

	/**
	 * Captures ScreenShot and Stores in Result folder
	 * 
	 * @author Shubham Kumar
	 */
	public static void captureScreenshot() {
		String folderPath = TestBase.folderPath;
		String testId = TestBase.getTestID();

		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile,
					new File(folderPath + "/" + testId + "/Img_" + System.currentTimeMillis() + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finds the presence of element on the screen with the specified xpath selector
	 * 
	 * @param selector Xpath of the element
	 * @return {@code Boolean} Presence of the element
	 * @author Shubham Kumar
	 */
	public static boolean getPresenceOfElementWithXpath(By selector) {
		if (!getAbsenceOfXpath(selector)) {
			return driver.findElement(selector).isDisplayed();
		} else {
			return false;
		}
	}

	/**
	 * Compares two Lists
	 * 
	 * @param l1 List1
	 * @param l2 List2
	 * @return {@code Boolean} If Both Lists contains same data
	 * @author Shubham Kumar
	 */
	public static boolean compareList(List<?> l1, List<?> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}

		ArrayList<?> temp = new ArrayList<>(l2);
		for (Object o : l1) {
			if (!temp.remove(o)) {
				return false;
			}
		}

		return temp.isEmpty();
	}

	/**
	 * Writes data to the specified column for the current running TestCase
	 * 
	 * @param columnName
	 * @param data
	 * @author Shubham Kumar
	 */
	public static void writeToExcel(String columnName, String data) {
		try (FileInputStream fis = new FileInputStream(TestBase.testDataFile)) {
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(TestBase.sheetName);

			int row = sh.getPhysicalNumberOfRows();
			int col = sh.getRow(0).getPhysicalNumberOfCells();

			int colIndex = -1;
			for (int i = 1; i < col; i++) {
				String colName = sh.getRow(0).getCell(i).getStringCellValue().trim();
				if (colName.equalsIgnoreCase(columnName)) {
					colIndex = i;
					break;
				}
			}

			String testName = TestBase.testCaseName;
			for (int i = 1; i < row; i++) {
				String currentTestName = sh.getRow(i).getCell(0).getStringCellValue().trim();

				if (testName.equalsIgnoreCase(currentTestName)) {
					Cell cell = sh.getRow(i).getCell(colIndex);
					if (colIndex != -1) {
						cell.setCellValue(data);
						Log.info("Added value: " + data + " To Column: " + columnName + " for TestCase " + testName);
						break;
					}
				}
			}

			FileOutputStream fos = new FileOutputStream(TestBase.testDataFile);
			wb.write(fos);
			wb.close();
			fos.close();
			TestBase.setTestData();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Gets first selected option from the dropdown element
	 * 
	 * @param el
	 * @return {@code WebElement} Option
	 * @author Shubham Kumar
	 */
	public static WebElement getFirstSelectedOptionFromDropdown(WebElement el) {
		return new Select(el).getFirstSelectedOption();
	}

	/**
	 * Gets first selected option from the dropdown selector
	 * 
	 * @param selector
	 * @return {@code WebElement} Option
	 * @author Shubham Kumar
	 */
	public static WebElement getFirstSelectedOptionFromDropdown(By selector) {
		return new Select(driver.findElement(selector)).getFirstSelectedOption();
	}
}
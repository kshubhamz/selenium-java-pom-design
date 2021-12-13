package base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lib.Log;
import utils.ExcelReader;

/**
 * Class for interacting with TestData and run-properties
 * 
 * @author Shubham Kumar
 * @version 2.0
 *
 */
public class TestBase {
	public static String testCaseName;
	public static String sheetName;
	public static String testDataFile;
	public static String folderPath;

	private TestBase() {

	}

	/**
	 * Reads data from file and sets to TestObjects
	 * 
	 * @throws IOException
	 * @author Shubham Kumar
	 */
	public static void setTestData() throws IOException {
		TestObjects.testData = ExcelReader.readExcel(testDataFile, sheetName);
	}

	/**
	 * Gets data for the specified column from TestObjects
	 * 
	 * @param colName
	 * @return {@code String} Data for particular column for current running test
	 * @author Shubham Kumar
	 */
	public static String getData(String colName) {
		return TestObjects.getColValue(colName);
	}

	/**
	 * Sets fiilePath and sheetName for the Test
	 * 
	 * @param filePath
	 * @param sheet
	 * @author Shubham Kumar
	 */
	public static void setDataParameters(String filePath, String sheet) {
		sheetName = sheet;
		testDataFile = filePath;
	}

	/**
	 * Sets which row's data to be used for current running Test
	 * 
	 * @param testId
	 * @author Shubham Kumar
	 */
	public static void setTestID(String testId, String ...otherProps) {
		testCaseName = testId;
		TestObjects.setTestID(testId);
		if (otherProps.length == 0) Log.startTestCase(testId);
	}

	/**
	 * Gets current running TestID
	 * 
	 * @return {@code String}
	 * @author Shubham Kumar
	 */
	public static String getTestID() {
		return TestObjects.getTestID();
	}

	/**
	 * Creates a new Results Directory in Root Folder for storing screen shots
	 * 
	 * @author Shubham Kumar
	 */
	public static void mkdirRoot() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date = new Date();
		String folderName = "./Results/" + TestObjects.getRunProperties().getProperty("APP_NAME").trim()
				+ "_TC_ScreenShot/" + dateFormat.format(date) + "";
		folderPath = folderName;
		new File(folderName).mkdir();
	}

	/**
	 * Gets run time property from run.properties
	 * 
	 * @param property
	 * @return {@code String} Configuration for the specified key
	 * @author Shubham Kumar
	 */
	public static String getProperty(String property) {
		return TestObjects.getRunProperties().getProperty(property).trim();
	}

	/**
	 * Sets run configuration for the test
	 * 
	 * @throws IOException
	 * @author Shubham Kumar
	 */
	public static void setRunProperties() throws IOException {
		TestObjects.setRunProperties();
	}

}

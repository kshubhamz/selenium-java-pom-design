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
 * @author shubhamkumar
 * @version 2.0
 *
 */
public class TestBase {
	public static String testCaseName;
	public static String sheetName;
	public static String testDataFile;

	private TestBase() {

	}

	/**
	 * Reads data from file and sets to TestObjects
	 * 
	 * @throws IOException
	 * @author shubhamkumar
	 */
	public static void setTestData() throws IOException {
		TestObjects.testData = ExcelReader.readExcel(testDataFile, sheetName);
	}

	/**
	 * Gets data for the specified column from TestObjects
	 * 
	 * @param colName
	 * @return Data for particular column for current running test
	 * @author shubhamkumar
	 */
	public static String getData(String colName) {
		return TestObjects.getColValue(colName);
	}

	/**
	 * Sets fiilePath and sheetName for the Test
	 * 
	 * @param filePath
	 * @param sheet
	 * @author shubhamkumar
	 */
	public static void setDataParameters(String filePath, String sheet) {
		sheetName = sheet;
		testDataFile = filePath;
	}

	/**
	 * Sets which row's data to be used for current running Test
	 * 
	 * @param testId
	 * @author shubhamkumar
	 */
	public static void setTestID(String testId) {
		testCaseName = testId;
		TestObjects.setTestID(testId);
		Log.startTestCase(testId);
	}

	/**
	 * Gets current running TestID
	 * 
	 * @return
	 * @author shubhamkumar
	 */
	public static String getTestID() {
		return TestObjects.getTestID();
	}

	/**
	 * Creates a new Results Directory in Root Folder for storing screen shots
	 * 
	 * @author shubhamkumar
	 */
	public static void mkdirRoot() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date = new Date();
		String folderName = "./Results/" + TestObjects.getRunProperties().getProperty("APP_NAME").trim()
				+ "_TC_ScreenShot/" + dateFormat.format(date) + "";
		TestObjects.setFolderPath(folderName);
		new File(folderName).mkdir();
	}

	/**
	 * Gets run time property from run.properties
	 * 
	 * @param property
	 * @return Property for the specified key
	 * @author shubhamkumar
	 */
	public static String getProperty(String property) {
		return TestObjects.getRunProperties().getProperty(property).trim();
	}

}

package base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import types.TestObj;
import utils.ExcelReader;

/**
 * Class for interacting with TestData and run-properties
 * 
 * @author Shubham Kumar
 * @version 2.1
 *
 */
public class TestBase {
	public String testCaseName;
	public String sheetName;
	public String testDataFile;
	public String folderPath;
	private TestObjects testObjects;
	public Map<TestObj	, Object> testObj = new LinkedHashMap<>();

	public TestBase() {
		this.testObjects = new TestObjects();
		testObj.put(TestObj.TESTBASE, this);
	}

	/**
	 * Reads data from file and sets to TestObjects
	 * 
	 * @throws IOException
	 * @author Shubham Kumar
	 */
	public void setTestData() throws IOException {
		testObjects.testData = ExcelReader.readExcel(testDataFile, sheetName);
	}

	/**
	 * Gets data for the specified column from TestObjects
	 * 
	 * @param colName
	 * @return {@code String} Data for particular column for current running test
	 * @author Shubham Kumar
	 */
	public String getData(String colName) {
		return testObjects.getColValue(colName);
	}

	/**
	 * Sets fiilePath and sheetName for the Test
	 * 
	 * @param filePath
	 * @param sheet
	 * @author Shubham Kumar
	 */
	public void setDataParameters(String filePath, String sheet) {
		sheetName = sheet;
		testDataFile = filePath;
	}

	/**
	 * Sets which row's data to be used for current running Test
	 * 
	 * @param testId
	 * @author Shubham Kumar
	 */
	public void setTestID(String testId) {
		testCaseName = testId;
		testObjects.setTestID(testId);
	}

	/**
	 * Gets current running TestID
	 * 
	 * @return {@code String}
	 * @author Shubham Kumar
	 */
	public String getTestID() {
		return testObjects.getTestID();
	}

	/**
	 * Creates a new Results Directory in Root Folder for storing screen shots
	 * 
	 * @author Shubham Kumar
	 */
	public void mkdirRoot() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date = new Date();
		String folderName = "./Results/" + testObjects.getRunProperties().getProperty("APP_NAME").trim()
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
	public String getProperty(String property) {
		return testObjects.getRunProperties().getProperty(property).trim();
	}

	/**
	 * Sets run configuration for the test
	 * 
	 * @throws IOException
	 * @author Shubham Kumar
	 */
	public void setRunProperties() throws IOException {
		testObjects.setRunProperties();
	}

}

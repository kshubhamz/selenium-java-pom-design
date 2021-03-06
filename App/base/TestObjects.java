package base;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import utils.PropertiesReader;

/**
 * Class for storing TestObjects
 * 
 * @author Shubham Kumar
 * @version 2.0
 *
 */
class TestObjects {
	String testID;
	private Properties runProperties;
	Map<String, Map<String, String>> testData = new LinkedHashMap<>();

	/**
	 * Sets TestID
	 * 
	 * @param testId
	 * @author Shubham Kumar
	 */
	public void setTestID(String testId) {
		testID = testId;
	}

	/**
	 * Gets TestID
	 * 
	 * @return {@code String}
	 * @author Shubham Kumar
	 */
	public String getTestID() {
		return testID;
	}

	/**
	 * Sets Test Data for Test Execution
	 * 
	 * @param data
	 * @author Shubham Kumar
	 */
	public void setTestData(Map<String, Map<String, String>> data) {
		testData = data;
	}

	/**
	 * Sets Configuration for Test Execution
	 * 
	 * @throws IOException
	 * @author Shubham Kumar
	 */
	public void setRunProperties() throws IOException {
		runProperties = PropertiesReader.readProperties("run.properties");
	}

	/**
	 * Get Configuration for Test Execution
	 * 
	 * @return {@code Properties}
	 * @author Shubham Kumar
	 */
	public Properties getRunProperties() {
		return runProperties;
	}

	/**
	 * Get Cell Data for the set TestID
	 * 
	 * @param colName
	 * @return {@code String}
	 * @author Shubham Kumar
	 */
	public String getColValue(String colName) {
		return testData.get(testID).get(colName);
	}

}

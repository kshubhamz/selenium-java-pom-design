package base;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import utils.PropertiesReader;

/**
 * Class for storing TestObjects
 * 
 * @author shubhamkumar
 * @version 2.0
 *
 */
class TestObjects {
	static String testID;
	private static Properties runProperties;
	public static String folderPath;
	static Map<String, Map<String, String>> testData = new LinkedHashMap<>();

	private TestObjects() {

	}

	public static void setTestID(String testId) {
		testID = testId;
	}

	public static String getTestID() {
		return testID;
	}

	public static void setTestData(Map<String, Map<String, String>> data) {
		testData = data;
	}

	public static void setRunProperties() throws IOException {
		runProperties = PropertiesReader.readProperties("run.properties");
	}

	public static Properties getRunProperties() {
		return runProperties;
	}

	public static String getColValue(String colName) {
		return testData.get(testID).get(colName);
	}

	public static void setFolderPath(String path) {
		folderPath = path;
	}

}

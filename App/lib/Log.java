package lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

/**
 * Class for Logging to Console using log4j
 * 
 * @author Shubham Kumar
 * @version 2.0
 *
 */
public class Log {
	private static Logger logger = LogManager.getLogger(Log.class);

	private Log() {

	}

	/**
	 * Logs a separator to console
	 * 
	 * @author Shubham Kumar
	 */
	private static void logSeperator() {
		logger.info("****************************************************************************");
		logger.info("****************************************************************************");
	}

	/**
	 * Logs test case execution starting message to console
	 * 
	 * @param testCaseName Current TestCase Name
	 * @author Shubham Kumar
	 */
	public static void startTestCase(String testCaseName) {
		logger.info("TestCase Execution Starting...");
		logger.info("TestCase Name: " + testCaseName);
		logSeperator();
	}

	/**
	 * Logs test case execution Ended message to console
	 * 
	 * @param testCaseName Current TestCase Name
	 * @author Shubham Kumar
	 */
	public static void endTestCase(String testCaseName) {
		logger.info("TestCase Execution Ended: " + testCaseName);
		logSeperator();
	}

	/**
	 * Logs a info message to console
	 * 
	 * @param message
	 * @author Shubham Kumar
	 */
	public static void info(String message) {
		logger.info(message);
	}

	/**
	 * Logs a warning message to console
	 * 
	 * @param message
	 * @author Shubham Kumar
	 */
	public static void warn(String message) {
		logger.warn(message);
	}

	/**
	 * Logs a error message to console
	 * 
	 * @param message
	 * @author Shubham Kumar
	 */
	public static void error(String message) {
		logger.error(message);
	}

	/**
	 * Logs a fatal message to console
	 * 
	 * @param message
	 * @author Shubham Kumar
	 */
	public static void fatal(String message) {
		logger.fatal(message);
	}

	/**
	 * Logs a debug message to console
	 * 
	 * @param message
	 * @author Shubham Kumar
	 */
	public static void debug(String message) {
		logger.info(message);
	}

	/**
	 * Logs a results info of just completed TestCase
	 * 
	 * @param result       Result of completed TestCase
	 * @param testCaseName TestCaseName of completed TestCase
	 * @author Shubham Kumar
	 */
	public static void resultInfo(ITestResult result, String testCaseName) {
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			logger.info("TestCase Passed: " + testCaseName);
			break;
		case ITestResult.SKIP:
			logger.info("TestCase Skipped: " + testCaseName);
			break;
		case ITestResult.FAILURE:
			logger.info("TestCase Failed: " + testCaseName);
			break;
		default:
			break;
		}
	}

}

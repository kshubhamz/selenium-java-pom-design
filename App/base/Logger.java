package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import lib.Log;
import utils.DriverUtils;

/**
 * Class for setting various parameters for the Test Execution to start
 * 
 * @author shubhamkumar
 * @version 2.0
 *
 */
public class Logger {
	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;
	private static ExtentTest logger;

	private Logger() {

	}

	/**
	 * Sets a browser instance and open the url in set browser
	 * 
	 * @param browserType Which browser to ne used
	 * @param url         url of the app
	 * @author shubhamkumar
	 */
	@Parameters({ "browserType", "url" })
	public static void initialize(@Optional("NA") String browserType, @Optional("NA") String url) {
		if (!url.equals("NA")) {
			Log.info("url received: " + url);
			DriverUtils.setDriver(browserType, TestBase.getProperty("INCOGNITO_MODE").equalsIgnoreCase("Yes"));
			DriverUtils.getDriver().get(url);
		}
	}

	/**
	 * Initialize html report generation
	 * 
	 * @param testDataPath
	 * @param sheetName
	 * @param browserType
	 * @author shubhamkumar
	 */
	@Parameters({ "browserType" })
	public static void startReport(String testDataPath, String sheetName, @Optional("NA") String browserType) {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			extent = new ExtentReports();
			sparkReporter = new ExtentSparkReporter(new File("./Reports/Test_RunReport " + getDate() + ".html"));
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Author", TestBase.getProperty("AUTHOR"));
			extent.setSystemInfo("Executed By", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", System.getProperty("os.name"));
			extent.setSystemInfo("Browser", browserType);
		}
	}

	/**
	 * Starts a Test Method
	 * 
	 * @param method
	 * @author shubhamkumar
	 */
	@BeforeMethod
	public void startTestMethod(Method method) {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			logger = extent.createTest(method.getName());
		}
	}

	/**
	 * Ends a Test Method
	 * 
	 * @param result
	 * @throws IOException
	 * @author shubhamkumar
	 */
	@AfterMethod
	public static void getResult(ITestResult result) throws IOException {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			String testcaseName = result.getName();
			if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS,
						MarkupHelper.createLabel("TestCase Passed: " + testcaseName, ExtentColor.GREEN));
			} else if (result.getStatus() == ITestResult.FAILURE) {
				logger.addScreenCaptureFromPath(takeScreenShot());
				logger.log(Status.FAIL, MarkupHelper.createLabel("TestCase Failed: " + testcaseName, ExtentColor.RED));
				logger.log(Status.FAIL,
						"<span style='color: red; font-weight: bold'>REASON: </span>" + result.getThrowable());
			} else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP,
						MarkupHelper.createLabel("TestCase skipped: " + testcaseName, ExtentColor.YELLOW));
			}
		}

		Log.resultInfo(result, TestBase.getTestID());
		Log.endTestCase(TestBase.getTestID());
	}

	/**
	 * Ends a Test
	 * 
	 * @author shubhamkumar
	 */
	@AfterTest
	public void endReport() {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			extent.flush();
		}
	}

	/**
	 * Ends a Test Class
	 * 
	 * @author shubhamkumar
	 */
	@AfterClass
	public void endDriver() {
		DriverUtils.getDriver().quit();
	}

	/**
	 * Logs info in html report as well as console
	 * 
	 * @param message
	 * @author shubhamkumar
	 */
	public static void info(String message) {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			logger.log(Status.INFO, message);
		}
		Log.info(message);
	}

	/**
	 * Logs bold info in html report as well as console
	 * 
	 * @param message
	 * @author shubhamkumar
	 */
	public static void boldInfo(String message) {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			logger.log(Status.INFO, "<strong>" + message + "</strong>");
		}
		Log.info(message);
	}

	/**
	 * Logs itallic info in html report as well as console
	 * 
	 * @param message
	 * @author shubhamkumar
	 */
	public static void itallicInfo(String message) {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			logger.log(Status.INFO, "em style='font-size:10px'>" + message + "</em>");
		}
		Log.info(message);
	}

	/**
	 * Attach ScreenShot in html report for a fail scenario
	 * 
	 * @throws IOException
	 * @author shubhamkumar
	 */
	public static void fail() throws IOException {
		if (TestBase.getProperty("GENERATE_HTML_REPORT").equalsIgnoreCase("Yes")) {
			logger.addScreenCaptureFromPath(takeScreenShot());
		}
	}

	/**
	 * Get current date
	 * 
	 * @return Current Date of format dd-MM-yyyy_HH-mm-ss
	 * @author shubhamkumar
	 */
	private static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		return sdf.format(new Date());
	}

	/**
	 * Takes screenshot and gets captured screenshot path
	 * 
	 * @return Path of Captured Screenshot
	 * @throws IOException
	 * @author shubhamkumar
	 */
	private static String takeScreenShot() throws IOException {
		File ssFile = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				"./Results/FailedTCScreenShots/" + getDate() + "/" + System.currentTimeMillis() + ".png");
		String dest = destinationFile.getCanonicalPath();
		FileUtils.copyFile(ssFile, new File(dest));
		return dest;
	}

}

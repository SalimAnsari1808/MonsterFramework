package com.demo.baseClass;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.demo.enums.Context;
import com.demo.managers.ExtentReportManager;
import com.demo.managers.FileReaderManager;
import com.demo.managers.WebPageDriverManager;
import com.demo.managers.WebPageMethodsManager;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.ActiveNodeUtil;
import com.demo.uility.EmailUtil;
import com.demo.uility.TestUtil;

import java.io.IOException;

public class BaseClass {
	public WebPageDriverManager webPageDriverManager;
	public WebPageObjectsManager webPageObjectsManager;
	public WebPageMethodsManager webPageMethodsManager;
	public ScenarioContext scenarioContext;
	private ExtentReports extent;
	public ActiveNodeUtil activeNodeUtil;

	// declare ThreadLocal to maintain multiple threads
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> extReport = new ThreadLocal<ExtentTest>();

	/*
	 * Declare getter and setter for web driver
	 */
	public WebDriver getDriver() {
		return threadDriver.get();
	}

	public void setDriver(WebDriver driver) {
		threadDriver.set(driver);
	}

	/*
	 * Declare getter and setter for Extent Report
	 */
	public synchronized ExtentTest getExtText() {
		return extReport.get();
	}

	public synchronized void setExtTest(ExtentTest et) {
		extReport.set(et);
	}

	public synchronized void openBrowser(String platform) {
		activeNodeUtil = new ActiveNodeUtil("localhost", 4444);

		// Create Instance of WebDriver Manager
		webPageDriverManager = new WebPageDriverManager(platform);

		// Get Driver instance from WebDriver manager Class
		setDriver(webPageDriverManager.getDriver());

		WebDriverRunner.setWebDriver(getDriver());

		// initialize page objects
		webPageObjectsManager = new WebPageObjectsManager();

		// initialize page methods
		webPageMethodsManager = new WebPageMethodsManager(webPageObjectsManager, scenarioContext);

		if (platform.equalsIgnoreCase("NA")) {
			// set browser under test
			scenarioContext.setContext(Context.BROWSER_UNDER_TEST,
					FileReaderManager.getInstance().getConfigFileReader().getBrowserUnderTest(platform));
		} else {
			// set browser under test
			scenarioContext.setContext(Context.BROWSER_UNDER_TEST, platform);

			// get node machine name
			// ValidationUtil.validateTestStep("*********** Test Case is running on " +
			// activeNodeDeterminer.getNodeInfoForSession(((RemoteWebDriver)getDriver()).getSessionId())
			// + " ***********", true);
		}
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@BeforeSuite(alwaysRun = true)
	public synchronized void suiteSetup(ITestContext context) {
		String suiteName = null;
		// get the suite name from xml file
		suiteName = context.getCurrentXmlTest().getSuite().getName();
		System.out.println("This is the start of Suite " + suiteName);
		extent = ExtentReportManager.getInstance();
		// System.out.println(TestUtil.getLatestReportFile().getName());
		// AppiumServer.appiumServer();
	}

	@BeforeMethod(alwaysRun = true)
	public synchronized void setup(ITestResult result, ITestContext context) {
		System.out.println("Start of Before Method");
		// get the suite name from xml file
		String suiteName = context.getCurrentXmlTest().getSuite().getName();

		extent = ExtentReportManager.getInstance();
		setExtTest(extent.createTest(result.getMethod().getMethodName()));
		getExtText().assignCategory(suiteName);

		// create global variable hashmap
		scenarioContext = new ScenarioContext();

	}

	@AfterMethod(alwaysRun = true)
	public synchronized void tearDown(ITestResult result, ITestContext context) {
		// declare variable used in method
		String suiteName = null;
		System.out.println("Start of After Method");
		getDriver().switchTo().defaultContent();

		if (result.getStatus() == ITestResult.SUCCESS) {
			getExtText().pass(getTestMethodName(result).toUpperCase() + " is Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			getExtText().fail(getTestMethodName(result).toUpperCase() + " is Failed");
			getExtText().fail(result.getThrowable());
			try {
				String base64Screenshot = TestUtil.getBase64Screenshot(getDriver());
				MediaEntityModelProvider mediaModel = MediaEntityBuilder
						.createScreenCaptureFromBase64String(base64Screenshot).build();
				getExtText().fail(" Failed ScreenShot", mediaModel);
			} catch (IOException ex) {

			}

			// get the suite name from xml file
			suiteName = context.getCurrentXmlTest().getSuite().getName();

		} else if (result.getStatus() == ITestResult.SKIP) {
			getExtText().skip(getTestMethodName(result).toUpperCase() + " is Skipped" + result.getThrowable());
			getExtText().skip(result.getThrowable());

			//ExtentReportManager.getInstance().removeTest(getExtText());
		}

		// webPageMethodsManager.getHeaderPageMethods().logOutFromApplication();
		// close current window
		getDriver().quit();
		setDriver(null);
		// threadDriver.set(null);

		//try {
		//	Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
		//	Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		//	Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe /T");
		//	Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
		//	Runtime.getRuntime().exec("taskkill /F /IM MicrosoftWebDriver.exe /T");
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
	}

	@AfterSuite(alwaysRun = true)
	public synchronized void cleanupSuite(ITestContext context) {
		// String suiteName = null;
		System.out.println("Start of After Suite");
		// get the suite name from xml file
		// suiteName = context.getCurrentXmlTest().getSuite().getName();
		extent.flush();
//		EmailUtil.sendEmailWithAttachReport(TestUtil.getLatestReportFile(),suiteName);
	}

}

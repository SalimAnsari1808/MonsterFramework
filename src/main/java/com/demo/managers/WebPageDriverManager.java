package com.demo.managers;

import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demo.enums.DriverType;
import com.demo.enums.EnvironmentType;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;


public class WebPageDriverManager {

	
	private WebDriver driver;
	private DriverType driverType;
	private EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String INTERNETEXPLORER_DRIVER_PROPERTY = "webdriver.ie.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";

	
	public WebPageDriverManager(String driverReq) {
		// Get Environment Type(e.g. Local/Remote)
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment(driverReq);
		
		//taking driver type from config file
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowserUnderTest(driverReq);
	}
	
	/**
	 * 
	 * Method is used to create WebDriver when no driver instance is present
	 * if driver instance is already available then driver instance will be returned
	 * 
	 * @author saansari
	 * @param  NA
	 * @return Webdriver
	 * @since  10-Jan-2020
	 */
	public synchronized WebDriver getDriver() {
		if (driver == null) {
			return createNewDriver();
		} else {
			return driver;
		}
	}

	/**
	 * 
	 * Method is used to create Local and Remote driver
	 * based on environment type to be used during testing
	 * 
	 * @author saansari
	 * @param  NA
	 * @return Webdriver
	 * @since  10-Jan-2020
	 */
	private synchronized WebDriver createNewDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		case BROWSERSTACK:
			driver = createBrowserStackRemoteDriver();
			break;
		}
		return driver;
	}

	/**
	 * 
	 * Method is used to create Remote driver based on
	 * Platform, Browser and Version
	 * 
	 * @author saansari
	 * @param  NA
	 * @return Webdriver
	 * @since  10-Jan-2020
	 */
	private synchronized WebDriver createRemoteDriver()  {
		
		WaitUtil.untilTimeComplete(5000);

		//taking reference
		InetAddress localhost = null;
		DesiredCapabilities capabilities = null;
		String ipAddress = null;
		String Node = null;
				
		//getting information about local host
		try {
			localhost = InetAddress.getLocalHost();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//getting IP address of the machine
		ipAddress = (localhost.getHostAddress()).trim();
			
		//creating node
		Node = "http://" + ipAddress + ":4444/wd/hub";

				 
		switch (driverType) {
		case FIREFOX:
			capabilities = DesiredCapabilities.firefox();
	        capabilities.setBrowserName(BrowserType.FIREFOX);
			capabilities.setPlatform(Platform.ANY);
			break;
		case CHROME:
			capabilities = DesiredCapabilities.chrome();
	        capabilities.setBrowserName(BrowserType.CHROME);
	        capabilities.setPlatform(Platform.ANY);

			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
			options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
			options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
			options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
			options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
			options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			break;
		case INTERNETEXPLORER:
	        capabilities = DesiredCapabilities.internetExplorer();
	        capabilities.setBrowserName(BrowserType.IE);
	        capabilities.setPlatform(Platform.WINDOWS);
	        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		break;
		case SAFARI:
			capabilities = DesiredCapabilities.safari();
			capabilities.setBrowserName("safari");
			capabilities.setPlatform(Platform.MAC);
			capabilities.setCapability("javascriptEnabled", "false");
			break;
		case EDGE:
			capabilities = DesiredCapabilities.edge();
			capabilities.setBrowserName(BrowserType.EDGE);
			capabilities.setPlatform(Platform.WIN10);
			break;
		case ANDROID:
			capabilities = DesiredCapabilities.android();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Android Emulator");
			capabilities.setCapability("automationName", "UiAutomator2");
			capabilities.setCapability("browserName", "Chrome");
		}
	
				 
		try {
			driver = new RemoteWebDriver(new URL(Node), capabilities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ValidationUtil.validateTestStep("Unable to create Remote driver",false);
		}
				 
		//Maximize window
		if(FileReaderManager.getInstance().getConfigFileReader().getWindowSize() && !driverType.toString().equalsIgnoreCase("Android")) {
			driver.manage().window().maximize();
		}
			
		//implicit wait
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
		
		//page load time
		driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance().getConfigFileReader().getPageLoadTimeOut(), TimeUnit.SECONDS);
		
	    // return created driver
		 return driver;
	}

	/**
	 * 
	 * Method is used to create Local driver based on
	 * Platform, Browser and Version
	 * 
	 * @author saansari
	 * @param  NA
	 * @return Webdriver
	 * @since  10-Jan-2020
	 */
	private synchronized WebDriver createLocalDriver()  {
		
		WaitUtil.untilTimeComplete(5000);

		//switch according to driver type
		switch (driverType) {
		case FIREFOX:
			System.setProperty(FIREFOX_DRIVER_PROPERTY,
			System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigFileReader().getBrowserDriverPath() + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case CHROME:
//				System.setProperty(CHROME_DRIVER_PROPERTY,
//						System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getBrowserDriverPath() + "chromedriver.exe");
//				Map<String, String> mobileEmulation = new HashMap<>();
//				mobileEmulation.put("deviceName", "Nexus 5");
//				ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//
//				driver = new ChromeDriver(chromeOptions);
			
			System.out.println("Opening Browser");

			System.setProperty(CHROME_DRIVER_PROPERTY,
			System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigFileReader().getBrowserDriverPath() + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			System.setProperty(INTERNETEXPLORER_DRIVER_PROPERTY,
			System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigFileReader().getBrowserDriverPath() + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			// Do Nothing
			break;
		case EDGE:
			System.setProperty(EDGE_DRIVER_PROPERTY,
					System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigFileReader().getBrowserDriverPath() + "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		case ANDROID:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigFileReader().getBrowserDriverPath() + "chromedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

			driver = new ChromeDriver(chromeOptions);
			break;
		default:
			break;

		}

		// Maximize window
		if (FileReaderManager.getInstance().getConfigFileReader().getWindowSize()) {
			driver.manage().window().maximize();
		}
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
		
		// page load time
		driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance().getConfigFileReader().getPageLoadTimeOut(), TimeUnit.SECONDS);

		// return created driver
		return driver;
	}
	
	/**
	 * 
	 * Method is used to create Remote driver based on
	 * Platform, Browser and Version
	 * 
	 * @author saansari
	 * @param  NA
	 * @return Webdriver
	 * @since  10-Jan-2020
	 */
	private synchronized WebDriver createBrowserStackRemoteDriver()  {
		
		WaitUtil.untilTimeComplete(5000);

		
		String USERNAME = "salimansari5";
		String AUTOMATE_KEY = "yGcwgaiBaZPo3J5EfYjq";
		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
		DesiredCapabilities capabilities = null;
						 
		switch (driverType) {
		case FIREFOX:
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("os_version", "10");
			capabilities.setCapability("browser", "Firefox");
			capabilities.setCapability("browser_version", "74");
			capabilities.setCapability("name", "salimansari5's First Test");
			break;
		case CHROME:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("os_version", "10");
			capabilities.setCapability("browser", "Chrome");
			capabilities.setCapability("browser_version", "81");
			capabilities.setCapability("name", "salimansari5's First Test");

			break;
		case INTERNETEXPLORER:
	        capabilities = DesiredCapabilities.internetExplorer();
	        capabilities.setCapability("os", "Windows");
	        capabilities.setCapability("os_version", "10");
	        capabilities.setCapability("browser", "IE");
	        capabilities.setCapability("browser_version", "11");
	        capabilities.setCapability("name", "salimansari5's First Test");
		break;
		case SAFARI:
			capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("os", "OS X");
			capabilities.setCapability("os_version", "Catalina");
			capabilities.setCapability("browser", "Safari");
			capabilities.setCapability("browser_version", "13");
			capabilities.setCapability("name", "salimansari5's First Test");
			break;
		case EDGE:
			capabilities = DesiredCapabilities.edge();
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("os_version", "10");
			capabilities.setCapability("browser", "Edge");
			capabilities.setCapability("browser_version", "81");
			capabilities.setCapability("name", "salimansari5's First Test");
			break;
		case ANDROID:
			capabilities = DesiredCapabilities.android();
			capabilities.setCapability("browserName", "android");
			capabilities.setCapability("device", "Pixel 4 XL");
			capabilities.setCapability("realMobile", "true");
			capabilities.setCapability("os_version", "10.0");
			capabilities.setCapability("name", "salimansari5's First Test");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(URL), capabilities);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//Maximize window
		if(FileReaderManager.getInstance().getConfigFileReader().getWindowSize() && !driverType.toString().equalsIgnoreCase("Android")) {
			driver.manage().window().maximize();
		}
			
		//implicit wait
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
		
		//page load time
		driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance().getConfigFileReader().getPageLoadTimeOut(), TimeUnit.SECONDS);
		
	    // return created driver
		 return driver;
	}
}

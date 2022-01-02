package com.demo.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.demo.enums.DriverType;
import com.demo.enums.EnvironmentType;
import com.demo.enums.MobileType;

/**
* The HelloWorld program implements an application that
* simply displays "Hello World!" to the standard output.
*
*/
public class ConfigFileReader {
	
	private Properties properties;
	private final String configFilePath = "/src/main/resources/configs/Configuation.properties";
	
	//declare variable used in class
	String applicationURL = null;
	
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + configFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + configFilePath);
		}	
	}
	
	/**
	* 
	*
	* @author  
	* @param 1.0
	* @return
	* @since   2014-03-31 
	*/
	public String getApplicationURL() {
		applicationURL = properties.getProperty("url");
		if(applicationURL != null) {
			return applicationURL;
		}else {
			throw new RuntimeException("url not specified in the Configuration.properties file");
		}
	}
	
	public DriverType getBrowserUnderTest(String browserParallel) {
		String browserUnderTest;
		if(browserParallel.equalsIgnoreCase("NA")) {
			browserUnderTest = properties.getProperty("browserUnderTest").toLowerCase();
		}else {
			browserUnderTest = browserParallel.toLowerCase();
		}

		if(browserUnderTest == null || browserUnderTest.contains("internetexplorer")) {
			return DriverType.INTERNETEXPLORER;
		}else if(browserUnderTest.contains("chrome")) {
			return DriverType.CHROME;
		}else if(browserUnderTest.contains("firefox")) {
			return DriverType.FIREFOX;
		}else if(browserUnderTest.contains("safari")) {
			return DriverType.SAFARI;
		}else if (browserUnderTest.contains("edge")){
			return DriverType.EDGE;
		}else if(browserUnderTest.contains("android")){
			return DriverType.ANDROID;
		}else if(browserUnderTest.equalsIgnoreCase("Ios")){
			return DriverType.IOS;
		}
		else {
			throw new RuntimeException("Browser under test is not specified in the Configuration.properties file");
		}
	}
	
	public DriverType getMobileDriver(String requiredDriver){
		if(requiredDriver.toLowerCase().contains("iphone")){
			//store andriod driver
			return DriverType.IOS;
		}else if(!requiredDriver.toLowerCase().equalsIgnoreCase("na")){
			//create ios driver
			return DriverType.ANDROID;
		}else if(requiredDriver.toLowerCase().equalsIgnoreCase("na")){
			//get value from config file
			if(properties.getProperty("mobile").equalsIgnoreCase("iphone")){
				return DriverType.IOS;
			}else {
				return DriverType.ANDROID;
			}
		}

		//throw new RuntimeException("Browser under test is not specified in the Configuration.properties file");
		return null;
	}


	public MobileType getMobileUnderTest(String mobileType){
		switch(mobileType.toLowerCase()){
			case "iphone7":
				return MobileType.iPhone7;
			case "iphone7plus":
				return MobileType.iPhone7Plus;
			case "iphone8":
				return MobileType.iPhone8;
			case "iphone8plus":
				return MobileType.iPhone8Plus;
			case "iphonex":
				return MobileType.iPhoneX;
			case "iphonexr":
				return MobileType.iPhoneXR;
			case "iphonexsmax":
				return MobileType.iPhoneXSMax;
			case "galaxys8":
				return MobileType.GalaxyS8;
			case "galaxys8plus":
				return MobileType.GalaxyS8Plus;
			case "galaxys9":
				return MobileType.GalaxyS9;
			case "galaxys9plus":
				return MobileType.GalaxyS9Plus;
			case "galaxys10":
				return MobileType.GalaxyS10;
			case "galaxys10plus":
				return MobileType.GalaxyS10Plus;
			case "galaxynote8":
				return MobileType.GalaxyNote8;
			case "galaxynote9":
				return MobileType.GalaxyNote9;
			case "na":
				//check mobile type from config file
				switch(properties.getProperty("mobile").toLowerCase()){
					case "iphone7":
						return MobileType.iPhone7;
					case "iphone7plus":
						return MobileType.iPhone7Plus;
					case "iphone8":
						return MobileType.iPhone8;
					case "iphone8plus":
						return MobileType.iPhone8Plus;
					case "iphonex":
						return MobileType.iPhoneX;
					case "iphonexr":
						return MobileType.iPhoneXR;
					case "iphonexsmax":
						return MobileType.iPhoneXSMax;
					case "galaxys8":
						return MobileType.GalaxyS8;
					case "galaxys8plus":
						return MobileType.GalaxyS8Plus;
					case "galaxys9":
						return MobileType.GalaxyS9;
					case "galaxys9plus":
						return MobileType.GalaxyS9Plus;
					case "galaxys10":
						return MobileType.GalaxyS10;
					case "galaxys10plus":
						return MobileType.GalaxyS10Plus;
					case "galaxynote8":
						return MobileType.GalaxyNote8;
					case "galaxynote9":
						return MobileType.GalaxyNote9;
				}
		}
		return null;
	}
	
	public Long getImplicitWait() {
		String implicitWait = properties.getProperty("implicitWait");
		if(implicitWait != null) {
			try {
				return Long.parseLong(implicitWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitWait + " in to Long");
			}
		}else {
			throw new RuntimeException("Implicit Wait is not specified in the Configuration.properties file");
		}
	}
	
	public Long getExplicitWait() {
		String explicitWait = properties.getProperty("explicitWait");
		if(explicitWait != null) {
			try {
				return Long.parseLong(explicitWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + explicitWait + " in to Long");
			}
		}else {
			throw new RuntimeException("Explicit Wait is not specified in the Configuration.properties file");
		}
	}
	
	public Long getPageLoadTimeOut() {
		String pageLoadTimeOut = properties.getProperty("pageLoadTimeOut");
		if(pageLoadTimeOut != null) {
			try {
				return Long.parseLong(pageLoadTimeOut);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + pageLoadTimeOut + " in to Long");
			}
		}else {
			throw new RuntimeException("Page Load TimeOut is not specified in the Configuration.properties file");
		}
	}
	
	public EnvironmentType getEnvironment(String browserParallel) {
		String environmentType = properties.getProperty("environment");
		//|| environmentType.equalsIgnoreCase("local")
		//environmentType.equalsIgnoreCase("remote") ||
		if(environmentType == null || browserParallel.equalsIgnoreCase("NA")) {
			return EnvironmentType.LOCAL;
		}
		else if(browserParallel.startsWith("BS")) {
			return EnvironmentType.BROWSERSTACK;
		}
		else if(!browserParallel.equalsIgnoreCase("NA")) {
			return EnvironmentType.REMOTE;
		}else {
			throw new RuntimeException("Environment Type is not specified in the Configuration.properties file");
		}
	}
	
	public Boolean getWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) {
			return Boolean.valueOf(windowSize);
		}else {
			return true;
		}
	}
	
	public String getReportExtentPath() {
		String reportExtentPath = properties.getProperty("reportExtentPath");
		if(reportExtentPath != null) {
			return reportExtentPath;
		}else {
			throw new RuntimeException("Extent Report xml file path is not specified in the Configuration.properties file");
		}
	}

    public String getBrowserDriverPath() {
        String browserDriverPath = properties.getProperty("browserDriverPath");
        if(browserDriverPath != null) {
            return browserDriverPath;
        }else {
            throw new RuntimeException("Browser Drivers Path is not specified in the Configuration.properties file");
        }
    }
	
	public String getExcelDataPath() {
		String reportExcelDataPath = properties.getProperty("excelDataPath");
		if(reportExcelDataPath != null) {
			return reportExcelDataPath;
		}else {
			throw new RuntimeException("Base Line Report xls file path is not specified in the Configuration.properties file");
		}
	}

	public String getTestDataResourcePath(){
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) {
			return testDataResourcePath;
		}else {
			throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
		}
	}
	
    public String getMobileNativeApplicationPath() {
        String mobileApplicationPath = properties.getProperty("mobileNativeApplicationPath");
        if(mobileApplicationPath != null) {
            return mobileApplicationPath;
        }else {
            throw new RuntimeException("Mobile Application Path is not specified in the Configuration.properties file");
        }
    }
    
    public int getRetryCount() {
		String retryCounter = properties.getProperty("retryCount");
		if(retryCounter != null) {
			return Integer.parseInt(retryCounter);
		}else {
			throw new RuntimeException("url not specified in the Configuration.properties file");
		}
	}
	
}

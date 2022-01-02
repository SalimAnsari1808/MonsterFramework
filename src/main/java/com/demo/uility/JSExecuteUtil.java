package com.demo.uility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class JSExecuteUtil {
private static JavascriptExecutor javaScriptExecute = null;
private static WebDriver driver = WebDriverRunner.getWebDriver();

	
	// **********************************************************************************************
	// Method : clickOnElement
	// Description: Method is used to click on element on the Web page
	// Input Arguments: 1. WebDriver  2. SelenideElement
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void clickOnElement(SelenideElement selenideElement) {
		javaScriptExecute = (JavascriptExecutor)driver;
		javaScriptExecute.executeScript("arguments[0].click();", selenideElement);
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Clicked on SelenideElement using JavaScript");
	}
	
	// **********************************************************************************************
	// Method : scrollDown
	// Description: Method is used to scroll down in the Web page
	// Input Arguments: 1. WebDriver  2. vertical height
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void scrollDown(String vertical) {
		javaScriptExecute = (JavascriptExecutor)driver;
		javaScriptExecute.executeScript("window.scrollBy(0,"+vertical+")");
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Scroll down using JavaScript");
	}

	// **********************************************************************************************
	// Method : scrollDownToElementVisible
	// Description: Method is used to scroll down in the Web page to make element visible
	// Input Arguments: 1. WebDriver  2. vertical height
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void scrollDownToElementVisible(SelenideElement element) {
		javaScriptExecute = (JavascriptExecutor)driver;

		javaScriptExecute.executeScript("arguments[0].scrollIntoView(true);", element);

		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Scroll down using JavaScript");
	}
	
	// **********************************************************************************************
	// Method : generateAlertPopup
	// Description: Method is used to generate Alert pop up with provided message of the Web page
	// Input Arguments: 1. WebDriver  2. Message
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void generateAlertPopup( String message) {
		javaScriptExecute = (JavascriptExecutor)driver;
		javaScriptExecute.executeScript("alert('"+message+"');");
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Generated Alert message with value " + message+ " using JavaScript");
	}
	
	// **********************************************************************************************
	// Method : refreshBrowser
	// Description: Method is used to refresh the web page
	// Input Arguments: 1. WebDriver
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void refreshBrowser() {
		javaScriptExecute = (JavascriptExecutor)driver;
		javaScriptExecute.executeScript("history.go(0)");
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Refresh Browser using JavaScript");
	}
	
	// **********************************************************************************************
	// Method : getElementInnerText
	// Description: Method is used to get all the inner element of the Web page
	// Input Arguments:1. WebDriver 
	// Return: String -> All Inner element
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getElementInnerText() {
		javaScriptExecute = (JavascriptExecutor)driver;
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Get innertext using JavaScript");
		
		return javaScriptExecute.executeScript("return document.documentElement.innerText;").toString();
	}
	
	// **********************************************************************************************
	// Method : getElementTextValue
	// Description: Method is used to get all the inner element of the Web page
	// Input Arguments:1. WebDriver 
	// Return: String -> All Inner element
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getElementTextValue( SelenideElement selenideElement) {
		javaScriptExecute = (JavascriptExecutor)driver;
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Getting element innertext using JavaScript");
		return javaScriptExecute.executeScript("return arguments[0].value", selenideElement).toString();
	}
	
	// **********************************************************************************************
	// Method : getWebPageDomain
	// Description: Method is used to get Web page Domain
	// Input Arguments:1. WebDriver 
	// Return: String -> Domain
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getWebPageDomain() {
		javaScriptExecute = (JavascriptExecutor)driver;
		return javaScriptExecute.executeScript("return document.domain;").toString();
	}
	
	// **********************************************************************************************
	// Method : getWebPageTitle
	// Description: Method is used to get Web page Title
	// Input Arguments:1. WebDriver 
	// Return: String -> Title
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getWebPageTitle() {
		javaScriptExecute = (JavascriptExecutor)driver;
		return javaScriptExecute.executeScript("return document.title;").toString();
	}
	
	// **********************************************************************************************
	// Method : getWebPageURL
	// Description: Method is used to get Web page URL
	// Input Arguments:1. WebDriver 
	// Return: String -> URL
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getWebPageURL() {
		javaScriptExecute = (JavascriptExecutor)driver;
		return javaScriptExecute.executeScript("return document.URL;").toString();
	}
	
	// **********************************************************************************************
	// Method : highlightElement
	// Description: Method is used to highlight web element
	// Input Arguments:1. WebDriver  2. SelenideElement
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void highlightElement( SelenideElement selenideElement) {
		javaScriptExecute = (JavascriptExecutor)driver;
		javaScriptExecute.executeScript("arguments[0].style.border='3px dotted blue'", selenideElement);
	}
	
	// **********************************************************************************************
	// Method : getBackGroundColor
	// Description: Method is used to get background color of webelement
	// Input Arguments:1. WebDriver  2. SelenideElement
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getElementBackGroundColor( SelenideElement selenideElement) {
		javaScriptExecute = (JavascriptExecutor)driver;
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Getting weblement back ground colour using JavaScript");
		return javaScriptExecute.executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color');",selenideElement).toString();
	}
	
	// **********************************************************************************************
	// Method : sendKeys
	// Description: Method is used to enter the value in the text box
	// Input Arguments:1. WebDriver  2. SelenideElement 3. text
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static void sendKeys( SelenideElement selenideElement,String text) {
		javaScriptExecute = (JavascriptExecutor)driver;
		javaScriptExecute.executeScript("arguments[0].value='"+text+"';", selenideElement);
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Sending value "+ text +  " using JavaScript");
	}
	
	// **********************************************************************************************
	// Method : getElementAfterProperty
	// Description: Method is used to get After property of SelenideElement
	// Input Arguments:1. WebDriver  2. SelenideElement 3. attributeValue
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getElementAfterProperty( SelenideElement selenideElement,String attributeValue) {
		javaScriptExecute = (JavascriptExecutor)driver;
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Getting webelement back ground color using JavaScript");
		return javaScriptExecute.executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('"+attributeValue+"');",selenideElement).toString();
	}

	public static void openNewTabWithGivenURL( String navigateURL){
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.open('"+navigateURL+"', '_blank');");
	}
	
	// **********************************************************************************************
	// Method : getElementBeforeProperty
	// Description: Method is used to get Before property of SelenideElement
	// Input Arguments:1. WebDriver  2. SelenideElement 3. attributeValue
	// Return: NA
	// Created By : Salim Ansari
	// Created On : 13-Jan-2020
	// Reviewed By:
	// Reviewed On:
	// **********************************************************************************************
	public static String getElementBeforeProperty( SelenideElement selenideElement,String attributeValue) {
		javaScriptExecute = (JavascriptExecutor)driver;
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Getting weblement back ground colour using JavaScript");
		return javaScriptExecute.executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('"+attributeValue+"');",selenideElement).toString();
	}
}
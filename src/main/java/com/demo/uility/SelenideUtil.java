package com.demo.uility;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demo.managers.FileReaderManager;


public class SelenideUtil {
	
	public static synchronized SelenideElement getSelenideElement(String locatorValue) {
		
		if(locatorValue.startsWith("//")) {
			return  $x(locatorValue).waitUntil(Condition.visible, FileReaderManager.getInstance().getConfigFileReader().getImplicitWait());
			//element =  $x(locatorValue);
		}
		return null;
	}
	
	public static synchronized ElementsCollection getSelenideElementsCollection(String locatorValue) {
		ElementsCollection elements = null;
		
		try {
			if(locatorValue.startsWith("//")) {
				$x(locatorValue).waitUntil(Condition.visible, FileReaderManager.getInstance().getConfigFileReader().getImplicitWait());
				elements = $$x(locatorValue);
				return elements;
			}
		}catch (Exception e) {
			// Do Nothing
		}

		return elements;
	}
	
	public static synchronized void setValue(String locatorValue, String sendText, String pageName) {
		
		SelenideUtil.getSelenideElement(locatorValue).setValue(sendText);
		
		ValidationUtil.validateTestStep("Set Value " + sendText + " on Locator " + locatorValue + " on " +  pageName, true);
		
	}
	
	public static synchronized void click(String locatorValue, String pageName) {
		
		SelenideUtil.getSelenideElement(locatorValue).scrollTo().click();
		
		ValidationUtil.validateTestStep("Click on Locator "  + locatorValue + " on " + pageName, true);
	}
	
	public static synchronized void click(String locatorValueList, String indexValue, String pageName) {
		if(indexValue.equalsIgnoreCase("0")) {
			click(locatorValueList, pageName);
		}else {
			click("("+locatorValueList+")["+indexValue+"]",pageName);
		}
	}
	
	public static synchronized void jsClick(String locatorValue, String pageName) {
		
		JSExecuteUtil.clickOnElement(SelenideUtil.getSelenideElement(locatorValue));
		
		ValidationUtil.validateTestStep("Click on Locator "  + locatorValue + " on " + pageName, true);
	}
	
	public static synchronized void jsClick(String locatorValueList, String indexValue, String pageName) {
		if(indexValue.equalsIgnoreCase("0")) {
			jsClick(locatorValueList, pageName);
		}else {
			jsClick("("+locatorValueList+")["+indexValue+"]",pageName);
		}
	}
	
	
	
	public static synchronized boolean checkElementVisible(String locatorValue) {
		boolean statusFlag = false;
		try {
			//statusFlag = getSelenideElement(locatorValue).is(Condition.visible);
			SelenideElement element = $x(locatorValue);
			statusFlag = element.is(Condition.visible);
		}catch (Exception e) {
			
		}
		return statusFlag;	
	}
	
	public static synchronized boolean checkElementExist(String locatorValue) {
		boolean statusFlag = false;
		try {
			statusFlag = $x(locatorValue).is(Condition.exist);
		}catch (Exception e) {
			
		}
		return statusFlag;	
	}
	
	public static synchronized boolean checkCollectionElementTextVisible(String locatorValue, String searchValue) {
		
		return SelenideUtil.getSelenideElementsCollection(locatorValue).findBy(text(searchValue)).is(Condition.visible);
	}
	
	public static synchronized void selectTextFromList(String locatorValue, String selectedValue, String pageName) {
		
		SelenideUtil.getSelenideElementsCollection(locatorValue).findBy(text(selectedValue)).click();
		
		/*
		 * for(SelenideElement listValue :
		 * SelenideUtil.getSelenideElementsCollection(locatorValue)) {
		 * if(listValue.getText().equalsIgnoreCase(selectedValue)) { listValue.click();
		 * 
		 * break; } }
		 */
		
		ValidationUtil.validateTestStep("Click on value " + selectedValue + " from Locator list " + locatorValue + " on " + pageName, true);
	}
	
	public static synchronized int getTextIndexFromList(String locatorValue, String selectedValue) {
			
		for(int count = 0;count<SelenideUtil.getSelenideElementsCollection(locatorValue).size();count++) {
			if(SelenideUtil.getSelenideElementsCollection(locatorValue).get(count).getText().contains(selectedValue)) { 
				return count;
			 
			  } 
		  }
		return 0;
	}
	
	public static synchronized String getText(String locatorValue, String pageName) {
		String elementText = getSelenideElement(locatorValue).text().trim();
		
		ValidationUtil.validateTestStep("Geting "+elementText+" Text on Locator "  + locatorValue + " on " + pageName, true);
		return elementText;
	}
	
	public static synchronized void clearTextBoxUsingSendKeys(String locatorValue,String pageName) {
		
		SelenideElement element = getSelenideElement(locatorValue);

    	//click on webelement
		element.click();
    	
    	//select all the box text
		element.sendKeys(Keys.CONTROL + "a");
    	
    	//delete box text
		element.sendKeys(Keys.DELETE);

		//clear with selenium API
		element.clear();

		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "clear text of webelement using sendkeys for " + webElement);
		ValidationUtil.validateTestStep("Clear text present from Locator "  + locatorValue + " on " + pageName, true);
    }
	
	public static synchronized String getAttributeValue(String locatorValue,String attributeName,String pageName) {
		
		ValidationUtil.validateTestStep("Getting Attribute "+attributeName+" Value present from Locator "  + locatorValue + " on " + pageName, true);
		
		return getSelenideElement(locatorValue).attr(attributeName);
	}
	
	public static synchronized boolean hasAtrributePresent(String locatorValue,String attributeName,String pageName) {
		
		boolean statusFlag = false;
		try {
			if(getAttributeValue(locatorValue, attributeName, pageName)!=null) {
				statusFlag = true;
			}
		}catch (Exception e) {
			// Do Nothing
		}
		
		ValidationUtil.validateTestStep("Checking Attribute "+attributeName+" is present from Locator "  + locatorValue + " on " + pageName, true);
		
		return statusFlag;
	}
	
}

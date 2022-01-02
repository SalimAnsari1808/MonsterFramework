package com.demo.webPageMethods;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.demo.baseClass.ScenarioContext;
import com.demo.managers.FileReaderManager;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.JSExecuteUtil;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;
import com.demo.webPageObjects.GooglePage;

public class GooglePageMethods {
	//private ScenarioContext   scenarioContext;
	private GooglePage  googlePage;
	
	public GooglePageMethods(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		googlePage    = webPageObjectsManager.getGooglePageObject();
		//this.scenarioContext = scenarioContext;
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	public synchronized void launchApplication() {
		
		open(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
		
		ValidationUtil.validateTestStep(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL()
				+" Application is launch Secessfull", true);
	}
	
	public synchronized void searchShreepartners() {
		
		//search shreepartners
        WebDriverRunner.getWebDriver().findElement(By.xpath(googlePage.xpath_SearchTextBox)).sendKeys("shreepartners"+ Keys.ENTER);
        
        //wait for 5 second
        WaitUtil.untilTimeComplete(5000);
				
	}
	
	public synchronized void clickOnShreepartnersLink() {
		
		//scroll down 500 px
        JSExecuteUtil.scrollDown("400");

        WebElement element =  WebDriverRunner.getWebDriver().findElement(By.xpath("//*[text()='Shree Partners | IT Services | Consulting | Digital Solutions']"));
                
        //click on shreepartners
        element.click();

        //wait for 5 second
        WaitUtil.untilTimeComplete(5000);
				
	}
	
	public synchronized void clickOnShreepartnersLinkOnWeb() {
		
        WebElement element =  WebDriverRunner.getWebDriver().findElement(By.xpath("//*[text()='Shree Partners | IT Services | Consulting | Digital Solutions']"));
        
        //click on shreepartners
        element.click();

        //wait for 5 second
        WaitUtil.untilTimeComplete(5000);
				
	}
	
}

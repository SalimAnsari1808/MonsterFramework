package com.demo.webPageMethods;

import static com.codeborne.selenide.Selenide.*;

import com.demo.baseClass.ScenarioContext;
import com.demo.dataType.LoginCredentialsData;
import com.demo.managers.FileReaderManager;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.SelenideUtil;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;
import com.demo.webPageObjects.HeaderPageObjects;
import com.demo.webPageObjects.LoginPageObjects;

public class LoginPageMethods {
	//private ScenarioContext   scenarioContext;
	private LoginPageObjects  loginPageObjects;
	private HeaderPageObjects headerPageObjects;
	
	public LoginPageMethods(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		loginPageObjects    = webPageObjectsManager.getLoginPageObjects();
		headerPageObjects	= webPageObjectsManager.getHeaderPageObjects();
		//this.scenarioContext = scenarioContext;
	}

	/*
	 * 
	 * 
	 * 
	 */
	public synchronized void loginToApplication(String loginRoles) {
		//get the login credential 
		LoginCredentialsData loginCredentialsData = FileReaderManager.getInstance().getJsonDataReader().getCredentialsByUserType(loginRoles);

		//enter username value
		SelenideUtil.setValue(loginPageObjects.xpth_UserNameTextBox, loginCredentialsData.userName, "Login Page");
		
		//enter password value
		SelenideUtil.setValue(loginPageObjects.xpth_PasswordTextBox, loginCredentialsData.password, "Login Page");
		//loginPageObjects.getPasswordTextBox().setValue(loginCredentialsData.password);
		
		//click on login button
		SelenideUtil.click(loginPageObjects.xpth_LoginButton, "Login Page");
		
		WaitUtil.untilTimeComplete(2000);
		
		//check login to application is done
		if(SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuIconLink)) {
			//validate Login to Application is done for Desktop
			ValidationUtil.validateTestStep("Login to Application is sucessfull on Login Page", SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuIconLink));
		}else {
			//validate Login to Application is done for mobile
			ValidationUtil.validateTestStep("Login to Application is sucessfull on Login Page", SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuLogOutButton));
		}
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	public synchronized void quickLoginToApplication() {
		//click on quick Login
		SelenideUtil.click(loginPageObjects.xpth_QuickLoginButton, "Login Page");
		
		//check login to application is done
		if(SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuIconLink)) {
			//validate Login to Application is done for Desktop
			ValidationUtil.validateTestStep("Quick Login to Application is sucessfull on Login Page", SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuIconLink));
		}else {
			//validate Login to Application is done for mobile
			ValidationUtil.validateTestStep("Quick Login to Application is sucessfull on Login Page", SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuLogOutButton));
		}	
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	public synchronized void launchApplicationUnderTest() {
		
		open(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
		
		ValidationUtil.validateTestStep(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL()
				+" Application is launch Secessfull", true);
	}
	
	public synchronized void selectOffice(String officeName) {
		
		SelenideUtil.click(loginPageObjects.xpth_ChooseOfficePopUpOfficeText, "Login Page");
		
		if(officeName.equalsIgnoreCase("NA")) {
			SelenideUtil.click(loginPageObjects.xpth_ChooseOfficePopUpOfficeOptionTextList, "0", "Login Page");
		}else {
			SelenideUtil.selectTextFromList(loginPageObjects.xpth_ChooseOfficePopUpOfficeOptionTextList, officeName, "Login Page");
		}
		
		SelenideUtil.click(loginPageObjects.xpth_ChooseOfficePopUpSubmitButton, "Login Page");
	}
}

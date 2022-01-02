package com.demo.webPageMethods;



import com.demo.baseClass.ScenarioContext;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.SelenideUtil;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;
import com.demo.webPageObjects.HeaderPageObjects;

public class HeaderPageMethods {
	private HeaderPageObjects headerPageObjects;
	//private ScenarioContext   scenarioContext;
	
	public HeaderPageMethods(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		headerPageObjects    = webPageObjectsManager.getHeaderPageObjects();
		//this.scenarioContext = scenarioContext;
	}
	
	/*
	 * 
	 * 
	 */
	public synchronized void logOutFromApplication() {
		
		if(SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuIconLink)) {
			SelenideUtil.click(headerPageObjects.xpth_HeaderRightUserMenuIconLink, "Header Section On Landing Page");
		}else {
			SelenideUtil.click(headerPageObjects.xpth_HeaderLeftMenuButton, "Header Section On Landing Page");
		}
		WaitUtil.untilTimeComplete(1500);
		ValidationUtil.validateTestStep("Verify LogOut Button is visible 0n Header Section", SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderRightUserMenuLogOutButton));
		
		SelenideUtil.click(headerPageObjects.xpth_HeaderRightUserMenuLogOutButton, "Header Section");
	}
	
	/*
	 * 
	 * 
	 */
	public synchronized void searchValueHeaderSection(String listValue, String searchValue) {
		
		if(SelenideUtil.checkElementVisible(headerPageObjects.xpth_HeaderCenterSearchTextBox)) {
			
			SelenideUtil.click(headerPageObjects.xpth_HeaderCenterSearchTypeButton, "Header Section");
			
			SelenideUtil.selectTextFromList(headerPageObjects.xpth_HeaderCenterSearchTextList, listValue, "Header Section");
			
			SelenideUtil.setValue(headerPageObjects.xpth_HeaderCenterSearchTextBox, searchValue, "Header Section");
			
			SelenideUtil.click(headerPageObjects.xpth_HeaderCenterSearchButton, "Header Section");
		}else {
			//click on search button
			SelenideUtil.click(headerPageObjects.xpth_HeaderCenterSearchButton, "Header Section");
			
			WaitUtil.untilTimeComplete(1500);
			
			//open list on search popup
			SelenideUtil.click(headerPageObjects.xpth_HeaderPopupSearchTypeText, "Header Popup");
			
			WaitUtil.untilTimeComplete(1000);
			
			SelenideUtil.selectTextFromList(headerPageObjects.xpth_HeaderPopupSearchTypeTextList, listValue, "Header Popup");
			
			SelenideUtil.setValue(headerPageObjects.xpth_HeaderPopupSearchTextBox, searchValue, "Header Popup");
			
			SelenideUtil.click(headerPageObjects.xpth_HeaderPopupSearchButton, "Header Popup");
		}
	}
	
	/*
	 * 
	 * 
	 */
	public synchronized void selectValueFromHeaderLeftMenu(String selectedValue) {
		
		if(!SelenideUtil.checkCollectionElementTextVisible(headerPageObjects.xpth_HeaderLeftMenuTextList, "Group Services")) {
			SelenideUtil.click(headerPageObjects.xpth_HeaderLeftMenuButton, "Header Section");
		}
		
		if(selectedValue.contains("Reports")|| selectedValue.contains("Data")) {
			SelenideUtil.selectTextFromList(headerPageObjects.xpth_HeaderLeftMenuTextList, "Reports", "Header Left Menu List");
		}else if(selectedValue.contains("Admin")) {
			SelenideUtil.selectTextFromList(headerPageObjects.xpth_HeaderLeftMenuTextList, "Administration", "Header Left Menu List");
		}
		
		SelenideUtil.selectTextFromList(headerPageObjects.xpth_HeaderLeftMenuTextList, selectedValue, "Header Left Menu List");
	}
	
	public synchronized void selectNavigationTab(String tabName) {
		
		SelenideUtil.click("//button[@id='tabs-menu-button']", "Header Section");
		WaitUtil.untilTimeComplete(1000);
		SelenideUtil.selectTextFromList("//button[contains(@id,'tab-menu-button')]", tabName, "Header Page");
		
	}
	
	public synchronized void clickOnLeftMenuButton() {
		SelenideUtil.click(headerPageObjects.xpth_HeaderLeftMenuButton, "Header Section");
	}
}

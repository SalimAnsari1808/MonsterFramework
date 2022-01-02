package com.demo.webPageObjects;

/*
* Prefix with WebElement      PostFix with Method
	ifr     					-  IFrame
	btn       					-  Button
	chkbx     					-  CheckBox
	chklst   					-  CheckBoxList
	drpdwn   					-  DropDown
	grdvew   					-  GridView
	hyrlnk   					-  Hyperlink
	img       					-  Image
	imgbtn   					-  ImageButton
	lbl       					-  Label
	lnkbtn   					-  LinkButton
	lnk     					-  Link
	lstbx     					-  ListBox
	lit       					-  Literal
	pnl       					-  Panel
	ph       					-  PlaceHolder
	rdbtn     					-  RadioButton
	rdbtnlst 					-  RadioButtonListF
	txtbx     					-  Textbox
	txt       					-  Text
*/

public class HeaderPageObjects {
	
	
	public HeaderPageObjects() {
		
	}
	
	//Header Top Left corner Elements Locator
	public final String xpth_HeaderLeftMenuButton 				= "//mat-icon[text()='menu']";
	
	public final String xpth_HeaderLeftMenuTextList				= "//mat-sidenav//button";
	
	public final String xpth_HeaderLeftLogoImage 				= "//mat-icon[@id='logo']";
	
	//Header Center Elements Locator
	public final String xpth_HeaderCenterSearchTypeButton		= "//button[@id='search-type-trigger-button']";
	
	public final String xpth_HeaderCenterSearchTextList 		= "//div[@class='mat-menu-content']//button";
	
	public final String xpth_HeaderCenterSearchTextBox 			= "//input[@id='main-search-input']";
	
	public final String xpth_HeaderCenterSearchButton 			= "//button[contains(@id,'search-button')]";
	
	//Header Top Right corner Elements Locator 
	public final String xpth_HeaderRightMessageLink 			= "//*[contains(@id,'messages')]";
	
	public final String xpth_HeaderRightNotificationLink 		= "//*[contains(@id,'notifications')]";
	
	public final String xpth_HeaderRightUserMenuIconLink 		= "//button[contains(@id,'user-menu')]//mat-icon";
	
	public final String xpth_HeaderRightUserMenuStaffInfoText	= "//div[@class='staff-info mat-menu-item']";
	
	public final String xpth_HeaderRightUserMenuMyProfileButton	= "//button[contains(@id,'profile')]";
	
	public final String xpth_HeaderRightUserMenuLogOutButton 	= "//button[contains(@id,'logout')]";
	
	//Search PopUp
	public final String xpth_HeaderPopupSearchTypeText			= "//mat-select";
	
	public final String xpth_HeaderPopupSearchTypeTextList 		= "//mat-option";
	
	public final String xpth_HeaderPopupSearchTextBox			= "//input[@placeholder='Search Terms']";
	
	public final String xpth_HeaderPopupSearchButton			= "//span[text()=' Search ']/..";
	
	public final String xpth_HeaderPopupCancelButton			= "//span[text()=' Cancel ']/..";
	
	//BreadCrums
	public final String xpth_BreadCrumsLinks					= "//div[contains(@class,'breadcrumbs')]//a";
	
	//Summary Section Panel
	public final String xpth_SummarySectionHeader				= "//mat-expansion-panel[contains(@class,'summary-section')]//h3";
	
	public final String xpth_SummarySectionAdministerButton		= "//mat-expansion-panel[contains(@class,'summary-section')]//button[contains(@id,'administration')]";
	
	public final String xpth_SummarySectionDashBoardButton		= "//mat-expansion-panel[contains(@class,'summary-section')]//button[contains(@id,'dashboard')]";
	
	public final String xpth_SummarySectionExpensionIcon		= "//mat-expansion-panel[contains(@class,'summary-section')]//span[contains(@class,'expansion')]";
	
	
}

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

public class OfficesPageObjects {
	
	public final String xpth_HeaderText				= "//h2[text()='System Metrics']/../..//mat-cell[contains(@class,'label')]";
	
	public final String xpth_FilterTextBox			= "//input[contains(@id,'Filter')]";
	
	public final String xpth_CreateNewButton		= "//button/span[text()='Create New']";
	
	public final String xpth_TableHeaderTextList	= "//mat-header-row//mat-header-cell";
	
	public final String xpth_OfficesNameTextList	= "//mat-row//mat-cell[1]";
	
	public final String xpth_WIBTextList			= "//mat-row//mat-cell[2]";
	
	public final String xpth_CreatedDateTextList	= "//mat-row//mat-cell[3]";
	
	public final String xpth_OfficeAction3DotsList	= "//mat-row//mat-cell[5]/button";

	//Create New Office
	public final String xpth_NewOfficeProfileText				= "//h2[text()='new Office Profile']";
	
	public final String xpth_NewOfficeOfficeNameTextBox			= "//input[@placeholder='Office Name']";
	
	public final String xpth_NewOfficeAddressTextBox			= "//input[@placeholder='Address']";
	
	public final String xpth_NewOfficeAddress2TextBox			= "//input[@placeholder='Address 2']";
	
	public final String xpth_NewOfficeZipCodeTextBox			= "//input[@placeholder='ZipCode']";
	
	public final String xpth_NewOfficeCountyTextBox				= "//input[@placeholder='County']";
	
	public final String xpth_NewOfficeCityTextBox				= "//input[@placeholder='City']";
		
	public final String xpth_NewOfficeStateText					= "//mat-select[@placeholder='State']";
	
	public final String xpth_NewOfficeStateOptionTextList		= "//mat-option";
	
	public final String xpth_NewOfficeContactEmailTextBox		= "//input[@placeholder='Contact Email']";
	
	public final String xpth_NewOfficeCityCodeTextBox			= "//input[@placeholder='Cty Cd']";
	
	public final String xpth_NewOfficeContactPhoneTextBox		= "//input[@placeholder='Contact Phone']";
	
	public final String xpth_NewOfficeContactExtTextBox			= "//input[@placeholder='Ext']";
	
	public final String xpth_NewOfficePhysicalLocationTextBox	= "//input[@placeholder='Physical Location Code']";
	
	public final String xpth_NewOfficeWIBSText					= "//mat-select[@aria-label='WIB']";
	
	public final String xpth_NewOfficeWIBSOptionTextList		= "//mat-option";
	
	public final String xpth_NewOfficeStartDateTextBox			= "//lx2-datepicker[@placeholder='Start Date']//input";
	
	public final String xpth_NewOfficeEndDateTextBox			= "//lx2-datepicker[@placeholder='End Date']//input";
	
	public final String xpth_NewOfficeOpenigTimeHoursTextBox	= "//lx2-timepicker[@name='openingTime']//input[@formcontrolname='hours']";
	
	public final String xpth_NewOfficeOpenigTimeMinutesTextBox	= "//lx2-timepicker[@name='openingTime']//input[@formcontrolname='minutes']";
	
	public final String xpth_NewOfficeOpenigTimeMeridianTextBox	= "//lx2-timepicker[@name='openingTime']//input[@formcontrolname='meridian']";
	
	public final String xpth_NewOfficeClosingTimeHoursTextBox	= "//lx2-timepicker[@name='closingTime']//input[@formcontrolname='hours']";
	
	public final String xpth_NewOfficeClosingTimeMinutesTextBox	= "//lx2-timepicker[@name='closingTime']//input[@formcontrolname='minutes']";
	
	public final String xpth_NewOfficeClosingTimeMeridianTextBox= "//lx2-timepicker[@name='closingTime']//input[@formcontrolname='meridian']";
	
	public final String xpth_NewOfficeSubmitButton				= "//mat-card//button[@type='submit']";
	
	public final String xpth_NewOfficeBackButton				= "//span[text()='Back']/..";
	
}

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

public class SystemInformationPageObjects {
	
	
	//System Metrices
	public final String xpth_SystemMetricesHeaderText						= "//h2[text()='System Metrics']";
	
	public final String xpth_SystemMetricesInformationLabelList				= "//h2[text()='System Metrics']/../..//mat-cell[contains(@class,'label')]";
	
	public final String xpth_SystemMetricesInformationValueTextList			= "//h2[text()='System Metrics']/../..//mat-cell[contains(@class,'value')]";
		
	//System Configuration
	public final String xpth_SystemConfigurationHeaderText					= "//h2[text()='System Configuration']";
	
	public final String xpth_SystemConfigurationInformationLabelList		= "//h2[text()='System Configuration']/../..//mat-cell[contains(@class,'label')]/div";
	
	public final String xpth_SystemConfigurationInformationValueTextList	= "//h2[text()='System Configuration']/../..//mat-cell[contains(@class,'value')]";
	
	public final String xpth_SystemConfigurationInformationEditButtonList	= "//h2[text()='System Configuration']/../..//mat-icon";
	
	//Service count for last year chart
	public final String xpth_ServiceCountChartHeaderText					= "//mat-expansion-panel//span/h3";
	
	public final String xpth_ServiceCountChartExpensionIcon					= "//h3[contains(text(),'Service counts')]/../../span[contains(@class,'expansion')]";
	
	public final String xpth_ServiceCountChartExpensionImage				= "//h3[contains(text(),'Service counts')]/../../..//canvas";
	
}

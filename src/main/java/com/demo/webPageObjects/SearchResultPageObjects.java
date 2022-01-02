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

public class SearchResultPageObjects {
	

	public final String xpth_FilterTextBox						= "//input[contains(@placeholder,'Filter')]";
	
	public final String xpth_TableHeaderTextList				= "//mat-header-cell";
	
	//Employer Search
	public final String xpth_EmployerSearchEmployerNameList		= "//mat-row/mat-cell[1]";
	
	public final String xpth_EmployerSearchEmployerFEINList		= "//mat-row/mat-cell[2]";
	
	public final String xpth_EmployerSearchOtherStateIDList		= "//mat-row/mat-cell[3]";
	
	public final String xpth_EmployerSearchStreetAddressList	= "//mat-row/mat-cell[4]";
	
	public final String xpth_EmployerSearchCityList				= "//mat-row/mat-cell[5]";
	
	public final String xpth_EmployerSearchStateList			= "//mat-row/mat-cell[6]";
	
	public final String xpth_EmployerSearchZipList				= "//mat-row/mat-cell[7]";
	
	public final String xpth_EmployerSearchQWECLocationList		= "//mat-row/mat-cell[8]";
	
	public final String xpth_EmployerSearchAction3DotList		= "//mat-row/mat-cell[9]/button";
	
	public final String xpth_EmployerSearchActionOptionList		= "//div[@role='menu']//a/span";
	
}
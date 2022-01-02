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

public class ServicesRenderedPageObjects {
	
	public ServicesRenderedPageObjects() {
		
	}

	public final String xpth_ServicesRenderText			= "//h2[text()='Services Rendered']";
	
	public final String xpth_StartDateTextBox			= "//input[@placeholder='Start Date']";
	
	public final String xpth_EndDateTextBox				= "//input[@placeholder='End Date']";
	
	public final String xpth_FilterTextBox				= "//input[contains(@placeholder,'Filter')]";
	
	public final String xpth_RecordServiceButton		= "//span[contains(text(),'Record Service')]/..";
	
	public final String xpth_TabelHeaderTextList		= "//mat-header-cell";
	
	public final String xpth_ServiceNameTextList		= "//mat-row/mat-cell[1]";
	
	public final String xpth_LocationTextList			= "//mat-row/mat-cell[2]";
	
	public final String xpth_RecuriterNameTextList		= "//mat-row/mat-cell[3]";
	
	public final String xpth_EntryDateTextList			= "//mat-row/mat-cell[4]";
	
	public final String xpth_ActualDateTextList			= "//mat-row/mat-cell[5]";
	
	public final String xpth_Action3DotList				= "//mat-row/mat-cell[6]//button";
	
	public final String xpth_ActionOptionViewButton		= "//div[@role='menu']//a";
	
	
	//View Service Rendered
	public final String xpth_ViewRecordServicesEditServiceButton	= "//span[contains(text(),'Edit Service')]/..";
	
	public final String xpth_ViewRecordServicesBackButton			= "//span[contains(text(),'Back')]/..";
	
	
	//Edit Record Service
	public final String xpth_EditRecordServicesHeaderText			= "//h2[contains(text(),'Edit record')]";
	
	public final String xpth_EditRecordServicesSaveButton			= "//span[contains(text(),'Save')]/..";
	
	public final String xpth_EditRecordServicesCancelButton			= "//span[contains(text(),'Cancel')]/..";
	
	public final String xpth_EditRecordServicesVoidServiceButton	= "//span[contains(text(),'Void Service')]/..";
	
	
	//Please Confirm Dialog Box
	public final String xpth_PleaseConfirmDialogBoxHeaderText		= "//h1";
	
	public final String xpth_PleaseConfirmDialogBoxYesButton		= "//span[contains(text(),'Yes')]/..";
	
	public final String xpth_PleaseConfirmDialogBoxNoButton			= "//mat-dialog-container//span[contains(text(),'No')]/..";
	
}

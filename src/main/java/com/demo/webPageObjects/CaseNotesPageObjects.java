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

public class CaseNotesPageObjects {

	public CaseNotesPageObjects() {
		
	}
	
	public final String xpth_CaseNotesHeaderText		= "//h2";
	
	public final String xpth_CreateNewButton			= "//span[text()='Create New']/..";
	
	public final String xpth_FilterTextBox				= "//input[contains(@placeholder,'Filter')]";
	
	public final String xpth_TableHeaderTextList		= "//mat-header-cell";
	
	public final String xpth_CreatedByValueTextList		= "//mat-row/mat-cell[1]";
	
	public final String xpth_NoteDateValueTextList		= "//mat-row/mat-cell[2]";
	
	public final String xpth_CaseNoteTitleValueTextList	= "//mat-row/mat-cell[3]";
	
	public final String xpth_ServiceNameValueTextList	= "//mat-row/mat-cell[4]";

	public final String xpth_ActionViewButtonList		= "//mat-row/mat-cell[5]//mat-icon";
	
	
	//New Case Note Form
	public final String xpth_NewCaseNotesDateTextBox				= "//mat-datepicker/../input";
	
	public final String xpth_NewCaseNotesCaseNoteTitleTextBox		= "//input[@placeholder='Case Note Title']";
	
	public final String xpth_NewCaseNotesCaseNotesTextBox			= "//textarea[@placeholder='Case Note']";
	
	public final String xpth_NewCaseNotesSubmitButton				= "//span[contains(text(),'Submit')]/..";
	
	public final String xpth_NewCaseNotesBackButton					= "//span[contains(text(),'Back')]/..";
	
	public final String xpth_NewCaseNotesConfidentialsCaseNoteLabel	= "//span[contains(text(),'Confidential Case Note')]/..";
	
	
	//View Edit Case Note
	public final String xpth_ViewCaseNotesBackButton				= "//span[contains(text(),'Back')]/..";
	
	public final String xpth_ViewCaseNoteEditButton					= "//span[text()='Edit']/..";
	
	public final String xpth_EditCaseNoteSaveButton					= "//span[contains(text(),'Save')]/..";

}

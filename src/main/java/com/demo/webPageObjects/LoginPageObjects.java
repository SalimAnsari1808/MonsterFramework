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

public class LoginPageObjects {
	
	
	public LoginPageObjects() {
		
	}
	
	//Login Section Elements Locator

	public final String xpth_LogInText			= "//span[text()='Log in']";
	
	public final String xpth_UserNameTextBox 	= "//input[@placeholder='Username']";
	
	public final String xpth_PasswordTextBox 	= "//input[@placeholder='Password']";
	
	public final String xpth_LoginButton 		= "//button[@type='submit']";
	
	public final String xpth_QuickLoginButton 	= "//button[@mattooltip='Login as a State Admin']";
	
	
	//Choose Office PopUp
	public final String xpth_ChooseOfficePopUpOfficeText			= "//mat-select//span";
	
	public final String xpth_ChooseOfficePopUpOfficeOptionTextList	= "//mat-option";
	
	public final String xpth_ChooseOfficePopUpSubmitButton			= "//span[contains(text(),'Select')]/..";
}
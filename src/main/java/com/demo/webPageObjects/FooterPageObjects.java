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

public class FooterPageObjects {

	//paginator container
	public final String xpth_PaginatorItemPerPageText		= "//mat-paginator//div[contains(@class,'page-size-label')]";
	
	public final String xpth_PaginatorPerPageSelectedText	= "//mat-paginator//mat-select//div[contains(@class,'select-value')]/span";
	
	public final String xpth_PaginatorRangeText				= "//mat-paginator//div[contains(@class,'range-label')]";
	
	public final String xpth_PaginatorFirstPageButton		= "//mat-paginator//button[@aria-label='First page']";
	
	public final String xpth_PaginatorPreviousPageButton	= "//mat-paginator//button[@aria-label='Previous page']";
	
	public final String xpth_PaginatorNextPageButton		= "//mat-paginator//button[@aria-label='Next page']";
	
	public final String xpth_PaginatorLastPageButton		= "//mat-paginator//button[@aria-label='Last page']";
	
}

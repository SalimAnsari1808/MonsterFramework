package com.demo.sampleTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demo.baseClass.BaseClass;
import com.demo.uility.SelenideUtil;
import com.demo.uility.TestUtil;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;

/*****************************************************************************************************************************
 * TestCaseId:- 	TC:213179
 * Description:- 	Employer_CompanySearch_CaseNotes
 * Created By:- 	Abhishek Kumar Sharma
 * Created Date:- 	17-Jan-2020
 * Reviewed By:- 
 * Reviewed Date:- 
 * ***************************************************************************************************************************/
@Listeners(com.demo.testNG.AnnotationTransformer.class)
public class SampleTest3 extends BaseClass{

	@Parameters ({"platform"})
	@Test
	public void SampleTest3Method (@Optional("NA")String platform) {
		
		/*******************************************************************************************
		****************************Navigate to Case Note Page**************************************
		*******************************************************************************************/
		
		final String LOGIN			= "StateAdmin";
		final String SEARCH_TYPE	= "Employer";
		final String COMPANY_NAME	= "Monster Sanitation";
		final String ACTION_OPTION	= "View Dashboard";
		final String TAB_NAME		= "Case Notes";
		
		openBrowser(platform);
		
//Step 1:- User Role prep: following user roles have access to this page: 1) State Admin 2) State Performance (read only) 3)WIB admin 4)Office Admin
//Step 2:- This test case validates that the Case Notes can be added and existing ones can be edited
		webPageMethodsManager.getLoginPageMethods().launchApplicationUnderTest();
		
//Step 3:- Login to https://cm-demo.monster.com, select Employer->company search->search for a company->Under "Actions" select "View Dashboard"->select "CaseNotes" tab
		webPageMethodsManager.getLoginPageMethods().loginToApplication(LOGIN);
		webPageMethodsManager.getHeaderPageMethods().clickOnLeftMenuButton();
		webPageMethodsManager.getHeaderPageMethods().searchValueHeaderSection(SEARCH_TYPE, COMPANY_NAME);
		webPageMethodsManager.getSearchResultPageMethods().selectEmployerActionOption("NA", ACTION_OPTION);
		webPageMethodsManager.getHeaderPageMethods().selectNavigationTab(TAB_NAME);

//Step 4:- Select "Create new" button
		webPageMethodsManager.getCaseNotesPageMethods().clickNewCaseNoteButton();
		
		/*******************************************************************************************
		****************************Validation on Case Notes Page***********************************
		*******************************************************************************************/

/*Step5:- a.Verify that the "note date" can have current date/backdated but cannot have a future date.
*		b.Verify that Case note title is a required field
*		c.Verify that "case note" is a required field
*		d.Select the Submit button */
		
		final String CURRENT_DATE	= TestUtil.getStringDateFormat(0, "MM/dd/yyyy");
		final String PREVIOUS_DATE	= TestUtil.getStringDateFormat(-2, "MM/dd/yyyy");
		final String NEXT_DATE		= TestUtil.getStringDateFormat(2, "MM/dd/yyyy");
		final String ATTRIBUE		= "required";
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, NEXT_DATE, TAB_NAME);
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, ""+Keys.TAB, TAB_NAME);
		ValidationUtil.validateTestStep("Error Message is Displayed for Next Date on Case Note Page",
				SelenideUtil.checkElementVisible(webPageObjectsManager.getCommonPageObjects().xpth_Error));
		SelenideUtil.clearTextBoxUsingSendKeys(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, TAB_NAME);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, PREVIOUS_DATE, TAB_NAME);
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, ""+Keys.TAB, TAB_NAME);
		boolean statusFlag1 = SelenideUtil.checkElementExist(webPageObjectsManager.getCommonPageObjects().xpth_Error);
		ValidationUtil.validateTestStep("Error Message is not Displayed for Previous Date on Case Note Page",!statusFlag1);
		SelenideUtil.clearTextBoxUsingSendKeys(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, TAB_NAME);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, CURRENT_DATE, TAB_NAME);
		boolean statusFlag2 = SelenideUtil.checkElementExist(webPageObjectsManager.getCommonPageObjects().xpth_Error);
		ValidationUtil.validateTestStep("Error Message is not Displayed for Current Date on Case Note Page",!statusFlag2);
		SelenideUtil.clearTextBoxUsingSendKeys(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, TAB_NAME);
		
		boolean statusFlag3 = SelenideUtil.hasAtrributePresent(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesCaseNoteTitleTextBox, ATTRIBUE, TAB_NAME);
		ValidationUtil.validateTestStep("Case Note Title Field is Required on Case Note Page", statusFlag3);
		
		boolean statusFlag4 = SelenideUtil.hasAtrributePresent(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesCaseNotesTextBox, ATTRIBUE, TAB_NAME);
		ValidationUtil.validateTestStep("Case Notes Field is Required on Case Note Page", statusFlag4);
				
		webPageMethodsManager.getCaseNotesPageMethods().createNewCaseNote();
		
		WaitUtil.untilTimeComplete(2000);

//Step 6:- On the Casenotes screen, select "view casenote" to view an existing case note and verify The view screen with "back and Edit" buttons are displayed
		
		webPageMethodsManager.getCaseNotesPageMethods().viewCaseNote("NA");
		
		boolean statusFlag5 = SelenideUtil.checkElementVisible(webPageObjectsManager.getCaseNotesPageObjects().xpth_ViewCaseNoteEditButton);
		
		boolean statusFlag6 = SelenideUtil.checkElementVisible(webPageObjectsManager.getCaseNotesPageObjects().xpth_ViewCaseNotesBackButton);
		
		ValidationUtil.validateTestStep("Back And Edit Button is displayed on View Case Note Page", statusFlag5&&statusFlag6);

/*Step 7:- Select the Edit button
*			a.Verify that the "note date" can be modified to have current date/backdated but cannot have a future date.
*			b.Verify that Case note title can be modified
*			c.Verify that "case note" can be modified
*			d.Select the Submit button */
		
		SelenideUtil.click(webPageObjectsManager.getCaseNotesPageObjects().xpth_ViewCaseNoteEditButton, TAB_NAME);
		
		WaitUtil.untilTimeComplete(200);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, NEXT_DATE,TAB_NAME);
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, ""+Keys.TAB, TAB_NAME);
		ValidationUtil.validateTestStep("Error Message is Displayed for Next Date on Case Note Page",
				SelenideUtil.checkElementVisible(webPageObjectsManager.getCommonPageObjects().xpth_Error));
		SelenideUtil.clearTextBoxUsingSendKeys(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, TAB_NAME);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, PREVIOUS_DATE,TAB_NAME);
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, ""+Keys.TAB, TAB_NAME);
		boolean statusFlag7 = SelenideUtil.checkElementExist(webPageObjectsManager.getCommonPageObjects().xpth_Error);
		ValidationUtil.validateTestStep("Error Message is not Displayed for Previous Date on Case Note Page",!statusFlag7);
		SelenideUtil.clearTextBoxUsingSendKeys(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, TAB_NAME);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesDateTextBox, CURRENT_DATE, TAB_NAME);
		boolean statusFlag8 = SelenideUtil.checkElementExist(webPageObjectsManager.getCommonPageObjects().xpth_Error);
		ValidationUtil.validateTestStep("Error Message is not Displayed for Current Date on Case Note Page",!statusFlag8);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesCaseNoteTitleTextBox, "New", TAB_NAME);
		
		SelenideUtil.setValue(webPageObjectsManager.getCaseNotesPageObjects().xpth_NewCaseNotesCaseNotesTextBox, "New", TAB_NAME);
		
		SelenideUtil.click(webPageObjectsManager.getCaseNotesPageObjects().xpth_EditCaseNoteSaveButton, TAB_NAME);
		
		ValidationUtil.validateTestStep("Case Note Date, Case Note Title and Case Note can be Modified", 
				SelenideUtil.checkElementVisible(webPageObjectsManager.getCaseNotesPageObjects().xpth_ViewCaseNoteEditButton));
	}
}
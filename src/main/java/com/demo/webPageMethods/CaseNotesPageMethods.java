package com.demo.webPageMethods;


import com.demo.baseClass.ScenarioContext;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.SelenideUtil;
import com.demo.uility.TestUtil;
import com.demo.uility.WaitUtil;
import com.demo.webPageObjects.CaseNotesPageObjects;

public class CaseNotesPageMethods {
	
	private CaseNotesPageObjects caseNotesPageObjects;
	
	//private ScenarioContext   scenarioContext;
	
	public CaseNotesPageMethods(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		caseNotesPageObjects    = webPageObjectsManager.getCaseNotesPageObjects();
		//this.scenarioContext = scenarioContext;
	}
	
	public synchronized void clickNewCaseNoteButton() {
		
		SelenideUtil.click(caseNotesPageObjects.xpth_CreateNewButton, "Case Notes Page inside method clickNewCaseNoteButton");
		
	}
	
	public synchronized void createNewCaseNote() {
		
		if(SelenideUtil.checkElementExist(caseNotesPageObjects.xpth_CreateNewButton)) {
			clickNewCaseNoteButton();
		}
		
		SelenideUtil.setValue(caseNotesPageObjects.xpth_NewCaseNotesDateTextBox, 
				TestUtil.getStringDateFormat(0, "MM/dd/yyyy"), "Case Note");
		
		SelenideUtil.setValue(caseNotesPageObjects.xpth_NewCaseNotesCaseNoteTitleTextBox, 
				"Case Note Title "+TestUtil.currentDateTimeString(), "Case Note");
		
		SelenideUtil.setValue(caseNotesPageObjects.xpth_NewCaseNotesCaseNotesTextBox, 
				"Case Note Discription "+TestUtil.currentDateTimeString(), "Case Note");
		
		SelenideUtil.click(caseNotesPageObjects.xpth_NewCaseNotesSubmitButton, "Case Notes");
		
		WaitUtil.untilTimeComplete(1500);
		
		SelenideUtil.click(caseNotesPageObjects.xpth_ViewCaseNotesBackButton, "Case Notes");
	}
	
	public synchronized void viewCaseNote(String caseNoteTitle) {
		
		if(caseNoteTitle.equalsIgnoreCase("NA")) {
			SelenideUtil.jsClick(caseNotesPageObjects.xpth_ActionViewButtonList,"0", "Case Note");
			//JSExecuteUtil.clickOnElement(SelenideUtil.getSelenideElement(caseNotesPageObjects.xpth_ActionViewButtonList));
		}else {
			SelenideUtil.click(caseNotesPageObjects.xpth_ActionViewButtonList,
					Integer.toString(SelenideUtil.getTextIndexFromList(caseNotesPageObjects.xpth_CaseNoteTitleValueTextList, caseNoteTitle)), "Case Note");
		}
		
	}
	
}

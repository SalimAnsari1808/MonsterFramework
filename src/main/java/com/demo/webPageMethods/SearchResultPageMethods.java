package com.demo.webPageMethods;

import com.demo.baseClass.ScenarioContext;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.SelenideUtil;
import com.demo.uility.WaitUtil;
import com.demo.webPageObjects.SearchResultPageObjects;

public class SearchResultPageMethods {

	//private ScenarioContext   scenarioContext;
	private SearchResultPageObjects  searchResultPageObjects;
		
	public SearchResultPageMethods(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		searchResultPageObjects = webPageObjectsManager.getSearchResultPageObjects();
		//this.scenarioContext = scenarioContext;
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	public synchronized void selectEmployerActionOption(String employerName,String option) {
		
		if(employerName.equalsIgnoreCase("NA")) {
			SelenideUtil.click(searchResultPageObjects.xpth_EmployerSearchAction3DotList,"0", "Search Result Page");
		}else {
			SelenideUtil.click(searchResultPageObjects.xpth_EmployerSearchAction3DotList,
					Integer.toString(SelenideUtil.getTextIndexFromList(searchResultPageObjects.xpth_EmployerSearchEmployerNameList, employerName)), "Search Result Page");
		}
		WaitUtil.untilTimeComplete(1000);
		SelenideUtil.selectTextFromList(searchResultPageObjects.xpth_EmployerSearchActionOptionList,option,"Search Result Page");
		
	}
	
	
}

package com.demo.managers;

import com.demo.baseClass.ScenarioContext;
import com.demo.webPageMethods.CaseNotesPageMethods;
import com.demo.webPageMethods.GooglePageMethods;
import com.demo.webPageMethods.HeaderPageMethods;
import com.demo.webPageMethods.LoginPageMethods;
import com.demo.webPageMethods.SearchResultPageMethods;
import com.demo.webPageMethods.ServiceRenderedPageMethods;

public class WebPageMethodsManager {
	
	private WebPageObjectsManager webPageObjectsManager;
	private ScenarioContext scenarioContext;
	private LoginPageMethods loginPageMethods;
	private HeaderPageMethods headerPageMethods;
	private SearchResultPageMethods searchResultPageMethods;
	private ServiceRenderedPageMethods serviceRenderedPageMethods;
	private CaseNotesPageMethods caseNotesPageMethods;
	private GooglePageMethods googlePageMethods;
	
	public WebPageMethodsManager(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		this.webPageObjectsManager = webPageObjectsManager;
		this.scenarioContext = scenarioContext;
	}
	
	public LoginPageMethods getLoginPageMethods() {
		if(loginPageMethods == null) {
			return loginPageMethods = new LoginPageMethods(webPageObjectsManager, scenarioContext);
		}else {
			return loginPageMethods;
		}
	} 
	
	public HeaderPageMethods getHeaderPageMethods() {
		if(headerPageMethods == null) {
			return headerPageMethods = new HeaderPageMethods(webPageObjectsManager, scenarioContext);
		}else {
			return headerPageMethods;
		}
	} 
	
	public SearchResultPageMethods getSearchResultPageMethods() {
		if(searchResultPageMethods == null) {
			return searchResultPageMethods = new SearchResultPageMethods(webPageObjectsManager, scenarioContext);
		}else {
			return searchResultPageMethods;
		}
	}
	
	public ServiceRenderedPageMethods getServiceRenderedPageMethods() {
		if(serviceRenderedPageMethods == null) {
			return serviceRenderedPageMethods = new ServiceRenderedPageMethods(webPageObjectsManager, scenarioContext);
		}else {
			return serviceRenderedPageMethods;
		}
	}
	
	public CaseNotesPageMethods getCaseNotesPageMethods() {
		if(caseNotesPageMethods == null) {
			return caseNotesPageMethods = new CaseNotesPageMethods(webPageObjectsManager, scenarioContext);
		}else {
			return caseNotesPageMethods;
		}
	}
	
	public GooglePageMethods getGooglePageMethods() {
		if(googlePageMethods == null) {
			return googlePageMethods = new GooglePageMethods(webPageObjectsManager, scenarioContext);
		}else {
			return googlePageMethods;
		}
	}
}

package com.demo.managers;

import com.demo.webPageObjects.CaseNotesPageObjects;
import com.demo.webPageObjects.CommonPageObjects;
import com.demo.webPageObjects.GooglePage;
import com.demo.webPageObjects.HeaderPageObjects;
import com.demo.webPageObjects.LoginPageObjects;
import com.demo.webPageObjects.SearchResultPageObjects;
import com.demo.webPageObjects.ServicesRenderedPageObjects;

public class WebPageObjectsManager {
	private LoginPageObjects loginPageObjects;
	private HeaderPageObjects headerPageObjects;
	private SearchResultPageObjects searchResultPageObjects;
	private ServicesRenderedPageObjects servicesRenderedPageObjects;
	private CaseNotesPageObjects caseNotesPageObjects;
	private CommonPageObjects commonPageObjects;
	private GooglePage googlePage;
	
	public WebPageObjectsManager() {
		
	}
	
	public LoginPageObjects getLoginPageObjects() {
		if(loginPageObjects == null) {
			return loginPageObjects = new LoginPageObjects();
		}else {
			return loginPageObjects;
		}
	}
	
	public HeaderPageObjects getHeaderPageObjects() {
		if(headerPageObjects == null) {
			return headerPageObjects = new HeaderPageObjects();
		}else {
			return headerPageObjects;
		}
	}

	public SearchResultPageObjects getSearchResultPageObjects() {
		if(searchResultPageObjects == null) {
			return searchResultPageObjects = new SearchResultPageObjects();
		}else {
			return searchResultPageObjects;
		}
	}
	
	public ServicesRenderedPageObjects getServicesRenderedPageObjects() {
		if(servicesRenderedPageObjects == null) {
			return servicesRenderedPageObjects = new ServicesRenderedPageObjects();
		}else {
			return servicesRenderedPageObjects;
		}
	}
	
	public CaseNotesPageObjects getCaseNotesPageObjects() {
		if(caseNotesPageObjects == null) {
			return caseNotesPageObjects = new CaseNotesPageObjects();
		}else {
			return caseNotesPageObjects;
		}
	}
	
	public CommonPageObjects getCommonPageObjects() {
		if(commonPageObjects == null) {
			return commonPageObjects = new CommonPageObjects();
		}else {
			return commonPageObjects;
		}
	}
	
	public GooglePage getGooglePageObject() {
		if(googlePage == null) {
			return googlePage = new GooglePage();
		}else {
			return googlePage;
		}
	}
	
}

package com.demo.webPageMethods;

import com.demo.baseClass.ScenarioContext;
import com.demo.managers.WebPageObjectsManager;
import com.demo.uility.SelenideUtil;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;
import com.demo.webPageObjects.ServicesRenderedPageObjects;

public class ServiceRenderedPageMethods {

	private ServicesRenderedPageObjects servicesRenderedPageObjects;
	//private ScenarioContext   scenarioContext;
	
	public ServiceRenderedPageMethods(WebPageObjectsManager webPageObjectsManager, ScenarioContext scenarioContext) {
		servicesRenderedPageObjects    = webPageObjectsManager.getServicesRenderedPageObjects();
		//this.scenarioContext = scenarioContext;
	}
	
	public synchronized void selectServicesActionOption(String serviceName,String option) {
		
		if(serviceName.equalsIgnoreCase("NA")) {
			SelenideUtil.click(servicesRenderedPageObjects.xpth_Action3DotList,"0", "Service Rendered Page");
		}else {
			SelenideUtil.click(servicesRenderedPageObjects.xpth_Action3DotList,
					Integer.toString(SelenideUtil.getTextIndexFromList(servicesRenderedPageObjects.xpth_Action3DotList, serviceName)), "Service Rendered Page");
		}
		
		WaitUtil.untilTimeComplete(1000);
		
		SelenideUtil.click(servicesRenderedPageObjects.xpth_ActionOptionViewButton,"Service Rendered Page");
		
	}
	
	public synchronized void selectViewRecordServiceEditBackButton(String buttonName) {
		if(buttonName.equalsIgnoreCase("Back")) {
			SelenideUtil.click(servicesRenderedPageObjects.xpth_ViewRecordServicesBackButton, "View Record Service of Service Rendered");
		}else if (buttonName.equalsIgnoreCase("Edit")) {
			SelenideUtil.click(servicesRenderedPageObjects.xpth_ViewRecordServicesEditServiceButton, "View Record Service of Service Rendered");
		}
		
	}
	
	public synchronized void selectEditRecordServiceVoidServiceButton(String buttonName) {
		SelenideUtil.click(servicesRenderedPageObjects.xpth_EditRecordServicesVoidServiceButton, "Edit Record Service of Service Rendered");
		
		WaitUtil.untilTimeComplete(1500);
		
		ValidationUtil.validateTestStep("Please Confirm Dialog Box Open on Edit Record Service of Service Rendered Page", true);
		if(buttonName.equalsIgnoreCase("Yes")) {
			SelenideUtil.click(servicesRenderedPageObjects.xpth_PleaseConfirmDialogBoxYesButton, "Edit Record Service of Service Rendered");
		}else if (buttonName.equalsIgnoreCase("No")) {
			SelenideUtil.click(servicesRenderedPageObjects.xpth_PleaseConfirmDialogBoxNoButton, "Edit Record Service of Service Rendered");
		}
		
	}
	
}

package com.demo.sampleTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demo.baseClass.BaseClass;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;

/*****************************************************************************************************************************
 * TestCaseId:- 	SampleTest 2
 * Description:- 	Open shreepartners through google
 * Created By:- 	Salim Ansari
 * Created Date:- 	29-Sep-2020
 * Reviewed By:- 
 * Reviewed Date:- 
 * ***************************************************************************************************************************/

public class SampleTest2 extends BaseClass {
	
	@Parameters ({"platform"})
	@Test
	public void SampleTest2Method (@Optional("NA")String platform) {
		
		/*******************************************************************************************
		****************************Navigate to Google Page*******************************
		*******************************************************************************************/
		
		if(!platform.equals("NA")) {
            ValidationUtil.validateTestStep("Starting Test Case under Suite on " + platform + " Browser"   , true);
        }

        //open browser
        openBrowser( platform);
             
        //open google
        webPageMethodsManager.getGooglePageMethods().launchApplication();
        
        //wait for 5 second
        WaitUtil.untilTimeComplete(7000);

        //search shreepartners
        webPageMethodsManager.getGooglePageMethods().searchShreepartners();

        //click on shreepartners link
        webPageMethodsManager.getGooglePageMethods().clickOnShreepartnersLink();
        
        /*******************************************************************************************
		****************************Validation on Shreepartners.com Page*******************************
		*******************************************************************************************/
        
        //check URL
        boolean statusFlag = getDriver().getCurrentUrl().contains("https://www.shreepartners.com");
        
        //validate step
        ValidationUtil.validateTestStep("Shree partners is open Successfully",statusFlag);
	}
}
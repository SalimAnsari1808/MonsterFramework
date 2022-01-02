package com.demo.sampleTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demo.baseClass.BaseClass;
import com.demo.uility.ValidationUtil;
import com.demo.uility.WaitUtil;

/*****************************************************************************************************************************
 * TestCaseId:- 	SampleTest 1
 * Description:- 	Open shreepartners through google
 * Created By:- 	Salim Ansari
 * Created Date:- 	29-Sep-2020
 * Reviewed By:- 
 * Reviewed Date:- 
 * ***************************************************************************************************************************/

public class SampleTest1 extends BaseClass{
	//Platform_Browser_Version
	@Parameters ({"platform"})
	@Test
	public void SampleTest1Method (@Optional("NA")String platform) {
		
		/*******************************************************************************************
		****************************Navigate to google Page*******************************
		*******************************************************************************************/
				
		//open Browser
		openBrowser(platform);

//		webPageMethodsManager.getLoginPageMethods().launchApplicationUnderTest();
		
//		WebDriver driver = getDriver();
//		
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Shree Partners LLC");
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
//		
//		driver.findElement(By.xpath("//a[@href='https://www.shreepartners.com/']")).click();
		
		webPageMethodsManager.getGooglePageMethods().launchApplication();
		
		//wait for 5 second
        WaitUtil.untilTimeComplete(7000);
        
		webPageMethodsManager.getGooglePageMethods().searchShreepartners();
		webPageMethodsManager.getGooglePageMethods().clickOnShreepartnersLinkOnWeb();
		
		/*******************************************************************************************
		****************************Validation on Service Rendered Page*****************************
		*******************************************************************************************/
		
		//check URL
        boolean statusFlag = getDriver().getCurrentUrl().contains("https://www.shreepartners.com");
        
        //validate step
        ValidationUtil.validateTestStep("Shree partners is open Successfully",statusFlag);

	}

}

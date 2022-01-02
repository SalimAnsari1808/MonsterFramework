package com.demo.uility;

import org.testng.Assert;

import com.demo.baseClass.BaseClass;

public class ValidationUtil {
	
	
	public static boolean validateTestStep(String TestDesc, boolean statusFlag) {
		BaseClass baseClass = new BaseClass();

		//check the status flag of test step
		if(statusFlag) {
			//update extent report
			baseClass.getExtText().pass(TestDesc);

			//mark test as pass
			Assert.assertTrue(true);
		}else{
			System.out.println(TestDesc + ": FAILED");

			//update extent report
			baseClass.getExtText().fail(TestDesc);

			//mark test as fail
			Assert.assertTrue(false);
		}
		//need to add log file here to print all test description in log
		System.out.println(TestDesc);
		return statusFlag;
	}
}

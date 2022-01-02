package com.demo.managers;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demo.uility.TestUtil;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	//Create an extent report instance
	public static ExtentReports createInstance() {
		//platform = getCurrentPlatform();
		//String fileName = getReportFileLocation(platform);
		String appURL = "";
		//String sysInfomation;

		//check the
		//if(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().contains("qaepic")){
		//	appURL = "QAEpic_";
		//	sysInfomation = "Production";
		//}else if(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().contains("nav")) {
		//	appURL = "Nav01_";
		//	sysInfomation = "Testing";
		//}

		//String css = ".report-name { padding-left: 10px; } .report-name > img { float: left;height: 90%;margin-left: 30px;margin-top: 2px;width: auto; }";


		String fileName =  appURL + TestUtil.currentDateTimeString()+".html";
		//String fileName =  "Sample.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/reports/"+fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().enableTimeline(false);
		htmlReporter.config().setDocumentTitle("Demo Automation Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Demo Automation Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		//extent.setSystemInfo("",);
		return extent;
	}
}

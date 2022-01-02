package com.demo.uility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtil {
	
	public static String takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenShotFileName = (currentDateTimeString() + ".png");

		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshots/" + screenShotFileName));

		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Screen Shot taken using takeScreenshotAtEndOfTest method");

		return System.getProperty("user.dir") + "/screenshots/" + screenShotFileName;

	}


	public static String getBase64Screenshot(WebDriver driver) throws IOException {
	
		String encodedBase64 = null;
		FileInputStream fileInputStream = null;
	
		String screenShotFileName = (currentDateTimeString() + ".png");
	
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenShotFileName;
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
	
		try {
			fileInputStream =new FileInputStream(finalDestination);
			byte[] bytes =new byte[(int)finalDestination.length()];
			fileInputStream.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	
		return encodedBase64;
	}
	
	public static String currentDateTimeString() {
		//create date instance
		Date curdate = new Date();
		
		//create format instance in which need to be converted
		SimpleDateFormat newformat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Date Time string is created with value " + newformat.format(curdate));
		
		//return current date and time after converting into format
		return newformat.format(curdate);
	}
	
	public static String currentDateString() {
		//create date instance
		Date curdate = new Date();
		
		//create format instance in which need to be converted
		SimpleDateFormat newformat = new SimpleDateFormat("MM_dd_yyyy");
		
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, "Date Time string is created with value " + newformat.format(curdate));
		
		//return current date and time after converting into format
		return newformat.format(curdate);
	}
	
	public static File getLatestFailedSnapshotFile(){
		//create dic intance of result folder
		File dir = new File(System.getProperty("user.dir")+"\\screenshots\\");

		//get all files from result folder
		File[] files = dir.listFiles();

		//check is present in folder
		if (files == null || files.length == 0) {
			return null;
		}

		//get firest file for comparision
		File lastModifiedFile = files[0];

		//loop through all files to get the latest file
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		//return latest file
		return lastModifiedFile;
	}
	
	//**********************************************************************************************
	//Method Name:getStringDateFormat
	//Description: Method is used to generate date string based on date number and date format
	//Input Arguments:1.dateNumber->Number of which date is required
	//				  2.dateFormat->Empty string used for nested recursion
	//Return: string of date
	//Created By : Salim Ansari
	//Created On : 15-Jan-2020
	//Reviewed By:
	//Reviewed On:
	//**********************************************************************************************
    public static String getStringDateFormat(Object object,String dateFormat) {
	   	//declare of class used in method
    	Calendar calender;
		Date date;
		SimpleDateFormat dateFormatter;
			
		//create calendar instance
		calender = Calendar.getInstance();
			
		//Increment calendar date to get departure date
		calender.add(Calendar.DATE, Integer.parseInt(object.toString()));

		//get date from calendar in correct format
		date = calender.getTime();
			
		//set format in which date is required
		dateFormatter = new SimpleDateFormat(dateFormat);
			
		//update extent report
		//BaseClass.test.log(LogStatus.INFO, dateFormatter.format(date) + "is the date string of day number " + dateFormat);
			
		//convert date in required format
		return dateFormatter.format(date);
    }
}

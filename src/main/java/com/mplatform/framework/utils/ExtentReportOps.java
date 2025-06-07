package com.mplatform.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportOps 
{

	public static ExtentReports createExtentReporter(String projectName) 
    {	
    			
    	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\generatedReport\\" + projectName + ".html";
    	
    	System.out.println("filePath => " + filePath);
    	
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
    //	htmlReporter.setAppendExisting(true);
    	
   		ExtentReports extentreporter = new ExtentReports();
   		extentreporter.attachReporter(htmlReporter);
  
		return extentreporter;   
		
    }
}

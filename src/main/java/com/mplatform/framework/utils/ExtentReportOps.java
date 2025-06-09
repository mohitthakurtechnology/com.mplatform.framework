package com.mplatform.framework.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportOps 
{

	public static ExtentReports createExtentReporter(String projectName) 
    {	
    			
    	String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator +"test" + File.separator + "resources" + File.separator + "generatedReport" + File.separator + projectName + ".html";
    	
    	System.out.println("filePath => " + filePath);
    	
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
    //	htmlReporter.setAppendExisting(true);
    	
   		ExtentReports extentreporter = new ExtentReports();
   		extentreporter.attachReporter(htmlReporter);
  
		return extentreporter;   
		
    }
}

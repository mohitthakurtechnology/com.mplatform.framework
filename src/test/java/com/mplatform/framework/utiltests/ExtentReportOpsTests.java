package com.mplatform.framework.utiltests;

import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mplatform.framework.utils.ExtentReportOps;
import com.mplatform.framework.utils.PropertiesFileOps;

/**
 * Unit test for simple App.
 */
public class ExtentReportOpsTests 
{
    @Test
    public void createTestReporterTest()
    {
    	
    	PropertiesFileOps propertiesFileOps = new PropertiesFileOps();
    	Properties prop = propertiesFileOps.loadProperties("configs");
    	
    	ExtentReports extentReporterTest = ExtentReportOps.createExtentReporter(prop.getProperty("projectName"));
    	ExtentTest extentTests = extentReporterTest.createTest("demoTest");
    	
    	extentTests.pass("demo test pass");
    	extentTests.log(Status.PASS, "demo test log pass");
    	
    	extentReporterTest.flush();
    	
    }
}

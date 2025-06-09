package com.mplatform.framework.utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyListeners implements ITestListener,ISuiteListener
{
	public static WebDriver driver;
	
	public static PropertiesFileOps propertiesfileops;
	public static Properties prop;
	
	public static ExtentReports extentreporter;
	public static ExtentTest extenttest;
	public static Logger logger = null; 
	
	String binariesPath;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		logger = LogManager.getLogger(result.getTestClass().getName().concat(".class"));
		logger.log(Level.INFO, "OnTestStart - Invoked at every test method");
		logger.log(Level.INFO, "test class ============================= >>>" + result.getTestClass().getName()+".class");

		extenttest = extentreporter.createTest(result.getName());
		logger.log(Level.INFO, "test started ============================= >>>>>>>>>>>>" + result.getName());

		extenttest.info("test started ============================= >>>>>>>>>>>>" + result.getName());
		
		
		Object platform = setPlatform(prop.getProperty("PlatformType"));
		
		if(platform instanceof WebDriver)
		{	
			
			driver.get(prop.getProperty("weburl"));
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		logger.log(Level.INFO, "OnTestSuccess - Invoked at every test method success");
		extenttest.pass(result.getName());
		driver.quit();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFailure - Invoked at every test method fails");
		logger.log(Level.INFO,"OnTestFailure - Invoked at every test method fails");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkipped - Invoked at every test method skipped");
		logger.log(Level.INFO,"OnTestSkipped - Invoked at every test method skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("OnTestFailedButWithinSuccessPercentage - Invoked when test method fails with some success percentage defined by user");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Onstart - Invoked on the test class initiation before any test method execution"+ context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("OnFinish - Invoked after all test methods is executed");
		
	}
	
	@Override
	public void onStart(ISuite suite) {
		init(suite.getXmlSuite().getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		extentreporter.flush();
		
	}
	
	public void init(String suiteName)
	{
		
		propertiesfileops = new PropertiesFileOps();
		prop = propertiesfileops.loadProperties("configs");
		extentreporter = ExtentReportOps.createExtentReporter(suiteName);
	
	}
	
	//Platform Utils

	public Object setPlatform(String platformName)
	{
		
		if(prop.getProperty("PlatformType").toUpperCase().compareTo("WEB")==0) {
			driver = setBrowser(prop.getProperty("BrowserType"));
		}
		else if(prop.getProperty("PlatformType").toUpperCase().compareTo("API")==0) {
			System.out.println(prop.getProperty("PlatformType"));
		}
		else if(prop.getProperty("PlatformType").toUpperCase().compareTo("MOBILE")==0) {
			System.out.println(prop.getProperty("PlatformType"));
		}
		
		return driver ;
	}
	
	//WebUtils
	
	public WebDriver setBrowser(String BrowserName)
	{
		binariesPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "binaries" + File.separator + "chromedriver"  + ".exe";
		
		if(prop.getProperty("BrowserType").toUpperCase().compareTo("CHROME")==0) {
		
			System.setProperty("webdriver.chrome.driver", binariesPath);
			driver = new ChromeDriver();
			
		}
		else if(prop.getProperty("BrowserType").toUpperCase().compareTo("FIREFOX")==0) {
			
			System.out.println(prop.getProperty("BrowserType"));
			
		}
		else if(prop.getProperty("BrowserType").toUpperCase().compareTo("EDGE")==0) {
			
			System.out.println(prop.getProperty("BrowserType"));
			
		}
		else if(prop.getProperty("BrowserType").toUpperCase().compareTo("SAFARI")==0) {
			
			System.out.println(prop.getProperty("BrowserType"));
			
		}
		
		return driver;
	}

}
package com.mplatform.framework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyListeners implements ITestListener
{
	public static WebDriver driver;
	public static PropertiesFileOps propertiesfileops;
	public static Properties prop;
	String binariesPath;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("OnTestStart - Invoked at every test method");
		
		init();
		setPlatform(prop.getProperty("PlatformType"));
		
		
		driver.get(prop.getProperty("weburl"));
		
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("OnTestSuccess - Invoked at every test method success");
		driver.quit();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFailure - Invoked at every test method fails");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkipped - Invoked at every test method skipped");
		
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
	
	public void init()
	{
		propertiesfileops = new PropertiesFileOps();
		prop = propertiesfileops.loadProperties("configs");
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
		binariesPath = System.getProperty("user.dir") + prop.getProperty("BinaryPath");
		
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
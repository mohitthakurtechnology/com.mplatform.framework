package com.mplatform.framework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyListeners implements ITestListener  
{
	WebDriver driver;
	PropertiesFileOps propertiesfileops;
	Properties prop;
	String binariesPath;
	
	public void init()
	{
		propertiesfileops = new PropertiesFileOps();
		
		try {
			
			this.prop = propertiesfileops.loadProperties("configs");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver getWebDriver(String BrowserName)
	{
		if(prop.getProperty("BrowserType").toUpperCase().compareTo("CHROME")==0) {
			
			this.binariesPath = System.getProperty("user.dir") + prop.getProperty("ChromeBinaryPath");
			System.setProperty("webdriver.chrome.driver", binariesPath);
			this.driver = new ChromeDriver();
			
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
		return this.driver;
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("OnTestStart - Invoked at every test method");
		
		init();
		
		if(prop.getProperty("PlatformType").toUpperCase().compareTo("WEB")==0) {
			
			driver = getWebDriver(prop.getProperty("BrowserType"));
			driver.get("https://www.browserstack.com/");
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
			
		}
		else if(prop.getProperty("PlatformType").toUpperCase().compareTo("API")==0) {
			System.out.println(prop.getProperty("PlatformType"));
		}
		else if(prop.getProperty("PlatformType").toUpperCase().compareTo("MOBILE")==0) {
			System.out.println(prop.getProperty("PlatformType"));
		}
		
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
}
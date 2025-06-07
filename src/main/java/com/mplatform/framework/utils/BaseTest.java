package com.mplatform.framework.utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BaseTest 
{
	public WebDriver driver;
	PropertiesFileOps propertiesfileops;
	public Properties prop;
	String binariesPath;
	
	@BeforeMethod
    public void testSetUp()
    {
		
		propertiesfileops = new PropertiesFileOps();
		try {
				prop = propertiesfileops.loadProperties("configs");
				if(prop.getProperty("PlatformType").toUpperCase().compareTo("WEB")==0) {
					System.out.println(prop.getProperty("testType"));
					binariesPath = System.getProperty("user.dir") + prop.getProperty("ChromeBinaryPath");
					if(prop.getProperty("BrowserType").toUpperCase().compareTo("CHROME") == 0)
					{
						System.setProperty("webdriver.chrome.driver",binariesPath);
						driver = new ChromeDriver();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
						driver.get(prop.getProperty("weburl"));
						
						
						
					}
					
				}
				else if(prop.getProperty("PlatformType").toUpperCase().compareTo("API")==0) {
					System.out.println(prop.getProperty("testType"));
				}
				else if(prop.getProperty("PlatformType").toUpperCase().compareTo("MOBILE")==0) {
					System.out.println(prop.getProperty("testType"));
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	@AfterMethod
    public void tearDown()
    {
		driver.quit();
    }
}

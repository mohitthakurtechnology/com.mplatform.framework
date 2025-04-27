package com.mplatform.framework.utils;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest 
{
	public WebDriver driver;
	public PropertiesFileOps propertiesfileops;
	
	@BeforeTest
    public void testSetUp(String testType)
    {
		propertiesfileops = new PropertiesFileOps();
		Properties prop;
		try {
				prop = propertiesfileops.loadProperties("configs");
				if(prop.getProperty("testType").toUpperCase().compareTo("WEB")==0) {
					System.out.println(prop.getProperty("testType"));
				}
				else if(prop.getProperty("testType").toUpperCase().compareTo("API")==0) {
					System.out.println(prop.getProperty("testType"));
				}
				else if(prop.getProperty("testType").toUpperCase().compareTo("MOBILE")==0) {
					System.out.println(prop.getProperty("testType"));
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}

package com.mplatform.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	public WebDriver driver;
	
	@BeforeTest
    public void testSetUp(String testType)
    {
    
    }
}

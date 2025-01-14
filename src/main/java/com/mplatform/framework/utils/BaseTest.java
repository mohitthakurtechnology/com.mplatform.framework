package com.mplatform.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.mplatform.framework.constants.TestTypes;

public class BaseTest 
{
	public WebDriver driver;
	@BeforeTest
    public void testSetUp(String testType)
    {
		if(testType.toUpperCase().compareTo(TestTypes.WEB.toString())==0) {
			System.out.println(testType);
		}
		else if(testType.toUpperCase().compareTo(TestTypes.API.toString())==0) {
			System.out.println(testType);
		}
		else if(testType.toUpperCase().compareTo(TestTypes.MOBILE.toString())==0) {
			System.out.println(testType);
		}
    }
}

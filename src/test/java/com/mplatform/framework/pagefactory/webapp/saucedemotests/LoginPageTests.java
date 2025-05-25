package com.mplatform.framework.pagefactory.webapp.saucedemotests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mplatform.framework.pagefactory.webapp.saucedemo.LoginPage;
import com.mplatform.framework.utils.MyListeners;


public class LoginPageTests extends MyListeners
{
	LoginPage loginpage;
	
    @Test
    public void loginTest()
    {
    	loginpage = new LoginPage(driver);
    	
    	loginpage.login(prop.getProperty("testid"), prop.getProperty("password"));
    	Assert.assertEquals(10,10);
    	extenttest.info("Inside Login Page Test");
    }
    @Test
    public void loginTest1()
    {
    	Assert.assertEquals(10,10);
    }
}
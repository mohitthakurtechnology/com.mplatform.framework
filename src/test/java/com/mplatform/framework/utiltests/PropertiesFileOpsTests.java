package com.mplatform.framework.utiltests;


import java.util.Properties;

import org.testng.annotations.Test;

import com.mplatform.framework.utils.PropertiesFileOps;


/**
 * Unit test for simple App.
 */
public class PropertiesFileOpsTests 
{
    @Test
    public void getconfigpropertytest()
    {
    	PropertiesFileOps propertiesfileopstests = new PropertiesFileOps();
    	Properties prop;
		prop = propertiesfileopstests.loadProperties("configs");
		System.out.println("config property of test type is => " + prop.get("testType"));
		System.out.println("config property of browser type is => " + prop.get("BrowserType"));
    }
}

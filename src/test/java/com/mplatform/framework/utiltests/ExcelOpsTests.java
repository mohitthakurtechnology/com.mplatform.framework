 package com.mplatform.framework.utiltests;

import org.testng.annotations.Test;

import com.mplatform.framework.utils.ExcelOps;

/**
 * Unit test for simple App.
 */
public class ExcelOpsTests 
{
    @Test
    public void getDataTest()
    {
    	Object[][] excelOps = ExcelOps.getData("testing");
    	for(int i = 0 ; i < excelOps.length;i++)
    	{
    		for(int j = 0;j < excelOps[i].length;j++)
    		{
    			System.out.println(excelOps[i][j]);
    		}
    	}
    	System.out.println("excel column count is => " + excelOps.length);
    }
}

package com.mplatform.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelOps 
{
    @SuppressWarnings("null")
	public static Object[][] getData(String xLFileName) 
    {

		Object[][] excelData = null;
		
    	try {
    
    			String filePath = System.getProperty("USER.DIR") + "C:\\Users\\mohit\\git\\com.mplatform.framework\\src\\test\\resources" + xLFileName;
				FileInputStream fis = new FileInputStream(filePath);
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet worksheet = workbook.getSheet(filePath);
				XSSFRow row;
				for(int i = 0;i < worksheet.getPhysicalNumberOfRows();i++)
				{
					row = worksheet.getRow(i);
					for(int j = 0;j < row.getPhysicalNumberOfCells();j++)
					{
						XSSFCell cell = row.getCell(j);
						excelData[i][j] = cell.getStringCellValue();
					}
				}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelData;                       	
    }
}

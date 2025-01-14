package com.mplatform.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ExcelOps 
{
    @SuppressWarnings("null")
	public static Object[][] getData(String xLFileName) 
    {

		Object[][] excelData = null;
		
    	try {
    			
    			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + xLFileName + ".xlsx";
				FileInputStream fis = new FileInputStream(filePath);
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet worksheet = workbook.getSheet("Test");
				XSSFRow row;
				excelData = new Object[worksheet.getPhysicalNumberOfRows()][worksheet.getRow(0).getPhysicalNumberOfCells()];
				for(int i = 0;i < worksheet.getPhysicalNumberOfRows();i++)
				{
					row = worksheet.getRow(i);
					for(int j = 0;j < row.getPhysicalNumberOfCells();j++)
					{
						XSSFCell cell = row.getCell(j);
						if(cell.getCellType()==CellType.STRING) {
								excelData[i][j] = cell.getStringCellValue();
							}
						else if(cell.getCellType()==CellType.NUMERIC){
							excelData[i][j] = cell.getNumericCellValue();
						}
					}
				}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelData;                       	
    }
}

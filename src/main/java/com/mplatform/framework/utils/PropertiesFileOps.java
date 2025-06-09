package com.mplatform.framework.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileOps {
	
	Properties prop;
	
	public Properties loadProperties(String fileName) {
		
		
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName + ".properties";
		System.out.println("filePath => " + filePath);
		try {
				FileInputStream fis = new FileInputStream(filePath);
				prop = new Properties();
				prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
package com.training.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FWFile 
{
	
	public String getDataFromProperty(String key) throws IOException
	{
		FileInputStream fisObj=new FileInputStream("./datasource/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fisObj);
		String value=pobj.getProperty(key);
		return value;
		
	}

}

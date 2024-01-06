package utils;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesFileReader {
	static Logger mylogger = LogManager.getLogger(PropertiesFileReader.class.getName());
	public static FileInputStream fis;
	static String locationPath;
	static Properties prop;
	public static String value=null;

	
	
	public static String getProperty(String key)
	{
		mylogger.info("Reading the Data from ProperyFile.Getting Value for Key: "+key);
		try 
		{
			locationPath 	= System.getProperty("user.dir")+"\\Resources\\propertyFile.properties";
			fis 			= new FileInputStream(locationPath);
			prop 			= new Properties();
			prop.load(fis);
			value 			= prop.getProperty(key);
			mylogger.info("Successfully Read the Data from Property File. KEY: "+key+ ", VALUE: "+value);
			
		}
		catch(Exception e)
		{
			mylogger.info("Exception Occured while Reading the data from the Properties File");
			mylogger.info("Key not Presnent in the Properties File: "+key);
			e.printStackTrace();
		}
		
		return value;
	
		
		
		
	}
	
	
	
	

}

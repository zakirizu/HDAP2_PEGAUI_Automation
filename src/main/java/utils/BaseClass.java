package utils;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import factory.Constants;

public class BaseClass {
	public static WebDriver driver;
	public static Logger mylogger 			= LogManager.getLogger(BaseClass.class.getName());	
	public static String browserType 		= null;
	public static String zoomPercent 		= null;
	
	static String scrReports 						= Constants.SCREENSHOT;
	
	
	public static WebDriver initializeDriver() {
		browserType 		= PropertiesFileReader.getUIProperty("browserType");
		zoomPercent 		= PropertiesFileReader.getUIProperty("zoom");
		int waitTime  			=  Integer.parseInt(PropertiesFileReader.getUIProperty("implicitWait"));	
		try 
		{
			if(browserType.equalsIgnoreCase("chrome"))
				{
					mylogger.info("Intializing the Browser type: "+browserType);
					driver = new ChromeDriver();					
				}
			else if(browserType.equalsIgnoreCase("ie"))
				{
					mylogger.info("Intializing the Browser type: "+browserType);
					driver = new InternetExplorerDriver();					
				}
			else if(browserType.equalsIgnoreCase("edge"))
				{
					mylogger.info("Intializing the Browser type: "+browserType);
				 	driver = new EdgeDriver();					 	
				}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	
		}
		
		catch(Exception e)
		{
			mylogger.info("Error While Initializing the Browser : "+browserType);
			e.printStackTrace();			
		}
		return driver;
}

	
	

	public static String takeScreenShot(String testCaseName) throws IOException {
	    TakesScreenshot ts 	= ((TakesScreenshot) driver);
		File source 					= ts.getScreenshotAs(OutputType.FILE);
		File file 						= new File(scrReports+testCaseName+".png");
		File desFile 				= new File(scrReports);
		FileUtils.copyFile(source, file);		
		return scrReports+testCaseName+".png";		
	}
	
	

	
	
}

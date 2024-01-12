package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.KeyWords;
import utils.PropertiesFileReader;


public class CommonBusinesFuncts {
	public static WebDriver driver ;
	public static Logger mylogger 	= LogManager.getLogger(CommonBusinesFuncts.class.getName());	
	

	
	public CommonBusinesFuncts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	

	


}

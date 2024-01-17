package stepDefinitionFile;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import factory.CommonBusinesFuncts;
import io.cucumber.java.en.Given;
import pages.RequestGroup_Pg;
import utils.KeyWords;
import utils.PropertiesFileReader;

public class ConfigureRequestGroupTask_SD {
	
	public static WebDriver     driver 			=   HooksCucumbers.Hookdriver;	
	KeyWords        			 		    keys			 	=   new KeyWords(driver);
	CommonBusinesFuncts      cbus				=   new CommonBusinesFuncts(driver);
	RequestGroup_Pg 			   rgpage 			=   new RequestGroup_Pg(driver);
	int 										waitTime  		=  Integer.parseInt(PropertiesFileReader.getProperty("implicitWait"));	
	static Logger 	myLogger 						= LogManager.getLogger(ConfigureRequestGroupTask_SD.class.getName());

	
	
	

	
	@Given("Click on the Work Tab")
	public void dummycode1() {
		System.out.println("Dummy Code 1");
		keys.clickElement(rgpage.getWorkTab());	
	}
	
	@Given("Click on the My WorkBasket Header")
	public void dummycode2() {
		System.out.println("Create RG Screen is displayed");
		keys.clickElement(rgpage.getMyWorkBasket());	
	
	}
	
	
	
	
	
	

}

package stepDefinitionFile;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import factory.CommonBusinesFuncts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.PG_ConfigureRequestGroupTask;
import pages.PG_Create_RG;
import pages.PG_RequestGroup;
import utils.KeyWords;
import utils.PropertiesFileReader;

public class SD_Create_RG {
	
	public static WebDriver     driver 			=   HooksCucumbers.Hookdriver;	
	KeyWords        			 		    keys			 	=   new KeyWords(driver);
	CommonBusinesFuncts      cbus				=   new CommonBusinesFuncts(driver);
	PG_Create_RG					createRg 		= new PG_Create_RG(driver);
	int 										waitTime  		=  Integer.parseInt(PropertiesFileReader.getUIProperty("implicitWait"));	
	static Logger 	myLogger 						= LogManager.getLogger(SD_Create_RG.class.getName());
	
	@Given("Click on CreateRGButton")
	public void Click_on_CreateRGButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		keys.clickElement(createRg.getBtn_createRG());
	}
	
	@Then("Switch to CreateRG Fame")
	public void switchToCreateRGFrame() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		keys.switchFrameByWebElement(createRg.getFrame_CreateRG());
	}
		
	@Then("Click on NextButton")
	public void Click_On_Next_Button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		keys.clickElement(createRg.getBtn_Next());
	}
	
	



}

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
import pages.ConfigureRequestGroupTask_Pg;
import pages.RequestGroup_Pg;
import utils.KeyWords;
import utils.PropertiesFileReader;

public class ConfigureRequestGroupTask_SD {
	
	public static WebDriver     driver 			=   HooksCucumbers.Hookdriver;	
	KeyWords        			 		    keys			 	=   new KeyWords(driver);
	CommonBusinesFuncts      cbus				=   new CommonBusinesFuncts(driver);
	RequestGroup_Pg 			   rgpage 			=   new RequestGroup_Pg(driver);
	ConfigureRequestGroupTask_Pg crgpage = new ConfigureRequestGroupTask_Pg(driver);
	int 										waitTime  		=  Integer.parseInt(PropertiesFileReader.getProperty("implicitWait"));	
	static Logger 	myLogger 						= LogManager.getLogger(ConfigureRequestGroupTask_SD.class.getName());

	
	
	
	@Given("Launch the application URL")
	public void LaunchTheApplicationURL() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		keys.switchFrameByWebElement(rgpage.getIframeHomePage());
		
	}
	
	@Then("Click ont he MyWorkbasekt")
	public void Click_On_the_My_Workbasekt() {
		keys.clickElement(null);
	}
	
	@Given("Click on the Work Tab")
	public void Click_on_the_Work_Tab() {
		keys.clickElement(rgpage.getWorkTab());	
	}
	
	@Then("Click on the My WorkBasket Header")
	public void Click_On_My_Workbasket_Header() {
		keys.clickElement(rgpage.getMyWorkBasket());	
	}
	
	@Then("Switch to the RG Frame")
	public void Switch_To_Frame() {
		keys.switchToDefaultContent();
		keys.switchFrameByWebElement(crgpage.getRGTabFrame());	
	}
	
	@Then("Click on the First Available RG")
	public void Click_on_the_First_Available_RG() {
		keys.clickElement(crgpage.getFirstRGfromWB());	
	}
	
	@Then("Hold For half min")
	public void Hold_For_Half_min() throws InterruptedException {
		keys.shortWait();
	}
	
	@And("Click on the Request Group Settings Tab")
	public void Click_on_the_Request_Group_Settings_Tab() {
		keys.clickElement(crgpage.getRequestGroupSettingsTab());
	}
	
	
	@And("Click on the Add Task Button")
	public void Click_on_the_Add_Task_Button() {
	
	}
	
	
	@And("click on UploadMR Button")
	public void click_on_UploadMR_Button() {
		keys.clickElement(crgpage.getUploadMRButton());
		
	}
	

}

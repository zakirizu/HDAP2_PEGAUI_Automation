package stepDefinitionFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Create_RG_Pg;
import utils.KeyWords;


public class Create_RG_Sd {
	
	public static WebDriver     driver 			=   HooksCucumbers.Hookdriver;	
	KeyWords        			 		    keys			 	=   new KeyWords(driver);
	static Logger 						myLogger 	= LogManager.getLogger(Create_RG_Sd.class.getName());
	
	//Create Pages for only the elements which you are using here
	Create_RG_Pg					createRg 		= new Create_RG_Pg(driver);
	
	@Given("Click on CreateRGButton")
	public void Click_on_CreateRGButton() {		
		keys.clickElement(createRg.getBtn_createRG());
	}
	
	@Then("Switch to CreateRG Fame")
	public void switchToCreateRGFrame() {
		keys.switchFrameByWebElement(createRg.getFrame_CreateRG());
	}
		
	@Then("Click on NextButton")
	public void Click_On_Next_Button() {
		keys.clickElement(createRg.getBtn_Next());
	}
	




}

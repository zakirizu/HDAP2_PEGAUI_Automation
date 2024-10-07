package stepDefinitionFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Create_RG_Pg;
import utils.DependencyInjection;
import utils.KeyWords;


public class Create_RG_Sd {
	
    public DependencyInjection obj;
    Scenario s;
	public Create_RG_Sd(DependencyInjection obj)
	{
		this.obj = obj;
	}

	
	
	static Logger 						myLogger 	= LogManager.getLogger(Create_RG_Sd.class.getName());
		
	//Create Pages for only the elements which you are using here
	
	
	@Given("Click on CreateRGButton")
	public void Click_on_CreateRGButton() {	
		System.out.println("ZR-"+obj.driver);
		obj.getKeyWords().switchToDefaultContent();		
		obj.getKeyWords().clickElement(obj.getPageCreateRG().getBtn_createRG());
		
	}
	
	@Then("Switch to CreateRG Fame")
	public void switchToCreateRGFrame() {
		obj.getKeyWords().switchFrameByWebElement(obj.getPageCreateRG().getFrame_CreateRG());
	}
		
	@Then("Click on NextButton")
	public void Click_On_Next_Button() {
		obj.getKeyWords().clickElement(obj.getPageCreateRG().getBtn_Next());
	}
	




}

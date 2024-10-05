package stepDefinitionFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Common_Business_Functions_Pg;
import pages.RequestGroup_Pg;
import utils.KeyWords;
import utils.PropertiesFileReader;



/**
 * Common functions that can be used across the Create RG 
 * 
 * Function that will take input as Request ID and Open that RG
 * Function that will take input as task name and create that task
 * Give an RG I should be able to filter with RG ID on Work List
 * Give an RG I should be able to filter with RG ID on Work List
 * Give an RG I should be able to filter with RG ID on Work Basket
 * Give an RG I should be able to filter with RG ID on Work Basket
 * 
 * 
 * 
 * 
 * 
 * */






public class Common_Business_Functions_Sd {
	
	public static WebDriver     driver 			=   HooksCucumbers.Hookdriver;	
	KeyWords        			 		    keys			 	=   new KeyWords(driver);
	int 										waitTime  		=  Integer.parseInt(PropertiesFileReader.getUIProperty("implicitWait"));	
	static Logger 	myLogger 						= LogManager.getLogger(Common_Business_Functions_Sd.class.getName());
	
	
	//Create Pages for only the elements which you are using here
	RequestGroup_Pg 			   rgpage 			=   new RequestGroup_Pg(driver);
	Common_Business_Functions_Pg crgpage = new Common_Business_Functions_Pg(driver);


	
	
	@Then("Search for the RG ID {string}")
	public void searchFoRGID(String value) {
		keys.clickElement(crgpage.getSearchButtonTab());
		keys.sendKeys(crgpage.getRequestGroupIDSearchTextBox(), value);
		keys.clickElement(crgpage.getSearchButtonInSearchSection());
	}
	
	
	@Given("Click on the Work Tab")
	public void Click_on_the_Work_Tab() {
		keys.clickElement(rgpage.getWorkTab());	
	}
	
	
	@Then("Click on the My WorkList Header")
	public void Click_On_My_WorkList_Header() {
			keys.clickElement(rgpage.getmyWorkList());	
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
	
	@Then("Switch to the Second Frame")
	public void Switch_To_SecondFrame() {
		keys.switchToDefaultContent();
		keys.switchFrameByWebElement(crgpage.getSecondFrame());	
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
	
	
	public static String getUniqueRandomText() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss sss");
		String stringDate = DateFor.format(date);
		String RandomText = ((stringDate.replace(" ", "")).replace(",", "")).replace(":", "");
		System.out.println(RandomText);	
		return RandomText;
	
	}
	
	public static String  getUniqueRandomInteger() {
		
		int  rand = ThreadLocalRandom.current().nextInt();
		String temp = Integer.toString(rand);
		return temp;
	
	}
}

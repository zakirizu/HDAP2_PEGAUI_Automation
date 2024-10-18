package stepDefinitionFile;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import factory.ReadDataFromExcel;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

//Add this piece of code to read data from Excel Sheet. Change the Sheet Name
	HashMap<String,String> testData;	
	@Then("^Read ExcelData from CreateRGSheet  for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet( String TestCaseID) {		
		testData = ReadDataFromExcel.getExcelData("createRG", TestCaseID);
		return testData;		
	}
		
	@Given("Click on CreateRGButton")
	public void Click_on_CreateRGButton() {	
		obj.keyWords().switchToDefaultContent();		
		obj.keyWords().clickElement(obj.getPageCreateRG().getBtn_createRG());		
		obj.driver.switchTo().frame(obj.getPageCreateRG().getFrame_CreateRG());
		
		//obj.keyWords().switchFrameByWebElement(obj.getPageCreateRG().getFrame_CreateRG());		
	}
	
	@Then("Switch to CreateRG Fame")
	public void switchToCreateRGFrame() {
		obj.keyWords().switchFrameByWebElement(obj.getPageCreateRG().getFrame_CreateRG());
	}
		
	@Then("Click on NextButton")
	public void Click_On_Next_Button() {
		obj.keyWords().clickElement(obj.getPageCreateRG().getBtn_Next());
	}
	
	@Then("Under Contact section Add a Single Contact")
	public void AddaSingleContact() throws InterruptedException {
		obj.keyWords().clickElement(obj.getPageCreateRG().getAddContact_btn());
		obj.keyWords().selectByValue(obj.getPageCreateRG().getContactType_ddl(), testData.get("contactType"));
		obj.keyWords().selectByValue(obj.getPageCreateRG().getDepartment_ddl(), testData.get("department"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getName_txtbox(),testData.get("name"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRole_txtbox(),testData.get("role"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getEmail_txtbox(),testData.get("email"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getPhone_txtbox(),testData.get("phone"));
		obj.getPageCreateRG().getPhone_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		obj.keyWords().sendKeys(obj.getPageCreateRG().getExt_txtbox(),testData.get("ext"));
		obj.getPageCreateRG().getExt_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getFax_txtbox(),testData.get("fax"));		
		obj.getPageCreateRG().getFax_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getPreferred_method_txtbox(), testData.get("preferredMethod"));	
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezone_ddl(), testData.get("timeZoneContact"));	
		Thread.sleep(6000);
		obj.keyWords().clickElement(obj.getPageCreateRG().getcustomerAccSummary_btn());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContacts_Nextbtn());
	
		
	}

	
	@Then("Enter Data in the  Request Group Settings section")
	public void EnterDataintheRequestGroupSettingssection() throws InterruptedException {
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));
		
		
	}

	
	
	

}

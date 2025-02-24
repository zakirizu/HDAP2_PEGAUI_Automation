package stepDefinitionFile;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import factory.Constants;
import factory.*;
import io.cucumber.java.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Common_Functions_Pg;
import utils.BaseClass;
import utils.DependencyInjection;
import utils.KeyWords;

/**---------------------------------------------- RULES ------------------------------
 * Write the Xpath here itself as these are common functions and canBe and willBe used by other features
 * Common functions that can be used across the Create RG 
 * Function that will take input as Request ID and Open that RG
 * Function that will take input as task name and create that task
 * Give an RG I should be able to filter with RG ID on Work List
 * Give an RG I should be able to filter with RG ID on Work List
 * Give an RG I should be able to filter with RG ID on Work Basket
 * Give an RG I should be able to filter with RG ID on Work Basket
 * 
 * */
public class ProjectLaunches_Sd {
	Scenario scn;
    public WebDriver driver = null;   
    public DependencyInjection obj;
	public ProjectLaunches_Sd(DependencyInjection obj)
	{
		this.obj = obj;
	}
	
	static Logger 					myLogger 		= LogManager.getLogger(ProjectLaunches_Sd.class.getName());

	//Add this piece of code to read data from Excel Sheet. Change the Sheet Name
		HashMap<String,String> testData;	
		@Then("^Read ExcelData from projectLaunchSheet  for  (.+)$")
		public HashMap<String, String> ReadExcelSheetDataFromSheet( String TestCaseID) {		
			testData = getExcelData.UI_Sheet_Data("preLaunch", TestCaseID);
			return testData;		
		}
	
	@Given("User Clicks on the Project Launches Tab")
	public void UserClicksontheProjectLaunchesTab() {		
		obj.keyWords().clickElement(obj.getProjectLaunches_Pg().getQA_Retrieval_btn());
		obj.keyWords().clickElement(obj.getProjectLaunches_Pg().getSwitchRole_btn());
		obj.keyWords().clickElement(obj.getProjectLaunches_Pg().getHDAP_Admin_btn());
	}
	
	
		
	
}


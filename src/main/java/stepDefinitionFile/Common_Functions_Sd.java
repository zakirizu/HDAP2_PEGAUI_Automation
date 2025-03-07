package stepDefinitionFile;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class Common_Functions_Sd {
	
	static Logger 					myLogger 		= LogManager.getLogger(Common_Functions_Sd.class.getName());
	Scenario scn;
    public WebDriver driver = null;   
    public DependencyInjection obj;
	public Common_Functions_Sd(DependencyInjection obj)
	{
		this.obj = obj;
	}
		
	@Then("Launch the Application")
	public void te() throws InterruptedException {		
		driver = BaseClass.initializeDriver();
		obj.setDriver(driver);
		obj.initializePageObject(driver, scn);
		obj.keyWords().loginApplicaiton();
	}
	
			
	@Then("^Search for the User RG ID (.+)$")
	public void searchFoRGID(String value) throws InterruptedException {
		
	//	obj.getKeyWords().switchFrameByWebElement(obj.getPagecommon().getFramefirstFrame());
		getDynamicFrame("0");//if not working delete this code
		obj.keyWords().clickElement(obj.getPagecommon().getSearchButtonTab());
		obj.keyWords().sendKeys(obj.getPagecommon().getRequestGroupIDSearchTextBox(), value);
		obj.keyWords().clickElement(obj.getPagecommon().getSearchButtonInSearchSection());
		obj.keyWords().clickElement(obj.getPagecommon().getclickFirstRG());		
		}
	
	
	@Then("^Add the task (.+)$")
	public void addTask(String value) throws InterruptedException {
		obj.keyWords().switchToDefaultContent();
		getDynamicFrame("1");//if not working delete this code
		//obj.getKeyWords().switchFrameByWebElement(obj.getPagecommon().getSecondFrame());
		obj.keyWords().clickElement(obj.getPagecommon().getAddTaskBtn());
		obj.keyWords().clickElement(obj.getPagecommon().dynamic_AddTask(value));
		obj.keyWords().clickElement(obj.getPagecommon().getbtn_addTasks());
		}

	@Then("Switch to the RG Frame")
	public void Switch_To_Frame() {
		obj.keyWords().switchToDefaultContent();
		obj.keyWords().switchFrameByWebElement(obj.getPagecommon().getRGTabFrame());	
	}
	
	@Then("Switch to the Second Frame")
	public void Switch_To_SecondFrame() {
		obj.keyWords().switchToDefaultContent();
		obj.keyWords().switchFrameByWebElement(obj.getPagecommon().getSecondFrame());	
	}
	

	@Then("Click on the First Available RG")
	public void Click_on_the_First_Available_RG() {
		obj.keyWords().clickElement(obj.getPagecommon().getFirstRGfromWB());	
	}
	
	@Then("Hold For half min")
	public void Hold_For_Half_min() throws InterruptedException {
		obj.keyWords().shortWait();
	}
	
	@And("Click on the Request Group Settings Tab")
	public void Click_on_the_Request_Group_Settings_Tab() {
		obj.keyWords().clickElement(obj.getPagecommon().getRequestGroupSettingsTab());
	}

	@Given("^Read ExcelData from (.+) and (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet(String SheetName, String TestCaseID) {		
		HashMap<String,String> testData = getExcelData.UI_Sheet_Data(SheetName, TestCaseID);
		 return testData;		
	}
	

	@And("click on UploadMR Button")
	public void click_on_UploadMR_Button() {
		obj.keyWords().clickElement(obj.getPagecommon().getUploadMRButton());		
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
        Random random = new Random();
        long randomNumber = 1_000_000_000L + random.nextLong();	         
        String  x = Long.toString(randomNumber);
        String  temp = x.replaceAll("-", "");
        return temp;
	}	

	public static String currentDateTimeMilliSeconds() {
		String stringDate ="";
		try {	
			Thread.sleep(50);
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		stringDate = DateFor.format(date);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return stringDate;
	}
	
	
	
	/*
	 *Desgined By: Shaik Zakir Hussain
	 * This function can be used to enter data into the Next Review Date.
	 * Input: Days
	 * Outputs: Current Date + Number of Input dates given
	 */
	
	
	public static String getNextReviewDate(int x)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, x); // Adding 5 days
		String date = sdf.format(c.getTime());
		return date;
	}
	
	
	
	public void getDynamicFrame(String id) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//iframe[@id='PegaGadget"+id+"Ifr']"));
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
	}
	
	
	
	
	
	/**********************************************************************************************************/
	/************************************HOOK OPERATIONS*****************************************************/
	/**********************************************************************************************************/
	@Before
	public void SetUp(Scenario s)
	{
		this.scn = s;
	}
	
	@After
	public void afterScenarios(Scenario scenario) throws  NullPointerException {

		if (scenario.isFailed()) {
           try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "FAILED Scenario Screenshot");
                driver.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
	       else
	    	   try {    { 
	                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", "PASSED  Scenario Screenshot");
	                driver.close();
           }
        driver.quit();  // Closing the browser after scenario
           }catch(Exception e) {
        	   System.out.println("Driver not initiated");
           }
}
}
	


package stepDefinitionFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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
import io.cucumber.java.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
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
	Scenario scn;
    public WebDriver driver = null;   
    //KeyWords keys;
    //Common_Functions_Pg commo;  
	

    public DependencyInjection obj;
	public Common_Functions_Sd(DependencyInjection obj)
	{
		this.obj = obj;
	}
	
	static Logger 					myLogger 		= LogManager.getLogger(Common_Functions_Sd.class.getName());
	//Create Pages for only the elements which you are using here

		
	@Then("Launch the Application")
	public void te() throws InterruptedException {		
		driver = BaseClass.initializeDriver();
		obj.setDriver(driver);
		obj.initializePageObject(driver, scn);
		obj.getKeyWords().loginApplicaiton();
	}
	
			
	@Then("^Search for the User RG ID (.+)$")
	public void searchFoRGID(String value) throws InterruptedException {
		//obj.driver.switchTo().frame(obj.getPagecommon().getFramefirstFrame());
		obj.getKeyWords().switchFrameByWebElement(obj.getPagecommon().getFramefirstFrame());
		obj.getKeyWords().clickElement(obj.getPagecommon().getSearchButtonTab());
		obj.getKeyWords().sendKeys(obj.getPagecommon().getRequestGroupIDSearchTextBox(), value);
		obj.getKeyWords().clickElement(obj.getPagecommon().getSearchButtonInSearchSection());
		obj.getKeyWords().clickElement(obj.getPagecommon().getclickFirstRG());		
		}
	
	
	@Then("^Add the task (.+)$")
	public void addTask(String value) throws InterruptedException {
		obj.getKeyWords().switchToDefaultContent();
		obj.getKeyWords().switchFrameByWebElement(obj.getPagecommon().getSecondFrame());
		obj.getKeyWords().clickElement(obj.getPagecommon().getAddTaskBtn());
		obj.getKeyWords().clickElement(obj.getPagecommon().dynamic_AddTask(value));
		obj.getKeyWords().clickElement(obj.getPagecommon().getbtn_addTasks());
		}

	@Then("Switch to the RG Frame")
	public void Switch_To_Frame() {
		obj.getKeyWords().switchToDefaultContent();
		obj.getKeyWords().switchFrameByWebElement(obj.getPagecommon().getRGTabFrame());	
	}
	
	@Then("Switch to the Second Frame")
	public void Switch_To_SecondFrame() {
		obj.getKeyWords().switchToDefaultContent();
		obj.getKeyWords().switchFrameByWebElement(obj.getPagecommon().getSecondFrame());	
	}
	

	@Then("Click on the First Available RG")
	public void Click_on_the_First_Available_RG() {
		obj.getKeyWords().clickElement(obj.getPagecommon().getFirstRGfromWB());	
	}
	
	@Then("Hold For half min")
	public void Hold_For_Half_min() throws InterruptedException {
		obj.getKeyWords().shortWait();
	}
	
	@And("Click on the Request Group Settings Tab")
	public void Click_on_the_Request_Group_Settings_Tab() {
		obj.getKeyWords().clickElement(obj.getPagecommon().getRequestGroupSettingsTab());
	}
	
	

	@And("click on UploadMR Button")
	public void click_on_UploadMR_Button() {
		obj.getKeyWords().clickElement(obj.getPagecommon().getUploadMRButton());		
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
	
	
	
	
	/**********************************************************************************************************/
	/************************************HOOK OPERATIONS*****************************************************/
	/**********************************************************************************************************/
	@Before
	public void SetUp(Scenario s)
	{
		this.scn = s;
	}
	
	@After
	public void afterScenarios(Scenario s) throws InterruptedException {
		if(s.isFailed())
		{
			TakesScreenshot  scrShot  = ((TakesScreenshot) driver);
			byte[] data = scrShot.getScreenshotAs(OutputType.BYTES);
			//scn.embed(data,"iamge/png");	
		}
		driver.quit();
		}


}

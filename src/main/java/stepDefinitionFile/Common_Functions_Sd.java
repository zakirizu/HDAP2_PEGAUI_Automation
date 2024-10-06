package stepDefinitionFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
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
    public WebDriver driver;
    public DependencyInjection di;
    KeyWords keys;
    Common_Functions_Pg commo;  

	public Common_Functions_Sd(DependencyInjection di)
	{
		this.di = di;
	}
	
	static Logger 					myLogger 		= LogManager.getLogger(Common_Functions_Sd.class.getName());
	//Create Pages for only the elements which you are using here

		
	@Then("Launch the Application")
	public void te() throws InterruptedException {		
		di.driver = BaseClass.initializeDriver();
		keys = new KeyWords(di.driver);
		commo = new Common_Functions_Pg(di.driver);
		keys.loginApplicaiton();
	}
	
			
	@Then("^Search for the User RG ID (.+)$")
	public void searchFoRGID(String value) throws InterruptedException {
		keys.switchFrameByWebElement(commo.getFramefirstFrame());
		keys.clickElement(commo.getSearchButtonTab());
		keys.sendKeys(commo.getRequestGroupIDSearchTextBox(), value);
		keys.clickElement(commo.getSearchButtonInSearchSection());
		keys.clickElement(commo.getclickFirstRG());
		}
	
	
	@Then("^Add the task (.+)$")
	public void addTask(String value) throws InterruptedException {
		keys.switchToDefaultContent();
		keys.switchFrameByWebElement(commo.getSecondFrame());
		keys.clickElement(commo.getAddTaskBtn());
		keys.clickElement(commo.dynamic_AddTask(value));
		keys.clickElement(commo.getbtn_addTasks());
		Thread.sleep(5000);
		}
	

	@Then("Switch to the RG Frame")
	public void Switch_To_Frame() {
		keys.switchToDefaultContent();
		keys.switchFrameByWebElement(commo.getRGTabFrame());	
	}
	
	@Then("Switch to the Second Frame")
	public void Switch_To_SecondFrame() {
		keys.switchToDefaultContent();
		keys.switchFrameByWebElement(commo.getSecondFrame());	
	}
	

	@Then("Click on the First Available RG")
	public void Click_on_the_First_Available_RG() {
		keys.clickElement(commo.getFirstRGfromWB());	
	}
	
	@Then("Hold For half min")
	public void Hold_For_Half_min() throws InterruptedException {
		keys.shortWait();
	}
	
	@And("Click on the Request Group Settings Tab")
	public void Click_on_the_Request_Group_Settings_Tab() {
		keys.clickElement(commo.getRequestGroupSettingsTab());
	}
	
	

	@And("click on UploadMR Button")
	public void click_on_UploadMR_Button() {
		keys.clickElement(commo.getUploadMRButton());		
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

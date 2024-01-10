package stepDefinitionFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.KeyWords;
import utils.PropertiesFileReader;
import utils.BaseClass;

public class Z_CommonBusinessFunctions extends BaseClass{
	
	public static WebDriver driver ;
	static KeyWords keyWord 			= new KeyWords(driver);
	static Logger myLogger 				= LogManager.getLogger(Z_CommonBusinessFunctions.class.getName());
	String Environment 						= PropertiesFileReader.getProperty("Env");
	
	
	
	
	public  void loginApplicaiton() throws InterruptedException {
		
		try 
		{
			if(Environment.equalsIgnoreCase("QA"))
				{
				mylogger.info("Error While Initializing the BrowserType : "+browserType +". Environment:"+Environment);
				driver.get(utils.PropertiesFileReader.getProperty("QA_URL"));			
				keyWord.shortWait();
				keyWord.sendKeys(getUserName_txtBox(), PropertiesFileReader.getProperty("QA_UserID"));
				keyWord.sendKeys(passWord_txtBox, PropertiesFileReader.getProperty("QA_Pwd"));
				keyWord.shortWait();
				keyWord.clickElement(getLogin_Button());
					
				}
			else if(Environment.equalsIgnoreCase("UAT"))
				{
				driver.get(utils.PropertiesFileReader.getProperty("UAT_URL"));		
				keyWord.sendKeys(getUserName_txtBox(), PropertiesFileReader.getProperty("UAT_UserID"));
				keyWord.sendKeys(passWord_txtBox, PropertiesFileReader.getProperty("UAT_Pwd"));
				keyWord.clickElement(getLogin_Button());
					
				}
			else if(Environment.equalsIgnoreCase("PROD"))
				{
				driver.get(utils.PropertiesFileReader.getProperty("PROD_URL"));		
				keyWord.sendKeys(getUserName_txtBox(), PropertiesFileReader.getProperty("PROD_UserID"));
				keyWord.sendKeys(passWord_txtBox, PropertiesFileReader.getProperty("PROD_Pwd"));
				keyWord.clickElement(getLogin_Button());
							 	
				}	
		}
		
		catch(Exception e)
		{
			mylogger.info("Error While Initializing the BrowserType : "+browserType +". Environment:"+Environment);
			e.printStackTrace();			
		}
		
		
		}
	
	//WebElemets
	
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement UserName_txtBox;
	public static WebElement getUserName_txtBox() {
		return UserName_txtBox;
	}
		
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement Login_Button;
	public static WebElement getLogin_Button() {
		return Login_Button;
	}
	
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement passWord_txtBox;
	public static WebElement getPassWord_txtBox() {
		return passWord_txtBox;
	}
	


}

package utils;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import pages.*;

public class DependencyInjection {
	
	public WebDriver driver;	
	Common_Functions_Pg pagecommon;
	Create_RG_Pg                    pageCreateRG;
	DQA_Task_Pg						pageDQATask;
	KeyWords 							keys;
	
	
	public WebDriver getDriver() {
		return driver;
	}
	public Common_Functions_Pg getPagecommon() {
		return pagecommon;
	}
	public Create_RG_Pg getPageCreateRG() {
		return pageCreateRG;
	}
	public DQA_Task_Pg getPageDQATask() {
		return pageDQATask;
	}
	public KeyWords getKeyWords() {
		return keys;
	}
	
	public void initializePageObject(WebDriver driver, Scenario s) {
		
		 pagecommon		= new  Common_Functions_Pg(driver, s);
		 pageCreateRG		=  new Create_RG_Pg(driver, s);
		 pageDQATask 		= new DQA_Task_Pg(driver, s);
		 keys 							= new KeyWords(driver);
		
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
}
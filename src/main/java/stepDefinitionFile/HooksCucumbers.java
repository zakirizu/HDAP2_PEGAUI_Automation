package stepDefinitionFile;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseClass;
import utils.KeyWords;

public class HooksCucumbers {
	public static WebDriver Hookdriver;
	
	
	// This code will run before every scenarios across all the Scen and feature files
	@Before
	public void beforeHookCode() throws InterruptedException {
		Hookdriver = BaseClass.initializeDriver();	
	//	SD_Common_Business_Functions cb = new SD_Common_Business_Functions(Hookdriver);
		KeyWords keyWord 			= new KeyWords(Hookdriver);		
		keyWord.loginApplicaiton();		
		}
	
	@After
	public void afterHookCode() throws InterruptedException {
		Thread.sleep(2000);
		Hookdriver.quit();	
	}
	
	
	@Before("@testAfterHook")
	public void testAfterHook() {
		System.out.println("Before Hook : Test Hook scenario");
	}
	
	@After("testAfterHook")
	public void testBeforeHook() {
		System.out.println("After Hook : Test Hook Scenario");
	}
	

}

package stepDefinitionFile;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseClass;

public class Z_HooksCucumbers {
	public static WebDriver Hookdriver;
	
	
	// This code will run before every scenarios across all the Scen and feature files
	@Before
	public void beforeHookCode() {
		Hookdriver = BaseClass.initializeDriver();		
		System.out.println("Hook Loplala Driver: "+Hookdriver);
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

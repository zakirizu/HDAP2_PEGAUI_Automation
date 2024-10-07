package stepDefinitionFile;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DependencyInjection;


public class HooksCucumbers {
	DependencyInjection di;
	public HooksCucumbers(DependencyInjection di)
	{
		this.di = di;
	}
	
	
	// This code will run before every scenarios across all the Scen and feature files
	@Before
	public void beforeHookCode() throws InterruptedException {
	//	Hookdriver = BaseClass.initializeDriver();	
		//KeyWords keyWord 			= new KeyWords(Hookdriver);		
	//	keyWord.loginApplicaiton();		
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

package stepDefinitionFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	
	@After
	public void afterHookCode() throws InterruptedException {
		Thread.sleep(2000);
		//di.driver.close();
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

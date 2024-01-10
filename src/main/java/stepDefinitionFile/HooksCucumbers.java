package stepDefinitionFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksCucumbers {
	
	
	// This code will run before every scenarios across all the Scen and feature files
	@Before
	public void beforeHookCode() {
		System.out.println("Before Hook : Common for every scenario");
	}
	
	@After
	public void afterHookCode() {
		System.out.println("After Hook : Common for every scenario");
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

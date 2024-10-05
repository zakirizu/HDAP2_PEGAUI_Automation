package stepDefinitionFile;
import static io.restassured.RestAssured.given;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import factory.CommonBusinesFuncts;
import factory.PropertiesData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import pages.ConfigureRequestGroupTask_Pg;
import pages.RequestGroup_Pg;
import utils.KeyWords;
import utils.PropertiesFileReader;

public class API_Create_Chase_Requests {
	
	public static WebDriver     driver 			=   HooksCucumbers.Hookdriver;	
	KeyWords        			 		    keys			 	=   new KeyWords(driver);
	CommonBusinesFuncts      cbus				=   new CommonBusinesFuncts(driver);
	RequestGroup_Pg 			   rgpage 			=   new RequestGroup_Pg(driver);
	ConfigureRequestGroupTask_Pg crgpage = new ConfigureRequestGroupTask_Pg(driver);
	int 										waitTime  		=  Integer.parseInt(PropertiesFileReader.getProperty("implicitWait"));	
	static Logger 	myLogger 						= LogManager.getLogger(API_Create_Chase_Requests.class.getName());

	
	
	
	@Given("Enter the count of Request you want to create {int}")
	public void PendingRGAssignment(int x) {
		for(int i =0;i<x;i++)
		{
		 String endPoint 				= PropertiesData.getAPIProperty("chaseRequest_url");
		 String resource			 	= PropertiesData.getAPIProperty("chaseRequest_resource");
		 String intendedUse		= PropertiesData.getAPIProperty("intendedUse");
		 String accountID			= PropertiesData.getAPIProperty("AccountID");
		 String subAccountID		= PropertiesData.getAPIProperty("SubAccountID");

	    String cotivitClaimNumber = factory.ReUsableMethods.getUniqueRandomInteger();
	    System.out.println("*******************************Creating Chase Request NO Matching Single RG with Below Combination*****************************");
		System.out.println("Intended Use------------------------->" +intendedUse);
		System.out.println("Account ID---------------------------->" +accountID);
		System.out.println("Sub Account ID----------------------->" +subAccountID);
		System.out.println("Cotiviti Claim Number-------------->" +cotivitClaimNumber);			
		System.out.println("<----------RESPONSE BODY--------->");
	

		RestAssured.baseURI = endPoint;
	//	JsonPath js =
				given()//.log().all()
				.header("Content-Type","application/json")
				.body(HDAP_PayLoads.ChaseRequest_PayLoads.payLoad_With_No_Matching_RG(intendedUse, accountID, subAccountID, cotivitClaimNumber))
				
				.when()
				.post(resource)
				
				.then().log().body(true)
				.assertThat().statusCode(202)
				.extract().response().jsonPath();			
	}
	

	}
	

}

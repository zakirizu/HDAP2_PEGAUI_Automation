package APIs;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.ReadDataFromExcel;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class Create_PreLaunch_Requests {

	//static HashMap<String, String> testData = ReadDataFromExcel.getExcelData("createRG", TestCaseID);
	static String endPoint = PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse = PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID = PropertiesFileReader.getAPIProperty("AccountID");
	static String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");
	static String authtoken = Create_PendingRGAssignment_Requests.Create_Auth();
	
	
/*
	@Test(invocationCount = 150)
	public static void ChaseRequest_With_Single_Matching_RG_01() throws InterruptedException {
		String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
		System.out.println(
				"*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
		System.out.println("Intended Use-------------------------->" + intendedUse);
		System.out.println("Account ID---------------------------->" + accountID);
		System.out.println("Sub Account ID----------------------->" + subAccountID);
		System.out.println("Cotiviti Claim Number--------------->" + cotivitClaimNumber);
		System.out.println("<----------RESPONSE BODY--------->");

		RestAssured.baseURI = endPoint;
		// JsonPath js =
		given()// .log().all()
		.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_Single_Matching_RG(intendedUse, accountID,	subAccountID, cotivitClaimNumber))
				.when().post(resource)
				.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
	}
	*/
	
	@Test(invocationCount = 48, dataProvider = "50Set_testdata")
	public static void bulkCreate(String accountID, String  intendedUse  ) throws InterruptedException {
		String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
		System.out.println(
				"*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
		System.out.println("Intended Use-------------------------->" + intendedUse);
		System.out.println("Account ID---------------------------->" + accountID);
		System.out.println("Sub Account ID----------------------->" + subAccountID);
		System.out.println("Cotiviti Claim Number--------------->" + cotivitClaimNumber);
		System.out.println("<----------RESPONSE BODY--------->");

		RestAssured.baseURI = endPoint;
		// JsonPath js =
		given()// .log().all()
		.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_Single_Matching_RG(intendedUse, accountID,	subAccountID, cotivitClaimNumber))
				.when().post(resource)
				.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
	}
	
	 @DataProvider (name = "50Set_testdata")
     public Object[][] dpMethod(){
	 return new Object[][] {
		 {"P610", "HEDIS"},
		 {"P610", "CCV"},
		 {"P610", "CV"},
		 {"P610", "MRA"},
		 {"P610", "CRA"},
		 {"P610", "CPR"},
		 {"P610", "RADV"},
		 {"J667", "RCA"},
		 {"J667", "HEDIS"},
		 {"J667", "CCV"},		 
	 };
     }

     }
	
	
	



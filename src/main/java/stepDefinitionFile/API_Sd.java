package stepDefinitionFile;
import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.StringUtils;

import factory.COLORS;
import factory.getExcelData;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;
import utils_API.GET_Facility_API;
import utils_API.GET_Practitioner_API;
import utils_API.GET_RequestGroup_API;
import utils_API.Generate_OAuth2;



public class API_Sd {
	static String env = PropertiesFileReader.getAPIProperty("env");
	HashMap<String, String> testData;
	static String authtoken;
    // Extract other values from testData
	static String auditType = PropertiesFileReader.getAPIProperty("AuditType");
	static String chartType = PropertiesFileReader.getAPIProperty("ChartType");
	static String DOS = PropertiesFileReader.getAPIProperty("DateOfStart");
	static String DOE = PropertiesFileReader.getAPIProperty("DateOfEnd");
	ConcurrentHashMap<String, String> dataMap; 
	
	@Given("^Read ExcelData from API_Sheet for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet(String TestCaseID) {
	testData = getExcelData.API_Sheet_Data("ChaseData", TestCaseID);
	System.out.println(testData);
	return testData;
	}
	
	@Given("^Get the Data from the Request Group$")
	public void GettheDatafromtheRequestGroup() {
		String requestGroup 	= testData.get("RGID");
		String env 					= testData.get("Environment");
		String accountID 			= testData.get("AccountID");
		String subAccountID 	= testData.get("SubAccountID");
		System.out.println();
		System.out.println(COLORS.GREEN+"Creating the Test Data in " +COLORS.RED+env+COLORS.GREEN+" Environment. If you want to change the Environment, Kindly stop and update the 'Env' Variable Under the API Properiets File"+COLORS.RESET);
		String authtoken = Generate_OAuth2.Token(env); 
		ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();
		dataMap.put("accountID", accountID);
		dataMap.put("subAccountID", subAccountID);
		GET_RequestGroup_API.get_RequestGroup_Data(dataMap, requestGroup,authtoken, env);		
	}
	
	
	@Given("^Get the Data from the Provider$")
	public void GettheDatafromtheProvider() {
		String providerID 		= testData.get("ProviderID");
		String tempCount 		= testData.get("Count");
		int count 						= Integer.parseInt(tempCount);
		dataMap = new ConcurrentHashMap<>();
		if(providerID.startsWith("F-"))
		{
			GET_Facility_API.get_Facility_Data(dataMap, providerID,authtoken, env , count);
		}
		else if(providerID.startsWith("P-"))
		{
			GET_Practitioner_API.get_Practitioner_Data(dataMap, providerID,authtoken, env, count); 
			
		}
		
	}
	



	    // Modify the original createChaseRequestWithSingleMatchingRG() to handle dynamic invocation count
	    @Given("^Create Chase Request with Single Matching RG$")
	    public void createChaseRequestWithSingleMatchingRG() throws InterruptedException {
	    	
	        // Get the "InvocationCount" field from the Excel sheet (this determines how many times to run the API)
	        int dynamicInvocationCount = Integer.parseInt(testData.get("InvocationCount"));
	        System.out.println("Dynamic Invocation Count: " + dynamicInvocationCount);

	        // Loop to run the same logic multiple times based on InvocationCount
	        for (int i = 0; i < dynamicInvocationCount; i++) {
	            // Here, you could call `executeChaseRequest` as needed
	            // If you're passing the same value for each iteration, this will call the API multiple times
	            String intendedUseField = testData.get("intendedUse");
	            String[] intendedUseValues = intendedUseField.split("\\|");

	            for (String intendedUse : intendedUseValues) {
	                intendedUse = intendedUse.trim();
	                System.out.println("Iteration " + (i + 1) + " - Running API for Intended Use: " + intendedUse);
	                Run_API_With_Single_Matching_RG(intendedUse);
	            }
	        }
	    }
	    
	
	    // Modify the original createChaseRequestWithSingleMatchingRG() to handle dynamic invocation count
	    @Given("^Create Chase Request with No Matching RG$")
	    public void createChaseRequestWithNoMatchingRG() throws InterruptedException {
	        // Get the "InvocationCount" field from the Excel sheet (this determines how many times to run the API)
	        int dynamicInvocationCount = Integer.parseInt(testData.get("InvocationCount"));
	        System.out.println("Dynamic Invocation Count: " + dynamicInvocationCount);

	        // Loop to run the same logic multiple times based on InvocationCount
	        for (int i = 0; i < dynamicInvocationCount; i++) {
	            // Here, you could call `executeChaseRequest` as needed
	            // If you're passing the same value for each iteration, this will call the API multiple times
	            String intendedUseField = testData.get("intendedUse");
	            String[] intendedUseValues = intendedUseField.split("\\|");

	            for (String intendedUse : intendedUseValues) {
	                intendedUse = intendedUse.trim();
	                System.out.println("Iteration " + (i + 1) + " - Running API for Intended Use: " + intendedUse);
	                Run_API_With_No_Matching_RG(intendedUse);
	            }
	        }
	    }	    
	    
	    // Modify the original createChaseRequestWithSingleMatchingRG() to handle dynamic invocation count
	    @Given("^Create Chase Request with Multiple Matching RG$")
	    public void createChaseRequestWithMultipleMatchingRG() throws InterruptedException {
	        // Get the "InvocationCount" field from the Excel sheet (this determines how many times to run the API)
	        int dynamicInvocationCount = Integer.parseInt(testData.get("InvocationCount"));
	        System.out.println("Dynamic Invocation Count: " + dynamicInvocationCount);

	        // Loop to run the same logic multiple times based on InvocationCount
	        for (int i = 0; i < dynamicInvocationCount; i++) {
	            // Here, you could call `executeChaseRequest` as needed
	            // If you're passing the same value for each iteration, this will call the API multiple times
	            String intendedUseField = testData.get("intendedUse");
	            String[] intendedUseValues = intendedUseField.split("\\|");

	            for (String intendedUse : intendedUseValues) {
	                intendedUse = intendedUse.trim();
	                System.out.println("Iteration " + (i + 1) + " - Running API for Intended Use: " + intendedUse);
	                Run_API_With_Multiple_Matching_RG(intendedUse);
	            }
	        }
	    }	    
	
	    private void Run_API_With_Single_Matching_RG(String intendedUse) throws InterruptedException {
	        // Print request details for debugging purposes
	        String endPoint = testData.get("chaseRequest_url");
	        String resource = testData.get("chaseRequest_resource");
	        String accountID = testData.get("AccountID");
	        String subAccountID = testData.get("SubAccountID");
	        String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
	    	
	    	Thread.sleep(3000);
	        System.out.println("Creating Chase Request with the following details:");
	        System.out.println("Intended Use: " + intendedUse);
	        System.out.println("Account ID: " + accountID);
	        System.out.println("Sub Account ID: " + subAccountID);
	        System.out.println("Cotiviti Claim Number: " + cotivitClaimNumber);
    	
	        // Handle Authentication Token (this logic seems correct, but make sure you handle token creation correctly)
	        if (testData.containsKey("Auth_Token") &&  StringUtils.isNotBlank(testData.get("Auth_Token"))) {
	            authtoken = testData.get("Auth_Token");
	            System.out.println(testData.get("Auth_Token"));

	            System.out.println("Taking Auth_Token from Excel Sheet");
	        } else {
	        	    authtoken = Generate_OAuth2.Token(env); 
	            System.out.println("Taking Auth_Token from API");
	            getExcelData.UI_Sheet_Data("API", authtoken);
	            System.out.println("Storing Auth_Token in Excel Sheet");
	        }

	        // Make the API request with the necessary headers and payload
	        RestAssured.baseURI = endPoint;
	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", authtoken)
	        	.body(APIs_PayLoads.ChaseRequest_PayLoads_RG_20013.MATCH_WITH_RG_20013(auditType,chartType, DOS, DOE, intendedUse, accountID,	subAccountID, cotivitClaimNumber))
	        .when()
	            .post(resource)
	        .then()
	            .log().body(true)
	            .assertThat().statusCode(202);

	        System.out.println("Request completed for Intended Use: " + intendedUse);
	    }
	    
	    
	    
	    private void Run_API_With_No_Matching_RG(String intendedUse) throws InterruptedException {
	        // Print request details for debugging purposes
	        String endPoint = testData.get("chaseRequest_url");
	        String resource = testData.get("chaseRequest_resource");
	        String accountID = testData.get("AccountID");
	        String subAccountID = testData.get("SubAccountID");
	        String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
	    	
	        System.out.println("Creating Chase Request with the following details:");
	        System.out.println("Intended Use: " + intendedUse);
	        System.out.println("Account ID: " + accountID);
	        System.out.println("Sub Account ID: " + subAccountID);
	        System.out.println("Cotiviti Claim Number: " + cotivitClaimNumber);
    	
	        // Handle Authentication Token (this logic seems correct, but make sure you handle token creation correctly)
	        if (testData.containsKey("Auth_Token") &&  StringUtils.isNotBlank(testData.get("Auth_Token"))) {
	            authtoken = testData.get("Auth_Token");
	            System.out.println(testData.get("Auth_Token"));

	            System.out.println("Taking Auth_Token from Excel Sheet");
	        } else {
	       	    authtoken = Generate_OAuth2.Token(env); 
	            System.out.println("Taking Auth_Token from API");
	            getExcelData.Write_UI_Sheet_Data(subAccountID, cotivitClaimNumber);
	            System.out.println("Storing Auth_Token in Excel Sheet");
	        }

	        // Make the API request with the necessary headers and payload
	        RestAssured.baseURI = endPoint;
	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", authtoken)
	        	.body(APIs_PayLoads.ChaseRequest_PayLoads_RG_20013.MATCH_WITH_RG_20013(auditType,chartType, DOS, DOE, intendedUse, accountID,	subAccountID, cotivitClaimNumber))
	        .when()
	            .post(resource)
	        .then()
	            .log().body(true)
	            .assertThat().statusCode(202);

	        System.out.println("Request completed for Intended Use: " + intendedUse);
	    }
	    
	    private void Run_API_With_Multiple_Matching_RG(String intendedUse) throws InterruptedException {
	        // Print request details for debugging purposes
	        String endPoint = testData.get("chaseRequest_url");
	        String resource = testData.get("chaseRequest_resource");
	        String accountID = testData.get("AccountID");
	        String subAccountID = testData.get("SubAccountID");
	        String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
	        System.out.println("Creating Chase Request with the following details:");
	        System.out.println("Intended Use: " + intendedUse);
	        System.out.println("Account ID: " + accountID);
	        System.out.println("Sub Account ID: " + subAccountID);
	        System.out.println("Cotiviti Claim Number: " + cotivitClaimNumber);
    	
	        // Handle Authentication Token (this logic seems correct, but make sure you handle token creation correctly)
	        if (testData.containsKey("Auth_Token") &&  StringUtils.isNotBlank(testData.get("Auth_Token"))) {
	            authtoken = testData.get("Auth_Token");
	            System.out.println(testData.get("Auth_Token"));

	            System.out.println("Taking Auth_Token from Excel Sheet");
	        } else {
	       	    authtoken = Generate_OAuth2.Token(env); 
	            System.out.println("Taking Auth_Token from API");
	            getExcelData.UI_Sheet_Data("API", authtoken);
	            System.out.println("Storing Auth_Token in Excel Sheet");
	        }

	        // Make the API request with the necessary headers and payload
	        RestAssured.baseURI = endPoint;
	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", authtoken)
	        	.body(APIs_PayLoads.ChaseRequest_PayLoads_RG_20013.MATCH_WITH_RG_20013(auditType,chartType, DOS, DOE, intendedUse, accountID,	subAccountID, cotivitClaimNumber))
	        .when()
	            .post(resource)
	        .then()
	            .log().body(true)
	            .assertThat().statusCode(202);

	        System.out.println("Request completed for Intended Use: " + intendedUse);
	    }
	    

	}
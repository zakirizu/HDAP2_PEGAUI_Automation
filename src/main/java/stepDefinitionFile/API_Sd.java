package stepDefinitionFile;
import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import APIs.Create_PendingRGAssignment_Requests;
import factory.ReadDataFromExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;


public class API_Sd {

	HashMap<String, String> testData;
	static String authtoken;
    // Extract other values from testData



	
	
	@Given("^Read ExcelData from API_Sheet for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet(String TestCaseID) {
		testData = ReadDataFromExcel.getExcelData("API", TestCaseID);
		System.out.println("ZR");
		System.out.println(testData);
		return testData;
		
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
	            authtoken = Create_PendingRGAssignment_Requests.Create_Auth();
	            System.out.println("Taking Auth_Token from API");
	            ReadDataFromExcel.storeDataInExcel("API", authtoken);
	            System.out.println("Storing Auth_Token in Excel Sheet");
	        }

	        // Make the API request with the necessary headers and payload
	        RestAssured.baseURI = endPoint;
	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", authtoken)
	            .body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_Single_Matching_RG(intendedUse, accountID, subAccountID, cotivitClaimNumber))
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
	            authtoken = Create_PendingRGAssignment_Requests.Create_Auth();
	            System.out.println("Taking Auth_Token from API");
	            ReadDataFromExcel.storeDataInExcel("API", authtoken);
	            System.out.println("Storing Auth_Token in Excel Sheet");
	        }

	        // Make the API request with the necessary headers and payload
	        RestAssured.baseURI = endPoint;
	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", authtoken)
	            .body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_No_Matching_RG(intendedUse, accountID, subAccountID, cotivitClaimNumber))
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
	            authtoken = Create_PendingRGAssignment_Requests.Create_Auth();
	            System.out.println("Taking Auth_Token from API");
	            ReadDataFromExcel.storeDataInExcel("API", authtoken);
	            System.out.println("Storing Auth_Token in Excel Sheet");
	        }

	        // Make the API request with the necessary headers and payload
	        RestAssured.baseURI = endPoint;
	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", authtoken)
	            .body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_Multile_Matching_RG(intendedUse, accountID, subAccountID, cotivitClaimNumber))
	        .when()
	            .post(resource)
	        .then()
	            .log().body(true)
	            .assertThat().statusCode(202);

	        System.out.println("Request completed for Intended Use: " + intendedUse);
	    }
	    

	}
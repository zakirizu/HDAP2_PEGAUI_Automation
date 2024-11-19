package stepDefinitionFile;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Factory;
import java.util.HashMap;

import org.testng.annotations.Test;

import APIs.Create_PendingRGAssignment_Requests;
import factory.ReadDataFromExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class API_Sd {

	HashMap<String, String> testData;
	static String authtoken;

	
	
	@Given("^Read ExcelData from CreateRGSheet   for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet(String TestCaseID) {
		testData = ReadDataFromExcel.getExcelData("API", TestCaseID);
		return testData;
	}

	
	  @Given("^Create Chase Request with Multiple Matching RGs$")
	    public void createChaseRequestWithMultipleMatchingRGs() throws InterruptedException {
	        // Get the "intendedUse" field from the Excel sheet, which contains values like "CSS | DSV | GSG"
	        String intendedUseField = testData.get("intendedUse");
	        System.out.println("Intended Use Field: " + intendedUseField);

	        // Split the values by the delimiter "|"
	        String[] intendedUseValues = intendedUseField.split("\\|");

	        // Loop over each value (CSS, DSV, GSG)
	        for (String intendedUse : intendedUseValues) {
	            // Trim any leading or trailing spaces from each value
	            intendedUse = intendedUse.trim();
	            System.out.println("Running API for Intended Use: " + intendedUse);

	            // Now execute the request for this specific value of intendedUse
	            executeChaseRequest(intendedUse);
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
	                executeChaseRequest(intendedUse);
	            }
	        }
	    }
	
	
	    private void executeChaseRequest(String intendedUse) throws InterruptedException {
	        // Extract other values from testData
	        String endPoint = testData.get("chaseRequest_url");
	        String resource = testData.get("chaseRequest_resource");
	        String accountID = testData.get("AccountID");
	        String subAccountID = testData.get("SubAccountID");
	        String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();

	        // Print request details for debugging purposes
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
	}
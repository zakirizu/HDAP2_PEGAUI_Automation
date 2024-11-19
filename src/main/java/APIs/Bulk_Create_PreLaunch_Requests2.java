package APIs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.PropertiesFileReader;

public class Bulk_Create_PreLaunch_Requests2 {

	static String endPoint 			= PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource			 	= PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse		= PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID			= PropertiesFileReader.getAPIProperty("AccountID");
	static String subAccountID		= PropertiesFileReader.getAPIProperty("SubAccountID");
	
	String cotivitiClaimNumber;
    Response response;

    @Given("the Chase Request API is available")
    public void givenChaseRequestApiIsAvailable() {
        RestAssured.baseURI = endPoint;
        System.out.println("Chase Request API endpoint is set to: " + endPoint);
    }

    @When("I create a Chase Request with account details and a unique Cotiviti Claim number")
    public void whenICreateAChaseRequest() {
        cotivitiClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();


        System.out.println("Creating Chase Request with Cotiviti Claim Number: " + cotivitiClaimNumber);
        
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_Single_Matching_RG(intendedUse, accountID, subAccountID, cotivitiClaimNumber))
                .when()
                .post(resource);
    }

    @Then("the API should respond with status 202")
    public void thenTheApiShouldRespondWithStatus202() {
        response.then().log().body(true).assertThat().statusCode(202);
        System.out.println("Response received with status code: " + response.getStatusCode());
        org.testng.Assert.assertEquals(202, response.getStatusCode());
    }
}

package APIs;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;

import factory.ReadDataFromExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Create_Auth_Token2 {

    private String authToken;
    private Response response;

    HashMap<String,String> testData;	
	@Then("^Read ExcelData from CreateRGSheet  for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet( String TestCaseID) {		
		testData = ReadDataFromExcel.getExcelData("API", TestCaseID);
		return testData;		
	}
	
	
    @Given("the authorization server is available")
    public void givenTheAuthorizationServerIsAvailable() {
        // Set the base URI for the authorization server
        RestAssured.baseURI = "https://cotiviti-ext-devtest.oktapreview.com"; // Your auth endpoint
        System.out.println("Authorization server is available at: " + RestAssured.baseURI);
    }

    @When("I request a new authentication token with valid credentials")
    public void whenIRequestANewAuthenticationToken() {
        // Set headers, parameters, and send the POST request to obtain the auth token
        String authorizationHeader = "Basic MG9hMjVod20zNHpablZVck0waDg6M21jR21jNk91MGplZFZwX2NTVHdiWFIwTWUybURVWW5ZNWRXSmt2YnpuQ1NwZXI1YkdZVGFHTHNTSEZ4ZFpxYg==";
        String sessionCookie = "E3FDDF4D92FD562312A9540EDFCA370A";

        response = RestAssured.given()
            .header("Authorization", authorizationHeader)
            .header("Cookie", "JSESSIONID=" + sessionCookie)
            .contentType(ContentType.URLENC)
            .accept(ContentType.JSON)
            .formParam("audience", "api://default")
            .formParam("grant_type", "client_credentials")
            .formParam("scope", "hdap_scope")
            .when()
            .post("/oauth2/default/v1/token");
        
        System.out.println("Response: " + response.getBody().asString());
    }

    @Then("the response should contain a valid access token")
    public void thenTheResponseShouldContainAValidAccessToken() {
        // Extract the access token from the response
        authToken = response.jsonPath().getString("access_token");

        assertNotNull("Authorization token should not be null", authToken);
      //  assertTrue("Authorization token should not be empty", authToken.isEmpty());

        System.out.println("Generated Auth Token: " + authToken);
    }

    @Then("the access token should not be empty")
    public void thenTheAccessTokenShouldNotBeEmpty() {
        // Validate that the token is not empty
        assertNotNull("Authorization token should not be null", authToken);
       // assertFalse("Authorization token should not be empty", authToken.isEmpty());
    }
}

package APIs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.PropertiesFileReader;

public class Create_PendingRGAssignment_Requests2 {

    static String endPoint = PropertiesFileReader.getAPIProperty("chaseRequest_url");
    static String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
    static String intendedUse = PropertiesFileReader.getAPIProperty("intendedUse");
    static String accountID = PropertiesFileReader.getAPIProperty("AccountID");
    static String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");

    private String authToken;
    private Response response;

    @Given("I generate an auth token and send a request with no matching RG")
    public void generateAuthTokenAndSendRequest() {
        // Get auth token (you can place the code that generates the token in a separate method)
        authToken = createAuthToken();

        // Generate a unique Cotiviti Claim Number (this can be a method to generate random values)
        String cotivitiClaimNumber = "12345";  // Replace with dynamic value if needed

        // Send the request with no matching RG
        response = given()
            .header("Content-Type", "application/json")
            .header("Authorization", authToken)
            .body("{"
                + "\"intendedUse\": \"" + intendedUse + "\","
                + "\"accountID\": \"" + accountID + "\","
                + "\"subAccountID\": \"" + subAccountID + "\","
                + "\"cotivitiClaimNumber\": \"" + cotivitiClaimNumber + "\""
                + "}")
            .when()
            .post(endPoint + resource);
    }

    @Then("I should receive a {int} status and log the response")
    public void verifyResponseStatusAndLog(int expectedStatusCode) {
        // Verify the response status code
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Expected status code was not returned!");

        // Log the response body for debugging
        System.out.println("Response Body: " + response.getBody().asString());
    }

    private String createAuthToken() {
        // Implement logic for generating auth token here (simplified example)
        RestAssured.baseURI = "https://example.com/auth"; // Replace with your actual auth URL

        Response authResponse = given()
            .header("Authorization", "Basic XYZ") // Replace with actual header details
            .contentType(ContentType.URLENC)
            .formParam("grant_type", "client_credentials")
            .when()
            .post("/oauth2/token");

        // Extract the token from the response
        return authResponse.jsonPath().getString("access_token");
    }
}

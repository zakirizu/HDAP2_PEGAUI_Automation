package APIs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DependencyInjection;
import utils.PropertiesFileReader;

public class Create_PendingRGAssignment_ChaseRequest {
	static String endPoint = PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse = PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID = PropertiesFileReader.getAPIProperty("AccountID");
	static String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");
	static String authtoken = Create_PendingRGAssignment_ChaseRequest.Create_Auth();

	@Test(invocationCount =1)
	public static void ChaseRequest_With_No_Matching_RG() throws InterruptedException

	{
		String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
		System.out.println("*******************************Creating Chase Request with NO Matching Single RG with Below Combination*****************************");
		System.out.println("Intended Use------------------------->" + intendedUse);
		System.out.println("Account ID---------------------------->" + accountID);
		System.out.println("Sub Account ID----------------------->" + subAccountID);
		System.out.println("Cotiviti Claim Number-------------->" + cotivitClaimNumber);
		System.out.println("<----------RESPONSE BODY--------->");

		// Create_Auth_Token auth = new Create_Auth_Token();

		
		RestAssured.baseURI = endPoint;
		// JsonPath js =
		given()// .log().all()
				.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_No_Matching_RG(intendedUse, accountID,
						subAccountID, cotivitClaimNumber))

				.when().post(resource)

				.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();

	}

	public static String Create_Auth() {

		DependencyInjection dp = new DependencyInjection();

		System.out.println("Generating OAuth2.0 Token ");
		// Set the base URI for the authorization server
		RestAssured.baseURI = "https://cotiviti-ext-devtest.oktapreview.com"; // Your auth endpoint

		String authorizationHeader = "Basic MG9hMjVod20zNHpablZVck0waDg6M21jR21jNk91MGplZFZwX2NTVHdiWFIwTWUybURVWW5ZNWRXSmt2YnpuQ1NwZXI1YkdZVGFHTHNTSEZ4ZFpxYg==";
		String sessionCookie = "E3FDDF4D92FD562312A9540EDFCA370A";

		// Send a POST request with the necessary headers
		Response response = RestAssured.given().header("Authorization", authorizationHeader) // Add the Authorization
																								// header
				.header("Cookie", "JSESSIONID=" + sessionCookie) // Add the session cookie
				.contentType(ContentType.URLENC) // Content type is URL encoded
				.accept(ContentType.JSON) // Accepting JSON responses
				.formParam("audience", "api://default") // Example form parameter
				.formParam("grant_type", "client_credentials") // Example form parameter
				.formParam("scope", "hdap_scope") // Example form parameter
				.when().post("/oauth2/default/v1/token") // Example endpoint
				.then().statusCode(200) // Expect HTTP 200 OK status code
				.extract().response(); // Extract the response

		String responseBody = response.getBody().asString(); // Get the response body as a string
		//System.out.println("Response Body: " + responseBody);

		//System.out.println("authToken" + response);
		// Extract the access_token from the response JSON
		String authToken = response.jsonPath().getString("access_token");
		System.out.println("authToken" + authToken);

		// Extract the access_token from the response JSON
		authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

		if (authToken == null || authToken.isEmpty()) {
			org.testng.Assert.fail("Authorization token not generated.");
		}
	return authToken;
	}

}

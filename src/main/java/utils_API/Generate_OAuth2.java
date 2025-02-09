package utils_API;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DependencyInjection;
import utils.PropertiesFileReader;


public class Generate_OAuth2{
static String env = PropertiesFileReader.getAPIProperty("env");

public static String Token() {
	
	if(env.equalsIgnoreCase("QA"))
	{
	System.out.println("Create OAuth2.0--- Running ");
	// Set the base URI for the authorization server
	RestAssured.baseURI = "https://cotiviti-ext-devtest.oktapreview.com"; // Your auth endpoint

	String authorizationHeader = "Basic MG9hMjVod20zNHpablZVck0waDg6M21jR21jNk91MGplZFZwX2NTVHdiWFIwTWUybURVWW5ZNWRXSmt2YnpuQ1NwZXI1YkdZVGFHTHNTSEZ4ZFpxYg==";
	String sessionCookie = "E3FDDF4D92FD562312A9540EDFCA370A";

	// Send a POST request with the necessary headers
	Response response = RestAssured.given().header("Authorization", authorizationHeader) // Add the Authorization	// header
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
	System.out.println("Response Body: " + responseBody);

	System.out.println("authToken" + response);
	// Extract the access_token from the response JSON
	String authToken = response.jsonPath().getString("access_token");
	System.out.println("authToken" + authToken);

	// Extract the access_token from the response JSON
	authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

	if (authToken == null || authToken.isEmpty()) {
		org.testng.Assert.fail("Authorization token not generated.");
	}

	System.out.println("Generated QA_Auth Token: " + authToken); // Optional: Print the token for debugging
	return authToken;
}


////
else
{
	DependencyInjection dp = new DependencyInjection();

	System.out.println("Create Auth Running ");
	// Set the base URI for the authorization server
	RestAssured.baseURI = "https://login-preview.cotiviti.com"; // Your auth endpoint

	String authorizationHeader = "Basic MG9hMjlmNXA5bHV5M3hXa2QwaDg6TDVheTFXenl3U3B4ZVNMOHAweVVLWkRTRWRiM1FXcFZEdnRpMmVQOGpmOXBZeWFXY3BLbHF1M0E0UXEtOHV2Nw==";
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
	System.out.println("Response Body: " + responseBody);

	System.out.println("authToken" + response);
	// Extract the access_token from the response JSON
	String authToken = response.jsonPath().getString("access_token");
	System.out.println("authToken" + authToken);

	// Extract the access_token from the response JSON
	authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

	if (authToken == null || authToken.isEmpty()) {
		org.testng.Assert.fail("Authorization token not generated.");
	}

	System.out.println("Generated UA_Auth Token: " + authToken); // Optional: Print the token for debugging
	// return authToken;

	//dp.setAuth(authToken);

	return authToken;
}
}



}
package utils_API;
import static org.testng.Assert.assertEquals;

import factory.COLORS;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DependencyInjection;
import utils.PropertiesFileReader;


public class Generate_OAuth2{
static String env = PropertiesFileReader.getAPIProperty("env");

/*
public static String Token() {
	
	if(env.equalsIgnoreCase("QA"))
	{
		
		System.out.println("Hi There, Generating QA Auth2.0 Code");
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
	//System.out.println("Response Body: " + responseBody);

	//System.out.println("authToken" + response);
	// Extract the access_token from the response JSON
	String authToken = response.jsonPath().getString("access_token");
	//System.out.println("authToken" + authToken);

	// Extract the access_token from the response JSON
	authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

	if (authToken == null || authToken.isEmpty()) {
		org.testng.Assert.fail("Authorization token not generated.");
	}

	System.out.println("Generated QA_Auth2.0 Token Successfully: "); // Optional: Print the token for debugging
	//System.out.println(authToken); // Optional: Print the token for debugging
	return authToken;
}


////
else if(env.equalsIgnoreCase("UAT"))
{
	DependencyInjection dp = new DependencyInjection();

	System.out.println("Hi There, Generating UAT Auth2.0 Code");
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
	//System.out.println("Response Body: " + responseBody);

	//System.out.println("authToken" + response);
	// Extract the access_token from the response JSON
	String authToken = response.jsonPath().getString("access_token");
	//System.out.println("authToken" + authToken);

	// Extract the access_token from the response JSON
	authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

	if (authToken == null || authToken.isEmpty()) {
		org.testng.Assert.fail("Authorization token not generated.");
	}

	System.out.println("Generated UAT_Auth Token Successfully: "); // Optional: Print the token for debugging
	//System.out.println(authToken); // Optional: Print the token for debugging
	// return authToken;

	//dp.setAuth(authToken);

	
	return authToken;
	
}
else
{
System.out.println(COLORS.RED+"PLEASE SELECT PROPER ENVIRONMENT"+COLORS.RED);	
assertEquals(true, false);
}
	return env;
}
	*/


public static String Token(String env) {

	
	if(env.equalsIgnoreCase("QA"))
	{
		
		//System.out.println("Hi There, Generating QA Auth2.0 Code");
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
	//System.out.println("Response Body: " + responseBody);

	//System.out.println("authToken" + response);
	// Extract the access_token from the response JSON
	String authToken = response.jsonPath().getString("access_token");
	//System.out.println("authToken" + authToken);

	// Extract the access_token from the response JSON
	authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

	if (authToken == null || authToken.isEmpty()) {
		org.testng.Assert.fail("Authorization token not generated.");
	}

	//System.out.println(""); // Optional: Print the token for debugging
	//System.out.println(authToken); // Optional: Print the token for debugging
	return authToken;
}


////
else if(env.equalsIgnoreCase("UAT"))
{
	DependencyInjection dp = new DependencyInjection();

	System.out.println("Hi There, Generating UAT Auth2.0 Code");
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
	//System.out.println("Response Body: " + responseBody);

	//System.out.println("authToken" + response);
	// Extract the access_token from the response JSON
	String authToken = response.jsonPath().getString("access_token");
	//System.out.println("authToken" + authToken);

	// Extract the access_token from the response JSON
	authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

	if (authToken == null || authToken.isEmpty()) {
		org.testng.Assert.fail("Authorization token not generated.");
	}

	System.out.println("Generated UAT_Auth Token Successfully: "); // Optional: Print the token for debugging
	//System.out.println(authToken); // Optional: Print the token for debugging
	// return authToken;

	//dp.setAuth(authToken);


	
	return authToken;
	
}
else if(env.equalsIgnoreCase("DEV"))
{
//System.out.println("Hi There, Generating QA Auth2.0 Code");
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
//System.out.println("Response Body: " + responseBody);

//System.out.println("authToken" + response);
// Extract the access_token from the response JSON
String authToken = response.jsonPath().getString("access_token");
//System.out.println("authToken" + authToken);

// Extract the access_token from the response JSON
authToken = response.jsonPath().getString("access_token"); // Adjust the path if necessary

if (authToken == null || authToken.isEmpty()) {
	org.testng.Assert.fail("Authorization token not generated.");
}

//System.out.println(""); // Optional: Print the token for debugging
//System.out.println(authToken); // Optional: Print the token for debugging
return authToken;
	
}
else
{
System.out.println(COLORS.PURPLE+"PLEASE SELECT PROPER ENVIRONMENT"+COLORS.RESET);	
System.out.println(COLORS.PURPLE+"	Acceptable values are QA , UAT only "+COLORS.RESET);	
assertEquals(true, false);
}
	return env;
}


}
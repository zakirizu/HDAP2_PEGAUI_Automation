package APIs;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class Create_PreLaunch_Requests {
	static String endPoint 			= PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource			 	= PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse		= PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID			= PropertiesFileReader.getAPIProperty("AccountID");
	static String subAccountID		= PropertiesFileReader.getAPIProperty("SubAccountID");
	
	@Test(invocationCount = 5)
	public  static void ChaseRequest_With_Single_Matching_RG_01() throws InterruptedException
	{
		    String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
			System.out.println("*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
			System.out.println("Intended Use-------------------------->" +intendedUse);
			System.out.println("Account ID---------------------------->" +accountID);
			System.out.println("Sub Account ID----------------------->" +subAccountID);
			System.out.println("Cotiviti Claim Number--------------->" +cotivitClaimNumber);			
			System.out.println("<----------RESPONSE BODY--------->");
	
			RestAssured.baseURI = endPoint;
		//	JsonPath js =
					given()//.log().all()
					.header("Content-Type","application/json")
					.body(APIs_PayLoads.ChaseRequest_PayLoads.payLoad_With_Single_Matching_RG(intendedUse, accountID, subAccountID, cotivitClaimNumber))
					
					.when()
					.post(resource)
					
					.then().log().body(true)
					.assertThat().statusCode(202)
					.extract().response().jsonPath();			
			
	}

	
}

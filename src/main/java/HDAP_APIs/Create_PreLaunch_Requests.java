package HDAP_APIs;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import factory.PropertiesData;
import io.restassured.RestAssured;

public class Create_PreLaunch_Requests {
	static String endPoint 			= PropertiesData.getAPIProperty("chaseRequest_url");
	static String resource			 	= PropertiesData.getAPIProperty("chaseRequest_resource");
	static String intendedUse		= PropertiesData.getAPIProperty("intendedUse");
	static String accountID			= PropertiesData.getAPIProperty("AccountID");
	static String subAccountID		= PropertiesData.getAPIProperty("SubAccountID");
	
	@Test(invocationCount = 2)
	public  static void ChaseRequest_With_Single_Matching_RG() throws InterruptedException
	{
		    String cotivitClaimNumber = factory.ReUsableMethods.getUniqueRandomInteger();
			System.out.println("*******************************Creating Chase Request Matching Single RG with Below Combination*****************************");
			System.out.println("Intended Use-------------------------->" +intendedUse);
			System.out.println("Account ID---------------------------->" +accountID);
			System.out.println("Sub Account ID----------------------->" +subAccountID);
			System.out.println("Cotiviti Claim Number--------------->" +cotivitClaimNumber);			
			System.out.println("<----------RESPONSE BODY--------->");
	
			RestAssured.baseURI = endPoint;
		//	JsonPath js =
					given()//.log().all()
					.header("Content-Type","application/json")
					.body(HDAP_PayLoads.ChaseRequest_PayLoads.payLoad_With_Single_Matching_RG(intendedUse, accountID, subAccountID, cotivitClaimNumber))
					
					.when()
					.post(resource)
					
					.then().log().body(true)
					.assertThat().statusCode(202)
					.extract().response().jsonPath();			
			
	}

}

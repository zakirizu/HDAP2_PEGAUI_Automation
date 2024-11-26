package APIs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import APIs_PayLoads.CreateOAuth2_Token;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class ChaseRequests_With_SingleProject {

	//static HashMap<String, String> testData = ReadDataFromExcel.getExcelData("createRG", TestCaseID);
	static String endPoint = PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse = PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID = PropertiesFileReader.getAPIProperty("AccountID");
	static String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");
	static String authtoken = CreateOAuth2_Token.Create_Auth();
	
	

	@Test(invocationCount = 2)
	public static void ChaseRequest_With_Single_Matching_RG_01() throws InterruptedException {
		String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
		System.out.println(
				"*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
		System.out.println("Intended Use-------------------------->" + intendedUse);
		System.out.println("Account ID---------------------------->" + accountID);
		System.out.println("Sub Account ID----------------------->" + subAccountID);
		System.out.println("Cotiviti Claim Number--------------->" + cotivitClaimNumber);
		System.out.println("<----------RESPONSE BODY--------->");

		RestAssured.baseURI = endPoint;
		// JsonPath js =
		given()// .log().all()
		.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.ChaseRequest_PayLoads_RG_20013.MATCH_WITH_RG_20013(intendedUse, accountID,	subAccountID, cotivitClaimNumber))
				.when().post(resource)
				.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
	}
	
	
	

     }
	
	
	



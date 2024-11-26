package APIs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import APIs_PayLoads.CreateOAuth2_Token;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class ChaseRequests_With_Different_AccountID_IntendedUse {
	static String endPoint = PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse = PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID = PropertiesFileReader.getAPIProperty("AccountID");
	static String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");
	static String authtoken = CreateOAuth2_Token.Create_Auth();

	//We need to run this 100 times. But we are doing it in two rounds 50 each due to the limitation in the time out.
	@Test(invocationCount = 2, dataProvider = "200_Set_testdata" ) 
	public static void ChaseRequest_With_Single_Matching_RG_01(String accountID , String intendedUse) throws InterruptedException {
		String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
		Thread.sleep(500);
		System.out.println("*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
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
	
	
	 @DataProvider (name = "50_Set_testdata")
     public Object[][] FiftySetData(){
	 return new Object[][] {
		 {"P610", "HEDIS"},

			};
     }


	 @DataProvider (name = "100_Set_testdata")
     public Object[][] HundredSetData(){
	 return new Object[][] {
		 {"J667", "CV"},
		{"J667", "MRA"},
		{"J667",	 "CRA"},
		{"J667",	 "CPR"},
		{"J667",	 "RADV"},
		{"J667",	 "RCA"},
		{"M710", "HEDIS"},
		{"M710", "CCV"},
		{"M710",	"CV"},
		{"M710",	"MRA"}
	 	 };
	 }
	 
	 

	 @DataProvider (name = "150_Set_testdata")
     public Object[][] OneFiftySetData(){
	 return new Object[][] {
		 {"M710", "CRA"},
		 {"M710", "CPR"},
		 {"M710", "RADV"},
		 {"M710", "RCA"},
		 {"Q001", "HEDIS"},
		 {"Q001", "CCV"},
		 {"Q001", "CV"},
		 {"Q001", "MRA"},
		 {"Q001", "CRA"},
		 {"Q001", "CPR"}

	 };
	 }
	 
	 
	 @DataProvider (name = "200_Set_testdata")
     public Object[][] TwoHundredSetData(){
	 return new Object[][] {
		 {"Q001", "RADV"},
		 {"Q001", "RCA"},
		 {"K123", "HEDIS"},
		 {"K123", "CCV"},
		 {"K123", "CV"},
		 {"K123", "MRA"},
		 {"K123", "CRA"},
		 {"K123", "CPR"},
		{"K123", "RADV"},
		{"K123", "RCA"},

	 };
	 }
	 
     }
	
	
	



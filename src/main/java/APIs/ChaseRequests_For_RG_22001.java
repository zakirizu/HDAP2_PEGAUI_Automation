package APIs;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;
import utils_API.Generate_OAuth2;


public class ChaseRequests_For_RG_22001 {
	static String endPoint = PropertiesFileReader.getAPIProperty("chaseRequest_url");
	static String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	static String intendedUse = PropertiesFileReader.getAPIProperty("IntendedUse");
	static String accountID = PropertiesFileReader.getAPIProperty("Client_AccountID");
	static String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");	
	static String auditType = PropertiesFileReader.getAPIProperty("AuditType");
	static String chartType = PropertiesFileReader.getAPIProperty("ChartType");
	static String DOS = PropertiesFileReader.getAPIProperty("DateOfStart");
	static String DOE = PropertiesFileReader.getAPIProperty("DateOfEnd");
	static String env = PropertiesFileReader.getAPIProperty("env");
	static String authtoken = Generate_OAuth2.Token(env);
	
	
	@Test(invocationCount =2)
	public static void ChaseRequest_With_Single_Matching_RG_01() throws InterruptedException {
		System.out.println(	"*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
		System.out.println("Intended Use-------------------------->" + intendedUse);
		System.out.println("Account ID---------------------------->" + accountID);
		System.out.println("Sub Account ID----------------------->" + subAccountID);
		String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.currentDateTimeMilliSeconds();
		System.out.println("Cotiviti Claim Number--------------->" + cotivitClaimNumber);
		System.out.println("<----------RESPONSE BODY--------->");
		Thread.sleep(800);

		RestAssured.baseURI = endPoint; 
		// JsonPath js =
		given()//.log().all()
		.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.ChaseRequest_PayLoads_RG_22001.MATCH_WITH_RG_22001(auditType,chartType, DOS, DOE, intendedUse, accountID,	subAccountID, cotivitClaimNumber))
				.when().post(resource)
				.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
	}
	

     }
	
	
	



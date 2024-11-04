package APIs;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class Create_Multiple_Projects_With_PreLauch_Status {

	static String intendedUse		= PropertiesFileReader.getAPIProperty("intendedUse");
	static String accountID			= PropertiesFileReader.getAPIProperty("AccountID");
	
	
	@Test(dataProvider = "projectNames")
	public  static void ChaseRequest_With_Single_Matching_RG(String accID, String intdUse) throws InterruptedException
	{
			String endPoint 				= PropertiesFileReader.getAPIProperty("chaseRequest_url");
			String resource			 		= PropertiesFileReader.getAPIProperty("chaseRequest_resource");
			String subAccountID		= PropertiesFileReader.getAPIProperty("SubAccountID");
			String intendedUse			= intdUse;
			String accountID				= accID;		
		    String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.getUniqueRandomInteger();
		    
			System.out.println("*******************************Creating Chase Multiple Projects and Each ChaseRequest with Below Combination*****************************");
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
	
	
	@DataProvider(name = "projectNames")
	public Object[][] testDataProvider(){
			
		return new Object[][]
				{
			{"P610","CRA"},
			{"P610","CCV"},
			{"P610","RCA"},
			{"P610","HEDIS"},
			
			{"K123","CRA"},
			{"K123","CCV"},
			{"K123","RCA"},
			{"K123","HEDIS"},
			
			{"D321","CRA"},
			{"D321","CCV"},
			{"D321","RCA"},
			{"D321","HEDIS"},
			
			{"J667","CRA"},
			{"J667","CCV"},
			{"J667","RCA"},
			{"J667","HEDIS"},
			
			{"M567","CRA"},
			{"M567","CCV"},
			{"M567","RCA"},
			{"M567","HEDIS"},
			
			{"M900","CRA"},
			{"M900","CCV"},
			{"M900","RCA"},
			{"M900","HEDIS"},
			
			{"Q001","CRA"},
			{"Q001","CCV"},
			{"Q001","RCA"},
			{"Q001","HEDIS"},
			
			{"BBB1","CRA"},
			{"BBB1","CCV"},
			{"BBB1","RCA"},
			{"BBB1","HEDIS"},
			
			{"Q002","CRA"},
			{"Q002","CCV"},
			{"Q002","RCA"},
			{"Q002","HEDIS"},
			
			{"1234","CRA"},
			{"1234","CCV"},
			{"1234","RCA"},
			{"1234","HEDIS"},
		
				};
		
		
		
		
		
	}

}

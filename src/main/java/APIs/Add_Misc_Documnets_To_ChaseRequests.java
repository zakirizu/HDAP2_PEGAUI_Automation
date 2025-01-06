package APIs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import APIs_PayLoads.CreateOAuth2_Token;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class Add_Misc_Documnets_To_ChaseRequests {
	static String authtoken = CreateOAuth2_Token.Create_Auth();
	@Test( dataProvider = "demo")
	public static void ChaseRequest_With_Single_Matching_RG_01(String id) throws InterruptedException {
		System.out.println(	"*******************************Creating Chase Request Matching With Single RG with Below Combination*****************************");
		String endPoint = PropertiesFileReader.getAPIProperty("misc_url");
		String resource = "/qa/HDAP/Workflow/v1/ChaseRequests/"+id+"/WFUpdates";
		System.out.println("<----------RESPONSE BODY--------->");
		Thread.sleep(800);
		RestAssured.baseURI = endPoint; 
		// JsonPath js =
		given() .log().all()
		.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.Add_Misc_Documents_To_ChaseRequests.payLoad_Add_Misc_Documents_To_ChaseRequests(id))
				.when().post(resource)
				.then().log().body(true).assertThat().statusCode(201).extract().response().jsonPath();
	}
	
	
	 @DataProvider (name = "demo")
     public Object[][] FiftySetData(){
	 return new Object[][] {
		 {"A888-0000009401"},
   /* {"B115-0000000328"},
	    {"B115-0000000326"},
		{"B115-0000000335"},
		{"B115-0000000338"},
		{"B115-0000000318"},
		{"B115-0000000315"},
		{"B115-0000000317"},
		{"B115-0000000330"},
		{"B115-0000000334"},
	    {"B115-0000000320"},
	    {"B115-0000000323"},
	    {"B115-0000000331"},
	    {"B115-0000000324"},	
	    {"B115-0000000332"},
		{"B115-0000000325"},
		{"B115-0000000316"} */

			};
     }
	

     }
	
	
	



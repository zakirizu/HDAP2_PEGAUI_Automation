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
		//String resource = PropertiesFileReader.getAPIProperty("misc_resource");	

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
		// {"A888-0000009333"},
		// {"A888-0000009334"},
		// {"A888-0000009335"},
		 {"A888-0000009336"},
		 {"A888-0000009337"},
		 {"A888-0000009338"},
		 {"A888-0000009339"},
		 {"A888-0000009340"},
		 {"A888-0000009341"},
		 {"A888-0000009342"},
		 {"A888-0000009343"},
		 {"A888-0000009344"},
		 {"A888-0000009345"},
		 {"A888-0000009346"},
		 {"A888-0000009347"},
		 {"A888-0000009348"},
		 {"A888-0000009349"},
		 {"A888-0000009350"},
		 {"A888-0000009351"},
		 {"A888-0000009352"},
		 {"A888-0000009353"} 

			};
     }
	

     }
	
	
	



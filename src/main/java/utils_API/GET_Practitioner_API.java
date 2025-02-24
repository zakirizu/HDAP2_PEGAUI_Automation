package utils_API;
import factory.COLORS;
import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.PropertiesFileReader;
import java.util.concurrent.ConcurrentHashMap;
import static io.restassured.RestAssured.given;

public  class GET_Practitioner_API {

	   

    public static ConcurrentHashMap<String, String> get_Practitioner_Data (ConcurrentHashMap<String, String> dataMap, String practitionerId, String authtoken, String env, int count) {
        try {
        	System.out.println(COLORS.RED+"Getting the data for the Practitioner with Friendly ID: "+practitionerId+COLORS.RESET);
            String apiUrl="";             String resource = "";      
            
        	if(env.equalsIgnoreCase("UAT"))
        	{
	        	String url = PropertiesFileReader.getAPIProperty("UAT_getPractitioners");
	             apiUrl = url+ practitionerId;
        	}
        	else
        	{
        		String url = PropertiesFileReader.getAPIProperty("QA_getPractitioners");
                apiUrl = url+ practitionerId;
        	}

            // Fetch response from the API
            String jsonResponse =  
            		given()//.log().all()
            		.baseUri(apiUrl).header("Content-Type", "application/json")
                    .header("Authorization", authtoken)  // Add the Authorization header
                    .when().get().then().statusCode(200).log().all()  // Check if the status is OK
                    .extract().asString();  // Extract the response body as a string
            
            JSONObject jsonObject = new JSONObject(jsonResponse);
            
           
            
            dataMap.put("Prac_FirstName" , jsonObject.getString("FirstName"));
            dataMap.put("Prac_LastName" , jsonObject.getString("LastName"));
            //dataMap.put("Prac_Gender", jsonObject.getString("Gender"));
            //dataMap.put("Prac_DOB" , jsonObject.getString("DOB"));
           // dataMap.put("Prac_Email" , jsonObject.getString("Email"));
            dataMap.put("Prac_Phone" , jsonObject.getString("Phone"));
           // dataMap.put("Prac_Languages" , jsonObject.getString("Languages"));
            dataMap.put("Prac_NPI", jsonObject.getString("NPI"));
            dataMap.put("Prac_TIN", jsonObject.getString("TIN"));
            dataMap.put("Prac_FAX", jsonObject.getString("Fax"));
            
            
            JSONArray addresses = jsonObject.getJSONArray("Addresses");
         for (int i = 0; i < addresses.length(); i++) {
            	JSONObject address = addresses.getJSONObject(i);
                 {
                   String addressDetail = address.getString("Address");
                   String[] splitAddress = addressDetail.split(", ");
                   dataMap.put("Prac_Street", splitAddress[0]);
                   dataMap.put("Prac_City", splitAddress[1]);
                   dataMap.put("Prac_State", "AK");
                   dataMap.put("Prac_PostalCode", "84043");
                   break;
                }
            }
         
         
         
         
           
      		//Printing  using ForEachLoop		
      		for(String k : dataMap.keySet())		{
      			
      			if(k.contains("Prac")) {
      			System.out.println(COLORS.BLUE+k    + "----------->"    +dataMap.get(k));	
      			}
      		}
      		 System.out.println(COLORS.RED+"Above Request Group and Practitoner Data will now be injected into Chase Request to match with this RG and Provider"+COLORS.RESET);

			if(env.equalsIgnoreCase("UAT"))
			{
				RestAssured.baseURI = PropertiesFileReader.getAPIProperty("UAT_chaseRequest_url")+PropertiesFileReader.getAPIProperty("UAT_chaseRequest_resource");	
			}
			else
			{
				RestAssured.baseURI = PropertiesFileReader.getAPIProperty("QA_chaseRequest_url")+PropertiesFileReader.getAPIProperty("QA_chaseRequest_resource");	
			}
								
			for(int i =0;i<count;i++)
			{
			given()//.log().all()
			.header("Content-Type", "application/json").header("Authorization", authtoken)
					.body(APIs_PayLoads.ChaseRequest_Practitioner_PayLoad.PractitionerPayLoad(dataMap, env))
					.when().post(resource)
					.then().log().body(true).assertThat().statusCode(202)//.log().all()
					.extract().response().jsonPath(); 		
			System.out.println(COLORS.BLUE+"************************Create Chase Request Successfully*******************"+COLORS.RESET);
			}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }



   
    }


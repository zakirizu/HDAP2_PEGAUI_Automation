package utils_API;


import factory.COLORS;
import io.restassured.RestAssured;

import org.json.JSONArray;
import org.json.JSONObject;
import utils.PropertiesFileReader;
import java.util.concurrent.ConcurrentHashMap;

import static io.restassured.RestAssured.given;

public class GET_Facility_API {



    public static ConcurrentHashMap<String, String> get_Facility_Data(ConcurrentHashMap<String, String> dataMap, String facilityId, String authtoken) {    	
    	String apiUrl= "";
    	String resource = "";
        try {
        	System.out.println(COLORS.RED+"Getting the data for the Facility with Friendly ID: "+facilityId+COLORS.RESET);
        	
        	String env = PropertiesFileReader.getAPIProperty("env");
        	if(env.equalsIgnoreCase("UAT"))
        	{
        		String url = PropertiesFileReader.getAPIProperty("UAT_getFacility");
        			apiUrl = url+facilityId;
        	}
        	else
        	{
        		String url = PropertiesFileReader.getAPIProperty("QA_getFacility");
    			apiUrl = url+facilityId;
        	}
        	

            // Fetch response from the API
            String jsonString = 
            		given()//.log().all()
            		.baseUri(apiUrl).header("Content-Type", "application/json")
                    .header("Authorization", authtoken)  
                    .when().get().then().statusCode(200)  
                    .extract().asString(); 
            
            // Create a JSONObject from the string
            JSONObject jsonObject = new JSONObject(jsonString);
            String name = jsonObject.getString("Name");
            dataMap.put("Faci_Name", name);            
            String tin = jsonObject.getString("TIN");
            dataMap.put("Faci_TIN", tin);            
            String npi = jsonObject.getString("NPI"); 
            dataMap.put("Faci_NPI", npi);      
            String phone = jsonObject.getString("Phone");
            dataMap.put("Faci_Phone", phone);


            // Read Addresses array
            JSONArray addresses = jsonObject.getJSONArray("Addresses");
      //      System.out.println("\nAddresses:");
            for (int i = 0; i < addresses.length(); i++) {
            	
                JSONObject address = addresses.getJSONObject(i);
                if(address.getBoolean("IsPrimary"))
                {
                   String addressDetail = address.getString("Address");
                   String[] splitAddress = addressDetail.split(", ");
                   dataMap.put("Faci_Street", splitAddress[0]);
                   dataMap.put("Faci_City", splitAddress[1]);
                   dataMap.put("Faci_State", splitAddress[2]);
                   dataMap.put("Faci_PostalCode", splitAddress[3]);
                   break;
                }
            }
    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        String env = PropertiesFileReader.getAPIProperty("env");
		if(env.equalsIgnoreCase("UAT"))
		{
			RestAssured.baseURI = PropertiesFileReader.getAPIProperty("UAT_chaseRequest_url")+PropertiesFileReader.getAPIProperty("UAT_chaseRequest_resource");				
		}
		else
		{
			RestAssured.baseURI = PropertiesFileReader.getAPIProperty("QA_chaseRequest_url")+PropertiesFileReader.getAPIProperty("QA_chaseRequest_resource");
		}
		given()//.log().all()
		.header("Content-Type", "application/json").header("Authorization", authtoken)
				.body(APIs_PayLoads.ChaseRequest_Facility_PayLoad.FacilityPayLoad(dataMap))
				.when().post(resource)
				.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
        
        System.out.println(COLORS.RED+"Below Request Group and Facility Data which will be now injected into Chase Request to match with this RG and Provider"+COLORS.RESET);
      	for(String k : dataMap.keySet())		{
      			System.out.println(COLORS.BLUE+k    + "----------->"    +dataMap.get(k));			
      		}
      		
      		System.out.println(COLORS.RED+"NOTE:  if RG/Provider has multiple values to any Attribute Then we are taking the first one into account."+COLORS.RESET);
      		
        return dataMap;
    }

    
    

}

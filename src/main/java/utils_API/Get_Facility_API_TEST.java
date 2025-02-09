package utils_API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import factory.COLORS;
import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static io.restassured.RestAssured.given;

public class Get_Facility_API_TEST {

	   static String authtoken = Generate_OAuth2.Token();   // Fetches the authorization token

    public ConcurrentHashMap<String, String> get_Facility_Data(ConcurrentHashMap<String, String> dataMap, String facilityId) {
        try {
        	System.out.println("Getting the data for the Facility with Friendly ID: "+COLORS.RED+facilityId);
            // Construct the API URL dynamically with the Facility ID
            String apiUrl = "https://is8i4ayzcg.execute-api.us-east-1.amazonaws.com/uat/HDAP/Workflow/v1/Facilities/"+ facilityId;

            // Fetch response from the API
            String jsonString = 
            		given().baseUri(apiUrl).header("Content-Type", "application/json")
                    .header("Authorization", authtoken)  // Add the Authorization header
                    .when().get().then().statusCode(200)  // Check if the status is OK
                    .extract().asString();  // Extract the response body as a string
            // Create a JSONObject from the string
            JSONObject jsonObject = new JSONObject(jsonString);

            // Read basic properties
            String name = jsonObject.getString("Name");
            String tin = jsonObject.getString("TIN");
            String npi = jsonObject.getString("NPI");
            String creationDate = jsonObject.getString("CreationDate");
            String lastModifiedDate = jsonObject.getString("LastModifiedDate");
            String healthSystem = jsonObject.getString("HealthSystem");
            String phone = jsonObject.getString("Phone");
            int rgCount = jsonObject.getInt("RGCount");
            int croOpenCount = jsonObject.getInt("CROpenCount");
            int practitionerCount = jsonObject.getInt("PractitionerCount");

            System.out.println("Name: " + name);
            System.out.println("TIN: " + tin);
            System.out.println("NPI: " + npi);
           // System.out.println("Creation Date: " + creationDate);
           // System.out.println("Last Modified Date: " + lastModifiedDate);
            System.out.println("Health System: " + healthSystem);
            System.out.println("Phone: " + phone);
            //System.out.println("RG Count: " + rgCount);
          //  System.out.println("CROpen Count: " + croOpenCount);
           // System.out.println("Practitioner Count: " + practitionerCount);

            // Read Addresses array
            JSONArray addresses = jsonObject.getJSONArray("Addresses");
            System.out.println("\nAddresses:");
            for (int i = 0; i < addresses.length(); i++) {
                JSONObject address = addresses.getJSONObject(i);
                String type = address.getString("Type");
                String addressDetail = address.getString("Address");
                boolean isPrimary = address.getBoolean("IsPrimary");

                System.out.println("Type: " + type);
                System.out.println("Address: " + addressDetail);
                System.out.println("Is Primary: " + isPrimary);

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    
    

}

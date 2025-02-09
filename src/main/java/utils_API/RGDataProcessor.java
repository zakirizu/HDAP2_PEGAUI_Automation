package utils_API;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.*;
import io.restassured.response.Response;
import utils.PropertiesFileReader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static io.restassured.RestAssured.given;

public class RGDataProcessor {

	   static String authtoken = Generate_OAuth2.Token();   // Fetches the authorization token

    // Method to generate random UK-style FirstName and LastName
    private static String[] generateUKName() {
        List<String> firstNames = Arrays.asList("Oliver", "George", "Harry", "Jack", "Jacob", "Charlie", "Thomas", "James", "William", "Joshua");
        List<String> lastNames = Arrays.asList("Smith", "Jones", "Taylor", "Brown", "Williams", "Wilson", "Evans","Thomas", "Johnson", "Roberts");
        Random random = new Random();
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));

        return new String[] { firstName, lastName };
    }

    public ConcurrentHashMap<String, String> processRGData(ConcurrentHashMap<String, String> dataMap, String rgId) {
    	String apiUrl ="";
        try {
            // Construct the API URL dynamically with the RG ID
        	String env = PropertiesFileReader.getAPIProperty("env");
        	if(env.equalsIgnoreCase("QA"))
        	{
             apiUrl = PropertiesFileReader.getAPIProperty("QA_requestGroup")+rgId+PropertiesFileReader.getAPIProperty("QA_requestGroup_Resource");
        	}
        	else
        	{
        		 apiUrl = PropertiesFileReader.getAPIProperty("UAT_requestGroup")+ rgId+PropertiesFileReader.getAPIProperty("UAT_requestGroup_Resource");
        	}

            // Fetch response from the API
            String jsonResponse = sendGetRequest(apiUrl);

            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Extract the required values
            String projectType = extractType(rootNode.path("ProjectTypes"));
            String auditType = extractType(rootNode.path("AuditTypes"));
            String chartType = extractType(rootNode.path("ChartTypes"));
            
            dataMap.put("RGProjectTypes", projectType);
            dataMap.put("RGAuditTypes", auditType);
            dataMap.put("RGChartTypes", chartType);

            // Extract DatesOfService range
            JsonNode datesOfService = rootNode.path("DatesOfService");
            String startDate = "";
            String endDate = "";
            if (datesOfService.isArray() && datesOfService.size() > 0) {
                JsonNode dateRange = datesOfService.get(0);  // Taking the first date range
                startDate = dateRange.path("StartDate").asText();
                endDate = dateRange.path("EndDate").asText();
            }

            // Generate random names
            String[] generatedName = generateUKName();
            String firstName = generatedName[0];
            String lastName = generatedName[1];

            // Add to data map
            dataMap.put("RGstartDate", startDate);
            dataMap.put("RGendDate", endDate);
            dataMap.put("RGfirstName", firstName);
            dataMap.put("RGlastName", lastName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    // Method to send GET request and return the response
    private static String sendGetRequest(String apiUrl) throws Exception {
        return given().log().all().
        		baseUri(apiUrl).header("Content-Type", "application/json")
                .header("Authorization", authtoken)  // Add the Authorization header
                .when().get().then().statusCode(200)  // Check if the status is OK
                .extract().asString();  // Extract the response body as a string
    }

    // Helper method to extract the type from a JsonNode
    private static String extractType(JsonNode jsonNode) {
        if (jsonNode.isArray() && jsonNode.size() > 0) {
            for (JsonNode node : jsonNode) {
                String type = node.path("Type").asText();
                if (type.equals("Pharmacy") || type.equals("RADM") || type.equals("CCV")) 
                {
                    return type;  // Return first matching type
                }
            }
        }
        return "";  // If no match, return an empty string
    }
}

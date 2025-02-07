package utils_API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.*;
import io.restassured.response.Response;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static io.restassured.RestAssured.given;

public class FactDataProcessor {

    static String authtoken = OAuth2_Token_UAT.Generate_UAT_OAuth();  // Fetches the authorization token

    public ConcurrentHashMap<String, String> processFactData(ConcurrentHashMap<String, String> dataMap, String facilityId) {
        try {
            // Construct the API URL dynamically with the Facility ID
            String apiUrl = "https://is8i4ayzcg.execute-api.us-east-1.amazonaws.com/uat/HDAP/Workflow/v1/Facilities/" + facilityId;

            // Fetch response from the API
            String jsonResponse = sendGetRequest(apiUrl);

            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Extract the required values from the response (update field names)
            String name = rootNode.path("Name").asText();
            String tin = rootNode.path("TIN").asText();
            String npi = rootNode.path("NPI").asText();
            String phone = rootNode.path("Phone").asText();

            // Extract address info (addresses is an array)
            String street = "", city = "", state = "", postalCode = "";
            JsonNode addressesNode = rootNode.path("Addresses");
            if (addressesNode.isArray() && addressesNode.size() > 0) {
                JsonNode addressNode = addressesNode.get(0); // Get the first address
                String address = addressNode.path("Address").asText();

                // Use regular expressions to split the address into street, city, state, and postal code
                String[] addressParts = parseAddress(address);
                street = addressParts[0];
                city = addressParts[1];
                state = addressParts[2];
                postalCode = addressParts[3];
            }

            // Extract Facility from the response (assuming it's in the API response)
            String facility = rootNode.path("Facility").asText(); // Facility value

            // Add extracted values to the data map
            dataMap.put("Fname", name);
            dataMap.put("Ftin", tin);
            dataMap.put("Fnpi", npi);
            dataMap.put("Fphone", phone);
            dataMap.put("Fstreet", street);
            dataMap.put("Fcity", city);
            dataMap.put("Fstate", state);
            dataMap.put("FpostalCode", postalCode);
            dataMap.put("Facility", facility);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    // Method to send GET request and return the response
    private static String sendGetRequest(String apiUrl) throws Exception {
        return given().baseUri(apiUrl).header("Content-Type", "application/json")
                .header("Authorization", authtoken)  // Add the Authorization header
                .when().get().then().statusCode(200)  // Check if the status is OK
                .extract().asString();  // Extract the response body as a string
    }

    // Helper method to parse the address string into street, city, state, and postal code
    private String[] parseAddress(String address) {
        String[] addressParts = new String[4];
        // Regular expression to split the address
        // This assumes address format: street, city, state, postal code
        // Example: "03354 Brown Landing Apt. 514, West Dustinfort, FM, 54477"
        String[] splitAddress = address.split(", ");
        if (splitAddress.length == 4) {
            addressParts[0] = splitAddress[0];  // Street
            addressParts[1] = splitAddress[1];  // City
            addressParts[2] = splitAddress[2];  // State
            addressParts[3] = splitAddress[3];  // Postal Code
        }
        return addressParts;
    }
}

package utils_API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.*;
import io.restassured.response.Response;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static io.restassured.RestAssured.given;

public class PractDataProcessor {

	   static String authtoken = Generate_OAuth2.Token();  // Fetches the authorization token

    public ConcurrentHashMap<String, String> processPractData(ConcurrentHashMap<String, String> dataMap, String practitionerId) {
        try {
            // Construct the API URL dynamically with the Practitioner ID
            String apiUrl = "https://is8i4ayzcg.execute-api.us-east-1.amazonaws.com/qa/HDAP/Workflow/v1/Practitioners/"+ practitionerId;

            // Fetch response from the API
            String jsonResponse = sendGetRequest(apiUrl);

            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Extract the required values (adjusting for the correct JSON field names)
            String firstName = rootNode.path("FirstName").asText();
            String lastName = rootNode.path("LastName").asText();
            String tin = rootNode.path("TIN").asText();
            String npi = rootNode.path("NPI").asText();
            String phone = rootNode.path("Phone").asText();
            String email = rootNode.path("Email").asText();
            String fax = rootNode.path("Fax").asText();
            String pager = rootNode.path("Pager").asText();
            String languages = rootNode.path("Languages").asText();
            String specialty = rootNode.path("Specialty").asText();

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

            // Add extracted values to the dataMap
            dataMap.put("PfirstName", firstName);
            dataMap.put("PlastName", lastName);
            dataMap.put("Ptin", tin);
            dataMap.put("Pnpi", npi);
            dataMap.put("Pphone", phone);
            dataMap.put("Pemail", email);
            dataMap.put("Pfax", fax);
            dataMap.put("Ppager", pager);
            dataMap.put("Planguages", languages);
            dataMap.put("Pspecialty", specialty);
            dataMap.put("Pstreet", street);
            dataMap.put("Pcity", city);
            dataMap.put("Pstate", state);
            dataMap.put("PpostalCode", postalCode);
            dataMap.put("PpractitionerId", practitionerId);

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
        // Example: "8434 Warren IslandApt. 514, East Amanda, PW, 31808"
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

package utils_API;
import factory.COLORS;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.PropertiesFileReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import static io.restassured.RestAssured.given;

public class GET_RequestGroup_API {

    public static ConcurrentHashMap<String, String> get_RequestGroup_Data(ConcurrentHashMap<String, String> dataMap, String rgId, String authtoken, String env) {
    	System.out.println("Selected Environment is : "+env);
  		System.out.println(COLORS.BLUE+"NOTE:  If RG/Provider has multiple values to any Attribute Then we are taking the first one into account. Also"+COLORS.RESET);
  		System.out.println(COLORS.BLUE+"NOTE: Please ensure that the Above RG and Provider are binded with the Process For Rules in Health Lake "+COLORS.RESET);
    	System.out.println(COLORS.RED+"Getting the data for the Request Group ID: "+COLORS.RED+rgId+COLORS.RESET);
    	    	String apiUrl ="";
        try {
        	//String env = PropertiesFileReader.getAPIProperty("env");
        	
        	if(env.equalsIgnoreCase("UAT"))
        	{
        		String url = PropertiesFileReader.getAPIProperty("UAT_requestGroup");
        		String resource = PropertiesFileReader.getAPIProperty("UAT_requestGroup_Resource");
        		apiUrl = url+rgId+resource;
        	}
        	else if(env.equalsIgnoreCase("QA"))
        	{
        		String url = PropertiesFileReader.getAPIProperty("QA_requestGroup");        	
        		String resource = PropertiesFileReader.getAPIProperty("QA_requestGroup_Resource");        		
        		apiUrl = url+rgId+resource;
        	}

           String jsonString = given()//.log().all()
            		.baseUri(apiUrl).header("Content-Type", "application/json")
                    .header("Authorization", authtoken)  
                    .when().get().then().statusCode(200)//.log().all()
                    .extract().asString(); 
            
            // Create a JSONObject from the string
            JSONObject jsonObject = new JSONObject(jsonString);

            // Read ProjectTypes array
            JSONArray projectTypes = jsonObject.getJSONArray("ProjectTypes");
           // System.out.println("Project Types:");
            for (int i = 0; i < projectTypes.length(); i++) {
                JSONObject project = projectTypes.getJSONObject(i);
               // System.out.println("Type: " + project.getString("Type"));
                dataMap.put("RG_ProjectTypes", project.getString("Type"));
                break;
            }

            
            // Read Clients array
          JSONArray clients = jsonObject.getJSONArray("ClientIDs");// Work in QA
         //JSONArray clients = jsonObject.getJSONArray("Clients");
            //System.out.println("\nClients:");
            for (int i = 0; i < clients.length(); i++) {
                JSONObject client = clients.getJSONObject(i);
                //System.out.println("Type: " + client.getString("Type"));
                dataMap.put("RG_AuditTypes", client.getString("Type"));
                break;
            }

            // Read PatientName object
            JSONObject patientName = jsonObject.getJSONObject("PatientName");
            String namePart = patientName.getString("NamePart");
            JSONArray ranges = patientName.getJSONArray("Ranges");
           // System.out.println("\nPatient Name:");
           // System.out.println("Name Part: " + namePart);
            for (int i = 0; i < ranges.length(); i++) {
                JSONObject range = ranges.getJSONObject(i);
            //    System.out.println("Range: " + range.getString("startChar") + " to " + range.getString("endChar"));
                dataMap.put("RG_firstName",  range.getString("startChar"));
                dataMap.put("RG_lastName",  range.getString("endChar"));
                break;
                
            }

            // Read ChartTypes array
            JSONArray chartTypes = jsonObject.getJSONArray("ChartTypes");
            //System.out.println("\nChart Types:");
            for (int i = 0; i < chartTypes.length(); i++) {
                JSONObject chart = chartTypes.getJSONObject(i);
              //  System.out.println("Type: " + chart.getString("Type"));
                dataMap.put("RG_ChartTypes",  chart.getString("Type"));
                break;
                
            }

            // Read DatesOfService array
            JSONArray datesOfService = jsonObject.getJSONArray("DatesOfService");
           // System.out.println("\nDates of Service:");
            for (int i = 0; i < datesOfService.length(); i++) {
                JSONObject dateRange = datesOfService.getJSONObject(i);
                //System.out.println("Start Date: " + dateRange.getString("StartDate") + ", End Date: " + dateRange.getString("EndDate"));
                dataMap.put("RG_startDate",  dateRange.getString("StartDate"));
                dataMap.put("RG_endDate",  dateRange.getString("EndDate"));
                break;
            }

            // Read AuditTypes array
            JSONArray auditTypes = jsonObject.getJSONArray("AuditTypes");
         //   System.out.println("\nAudit Types:");
            for (int i = 0; i < auditTypes.length(); i++) {
                JSONObject audit = auditTypes.getJSONObject(i);
                //System.out.println("Type: " + audit.getString("Type"));
                dataMap.put("RG_AuditTypes",  audit.getString("Type"));
                break;
            }
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
     
		//Printing  using ForEachLoop	
     
		for(String k : dataMap.keySet())	
		{
			System.out.println(COLORS.BLUE+k    + "----------->"    +dataMap.get(k)+COLORS.RESET);			
		}
		
		
        return dataMap;
    }


}

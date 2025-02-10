package utils_API_TEST;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.COLORS;
import utils.PropertiesFileReader;

public class Automated_TestData_Creator_TEST {
	
    @DataProvider(name = "QA")
    public Object[][] QA_DataProvider() {
        return new Object[][] 
        	{
            	{"RG-20002", "P-388412033222"},
            	{"RG-20002", "P-388412033222"},            	  
        	};
    }
    
    @DataProvider(name = "UAT")
    public Object[][] UAT_DataProvider() {
        return new Object[][] 
        	{
            	{"RG-20002", "P-388412033222"},
            	{"RG-20002", "P-388412033222"},
            	{"RG-20002", "P-388412033222"},       
        	};
    }
	
		
	@Test(dataProvider = "QA", invocationCount = 1)
	public void processDataAndGenerateOutput(String requestGroup, String providerId) {		
			System.out.println(COLORS.GREEN+"Creating the Test Data in "+PropertiesFileReader.getAPIProperty("env")+" Environment. If you want to change the Environment, Kindly stop and update the 'Env' Variable Under the API Properiets File"+COLORS.RESET);
			String authtoken = Generate_OAuth2.Token(); 		
			String rgId = requestGroup; 
			String providerID = providerId ; 			
			ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();

			
			GET_RequestGroup_API_test.get_RequestGroup_Data(dataMap, rgId,authtoken);
  

				if(providerID.startsWith("F-"))
				{
					GET_Facility_API_test.get_Facility_Data(dataMap, providerID,authtoken );
				}
				else if(providerID.startsWith("P-"))
				{
					GET_Practitioner_API_test.get_Practitioner_Data(dataMap, providerID,authtoken); 
					
				}
			

		}
}
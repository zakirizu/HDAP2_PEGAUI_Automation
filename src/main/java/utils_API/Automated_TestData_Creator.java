package utils_API;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import factory.COLORS;


public class Automated_TestData_Creator {
	 private static final String env = "QA";

	
	    
	    @DataProvider(name = env)
	    public Object[][] UAT_DataProvider2() {
	    
	    	if(env.equalsIgnoreCase("QA"))
	    	{
	        return new Object[][] 
	        	{
	        	//Test
	        	//Enter the Request Group and Provider Details Here for QA Environment
	        	 {"RG-36010", "P-134669792725"},
	        //	 {"RG-35022", "P-157855884725"},	 //Alpha RG 
//        		    {"RG-73512850102019", "P-628385031024"},	 
//	        		{"RG-20002", "P-388412033222"},
//	        		{"RG-20013","P-329988776655"},
//	        		{"RG-22001","P-388412068877"},
	        	//Invalid Set of Data 	
	        		//{"RG-22001","P-329988776655"},

	        	};
	    	}
	        else
	        {
	    	return new Object[][] 
	    	 {
	    		//Enter the Request Group and Provider Details Here for UAT Environment
	    			{"RG-10002", "P-354531020225"}
	    	      };
	        	}
	        	
	        	
	        	
	    }

		
	@Test(dataProvider = env , invocationCount = 5)
	public void processDataAndGenerateOutput(String requestGroup, String providerId) {	
			System.out.println();
			System.out.println(COLORS.GREEN+"Creating the Test Data in " +COLORS.RED+env+COLORS.GREEN+" Environment. If you want to change the Environment, Kindly stop and update the 'Env' Variable Under the API Properiets File"+COLORS.RESET);
			String authtoken = Generate_OAuth2.Token(env); 		
			String rgId = requestGroup; 
			String providerID = providerId ; 			
			ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();

			
			GET_RequestGroup_API.get_RequestGroup_Data(dataMap, rgId,authtoken, env);
  

				if(providerID.startsWith("F-"))
				{
					GET_Facility_API.get_Facility_Data(dataMap, providerID,authtoken, env );
				}
				else if(providerID.startsWith("P-"))
				{
					GET_Practitioner_API.get_Practitioner_Data(dataMap, providerID,authtoken, env); 
					
				}
			

		}
}
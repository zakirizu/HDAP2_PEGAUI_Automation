package utils_API;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import factory.COLORS;
import factory.*;


public class Automated_TestData_Creator {

	
	int count = 1;
	 private static final String env = "QA";

	
	    
	    @DataProvider(name = env)
	    public Object[][] UAT_DataProvider2() {
	    
	    	if(env.equalsIgnoreCase("QA"))
	    	{
	        return new Object[][] 
	        	{
	
//Valid Set Of Data	   
		        {"RG-36024", "P-196212245725"}, 	
	        //	{"RG-36015","P-195206464425"}
	         //{"RG-31017", "P-134669792725"},
			//{"RG-36010", "P-134669792725"},
			//{"RG-35022", "P-157855884725"},	
			//{"RG-20002", "P-388412033222"},	        	
			//{"RG-20013","P-329988776655"},
			//{"RG-22001","P-388412068877"},
			//{"RG-73512850102019", "P-628385031024"},	 
	        	 
//Invalid Set of Data 	
				//{"RG-22001","P-329988776655"},
				//{"RG-36010", "P-157855884725"},
					        	
};
	    	}
	        else
	        {
	    	return new Object[][] 
	    	 {
//Valid Set Of Data For UAT
				{"RG-10002", "P-354531020225"}
				//{"RG-11006","P-388412088777"}
	    	      };
	        	}
	        	
	        	
	        	
	    }

		
	@Test(dataProvider = env , invocationCount =5)
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
					GET_Facility_API.get_Facility_Data(dataMap, providerID,authtoken, env, count );
				}
				else if(providerID.startsWith("P-"))
				{
					GET_Practitioner_API.get_Practitioner_Data(dataMap, providerID,authtoken, env, count); 
					
				}
			

		}
}
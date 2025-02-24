package utils_API;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import factory.COLORS;
import factory.*;


public class Automated_TestData_Creator_TEST {
	String SheetName ="ChaseData";
	String TestCaseID="testcase";
	
	HashMap<String,String> testData = getExcelData.API_Sheet_Data(SheetName, TestCaseID);
	
	
	String requestGroup 	= testData.get("RGID");
	String providerID 		= testData.get("ProviderID");
	String tempCount 		= testData.get("Count");
	int count 				= Integer.parseInt(tempCount);
	String env 				= testData.get("Environment");
	//int count = 3;
	

		
	@Test()
	public void processDataAndGenerateOutput() {	
		System.out.println(testData);
			System.out.println();
			System.out.println(COLORS.GREEN+"Creating the Test Data in " +COLORS.RED+env+COLORS.GREEN+" Environment. If you want to change the Environment, Kindly stop and update the 'Env' Variable Under the API Properiets File"+COLORS.RESET);
			String authtoken = Generate_OAuth2.Token(env); 		
			
			ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();
			GET_RequestGroup_API.get_RequestGroup_Data(dataMap, requestGroup,authtoken, env);
  

				if(providerID.startsWith("F-"))
				{
					GET_Facility_API.get_Facility_Data(dataMap, providerID,authtoken, env , count);
				}
				else if(providerID.startsWith("P-"))
				{
					GET_Practitioner_API.get_Practitioner_Data(dataMap, providerID,authtoken, env, count); 
					
				}
			

		}
}
package utils_API;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import factory.COLORS;
import factory.*;

public class Automated_TestData_Creator {

	@DataProvider(name = "testData")
    public Object[][] provideData() {
        return new Object[][] {
            {"QASet8"}
         //   {"QASet9"}
            
        };
    }
	
	@Test(dataProvider = "testData")
	public void processDataAndGenerateOutput(String testCaseID ) {	
		String SheetName 		="ChaseData";	
		HashMap<String,String> testData = getExcelData.API_Sheet_Data(SheetName, testCaseID);
		String requestGroup 	= testData.get("RGID");
		String providerID 		= testData.get("ProviderID");
		String tempCount 		= testData.get("Count");
		int count 				= Integer.parseInt(tempCount);
		String env 				= testData.get("Environment");
		String accountID 		= testData.get("AccountID");
		String subAccountID 	= testData.get("SubAccountID");
		ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();
		dataMap.put("accountID", accountID);
		dataMap.put("subAccountID", subAccountID);
		System.out.println(testData);
		System.out.println();
		System.out.println(COLORS.GREEN+"Creating the Test Data in " +COLORS.RED+env+COLORS.GREEN+" Environment. If you want to change the Environment, Kindly stop and update the 'Env' Variable Under the API Properiets File"+COLORS.RESET);
		
		String authtoken = Generate_OAuth2.Token(env);			
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
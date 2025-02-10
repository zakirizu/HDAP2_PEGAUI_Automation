package APIs_PayLoads;

import java.util.concurrent.ConcurrentHashMap;

import utils.PropertiesFileReader;

public class ChaseRequest_Facility_PayLoad {
	
	 public static  String FacilityPayLoad(ConcurrentHashMap<String, String> dataMap) {
		 //General Data
		 String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.currentDateTimeMilliSeconds();
     	 String accountID = PropertiesFileReader.getAPIProperty("Client_AccountID");
    	 String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");	 
		 
		 		 //RG Details from Map
		 String RG_intendedUse	 = dataMap.get("RG_ProjectTypes");//
		 String RG_AuditType			 = dataMap.get("RG_AuditTypes");//
		 String RG_CharTypes 		= dataMap.get("RG_ChartTypes");//
		 String RG_DOS 						= dataMap.get("RG_startDate");//
		 String RG_DOE 						= dataMap.get("RG_endDate");//
		 String RG_FName 				= dataMap.get("RG_firstName");//
		 String RG_LName 				= dataMap.get("RG_lastName");//
		 
		 
		 //Facility Datas
		 





		 
		String payLoad = "";
		return payLoad;
		
	}

}

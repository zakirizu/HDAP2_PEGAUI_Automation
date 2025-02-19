package APIs_PayLoads;

import java.util.concurrent.ConcurrentHashMap;

import utils.PropertiesFileReader;

public class ChaseRequest_Practitioner_PayLoad {
		 public static  String PractitionerPayLoad(ConcurrentHashMap<String, String> dataMap, String env) {
		 //General Data
		 String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.currentDateTimeMilliSeconds();
		 String accountID= ""; String subAccountID="";
     	 //String env = PropertiesFileReader.getAPIProperty("env");
     	 
     			if(env.equalsIgnoreCase("UAT"))
     			{
     				 accountID = PropertiesFileReader.getAPIProperty("UAT_AccountID");    
     				 subAccountID = PropertiesFileReader.getAPIProperty("UAT_SubAccountID");	 
     			}
     			else
     			{
     				 accountID = PropertiesFileReader.getAPIProperty("QA_AccountID");    
     				 subAccountID = PropertiesFileReader.getAPIProperty("QA_SubAccountID");	 
     			}

    	 		 	 
		 //RG Details from Map
		 String RG_intendedUse	 = dataMap.get("RG_ProjectTypes");// 
		 String RG_AuditType			 = dataMap.get("RG_AuditTypes");//
		 String RG_CharTypes 		= dataMap.get("RG_ChartTypes");//
		 String RG_DOS 						= dataMap.get("RG_startDate");//
		 String RG_DOE 						= dataMap.get("RG_endDate");//
		 String RG_FName 				= dataMap.get("RG_firstName");//
		 String RG_LName 				= dataMap.get("RG_lastName");//
		 
		 
		
		 
		 //Practitioner Data
		 		//String Prac_DOB 				= dataMap.get("Prac_DOB");
				String Prac_Street 			= dataMap.get("Prac_Street");
				String Prac_LastName 	= dataMap.get("Prac_LastName");
				String Prac_City 				= dataMap.get("Prac_City");
				//String Prac_Email 			= dataMap.get("Prac_Email");
				String Prac_FirstName 	= dataMap.get("Prac_FirstName");
				String Prac_PostalCode	= dataMap.get("Prac_PostalCode");
				//String Prac_Gender 		= dataMap.get("Prac_Gender");
				String Given_Prac_Phone 			= dataMap.get("Prac_Phone");
				String  Prac_Phone = Given_Prac_Phone.replaceAll("\\(|\\)", "").replace(" ", "-");
				//String Prac_Languages 	= dataMap.get("Prac_Languages");
				String Prac_State 			= dataMap.get("Prac_State");				
				String Prac_NPI 			= dataMap.get("Prac_NPI");
				
				String tempNPI 			= dataMap.get("Prac_TIN");
				
				String Prac_TIN = tempNPI.length() >= 9 ? tempNPI.substring(0, 9) : tempNPI;
				
			//	String Prac_TIN = 
				
				
				String given_Prac_FAX 			= dataMap.get("Prac_FAX").replaceAll("\\D", "");
	            String Prac_FAX = given_Prac_FAX.substring(0, 3) + "-" +given_Prac_FAX.substring(3, 6) + "-" + given_Prac_FAX.substring(6); 

		String payLoad = "{\r\n"
				+ "    \"ChaseRequest\": {\r\n"
				+ "        \"ChaseRequestHeader\": {\r\n"
				+ "            \"IntendedUse\": \""+RG_intendedUse+"\",\r\n"
				+ "            \"AuditType\": \""+RG_AuditType+"\",\r\n"
				+ "            \"ChartType\": \""+RG_CharTypes+"\",\r\n"
				+ "            \"RelatedChaseID\": \"911\",\r\n"
				+ "            \"ExternalChaseNumber\": \"894986377\",\r\n"
				+ "            \"GlobalWorkforceApproved\": false,\r\n"
				+ "            \"ExpirationDate\": \"2025-12-09\",\r\n"
				+ "            \"MRAvailableInClientSystem\": false,\r\n"
				+ "            \"MRClientSystemDCN\": \"8478579337\",\r\n"
				+ "            \"ProspectiveClaimFlag\": false,\r\n"
				+ "            \"ClientID\": 13,\r\n"
				+ "            \"AccountID\": \""+accountID+"\",\r\n"
				+ "            \"SubAccountId\": \""+subAccountID+"\",\r\n"
				+ "            \"PortalRequestCode\": \"46378\",\r\n"
				+ "            \"PlanName\": \"6\",\r\n"
				+ "            \"PrimaryChaseRequestProviderRole\": \"RenderingProvider\",\r\n"
				+ "            \"ExplicitRequestGroupId\": null\r\n"
				+ "        },\r\n"
				+ "        \"ClaimDetails\": {\r\n"
				+ "            \"CotivitiClaimNumber\": \""+cotivitClaimNumber+"\",\r\n"
				+ "            \"ClaimType\": \"S\",\r\n"
				+ "            \"InNetwork\": true,\r\n"
				+ "      \"ClientClaimNumber\": \"5106326342\",\r\n"
				+ "            \"DateOfServiceStart\": \""+RG_DOS+"\",\r\n" 
				+ "            \"DateOfServiceEnd\": \""+RG_DOS+"\",\r\n" 
				+ "            \"TotalClaimAmt\": 1666.09,\r\n"
				+ "            \"ProviderSpecialty\": \"test\",\r\n"
				+ "            \"PatientMemberIdx\": 1,\r\n"
				+ "            \"SubscriberMemberIdx\": 2,\r\n"
				+ "            \"BillingProviderIdx\": 2,\r\n"
				+ "            \"RenderingProviderIdx\": 1\r\n"
				+ "        },\r\n"
				+ "        \"ChaseDetails\": {\r\n"
				+ "            \"DOSChartRangeStart1\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeEnd1\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeStart2\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeEnd2\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeStart3\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeEnd3\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeStart4\": \"2022-09-26\",\r\n"
				+ "            \"DOSChartRangeEnd4\": \"2022-09-26\",\r\n"
				+ "            \"DeliveryDate\": \"2022-09-26\",\r\n"
				+ "            \"RetrievalRank\": 8,\r\n"
				+ "            \"HedisMeasureID\": \"HEDIS26\",\r\n"
				+ "            \"MeasurementGap\": \"Measure2\",\r\n"
				+ "            \"SubMeasurementGap\": \"SubMeasure5\",\r\n"
				+ "            \"IsOversampleFlag\": true,\r\n"
				+ "            \"ChasePriority\": \"High\",\r\n"
				+ "            \"RADVEnrolleeID\": \"RADV3354\",\r\n"
				+ "            \"MedicareAdvantagecontractNumber\": \"MA353\"\r\n"
				+ "        },\r\n"
				+ "        \"Members\": [\r\n"
				+ "            {\r\n"
				+ "                \"Member\": {\r\n"
				+ "                  \"LastName\": \"Phi\",\r\n"
				+ "                 \"FirstName\": \"Team\",\r\n"
				+ "                    \"Address1\": \"048 Hinton Loop Apt. 872\",\r\n"
				+ "                    \"Address2\": \"Apt. 736\",\r\n"
				+ "                    \"City\": \"Kathleenside\",\r\n"
				+ "                    \"State\": \"KY\",\r\n"
				+ "                    \"Zip\": \"62417\",\r\n"
				+ "                    \"DOB\": \"1983-04-18\",\r\n"
				+ "                    \"Gender\": \"M\",\r\n"
				+ "                    \"SSN\": \"495-92-8935\",\r\n"
				+ "                    \"PatientId\": \"4145\",\r\n"
				+ "                    \"HICN\": \"716351468\",\r\n"
				+ "                    \"ControlNumber\": \"9679\",\r\n"
				+ "                    \"MBI\": \"98716\",\r\n"
				+ "                    \"RecordNumber\": \"87618\",\r\n"
				+ "                    \"ClientMemberID\": \"89225\"\r\n"
				+ "                }\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"Member\": {\r\n"
				+ "                    \"LastName\": \"Phi\",\r\n"
				+ "                    \"FirstName\": \"Qui\",\r\n"
				+ "                    \"Address1\": \"644 Rachel Ridge Apt. 945\",\r\n"
				+ "                    \"Address2\": \"Suite 660\",\r\n"
				+ "                    \"City\": \"East Victoriaborough\",\r\n"
				+ "                    \"State\": \"MS\",\r\n"
				+ "                    \"Zip\": \"14075\",\r\n"
				+ "                    \"DOB\": \"2008-02-27\",\r\n"
				+ "                    \"Gender\": \"F\",\r\n"
				+ "                    \"SSN\": \"790-57-4891\",\r\n"
				+ "                    \"PatientId\": \"4906\",\r\n"
				+ "                    \"HICN\": \"949290986\",\r\n"
				+ "                    \"ControlNumber\": \"1092\",\r\n"
				+ "                    \"MBI\": \"77340\",\r\n"
				+ "                    \"RecordNumber\": \"26970\",\r\n"
				+ "                    \"ClientMemberID\": \"57303\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"Providers\": [\r\n"
				+ "            {\r\n"
				+ "                \"Provider\": {\r\n"
				+ "                    \"Name\": \""+Prac_FirstName+" "+Prac_LastName+"\",\r\n"
				+ "                    \"LastName\": \""+Prac_LastName+"\",\r\n"
				+ "                    \"FirstName\": \""+Prac_FirstName+"\",\r\n"
				+ "                    \"Address1\": \""+Prac_Street+"\",\r\n"
				+ "                    \"Address2\": \"Suite 358\",\r\n"
				+ "                    \"City\": \""+Prac_City+"\",\r\n"
				+ "                    \"State\": \""+Prac_State+"\",\r\n"
				+ "                    \"Zip\": \"60923\",\r\n"
				+ "                    \"NPI\": \""+Prac_NPI+"\",\r\n"
				+ "                    \"TIN\": \""+Prac_TIN+"\",\r\n"
				+ "                    \"Phone1\": \""+Prac_Phone+"\",\r\n"
				+ "                    \"Phone2\": \"746-655-2864\",\r\n"
				+ "                    \"Phone3\": \"586-128-4316\",\r\n"
				+ "                    \"Fax\": \""+Prac_FAX+"\",\r\n"
				+ "                    \"ClientProviderId\": \"3435\"\r\n"
				+ "                }\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"Provider\": {\r\n"
				+ "                    \"Name\": \"\",\r\n"
				+ "                    \"LastName\": \"Messer\",\r\n"
				+ "                    \"FirstName\": \"Michelle\",\r\n"
				+ "                    \"Address1\": \"94966 Glass Roads Suite 263\",\r\n"
				+ "                    \"Address2\": \"Suite 669\",\r\n"
				+ "                    \"City\": \"Davidfurt\",\r\n"
				+ "                    \"State\": \"MT\",\r\n"
				+ "                    \"Zip\": \"43489\",\r\n"
				+ "                    \"NPI\": \"1528144581\",\r\n"
				+ "                    \"TIN\": \"967050750\",\r\n"
				+ "                    \"Phone1\": \"672-418-1811\",\r\n"
				+ "                    \"Phone2\": \"242-244-8446\",\r\n"
				+ "                    \"Phone3\": \"366-449-9188\",\r\n"
				+ "                    \"Fax\": \"168-994-3569\",\r\n"
				+ "                    \"ClientProviderId\": \"619\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    }\r\n"
				+ "}";
		return payLoad;
		
	}

}

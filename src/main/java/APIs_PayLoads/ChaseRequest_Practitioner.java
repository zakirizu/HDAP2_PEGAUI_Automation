package APIs_PayLoads;

import java.util.concurrent.ConcurrentHashMap;

import utils.PropertiesFileReader;

public class ChaseRequest_Practitioner {
	
	 public static  String Practitioner_Provider(ConcurrentHashMap<String, String> dataMap) {
		 //General Data
		 String cotivitClaimNumber = stepDefinitionFile.Common_Functions_Sd.currentDateTimeMilliSeconds();
     	 String accountID = PropertiesFileReader.getAPIProperty("Client_AccountID");
    	 String subAccountID = PropertiesFileReader.getAPIProperty("SubAccountID");	 
		 
		 
		 //RG Details from Map
		 String RG_intendedUse	 = dataMap.get("RGProjectTypes");//
		 String RG_AuditType			 = dataMap.get("RGAuditTypes");//
		 String RG_CharTypes 		= dataMap.get("RGChartTypes");//
		 String RG_DOS 						= dataMap.get("RGstartDate");//
		 String RG_DOE 						= dataMap.get("RGendDate");//
		 String RG_FName 				= dataMap.get("RGfirstName");//
		 String RG_LName 				= dataMap.get("RGlastName");//
		 
		 //Practitioner Data
         String P_FName						= dataMap.get("PfirstName");
         String P_LName    					=dataMap.get("PlastName");
         String P_TIN    							=dataMap.get("Ptin");
         String P_NPI   							 =dataMap.get("Pnpi");
         String P_Phone 						=dataMap.get("Pphone" );
         String P_Email    						=dataMap.get("Pemail" );
         String P_Fax    =dataMap.get("Pfax");
         String P_pager    =dataMap.get("Ppager");
         String P_Languages    =dataMap.get("Planguages");
         String P_Specaility   =dataMap.get("Pspecialty");
         String P_Street    =dataMap.get("Pstreet");
         String P_City    =dataMap.get("Pcity");
         String P_State    =dataMap.get("Pstate");
         String P_PostalCode    =dataMap.get("PpostalCode");
         String P_PractitionerID    =dataMap.get("PpractitionerId");
         




		 
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
				+ "            \"DateOfServiceStart\": \""+RG_DOS+10+"\",\r\n"
				+ "            \"DateOfServiceEnd\": \""+RG_DOE+"\",\r\n"
				+ "            \"TotalClaimAmt\": 1666.09,\r\n"
				+ "            \"ProviderSpecialty\": \"test\",\r\n"
				+ "            \"PatientMemberIdx\": 1,\r\n"
				+ "            \"SubscriberMemberIdx\": 2,\r\n"
				+ "            \"BillingProviderIdx\": 1,\r\n"
				+ "            \"RenderingProviderIdx\": 2\r\n"
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
				+ "                    \"Name\": \""+P_FName+P_LName+"\",\r\n"
				+ "                    \"LastName\": \""+P_FName+"\",\r\n"
				+ "                    \"FirstName\": \""+P_LName+"\",\r\n"
				+ "                    \"Address1\": \""+P_Street+"\",\r\n"
				+ "                    \"Address2\": \"Suite 358\",\r\n"
				+ "                    \"City\": \""+P_City+"\",\r\n"
				+ "                    \"State\": \""+P_State+"\",\r\n"
				+ "                    \"Zip\": \"60923\",\r\n"
				+ "                    \"NPI\": \""+P_NPI+"\",\r\n"
				+ "                    \"TIN\": \""+P_TIN+"\",\r\n"
				+ "                    \"Phone1\": \""+P_Phone+"\",\r\n"
				+ "                    \"Phone2\": \"746-655-2864\",\r\n"
				+ "                    \"Phone3\": \"586-128-4316\",\r\n"
				+ "                    \"Fax\": \""+P_Fax+"\",\r\n"
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

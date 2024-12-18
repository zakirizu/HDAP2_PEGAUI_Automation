package APIs_PayLoads;

public class Add_Misc_Documents_To_ChaseRequests {
	public static  String payLoad_Add_Misc_Documents_To_ChaseRequests(String requestID) {		
		String payLoad ="{\r\n"
				+ "    \"MiscDocuments\": [\r\n"
				+ "        {\r\n"
				+ "            \"MiscDocRef\": \"https://workflow.api.hdap.cotiviti.com/Workflow/MiscDocuments/"+requestID+"-1008/Image\",\r\n"
				+ "            \"ID\": \"https://workflow.api.hdap.cotiviti.com/Workflow/ChaseRequests/"+requestID+"/MiscDocuments/"+requestID+"-1008\",\r\n"
				+ "            \"ClassificationType\": null,\r\n"
				+ "            \"IsProcessed\": null\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
				return payLoad;
	}
}



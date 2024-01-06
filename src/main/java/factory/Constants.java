package factory;

import java.io.File;

import utils.PropertiesFileReader;



public interface Constants {	
	String PROJECT_PATH 	= System.getProperty("user.dir");
	String RESOURCES 		= PROJECT_PATH + File.separator + "Resources";	
	String PROPERTYFILE 	= PROJECT_PATH + File.separator + "Resources"+ File.separator + "propertyFile.properties";
	String DIT_FILE			= PROJECT_PATH + File.separator + "TestData" + File.separator + "DIT_File.xlsx";
	String UI_TESTDATA		= PROJECT_PATH + File.separator + "TestData" + File.separator + "UI_TestData.xlsx";
	//String SCREENSHOT		= "https://cotiviti-my.sharepoint.com/personal/shaik_hussain_cotiviti_com/_layouts/15/onedrive.aspx?login_hint=shaik%2Ehussain%40cotiviti%2Ecom&id=%2Fpersonal%2Fshaik%5Fhussain%5Fcotiviti%5Fcom%2FDocuments%2FPhi%20Team%20QA%20Only%2FAutomation%2FAutomation%20Test%20Results&view=0";
	String SCREENSHOT       = PROJECT_PATH + File.separator + "ScreenShots";
	String REPORTS       	= PROJECT_PATH + File.separator + "Reports";
	String Environment		= PropertiesFileReader.getProperty("Env");
}

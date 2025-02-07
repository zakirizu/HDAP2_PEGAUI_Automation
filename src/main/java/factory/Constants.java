package factory;

import java.io.File;
import utils.PropertiesFileReader;



public interface Constants {	
	String PROJECT_PATH 	= System.getProperty("user.dir");
	String RESOURCES 			= PROJECT_PATH + File.separator + "Resources";	
	String PROPERTYFILE 		= PROJECT_PATH + File.separator + "Resources"+ File.separator + "propertyFile.properties";
	String UI_TESTDATA		= PROJECT_PATH + File.separator + "TestData" + File.separator + "ExcelSheet_TestData_UI.xlsx";
	String API_INPUT			= PROJECT_PATH + File.separator + "TestData" + File.separator + "API_INPUT.xlsx";
	String API_OUTPUT		= PROJECT_PATH + File.separator + "TestData" + File.separator + "API_OUTPUT.xlsx";
	String SCREENSHOT      	= PROJECT_PATH + File.separator + "ScreenShots"+ File.separator ;
	String REPORTS       		= PROJECT_PATH + File.separator + "Reports"+ File.separator ;
	String Environment			= PropertiesFileReader.getUIProperty("Env");
}

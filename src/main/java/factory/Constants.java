package factory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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
	String env       					= PropertiesFileReader.getAPIProperty("env");
	String Environment			= PropertiesFileReader.getUIProperty("Env");
	List<String> firstNames_list = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emma", "Fiona", "George", "Hannah", "Ian", "Jack",
            									"Karen", "Liam", "Mia", "Nathan", "Olivia", "Paul", "Quinn", "Rachel", "Samuel", "Tina",
            									"James", "Lucas", "Mason", "Noah", "Oliver", "Ava", "Benjamin", "Chloe", "Dylan", "Ella",
            									"Henry", "Grace", "Jackson", "Leo", "Madison", "Nathaniel", "Owen", "Penelope", "Ryan", "Zoe");
	List<String> lastNames_list = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez","Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin",
	            "Lee", "Perez", "Thompson", "White", "Harris");
}

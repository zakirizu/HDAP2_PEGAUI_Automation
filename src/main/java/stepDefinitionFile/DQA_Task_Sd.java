package stepDefinitionFile;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import factory.*;
import io.cucumber.java.en.Then;
import utils.DependencyInjection;



public class DQA_Task_Sd {
	DependencyInjection obj;
	public DQA_Task_Sd(DependencyInjection obj)
	{
		this.obj = obj;
	}
	static Logger 						myLogger 	= LogManager.getLogger(DQA_Task_Sd.class.getName());
	
	//Add this piece of code to read data from Excel Sheet. Change the Sheet Name
	HashMap<String,String> testData;	
	@Then("^Read ExcelData from DQATaskSheet  for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet( String TestCaseID) {		
		testData = getExcelData.UI_Sheet_Data("DQA", TestCaseID);
		return testData;		
	}

   
	


}

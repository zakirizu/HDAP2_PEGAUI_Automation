package utils_API;

import static io.restassured.RestAssured.given;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import factory.COLORS;
import io.restassured.RestAssured;
import utils.PropertiesFileReader;

public class Automated_TestData_Creator {
	
    static String authtoken = ""; 
    static String inputFilePath = factory.Constants.API_INPUT;
    static String outputFilePath = factory.Constants.API_OUTPUT;   
     String resource = PropertiesFileReader.getAPIProperty("chaseRequest_resource");
	ConcurrentHashMap<String, String> dataMap;
	
	
	public static void main(String[] args) {
		System.out.println("Creating the Test Data in "+COLORS.RED+PropertiesFileReader.getAPIProperty("env")+COLORS.RESET+" Environment. If you want to change the Environment, Kindly stop and update the 'Env' Variable Under the API Properiets File");
		 authtoken = Generate_OAuth2.Token(); 		
		Automated_TestData_Creator processor = new Automated_TestData_Creator();
		processor.processDataAndGenerateOutput(inputFilePath,outputFilePath );
		
	}


	public void processDataAndGenerateOutput(String inputFilePath, String outputFilePath) {
		try {
			// Load the input Excel file
			FileInputStream fis = new FileInputStream(inputFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet inputSheet = workbook.getSheetAt(0); 
		
			// Iterate through the input data rows
			for (Row inputRow : inputSheet) {
				if (inputRow.getRowNum() == 0) {
					continue; // Skip the header row
				}

				String rgId = inputRow.getCell(0).getStringCellValue();
				String providerID = inputRow.getCell(1).getStringCellValue();
				dataMap = new ConcurrentHashMap<>();
				
				GET_RequestGroup_API rgProcessor = new GET_RequestGroup_API();
				rgProcessor.get_RequestGroup_Data(dataMap, rgId);
				
				

				if(providerID.startsWith("F-"))
				{
					System.out.println("Reading the Facility Data");
					Get_Facility_API factProcessor = new Get_Facility_API();
					factProcessor.get_Facility_Data(dataMap, providerID);
					String env = PropertiesFileReader.getAPIProperty("env");
					if(env.equalsIgnoreCase("QA"))
					{
						RestAssured.baseURI = PropertiesFileReader.getAPIProperty("QA_chaseRequest_url");
					}
					else
					{
						RestAssured.baseURI = PropertiesFileReader.getAPIProperty("UAT_chaseRequest_url");
					}
					
					given()//.log().all()
					.header("Content-Type", "application/json").header("Authorization", authtoken)
							.body(APIs_PayLoads.ChaseRequest_Practitioner.Practitioner_Provider(dataMap))
							.when().post(resource)
							.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
					
				}
				else if(providerID.startsWith("P-"))
				{
					System.out.println("Getting the Practitioner Data");
					PractDataProcessor practProcessor = new PractDataProcessor();
					practProcessor.get_Practitioner_Data(dataMap, providerID);
					String env = PropertiesFileReader.getAPIProperty("env");
					if(env.equalsIgnoreCase("UAT"))
					{
						RestAssured.baseURI = PropertiesFileReader.getAPIProperty("UAT_chaseRequest_url");
					}
					else
					{
						RestAssured.baseURI = PropertiesFileReader.getAPIProperty("QA_chaseRequest_url");
					}
										
					RestAssured.baseURI = PropertiesFileReader.getAPIProperty("chaseRequest_url");
					given()//.log().all()
					.header("Content-Type", "application/json").header("Authorization", authtoken)
							.body(APIs_PayLoads.ChaseRequest_Practitioner.Practitioner_Provider(dataMap))
							.when().post(resource)
							.then().log().body(true).assertThat().statusCode(202).extract().response().jsonPath();
				}
			}
			workbook.close();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}









}

package utils_API;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonDataProcessor {
	
    static String authtoken = OAuth2_Token_UAT.Generate_UAT_OAuth(); // Fetches the authorization token
    static String inputFilePath = factory.Constants.API_INPUT;
    static String outputFilePath = factory.Constants.API_OUTPUT;
	XSSFSheet sheet;
	XSSFWorkbook writeWB;
	ConcurrentHashMap<String, String> dataMap;
	// Main method for testing
	public static void main(String[] args) {
		CommonDataProcessor processor = new CommonDataProcessor();
		//processor.processDataAndGenerateOutput("input.xlsx", "output.csv");
		processor.processDataAndGenerateOutput(inputFilePath,outputFilePath );
	}



    // Process each row in the input Excel file and store results in output CSV
	public void processDataAndGenerateOutput(String inputFilePath, String outputFilePath) {
		try {
			// Load the input Excel file
			FileInputStream fis = new FileInputStream(inputFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet inputSheet = workbook.getSheetAt(0); // Assuming input data is in the first sheet
		
			// Iterate through the input data rows
			for (Row inputRow : inputSheet) {
				if (inputRow.getRowNum() == 0) {
					continue; // Skip the header row
				}

				String rgId = inputRow.getCell(0).getStringCellValue();
				String factId = inputRow.getCell(1).getStringCellValue();
				//String practId = inputRow.getCell(2).getStringCellValue();

				// Initialize the data map for this row
				//ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();
				dataMap = new ConcurrentHashMap<>();

				// Process the data for RG, Fact, and Pract
				RGDataProcessor rgProcessor = new RGDataProcessor();
				rgProcessor.processRGData(dataMap, rgId);

				FactDataProcessor factProcessor = new FactDataProcessor();
				factProcessor.processFactData(dataMap, factId);

			//	PractDataProcessor practProcessor = new PractDataProcessor();
			//	practProcessor.processPractData(dataMap, practId);
				
				//Wrting the data into Excel Sheet
				writeWB = new XSSFWorkbook();
				sheet = writeWB.createSheet("chaseData");
				writeHeaderdata();
				int rowNum = 1;
				Row row = sheet.createRow(rowNum++);
				writeRowData(row);
				
				System.out.println("ZAKIR");
				FileOutputStream fileOut = new FileOutputStream(outputFilePath);
				writeWB.write(fileOut);
		        System.out.println("Excel file written successfully!");
				
			}
			writeWB.close();
			workbook.close();

		

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



	private void writeRowData(Row row) {
		row.createCell(0).setCellValue("");
        row.createCell(1).setCellValue("RGAuditTypes");
        row.createCell(2).setCellValue("RGChartTypes");
        row.createCell(3).setCellValue("RGstartDate");
        row.createCell(4).setCellValue("RGendDate");
        row.createCell(5).setCellValue("RGfirstName");
        row.createCell(6).setCellValue("RGlastName");
        row.createCell(7).setCellValue("Fname");
        row.createCell(8).setCellValue("Ftin");
        row.createCell(9).setCellValue("Fnpi");
        row.createCell(10).setCellValue("Fphone");
        row.createCell(11).setCellValue("Fstreet");
        row.createCell(12).setCellValue("Fcity");
        row.createCell(12).setCellValue("Fstate");
        row.createCell(14).setCellValue("FpostalCode");
        row.createCell(15).setCellValue("Facility");
        row.createCell(16).setCellValue("PfirstName");
        row.createCell(17).setCellValue("PlastName");
        row.createCell(18).setCellValue("Ptin");
        row.createCell(19).setCellValue("Pnpi");
        row.createCell(20).setCellValue("Pstreet");
        row.createCell(21).setCellValue("Pcity");
        row.createCell(22).setCellValue("Pstate");
        row.createCell(23).setCellValue("PpostalCode");
	}



	private void writeHeaderdata() {

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("RG_IntendedUse");
        headerRow.createCell(1).setCellValue("RG_AuditTypes");
        headerRow.createCell(2).setCellValue("RG_ChartTypes");
        headerRow.createCell(3).setCellValue("RG_DOSstartDate");
        headerRow.createCell(4).setCellValue("RG_DOEendDate");
        headerRow.createCell(5).setCellValue("RG_firstName");
        headerRow.createCell(6).setCellValue("RG_lastName");
        headerRow.createCell(7).setCellValue("F_Name");
        headerRow.createCell(8).setCellValue("F_TIN");
        headerRow.createCell(9).setCellValue("F_NPI");
        headerRow.createCell(10).setCellValue("F_phone");
        headerRow.createCell(11).setCellValue("F_Street");
        headerRow.createCell(12).setCellValue("F_City");
        headerRow.createCell(12).setCellValue("F_State");
        headerRow.createCell(14).setCellValue("F_PostalCode");
        headerRow.createCell(15).setCellValue("Facility");
        headerRow.createCell(16).setCellValue("P_FirstName");
        headerRow.createCell(17).setCellValue("P_LastName");
        headerRow.createCell(18).setCellValue("P_TIN");
        headerRow.createCell(19).setCellValue("P_NPIi");
        headerRow.createCell(20).setCellValue("P_Street");
        headerRow.createCell(21).setCellValue("P_City");
        headerRow.createCell(22).setCellValue("P_State");
        headerRow.createCell(23).setCellValue("P_postalCode");
		
	}


}

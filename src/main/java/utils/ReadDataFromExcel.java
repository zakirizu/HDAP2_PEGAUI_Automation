package utils;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import factory.Constants;




public class ReadDataFromExcel {
	static HashMap<String, String> hmap = null;
	static String path 			= Constants.UI_TESTDATA;
	static FileInputStream fis 	= null;
	static Logger mylogger 		= LogManager.getLogger(ReadDataFromExcel.class.getName());
	

	public static HashMap<String, String> getExcelData(String sheetName, String tcID)
	{
		try 
		{
			mylogger.info("RECOMMENDED: PLEASE MAKE THE TEST DATA SHEET TO READ ONLY MODE.");
			mylogger.info("Reading Data from the Excel Sheet for TestCaseID: "+tcID);
			hmap 					= new HashMap<String,String>();
			fis 					= new FileInputStream(path);
			XSSFWorkbook workbook 	= new XSSFWorkbook(fis);
			XSSFSheet sheet 		= workbook.getSheet(sheetName);			
			int lastRowCount 		= sheet.getLastRowNum();			
			//System.out.println("Last Row Count is: "+lastRowCount);
			
			for(int i=0;i<lastRowCount;i=i+2)
			{
				String temp = sheet.getRow(i).getCell(0).getStringCellValue();
				if(temp.equalsIgnoreCase(tcID))
				{
					XSSFRow targetKeyRow 	= sheet.getRow(i);
					XSSFRow targetValueRow 	= sheet.getRow(i+1);
					int lastColumn 			= targetKeyRow.getLastCellNum();
					
					for(int j=1; j<lastColumn-1; j++)						
					{
						String k = targetKeyRow.getCell(j).getStringCellValue();
						String v = targetValueRow.getCell(j).getStringCellValue();
						hmap.put(k, v);
					}
					mylogger.info("Successfully Read the Data from the Excel Sheet for TestCaseID: "+tcID);
					break;}
			}
		}
		
		catch(Exception e)
		{
			mylogger.info("Exception Ouccred while Reading data from Excel Sheet:"+path);
			e.printStackTrace();
		}
		
	return hmap;
		}
}

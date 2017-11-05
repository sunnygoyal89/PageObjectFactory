package com.training.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public void readExcelFile(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);
		//C:\Users\lenovo\Desktop\Book1.xlsx
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		// Find the file extension by splitting file name in substring and
		// getting only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf('.'));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class

			workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet sheet = workbook.getSheet(sheetName);
		
		// Find number of rows in excel file

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i <= rowCount; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}

			System.out.println();

		}

	}

	/*
	 * public ReadExcel(String filePath, String fileName, String sheetName){
	 * 
	 * }
	 */

	public static String[][] getExcelTable(String filePath, String sheetName) {
		String[][] table = null;
		File file = null;
		FileInputStream inputStream = null;
		Workbook workbook = null;
		Sheet sheet;

		try {
			file = new File(filePath);
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getLastRowNum();
			table = new String[rowCount][];
			// Create a loop over all the rows of excel file to read it

			for (int i = 1; i <= rowCount; i++) {
				
				Row row = sheet.getRow(i);
				int cellCount = row.getLastCellNum() - row.getFirstCellNum();
				table[i-1] = new String[cellCount];
				for (int j = 0; j < cellCount; j++) {
					
					String cellVaue= row.getCell(j).getStringCellValue();
					
					table[i-1][j] = cellVaue;
					
					System.out.print( "| " + row.getCell(j).getStringCellValue() + " |");
				}
			}
			
			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		return table;
	}

	// Main function is calling readExcel function to read data from excel file

	public static void main(String[] args) {

		// Create an object of ReadGuru99ExcelFile class

		//ReadExcel objExcelFile = new ReadExcel();

		// Prepare the path of excel file

		String filePath = System.getProperty("user.dir") + "\\resource";

		// Call read file method of the class to read data
		ReadExcel.getExcelTable(filePath + "\\TestData.xlsx", "Login");
		
		//objExcelFile.readExcelFile(filePath, "CompanyData.xlsx", "Sheet1");

	}
}
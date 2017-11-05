package com.training.data;

import org.testng.annotations.DataProvider;

import com.training.util.ReadExcel;

public class ExternalDP {

	//System.getProperty("user.dir") will return this project's home directory path
	private static final String resourcePath = System.getProperty("user.dir") + "/resource";

	
	//when dataProvider is another class than we need to make method as 'static'
	@DataProvider(name = "validLoginDataProvider")
	public static Object[][] validLoginDataProvider() {
		
		// Call read file method of the class to read data
		String[][] dataTable = ReadExcel.getExcelTable(resourcePath + "/TestData.xlsx", "ValidLogin");
		
		return dataTable;
	}
	
	@DataProvider(name = "invalidLoginDataProvider")
	public static Object[][] invalidLoginDataProvider() {
		
		String[][] dataTable = ReadExcel.getExcelTable(resourcePath + "/TestData.xlsx", "InvalidLogin");

		return dataTable;
	}
}

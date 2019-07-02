package com.qa.FreeCrmPro.Utility;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

public ExcelDataProvider() {

	try {

		File fs = new File(System.getProperty("user.dir") + "//TestData//freeCrmTestData.xlsx");

		FileInputStream fins = new FileInputStream(fs);

		wb = new XSSFWorkbook(fins);

	} catch (Exception e) {
		
		System.out.println("excel Not able to found in the folder"+e.getMessage());
	}
}

public String getStringData(String sheetName, int row, int col) {

	XSSFSheet sheet = wb.getSheet(sheetName);

	return sheet.getRow(row).getCell(col).getStringCellValue();
}

public String getStringData(int sheetIndex, int row, int col) {

	XSSFSheet sheet = wb.getSheetAt(sheetIndex);

	return sheet.getRow(row).getCell(col).getStringCellValue();
}

public int getNumericgData(String sheetName, int row, int col) {

	XSSFSheet sheet = wb.getSheet(sheetName);

	return (int)sheet.getRow(row).getCell(col).getNumericCellValue();
}

public int getNumericgData(int sheetIndex, int row, int col) {

	XSSFSheet sheet = wb.getSheetAt(sheetIndex);

	return (int)sheet.getRow(row).getCell(col).getNumericCellValue();
}

public Object[][] getExcelData(String sheetName){
	
	 XSSFSheet sheet = wb.getSheet(sheetName);
	 
	 int rows = sheet.getLastRowNum();
	 
	 short cols = sheet.getRow(0).getLastCellNum();
	 
	Object data [][]= new Object[rows][cols];
	
	for(int i=0; i< rows; i++){
		
		for(int j=0; j< cols; j++){
			
			data[i][j] =sheet.getRow(i+1).getCell(j).toString();
		}
	}
	
	return data;
	
}
}

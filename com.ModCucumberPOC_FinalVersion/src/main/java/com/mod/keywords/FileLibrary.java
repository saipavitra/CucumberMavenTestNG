package com.mod.keywords;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mod.configurations.Config;

public class FileLibrary {
	public static FileInputStream file = null;;
	public static XSSFWorkbook book = null;
	public static XSSFSheet sheet = null;

	public static void readData(String fileName, String sheetName, String scenario) throws IOException {
		String filePath = Config.testdataPath + fileName + ".xlsx";
		file = new FileInputStream(filePath);
		book = new XSSFWorkbook(file);
		sheet = book.getSheet(sheetName); 
		// sheet = book.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 1; j < cellCount; j++) {
				String testScenario = sheet.getRow(i).getCell(0).getStringCellValue();
				if (testScenario.equalsIgnoreCase(scenario)) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value =row.getCell(j).getStringCellValue();
					Config.testdata.put(key, value);
				}
			}
			book.close();
			file.close();
		}
	}
}

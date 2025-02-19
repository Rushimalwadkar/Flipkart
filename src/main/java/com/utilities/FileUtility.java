package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtility {
	public String getProperty(String filePath, String key) {
		String baseDir = System.getProperty("user.dir");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(baseDir + filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Properties prop = new Properties();
		String value = "";
		try {
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	public String getConfiguration(String key) {
		return getProperty("/src/main/resources/config.properties", key);
	}

	public void loadExcel(String filePath) {

	}

	public String[] getRowFromExcel(String filePath, String sheetName, int rowNum) {
		String[] data;
		Workbook book = null;
		try {
			book = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		data = new String[row.getLastCellNum()];
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			switch (cell.getCellTypeEnum()) {
			case STRING:
				data[i] = cell.getStringCellValue();
				break;
			case NUMERIC:
				data[i] = String.valueOf(cell.getNumericCellValue());
			default:
				break;
			}

		}

		return data;
	}
}

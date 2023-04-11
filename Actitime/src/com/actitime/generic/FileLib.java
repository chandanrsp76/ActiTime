package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author chandan
 *
 */
public class FileLib {
	
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./data/commonData.property");
		Properties p = new Properties();
		p.load(fis);
		return  p.getProperty(key);
		
	}

	public String getExcelData(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	public void setExcelData(String sheetName, int row, int cell, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}
}

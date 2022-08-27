package com.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead extends TestExecutor{
	
	
	public void readexcel() throws IOException
	{
		File f = new File("C:\\neworkspace\\DataDriven\\src\\test\\java\\com\\datadriven\\resource\\Register_Data.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum()+1;
		int colcount = sheet.getRow(0).getLastCellNum();
		

		
		for(int i=0;i<colcount;i++)
		{
			map.put(formatter.formatCellValue(sheet.getRow(0).getCell(i)), formatter.formatCellValue(sheet.getRow(1).getCell(i)));
		}
		
		
	}
	
	
	public String getMapValue(String key) throws IOException
	{
		readexcel();
	return	map.get(key);
	}

}

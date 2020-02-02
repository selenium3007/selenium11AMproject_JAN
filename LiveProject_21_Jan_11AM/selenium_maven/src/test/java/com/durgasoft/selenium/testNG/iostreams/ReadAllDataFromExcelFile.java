package com.durgasoft.selenium.testNG.iostreams;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFromExcelFile {
	public FileInputStream fi;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("D:\\LiveProject_21_Jan_11AM" 
											+ "\\selenium_maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		//int rowCount = s.getLastRowNum() - s.getFirstRowNum();
		//System.out.println("Number of rows in excel file:" + rowCount);
		for (int i = 1; i <= s.getLastRowNum(); i++) {
			r = s.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				System.out.println(r.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}
}

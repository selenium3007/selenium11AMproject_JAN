package com.durgasoft.selenium.testNG.iostreams;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {
	@Test
	public void f() throws Exception {
		FileInputStream fi = new FileInputStream("D:\\LiveProject_21_Jan_11AM"
															+ "\\selenium_maven\\testdata\\login.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fi);
		XSSFSheet s=w.getSheet("Sheet1");
		XSSFRow r=s.getRow(2);
		XSSFCell c=r.getCell(1);
		System.out.println(c.getStringCellValue());
		w.close();
	}
}

package com.durgasoft.selenium.testNG.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByColumnName {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;

	@Test
	public void f() throws Exception{
		fi = new FileInputStream("D:\\LiveProject_21_Jan_11AM"
														+ "\\selenium_maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		r = null;
		c = null;
		int column = -1;
		r=s.getRow(0);
		for (int i = 0; i < r.getLastCellNum(); i++) {
			System.out.println(r.getCell(i).getStringCellValue());
			if (r.getCell(i).getStringCellValue().equalsIgnoreCase("Results")) {
				column = i;
				System.out.println(column);
			}
		}
		r=s.getRow(1);
		if(r==null)
			r=s.createRow(1);
		c=r.getCell(column);
		if(c==null)
			c=r.createCell(column);
		c.setCellValue("SKIPPED");
		fo=new FileOutputStream("D:\\LiveProject_21_Jan_11AM"
																	+ "\\selenium_maven\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();
	}
}

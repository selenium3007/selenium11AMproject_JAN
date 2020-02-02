package com.durgasoft.selenium.testNG.iostreams;

import org.testng.annotations.Test;

public class ReadDataFromExcelFileByExcel_API {
	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("D:\\LiveProject_21_Jan_11AM\\selenium_maven\\testdata\\login.xlsx");
		System.out.println("Reading data from excel file by using col num row num");
		System.out.println(e.getCellData("Sheet1", 3, 2));
		System.out.println(e.getCellData("Sheet1", 3, 5));
		System.out.println(e.getCellData("Sheet1", 3, 6));
		System.out.println("Reading data from excel file by using colname row num");
		System.out.println(e.getCellData("Sheet1", "Password", 1));
		System.out.println(e.getCellData("Sheet1", "Password", 3));
		System.out.println(e.getCellData("Sheet1", "Password", 5));
		System.out.println("Writing data to excel file by using colnum row num");
		e.setCellData("Sheet1", 4, 3, "PASSED");
		e.setCellData("Sheet1", 4, 2, "FAILED");
		e.setCellData("Sheet1", 4, 5, "SKIPPED");
		System.out.println("Writing data to excel file by using col name row num");
		e.setCellData("Sheet1", "Password", 3, "BLOCKED");
	}
}

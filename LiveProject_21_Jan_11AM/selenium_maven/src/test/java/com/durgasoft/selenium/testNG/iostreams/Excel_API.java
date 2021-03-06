package com.durgasoft.selenium.testNG.iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {
	public FileInputStream fi = null;
	public FileOutputStream fo = null;
	public XSSFWorkbook w = null;
	public XSSFSheet s = null;
	public XSSFRow r = null;
	public XSSFCell c = null;
	String filePath;

	public Excel_API(String file) throws Exception {
		this.filePath = file;
		fi = new FileInputStream(filePath);
		w = new XSSFWorkbook(fi);
		fi.close();
	}

	// Reading data from excel file by using column index
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			s = w.getSheet(sheetName);
			r = s.getRow(rowNum);
			c = r.getCell(colNum);
			if (c.getCellTypeEnum() == CellType.STRING) {
				return c.getStringCellValue();
			} else if (c.getCellTypeEnum() == CellType.NUMERIC || c.getCellTypeEnum() == CellType.FORMULA) {
				return String.valueOf(c.getNumericCellValue());
			} else if (c.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(c.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}

	// Reading data from excel file by using column name
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int column = -1;
			s = w.getSheet(sheetName);
			r = s.getRow(0);
			for (int i = 0; i < r.getLastCellNum(); i++) {
				if (r.getCell(i).getStringCellValue().equalsIgnoreCase("Password")) {
					column = i;
				}
			}
			r = s.getRow(rowNum);
			c = r.getCell(column);
			if (c.getCellTypeEnum() == CellType.STRING) {
				return c.getStringCellValue();
			} else if (c.getCellTypeEnum() == CellType.NUMERIC || c.getCellTypeEnum() == CellType.FORMULA) {
				return String.valueOf(c.getNumericCellValue());
			} else if (c.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(c.getBooleanCellValue());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No matching value";
		}
	}

	// Writing data to excel file by using column index
	public boolean setCellData(String sheetName, int colNum, int rowNum, String value) throws Exception {
		try {
			s = w.getSheet(sheetName);
			r = s.getRow(rowNum);
			if (r == null)
				r = s.createRow(rowNum);
			c = r.getCell(colNum);
			if (c == null)
				c = r.createCell(colNum);
			c.setCellValue(value);
			fo = new FileOutputStream(filePath);
			w.write(fo);
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Writing data to excel file by using column name
	public boolean setCellData(String sheetName, String colName, int rowNum, String value) throws Exception {
		try {
			int column = -1;
			s = w.getSheet(sheetName);
			r = s.getRow(0);
			for (int i = 0; i < r.getLastCellNum(); i++) {
				if (r.getCell(i).getStringCellValue().equalsIgnoreCase("Results")) {
					column = i;
				}
			}
			r = s.getRow(rowNum);
			if (r == null)
				r = s.createRow(rowNum);
			c = r.getCell(column);
			if (c == null)
				c = r.createCell(column);
			c.setCellValue(value);
			fo = new FileOutputStream(filePath);
			w.write(fo);
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Identify number of rows & number of columns in excel file
	public int getRows(String sheetName) {
		s = w.getSheet(sheetName);
		int rowCount = s.getLastRowNum() + 1;
		return rowCount;

	}

	public int getColumns(String sheetName) {
		s = w.getSheet(sheetName);
		r = s.getRow(0);
		int columnCount = r.getLastCellNum();
		return columnCount;
	}
}



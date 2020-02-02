package com.durgasoft.selenium.testNG.iostreams;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class HMS_Login_Excel_API {
	public WebDriver driver;

	@Test
	public void hms_Login() throws Exception {
		Excel_API e = new Excel_API("D:\\LiveProject_21_Jan_11AM\\selenium_maven\\testdata\\login.xlsx");
		driver.findElement(By.name("username")).sendKeys(e.getCellData("Sheet1", 0, 1));
		driver.findElement(By.name("password")).sendKeys(e.getCellData("Sheet1", 1, 1));
		driver.findElement(By.name("submit")).click();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}

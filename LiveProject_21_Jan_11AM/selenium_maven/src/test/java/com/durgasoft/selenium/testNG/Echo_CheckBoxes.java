package com.durgasoft.selenium.testNG;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Echo_CheckBoxes {
	public WebDriver driver;
	@Test
	public void f() {
		List<WebElement> checkboxes = driver.findElements
								(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for (int i = 0; i < checkboxes.size(); i++) {
			System.out.println(checkboxes.get(i).getAttribute("value") 
											+ "---" + checkboxes.get(i).getAttribute("checked"));
			if (!checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
	}

}

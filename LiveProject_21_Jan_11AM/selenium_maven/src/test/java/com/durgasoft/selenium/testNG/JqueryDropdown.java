package com.durgasoft.selenium.testNG;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class JqueryDropdown {

	public WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.xpath
				("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		WebElement table = driver.findElement(By.xpath
				("//ul[@class='multiselect-container dropdown-menu']"));
		List<WebElement> ddValues = table.findElements(By.tagName("input"));
		System.out.println("The values in table:" + ddValues.size());
		/*for (int i = 0; i < ddValues.size(); i++) {
			//ddValues.get(i).click();//To select all values in drop down
			System.out.println(ddValues.get(i).getAttribute("value"));
			if (ddValues.get(i).getAttribute("value").equalsIgnoreCase("HTML")) {
				ddValues.get(i).click();
			}
		}*/
			Random r=new Random();
			int num=r.nextInt(4);
			System.out.println(num);
			ddValues.get(num).click();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.manage().window().maximize();
	}

}

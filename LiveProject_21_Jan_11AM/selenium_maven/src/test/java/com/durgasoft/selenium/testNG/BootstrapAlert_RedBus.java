package com.durgasoft.selenium.testNG;

import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BootstrapAlert_RedBus {
	public WebDriver driver;

	@Test
	public void f() throws Exception{
		Thread.sleep(6000);
		driver.findElement(By.id("i-icon-profile")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li[text()='Sign In/Sign Up']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		driver.findElement(By.id("newFbId")).click();
		Thread.sleep(5000);
		Set<String> windows = driver.getWindowHandles();
		Object[] s=windows.toArray();
		driver.switchTo().window(s[1].toString());
		driver.findElement(By.id("email")).sendKeys("Sunny");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://redbus.in/");
		driver.manage().window().maximize();
	}

}

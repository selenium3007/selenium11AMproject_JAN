package com.durgasoft.ecommerce.homepage;

import org.testng.annotations.Test;
import com.durgasoft.ecommerce.basepage.BasePage;
import com.durgasoft.ecommerce.pageUI.CreateLoginAccount;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC001_CustomerRegistration extends BasePage {

	public static final Logger log = Logger.getLogger(TC001_CustomerRegistration.class.getName());

	@Test
	public void customerRegistration() throws Exception {
		log.info("****TC001_CustomerRegistration Started******");
		CreateLoginAccount login = new CreateLoginAccount(driver);
		login.createAccount();
		log.info("****TC001_CustomerRegistration Ended******");

	}

	@Test
	public void verifyLogin() {
		System.out.println("verifyLogin");
	}

	@BeforeClass
	public void beforeTest() throws Exception {
		browserLaunch(getData("browser"), getData("url"));

	}

	@AfterClass
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
}

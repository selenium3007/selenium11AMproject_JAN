package com.durgasoft.selenium.testNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium.java.BasePage;
import com.durgasoft.selenium.java.PageUI;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.testng.annotations.BeforeTest;

public class TC001_HMS_Login extends BasePage {
	
	public ATUTestRecorder recorder;
	
	@Test(description = "This test acse is  to verify login & logout in HMS")
	public void hmsLoginLogout()throws Exception {
		PageUI p = new PageUI(driver);
		p.verifyLogin();
		p.verifyLogout();
		recorder.stop();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		recorder=new ATUTestRecorder("D:\\recording", "hmslogin", false);
		recorder.start();
		browserLaunch("firefox", "http://seleniumbymahesh.com");

	}

}

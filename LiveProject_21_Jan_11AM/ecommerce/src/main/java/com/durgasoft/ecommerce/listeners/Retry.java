package com.durgasoft.ecommerce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	int retryCount = 0;
	int maxCount = 3;
	public boolean retry(ITestResult arg0) {
		if (retryCount < maxCount) {
			log("Retrying Test " + arg0.getName() + " with status " + getResultStatus(arg0.getStatus())
					+ " for the time " + (retryCount + 1) + " times");
			retryCount++;
			return true;
		}
		return false;
	}

	public void log(String string) {
		Reporter.log(string);
	}
	
	public String getResultStatus(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAIL";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
}


package org.TourishManagement.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryIplementationClass implements IRetryAnalyzer{
	int count=0;
	int retries=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retries)
		{
			count++;
			return true;
		}
		return false;
	}

}

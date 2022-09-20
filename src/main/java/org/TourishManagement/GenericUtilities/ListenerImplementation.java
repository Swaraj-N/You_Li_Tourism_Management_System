package org.TourishManagement.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener  {

	private ExtentReports reports;
	public static ExtentTest sTest;
	private ExtentTest test;

	@Override//For @Before Test
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		sTest=test;
	}

	@Override// @After Method
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"PASS");
	}

	@Override// @After Method
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"FAIL");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		String screenShotpath = new WebDriverUtility().screenShot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(screenShotpath);
		//Use Below Statement is used to take Sreenshot and save in local directory
		//new WebDriverUtility().screenShot(BaseClass.sdriver, BaseClass.sjou, result.getMethod().getMethodName());		
	}

	@Override// @After Method
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"SKIP");
		test.fail(result.getThrowable());
	}

	@Override// @After Method
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override// @Before Class
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title - You-Li");
		spark.config().setReportName("Report Name - You-Li");
		spark.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "SWARAJ");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", "Chrome");
	}

	@Override // @After Class
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}

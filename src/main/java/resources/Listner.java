package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import baseClass.BaseClass;

//import resources.baseClass;

//ITestListener -- Interface -
//ITestReslut -- interface

public class Listner extends ExtentReportManager implements ITestListener {

	// This will create entry in the report

	// result.getName() --This will give the testcase name --

	// verifyRegsiterationWithValidData

	
	//override method
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	//override method
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case passed is " + result.getName());

			// PASS // Test cases passed is verifyRegsiterationWithValidData
		}
	}

	//override method
	public void onTestSkip(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is" + result.getName());

		}
	}

	//override method
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test CASE Failed is " + result.getName());
			test.log(Status.FAIL, "Test CASE Failed is " + result.getThrowable()); // To throw excpetion

			 
				String screenshotPath =  BaseClass.screenShot(BaseClass.driver, result.getName());
				test.addScreenCaptureFromPath(screenshotPath);
			

			// String screenshotPath = baseClass.screenShot(baseClass.driver,
			// result.getName());

			// test.addScreenCaptureFromPath(screenshotPath); // Adding screenshot inside
			// report//To add name in extent
			// report
		}
	}
}

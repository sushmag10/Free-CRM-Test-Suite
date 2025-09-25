package com.qa.ExtentReporting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyExtentListener implements ITestListener{
	
	ExtentReports extent = ExtentReportManager.getExtentReport();
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Test Execution Finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        test.log(Status.FAIL, result.getThrowable());

        // Capture Screenshot
 //       Object currentClass = result.getInstance();
  //      WebDriver driver = ((OrangeHRMTest) currentClass).driver;
   //     String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
    //    try {
     //       test.addScreenCaptureFromPath(screenshotPath);
     //   } catch (IOException e) {
     //       e.printStackTrace();
     //   }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        test.log(Status.SKIP, result.getThrowable());
    }

    // Other methods can be overridden as needed
}

package com.qa.ExtentReporting;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	static ExtentSparkReporter extentSparkReporter;
	static ExtentReports extentReports;
	   ExtentTest extentTest;
	  
	   @BeforeTest
	   public static ExtentReports getExtentReport()
	   {
	      if(extentReports==null) {
		   extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
	       extentReports = new ExtentReports();
	       extentReports.attachReporter(extentSparkReporter);


	       //configuration items to change the look and feel
	       //add content, manage tests etc
	       extentSparkReporter.config().setDocumentTitle("Free CRM Test Automation");
	       extentSparkReporter.config().setReportName("Free CRM Test Automation Extent Report");
	       extentSparkReporter.config().setTheme(Theme.STANDARD);
	       extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	   }
	      return extentReports;
	   }
	  
	   @AfterMethod
	   public void getResult(ITestResult result) {
	       if(result.getStatus() == ITestResult.FAILURE) {
	           extentTest.log(Status.FAIL,result.getThrowable());
	       }
	       else if(result.getStatus() == ITestResult.SUCCESS) {
	           extentTest.log(Status.PASS, result.getTestName());
	       }
	       else {
	           extentTest.log(Status.SKIP, result.getTestName());
	       }
	   }
	   @AfterTest
	   public void tearDown() {
	       //to write or update test information to the reporter
	       extentReports.flush();
	   }
	}
	


package com.AttendanceManagementTest.main;

import java.io.File;



import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.LogStatus;

public class Extent implements ITestListener, ISuiteListener {

	public static ExtentReports report;
	public static ExtentTest logger;
	public void onStart(ISuite suite) {
		//Create an html report for the suite that is executed
	   report = new ExtentReports(System.getProperty("user.dir") + "/reports/FinalReport.html");
	}


	public void onFinish(ISuite suite) {
		report.flush();
	}


	public void onTestStart(ITestResult result) {
		logger = report.startTest(result.getMethod().getMethodName());
		logger.log(LogStatus.INFO, "Executing test: " + result.getMethod().getMethodName());

	}


	public void onTestSuccess(ITestResult result) {
		logger.log(LogStatus.INFO, "Finished executing test");
	}


	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
	    if (driver != null) {
	        String fileName = String.format("Screenshot-%s.png", Calendar.getInstance().getTimeInMillis());
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File("./screenshots/" + fileName);
	        try {
	            FileUtils.copyFile(srcFile, destFile);
	            System.out.println("Screenshot taken, saved in screenshots folder");
	            logger.log(LogStatus.FAIL, "Test failed, screenshot saved: " + destFile.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot");
	            logger.log(LogStatus.FAIL, "Failed to save screenshot");
	        }
	    } else {
	        System.out.println("Driver is null, cannot take screenshot");
	        logger.log(LogStatus.FAIL, "Driver is null, screenshot not taken");
	    }
			
	}


	public void onTestSkipped(ITestResult result) {
		logger.log(LogStatus.SKIP, "Test skipped");
	}
	
}
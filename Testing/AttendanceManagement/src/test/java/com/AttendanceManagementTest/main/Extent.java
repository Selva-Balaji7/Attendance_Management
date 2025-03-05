package com.AttendanceManagementTest.main;

import java.io.File;

<<<<<<< HEAD

=======
>>>>>>> e35801fb2b71fd0cd1f3f4f833e0a2284438d8fe
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent implements ITestListener, ISuiteListener {

    public static ExtentReports report;
    public static ExtentTest logger;

    // Runs before the entire test suite
    public void onStart(ISuite suite) {
        if (report == null) {  // Ensure only one instance of ExtentReports
            report = new ExtentReports(System.getProperty("user.dir") + "/reports/FinalReport.html", true);
            System.out.println("Extent report initialized: " + (report != null));
        }
    }

    // Runs after the test suite execution is completed
    public void onFinish(ISuite suite) {
        if (report != null) {
            report.flush();
            report.close();
        }
    }

    public void onStart(ITestContext context) {
        System.out.println("Starting test: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Finished executing test: " + context.getName());
    }

    public void onTestStart(ITestResult result) {
        logger = report.startTest(result.getMethod().getMethodName());
        logger.log(LogStatus.INFO, "Executing test: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.log(LogStatus.PASS, "Test passed: " + result.getMethod().getMethodName());
        report.endTest(logger);  // Ensure logs are recorded
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
        if (driver != null) {
            String fileName = "Screenshot-" + Calendar.getInstance().getTimeInMillis() + ".png";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + fileName);
            try {
                FileUtils.copyFile(srcFile, destFile);
                logger.log(LogStatus.FAIL, "Test failed. Screenshot: " + logger.addScreenCapture(destFile.getAbsolutePath()));
            } catch (IOException e) {
                logger.log(LogStatus.FAIL, "Test failed. Screenshot could not be saved.");
            }
        } else {
            System.out.println("Test failed. WebDriver instance is null.");
            logger.log(LogStatus.FAIL, "Test failed. WebDriver instance is null.");
        }
        report.endTest(logger);
    }

    public void onTestSkipped(ITestResult result) {
        logger.log(LogStatus.SKIP, "Test skipped: " + result.getMethod().getMethodName());
        report.endTest(logger);
    }
}

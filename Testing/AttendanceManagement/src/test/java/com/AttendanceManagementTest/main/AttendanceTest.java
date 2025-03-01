package com.AttendanceManagementTest.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.time.Duration;

public class AttendanceTest {
    WebDriver driver=new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String baseUrl = "http://localhost:4200";
    String expectedDashboardURL = "http://localhost:4200/dashboard";


    @Test(priority = 1, description = "Login as Admin and Verify Dashboard Redirection")
    public void testAdminLogin() {
        driver.get(baseUrl);
        waitAndSendKeys(By.id("userid"), "999");
        waitAndSendKeys(By.id("userpassword"), "Allen@123");
        waitAndClick(By.className("btn-primary"));
        wait.until(ExpectedConditions.urlToBe(expectedDashboardURL));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDashboardURL, "Admin Login Failed");
        System.out.println("Admin Login Successful");
    }

    @Test(priority = 2, description = "Mark Attendance")
    public void testMarkAttendance() {
        navigateToMenu("Attendance", "Give Attendance");
        waitAndClick(By.id("submit"));
        System.out.println("Attendance marked successfully");
    }

    @Test(priority = 3, description = "View Attendance History")
    public void testViewAttendanceHistory() {
        navigateToMenu("Your History");
        waitAndClick(By.xpath("//summary[text()='Filter Attendance']"));
        filterAttendance("01-01-2025", "02-18-2025", "Present");
        System.out.println("Attendance history filtered successfully");
    }

    @Test(priority = 4, description = "View Student Attendances")
    public void testViewStudentAttendances() {
        navigateToMenu("Students");
        waitAndClick(By.xpath("//summary[text()='Filter Attendance']"));
        filterAttendance("01-01-2025", "01-31-2025", "Present", "100");
        updateAttendance("Leave");
        deleteAttendance();
        System.out.println("Student attendance updated and deleted successfully");
    }

    @Test(priority = 5, description = "View Teacher Attendances")
    public void testViewTeacherAttendances() {
        navigateToMenu("Teachers");
        waitAndClick(By.xpath("//summary[text()='Filter Attendance']"));
        filterAttendance("01-01-2025", "01-31-2025", "Present", "500");
        updateAttendance("Absent");
        deleteAttendance();
        System.out.println("Teacher attendance updated and deleted successfully");
    }

    @Test(priority = 6, description = "View All Attendances")
    public void testViewAllAttendances() {
        navigateToMenu("All");
        waitAndClick(By.xpath("//summary[text()='Filter Attendance']"));
        filterAttendance("01-01-2025", "01-31-2025", "Present");
        updateAttendance("Absent");
        deleteAttendance();
        System.out.println("All attendances updated and deleted successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

 // Utility Methods
    private void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void waitAndSendKeys(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    private void navigateToMenu(String... menuItems) {
        waitAndClick(By.className("hamburger-btn"));
        for (String item : menuItems) {
            waitAndClick(By.linkText(item));
        }
    }

    private void filterAttendance(String startDate, String endDate, String status) {
        waitAndSendKeys(By.xpath("//input[@formcontrolname='startDate']"), startDate);
        waitAndSendKeys(By.xpath("//input[@formcontrolname='endDate']"), endDate);
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("form-select")));
        dropdown.click();
        dropdown.sendKeys(status);
        dropdown.sendKeys(Keys.ENTER);
        waitAndClick(By.xpath("//button[@type='submit']"));
    }

    private void filterAttendance(String startDate, String endDate, String status, String id) {
        filterAttendance(startDate, endDate, status);
        waitAndSendKeys(By.xpath("//input[@formcontrolname='id']"), id);
    }

    private void updateAttendance(String status) {
        waitAndClick(By.cssSelector("table tbody tr:first-child button.btn.btn-warning"));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("form-select2")));
        dropdown.click();
        dropdown.sendKeys(status);
        waitAndClick(By.className("btn-success"));
    }

    private void deleteAttendance() {
        waitAndClick(By.cssSelector("table tbody tr:first-child button.btn.btn-danger"));
    }
}


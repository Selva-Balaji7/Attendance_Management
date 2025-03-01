package com.AttendanceManagementTest.main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class PermissionsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "http://localhost:4200";
    private String expectedDashboardURL = baseUrl + "/dashboard";

    @BeforeClass
    public void testLogin() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
        driver.manage().window().maximize();

        waitAndSendKeys(By.id("userid"), "999");
        waitAndSendKeys(By.id("userpassword"), "Allen@123");
        waitAndClick(By.className("btn"));
        
        Assert.assertEquals(driver.getCurrentUrl(), expectedDashboardURL, "Login failed");
    }

    @Test(priority = 1)
    public void navigateToViewPermissions() {
        waitAndClick(By.className("hamburger-btn"));
        waitAndClick(By.xpath("//summary[text()='Permissions']"));
        waitAndClick(By.linkText("View Permissions"));
    }

    @Test(priority = 2)
    public void navigateToEditPermissions() {
        waitAndClick(By.className("hamburger-btn"));
        waitAndClick(By.linkText("Edit Permissions"));
    }

    @Test(priority = 3)
    public void modifyPermissions() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        
        WebElement dropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@formcontrolname='permissionSelect']")));
        dropdown1.click();
        dropdown1.sendKeys("ViewAllAttendance");

        WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("roleSelect")));
        dropdown2.click();
        dropdown2.sendKeys("Student");
        dropdown2.click();

        waitAndClick(By.className("btn-success"));
        System.out.println("Permission added");

        waitAndClick(By.className("btn-danger"));
        System.out.println("Permission deleted successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void waitAndSendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }
}

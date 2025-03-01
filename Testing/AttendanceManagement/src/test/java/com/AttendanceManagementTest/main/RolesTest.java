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
import java.util.List;

public class RolesTest {
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
        boolean urlChanged = wait.until(ExpectedConditions.urlToBe(expectedDashboardURL));
        Assert.assertEquals(driver.getCurrentUrl(), expectedDashboardURL, "Login failed");
    }

    @Test(priority = 1)
    public void testAddRole() {
        waitAndClick(By.className("hamburger-btn"));
        waitAndClick(By.xpath("//summary[text()='Roles']"));
        waitAndClick(By.linkText("Edit Roles"));
        waitAndClick(By.xpath("//button[text()='Add Role']"));
        waitAndSendKeys(By.xpath("//input[@placeholder='Role Name']"), "Student");
        waitAndClick(By.className("btn-dark"));
    }

    @Test(priority = 2)
    public void testEditRole() {
        List<WebElement> editButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("btn-warning")));
        editButtons.get(3).click();
        waitAndSendKeys(By.xpath("//input[@formcontrolname='roleName']"), "head master");
        waitAndClick(By.className("btn-success"));
        handleAlert("Update");
    }

    @Test(priority = 3)
    public void testDeleteRole() {
        List<WebElement> deleteButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("btn-danger")));
        deleteButtons.get(3).click();
        handleAlert("Delete");
    }

    private void handleAlert(String action) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert Ok button clicked successfully for " + action);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

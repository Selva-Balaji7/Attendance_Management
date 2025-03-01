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

public class LeaveTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void testLogin() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:4200");
        driver.manage().window().maximize();

        waitAndSendKeys(By.id("userid"), "999");
        waitAndSendKeys(By.id("userpassword"), "Allen@123");
        waitAndClick(By.className("btn"));
    }

    @Test(priority = 1)
    public void testLeaveRequest() {
        waitAndClick(By.className("hamburger-btn"));
        waitAndClick(By.xpath("//summary[text()='Leave']"));
        waitAndClick(By.linkText("Request Leave"));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@formcontrolname='leaveTypeId']")));
        dropdown.click();
        dropdown.sendKeys("SL");

        waitAndSendKeys(By.id("startDate"), "02-25-2025");
        waitAndSendKeys(By.id("reason"), "feeling not well");

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitAndClick(By.xpath("//button[@type='submit']"));

        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'leave requested successfully')]")));
        Assert.assertTrue(confirmation.isDisplayed(), "Leave request failed");
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

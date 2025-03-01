package com.AttendanceManagementTest.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class UsersTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass
    public void testLogin() {
        WebElement userID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        userID.sendKeys("999");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userpassword")));
        password.sendKeys("Allen@123");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn")));
        loginButton.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:4200/dashboard"));
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/dashboard", "Login failed");
    }

    @Test(priority = 1)
    public void testViewUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("hamburger-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//summary[text()='Users']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Users"))).click();
        WebElement userIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        userIdField.sendKeys("999");
        WebElement role = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='role']")));
        Select select = new Select(role);
        select.selectByVisibleText("Admin");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButton.click();
    }

    @Test(priority = 2)
    public void testApproveRejectUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("hamburger-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Approve User"))).click();
        List<WebElement> viewButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@type='button']")));
        viewButtons.get(1).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("approvebtn")));
        approveButton.click();
        System.out.println("Approved successfully");
        viewButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@type='button']")));
        viewButtons.get(1).click();
        WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("rejectbtn")));
        rejectButton.click();
        System.out.println("Rejected successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

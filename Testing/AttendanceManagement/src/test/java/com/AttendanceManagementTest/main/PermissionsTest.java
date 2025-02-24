package com.AttendanceManagementTest.main;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PermissionsTest extends LeaveTest{
    private WebDriver driver;
    private String expectedURL = "http://localhost:4200/dashboard";

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        WebElement userID = driver.findElement(By.id("userid"));
        userID.sendKeys("999");

        WebElement password = driver.findElement(By.id("userpassword"));
        password.sendKeys("Allen@123");

        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login failed");
    }

    @Test(priority = 2)
    public void navigateToViewPermissions() throws InterruptedException {
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//summary[text()='Permissions']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("View Permissions")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void navigateToEditPermissions() throws InterruptedException {
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Edit Permissions")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void modifyPermissions() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(2000);

        WebElement dropdown1 = driver.findElement(By.xpath("//select[@formcontrolname='permissionSelect']"));
        dropdown1.click();
        Thread.sleep(2000);
        dropdown1.sendKeys("ViewAllAttendance");
        Thread.sleep(2000);

        WebElement dropdown2 = driver.findElement(By.id("roleSelect"));
        dropdown2.click();
        Thread.sleep(2000);
        dropdown2.sendKeys("Student");
        Thread.sleep(2000);
        dropdown2.click();

        driver.findElement(By.className("btn-success")).click();
        System.out.println("Permission added");
        Thread.sleep(2000);

        driver.findElement(By.className("btn-danger")).click();
        System.out.println("Permission deleted successfully");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

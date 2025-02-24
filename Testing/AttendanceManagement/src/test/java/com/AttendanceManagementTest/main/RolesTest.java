package com.AttendanceManagementTest.main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RolesTest extends PermissionsTest{
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
    }

    @Test(priority = 1)
    public void testLogin() throws InterruptedException {
        WebElement userID = driver.findElement(By.id("userid"));
        userID.sendKeys("999");
        WebElement password = driver.findElement(By.id("userpassword"));
        password.sendKeys("Allen@123");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/dashboard", "Login failed");
    }

    @Test(priority = 2)
    public void testAddRole() throws InterruptedException {
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//summary[text()='Roles']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Edit Roles")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Add Role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Role Name']")).sendKeys("Student");
        Thread.sleep(1000);
        driver.findElement(By.className("btn-dark")).click();
    }

    @Test(priority = 3)
    public void testEditRole() throws InterruptedException {
        List<WebElement> editButtons = driver.findElements(By.className("btn-warning"));
        editButtons.get(3).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("head master");
        Thread.sleep(1000);
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(1000);
        handleAlert("Update");
    }

    @Test(priority = 4)
    public void testDeleteRole() throws InterruptedException {
        List<WebElement> deleteButtons = driver.findElements(By.className("btn-danger"));
        deleteButtons.get(3).click();
        Thread.sleep(1000);
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
}
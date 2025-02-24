package com.AttendanceManagementTest.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class UsersTest extends RolesTest {
    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        Thread.sleep(2000);
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
    public void testViewUsers() throws InterruptedException {
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//summary[text()='Users']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("View Users")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userid")).sendKeys("999");
        Thread.sleep(2000);
        WebElement role = driver.findElement(By.xpath("//select[@formcontrolname='role']"));
        Select select = new Select(role);
        select.selectByVisibleText("Admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void testApproveRejectUsers() throws InterruptedException {
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Approve User")).click();
        Thread.sleep(2000);
        List<WebElement> viewButtons = driver.findElements(By.xpath("//button[@type='button']"));
        viewButtons.get(1).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	     Thread.sleep(2000);
        driver.findElement(By.className("approvebtn")).click();
        System.out.println("Approved successfully");
        Thread.sleep(2000);
        viewButtons = driver.findElements(By.xpath("//button[@type='button']"));
        viewButtons.get(1).click();
        Thread.sleep(2000);
        driver.findElement(By.className("rejectbtn")).click();
        Thread.sleep(2000);
        System.out.println("Rejected successfully");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

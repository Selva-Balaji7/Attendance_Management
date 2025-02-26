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

public class LeaveTest{
     WebDriver driver=new ChromeDriver();
     
     @BeforeClass
     public void testLogin() throws InterruptedException
     {
    	 driver.get("http://localhost:4200");
	     driver.manage().window().maximize();
	     Thread.sleep(2000);
	     WebElement userID = driver.findElement(By.id("userid"));
	     userID.sendKeys("999");
	     WebElement password = driver.findElement(By.id("userpassword"));
	     password.sendKeys("Allen@123");
	     WebElement loginButton = driver.findElement(By.className("btn")); // Change ID if needed
	     loginButton.click();
	     Thread.sleep(2000);
     }     
     
    @Test(priority = 1)
    public void testLeaveRequest() throws InterruptedException {
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//summary[text()='Leave']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Request Leave")).click();
        Thread.sleep(2000);
        
        WebElement dropdown = driver.findElement(By.xpath("//select[@formcontrolname='leaveTypeId']"));
        dropdown.click();
        Thread.sleep(2000);
        dropdown.sendKeys("SL");
        Thread.sleep(2000);
        
        WebElement date = driver.findElement(By.id("startDate"));
        date.click();
        date.sendKeys("02-52-2025");
        Thread.sleep(2000);
        
        driver.findElement(By.id("reason")).sendKeys("feeling not well");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        
        // Validation (Assuming a confirmation message appears)
        WebElement confirmation = driver.findElement(By.xpath("//*[contains(text(), 'leave requested successfully')]"));
        Assert.assertTrue(confirmation.isDisplayed(), "Leave request failed");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
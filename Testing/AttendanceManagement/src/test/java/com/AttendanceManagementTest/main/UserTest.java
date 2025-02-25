package com.AttendanceManagementTest.main;

import com.AttendanceManagement.main.User;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class UserTest extends UsersTest {
    WebDriverWait wait;

    @Test(priority = 19)
    public void testLoginWithInvalidCredentials() {
        driver.get(baseUrl);

        WebElement userID = wait.until(ExpectedConditions.elementToBeClickable(By.id("userid")));
        userID.sendKeys("1");

        WebElement password = driver.findElement(By.id("userpassword"));
        password.sendKeys("Allensdfsdfs23");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertFalse(loginButton.isEnabled(), "Test Failed: Login button should be disabled for invalid credentials");

        WebElement idWarning = driver.findElement(By.xpath("//div[contains(text(), 'Id is a 3 or 4 Digit Number')]"));
        Assert.assertTrue(idWarning.isDisplayed(), "Warning message for ID is missing");

        WebElement passwordWarning = driver.findElement(By.xpath("//div[contains(text(), 'InValid Password')]"));
        Assert.assertTrue(passwordWarning.isDisplayed(), "Warning message for password is missing");
    }

    @Test(priority = 20)
    public void testForgotPassword() {
        driver.findElement(By.linkText("Forgot Password?")).click();

        WebElement userID = wait.until(ExpectedConditions.elementToBeClickable(By.id("userid")));
        userID.sendKeys("999");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("allen@gmail.com");

        driver.findElement(By.className("btn-primary")).click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Found User')]")));
        Assert.assertTrue(successMessage.isDisplayed(), "User not found message missing");
    }

    @Test(priority = 21)
    public void testNewUserRegistration() {
        driver.findElement(By.linkText("New User")).click();

        driver.findElement(By.id("userid")).sendKeys("4899");
        driver.findElement(By.id("username")).sendKeys("nitheesh");
        driver.findElement(By.id("useremail")).sendKeys("nitheesh@gmail.com");
        driver.findElement(By.id("userpassword")).sendKeys("Nitheesh@193");

        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("D:\\Attendance_Management_MainProject\\SampleUserImages\\Male\\11.jpg");

        driver.findElement(By.className("imagebtn")).click();
        driver.findElement(By.className("regbtn")).click();

        System.out.println("New user registered successfully");
    }

    @Test(priority = 22)
    public void testLoginAsStudent() {
        driver.get(baseUrl);

        WebElement userID = wait.until(ExpectedConditions.elementToBeClickable(By.id("userid")));
        userID.sendKeys("101");

        WebElement password = driver.findElement(By.id("userpassword"));
        password.sendKeys("Johnson@123");

        driver.findElement(By.className("btn")).click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:4200/dashboard"));

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/dashboard",
                "Login Failed: User not redirected to dashboard");
    }

    @Test(priority = 23)
    public void testApplyForLeave() {
        driver.findElement(By.linkText("Request Leave")).click();

        driver.findElement(By.xpath("//select[@formcontrolname='leaveTypeId']")).click();
        WebElement leaveType = driver.findElement(By.xpath("//button[@type='submit']"));
        leaveType.click();
        leaveType.sendKeys("SL");

        WebElement startDate = driver.findElement(By.id("startDate"));
        startDate.click();
        startDate.sendKeys("02-19-2025");

        WebElement reason = driver.findElement(By.id("reason"));
        reason.sendKeys("Feeling not well");

        driver.findElement(By.className("btn-success")).click();

        System.out.println("Leave applied successfully");
    }

}

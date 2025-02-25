 package com.AttendanceManagementTest.main;

import org.openqa.selenium.WebDriver;




import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;


// import net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.System;

 public class AttendanceTest {

     public WebDriver driver =new ChromeDriver();
     public String baseUrl = "http://localhost:4200";
     public String expectedDashboardURL = baseUrl + "/dashboard";

     @BeforeSuite  
     public void setUp(ITestContext context) throws InterruptedException {
         // Set up the ChromeDriver
         System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");       
         Thread.sleep(2000);
         context.setAttribute("WebDriver", driver);
     }
     @Test(priority = 1, description = "Login as Admin and Verify Dashboard Redirection")
     public void testAdminLogin() throws InterruptedException {
         driver.get(baseUrl);
         driver.manage().window().maximize();

         // Login as Admin
         WebElement userID = driver.findElement(By.id("userid"));
         userID.sendKeys("999");

         WebElement password = driver.findElement(By.id("userpassword"));
         password.sendKeys("Allen@123");
         
         WebElement loginButton = driver.findElement(By.className("btn-primary"));
         loginButton.click();

         Thread.sleep(2000); // Wait for redirection
         String currentURL = driver.getCurrentUrl();
         Assert.assertEquals(currentURL, expectedDashboardURL, "Admin Login Failed or Incorrect Redirection");
         System.out.println("Admin Login Successful");
     }


     @Test(priority = 2, description = "Mark Attendance")
     public void testMarkAttendance() throws InterruptedException {
         // Navigate to Mark Attendance page
         driver.findElement(By.className("hamburger-btn")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//summary[text()='Attendance']")).click();
         Thread.sleep(2000);
         driver.findElement(By.linkText("Give Attendance")).click();
         Thread.sleep(2000);

         // Mark attendance for a specific date
         driver.findElement(By.id("attendanceDate"));
         Thread.sleep(2000);
         driver.findElement(By.id("submit")).click();
         System.out.println("Attendance marked successfully");
         Thread.sleep(2000);
     }


     @Test(priority = 3, description = "View Attendance History")
     public void testViewAttendanceHistory() throws InterruptedException {

         // Navigate to Attendance History page
         driver.findElement(By.className("hamburger-btn")).click();
         Thread.sleep(1000);
         driver.findElement(By.linkText("Your Histoy")).click();
         Thread.sleep(1000);
         //to click outside area of hamberg
         Actions actions=new Actions(driver);
         actions.moveByOffset(100, 100).click().perform();
         Thread.sleep(2000);

         // Filter by date and status
         
         driver.findElement(By.xpath("//summary[text()='Filter Attendance']")).click();
         Thread.sleep(2000);
         WebElement startDate = driver.findElement(By.xpath("//input[@formcontrolname='startDate']"));
         startDate.sendKeys("01-01-2025");
         WebElement endDate = driver.findElement(By.xpath("//input[@formcontrolname='endDate']"));
         endDate.sendKeys("02-18-2025");

         WebElement dropdown = driver.findElement(By.className("form-select"));
         dropdown.click();
         dropdown.sendKeys("Present");
         dropdown.sendKeys(Keys.ENTER);
         driver.findElement(By.xpath("//button[@type='submit']")).click();
         Thread.sleep(2000);
         System.out.println("Attendance history filtered successfully"); //tested
     }


     @Test(priority = 4, description = "View Student Attendances")
     public void testViewStudentAttendances() throws InterruptedException {
         // Navigate to View Student Attendances page
    	 
         driver.findElement(By.className("hamburger-btn")).click();
         Thread.sleep(1000);
//         driver.findElement(By.xpath("//summary[text()='Attendance']")).click();
         Thread.sleep(2000);
         driver.findElement(By.linkText("Students")).click();
         Thread.sleep(1000);

         // Filter and update attendance
         driver.findElement(By.xpath("//summary[text()='Filter Attendance']")).click();
         Thread.sleep(2000);
         WebElement startDate1 = driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]"));
         startDate1.sendKeys("01-01-2025");
         Thread.sleep(2000);
         WebElement endDate1 = driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]"));
         endDate1.sendKeys("01-31-2025");
         Thread.sleep(2000);
         WebElement id = driver.findElement(By.xpath("//input[@formcontrolname='id']"));
         id.sendKeys("100");
         Thread.sleep(2000);
         WebElement dropdown2 = driver.findElement(By.className("form-select"));
         dropdown2.click();
         Thread.sleep(2000);
         dropdown2.sendKeys("Present");
         dropdown2.sendKeys(Keys.ENTER);
         driver.findElement(By.xpath("//button[@type='submit']")).click();
         Thread.sleep(2000);
         System.out.println("Student attendances filtered successfully");

         // Update Attendance
         Thread.sleep(1000);
         driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-warning")).click(); // Edit
         WebElement dropdown3 = driver.findElement(By.className("form-select2"));
         dropdown3.click();
         Thread.sleep(2000);
         dropdown3.sendKeys("Leave");
         Thread.sleep(2000);
         driver.findElement(By.className("btn-success")).click(); // Save
         Thread.sleep(2000);

         // Delete Attendance
         driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-danger")).click(); // Delete
         Thread.sleep(1000);
         System.out.println("Student attendance updated and deleted successfully");//tested
     }



     @Test(priority = 5, description = "View Teacher Attendances")
     public void testViewTeacherAttendances() throws InterruptedException {
         // Navigate to View Teacher Attendances page
    	
         driver.findElement(By.className("hamburger-btn")).click();
         Thread.sleep(1000);
//         driver.findElement(By.xpath("//summary[text()='Attendance']")).click();
         Thread.sleep(2000);
         driver.findElement(By.linkText("Teachers")).click();
         Thread.sleep(1000);

         // Filter and update attendance
         driver.findElement(By.xpath("//summary[text()='Filter Attendance']")).click();
         Thread.sleep(2000);
         WebElement startDate2 = driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]"));
         startDate2.sendKeys("01-01-2025");
         Thread.sleep(2000);
         WebElement endDate2 = driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]"));
         endDate2.sendKeys("01-31-2025");
         Thread.sleep(2000);
         WebElement id1 = driver.findElement(By.xpath("//input[@formcontrolname='id']"));
         id1.sendKeys("500");
         Thread.sleep(2000);
         WebElement dropdown4 = driver.findElement(By.className("form-select"));
         dropdown4.click();
         dropdown4.sendKeys("Present");
         dropdown4.sendKeys(Keys.ENTER);
         driver.findElement(By.xpath("//button[@type='submit']")).click();
         Thread.sleep(1000);


         // Update Attendance
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
         driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-warning")).click(); // Edit
         WebElement dropdown6 = driver.findElement(By.className("form-select2"));
         dropdown6.click();
         Thread.sleep(2000);
         dropdown6.sendKeys("Absent");
         driver.findElement(By.className("btn-success")).click(); // Save
         Thread.sleep(2000);

         // Delete Attendance
         driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-danger")).click(); // Delete
         Thread.sleep(1000);
         System.out.println("Teacher attendance updated and deleted successfully");//tested
     }

     @Test(priority = 6, description = "View All Attendances")
     public void testViewAllAttendances() throws InterruptedException {
         // Navigate to View All Attendances page
         driver.findElement(By.className("hamburger-btn")).click();
         Thread.sleep(1000);
         driver.findElement(By.linkText("All")).click();
         Thread.sleep(1000);

         // Filter and update attendance
         driver.findElement(By.xpath("//summary[text()='Filter Attendance']")).click();
         Thread.sleep(2000);
         WebElement startDate3 = driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]"));
         startDate3.sendKeys("01-01-2025");
         Thread.sleep(2000);
         WebElement endDate3 = driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]"));
         endDate3.sendKeys("01-31-2025");
         Thread.sleep(2000);
         WebElement roledropdown = driver.findElement(By.xpath("//select[@formcontrolname='role']"));
         roledropdown.click();
         Thread.sleep(2000);
         roledropdown.sendKeys("Teacher");
         Thread.sleep(2000);
         WebElement dropdown7 = driver.findElement(By.className("form-select"));
         dropdown7.click();
         dropdown7.sendKeys("Present");
         dropdown7.sendKeys(Keys.ENTER);
         driver.findElement(By.xpath("//button[@type='submit']")).click();
         Thread.sleep(1000);

         // Update and delete attendance
         driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-warning")).click(); // Edit
         WebElement dropdown8 = driver.findElement(By.className("form-select2"));
         dropdown8.click();
         Thread.sleep(2000);
         dropdown8.sendKeys("Absent");
         driver.findElement(By.className("btn-success")).click(); // Save
         Thread.sleep(2000);

         driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-danger")).click(); // Delete
         Thread.sleep(1000);
         System.out.println("All attendances updated and deleted successfully");

     }


     @AfterSuite
     public void tearDown() {
         if (driver != null) {
             driver.quit();
         }
     }
 }
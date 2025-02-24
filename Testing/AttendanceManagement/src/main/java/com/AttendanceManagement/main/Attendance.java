package com.AttendanceManagement.main;

import org.openqa.selenium.WebDriver;






import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Attendance {
	public static void main(String[]args) throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		
		 String expectedURL = "http://localhost:4200/dashboard";
		 
		 driver.get("http://localhost:4200");
	     driver.manage().window().maximize();
	        
		 //login as student
		  //Locate the username and password fields and enter credentials
//	     WebElement userID = driver.findElement(By.id("userid"));
//	     userID.sendKeys("101");
//      
//       
//        WebElement password = driver.findElement(By.id("userpassword"));
//        password.sendKeys("Johnson@123");
        
        //login as admin
		 WebElement userID = driver.findElement(By.id("userid"));
	     userID.sendKeys("999");
	        
	       
	     WebElement password = driver.findElement(By.id("userpassword"));
	     password.sendKeys("Allen@123");

        // Click the login button (Update selector if needed)
        WebElement loginButton = driver.findElement(By.className("btn")); // Change ID if needed
        loginButton.click();
        
        // Replace with actual expected URL
        Thread.sleep(2000); // Wait for redirection (Better to use WebDriverWait)
        String currentURL = driver.getCurrentUrl();

        if (currentURL.equals(expectedURL)) {
            System.out.println("Login Successful: logged as student Redirected to Dashboard");
        } else {
            System.out.println("Login Failed or Incorrect Redirection");
        }
         
        //Attendance Module
        driver.findElement(By.className("hamburger-btn")).click();
        System.out.println("dashboard is displayed");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//summary[text()='Attendance']")).click();
        System.out.println("Attendance module has been selected");
       
        
       //mark attendance
        driver.findElement(By.linkText("Mark Attendance")).click();
        System.out.println("Mark-attendance found");
        WebElement dateInput = driver.findElement(By.id("attendanceDate"));
        dateInput.sendKeys("2025-02-16");
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        System.out.println("marked attendance");
        
        //attendance history
        driver.findElement(By.className("hamburger-btn")).click();
        Thread.sleep(2000);
        System.out.println("dashboard is displayed");
        driver.findElement(By.linkText("Attendance Histoy")).click();
        System.out.println("attendance history is found");
        driver.findElement(By.className("hamburger-btn")).click();
        WebElement startDate = driver.findElement(By.xpath("//input[@formcontrolname='startDate']"));
		startDate.sendKeys("01-01-2025");
		Thread.sleep(2000);
        WebElement endDate= driver.findElement(By.xpath("//input[@formcontrolname='endDate']"));
        Thread.sleep(2000);
        endDate.sendKeys("31-01-2025");
        Thread.sleep(2000);
        WebElement dropdown=driver.findElement(By.className("form-select"));
        dropdown.click();
        Thread.sleep(2000);
        dropdown.sendKeys("Present");
        dropdown.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        System.out.println("filtered successfully");
       

          
        
        //View student attendance
        driver.findElement(By.className("hamburger-btn")).click();
        System.out.println("dashboard is displayed");
        driver.findElement(By.linkText("View Student Attendances")).click();
        System.out.println("view student attendance found");
        driver.findElement(By.className("hamburger-btn")).click();
        WebElement startDate1=driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]"));
        startDate1.sendKeys("01-01-2025");
        Thread.sleep(2000);
        WebElement endDate1=driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]"));
        endDate1.sendKeys("31-01-2025");
        Thread.sleep(2000);
        WebElement id=driver.findElement(By.xpath("//input[@formcontrolname='id']"));
        id.click();
        Thread.sleep(2000);
        id.sendKeys("100");
        Thread.sleep(2000);
        WebElement dropdown2 = driver.findElement(By.className("form-select"));  
        dropdown2.click();
        Thread.sleep(2000);
        dropdown2.sendKeys("Present");
        dropdown2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("filtered successfully");
        Thread.sleep(2000);
        driver.findElement(By.className("hamburger-btn")).click();
        System.out.println("dashboard is displayed");
        Thread.sleep(2000);
        driver.findElement(By.linkText("View Student Attendances")).click();
        driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-warning")).click();
        WebElement dropdown3 =driver.findElement(By.className("form-select"));
        dropdown3.click();
        Thread.sleep(2000);
        dropdown3.sendKeys("Leave");
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(2000);
        System.out.println("updated successfully");
        driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-danger")).click();
        System.out.println("Deleted successfully");       
        
        
        //view Teacher attendance
         driver.findElement(By.className("hamburger-btn")).click();
          System.out.println("dashboard is displayed");
          driver.findElement(By.linkText("View Teacher Attendances")).click();
        System.out.println("Teacher attendance found");
        driver.findElement(By.className("hamburger-btn")).click();
        WebElement startDate2=driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]"));
        startDate2.sendKeys("01-01-2025");
        Thread.sleep(2000);
        WebElement endDate2=driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]"));
        endDate2.sendKeys("31-01-2025");
        Thread.sleep(2000);
        WebElement id1=driver.findElement(By.xpath("//input[@formcontrolname='id']"));
        id1.click();
        Thread.sleep(2000);
        id1.sendKeys("500");
        Thread.sleep(2000);
        WebElement dropdown4 = driver.findElement(By.className("form-select"));  
        dropdown4.click();
        Thread.sleep(2000);
        dropdown4.sendKeys("Leave");
        dropdown4.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("filtered successfully");
        Thread.sleep(2000);
        WebElement dropdown5 = driver.findElement(By.className("form-select"));  
        dropdown5.click();
        Thread.sleep(2000);
        dropdown5.sendKeys("Present");
        dropdown5.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("filtered successfully");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-warning")).click();
        WebElement dropdown6 =driver.findElement(By.className("form-select"));
        dropdown6.click();
        Thread.sleep(2000);
        dropdown6.sendKeys("Absent");
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(2000);
        System.out.println("updated successfully");
        driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-danger")).click();
        System.out.println("Deleted successfully");
        
        
        //View all attendance 
        
        driver.findElement(By.className("hamburger-btn")).click();
        System.out.println("dashboard is displayed");
        driver.findElement(By.linkText("View All Attendances")).click();
        System.out.println("View all attendance found");
        driver.findElement(By.className("hamburger-btn")).click();
        WebElement startDate3=driver.findElement(By.xpath("//input[@formcontrolname=\"startDate\"]"));
        startDate3.sendKeys("01-01-2025");
        Thread.sleep(2000);
        WebElement endDate3=driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]"));
        endDate3.sendKeys("31-01-2025");
        Thread.sleep(2000);
        WebElement roledropdown=driver.findElement(By.xpath("//select[@formcontrolname='role']"));
        roledropdown.click();
        Thread.sleep(2000);
        roledropdown.sendKeys("Admin");
        Thread.sleep(2000);
        WebElement dropdown7= driver.findElement(By.className("form-select"));  
        dropdown7.click();
        Thread.sleep(2000);
        dropdown7.sendKeys("Present");
        dropdown7.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("filtered successfully");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-warning")).click();
        WebElement dropdown8 =driver.findElement(By.className("form-select"));
        dropdown8.click();
        Thread.sleep(2000);
        dropdown8.sendKeys("Absent");
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(2000);
        System.out.println("updated successfully");
        driver.findElement(By.cssSelector("table tbody tr:first-child button.btn.btn-danger")).click();
        System.out.println("Deleted successfully");
        
        
        
        
        driver.quit();
      	
	}

	 
}






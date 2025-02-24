package com.AttendanceManagement.main;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Leave {
	public static void main(String[]args) throws InterruptedException
	{

		WebDriver driver=new ChromeDriver();
		String expectedURL = "http://localhost:4200/dashboard";
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
	     
	     
	     //leave
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//summary[text()='Leave']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Request Leave")).click();
	     Thread.sleep(2000);
	     WebElement dropdown=driver.findElement(By.xpath("//select[@formcontrolname='leaveTypeId']"));
	     dropdown.click();
	     Thread.sleep(2000);
	     dropdown.sendKeys("SL");
	     dropdown.click();
	     Thread.sleep(2000); 
	     WebElement date=driver.findElement(By.id("startDate"));
	     date.click();
	     date.sendKeys("02-25-2025");
	     Thread.sleep(2000);
	     driver.findElement(By.id("reason")).sendKeys("feeling not well");
	     Thread.sleep(2000);
	     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	     Thread.sleep(2000);
	     driver.findElement(By.className("btn-success")).click();
	     System.out.println("leave requested successfully");
	     Thread.sleep(2000);
	     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
	     Thread.sleep(2000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);  
	     driver.findElement(By.linkText("Request History")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);  
	     driver.findElement(By.linkText("Leave Types")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000); 
	     
	     
	      //Requests
	     driver.findElement(By.id("leaverequest")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Students")).click();
	     Thread.sleep(2000);
	     List<WebElement> accept =driver.findElements(By.className("btn-success"));
	     accept.get(0).click();
	     System.out.println("leave requested accepted successfully");
	     Thread.sleep(2000); 
	     List<WebElement> reject =driver.findElements(By.className("btn-danger"));
	     reject.get(1).click();
	     System.out.println("leave requested rejected successfully");
	     Thread.sleep(2000); 
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Teachers")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("All Requests")).click();
	     System.out.println("test successfully");
	     Thread.sleep(2000);
	   
	     }
	     

}

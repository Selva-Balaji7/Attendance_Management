package com.AttendanceManagement.main;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Permissions {
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
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//summary[text()='Permissions']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("View Permissions")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Edit Permissions")).click();
	     Thread.sleep(2000);
	     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	     Thread.sleep(2000);
	     WebElement dropdown1 =driver.findElement(By.xpath("//select[@formcontrolname='permissionSelect']"));
	     dropdown1.click();
	     Thread.sleep(2000);
	     dropdown1.sendKeys("ViewAllAttendance");
	     Thread.sleep(2000);
	     WebElement dropdown2=driver.findElement(By.id("roleSelect"));
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
	     

}

package com.AttendanceManagement.main;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Roles {
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
	     driver.findElement(By.xpath("//summary[text()='Roles']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("View Roles")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Edit Roles")).click();
	     Thread.sleep(2000);
//	     Actions actions=new Actions(driver);
//	     actions.moveByOffset(100, 100).click().perform();
//	     Thread.sleep(2000); 
	     driver.findElement(By.xpath("//button[text()='Add Role']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@placeholder='Role Name']")).sendKeys("Student");
	     Thread.sleep(2000);
	     driver.findElement(By.className("btn-dark")).click();
	     Thread.sleep(2000);
	     List<WebElement> edit=driver.findElements(By.className("btn-warning"));
	     edit.get(3).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("head master");
	     Thread.sleep(2000);
	     driver.findElement(By.className("btn-success")).click();
	     Thread.sleep(2000);
	     try {
	    	 //switch to alert box
	    	 Alert alert=driver.switchTo().alert();
	    	 alert.accept();
	    	 System.out.println("alert Ok button clicked successfully for update");
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     Thread.sleep(2000);
	     List<WebElement> delete=driver.findElements(By.className("btn-danger"));
	     delete.get(3).click();
	     Thread.sleep(2000);
	     try {
	    	 //switch to alert box
	    	 Alert alert=driver.switchTo().alert();
	    	 alert.accept();
	    	 System.out.println("alert Ok button clicked successfully for delete");
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     }
	     

}

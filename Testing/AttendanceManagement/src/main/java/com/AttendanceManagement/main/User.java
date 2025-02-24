package com.AttendanceManagement.main;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class User {
	
	public static void main(String[]args) throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		String expectedURL = "http://localhost:4200/dashboard";
		driver.get("http://localhost:4200");
	     driver.manage().window().maximize();
	     
	     
	     //user-login:
	     WebElement userID=driver.findElement(By.id("userid"));
	     Thread.sleep(2000);
	     userID.click();
	     Thread.sleep(2000);
	     userID.sendKeys("1");
	     WebElement pass=driver.findElement(By.id("userpassword"));
	     Thread.sleep(2000);
	     pass.click();
	     Thread.sleep(2000);
	     pass.sendKeys("Allensdfsdfs23");
	     Thread.sleep(2000);
	     boolean login=driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
	     if(login==true)
	     {
	    	System.out.println("test failed"); 
	     }
	     else
	     {
	    	 System.out.println("test passed");  
	     }
	     Thread.sleep(2000);
	     WebElement idmsg = driver.findElement(By.xpath("//div[contains(@class, 'warningmessage') and contains(text(), 'Id is a 3 or 4 Digit Number')]"));
	     if(idmsg.isDisplayed()) {
	    	 System.out.println("warning for id is present");
	     }
	     else {
	    	 System.out.println("warning for id is not present");
	     }
	     Thread.sleep(2000);
	     driver.findElement(By.id("userid")).click();
	     WebElement pmsg = driver.findElement(By.xpath("//div[contains(@class, 'warningmessage') and contains(text(), 'InValid Password')]"));
	     if(pmsg.isDisplayed()) {
	    	 System.out.println("warning for password is present");
	     }
	     else {
	    	 System.out.println("warning for password is not present");
	     }
	     
	     //forgot password
	     driver.findElement(By.linkText("Forgot Password?")).click();
	     Thread.sleep(2000);
	     WebElement id=driver.findElement(By.id("userid"));
	     id.click();
	     Thread.sleep(2000);
	     id.sendKeys("999");
	     Thread.sleep(2000); 
	     WebElement pass1=driver.findElement(By.id("email"));
	     pass1.click();
	     Thread.sleep(2000);
	     pass1.sendKeys("Allen@gmail.com");
	     Thread.sleep(2000);
	     driver.findElement(By.className("btn-primary")).click(); 
	     Thread.sleep(2000);
	     WebElement userfound = driver.findElement(By.xpath("//div[contains(@class, 'successmessage') and contains(text(), 'Found User')]"));
	     if(userfound.isDisplayed()) {
	    	 System.out.println("userfound text is present");
	     }
	     else {
	    	 System.out.println("userfound text is not present");
	     }
	     
	     //change password 
	     driver.findElement(By.id("password")).sendKeys("Allen@123");
	     Thread.sleep(2000);
	     driver.findElement(By.id("confirmpassword")).sendKeys("Allen@123");
	     Thread.sleep(2000);
	     driver.findElement(By.className("btn-success")).click();
	     System.out.println("password changed successfully");
	     
	     
	     //new user
	     driver.findElement(By.linkText("New User")).click();
	     driver.findElement(By.id("userid")).sendKeys("4899");
	     Thread.sleep(2000);
	     driver.findElement(By.id("username")).sendKeys("nitheesh");
	     Thread.sleep(2000);
	     driver.findElement(By.id("useremail")).sendKeys("nitheesh@gmail.com");
	     Thread.sleep(2000);
	     driver.findElement(By.id("userpassword")).sendKeys("Nitheesh@193"); 
	     Thread.sleep(2000);
	    
 	     Actions actions=new Actions(driver);
         actions.moveByOffset(100, 100).click().perform();
	     Thread.sleep(2000);
	     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	     try {
	    	 WebElement fileInput=driver.findElement(By.xpath("//input[@type='file']"));
		     Thread.sleep(2000);
		     String filePath="D:\\Attendance_Management_MainProject\\SampleUserImages\\Male\\11.jpg";
		     Thread.sleep(2000);
		     fileInput.sendKeys(filePath);
		     Thread.sleep(2000);
	     driver.findElement(By.className("imagebtn")).click();
		     System.out.println("uploaded successfully");
		     Thread.sleep(2000);
		     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
		     Thread.sleep(2000);
		     driver.findElement(By.className("regbtn")).click();
		     System.out.println("registered successfully");
		     Thread.sleep(2000);
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
	     driver.findElement(By.xpath("//button[@tabindex=0]")).click();
	     
	     
	     
	     //edit profile
	     WebElement userID1 = driver.findElement(By.id("userid"));
	     userID1.sendKeys("999");
	     WebElement password = driver.findElement(By.id("userpassword"));
	     password.sendKeys("Allen@123");
	     WebElement loginButton = driver.findElement(By.className("btn")); // Change ID if needed
	     loginButton.click();
	     Thread.sleep(2000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.className("dropdowns")).click();
	     driver.findElement(By.linkText("Your Profile")).click();
	     Thread.sleep(2000);
	     boolean profile=driver.findElement(By.className("userprofile")).isDisplayed();
	     if(profile==true)
	     {
	    	 System.out.println("profile is present");
	     }
	     else
	     {
	    	 System.out.println("profile is not present"); 
	     }
	     Thread.sleep(2000);
	     driver.findElement(By.className("hamburger-btn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Edit Profile")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.className("changeprofilebtn")).click();
	     Thread.sleep(2000);
	     try {
	    	 WebElement fileInput=driver.findElement(By.xpath("//input[@type='file']"));
		     Thread.sleep(2000);
		     String filePath="D:\\Attendance_Management_MainProject\\SampleUserImages\\Male\\11.jpg";
		     Thread.sleep(2000);
		     fileInput.sendKeys(filePath);
		     Thread.sleep(2000);
		     driver.findElement(By.className("btn-success")).click();
		     System.out.println("profile uploaded successfully");
		     Thread.sleep(2000);
	     }
	     catch(Exception e)
	     {
	    	e.printStackTrace();
	     }
	     Thread.sleep(2000);
	     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	     Thread.sleep(2000);
	     driver.findElement(By.className("changedetails")).click();
	     Thread.sleep(2000);
	     WebElement username=driver.findElement(By.id("username"));
	     username.clear();
	     Thread.sleep(2000);
	     username.sendKeys("Allen");
	     Thread.sleep(2000); 
	     WebElement email=driver.findElement(By.id("useremail"));
	     email.clear();
	     email.sendKeys("allen@gmail.com");
	     Thread.sleep(2000); 
	     WebElement pass2=driver.findElement(By.id("userpassword"));
	     pass2.clear();
	     Thread.sleep(2000);
	     pass2.sendKeys("Allen@123");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     System.out.println("Details edited successfully");
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	   //login as student
		  //Locate the username and password fields and enter credentials
	      WebElement userID2 = driver.findElement(By.id("userid"));
	     userID1.sendKeys("101");      
	     WebElement password2 = driver.findElement(By.id("userpassword"));
         password.sendKeys("Johnson@123");
         
         // Click the login button (Update selector if needed)
         WebElement loginButton1 = driver.findElement(By.className("btn")); // Change ID if needed
         loginButton.click();
         
         // Replace with actual expected URL
         Thread.sleep(2000); // Wait for redirection (Better to use WebDriverWait)
         String currentURL = driver.getCurrentUrl();

         if (currentURL.equals(expectedURL)) {
             System.out.println("Login Successful: logged as student Redirected to Dashboard");
         } else {
             System.out.println("Login Failed or Incorrect Redirection");
         }
         
         //UserDetails
         driver.findElement(By.className("hamburger-btn")).click();
         Thread.sleep(2000);
         Actions actions1=new Actions(driver);
         actions1.moveByOffset(100, 100).click().perform();
         Thread.sleep(2000);
         boolean img=driver.findElement(By.className("profileimage")).isDisplayed();
         System.out.println("Profile image present:"+img);
         driver.findElement(By.linkText("Give your attendance")).click();
         Thread.sleep(2000);
         driver.findElement(By.className("dashboardbtn")).click();
         Thread.sleep(2000);
         driver.findElement(By.linkText("Request Leave")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//select[@formcontrolname='leaveTypeId']")).click();
         Thread.sleep(2000);
         WebElement selectLeave=driver.findElement(By.xpath("//button[@type='submit']"));
         selectLeave.click();
         Thread.sleep(2000);
         selectLeave.sendKeys("SL");
         Thread.sleep(2000);
         WebElement date=driver.findElement(By.id("startDate"));
         date.click();
         Thread.sleep(2000);
         date.sendKeys("02-19-2025");
         Thread.sleep(2000);
         WebElement reason=driver.findElement(By.id("reason"));
         reason.click();
         Thread.sleep(2000);
         reason.sendKeys("Feeling not well");
         Thread.sleep(2000);
         driver.findElement(By.className("btn-success")).click();
         System.out.println("Leave applied successfully");
         Thread.sleep(2000);
         driver.findElement(By.className("dashboardbtn")).click();
         Thread.sleep(2000);
         driver.findElement(By.linkText("View Attendance Requests from Students")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("Approve1002025-01-31")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("Reject1032025-01-31")).click();
         Thread.sleep(2000);
         driver.findElement(By.className("dashboardbtn")).click();
	     }
	    		 
	     
	    
	   
	     
          
	}



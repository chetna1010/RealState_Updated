package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.training.pom.AddedUserPOM;
import com.training.pom.Register_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_035_AddedUser {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String adminURL;
	private static Properties properties;
	private ScreenShot screenshot;
	private AddedUserPOM AddedUserPOM;
	private Register_LoginPOM register_LoginPOM;
	
	 @BeforeClass
	  public void beforeClass() throws IOException  {
		 
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
	  }
	 
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
			register_LoginPOM = new Register_LoginPOM(driver);
			adminURL = properties.getProperty("adminURL");
			screenshot = new ScreenShot(driver);
			AddedUserPOM = new AddedUserPOM(driver);
			// open the browser
			driver.get(adminURL);
		  
	  }
  @Test
  public void f() throws InterruptedException {
	  wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs to load the page
	  wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getLoginRegister()));  // launch the Application
	  screenshot.captureScreenShot("RETC_035_login_00_launch");
	  
	  register_LoginPOM.sendUserName("admin"); // Enter user name and password
		register_LoginPOM.sendPassword("admin@123");
		
		register_LoginPOM.clickLoginBtn(); // Click on login button
		
		Actions actions = new Actions(driver);
		actions.moveToElement(AddedUserPOM.getUsers()).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add New")).click();
		
		Thread.sleep(5000);
		
	
		//When I run this script 2nd time getting the mail id already exists so used below function to generate random chars 
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
    	AddedUserPOM.sendUserName(saltStr); 
		AddedUserPOM.sendEmail(saltStr+"@gmail.com"); 
		AddedUserPOM.sendFname(saltStr); 
		AddedUserPOM.sendLname(saltStr); 
		AddedUserPOM.sendUrl("www.google.com");
		AddedUserPOM.clickPasswordBtn();
		
		Thread.sleep(5000);
		AddedUserPOM.sendPasswordText("ramesh@ramesh1234");
		
		Select role = new Select(driver.findElement(By.id("role")));
		role.selectByValue("agent");
		
		Thread.sleep(5000);
		
		AddedUserPOM.clickcreateusersub();
		
		Thread.sleep(5000);
		
	String Newusercreated = driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();
		
		// Verify New user created. Edit user Message should get displayed 

	
	System.out.println(Newusercreated);
		  String Expected ="New user created. Edit user";
		  String Actual =  Newusercreated;		
		  assertEquals(Actual, Expected);
		  
		  
		  AddedUserPOM.clickAllusers();
		  
		  AddedUserPOM.sendsearchinput(saltStr);
		  AddedUserPOM.clicksearchsubmit();
		  
		  
		  
		  
		  String Newuser = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[3]/form/table/tbody/tr/td[1]/strong/a")).getText();
			
			// Verify created user should get displayed

			  String Expected1 = (saltStr);
			  String Actual1 =  Newuser;		
			  assertEquals(Actual1, Expected1);
  }


  @AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
	  
  		}

 

 }

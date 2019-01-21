package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPropertyPOM;
import com.training.pom.Register_LoginPOM;
import com.training.pom.AddedPropertyDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_033_AddedPropertyDetails {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddNewPropertyPOM addNewPropertyPOM;
	private AddedPropertyDetailsPOM AddedPropertyDetailsPOM;
	
	private Register_LoginPOM register_LoginPOM;

	@BeforeClass
	  public void beforeClass() throws IOException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		register_LoginPOM = new Register_LoginPOM(driver);
		AddedPropertyDetailsPOM = new AddedPropertyDetailsPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		addNewPropertyPOM = new AddNewPropertyPOM(driver);
		// open the browser
		driver.get(adminURL);
	  }
	
  @Test
  public void RETC_002_Login() throws InterruptedException {
	  	wait = new WebDriverWait(driver, 30); // this function will be wait 180 secs to load the page
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_031_login_00_launch");
		
		register_LoginPOM.sendUserName("admin"); // Enter user name and password
		register_LoginPOM.sendPassword("admin@123");
		
		register_LoginPOM.clickLoginBtn(); // Click on login button
		
		
		Actions actions = new Actions(driver); // Used mouse action function to click on properties link then click on add new
		actions.moveToElement(addNewPropertyPOM.getProperties()).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Add New")).click();
		
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getEnterTitleHere())); // Wait until EntrTitleHere text displays
		screenShot.captureScreenShot("RETC_031_login_02_EnterTitleHere");
		
		//Used random function to enter below details
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
		
		addNewPropertyPOM.sendEnterTitleHere(saltStr);
		
		addNewPropertyPOM.sendcontent(saltStr);
		
		Thread.sleep(5000);
		
		AddedPropertyDetailsPOM.clickPublishButton();
		
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(AddedPropertyDetailsPOM.getPostPublished())); // wait until post publish details displays
		screenShot.captureScreenShot("RETC_033_login_03_PostPublished");
		
		String PostPublished = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p")).getText();
		
		//Verify Post published should get displayed
		
		Thread.sleep(5000);
		
		  String Expected ="Post published. View post";
		  String Actual =  PostPublished;		
		  assertEquals(Actual, Expected);
		
		Thread.sleep(5000);
		  
		  AddedPropertyDetailsPOM.clickAllProperties(); // Click on All Properties link
		  
		  // Enter title text and click on search button 
		  
		  AddedPropertyDetailsPOM.sendsearchinput(saltStr);
		  AddedPropertyDetailsPOM.clicksearchsubmit();
		  
		  
		 Thread.sleep(5000);
		  
			String Addedproperty = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/table/tbody/tr[1]/td[1]/strong/a")).getText();
			
			// verify added property details. Message should get displayed
			
				  String Expected1 = saltStr;
				  String Actual1 =  Addedproperty;		
				  assertEquals(Actual1, Expected1);
		  
  
  }
  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  
  
  
  }

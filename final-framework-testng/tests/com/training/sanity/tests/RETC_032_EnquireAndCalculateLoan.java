package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPropertyPOM;
import com.training.pom.EnquireAndCalculateLoanPOM;
import com.training.pom.Register_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_032_EnquireAndCalculateLoan {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	private Register_LoginPOM register_LoginPOM;
	private EnquireAndCalculateLoanPOM EnquireAndCalculateLoanPOM;

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
		EnquireAndCalculateLoanPOM = new EnquireAndCalculateLoanPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		new AddNewPropertyPOM(driver);
		// open the browser
		driver.get(adminURL);
	  }
	
  @Test
  public void RETC_002_Login() throws InterruptedException {
	  
	  	wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs until load the page
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_00_launch");
		
		register_LoginPOM.sendUserName("admin"); // Enter user name and password
		
		register_LoginPOM.sendPassword("admin@123");
		
		register_LoginPOM.clickLoginBtn(); // Click on login button
		
		Thread.sleep(5000);
		
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_01_LoginAdmin");
		
		EnquireAndCalculateLoanPOM.clickHomePage();
		
		Thread.sleep(5000);
		
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_02_Homepage");
		
		Actions actions = new Actions(driver); // Used mouse action function to click on NewLunch link then click on NullamHendrerit
		actions.moveToElement(EnquireAndCalculateLoanPOM.getNewLunch()).build().perform();
		Thread.sleep(5000);
		EnquireAndCalculateLoanPOM.clickNullamHendrerit(); //Click on Nullam hendrerit apartment icon
		
		Thread.sleep(5000);
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_03_NewLunch");
		
		
		Actions actions1 = new Actions(driver); // Used mouse action function to click on NullamHendrerit link then click on next
		actions1.moveToElement(EnquireAndCalculateLoanPOM.getNullamHendreritImage()).build().perform();
		Thread.sleep(5000);
		EnquireAndCalculateLoanPOM.clickNullamHendreritNext();
		
		Thread.sleep(5000);
		
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_04_NullamHendreritNext");
		
		//Enter valid details in Enquiries window
		
		EnquireAndCalculateLoanPOM.sendYourName("Ramesh");
		EnquireAndCalculateLoanPOM.sendYourEmail("rameshaku2019@gmail.com");
		EnquireAndCalculateLoanPOM.sendYourSubject("Apartment");
		EnquireAndCalculateLoanPOM.sendYourMessage("looking for apartment");
		
		EnquireAndCalculateLoanPOM.clickSubmit(); //Click on Send button
		
		Thread.sleep(5000);
		
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_05_Message sucess");
		
		String messagesend = driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		
		// verify Thank you for your message. It has been sent. Message should get displayed
			
			  String Expected ="Thank you for your message. It has been sent.";
			  String Actual =  messagesend;		
			  assertEquals(Actual, Expected);
			  
			 // Enter valid details in Mortgage Calculator
			  
			  	EnquireAndCalculateLoanPOM.sendAmount("4000");
				EnquireAndCalculateLoanPOM.sendDownpayment("2000");
				EnquireAndCalculateLoanPOM.sendLoanTerm("2");
				EnquireAndCalculateLoanPOM.sendInterest("5");
				
				screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_04_NullamHendreritNext");
				
				EnquireAndCalculateLoanPOM.clickCalcButton();	 //Click on Calculate button 
				
				Thread.sleep(5000);
		
				String Calculate = driver.findElement(By.xpath("//div[@class='notification success']")).getText();
				
				// verify Monthly Payment: 87.74 Rs. Message should get displayed
				
					
					  String Expected1 ="Monthly Payment: 87.74 Rs.";
					  String Actual1 =  Calculate;		
					  assertEquals(Actual1, Expected1);
			  
  }
  
  
  @AfterMethod
 public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
 
		
}

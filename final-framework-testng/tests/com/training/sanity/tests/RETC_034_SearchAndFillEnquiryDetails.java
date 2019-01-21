package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.Register_LoginPOM;
import com.training.pom.SearchAndFillEnquiryDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_034_SearchAndFillEnquiryDetails {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private Register_LoginPOM register_LoginPOM;
	private SearchAndFillEnquiryDetailsPOM searchAndFillEnquiryDetailsPOM;

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
		searchAndFillEnquiryDetailsPOM = new SearchAndFillEnquiryDetailsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	  }
	
  @Test
  public void RETC_002_Login() throws InterruptedException {
	  	wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs to load the page
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_00_launch");
		
		register_LoginPOM.clicklogin_register(); // click on login/register link
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getUserName())); // Wait until username filed displays
		screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_01_login_register");
		
		register_LoginPOM.sendUserName("rameshakula82@gmail.com"); // Enter user name and password
		register_LoginPOM.sendPassword("ramesh1234");
		
		register_LoginPOM.clickLoginBtn(); // Click on login button
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getProfile()));
		screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_02_Login_success");
		
		searchAndFillEnquiryDetailsPOM.clickCommercial(); //Click on Commercial tab
		
		screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_03_Commercial page");
		searchAndFillEnquiryDetailsPOM.SendSearch("Nullam hendrerit Apartments"); // search for Nullam hendrerit Apartments
		Thread.sleep(5000);
		screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_04_search"); 
		
		searchAndFillEnquiryDetailsPOM.clickSearchselect(); // click on search button and Nullam hendrerit apartment page should get displayed
		
		// the below function will be swtich to new window
		
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 
		 Thread.sleep(5000);
		 
		 //the below function will be scroll down to the page and click on contact Us
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    
		 searchAndFillEnquiryDetailsPOM.clickContactUs();
		 screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_04_Contact us");
		 
		 Thread.sleep(5000);
		 
		 //the below function will be scroll down and enter below details
	
		 JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 
		    js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    
		    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 10) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
		 
		 searchAndFillEnquiryDetailsPOM.SendName(saltStr);
		 searchAndFillEnquiryDetailsPOM.SendEmail(saltStr+"@gmail.com");
		 searchAndFillEnquiryDetailsPOM.SendSubject("Selenium");
		 searchAndFillEnquiryDetailsPOM.SendComments("Looking for Nullam hendrerit apartments");
		 
		 screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_05_ContactDetails");
		 
		 searchAndFillEnquiryDetailsPOM.clickSubmit(); // Click on submit button 
		 
		 //the below function will be scroll down and verify thanks message text
		 
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 
		    js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 
			wait.until(ExpectedConditions.visibilityOf(searchAndFillEnquiryDetailsPOM.getThanksMessage())); // will wait until Thanks message displays 
			
			 screenShot.captureScreenShot("RETC_034_SearchAndFillEnquiryDetails_06_Thanks message");
			
			Thread.sleep(5000);
			
			String ThanksMessage = driver.findElement(By.xpath("//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[4]")).getText();
			
			//Verify Thank you for your message. It has been sent. should get displayed
					
				Thread.sleep(5000);
			  String Expected ="Thank you for your message. It has been sent.";
			  String Actual =  ThanksMessage;		
			  assertEquals(Actual, Expected);
		 
		 
		 
  }
  
  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  
}

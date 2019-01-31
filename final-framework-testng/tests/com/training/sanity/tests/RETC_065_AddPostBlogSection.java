package com.training.sanity.tests;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPropertyPOM;
import com.training.pom.AddPostBlogSectionPOM;
import com.training.pom.AddedPropertyDetailsPOM;
import com.training.pom.AddNewPropertyPOM;
import com.training.pom.Register_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_065_AddPostBlogSection {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddPostBlogSectionPOM AddPostBlogSectionPOM;
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
		AddPostBlogSectionPOM = new AddPostBlogSectionPOM(driver);
		AddedPropertyDetailsPOM = new AddedPropertyDetailsPOM(driver);
		addNewPropertyPOM = new AddNewPropertyPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		
		// open the browser
		driver.get(adminURL);
	  }
	
  @Test
  public void RETC_002_Login() throws InterruptedException {
	  	wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs to load the page
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_031_login_00_launch");
		
		register_LoginPOM.sendUserName("admin"); // Enter user name and password
		register_LoginPOM.sendPassword("admin@123");
		
		register_LoginPOM.clickLoginBtn(); // Click on login button
		
		
		Actions actions = new Actions(driver); // Used mouse action function to click on properties link then click on Add new
		actions.moveToElement(AddPostBlogSectionPOM.getPosts()).build().perform();
		Thread.sleep(2000);
		AddPostBlogSectionPOM.clickCategories();
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
		
		AddPostBlogSectionPOM.sendTagName(saltStr);	
		AddPostBlogSectionPOM.sendTagSlug(saltStr);	
		
	/*	Select country = new Select(driver.findElement(By.id("parent")));
		country.selectByVisibleText("New Launches");*/
	
		AddPostBlogSectionPOM.sendTagDescription("New Launches of villas, apartments, flats");	
		
		AddPostBlogSectionPOM.clickSubmit();
		
		Thread.sleep(10000);
		
		AddPostBlogSectionPOM.sendSearchinput(saltStr);	
		AddPostBlogSectionPOM.clicksearchsubmit();
		
		String searchsubmit1 = driver.findElement(By.xpath("//*[@class='row-title']")).getText();
		
		// Verify You have successfully registered to Real Estate. We have emailed your password to the email address you entered. Message should get displayed on the screen & password should be sent to entered mail address

		  String Expected =saltStr;
		  String Actual =  searchsubmit1;		
		  assertEquals(Actual, Expected);
		  
		  Actions actions1 = new Actions(driver); // Used mouse action function to click on properties link then click on add new
			actions1.moveToElement(addNewPropertyPOM.getProperties()).build().perform();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Add New")).click();
			
			wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getEnterTitleHere())); // Wait until EntrTitleHere text displays
			screenShot.captureScreenShot("RETC_031_login_02_EnterTitleHere");
			
			//Used random function to enter below details
			
		
			
			addNewPropertyPOM.sendEnterTitleHere("new Lunch");
			
			addNewPropertyPOM.sendcontent("new lunch");
			
			Thread.sleep(5000);
			
			AddedPropertyDetailsPOM.clickPublishButton();
			
			Thread.sleep(10000);
			
			wait.until(ExpectedConditions.visibilityOf(AddedPropertyDetailsPOM.getPostPublished())); // wait until post publish details displays
			screenShot.captureScreenShot("RETC_033_login_03_PostPublished");
			
			String PostPublished = driver.findElement(By.id("message")).getText();
			
			//Verify Post published should get displayed
			
			Thread.sleep(5000);
			
			  String Expected1 ="Post published. View post\n" + 
				  		"Dismiss this notice.";
			  String Actual1 =  PostPublished;		
			  assertEquals(Actual1, Expected1);
		  
		  
		
}
  

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  
  

}

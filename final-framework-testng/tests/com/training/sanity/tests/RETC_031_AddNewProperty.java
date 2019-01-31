
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.training.pom.Register_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_031_AddNewProperty {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddNewPropertyPOM addNewPropertyPOM;
	
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
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		addNewPropertyPOM = new AddNewPropertyPOM(driver);
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
		actions.moveToElement(addNewPropertyPOM.getProperties()).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add New")).click();
		
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getEnterTitleHere()));
		
		screenShot.captureScreenShot("RETC_031_login_02_EnterTitleHere");
		
		addNewPropertyPOM.sendEnterTitleHere("new launch"); //  Enter valid text in Enter Title Here textbox 
		
		addNewPropertyPOM.sendcontent("new launch"); //Enter valid text in textbox
		
		Thread.sleep(5000);
		
		addNewPropertyPOM.sendprice("50000");  // Enter valid amount in Price Here textbox
		
		addNewPropertyPOM.sendpricePerSq("200"); //Enter valid amount in Price per sq. meter/sq. ft textbox
		
		screenShot.captureScreenShot("RETC_031_login_03_Price Details");
		
		addNewPropertyPOM.clickMainDetails(); //Click on Main Details tab
		
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getMainDetailsStatus())); // this function will be wait until Main details status displays
		
		screenShot.captureScreenShot("RETC_031_login_04_MainDetails");
		
		addNewPropertyPOM.sendMainDetailsStatus("new"); //Enter valid text in Status textbox
		
	
		
		addNewPropertyPOM.sendMainDetailsLocation("Electronic city"); // Enter valid text in Location textbox
		
	
		addNewPropertyPOM.sendMainDetailsPossession("immediate"); // Enter valid text in Possession textbox
		
		addNewPropertyPOM.clickLocation(); // Click on Location tab
		
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getLocationAddress())); // This function will be wait until Location Address displays
		
		screenShot.captureScreenShot("RETC_031_login_05_LocationAddress");
				
		addNewPropertyPOM.sendLocationAddress("yeshwanthapur"); //Enter valid text in Address textbox
		
		addNewPropertyPOM.sendGoogleMapAddress("yeshwanthapur"); // Enter valid text in Google Maps Address textbox
		
		addNewPropertyPOM.sendLocationLatitude("120"); //Enter valid text in Latitude textbox
		
		addNewPropertyPOM.sendLocationLongitude("56"); //Enter valid text in Longitude textbox
		
		addNewPropertyPOM.clickDetailsTab(); // Click on Details tab
		
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getDetailsStorageRoom())); // wait until Details storage room displays
		
		screenShot.captureScreenShot("RETC_031_login_06_DetailsStorageRoom");
		
		addNewPropertyPOM.sendDetailsStorageRoom("2"); //Enter valid text in Storage Room textbox
		
		Thread.sleep(2000);
		
				
		if ( !addNewPropertyPOM.getCentralBangalore().isSelected() )
		{
		     addNewPropertyPOM.clickCentralBangalore();
		}
				
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getPublishButton())); 
		
		screenShot.captureScreenShot("RETC_031_login_06_PublishButton");
				
			
		// The below function will be scroll up and click on Publish button
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		    js.executeScript("window.scrollTo(0, 0)");
		
		addNewPropertyPOM.clickPublishButton();
		
		wait.until(ExpectedConditions.visibilityOf(addNewPropertyPOM.getPostPublished())); 

		String PostPublished = driver.findElement(By.id("message")).getText();
		
		//Verify My Profile page should get displayed
		

		
		  String Expected ="Post published. View post\n" + 
		  		"Dismiss this notice.";
		  String Actual =  PostPublished;		
		  assertEquals(Actual, Expected);
		  
		  
		 
  }
  

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  
  
}


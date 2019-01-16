
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.changePasswordPOM;
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

public class RETC_005_changePassword {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private changePasswordPOM changePasswordPOM;

	@BeforeClass
	  public void beforeClass() throws IOException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		changePasswordPOM = new changePasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	  }
	
  @Test
  public void RETC_005_changePassword() throws InterruptedException {
	  	wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs to load the page
		wait.until(ExpectedConditions.visibilityOf(changePasswordPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_005_changePassword_00_launch");
		
		changePasswordPOM.clicklogin_register(); // click on login/register link
		wait.until(ExpectedConditions.visibilityOf(changePasswordPOM.getUserName())); // Wait until username filed displays 
		screenShot.captureScreenShot("RETC_005_changePassword_01_login_register"); 
		
		changePasswordPOM.sendUserName("rameshakula82@gmail.com"); // Enter user name and password
		changePasswordPOM.sendPassword("ramesh1234");
		changePasswordPOM.clickLoginBtn();  // click on login button
		wait.until(ExpectedConditions.visibilityOf(changePasswordPOM.getProfile())); //Wait until profile text displays 
		screenShot.captureScreenShot("RETC_005_changePassword_02_Login_success");
		
		Actions actions = new Actions(driver); // Used mouse action funtion to click on User Hyper link then click on MY profile 
		actions.moveToElement(changePasswordPOM.getUserHyperlink()).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("My Profile")).click();
		
		screenShot.captureScreenShot("RETC_005_changePassword_03_MyProfile");
		
		changePasswordPOM.clickChangePWD(); // Click on Change password 
		wait.until(ExpectedConditions.visibilityOf(changePasswordPOM.getChangePWD()));
		screenShot.captureScreenShot("RETC_005_changePassword_04_change password");
		
		changePasswordPOM.sendcurrentPass("ramesh1234"); //Enter Old and new password deatils 
		changePasswordPOM.sendNewPass("ramesh1234");
		changePasswordPOM.sendReNewPass("ramesh1234");
		
		changePasswordPOM.clickupdatednewpassword(); //click on update password
		wait.until(ExpectedConditions.visibilityOf(changePasswordPOM.getupdatednewpassword()));
		screenShot.captureScreenShot("RETC_005_changePassword_05_updatednewpassword");
		
	String updatedpassword = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/article/div[2]/div/div[1]/div/p")).getText();
		
	// verify Password Has been updated Message should get displayed
		
		  String Expected ="Your password has been updated.";
		  String Actual =  updatedpassword;		
		  assertEquals(Actual, Expected);
		  
		     
  }
  
   @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  

  
}



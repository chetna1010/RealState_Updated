
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.updateProfilePOM;
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

public class RETC_004_updateProfile {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private updateProfilePOM updateProfilePOM;

	@BeforeClass
	  public void beforeClass() throws IOException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		updateProfilePOM = new updateProfilePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	  }
	
  @Test
  public void RETC_004_updateProfile() throws InterruptedException {
	  
	  
	  	wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(updateProfilePOM.getLoginRegister()));
		screenShot.captureScreenShot("RETC_004_updateProfile_00_launch");
		
		updateProfilePOM.clicklogin_register();
		wait.until(ExpectedConditions.visibilityOf(updateProfilePOM.getUserName()));
		screenShot.captureScreenShot("RETC_004_updateProfile_01_login_register");
		
		updateProfilePOM.sendUserName("rameshakula82@gmail.com");
		updateProfilePOM.sendPassword("ramesh1234");
		updateProfilePOM.clickLoginBtn();
		
		wait.until(ExpectedConditions.visibilityOf(updateProfilePOM.getProfile()));
		screenShot.captureScreenShot("RETC_004_updateProfile_02_Login_success");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(updateProfilePOM.getUserHyperlink()).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("My Profile")).click();
				
		screenShot.captureScreenShot("RETC_004_updateProfile_03_MyProfile");
		
		updateProfilePOM.sendagentTitle("rameshakula Real Estate");
		updateProfilePOM.sendphone("9343925598");
		
		updateProfilePOM.clicksaveChanges();
		
		screenShot.captureScreenShot("RETC_004_updateProfile_04_ProfileUpdated");
		
		String updateprofile = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/article/div[2]/div/div[1]/div/p")).getText();
		
	
		  String Expected ="Your profile has been updated.";
		  String Actual =  updateprofile;		
		  assertEquals(Actual, Expected);
  }
  
  

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  

  
}



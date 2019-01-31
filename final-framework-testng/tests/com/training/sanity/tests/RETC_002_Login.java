
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_002_Login {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	  }
	
  @Test
  public void RETC_002_Login() {
	  	wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs to load the page
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_002_login_00_launch");
		
		register_LoginPOM.clicklogin_register(); // click on login/register link
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getUserName())); // Wait until username filed displays
		screenShot.captureScreenShot("RETC_002_login_01_login_register");
		
		register_LoginPOM.sendUserName("rameshakula82@gmail.com"); // Enter user name and password
		register_LoginPOM.sendPassword("ramesh1234");
		
		register_LoginPOM.clickLoginBtn(); // Click on login button
		wait.until(ExpectedConditions.visibilityOf(register_LoginPOM.getProfile()));
		screenShot.captureScreenShot("RETC_002_login_02_Login_success");
		
		String loginsuccess = driver.findElement(By.xpath("//*[@id=\"titlebar\"]/div/div/div/h2")).getText();
		
		//Verify My Profile page should get displayed

		
		  String Expected ="My Profile";
		  String Actual =  loginsuccess;		
		  assertEquals(Actual, Expected);
		   
  }
  

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
  

  
}


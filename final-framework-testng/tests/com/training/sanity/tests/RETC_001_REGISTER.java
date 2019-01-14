
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_001_REGISTER {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RegisterPOM registerPOM;

	@BeforeClass
	public void beforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	
	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@Test
	public void validRETC_001_REGISTER() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPOM.getLoginRegister()));
		screenShot.captureScreenShot("RETC_001_00_launch");

		registerPOM.clicklogin_register();
		wait.until(ExpectedConditions.invisibilityOf(registerPOM.getRegisterTab()));
		screenShot.captureScreenShot("RETC_001_01_Login_Registeration");
		registerPOM.clickRegisterTab();
		wait.until(ExpectedConditions.visibilityOf(registerPOM.getEmail()));
		screenShot.captureScreenShot("RETC_001_02_Register_Tab");
				
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
		registerPOM.sendemail(saltStr+"@gmail.com");
		registerPOM.sendfirstName(saltStr);
		registerPOM.sendlastName(saltStr);
		registerPOM.clickRegister();
		wait.until(ExpectedConditions.visibilityOf(registerPOM.getSuccess()));
		screenShot.captureScreenShot("RETC_001_03_Registration_Status");
		
		String registersuccess = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/article/div/div/div/div[1]/p")).getText();
		
		  String Expected ="You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		  String Actual =  registersuccess;		
		  assertEquals(Actual, Expected);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
}



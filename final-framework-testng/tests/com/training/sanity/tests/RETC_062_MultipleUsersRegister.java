
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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

import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_062_MultipleUsersRegister {

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
	public void registerDBTest()
	{
		wait = new WebDriverWait(driver, 180); // this function will be wait 180 secs until load the page
		wait.until(ExpectedConditions.visibilityOf(registerPOM.getLoginRegister())); // launch the Application
		screenShot.captureScreenShot("RETC_001_00_launch"); 

		registerPOM.clicklogin_register(); // click on login/register link
		wait.until(ExpectedConditions.invisibilityOf(registerPOM.getRegisterTab()));
		screenShot.captureScreenShot("RETC_001_01_Login_Registeration");
		
		registerPOM.clickRegisterTab(); // Click on Register tab
		wait.until(ExpectedConditions.visibilityOf(registerPOM.getEmail()));
		screenShot.captureScreenShot("RETC_001_02_Register_Tab");
		
		//When I run this script 2nd time getting the mail id already register so used below function to generate random chars 
				
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
		
		String registersuccess = driver.findElement(By.xpath("//div[@class='notification success closeable']")).getText();
		
		// Verify You have successfully registered to Real Estate. We have emailed your password to the email address you entered. Message should get displayed on the screen & password should be sent to entered mail address

		  String Expected ="You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		  String Actual =  registersuccess;		
		  assertEquals(Actual, Expected);
		  
		  ELearningDAO eLearningDAO = new ELearningDAO();
		  
		  eLearningDAO.insertRegisterIntoDB(saltStr+"@gmail.com", saltStr, saltStr, Actual);
		  
		  List<RegisterBean> rBean = eLearningDAO.getRegisterDetails();
		  for (RegisterBean registerBean : rBean) {
			  System.out.println(registerBean.getfName() +"  "+ registerBean.getlName() +"  "+ registerBean.getEmail()+"  "+registerBean.getComments());
		}
		 
		 
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
}



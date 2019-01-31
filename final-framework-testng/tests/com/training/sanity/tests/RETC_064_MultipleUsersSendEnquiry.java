package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.MultipleUsersSendEnquiry;
import com.training.generics.ScreenShot;
import com.training.pom.MultipleUsersSendEnquiryPOM;
import com.training.pom.Register_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_064_MultipleUsersSendEnquiry {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private MultipleUsersSendEnquiryPOM MultipleUsersSendEnquiryPOM;
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
		MultipleUsersSendEnquiryPOM = new MultipleUsersSendEnquiryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	  }
	
  @Test
  (dataProvider = "MultipleUsersSendEnquiry_excel_inputs", dataProviderClass = MultipleUsersSendEnquiry.class)
  public void f(String email, String fristName, String subject, String message) throws InterruptedException {
	  
	  wait = new WebDriverWait(driver, 30); // this function will be wait 30 secs to load the page
		wait.until(ExpectedConditions.visibilityOf(MultipleUsersSendEnquiryPOM.getApartment())); // launch the Application
		screenShot.captureScreenShot("RETC_064_Homepage_00_launch");
	
		Actions actions = new Actions(driver); // Used mouse action function to mouse hover  on apartment link then click on Prestige
		actions.moveToElement(MultipleUsersSendEnquiryPOM.getApartment()).build().perform();
		Thread.sleep(2000);
		MultipleUsersSendEnquiryPOM.clickPrestige(); //Click on Nullam hendrerit apartment icon
		
		Thread.sleep(5000);
		MultipleUsersSendEnquiryPOM.sendYourName(fristName);
		MultipleUsersSendEnquiryPOM.sendYourEmail(email);
		MultipleUsersSendEnquiryPOM.sendYourSubject(subject);
		MultipleUsersSendEnquiryPOM.sendYourMessage(message);
		
		MultipleUsersSendEnquiryPOM.clickSubmit(); //Click on Send button
		
		screenShot.captureScreenShot("RETC_032_EnquireAndCalculateLoanPOM_05_Message sucess");
		
		String messagesend = driver.findElement(By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/div[2]")).getText();
		
		// verify Thank you for your message. It has been sent. Message should get displayed
			
		
		System.out.println(messagesend);
			  String Expected ="Thank you for your message. It has been sent.";
			  String Actual =  messagesend;		
			  assertEquals(Actual, Expected);
  }


  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
		
  }

	

}

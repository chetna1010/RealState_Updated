package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleUsersSendEnquiryPOM {
	private WebDriver driver; 
	
	@FindBy(id="menu-item-346")
	private WebElement Apartment; 
	
	@FindBy(xpath="//*[@id=\"wpmm-megamenu\"]/div[2]/div[2]/div[1]/a/img")
	private WebElement prestige; 
	
	@FindBy(name="your-name")
	private WebElement YourName; 
	
	@FindBy(name="your-email")
	private WebElement YourEmail; 
	
	@FindBy(name="your-subject")
	private WebElement YourSubject; 
	
	@FindBy(name="your-message")
	private WebElement YourMessage; 
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement Submit; 
	
	
	public MultipleUsersSendEnquiryPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void clickApartment() {
		this.Apartment.click(); 
	}
	
	public WebElement getApartment() {
		return this.Apartment;
	}
	
	public void clickPrestige() {
		this.prestige.click(); 
	}
	
	public void sendYourName(String YourName) {
		this.YourName.clear();
		this.YourName.sendKeys(YourName);
	}
	
	public void sendYourEmail(String YourEmail) {
		this.YourEmail.clear();
		this.YourEmail.sendKeys(YourEmail);
	}
	
	public void sendYourSubject(String YourSubject) {
		this.YourSubject.clear();
		this.YourSubject.sendKeys(YourSubject);
	}
	
	public void sendYourMessage(String YourMessage) {
		this.YourMessage.clear();
		this.YourMessage.sendKeys(YourMessage);
	}
	
	public void clickSubmit() {
		this.Submit.click(); 
	}

}

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnquireAndCalculateLoanPOM {
	
	private WebDriver driver; 
	

	@FindBy(xpath="//*[@id=\"wp-admin-bar-site-name\"]/a")
	private WebElement HomePage;
	
	@FindBy(id="menu-item-354")
	private WebElement NewLunch; 
	
	
	@FindBy(xpath="//*[@id=\"wpmm-megamenu\"]/div/div[3]/div[1]/a/img")
	private WebElement NullamHendrerit;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[4]/div/div/div[1]/div/div/a[1]")
	private WebElement NullamHendreritImage;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[4]/div/div/div[1]/button[2]")
	private WebElement NullamHendreritNext;
	
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
	
	@FindBy(id="amount")
	private WebElement Amount;
	
	@FindBy(id="downpayment")
	private WebElement Downpayment;
	
	@FindBy(id="years")
	private WebElement LoanTerm;
	
	@FindBy(id="interest")
	private WebElement Interest;
	
	@FindBy(xpath="//button[@class='button calc-button']")
	private WebElement CalcButton;
	
	
	
	
	
	public EnquireAndCalculateLoanPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickHomePage() {
		this.HomePage.click(); 
	}


	public void clickNewLunch() {
		this.NewLunch.click(); 
	}

	public WebElement getNewLunch() {
		return this.NewLunch;
	}

	public void clickNullamHendrerit() {
		this.NullamHendrerit.click(); 
	}

	public WebElement getNullamHendrerit() {
		return this.NullamHendrerit;
	}
	
	public void clickNullamHendreritImage() {
		this.NullamHendreritImage.click(); 
	}
	
	public WebElement getNullamHendreritImage() {
		return this.NullamHendreritImage;
	}

	public void clickNullamHendreritNext() {
		this.NullamHendreritNext.click(); 
	}
	
	public WebElement getNullamHendreritNext() {
		return this.NullamHendreritNext;
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
	
	
	
	public void sendAmount(String Amount) {
		this.Amount.clear();
		this.Amount.sendKeys(Amount);
	}
	
	public void sendDownpayment(String Downpayment) {
		this.Downpayment.clear();
		this.Downpayment.sendKeys(Downpayment);
	}
	
	public void sendLoanTerm(String LoanTerm) {
		this.LoanTerm.clear();
		this.LoanTerm.sendKeys(LoanTerm);
	}
	
	public void sendInterest(String Interest) {
		this.Interest.clear();
		this.Interest.sendKeys(Interest);
	}
	
	public void clickCalcButton() {
		this.CalcButton.click(); 
	}
	
}

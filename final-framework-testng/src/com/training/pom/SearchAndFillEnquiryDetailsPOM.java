package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAndFillEnquiryDetailsPOM {
	
	private WebDriver driver; 
	
	@FindBy(xpath="//li[@id='menu-item-513']")
	private WebElement Commercial;
	
	@FindBy(name="phrase")
	private WebElement Search;
	
	@FindBy(xpath="//*[@id=\"mCSBap_1_container\"]")
	private WebElement Searchselect;
	
	@FindBy(xpath="//li[@id='menu-item-180']")
	private WebElement ContactUs;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement Name;
	
	@FindBy(xpath ="//input[@name='email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@name='subject']")
	private WebElement Subject;
	
	@FindBy(xpath="//textarea[@name='id:comments']")
	private WebElement Comments;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Submit;
	
	@FindBy(xpath="//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[4]")
	private WebElement ThanksMessage;
	
	public SearchAndFillEnquiryDetailsPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
	


	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCommercial() {
		this.Commercial.click();
	}
	
	public void SendSearch(String Search) {
		this.Search.clear();
		this.Search.sendKeys(Search);
	}
	
	public void clickSearchselect() {
		this.Searchselect.click();
	}
	
	public void clickContactUs() {
		this.ContactUs.click();
	}
	
	public void SendName(String Name) {
		this.Name.clear();
		this.Name.sendKeys(Name);
		
		}
	public void SendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public void SendSubject (String Subject) {
		this.Subject.clear();
		this.Subject.sendKeys(Subject);
		}
	
	public void SendComments(String Comments) {
		this.Comments.clear();
		this.Comments.sendKeys(Comments);
	}
	
	public void clickSubmit() {
		this.Submit.click();
	}
	
	public WebElement getThanksMessage() {
		return this.ThanksMessage;
	}



}



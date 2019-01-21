package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedPropertyDetailsPOM {
	
	private WebDriver driver; 
	
	@FindBy(id="publish")
	private WebElement  PublishButton;
	
	@FindBy(xpath="//*[@id=\"message\"]")
	private WebElement  PostPublished;
	
	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[2]/a")
	private WebElement AllProperties; 
	
	@FindBy(id="post-search-input")
	private WebElement searchinput;
	
	@FindBy(id="search-submit")
	private WebElement searchsubmit;
	
		
	public AddedPropertyDetailsPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void clickPublishButton() {
		
		this.PublishButton.click(); 
	}
	
	
	public WebElement getPublishButton() {
		return this.PublishButton;
	}
	
	
	public WebElement getPostPublished() {
		return this.PostPublished;
	}
	
	
	public void clickAllProperties() {
		System.out.println(this.AllProperties.getTagName());
		this.AllProperties.click(); 
	}
	

	public void sendsearchinput(String searchinput) {
		this.searchinput.clear();
		this.searchinput.sendKeys(searchinput);
	}
	
	public void clicksearchsubmit() {
		this.searchsubmit.click();
	}
	
	
}

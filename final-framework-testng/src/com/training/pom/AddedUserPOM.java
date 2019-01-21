package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedUserPOM {
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"menu-users\"]/a/div[3]")
	private WebElement Users;
	
	@FindBy(id="user_login")
	private WebElement UserName;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="first_name")
	private WebElement Fname;
	
	@FindBy(id="last_name")
	private WebElement Lname;
	
	@FindBy(id="url")
	private WebElement Url;
	
	@FindBy(xpath="//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	private WebElement PasswordBtn;
	
	@FindBy(id="pass1-text")
	private WebElement PasswordText;
	
	@FindBy(id="createusersub")
	private WebElement createusersub;
	
	@FindBy(xpath="//*[@id=\"menu-users\"]/ul/li[2]/a")
	private WebElement Allusers;
	
	@FindBy(id="user-search-input")
	private WebElement searchinput;
	
	@FindBy(id="search-submit")
	private WebElement searchsubmit;
	
	
	public AddedUserPOM(WebDriver driver) {
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickUser() {
		this.Users.click();
	}

	public WebElement getUsers() {
		
		return this.Users;
	}
	
	public void sendUserName(String UserName) {
		this.UserName.clear();
		this.UserName.sendKeys(UserName);
	}
	
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public void sendFname(String Fname) {
		this.Fname.clear();
		this.Fname.sendKeys(Fname);
	}
	
	public void sendLname(String Lname) {
		this.Lname.clear();
		this.Lname.sendKeys(Lname);
	}
	
	public void sendUrl(String Url) {
		this.Url.clear();
		this.Url.sendKeys(Url);
	}
	
	public void clickPasswordBtn() {
		this.PasswordBtn.click();
	}
	
	public void sendPasswordText(String PasswordText) {
		this.PasswordText.clear();
		this.PasswordText.sendKeys(PasswordText);
	}
	
	public void clickcreateusersub() {
		this.createusersub.click();
	}

	public void clickAllusers() {
		this.Allusers.click();
	}
	
	
	public void sendsearchinput(String searchinput) {
		this.searchinput.clear();
		this.searchinput.sendKeys(searchinput);
	}
	
	public void clicksearchsubmit() {
		this.searchsubmit.click();
	}
	
	
}

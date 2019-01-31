package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class changePasswordPOM {
	
	private WebDriver driver; 
			
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement login_register; 

	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;

	@FindBy(name="login")
	private WebElement login;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/div/div")
	private WebElement userHyperlink;
	
	
	@FindBy(xpath="//a[contains(@href,'realestate.hommelle.com/change-password')]")
	private WebElement ChangePWD;
	
	@FindBy(name="current_pass")
	private WebElement currentPass;
	
	@FindBy(name="pass1")
	private WebElement NewPass;
	
	@FindBy(name="pass2")
	private WebElement ReNewPass;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	private WebElement updatednewpassword;
	
	public changePasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
		
	public WebElement getUserName() {
		return this.userName;
	}
	
	
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clicklogin_register() {
		this.login_register.click(); 
	}
	
	public WebElement getLoginRegister() {
		return this.login_register;
	}
	
	public void clickUserHyperlink() {
		this.userHyperlink.click(); 
	}

	public WebElement getUserHyperlink() {
		return this.userHyperlink;
	}
	
	
	public void clickLoginBtn() {
		this.login.click(); 
	}

	public void clickChangePWD() {
		this.ChangePWD.click(); 
	}
	
	public WebElement getChangePWD() {
		return this.ChangePWD;
	}
	
	
	public void sendcurrentPass(String currentPass) {
		this.currentPass.clear();
		this.currentPass.sendKeys(currentPass);
	}
	
	public void sendNewPass(String NewPass) {
		this.NewPass.clear();
		this.NewPass.sendKeys(NewPass);
	}
	
	public void sendReNewPass(String ReNewPass) {
		this.ReNewPass.clear();
		this.ReNewPass.sendKeys(ReNewPass);
	}
	
	
	public void clickupdatednewpassword() {
		this.updatednewpassword.click(); 
		
	}
	
	public WebElement getupdatednewpassword() {
		return this.updatednewpassword;
	}
	
	}
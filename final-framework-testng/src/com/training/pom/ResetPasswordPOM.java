package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPOM{
	private WebDriver driver;
	
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement login_register; 
	
	@FindBy(linkText="Register")
	private WebElement registerTab; 
	
	@FindBy(linkText="Lost Your Password?")
	private WebElement forgotPassword;
	
	@FindBy(id="user_login")
	private WebElement email;
	
	@FindBy(name="submit")
	private WebElement resetpwd; 
	
	@FindBy(id="post-124")
	private WebElement conflink;
	
	@FindBy(id="identifierId")
	private WebElement gmailID;
	
	@FindBy(id="identifierNext")
	private WebElement gmailNext;
	
	@FindBy(name="password")
	private WebElement gmailPassword; 
	
	@FindBy(id="passwordNext")
	private WebElement gmailPasswordNext;
	
	@FindBy(id=":3d")
	private WebElement gmailWordPress; 
	
		
	@FindBy(xpath="//a[contains(@href,'realestate.hommelle')]")
	private WebElement wordPressLink; 
	
	@FindBy(id="pass1")
	private WebElement Enterpassword; 
	
	@FindBy(id="pass2")
	private WebElement ReEnterpassword; 
	
	@FindBy(id="resetpass-button")
	private WebElement Resetpassbutton; 
	
	
	@FindBy(xpath="//*[@id=\"post-124\"]") 
	private WebElement passwordchanged; 
	
	public WebElement getLoginRegister() {
		return this.login_register;
	}
	
	public ResetPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public void clickRegisterTab() {
		this.registerTab.click(); 
	}
	
	
	public void sendGmailID(String gmailID) {
		this.gmailID.clear();
		this.gmailID.sendKeys(gmailID);
	}
	
	
	public WebElement getGmailID() {
		return this.gmailID;
	}
	
	
	public void clickGmailNext() {
		this.gmailNext.click(); 
	
	}
	
	public WebElement getGmailNext() {
		return this.gmailNext;
	}
	
	public void sendGmailPassword(String gmailPassword) {
		this.gmailPassword.clear();
		this.gmailPassword.sendKeys(gmailPassword);
	}
	
	public WebElement getGmailpassword() {
		return this.gmailPassword;
	}
	
	public void clickGmailPasswordNext() {
		this.gmailPasswordNext.click(); 
	
	}
	
	public void clickGmailWordPress() {
		this.gmailWordPress.click(); 
	
	}
	
	public WebElement getGmailWordPress() {
		return this.gmailWordPress;
	}
	
	
	public void clickWordPressLink() {
		this.wordPressLink.click(); 
	
	}
	
	public WebElement getWordPressLink() {
		return this.wordPressLink;
	}
	
	
	public void clickforgotPassword() {
		this.forgotPassword.click(); 
	
	}
	
	public WebElement getEmail() {
		return this.email;
	}
	
	public WebElement getForgotPassword() {
		return this.forgotPassword;
	}
	
	public void clicklogin_register() {
		this.login_register.click(); 
	}
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickresetpwd() {
		this.resetpwd.click(); 
	}
	
	public WebElement getConflink() {
		return this.conflink;
	}

	public void sendEnterpassword(String Enterpassword) {
		this.Enterpassword.clear();
		this.Enterpassword.sendKeys(Enterpassword);
	}
	public WebElement getEnterpassword() {
		return this.Enterpassword;
	}
	
	public void sendReEnterpassword(String ReEnterpassword) {
		this.ReEnterpassword.clear();
		this.ReEnterpassword.sendKeys(ReEnterpassword);
	}
	
	public void clickResetpassbutton() {
		this.Resetpassbutton.click(); 
	}
		

	public WebElement getpasswordchanged() {
		return this.passwordchanged;
	}

}

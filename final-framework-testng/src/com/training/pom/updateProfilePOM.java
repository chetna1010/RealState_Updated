package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class updateProfilePOM {
	
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
	

	@FindBy(id="agent_title")
	private WebElement agentTitle;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveChanges;
	
	
	@FindBy(xpath="//div[@class='notification success closeable margin-bottom-35']")
	private WebElement ProfileUpdated;
	
	public updateProfilePOM(WebDriver driver) {
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

	
	public void sendagentTitle(String agentTitle) {
		this.agentTitle.clear();
		this.agentTitle.sendKeys(agentTitle);
	}
		
	
	public void sendphone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public WebElement getProfileUpdated() {
		return this.ProfileUpdated;
	}



	public void clicksaveChanges() {
		this.saveChanges.click();
		
	}




	
	}
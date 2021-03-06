package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDBTestPOM {
	private WebDriver driver;

	public LoginDBTestPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='sign-in']")
	private WebElement loginRegister;

	@FindBy(id = "user_login")
	private WebElement userName;

	@FindBy(id = "user_pass")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginBtn;

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

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	public WebElement getLoginRegister() {
		return this.loginRegister;
	}

	public void clicklogin_register() {
		this.loginRegister.click();

	}
}

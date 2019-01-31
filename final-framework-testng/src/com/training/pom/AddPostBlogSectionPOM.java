package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPostBlogSectionPOM {
private WebDriver driver; 
	
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]")
	private WebElement Posts;
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement Categories;
	
	@FindBy(id="tag-name")
	private WebElement  TagName;
	
	@FindBy(id="tag-slug")
	private WebElement  TagSlug;
	
	
	@FindBy(id="tag-description")
	private WebElement  TagDescription;
	
	@FindBy(id="submit")
	private WebElement  Submit;
	
	@FindBy(id="tag-search-input")
	private WebElement  searchinput;
	
	@FindBy(id="search-submit")
	private WebElement  searchsubmit;
	
	@FindBy(xpath="//*[@class='row-title']")
	private WebElement  searchreslut;
	
	public AddPostBlogSectionPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
	


	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void clickPosts() {
		this.Posts.click(); 
	}

	public WebElement getPosts() {
		return this.Posts;
	}
	
	public void clickCategories() {
		this.Categories.click(); 
	}
	
	
	public void sendTagName(String TagName) {
		this.TagName.clear();
		this.TagName.sendKeys(TagName);
	}
	
	public void sendTagSlug(String TagSlug) {
		this.TagSlug.clear();
		this.TagSlug.sendKeys(TagSlug);
	}
	
	public void sendTagDescription(String TagDescription) {
		this.TagDescription.clear();
		this.TagDescription.sendKeys(TagDescription);
	}
	
	public void clickSubmit() {
		this.Submit.click(); 
	}
	
	public void sendSearchinput(String searchinput) {
		this.searchinput.clear();
		this.searchinput.sendKeys(searchinput);
	}
	
	public void clicksearchsubmit() {
		this.searchsubmit.click(); 
	}
	

	public WebElement getsearchreslut() {
		return this.searchreslut;
	}
}

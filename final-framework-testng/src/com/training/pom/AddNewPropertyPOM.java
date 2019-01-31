package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropertyPOM {
	
	private WebDriver driver; 
	
	
	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
	private WebElement Properties;
	
	@FindBy(id="title")
	private WebElement  EnterTitleHere;
	
	@FindBy(id="content")
	private WebElement  content;
	
	@FindBy(id="_price")
	private WebElement  price;
	
	@FindBy(id="_price_per")
	private WebElement  pricePerSq;
	
	@FindBy(id="ui-id-2")
	private WebElement  MainDetails;
	
	@FindBy(id="_status")
	private WebElement  MainDetailsStatus;
	
	@FindBy(id="_location")
	private WebElement  MainDetailsLocation;
	
	@FindBy(id="_possession")
	private WebElement  MainDetailsPossession;
	
	@FindBy(id="ui-id-3")
	private WebElement  Location;
	
	@FindBy(id="_friendly_address")
	private WebElement  LocationAddress;
	
	@FindBy(id="_address")
	private WebElement  GoogleMapAddress;
	
	@FindBy(id="_geolocation_lat")
	private WebElement  LocationLatitude;
	
	@FindBy(id="_geolocation_long")
	private WebElement  LocationLongitude;
	
	@FindBy(id="ui-id-4")
	private WebElement  DetailsTab;
		
	@FindBy(id="_storage_room")
	private WebElement  DetailsStorageRoom;
	
	@FindBy(xpath="//*[@id=\"acf-group_5aa6786492979\"]/div/div/div[2]/div/div[2]/ul/li[5]/label/input")
	private WebElement  CentralBangalore;
	
	@FindBy(id="publish")
	private WebElement  PublishButton;
	
	@FindBy(id="message")
	private WebElement  PostPublished;
		
	public AddNewPropertyPOM(WebDriver driver) {
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
	}
	


	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void clickProperties() {
		this.Properties.click(); 
	}

	public WebElement getProperties() {
		return this.Properties;
	}
	
	public WebElement getEnterTitleHere() {
		return this.EnterTitleHere;
	}
	
	public void sendEnterTitleHere(String EnterTitleHere) {
		this.EnterTitleHere.clear();
		this.EnterTitleHere.sendKeys(EnterTitleHere);
	}
	
	
	public void sendcontent(String content) {
		this.content.clear();
		this.content.sendKeys(content);
	}
	
	public void sendprice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void sendpricePerSq(String pricePerSq) {
		this.pricePerSq.clear();
		this.pricePerSq.sendKeys(pricePerSq);
	}
		
	public void clickMainDetails() {
		this.MainDetails.click(); 
	}
	
	public WebElement getMainDetailsStatus() {
		return this.MainDetailsStatus;
	}
	
	public void sendMainDetailsStatus(String MainDetailsStatus) {
		this.MainDetailsStatus.clear();
		this.MainDetailsStatus.sendKeys(MainDetailsStatus);
	}
	
	public void sendMainDetailsLocation(String MainDetailsLocation) {
		this.MainDetailsLocation.clear();
		this.MainDetailsLocation.sendKeys(MainDetailsLocation);
	}
	
	public void sendMainDetailsPossession(String MainDetailsPossession) {
		this.MainDetailsPossession.clear();
		this.MainDetailsPossession.sendKeys(MainDetailsPossession);
	}
	
	
	public void clickLocation() {
		this.Location.click(); 
	}
	
	public WebElement getLocationAddress() {
		return this.LocationAddress;
	}
	
	public void sendLocationAddress(String LocationAddress) {
		this.LocationAddress.clear();
		this.LocationAddress.sendKeys(LocationAddress);
	}
	
	public void sendGoogleMapAddress(String GoogleMapAddress) {
		this.GoogleMapAddress.clear();
		this.GoogleMapAddress.sendKeys(GoogleMapAddress);
	}
	
	public void sendLocationLatitude(String LocationLatitude) {
		this.LocationLatitude.clear();
		this.LocationLatitude.sendKeys(LocationLatitude);
	}
	
	public void sendLocationLongitude(String LocationLongitude) {
		this.LocationLongitude.clear();
		this.LocationLongitude.sendKeys(LocationLongitude);
	}
	
	public void clickDetailsTab() {
		this.DetailsTab.click(); 
	}
	
	public WebElement getDetailsStorageRoom() {
		return this.DetailsStorageRoom;
	}
	
	public void sendDetailsStorageRoom(String DetailsStorageRoom) {
		this.DetailsStorageRoom.clear();
		this.DetailsStorageRoom.sendKeys(DetailsStorageRoom);
	}
	
	public void clickCentralBangalore() {
		this.CentralBangalore.click(); 
	}
	
	public WebElement getCentralBangalore() {
		return this.CentralBangalore; 
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
	
	
	}

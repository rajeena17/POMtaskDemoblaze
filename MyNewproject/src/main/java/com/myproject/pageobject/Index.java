package com.myproject.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class Index extends BaseClass {
	
	Action action= new Action();


	@FindBy(xpath = "//a[@class='navbar-brand']")
	private WebElement Logo;

	@FindBy(xpath="//a[text()='Laptops']")
	private WebElement lapCategory;
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement logInBtn;
	
	@FindBy(xpath="//input[@id='loginusername']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	private WebElement password;

	@FindBy(xpath="//button[text()='Log in']")
	private WebElement submit;
	
	public Index() {
	PageFactory.initElements(driver, this);
	}

	public boolean validateLogo() throws Throwable {
	return action.isDisplayed(driver,Logo);
	}

	public String getMyStoreTitle() {
	String myStoreTitel=driver.getTitle();
	return myStoreTitel;
	}
	
	public void clickOnLogIn(String uid, String pswd) throws Throwable {
		action.click(driver, logInBtn);		
		action.type(username, uid);
		action.type(password, pswd);
		action.click(driver,submit);
		}
	
	public SearchResult searchProduct() throws Throwable {
		action.scrollByVisibilityOfElement(driver, lapCategory);
		Thread.sleep(2000);
		action.click(driver,lapCategory);
		Thread.sleep(1000);
		return new SearchResult();
	}
}
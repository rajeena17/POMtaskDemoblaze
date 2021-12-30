package com.myproject.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class AddToCart extends BaseClass {
	
	Action action= new Action();

	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCartBtn;

	@FindBy(xpath="//a[text()='Cart']")
	private WebElement cart;

	@FindBy(xpath="//td[text()='Dell i7 8gb']")
	private WebElement productExist;
	
	@FindBy(xpath="//button[text()='Place Order']")
	private WebElement proceedBtn;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement typename;
	
	@FindBy(xpath="//input[@id='country']")
	private WebElement typecountry;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement typecity;
	
	@FindBy(xpath="//input[@id='card']")
	private WebElement typecardno;
	
	@FindBy(xpath="//input[@id='month']")
	private WebElement typemonth;
	
	@FindBy(xpath="//input[@id='year']")
	private WebElement typeyear;
	
	@FindBy(xpath="//button[@onclick='purchaseOrder()']")
	private WebElement purchaseBtn;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement ConfirmationMsg;
	
	public AddToCart() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToCart() throws Throwable {
		action.click(driver, addToCartBtn);
		Thread.sleep(3000);
		String atext = driver.switchTo().alert().getText();
		System.out.println(atext);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.switchTo().parentFrame();
	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(driver, cart, 10);
		action.click(driver, cart);
		Thread.sleep(2000);
		return action.isDisplayed(driver, productExist);		
	}
	
	public void clickOnProceed(String name,String country, String city, String credit, String month, String year)
	{
		action.click(driver, proceedBtn);
		action.fluentWait(driver, typename, 10);
		action.type(typename,name);
		action.type(typecountry,country);
		action.type(typecity,city);
		action.type(typecardno,credit);
		action.type(typemonth,month);
		action.type(typeyear,year);
		action.click(driver, purchaseBtn);
	}	
	
	public boolean validateOrderconfirmation()throws Throwable
	{
		Thread.sleep(2000);
		return action.isDisplayed(driver,ConfirmationMsg );
	}
}
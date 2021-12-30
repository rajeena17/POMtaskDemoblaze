package com.myproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class SearchResult extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//a[text()='Dell i7 8gb']")
	private WebElement product;
	
	public SearchResult() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(driver, product);
	}
	
	public AddToCart clickOnProduct() throws Throwable {
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(driver, product);
		action.click(driver, product);
		return new AddToCart();
	}
	
}
	
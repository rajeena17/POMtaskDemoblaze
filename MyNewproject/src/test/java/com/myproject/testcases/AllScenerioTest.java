package com.myproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myproject.base.BaseClass;
import com.myproject.pageobject.AddToCart;
import com.myproject.pageobject.Index;
import com.myproject.pageobject.SearchResult;

public class AllScenerioTest extends BaseClass {
	
	private Index index;
	private SearchResult searchResultPage;
	private AddToCart addToCartPage;

	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void scenerioTest() throws Throwable {
		index= new Index();
		index.clickOnLogIn(prop.getProperty("uid"), prop.getProperty("pswd"));
		searchResultPage=index.searchProduct();
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.clickOnAddToCart();
		addToCartPage.validateAddtoCart();
		addToCartPage.clickOnProceed(prop.getProperty("name"), prop.getProperty("country"),prop.getProperty("city"), prop.getProperty("credit"),prop.getProperty("month"), prop.getProperty("year"));
		boolean result=addToCartPage.validateOrderconfirmation();
		Assert.assertTrue(result);
		
	}
}
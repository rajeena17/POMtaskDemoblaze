package com.myproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobject.Index;

public class IndexTest extends BaseClass {
	Index indexPage;

	@BeforeMethod
	public void setup() {
		launchApp(); 
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void verifyLogo() throws Throwable {
		indexPage= new Index();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test
	public void verifyTitle() {
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "STORE");	}
}

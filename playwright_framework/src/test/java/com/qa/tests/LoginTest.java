package com.qa.tests;

import com.qa.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{
	
	@Test
	public void loginPageTest() {
		homePage = loginPage.loginToApplication();
		System.out.println("Login successful...");
		homePage.verifyHomePageLoaded();
		
		
	}

}

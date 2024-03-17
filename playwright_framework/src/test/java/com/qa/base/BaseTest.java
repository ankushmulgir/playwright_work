package com.qa.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class BaseTest {
	PlaywrightFactory factoryClass;
	Page page;
	protected Properties prop;
	protected LoginPage loginPage;
	protected HomePage homePage;
	
	
	@BeforeTest
	public void setUp() {
		factoryClass = new PlaywrightFactory();
		prop = factoryClass.init_prop();
		
		page = factoryClass.initBrowser(prop);
		loginPage = new LoginPage(page);
		
	}
	
	/*
	 * @Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		factoryClass = new PlaywrightFactory();
		prop = factoryClass.init_prop();
		
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		
		page = factoryClass.initBrowser(prop);
		loginPage = new LoginPage(page);
		
	}
	 */
	
	public void tearDown() {
		page.context().browser().close();
	}

}

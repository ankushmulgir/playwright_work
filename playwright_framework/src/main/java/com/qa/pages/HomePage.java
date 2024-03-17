package com.qa.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	
	//create a HomePage constructor
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	//page locators
	
	private String dashboardLabel = "//h6[text()='Dashboard']";
	private String loggedInUser = "//p[text()='Bob Tester']";
	
	public boolean verifyHomePageLoaded() {
		page.isVisible(dashboardLabel);
		page.isVisible(loggedInUser);
		
		return page.isVisible(dashboardLabel);
	}
}

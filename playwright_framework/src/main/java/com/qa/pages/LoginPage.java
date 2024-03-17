package com.qa.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	
	//page locators
	
	private String username = "Username";
	private String password = "Password";
	private String loginButton = "//button[@type='submit']";
	
	//create a LoginPage constructor
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public HomePage loginToApplication() {
		try {
			page.fill(username, "Admin");
			page.fill(username, "admin123");
			page.click(loginButton);
			System.out.println(page.title() + page.url());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return new HomePage(page);
		
		
	}
}

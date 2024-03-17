package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import config.config_env;
import setup.setup_browser;

public class login_page {
	
	public static String _username = "//input[@name='username']";
	public static String _password = "//input[@name='password']";
	public static String _login_button = "//button[@type='submit']";
	
	public static void login_to_app() {
		setup_browser obj = new setup_browser();
		Browser bwm = obj.launch_browser("Chrome");
		Page pg = bwm.newPage();
		
		// Navigate to the given url
		pg.navigate(config_env.app_url);
		pg.waitForTimeout(1000);
		pg.locator(_username).fill(config_env.getApp_username());
		pg.locator(_password).fill(config_env.getApp_password());
		pg.locator(_login_button).click();
		
		System.out.println("Login success");
		


	}
	
	public static void logout_app(Browser bwm) {
		setup_browser obj = new setup_browser();
		obj.close_browser(bwm);
		System.out.println("Browser Closed");
	}

}

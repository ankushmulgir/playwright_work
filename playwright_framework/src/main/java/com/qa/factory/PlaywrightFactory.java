package com.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;


public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	//Initialize playwright
	
	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Selected Browser: " + browserName);
		playwright = Playwright.create();
		
		String headlessMode = prop.getProperty("headless");
		Boolean mode = Boolean.valueOf(headlessMode);
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(mode).setSlowMo(2000));
			break;
		
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(mode).setSlowMo(2000));
			break;
		
		
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(mode).setSlowMo(2000));
			break;
			
		case "edge":	
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("msedge");
			lp.setHeadless(mode);
			browser = playwright.chromium().launch(lp);
			break;
		
		case "chrome":	
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(mode).setSlowMo(2000));
			break;
			
		default:
			System.out.println("Please provide the correct Browser name..." + browserName);
			break;
			
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		
		return page;
	}
	
	// initialize properties file
	public Properties init_prop() {
		try {
			FileInputStream ip = new FileInputStream("./playwright_framework/src/test/resource/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}

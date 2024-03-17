package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class session_handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false).setSlowMo(2000));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://practice.expandtesting.com/login");
	      page.locator("#username").fill("pratice");
	      page.locator("#username").fill("SuperSecretPassword");
	      page.locator("//button[@type='submit']").click();
	      
	      //context.storageState(new context.)


	}

}

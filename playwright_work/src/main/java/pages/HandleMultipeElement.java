package pages;


import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMultipeElement {
	
	public static String checkbox = "//input[contains(@name, 'vehicle')]";
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false).setSlowMo(2000));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://ultimateqa.com/simple-html-elements-for-automation/");
	      
	      page.locator("//input[contains(@name, 'vehicle')]").first().click();
	      //page.locator("//input[contains(@name, 'vehicle')]").last().click();
	      page.locator(checkbox).nth(1).click();
	      String s = "/playwright_work/output/screenshots/checkbox.png";
	      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("checkbox.png")));
	      
	      
	      
	      // handling dropdown list
	      Locator ele = page.locator("select option");
	      
	      for (int i=0; i<ele.count(); i++) {
	    	  String str = ele.nth(i).textContent();
	    	  
	    	  if (str.equals("Audi")) {
	    		  page.locator("select").selectOption(str);
	    		  System.out.println(str);
	    	  }
	      }
	      
	      String ss = "/playwright_work/output/screenshots/fullpage.png";
	      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("fullpage.png")).setFullPage(true));
	      // alternative way for loop to get all the elements from drop down
	      
	      /*
	      List<String> all_ele = ele.allTextContents();
	      
	      for (String list: all_ele) {
	    	  System.out.println(list);
	      }
	      
	      */
	      browser.close();
	      playwright.close();

	}
}

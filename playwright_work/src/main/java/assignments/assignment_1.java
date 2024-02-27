package assignments;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import config.config_env;
import setup.setup_browser;

/* Assignment 1 : 
 * Take a sample website of your choice and perform below operations:
1. Launch a website in different browsers (Chromium, firefox, webkit, chrome, msedge) - keep one browser launch code active and others commented while sending assignment
2. Open it in Headless and Non headless mode
3. Assert url and title of the website.
 */

public class assignment_1 {

	public static void main(String[] args) {
		String url = "https://www.google.com/finance/?hl=en";
		boolean[] headless_mode = { false, true };
		
		// create object of setup browser class
		setup_browser obj = new setup_browser();
		
		for (int hm = 0; hm < headless_mode.length; hm++) {
			System.out.println("Running on headless mode = " + headless_mode[hm]);
			config_env.headless_flag = headless_mode[hm];
			
			// Change the browser name in parameter here to launch choice of your browser
			//Browser bwm = obj.launch_browser("Webkit");
			
			//Browser bwm = obj.launch_browser("Chrome"); // Example for chrome browser
			Browser bwm = obj.launch_browser("chromium");
			//Browser bwm = obj.launch_browser("firefox"); 
			//Browser bwm = obj.launch_browser("edge"); 
			
			
			// Verify weather browser launched successfully, if not launched program will terminate here
			if (bwm == null){
				System.out.println("Error while launching the browser.");
				return;
			}
			System.out.println("Launched expected browser");
			
			// Create the object for new page
			Page pg = bwm.newPage();
			
			// Navigate to the given url
			pg.navigate(url);
			pg.waitForTimeout(50000);
			//print the title of web page and url
			System.out.println("Webpage title: " + pg.title());
			System.out.println("Webpage url: " + pg.url());
	
			
			// Assert web page title
			assertThat(pg).hasTitle("Google Finance - Stock Market Prices, Real-time Quotes & Business News");
			
			// Asset web page url
			assertThat(pg).hasURL(url);
	
			//close the browser and page
			pg.close();
			bwm.close();
			System.out.println("Browser Closed...!!!\n----------------------------");
		}
	}

}

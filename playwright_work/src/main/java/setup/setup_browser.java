package setup;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import config.config_env;

/*
 * Ankush Mulgir - Date - 25th Feb, 2024
 * you can add more browsers in if condition
 * Create the object of this class and give a call to launch_browser method
 * and do the further validation on page object created
 */

public class setup_browser {
	public static Browser launch_browser(String browser_name){
		Playwright playwright = Playwright.create();
		System.out.println("\nStarted Setup Browser Method....");
		if (browser_name.toLowerCase().equals("chrome")) {
			System.out.println("\nLaunching Chrome Browser");
			Browser bw = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(config_env.headless_flag));
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("webkit")) {
			System.out.println("\nLaunching Webkit Browser");
			Browser bw = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(config_env.headless_flag));
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("firefox")) {
			System.out.println("\nLaunching Firefox Browser");
			Browser bw = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(config_env.headless_flag));
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("edge")) {
			System.out.println("\nLaunching Edge Browser");
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("msedge");
			lp.setHeadless(config_env.headless_flag);
			Browser bw = playwright.chromium().launch(lp);
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("chromium")) {
			System.out.println("\nLaunching Chromium Browser");
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("chrome");
			lp.setHeadless(config_env.headless_flag);
			Browser bw = playwright.chromium().launch(lp);
			return bw;
		}
		
		else {
			System.out.println("ERROR...! Browser type not defined properly.");
			return null;
		}
				
	}

}

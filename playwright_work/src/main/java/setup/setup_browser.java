package setup;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

/*
 * Ankush Mulgir - Date - 24th Feb, 2024
 * you can add more browsers in if condition
 * Create the object of this class and give a call to launch_browser method
 * 
 */

public class setup_browser {
	public static Browser launch_browser(String browser_name){
		Playwright playwright = Playwright.create();
		System.out.println("\nStarted Setup Browser Method....");
		if (browser_name.toLowerCase().equals("Chrome")) {
			System.out.println("\nLaunching Chrome Browser");
			Browser bw = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("webkit")) {
			System.out.println("\nLaunching Webkit Browser");
			Browser bw = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("firefox")) {
			System.out.println("\nLaunching Firefox Browser");
			Browser bw = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			return bw;
		}
		
		else if (browser_name.toLowerCase().equals("edge")) {
			System.out.println("\nLaunching Edge Browser");
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("msedge");
			lp.setHeadless(false);
			Browser bw = playwright.chromium().launch(lp);
			return bw;
		}
		
		else {
			System.out.println("ERROR...! Browser type not defined properly.");
			return null;
		}
				
	}

}

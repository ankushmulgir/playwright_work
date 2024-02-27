package setup;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/*
 * Ankush Mulgir - Date - 25th Feb, 2024
 * Run this class to Launch the browsers of your choice
 * 
 */
public class launch_browser {
	public static void main(String[] args) {
		//Playwright pw = Playwright.create();
		
		// create object of setup_browser class
		setup_browser obj = new setup_browser();
		
		
		// Change the browser name in parameter here to launch choice of your browser
		Browser bwm = obj.launch_browser("Webkit");
		
		//Browser bwm = browser.launch_browser("Chrome"); // Example for chrome browser
		
		// Verify weather browser launched successfully, if not launched program will terminate here
		if (bwm == null){
			System.out.println("Error while launching the browser.");
			return;
		}
		System.out.println("Launched expected browser");
		
		// Create the object for new page
		Page pg = bwm.newPage();
		
		// Navigate to the given url
		pg.navigate("https://google.com");
		
		//print the title of web page
		System.out.println(pg.title());
		
		// Assert it will take some time to assert 
		assertThat(pg).hasTitle("Google");

		//close the browser and page
		pg.close();
		bwm.close();
		System.out.println("Browser Closed...!!!");
	}


}

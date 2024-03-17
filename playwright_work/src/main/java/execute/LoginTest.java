package execute;

import com.microsoft.playwright.Browser;

import pages.login_page;
import setup.setup_browser;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create object of setup browser class
		login_page login_obj = new login_page();
		login_obj.login_to_app();
		
		
		

	}

}

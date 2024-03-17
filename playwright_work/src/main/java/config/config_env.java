package config;

public class config_env {
	
	public static boolean headless_flag = false;
	public static String app_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	private static String app_username = "Admin";
	private static String app_password = "admin123";
	

	public static boolean isHeadless_flag() {
		return headless_flag;
	}

	public static void setHeadless_flag(boolean headless_flag) {
		config_env.headless_flag = headless_flag;
	}

	public static String getApp_username() {
		return app_username;
	}

	public static void setApp_username(String app_username) {
		config_env.app_username = app_username;
	}

	public static String getApp_password() {
		return app_password;
	}

	public static void setApp_password(String app_password) {
		config_env.app_password = app_password;
	}

		

}

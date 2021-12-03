package BaseClasses;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
	
	private static WebDriver webDriver = null;
	
	
	public WebDriverUtils() throws Exception {
		getDriver();
	}
	
	public static WebDriver getDriver() {
		return webDriver;
	}

}

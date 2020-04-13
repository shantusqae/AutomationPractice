	package appiumtest3;

	import java.net.URL;

	import org.openqa.selenium.By;
	import org.openqa.selenium.remote.DesiredCapabilities;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;

	public class RunonEmulator {
		
		static AppiumDriver<MobileElement> driver;

		public static void main(String[] args) {
			try {
				openCalculator();
			} catch (Exception e) {
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
			public static void openCalculator() throws Exception {
				DesiredCapabilities caps=new DesiredCapabilities();
				caps.setCapability("deviceName", "Android Emulator");
				//caps.setCapability("udid", "42009deff2399333"); //Give Device ID of your mobile phone
				caps.setCapability("platformName", "Android");
				caps.setCapability("platformVersion", "9.0");
				caps.setCapability("appPackage", "com.android.chrome");
				caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
				caps.setCapability("noReset", "true");
				
				
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				
				driver = new AppiumDriver<MobileElement>(url, caps);
			}
		}




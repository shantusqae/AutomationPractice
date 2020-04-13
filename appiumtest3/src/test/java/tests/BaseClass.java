package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup () {
		
		try {
		DesiredCapabilities caps=new DesiredCapabilities();
		
		//caps.setCapability("platformName", "ANDROID");
		//caps.setCapability("deviceName", "My Phone");
		//caps.setCapability("udid", "42009deff2399333"); //Give Device ID of your mobile phone
		//caps.setCapability("platformName", "Android");
		//caps.setCapability("platformVersion", "8.0.0");
		//caps.setCapability("appPackage", "com.tricolorcat.calculator");
		//caps.setCapability("appActivity", "com.tricolorcat.calculator.MainActivity");
		//caps.setCapability("noReset", "true");
				
		//caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		caps.setCapability(MobileCapabilityType.UDID, "42009deff2399333");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		//caps.setCapability(MobileCapabilityType.APP,"");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		//caps.setCapability(MobileCapabilityType.APP, "com.android.chrome");
		//caps.setCapability(MobileCapabilityType.A, "com.google.android.apps.chrome.Main");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, caps);
		
		}catch(Exception exp){
			System.out.println("Cause is: "+exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			
		}		
		
	}
	
	//@Test
	//public void sampleTest() {
	//	System.out.println("Cause is: 123");
	//}
	
	
	@AfterTest
public void teardown () {
		driver.close();
		driver.quit();
		
	}
}

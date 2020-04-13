package appiumtest3;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	
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
			caps.setCapability("deviceName", "My Phone");
			caps.setCapability("udid", "42009deff2399333"); //Give Device ID of your mobile phone
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.0.0");
			caps.setCapability("appPackage", "com.tricolorcat.calculator");
			caps.setCapability("appActivity", "com.tricolorcat.calculator.MainActivity");
			caps.setCapability("noReset", "true");
			
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AppiumDriver<MobileElement>(url, caps);
			System.out.println("WOrking");
			MobileElement seven = driver.findElement(By.id("com.tricolorcat.calculator:id/seven"));
			MobileElement plus = driver.findElement(By.id("com.tricolorcat.calculator:id/plus"));
			MobileElement eight = driver.findElement(By.id("com.tricolorcat.calculator:id/six"));
			MobileElement equal = driver.findElement(By.id("com.tricolorcat.calculator:id/equal"));
			
			seven.click();
			plus.click();
			eight.click();
			equal.click();
			
			MobileElement result = driver.findElement(By.id("com.tricolorcat.calculator:id/display"));
			String res = result.getText();
			System.out.println("\n Result = "+res);
			if(res=="15") {
				System.out.println("Pass ");
			}
			else {
				System.out.println("NotPass ");
			}
			System.out.println("Done");
			
			
			
		}
	}



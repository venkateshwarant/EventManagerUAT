package event_manager_appium.event_manager_appium_uat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginActivity 
{
	public static URL url;
	  public static DesiredCapabilities capabilities;
	  public static AndroidDriver<MobileElement> driver;
	  @BeforeSuite
	  public void setupAppium() throws MalformedURLException {
	    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
	    url = new URL(URL_STRING);
	    capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	    capabilities.setCapability(MobileCapabilityType.APP, "/Users/venkat/app-debug.apk");
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    capabilities.setCapability("appWaitActivity", "lu.uni.project.eventmanager.activity.LoginActivity");
	    capabilities.setCapability("appPackage", "lu.uni.project.eventmanager");
	    capabilities.setCapability("noResetValue","false"); 

	    driver = new AndroidDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.resetApp();
	  }
	  
	  
	  @Test
	  public void loginTest() {
		MobileElement email = driver.findElement(By.id("emailID"));
	    email.sendKeys("ejehh@hdbbd.com");
	    driver.findElement(By.id("password")).sendKeys("qwertyu");
	    driver.findElement(By.id("login_button")).click();
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    Assert.assertNotNull(driver.findElement(By.id("home_btm_ic")));
	  }
}

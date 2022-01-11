package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTest {
	
	
	 private static AndroidDriver<MobileElement> driver;
	 
	 
	 @Test
	 public void deveSomarDoisValoresTest() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("deviceName", "BOOT0002");
		    desiredCapabilities.setCapability("automationName", "uiautomator2");
		    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		    
		    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		    
		    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		    el1.click();
		    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mais");
		    el2.click();
		    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		    el3.click();
		    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
		    el4.click();
		    
		    MobileElement resultado = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
		    
		    System.out.println(resultado.getText());
		    
		    Assert.assertEquals("4", resultado.getText());
		    
		    driver.quit();
	 }


}

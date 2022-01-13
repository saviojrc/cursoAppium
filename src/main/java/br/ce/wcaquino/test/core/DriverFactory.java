package br.ce.wcaquino.test.core;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.ce.wcaquino.test.util.Utilitarios;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	private static URL remoteUrl;
	private static DesiredCapabilities desiredCapabilities;
	
	
	
	public static AndroidDriver<MobileElement> getDriver(){
		if(!Utilitarios.VerificaObjetoValido(driver)) {
			createDriver();
		}
		
		return driver;
	}
	
	
	private static void createDriver() {
		try {
			
			remoteUrl = Config.getUrl();
			desiredCapabilities=Config.getDesiredCapabilities();
			driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	
	public static void killDriver() {
		if(Utilitarios.VerificaObjetoValido(driver)) {
			driver.quit();
			driver=null;
		}
	}

}

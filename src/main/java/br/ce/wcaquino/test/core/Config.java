package br.ce.wcaquino.test.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.ce.wcaquino.test.util.Utilitarios;
import io.appium.java_client.remote.MobileCapabilityType;

public class Config {

	private static String platformName;
	private static String deviceName;
	private static String automationName;
	private static String pathApp;
	private static String uri;
	private static URL remoteUrl;
	private static DesiredCapabilities desiredCapabilities;

	public static DesiredCapabilities getDesiredCapabilities() {
		try {
			pathApp = Utilitarios.obterPropriedade("config.path.app");
			platformName = Utilitarios.obterPropriedade("confing.platform.name");
			deviceName = Utilitarios.obterPropriedade("config.device.name");
			automationName = Utilitarios.obterPropriedade("config.automation.name");

			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("automationName", automationName);
			desiredCapabilities.setCapability(MobileCapabilityType.APP, pathApp);

			return desiredCapabilities;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static URL getUrl() {
		try {
			uri = Utilitarios.obterPropriedade("config.url.app");
			remoteUrl = new URL(uri);

			return remoteUrl;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}

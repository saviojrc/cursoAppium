package br.ce.wcaquino.test.core;

import static br.ce.wcaquino.test.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.test.util.Utilitarios;
import io.appium.java_client.MobileElement;

public class DSL {

	public static void escrever(By by, String texto) {
		MobileElement objMobile = getMobileElement(by);
		objMobile.sendKeys(texto);
	}

	public static void clicar(By by) {
		MobileElement objMobile = getMobileElement(by);
		objMobile.click();
	}

	private static MobileElement getMobileElement(By by) {
		return getDriver().findElement(by);
	}

	public static String getText(By by) {
		String texto = getMobileElement(by).getText();
		return Utilitarios.VerificaObjetoValido(texto) ? texto : "";
	}

	public static String getAttribute(By by, String propriedade) {
		return getMobileElement(by).getAttribute(propriedade);
	}
	
	public static Boolean isEnable(By by) {
		return getMobileElement(by).isEnabled();
	}

}

package br.ce.wcaquino.test.core;

import static br.ce.wcaquino.test.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import br.ce.wcaquino.test.util.Utilitarios;
import io.appium.java_client.MobileElement;

public class BasePage {

	public void escrever(By by, String texto) {
		MobileElement objMobile = getMobileElement(by);
		objMobile.sendKeys(texto);
	}

	public  void clicar(By by) {
		MobileElement objMobile = getMobileElement(by);
		objMobile.click();
	}

	private  MobileElement getMobileElement(By by) {
		return getDriver().findElement(by);
	}
	
	
	
	
	public List<MobileElement> obterListaDeElementos(By by ){
		List<MobileElement> objMobileList = DriverFactory.getDriver().findElements(by);
		
		return objMobileList;
	}

	public  void clicarPorTexto(String texto) {
		By by = By.xpath("//*[@text='" + texto + "']");
		MobileElement objMobile = getMobileElement(by);
		objMobile.click();
	}

	public  void selecionarCombo(By by, String valor) {
		clicar(by);
		clicarPorTexto(valor);
	}

	public  String obterTexto(By by) {
		String texto = getMobileElement(by).getText();
		return Utilitarios.VerificaObjetoValido(texto) ? texto : "";
	}

	public  Boolean oCheckEstaMarcado(By by) {
		return obterAtributo(by, "checked").equalsIgnoreCase("true".trim());
	}

	public  String obterAtributo(By by, String propriedade) {
		return getMobileElement(by).getAttribute(propriedade);
	}

	public  Boolean isEnable(By by) {
		return getMobileElement(by).isEnabled();
	}
	
	

}

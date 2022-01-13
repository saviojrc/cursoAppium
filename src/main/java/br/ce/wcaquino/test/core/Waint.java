package br.ce.wcaquino.test.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.test.util.Utilitarios;

public class Waint {
	
	private Integer timeOut = Integer.valueOf(Utilitarios.obterPropriedade("config.timeOut"));
	
	
	
	public void waintPresenceOfElementLocated(By by) {
		try {

			
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	public void implicitWaint(int timeOut) {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	
	public void  waintElementToBeClickable(By by) {
		try {

			
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(by));

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}

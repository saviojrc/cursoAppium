package br.ce.wcaquino.test.core;

import java.util.concurrent.TimeUnit;

import br.ce.wcaquino.test.util.Utilitarios;

public class Waint {

	private static Integer timeOut;


	public static Integer getTimeOut() {
		timeOut = Integer.valueOf(Utilitarios.obterPropriedade("config.timeOut"));
		return timeOut;
	}

	public static void implicitWaint() {

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(getTimeOut(), TimeUnit.SECONDS);
	}

}

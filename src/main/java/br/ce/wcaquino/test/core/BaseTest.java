package br.ce.wcaquino.test.core;

import org.junit.After;

public class BaseTest {
	
	@After
	public void tearDowm() {
		Waint.implicitWaint();
		DriverFactory.getDriver().resetApp();
	}

}

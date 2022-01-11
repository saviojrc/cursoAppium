package br.ce.wcaquino.test.core;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.wcaquino.test.util.Utilitarios;

public class BaseTest {
	
	
	@Rule
	public TestName testName = new TestName(); ;
	
	
	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDowm() {
		Waint.implicitWaint();
		gerarCapturaDeTela();
		DriverFactory.getDriver().resetApp();
	}
	
	
	public void gerarCapturaDeTela() {
		try {
			
			String caminhoDoArquivo = "target/screenshot/"+Utilitarios.obterDataEHoraAtual()+"_"+testName.getMethodName()+".png";
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File(caminhoDoArquivo));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}

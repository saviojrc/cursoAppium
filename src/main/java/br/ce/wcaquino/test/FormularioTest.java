package br.ce.wcaquino.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {

	private static AndroidDriver<MobileElement> driver;

	@Before

	public void setUp() throws MalformedURLException {
		String pathApp = "C:\\DEV\\JAVA\\REPO\\Appium\\src\\main\\resources\\CTAppium_1_2.apk";

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "BOOT0001");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, pathApp);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		implicitWaint(driver);
	}

	@Test
	public void devePreencherCampoTexto() {

		

		// Selecionar Formulário
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

		MobileElement formulario = elementosEncontrados.get(1);
		formulario.click();

		// escrever o nome

		MobileElement campoNome = driver.findElementByAccessibilityId("nome");
		campoNome.click();
		campoNome.sendKeys("Sávio");

		// Checando nome

		String objValorAtual = campoNome.getText().trim();
		String objValorEsperado = "Sávio";

		Assert.assertEquals(objValorAtual, objValorEsperado);


	}

	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {

		// Selecionar Formulário
		

		MobileElement objMenuFormulario = driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));

		objMenuFormulario.click();

		// Clicar no combo
		implicitWaint(driver);
		MobileElement objComboFormulario = driver.findElement(MobileBy.AccessibilityId("console"));

		objComboFormulario.click();

		// Selecionar a opção desejada

		implicitWaint(driver);
		MobileElement objOpcaoComboFormulario = driver
				.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']"));

		objOpcaoComboFormulario.click();

		// Verificar opção selecionada
		implicitWaint(driver);

		MobileElement objOpcaoSelecionadaCombo = driver
				.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"));

		String objValorAtual = objOpcaoSelecionadaCombo.getText().trim();

		String objValorEsperado = "Nintendo Switch";

		Assert.assertEquals(objValorAtual, objValorEsperado);




	}

	private void implicitWaint(AndroidDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void deveInteragirComSwitchECheckBox() throws MalformedURLException {

		

		MobileElement objMenuFormulario = driver.findElement(By.xpath("//*[@text='Formulário']"));

		objMenuFormulario.click();

		// Verificar Status dos Elementos

		MobileElement objCheck = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement objSwitch = driver.findElement(MobileBy.AccessibilityId("switch"));

		Boolean objCheckMarcado = objCheck.getAttribute("checked").equalsIgnoreCase("false".trim());
		Boolean objSwitchMarcado = objSwitch.getAttribute("checked").equalsIgnoreCase("true".trim());

		assertTrue(objCheckMarcado);
		assertTrue(objSwitchMarcado);

		implicitWaint(driver);

		objCheck.click();
		objSwitch.click();

		Boolean objCheckDesmarcado = objCheck.getAttribute("checked").equalsIgnoreCase("false".trim());
		Boolean objSwitchDesmarcado = objSwitch.getAttribute("checked").equalsIgnoreCase("true".trim());

		assertFalse(objCheckDesmarcado);
		assertFalse(objSwitchDesmarcado);

		assertTrue(objCheckMarcado);

		

	}

	@Test
	public void devoValidarDadosDoFormulario() throws MalformedURLException {

		String nome = "Sávio Rodrigues";
		String console = "PS4";

		

		// Acessar o Formulário
		MobileElement objFormulario = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
		objFormulario.click();

		implicitWaint(driver);
		MobileElement objCampoNome = driver.findElementByAccessibilityId("nome");
		objCampoNome.sendKeys(nome);
		

		implicitWaint(driver);
		MobileElement objCheck = driver.findElement(MobileBy.AccessibilityId("check"));
		objCheck.click();

		// Selecione o elemento 'PS4'

		implicitWaint(driver);
		MobileElement objConsole = driver.findElement(MobileBy.AccessibilityId("console"));
		objConsole.click();
		MobileElement objConsoleSelecionado = driver.findElement(MobileBy
				.xpath("//android.widget.ListView/android.widget.CheckedTextView[@text=" + "'" + console + "'" + "]"));
		objConsoleSelecionado.click();

		// Selecionar a opção 'Salvar'
		implicitWaint(driver);
		MobileElement objBotaoSalvar =driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='SALVAR']"));
		objBotaoSalvar.click();

		// Checar estado dos campos e botões
		implicitWaint(driver);
		Boolean objNomeHabilitado = driver.findElement(MobileBy.AccessibilityId("nome")).isEnabled();
		Boolean objConsoleHabilitado = driver.findElement(MobileBy.AccessibilityId("console")).isEnabled();
		Boolean objCheckHabilitado = driver.findElement(MobileBy.AccessibilityId("check")).isEnabled();
		Boolean objSwichHabilitado = driver.findElement(MobileBy.AccessibilityId("switch")).isEnabled();
		Boolean objSalvarHabilitado = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='SALVAR']"))
				.isEnabled();

		Assert.assertFalse(objNomeHabilitado);
		Assert.assertFalse(objConsoleHabilitado);
		Assert.assertFalse(objCheckHabilitado);
		Assert.assertFalse(objSwichHabilitado);
		Assert.assertFalse(objSalvarHabilitado);
		
		
		
		
		String objStrNomeEsperado = "Nome: Sávio Rodrigues";
		String objStrConsoleEsperado = "Console: ps4";
		String objStrSliderEsperado = "Slider: 25";
		String objStrSwitchEsperado="Switch: On";
		String objStrCheckMarcadoEsperado = "Checkbox: Marcado";
		
		String objStrNomeAtual = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Nome: Sávio Rodrigues']")).getText().trim();
		String objStrConsoleAtual = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Console: ps4']")).getText().trim();
		String objStrSliderAtual = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Slider: 25']")).getText().trim();
		String objStrSwitchAtual=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Switch: On']")).getText().trim();
		String objStrCheckMarcadoAtual =driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText().trim();
		
		
		Assert.assertEquals(objStrNomeEsperado, objStrNomeAtual);
		Assert.assertEquals(objStrConsoleEsperado, objStrConsoleAtual);
		Assert.assertEquals(objStrSliderEsperado, objStrSliderAtual);
		Assert.assertEquals(objStrSwitchEsperado, objStrSwitchAtual);
		Assert.assertEquals(objStrCheckMarcadoEsperado, objStrCheckMarcadoAtual);

	}
	
	
	@After
	public void tearDowm() {
		implicitWaint(driver);
		driver.quit();
	}

}

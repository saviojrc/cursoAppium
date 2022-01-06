package br.ce.wcaquino.test;

import static br.ce.wcaquino.test.core.DSL.clicar;
import static br.ce.wcaquino.test.core.DSL.getText;
import static br.ce.wcaquino.test.core.DSL.isEnable;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.test.core.DSL;
import br.ce.wcaquino.test.core.DriverFactory;
import br.ce.wcaquino.test.core.Waint;
import io.appium.java_client.MobileBy;

public class FormularioTest {

	@Before
	public void setUp() throws MalformedURLException {

		Waint.implicitWaint();

		// Selecionar Formulário
		By objMobileFormulario = By.xpath("//android.widget.TextView[@text='Formulário']");
		DSL.clicar(objMobileFormulario);
	}

	@Test
	public void devePreencherCampoTexto() {

		// escrever o nome
		Waint.implicitWaint();
		String objStrNome = "Sávio Rodrigues";

		By nome = MobileBy.AccessibilityId("nome");
		DSL.escrever(nome, objStrNome);

		// Checando nome

		String objValorAtual = getText(nome);
		

		Assert.assertEquals(objValorAtual, objStrNome);

	}

	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {

		// Clicar no combo
		Waint.implicitWaint();

		By objMobileCampoConsole = MobileBy.AccessibilityId("console");

		clicar(objMobileCampoConsole);

		// Selecionar a opção desejada

		Waint.implicitWaint();

		By objOpcaoComboFormulario = By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']");

		clicar(objOpcaoComboFormulario);

		// Verificar opção selecionada
		Waint.implicitWaint();

		By objOpcaoSelecionadaCombo = By.xpath("//android.widget.Spinner/android.widget.TextView");

		String objValorAtual = DSL.getText(objOpcaoSelecionadaCombo);

		String objValorEsperado = "Nintendo Switch";

		Assert.assertEquals(objValorAtual, objValorEsperado);

	}

	@Test
	public void deveInteragirComSwitchECheckBox() throws MalformedURLException {

		// Verificar Status dos Elementos

		By objCheck = By.className("android.widget.CheckBox");
		By objSwitch = MobileBy.AccessibilityId("switch");

		Boolean objCheckMarcado = DSL.getAttribute(objCheck, "checked").equalsIgnoreCase("false".trim());
		Boolean objSwitchMarcado = DSL.getAttribute(objSwitch, "checked").equalsIgnoreCase("true".trim());

		assertTrue(objCheckMarcado);
		assertTrue(objSwitchMarcado);

		Waint.implicitWaint();

		clicar(objCheck);
		clicar(objSwitch);

		Boolean objCheckDesmarcado = DSL.getAttribute(objCheck, "checked").equalsIgnoreCase("false".trim());
		Boolean objSwitchDesmarcado = DSL.getAttribute(objSwitch, "checked").equalsIgnoreCase("true".trim());

		assertFalse(objCheckDesmarcado);
		assertFalse(objSwitchDesmarcado);

		assertTrue(objCheckMarcado);

	}

	@Test
	public void devoValidarDadosDoFormulario() throws MalformedURLException {

		String nome = "Sávio Rodrigues";
		String console = "PS4";

		Waint.implicitWaint();
		By objCampoNome = MobileBy.AccessibilityId("nome");
		DSL.escrever(objCampoNome, nome);

		// Clicar nas opções

		Waint.implicitWaint();
		By objCheck = MobileBy.AccessibilityId("check");
		DSL.clicar(objCheck);

		// Selecione o elemento 'PS4'

		Waint.implicitWaint();
		By objFormularioConsole = MobileBy.AccessibilityId("console");
		DSL.clicar(objFormularioConsole);
		By objOpcaoSelecionadaConsole = MobileBy
				.xpath("//android.widget.ListView/android.widget.CheckedTextView[@text=" + "'" + console + "'" + "]");
		DSL.clicar(objOpcaoSelecionadaConsole);

		// Selecionar a opção 'Salvar'
		Waint.implicitWaint();
		By objBotaoSalvar = MobileBy.xpath("//android.widget.TextView[@text='SALVAR']");
		DSL.clicar(objBotaoSalvar);

		// Checar estado dos campos e botões
		Waint.implicitWaint();

		By objNomeSalvo = MobileBy.AccessibilityId("nome");
		By objConsoleSalvo = MobileBy.AccessibilityId("console");
		By objCheckSalvo = MobileBy.AccessibilityId("check");
		By objSwichdSalvo = MobileBy.AccessibilityId("switch");
		By objBotaoSalvarAposGravacao = MobileBy.xpath("//android.widget.TextView[@text='SALVAR']");

		Boolean objNomeHabilitado = isEnable(objNomeSalvo);
		Boolean objConsoleHabilitado = isEnable(objConsoleSalvo);
		Boolean objCheckHabilitado = isEnable(objCheckSalvo);
		Boolean objSwichHabilitado = isEnable(objSwichdSalvo);
		Boolean objSalvarHabilitado = isEnable(objBotaoSalvarAposGravacao);

		Assert.assertFalse(objNomeHabilitado);
		Assert.assertFalse(objConsoleHabilitado);
		Assert.assertFalse(objCheckHabilitado);
		Assert.assertFalse(objSwichHabilitado);
		Assert.assertFalse(objSalvarHabilitado);

		
		//Obtendo os valores salvos no formulário
		String objStrNomeEsperado = "Nome: Sávio Rodrigues";
		String objStrConsoleEsperado = "Console: ps4";
		String objStrSliderEsperado = "Slider: 25";
		String objStrSwitchEsperado = "Switch: On";
		String objStrCheckMarcadoEsperado = "Checkbox: Marcado";

		By objNomeSalvoNoFormulario = MobileBy.xpath("//android.widget.TextView[@text='Nome: Sávio Rodrigues']");
		By objAtributoConsoleSalvoNoFormulario = MobileBy.xpath("//android.widget.TextView[@text='Console: ps4']");
		By objAtributoSliderSalvoNoFormulario = MobileBy.xpath("//android.widget.TextView[@text='Slider: 25']");
		By objSwitchSalvoNoFormulario = MobileBy.xpath("//android.widget.TextView[@text='Switch: On']");
		By objCheckSalvoNoFormulario = MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']");

		String objStrNomeAtual = getText(objNomeSalvoNoFormulario);
		String objStrConsoleAtual = getText(objAtributoConsoleSalvoNoFormulario);
		String objStrSliderAtual = getText(objAtributoSliderSalvoNoFormulario);
		String objStrSwitchAtual = getText(objSwitchSalvoNoFormulario);
		String objStrCheckMarcadoAtual = getText(objCheckSalvoNoFormulario);

		
		
		Assert.assertEquals(objStrNomeEsperado, objStrNomeAtual);
		Assert.assertEquals(objStrConsoleEsperado, objStrConsoleAtual);
		Assert.assertEquals(objStrSliderEsperado, objStrSliderAtual);
		Assert.assertEquals(objStrSwitchEsperado, objStrSwitchAtual);
		Assert.assertEquals(objStrCheckMarcadoEsperado, objStrCheckMarcadoAtual);

	}

	@After
	public void tearDowm() {
		Waint.implicitWaint();
		DriverFactory.killDriver();
	}

}

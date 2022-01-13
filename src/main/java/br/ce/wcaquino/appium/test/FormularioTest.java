package br.ce.wcaquino.appium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.enums.FormularioEnum;
import br.ce.wcaquino.appium.page.enums.OpcoesMenuEnum;
import br.ce.wcaquino.test.core.BaseTest;
import br.ce.wcaquino.test.util.Utilitarios;

public class FormularioTest extends BaseTest {

	
	private MenuPage paginaDeMenu = new MenuPage();
	private FormularioPage paginaDeFormulario = new FormularioPage();
	private int timeOut = Integer.valueOf(Utilitarios.obterPropriedade("config.timeOut"));

	@Before
	public void setUp() throws MalformedURLException {

		implicitWaint(timeOut);
		paginaDeMenu.selecionarOpcaoMenu(OpcoesMenuEnum.FORMULARIO);

	}

	@Test
	public void devePreencherCampoTexto() {

		// escrever o nome
		By objTextoBy= FormularioEnum.NOME.obterBy();
		waintPresenceOfElementLocated(objTextoBy);
		String objStrNome = "Sávio Rodrigues";
		paginaDeFormulario.escreverNoFormulario(FormularioEnum.NOME, objStrNome);

		// Checando nome

		String objValorAtual = paginaDeFormulario.obterTextoDoFormulario(FormularioEnum.NOME);

		Assert.assertEquals(objValorAtual, objStrNome);

	}

	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {

		// Clicar no combo
		implicitWaint(timeOut);

		String objStrValorCombo = "Nintendo Switch";

		paginaDeFormulario.selecionarCombo(objStrValorCombo);
		// Verificar opção selecionada
		implicitWaint(timeOut);

		String objValorAtual = paginaDeFormulario.obterTextoDoFormulario(FormularioEnum.TEXTO_SELECIONADO_SPINNER);

		Assert.assertEquals(objValorAtual, objStrValorCombo);

	}

	@Test
	public void deveInteragirComSwitchECheckBox() throws MalformedURLException {

		// Verificar Status dos Elementos

		

		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.CHEKBOX);

		Boolean objCheckMarcado = paginaDeFormulario.aOpcaoEstaMarcada(FormularioEnum.CHEKBOX);
		Boolean objSwitchMarcado =  paginaDeFormulario.aOpcaoEstaMarcada(FormularioEnum.SWITCH);

		assertTrue(objCheckMarcado);
		assertTrue(objSwitchMarcado);

		implicitWaint(timeOut);

		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.CHEKBOX);
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.SWITCH);
		

		Boolean objCheckDesmarcado = paginaDeFormulario.aOpcaoEstaMarcada(FormularioEnum.CHEKBOX);
		Boolean objSwitchDesmarcado = paginaDeFormulario.aOpcaoEstaMarcada(FormularioEnum.SWITCH);

		assertFalse(objCheckDesmarcado);
		assertFalse(objSwitchDesmarcado);

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		String nome = "Sávio Rodrigues";
		String opcaoDeVideoGame = "PS4";

		implicitWaint(timeOut);
		paginaDeFormulario.escreverNoFormulario(FormularioEnum.NOME, nome);
		
		// Selecione o elemento 'PS4'

		implicitWaint(timeOut);
		paginaDeFormulario.selecionarCombo(opcaoDeVideoGame);

		// Clicar nas opções

		implicitWaint(timeOut);
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.CHEKBOX);

		

		// Selecionar a opção 'Salvar'
		implicitWaint(timeOut);
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.SALVAR);

		// Checar estado dos campos e botões
		implicitWaint(timeOut);

		

		Boolean objNomeHabilitado = paginaDeFormulario.aOpcaoEstaHabilitada(FormularioEnum.NOME);
		Boolean objConsoleHabilitado = paginaDeFormulario.aOpcaoEstaHabilitada(FormularioEnum.SPINNER);
		Boolean objCheckHabilitado =  paginaDeFormulario.aOpcaoEstaHabilitada(FormularioEnum.CHEKBOX);
		Boolean objSwichHabilitado = paginaDeFormulario.aOpcaoEstaHabilitada(FormularioEnum.SWITCH);
		Boolean objSalvarHabilitado = paginaDeFormulario.aOpcaoEstaHabilitada(FormularioEnum.SALVAR);

		Assert.assertFalse(objNomeHabilitado);
		Assert.assertFalse(objConsoleHabilitado);
		Assert.assertFalse(objCheckHabilitado);
		Assert.assertFalse(objSwichHabilitado);
		Assert.assertFalse(objSalvarHabilitado);

		// Obtendo os valores salvos no formulário
		String objStrNomeEsperado = "Nome: Sávio Rodrigues";
		String objStrConsoleEsperado = "Console: ps4";
		String objStrSliderEsperado = "Slider: 25";
		String objStrSwitchEsperado = "Switch: On";
		String objStrCheckMarcadoEsperado = "Checkbox: Marcado";
		implicitWaint(timeOut);
		paginaDeFormulario.checarResultadoFormulario(objStrNomeEsperado, objStrConsoleEsperado, objStrSliderEsperado, objStrSwitchEsperado, objStrCheckMarcadoEsperado);

	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {

		String nome = "Sávio Rodrigues";
		String opcaoDeVideoGame = "PS4";

		implicitWaint(timeOut);
		paginaDeFormulario.escreverNoFormulario(FormularioEnum.NOME, nome);
		
		// Selecione o elemento 'PS4'

		implicitWaint(timeOut);
		paginaDeFormulario.selecionarCombo(opcaoDeVideoGame);

		// Clicar nas opções

		implicitWaint(timeOut);
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.CHEKBOX);

		

		// Selecionar a opção 'Salvar Demorado'
		implicitWaint(timeOut);
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.SALVAR_DEMORADO);

		// Checar estado dos campos e botões
		implicitWaint(timeOut);

		
		// Obtendo os valores salvos no formulário
		String objStrNomeEsperado = "Nome: Sávio Rodrigues";
		String objStrConsoleEsperado = "Console: ps4";
		String objStrSliderEsperado = "Slider: 25";
		String objStrSwitchEsperado = "Switch: On";
		String objStrCheckMarcadoEsperado = "Checkbox: Marcado";
		implicitWaint(timeOut);
		paginaDeFormulario.checarResultadoFormulario(objStrNomeEsperado, objStrConsoleEsperado, objStrSliderEsperado, objStrSwitchEsperado, objStrCheckMarcadoEsperado);

	}

	

}

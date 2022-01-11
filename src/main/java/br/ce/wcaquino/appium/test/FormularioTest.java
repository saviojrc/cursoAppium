package br.ce.wcaquino.appium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.enums.FormularioEnum;
import br.ce.wcaquino.appium.page.enums.OpcoesMenuEnum;
import br.ce.wcaquino.test.core.BaseTest;
import br.ce.wcaquino.test.core.Waint;

public class FormularioTest extends BaseTest {

	
	MenuPage paginaDeMenu = new MenuPage();
	private FormularioPage paginaDeFormulario = new FormularioPage();

	@Before
	public void setUp() throws MalformedURLException {

		Waint.implicitWaint();
		paginaDeMenu.selecionarOpcaoMenu(OpcoesMenuEnum.FORMULARIO);

	}

	@Test
	public void devePreencherCampoTexto() {

		// escrever o nome
		Waint.implicitWaint();
		String objStrNome = "Sávio Rodrigues";
		paginaDeFormulario.escreverNoFormulario(FormularioEnum.NOME, objStrNome);

		// Checando nome

		String objValorAtual = paginaDeFormulario.obterTextoDoFormulario(FormularioEnum.NOME);

		Assert.assertEquals(objValorAtual, objStrNome);

	}

	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {

		// Clicar no combo
		Waint.implicitWaint();

		String objStrValorCombo = "Nintendo Switch";

		paginaDeFormulario.selecionarCombo(objStrValorCombo);
		// Verificar opção selecionada
		Waint.implicitWaint();

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

		Waint.implicitWaint();

		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.CHEKBOX);
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.SWITCH);
		

		Boolean objCheckDesmarcado = paginaDeFormulario.aOpcaoEstaMarcada(FormularioEnum.CHEKBOX);
		Boolean objSwitchDesmarcado = paginaDeFormulario.aOpcaoEstaMarcada(FormularioEnum.SWITCH);

		assertFalse(objCheckDesmarcado);
		assertFalse(objSwitchDesmarcado);

	}

	@Test
	public void devoValidarDadosDoFormulario() throws MalformedURLException {

		String nome = "Sávio Rodrigues";
		String opcaoDeVideoGame = "PS4";

		Waint.implicitWaint();
		paginaDeFormulario.escreverNoFormulario(FormularioEnum.NOME, nome);
		
		// Selecione o elemento 'PS4'

		Waint.implicitWaint();
		paginaDeFormulario.selecionarCombo(opcaoDeVideoGame);

		// Clicar nas opções

		Waint.implicitWaint();
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.CHEKBOX);

		

		// Selecionar a opção 'Salvar'
		Waint.implicitWaint();
		paginaDeFormulario.clicarOpcaoNoFormulario(FormularioEnum.SALVAR);

		// Checar estado dos campos e botões
		Waint.implicitWaint();

		

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
		Waint.implicitWaint();
		paginaDeFormulario.checarResultadoFormulario(objStrNomeEsperado, objStrConsoleEsperado, objStrSliderEsperado, objStrSwitchEsperado, objStrCheckMarcadoEsperado);

	}

	

}

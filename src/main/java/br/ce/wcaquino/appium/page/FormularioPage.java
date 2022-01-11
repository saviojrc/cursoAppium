package br.ce.wcaquino.appium.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.page.enums.FormularioEnum;
import br.ce.wcaquino.test.core.BasePage;
import br.ce.wcaquino.test.util.Utilitarios;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {

	

	public void escreverNoFormulario(FormularioEnum campo, String nome) {
		By objFormulario = obterElementoDoFormulario(campo);
		escrever(objFormulario, nome);
	}

	public String obterTextoDoFormulario(FormularioEnum campo) {
		By objFormulario = obterElementoDoFormulario(campo);

		String objStrText = obterTexto(objFormulario);

		return Utilitarios.VerificaObjetoValido(objStrText) ? objStrText : "";

	}

	public void selecionarCombo(String valorCombo) {
		By objFormulario = obterElementoDoFormulario(FormularioEnum.SPINNER);
		selecionarCombo(objFormulario, valorCombo);
	}

	public void clicarOpcaoNoFormulario(FormularioEnum campo) {
		By objFormulario = obterElementoDoFormulario(campo);
		clicar(objFormulario);
	}

	public void checarResultadoFormulario(String nome, String textoConsole, String textoSlider, String textoSwitch,
			String textoCheck) {
		try {
			
			By objBy =By.className("android.widget.TextView");
			List<MobileElement> objFormularioSalvo = obterListaDeElementos(objBy);

			for (int i = 0; i < objFormularioSalvo.size(); i++) {

				
				MobileElement objMobile = objFormularioSalvo.get(i);
				String texto = objMobile.getText();
				
				if(i==7) {
					exibirResultadosNoConsole(texto.trim(), nome.trim());
					Assert.assertEquals(texto.trim(), nome.trim());
					
				}else if(i==8) {
					exibirResultadosNoConsole(texto.trim(), textoConsole.trim());
					Assert.assertEquals(texto.trim(), textoConsole.trim());
				}else if(i==9) {
					exibirResultadosNoConsole(texto.trim(), textoSlider.trim());
					Assert.assertEquals(texto.trim(), textoSlider.trim());
				}else if(i==10) {
					exibirResultadosNoConsole(texto.trim(), textoSwitch.trim());
					Assert.assertEquals(texto.trim(), textoSwitch.trim());
				}else if(i==11) {
					exibirResultadosNoConsole(texto.trim(), textoCheck.trim());
					Assert.assertEquals(texto.trim(), textoCheck.trim());
				}
				

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	public void exibirResultadosNoConsole(String textoAtual, String textoEsperado) {
		System.out.println("Texto atual - > "+ " : "+ textoAtual +"  "+ "Texto esperado - > "+ " : "+ textoEsperado );
	}

	public Boolean aOpcaoEstaMarcada(FormularioEnum campo) {
		By objFormulario = obterElementoDoFormulario(campo);
		return oCheckEstaMarcado(objFormulario);
	}

	public Boolean aOpcaoEstaHabilitada(FormularioEnum campo) {
		By objFormulario = obterElementoDoFormulario(campo);
		return isEnable(objFormulario);
	}

	public By obterElementoDoFormulario(FormularioEnum opcao) {
		return opcao.obterBy();
	}

}

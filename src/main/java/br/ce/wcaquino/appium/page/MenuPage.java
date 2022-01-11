package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.page.enums.OpcoesMenuEnum;
import br.ce.wcaquino.test.core.BasePage;

public class MenuPage extends BasePage {

	public void selecionarOpcaoMenu(OpcoesMenuEnum opcao) {
		String objStrOpc = opcao.getDescricao();
		clicarPorTexto(objStrOpc);
	}

}

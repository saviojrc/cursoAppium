package br.ce.wcaquino.test.util;

import br.ce.wcaquino.test.core.BaseTest;

public class Teste {

	public static void main(String[] args) {
		System.out.println(Utilitarios.obterDataEHoraAtual());
		
		BaseTest baseTest = new BaseTest();
		baseTest.gerarCapturaDeTela();

	}

}

package br.ce.wcaquino.appium.page.enums;

public enum OpcoesMenuEnum {
	
	ABOUT("About..."),
	FORMULARIO("Formulário"),
	SEU_BARRIGA_NATIVO("SeuBarriga Nativo"),
	SEU_BARRIGA_HIBRIDO("SeuBarriga Híbrido"),
	ALERTAS("Alertas"),
	SPLASH("Splash"),
	ABAS("Abas"),
	ACCORDION("Accordion"),
	CLIQUES("Cliques"),
	SWIPE("Swipe"),
	SWIPE_LIST("Swipe List"),
	DRAG_AND_DROP("Drag and drop"),
	OPCAO_BEM_ESCONDIDA("Opção bem escondida");
	
	
	private String descricao;
	
	OpcoesMenuEnum(String descricao) {
		this.descricao=descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	
	
}

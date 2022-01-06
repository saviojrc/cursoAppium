package br.ce.wcaquino.test.util;

public class Utilitarios {
	
	public static Boolean VerificaObjetoValido(Object obj) {
		return obj != null;
	}

	public static Boolean VerificaObjetoValido(String obj) {
		return obj != null && obj.length() > 0;
	}
	
	
	public static String obterPropriedade(String propriedade) {
		try {
			if(VerificaObjetoValido(propriedade)) {
				return PropriedadesDoSistema.getProp().getProperty(propriedade);
			}else {
				throw new IllegalArgumentException("Propriedade Inválida");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}

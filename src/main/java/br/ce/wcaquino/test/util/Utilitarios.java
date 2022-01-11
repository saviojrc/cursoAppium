package br.ce.wcaquino.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	
	public static String obterDataEHoraAtual() {
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("ddMMyyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HHmmss").format(dataHoraAtual);
			
			return data+"_"+hora;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}

package br.ce.wcaquino.appium.page.enums;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public enum FormularioEnum {

	NOME {
		@Override
		public By obterBy() {
			By objStrNome = MobileBy.AccessibilityId("nome");
			return objStrNome;
		}
	},

	SPINNER() {
		@Override
		public By obterBy() {
			return  MobileBy.AccessibilityId("console");
		}
	},
	TEXTO_SELECIONADO_SPINNER(){
		@Override
		public By obterBy() {
			return By.xpath("//android.widget.Spinner/android.widget.TextView");
		}
	},
	
	SEEKBAR() {
		@Override
		public By obterBy() {
			return MobileBy.AccessibilityId("slid");
		}
	},
	CHEKBOX() {
		@Override
		public By obterBy() {
			
			return MobileBy.AccessibilityId("check");
		}
	},
	SWITCH() {
		@Override
		public By obterBy() {
			return MobileBy.AccessibilityId("switch");
		}

	},
	SALVAR() {
		
		@Override
		public By obterBy() {
			return MobileBy.xpath("//android.widget.TextView[@text='SALVAR']");
		}

	},
	SALVAR_DEMORADO(){
		@Override
		public By obterBy() {
			return MobileBy.xpath("//android.widget.TextView[@text='SALVAR DEMORADO']");
		}
	};

	public By obterBy() {
		return null;
	}
	
	

	private FormularioEnum() {

	}

}

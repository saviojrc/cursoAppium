package br.ce.wcaquino.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropriedadesDoSistema {
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./src/main/resources/dados.properties");
		props.load(file);
		return props;

	}

}

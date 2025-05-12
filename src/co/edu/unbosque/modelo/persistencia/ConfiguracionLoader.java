package co.edu.unbosque.modelo.persistencia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class ConfiguracionLoader {
	private static final String RECURSO = "config/f1_calendar.properties";
	private Properties props;
	
	public ConfiguracionLoader() throws IOException, AccesoDatosException {
		props = new Properties();
		try(InputStream in = ConfiguracionLoader.class.getClassLoader().getResourceAsStream(RECURSO)) {
			if(in == null) {
				throw new AccesoDatosException("No se encontró el archivo de propiedades");
			}
		}
	}

}

package co.edu.unbosque.modelo.persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import co.edu.unbosque.modelo.entidad.Circuito;
import co.edu.unbosque.modelo.entidad.GrandPrix;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class ConfiguracionLoader {
	private String recurso;
	private Properties props;

	public ConfiguracionLoader(String recurso) throws IOException, AccesoDatosException {
		props = new Properties();
		try (InputStream in = ConfiguracionLoader.class.getClassLoader().getResourceAsStream(recurso)) {
			if (in == null) {
				throw new AccesoDatosException("No se encontró el archivo de propiedades");
			}

			props.load(new BufferedReader(new InputStreamReader(in)));
		}
	}

	public List<Circuito> cargarCircuitos() {
		String[] ids = props.getProperty("circuitos", "").split(",");
		List<Circuito> lista = new ArrayList<>();
		for (String id : ids) {
			id = id.trim();
			if (id.isEmpty())
				continue;
			String nombre = props.getProperty("circuito." + id + ".nombre");
			String rutaFoto = props.getProperty("circuito." + id + ".rutaFoto");
			lista.add(new Circuito(id, nombre, rutaFoto));
		}
		return lista;
	}

	public List<GrandPrix> cargarGrandPrix(List<Circuito> circuitos) throws AccesoDatosException {
		Map<String, Circuito> mapa = new HashMap<>();
		for (Circuito c : circuitos) {
			mapa.put(c.getId(), c);
		}

		String[] gps = props.getProperty("grandprix", "").split(",");
		List<GrandPrix> lista = new ArrayList<>();
		for (String id : gps) {
			id = id.trim();
			if (id.isEmpty())
				continue;
			String nombre = props.getProperty("grandprix." + id + ".nombre");
			String circuitoId = props.getProperty("grandprix." + id + ".circuito");
			Circuito circ = mapa.get(circuitoId);
			if (circ == null) {
				throw new AccesoDatosException("Circuito no encontrado: " + circuitoId);
			}
			lista.add(new GrandPrix(id, nombre, circ));
		}
		return lista;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}

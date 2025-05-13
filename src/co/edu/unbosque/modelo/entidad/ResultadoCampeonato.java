package co.edu.unbosque.modelo.entidad;

import java.util.List;
import java.util.Map;

public class ResultadoCampeonato implements Resultado {
	private final List<Equipo> clasificacion;
	private final Map<Equipo, Double> tiempos;

	public ResultadoCampeonato(List<Equipo> clasificacion, Map<Equipo, Double> tiempos) {
		super();
		this.clasificacion = clasificacion;
		this.tiempos = tiempos;
	}

	public List<Equipo> getClasificacion() {
		return clasificacion;
	}

	public Map<Equipo, Double> getTiempos() {
		return tiempos;
	}
	
	public Equipo getGanador() {
		return clasificacion.isEmpty() ? null : clasificacion.get(0);
	}

}

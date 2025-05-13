package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.List;

public class PartidaCarrera extends Partida<ResultadoCampeonato> {
	private final List<Equipo> participantes;
	private final Circuito circuito;
	private ResultadoCampeonato resultado;

	public PartidaCarrera(String id, List<Equipo> participantes, Circuito circuito, LocalDate fecha) {
		super(id, null, null, fecha);
		this.participantes = participantes;
		this.circuito = circuito;
	}

	public List<Equipo> getParticipantes() {
		return participantes;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	@Override
	protected void aplicarResultado(ResultadoCampeonato resultado) {
		this.resultado = resultado;

	}

	@Override
	public ResultadoCampeonato getResultado() {
		return resultado;
	}
	
	 @Override
	    public String toString() {
	        return "PartidaCarrera{" +
	               "id=" + getId() +
	               ", circuito=" + circuito.getNombre() +
	               ", fecha=" + getFecha() +
	               ", participantes=" + participantes.size() +
	               ", estado=" + getEstadoPartida() +
	               '}';
	    }

	@Override
	public Equipo getGanador() {
	    List<Equipo> clasif = resultado.getClasificacion();
	    if (clasif.isEmpty()) {
	        throw new IllegalStateException("Carrera sin clasificación");
	    }
	    return clasif.get(0);
	}
}

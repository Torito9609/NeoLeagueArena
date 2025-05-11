package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;

public class PartidaFifa extends Partida<ResultadoFifa> {
	private ResultadoFifa resultado;

	public PartidaFifa(String id, Equipo local, Equipo visitante, LocalDate fecha) {
		super(id, local, visitante, fecha);
	}

	@Override
	protected void aplicarResultado(ResultadoFifa resultado) {
		this.resultado = resultado;

	}

	@Override
	public ResultadoFifa getResultado() {
		return resultado;
	}

}

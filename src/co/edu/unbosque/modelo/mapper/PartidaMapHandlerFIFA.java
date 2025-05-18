package co.edu.unbosque.modelo.mapper;

import java.time.LocalDate;

import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.ResultadoFifa;
import co.edu.unbosque.modelo.entidad.PartidaFifa;

public class PartidaMapHandlerFIFA extends PartidaMapHandler<ResultadoFifa> {
	@Override
	protected Partida<ResultadoFifa> construirPartida(String id, Equipo local, Equipo visitante, LocalDate fecha) {
		return new PartidaFifa(id, local, visitante, fecha);
	}
}

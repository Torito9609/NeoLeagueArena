package co.edu.unbosque.modelo.mapper;

import java.time.LocalDate;

import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.ResultadoRocketLeague;
import co.edu.unbosque.modelo.entidad.PartidaRocketLeague;

public class PartidaMapHandlerRocketLeague extends PartidaMapHandler<ResultadoRocketLeague> {
	@Override
	protected Partida<ResultadoRocketLeague> construirPartida(String id, Equipo local, Equipo visitante, LocalDate fecha) {
		return new PartidaRocketLeague(id, local, visitante, fecha);
	}
}


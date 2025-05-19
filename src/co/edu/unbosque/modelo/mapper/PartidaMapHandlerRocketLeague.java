package co.edu.unbosque.modelo.mapper;

import java.time.LocalDate;

import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.dto.PartidaRocketLeagueDto;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.PartidaRocketLeague;
import co.edu.unbosque.modelo.entidad.ResultadoRocketLeague;

public class PartidaMapHandlerRocketLeague implements PartidaMapHandlerI {

	@Override
	public PartidaDto toDto(Partida<?> entidad) {
		if (!(entidad instanceof PartidaRocketLeague)) return null;

		PartidaRocketLeague partida = (PartidaRocketLeague) entidad;

		return new PartidaRocketLeagueDto(
			partida.getId(),
			partida.getEquipoLocal().getId(),
			partida.getEquipoVisitante().getId(),
			partida.getFecha(),
			partida.getEstadoPartida()
		);
	}

	@Override
	public Partida<?> toEntity(PartidaDto dto) {
		if (!(dto instanceof PartidaRocketLeagueDto)) return null;

		PartidaRocketLeagueDto rocketDto = (PartidaRocketLeagueDto) dto;

		Equipo local = construirEquipoDummy(rocketDto.getIdEquipoLocal());
		Equipo visitante = construirEquipoDummy(rocketDto.getIdEquipoVisitante());

		PartidaRocketLeague partida = new PartidaRocketLeague(rocketDto.getId(), local, visitante, rocketDto.getFecha());
		partida.setEstadoPartida(rocketDto.getEstado());

		return partida;
	}

	private Equipo construirEquipoDummy(String id) {
		Equipo e = new Equipo();
		e.setId(id);
		return e;
	}
}

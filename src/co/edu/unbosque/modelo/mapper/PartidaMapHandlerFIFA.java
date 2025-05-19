package co.edu.unbosque.modelo.mapper;


import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.dto.PartidaFifaDto;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.PartidaFifa;

public class PartidaMapHandlerFIFA implements PartidaMapHandlerI {

	@Override
	public PartidaDto toDto(Partida<?> entidad) {
		if (!(entidad instanceof PartidaFifa)) return null;

		PartidaFifa fifa = (PartidaFifa) entidad;

		return new PartidaFifaDto(
			fifa.getId(),
			fifa.getEquipoLocal() != null ? fifa.getEquipoLocal().getId() : null,
			fifa.getEquipoVisitante() != null ? fifa.getEquipoVisitante().getId() : null,
			fifa.getFecha(),
			fifa.getEstadoPartida()
		);
	}

	@Override
	public Partida<?> toEntity(PartidaDto dto) {
		if (!(dto instanceof PartidaFifaDto)) return null;

		PartidaFifaDto fifaDto = (PartidaFifaDto) dto;

		Equipo local = construirEquipoDummy(fifaDto.getIdEquipoLocal());
		Equipo visitante = construirEquipoDummy(fifaDto.getIdEquipoVisitante());

		PartidaFifa partida = new PartidaFifa(fifaDto.getId(), local, visitante, fifaDto.getFecha());
		partida.setEstadoPartida(fifaDto.getEstado());

		return partida;
	}

	private Equipo construirEquipoDummy(String id) {
		Equipo e = new Equipo();
		e.setId(id);
		return e;
	}
}

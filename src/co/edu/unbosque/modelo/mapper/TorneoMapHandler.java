package co.edu.unbosque.modelo.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.dto.TorneoDto;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.entidad.Torneo;

public class TorneoMapHandler implements Mapper<Torneo, TorneoDto> {

	private final PartidaMapHandlerI partidaMapper;

	public TorneoMapHandler(String tipoPartida) {
		this.partidaMapper = PartidaMapHandlerFactory.getHandler(tipoPartida);
	}

	@Override
	public TorneoDto toDto(Torneo entidad) {
		if (entidad == null) return null;

		// IDs de equipos
		List<String> idEquipos = new ArrayList<>();
		for (ParticipacionTorneo p : entidad.getParticipaciones()) {
			if (p.getEquipo() != null) {
				idEquipos.add(p.getEquipo().getId());
			}
		}

		// Partidas a DTO
		List<PartidaDto> partidasDto = new ArrayList<>();
		for (Partida<?> partida : entidad.getPartidas()) {
			partidasDto.add(partidaMapper.toDto(partida));
		}

		// Construcción del DTO
		TorneoDto dto = new TorneoDto();
		dto.setId(entidad.getId());
		dto.setNombre(entidad.getNombre());
		dto.setJuego(entidad.getJuego() != null ? entidad.getJuego().getNombre() : null);
		dto.setEstado(entidad.getEstado());
		dto.setIdEquiposInscritos(idEquipos);
		dto.setPartidas(partidasDto);

		// Guardamos el tipo de partida para la deserialización
		String tipoPartida = entidad.getPartidas().isEmpty()
				? "DESCONOCIDO"
				: entidad.getPartidas().get(0).getClass().getSimpleName();
		dto.setTipoPartida(tipoPartida);

		return dto;
	}

	@Override
	public Torneo toEntity(TorneoDto dto) {
		if (dto == null) return null;

		PartidaMapHandlerI handler = PartidaMapHandlerFactory.getHandler(dto.getTipoPartida());

		Torneo torneo = new Torneo();
		torneo.setId(dto.getId());
		torneo.setNombre(dto.getNombre());
		torneo.setEstado(dto.getEstado());

		torneo.setParticipaciones(new ArrayList<>());
		torneo.setJuego(null); // Setear después por servicios

		List<Partida<?>> partidas = new ArrayList<>();
		if (handler != null) {
			for (PartidaDto pDto : dto.getPartidas()) {
				partidas.add(handler.toEntity(pDto));
			}
		}
		torneo.setPartidas(partidas);

		return torneo;
	}
}

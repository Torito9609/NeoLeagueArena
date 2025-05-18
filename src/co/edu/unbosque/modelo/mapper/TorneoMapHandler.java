package co.edu.unbosque.modelo.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.dto.TorneoDto;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.entidad.Torneo;
import co.edu.unbosque.modelo.entidad.Resultado;

public class TorneoMapHandler<R extends Resultado> implements Mapper<Torneo<R>, TorneoDto> {

	private final PartidaMapHandler<R> partidaMapper;

	public TorneoMapHandler(PartidaMapHandler<R> partidaMapper) {
		this.partidaMapper = partidaMapper;
	}

	@Override
	public TorneoDto toDto(Torneo<R> entidad) {
		if (entidad == null) return null;

		// Convertir lista de participaciones a IDs
		List<String> idEquipos = new ArrayList<>();
		for (ParticipacionTorneo p : entidad.getParticipaciones()) {
			if (p.getEquipo() != null) {
				idEquipos.add(p.getEquipo().getId());
			}
		}

		// Convertir partidas
		List<PartidaDto> partidasDto = new ArrayList<>();
		for (Partida<R> partida : entidad.getPartidas()) {
			partidasDto.add(partidaMapper.toDto(partida));
		}

		// Crear DTO
		TorneoDto dto = new TorneoDto();
		dto.setId(entidad.getId());
		dto.setNombre(entidad.getNombre());
		dto.setJuego(entidad.getJuego() != null ? entidad.getJuego().getNombre() : null);
		dto.setEstado(entidad.getEstado());
		dto.setIdEquiposInscritos(idEquipos);
		dto.setPartidas(partidasDto);

		// Tipo de partida desde la primera (si existe)
		String tipoPartida = entidad.getPartidas().isEmpty()
				? "DESCONOCIDO"
				: entidad.getPartidas().get(0).getClass().getSimpleName();
		dto.setTipoPartida(tipoPartida);

		return dto;
	}

	@Override
	public Torneo<R> toEntity(TorneoDto dto) {
		if (dto == null) return null;

		Torneo<R> torneo = new Torneo<>();
		torneo.setId(dto.getId());
		torneo.setNombre(dto.getNombre());
		torneo.setEstado(dto.getEstado());

		// Juego y participaciones se setean después vía servicios
		torneo.setJuego(null);
		torneo.setParticipaciones(new ArrayList<>());

		// Reconstruir partidas
		List<Partida<R>> partidas = new ArrayList<>();
		for (PartidaDto pDto : dto.getPartidas()) {
			partidas.add(partidaMapper.toEntity(pDto));
		}
		torneo.setPartidas(partidas);

		return torneo;
	}
}

package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.ParticipacionTorneoDto;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.entidad.Torneo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.RegistroNoEncontradoException;
import co.edu.unbosque.modelo.servicio.EquipoService;
import co.edu.unbosque.modelo.servicio.TorneoService;

public class ParticipacionTorneoMapHandler implements Mapper<ParticipacionTorneo, ParticipacionTorneoDto> {

	private final EquipoService equipoService;
	private final TorneoService torneoService;

	public ParticipacionTorneoMapHandler() throws AccesoDatosException {
		this.equipoService = new EquipoService();
		this.torneoService = new TorneoService();
	}

	@Override
	public ParticipacionTorneoDto toDto(ParticipacionTorneo entidad) {
		if (entidad == null) return null;

		return new ParticipacionTorneoDto(
			entidad.getIdParticipacion(),
			entidad.getEquipo() != null ? entidad.getEquipo().getId() : null,
			entidad.getTorneo() != null ? entidad.getTorneo().getId() : null,
			entidad.getFechaInscripcion()
		);
	}

	@Override
	public ParticipacionTorneo toEntity(ParticipacionTorneoDto dto) {
		if (dto == null) return null;

		try {
			Equipo equipo = equipoService.buscarPorId(dto.getIdEquipo());
			Torneo torneo = torneoService.buscarPorId(dto.getIdTorneo());

			return new ParticipacionTorneo(
				dto.getIdParticipacion(),
				equipo,
				torneo,
				dto.getFechaInscripcion()
			);
		} catch (RegistroNoEncontradoException e) {
			System.err.println("Error al convertir DTO a entidad: " + e.getMessage());
			return null; 
		}
	}
}

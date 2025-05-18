package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EquipoDto;
import co.edu.unbosque.modelo.entidad.Equipo;

public class EquipoMapHandler implements Mapper<Equipo, EquipoDto> {

	public EquipoMapHandler() {
	}

	@Override
	public EquipoDto toDto(Equipo entidad) {
		if (entidad == null)
			return null;

		EquipoDto dto = new EquipoDto();
		dto.setId(entidad.getId());
		dto.setNombre(entidad.getNombre());
		dto.setIdTorneo(entidad.getTorneo() != null ? entidad.getTorneo().getId() : null);

		return dto;
	}
	
	public static Equipo convertirAEntidad(EquipoDto dto) {
		return new EquipoMapHandler().toEntity(dto);
	}

	@Override
	public Equipo toEntity(EquipoDto dto) {
		if (dto == null)
			return null;

		Equipo equipo = new Equipo();
		equipo.setId(dto.getId());
		equipo.setNombre(dto.getNombre());
		return equipo;
	}
	
	public static EquipoDto convertirADto(Equipo equipo) {
		return new EquipoMapHandler().toDto(equipo);
	}

}

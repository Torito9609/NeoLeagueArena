package co.edu.unbosque.modelo.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.PartidaCarreraDto;
import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.entidad.Circuito;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.PartidaCarrera;


public class PartidaMapHandlerCarrera implements PartidaMapHandlerI {

	@Override
	public PartidaDto toDto(Partida<?> entidad) {
		if (!(entidad instanceof PartidaCarrera)) return null;

		PartidaCarrera carrera = (PartidaCarrera) entidad;

		List<String> idParticipantes = new ArrayList<>();
		for (Equipo e : carrera.getParticipantes()) {
			idParticipantes.add(e.getId());
		}

		return new PartidaCarreraDto(
			carrera.getId(),
			idParticipantes,
			carrera.getCircuito().getNombre(),
			carrera.getFecha(),
			carrera.getEstadoPartida()
		);
	}

	@Override
	public Partida<?> toEntity(PartidaDto dtoBase) {
		if (!(dtoBase instanceof PartidaCarreraDto)) return null;

		PartidaCarreraDto dto = (PartidaCarreraDto) dtoBase;

		List<Equipo> participantes = new ArrayList<>();
		for (String id : dto.getIdParticipantes()) {
			participantes.add(construirEquipoDummy(id));
		}

		Circuito circuito = new Circuito();
		circuito.setNombre(dto.getNombreCircuito());

		PartidaCarrera partida = new PartidaCarrera(dto.getId(), participantes, circuito, dto.getFecha());
		partida.setEstadoPartida(dto.getEstado());

		return partida;
	}

	private Equipo construirEquipoDummy(String id) {
		Equipo dummy = new Equipo();
		dummy.setId(id);
		return dummy;
	}
}

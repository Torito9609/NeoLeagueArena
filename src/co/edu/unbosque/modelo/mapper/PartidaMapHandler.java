package co.edu.unbosque.modelo.mapper;

import java.time.LocalDate;

import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.Resultado;

public abstract class PartidaMapHandler<R extends Resultado> implements Mapper<Partida<R>, PartidaDto> {

	@Override
	public PartidaDto toDto(Partida<R> entidad) {
		if (entidad == null) return null;

		PartidaDto dto = new PartidaDto();
		dto.setId(entidad.getId());
		dto.setIdEquipoLocal(entidad.getEquipoLocal() != null ? entidad.getEquipoLocal().getId() : null);
		dto.setIdEquipoVisitante(entidad.getEquipoVisitante() != null ? entidad.getEquipoVisitante().getId() : null);
		dto.setFecha(entidad.getFecha());
		dto.setEstado(entidad.getEstadoPartida());

		return dto;
	}

	@Override
	public Partida<R> toEntity(PartidaDto dto) {
		if (dto == null) return null;

		// Como Partida es abstracta, delegamos la creación a la subclase
		Equipo local = construirEquipoDummy(dto.getIdEquipoLocal());
		Equipo visitante = construirEquipoDummy(dto.getIdEquipoVisitante());

		Partida<R> partida = construirPartida(dto.getId(), local, visitante, dto.getFecha());
		partida.setEstadoPartida(dto.getEstado());

		return partida;
	}

	/**
	 * Método abstracto para que las subclases construyan el tipo de partida concreto.
	 */
	protected abstract Partida<R> construirPartida(String id, Equipo local, Equipo visitante, LocalDate fecha);

	/**
	 * Método auxiliar para crear equipo básico solo con ID (se puede mejorar luego usando EquipoService).
	 */
	protected Equipo construirEquipoDummy(String idEquipo) {
		Equipo equipo = new Equipo();
		equipo.setId(idEquipo);
		return equipo;
	}
}

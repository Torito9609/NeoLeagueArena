package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.AsignacionEntrenadorDto;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Equipo;

public class AsignacionEntrenadorMapHandler implements Mapper<AsignacionEntrenador, AsignacionEntrenadorDto> {

    @Override
    public AsignacionEntrenadorDto toDto(AsignacionEntrenador entidad) {
        if (entidad == null) {
            return null;
        }
        AsignacionEntrenadorDto dto = new AsignacionEntrenadorDto();
        dto.setIdAsignacion(entidad.getIdAsignacion());
        dto.setIdEntrenador(entidad.getEntrenador().getId());
        dto.setIdEquipo(entidad.getEquipo().getId());
        dto.setFechaAsignacion(entidad.getFechaAsignacion());
        return dto;
    }

    @Override
    public AsignacionEntrenador toEntity(AsignacionEntrenadorDto dto) {
        if (dto == null) {
            return null;
        }
        AsignacionEntrenador entidad = new AsignacionEntrenador();
        entidad.setIdAsignacion(dto.getIdAsignacion());

        // Referencia mínima por ID; el servicio resolverá las entidades completas
        Entrenador entrenador = new Entrenador();
        entrenador.setId(dto.getIdEntrenador());
        entidad.setEntrenador(entrenador);

        Equipo equipo = new Equipo();
        equipo.setId(dto.getIdEquipo());
        entidad.setEquipo(equipo);

        entidad.setFechaAsignacion(dto.getFechaAsignacion());
        return entidad;
    }
}

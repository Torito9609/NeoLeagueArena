package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.AsignacionEntrenadorDto;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Equipo;
// Asumo que la interfaz Mapper está en este mismo paquete o importada correctamente.
// import co.edu.unbosque.modelo.mapper.Mapper;


/**
 * Implementación de la interfaz {@link Mapper} para convertir entre
 * entidades {@link AsignacionEntrenador} y DTOs {@link AsignacionEntrenadorDto}.
 * <p>
 * Esta clase maneja la transformación de datos entre el objeto de entidad
 * utilizado en la capa de negocio o persistencia y el objeto de transferencia de datos
 * utilizado, por ejemplo, para la comunicación con la capa de vista o servicios externos.
 * </p>
 *
 * @see Mapper
 * @see AsignacionEntrenador
 * @see AsignacionEntrenadorDto
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class AsignacionEntrenadorMapHandler implements Mapper<AsignacionEntrenador, AsignacionEntrenadorDto> {

    /**
     * Constructor por defecto para {@code AsignacionEntrenadorMapHandler}.
     */
    public AsignacionEntrenadorMapHandler() {
        // El constructor está vacío, no se realiza inicialización adicional.
    }

    /**
     * Convierte una entidad {@link AsignacionEntrenador} a su correspondiente
     * DTO {@link AsignacionEntrenadorDto}.
     * <p>
     * Si la entidad de entrada es {@code null}, este método devuelve {@code null}.
     * En el DTO, los campos {@code idEntrenador} e {@code idEquipo} se pueblan
     * obteniendo los IDs de las entidades {@link Entrenador} y {@link Equipo}
     * contenidas en la entidad {@code AsignacionEntrenador}.
     * </p>
     *
     * @param entidad La instancia de la entidad {@code AsignacionEntrenador} a convertir.
     * @return Un objeto {@code AsignacionEntrenadorDto} con los datos de la entidad,
     * o {@code null} si la entidad de entrada es {@code null}.
     * @throws NullPointerException si {@code entidad.getEntrenador()} o {@code entidad.getEquipo()} es {@code null}
     * y se intenta acceder a su ID. Se recomienda verificar la nulidad de estos objetos
     * antes de llamar a {@code getId()} si pueden ser nulos.
     */
    @Override
    public AsignacionEntrenadorDto toDto(AsignacionEntrenador entidad) {
        if (entidad == null) {
            return null;
        }
        AsignacionEntrenadorDto dto = new AsignacionEntrenadorDto();
        dto.setIdAsignacion(entidad.getIdAsignacion());
        // Se asume que entidad.getEntrenador() y entidad.getEquipo() no son null
        // y que sus respectivos objetos Entrenador y Equipo tienen un método getId().
        if (entidad.getEntrenador() != null) { // Verificación añadida para robustez
            dto.setIdEntrenador(entidad.getEntrenador().getId());
        }
        if (entidad.getEquipo() != null) { // Verificación añadida para robustez
            dto.setIdEquipo(entidad.getEquipo().getId());
        }
        dto.setFechaAsignacion(entidad.getFechaAsignacion());
        return dto;
    }

    /**
     * Convierte un DTO {@link AsignacionEntrenadorDto} a su correspondiente
     * entidad {@link AsignacionEntrenador}.
     * <p>
     * Si el DTO de entrada es {@code null}, este método devuelve {@code null}.
     * Para los campos {@code entrenador} y {@code equipo} en la entidad, se crean
     * nuevas instancias de {@link Entrenador} y {@link Equipo} respectivamente,
     * y se les asigna únicamente el ID proveniente del DTO. La carga o resolución
     * completa de estas entidades referenciadas se asume que es manejada
     * por una capa de servicio o lógica de negocio posterior.
     * </p>
     *
     * @param dto La instancia del DTO {@code AsignacionEntrenadorDto} a convertir.
     * @return Un objeto entidad {@code AsignacionEntrenador} con los datos del DTO,
     * o {@code null} si el DTO de entrada es {@code null}.
     */
    @Override
    public AsignacionEntrenador toEntity(AsignacionEntrenadorDto dto) {
        if (dto == null) {
            return null;
        }
        AsignacionEntrenador entidad = new AsignacionEntrenador();
        entidad.setIdAsignacion(dto.getIdAsignacion());

        // Crea instancias mínimas de Entrenador y Equipo solo con sus IDs.
        if (dto.getIdEntrenador() != null) {
            Entrenador entrenador = new Entrenador();
            entrenador.setId(dto.getIdEntrenador()); // Asume que Entrenador tiene setId()
            entidad.setEntrenador(entrenador);
        }

        if (dto.getIdEquipo() != null) {
            Equipo equipo = new Equipo();
            equipo.setId(dto.getIdEquipo()); // Asume que Equipo tiene setId()
            entidad.setEquipo(equipo);
        }

        entidad.setFechaAsignacion(dto.getFechaAsignacion());
        return entidad;
    }
}
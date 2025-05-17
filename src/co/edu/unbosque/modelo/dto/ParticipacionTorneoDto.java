package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
// import java.util.Objects; // No se usa Objects.equals o .hash aquí, pero podría añadirse para idParticipacion

/**
 * DTO (Data Transfer Object) para representar la participación de un equipo en un torneo.
 * <p>
 * Esta clase se utiliza para transferir datos sobre las inscripciones o participaciones
 * de equipos en torneos específicos, incluyendo la fecha de inscripción y los
 * identificadores del equipo y del torneo.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ParticipacionTorneoDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de esta instancia de participación.
     */
    private String idParticipacion;

    /**
     * Identificador del equipo que participa.
     * Referencia al {@link co.edu.unbosque.modelo.entidad.Equipo}.
     */
    private String idEquipo;

    /**
     * Identificador del torneo en el que se participa.
     * Referencia al {@link co.edu.unbosque.modelo.entidad.Torneo}.
     */
    private String idTorneo;

    /**
     * Fecha en la que el equipo se inscribió o se registró su participación en el torneo.
     */
    private LocalDate fechaInscripcion;

    /**
     * Constructor por defecto.
     */
    public ParticipacionTorneoDto() { }

    /**
     * Constructor con todos los campos para crear una instancia de {@code ParticipacionTorneoDto}.
     *
     * @param idParticipacion  El identificador único de esta participación.
     * @param idEquipo         El identificador del equipo participante.
     * @param idTorneo         El identificador del torneo.
     * @param fechaInscripcion La fecha de inscripción o registro de la participación.
     */
    public ParticipacionTorneoDto(
            String idParticipacion,
            String idEquipo,
            String idTorneo,
            LocalDate fechaInscripcion
    ) {
        this.idParticipacion = idParticipacion;
        this.idEquipo        = idEquipo;
        this.idTorneo        = idTorneo;
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Obtiene el ID de la participación.
     * @return El ID de la participación.
     */
    public String getIdParticipacion() {
        return idParticipacion;
    }

    /**
     * Establece el ID de la participación.
     * @param idParticipacion El nuevo ID de la participación.
     */
    public void setIdParticipacion(String idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    /**
     * Obtiene el ID del equipo participante.
     * @return El ID del equipo.
     */
    public String getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el ID del equipo participante.
     * @param idEquipo El nuevo ID del equipo.
     */
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Obtiene el ID del torneo.
     * @return El ID del torneo.
     */
    public String getIdTorneo() {
        return idTorneo;
    }

    /**
     * Establece el ID del torneo.
     * @param idTorneo El nuevo ID del torneo.
     */
    public void setIdTorneo(String idTorneo) {
        this.idTorneo = idTorneo;
    }

    /**
     * Obtiene la fecha de inscripción o registro de la participación.
     * @return La fecha de inscripción.
     */
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Establece la fecha de inscripción o registro de la participación.
     * @param fechaInscripcion La nueva fecha de inscripción.
     */
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Devuelve una representación en cadena de este {@code ParticipacionTorneoDto}.
     * @return Una cadena que representa el DTO, incluyendo sus campos principales.
     */
    @Override
    public String toString() {
        return "ParticipacionTorneoDto{" +
               "idParticipacion='" + idParticipacion + '\'' +
               ", idEquipo='" + idEquipo + '\'' +
               ", idTorneo='" + idTorneo + '\'' +
               ", fechaInscripcion=" + fechaInscripcion +
               '}';
    }
}
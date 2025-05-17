package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
// import java.util.Objects; // No se usa Objects.equals o .hash aquí, pero podría añadirse para idAsignacion

/**
 * DTO (Data Transfer Object) para representar la asignación de un entrenador a un equipo.
 * <p>
 * Esta clase se utiliza para transferir datos de asignaciones entre diferentes
 * capas de la aplicación, como entre la capa de servicio y la capa de vista,
 * o para la persistencia de datos simplificada.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class AsignacionEntrenadorDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la asignación.
     */
    private String idAsignacion;

    /**
     * Identificador del entrenador asignado.
     * Referencia al {@link co.edu.unbosque.modelo.entidad.Entrenador}.
     */
    private String idEntrenador;

    /**
     * Identificador del equipo al cual el entrenador es asignado.
     * Referencia al {@link co.edu.unbosque.modelo.entidad.Equipo}.
     */
    private String idEquipo;

    /**
     * Fecha en la que se realizó o inició la asignación.
     */
    private LocalDate fechaAsignacion;

    /**
     * Constructor por defecto.
     */
    public AsignacionEntrenadorDto() { }

    /**
     * Constructor con todos los campos para crear una instancia de {@code AsignacionEntrenadorDto}.
     *
     * @param idAsignacion    El identificador único de esta asignación.
     * @param idEntrenador    El identificador del entrenador.
     * @param idEquipo        El identificador del equipo.
     * @param fechaAsignacion La fecha de la asignación.
     */
    public AsignacionEntrenadorDto(
            String idAsignacion,
            String idEntrenador,
            String idEquipo,
            LocalDate fechaAsignacion
    ) {
        this.idAsignacion    = idAsignacion;
        this.idEntrenador    = idEntrenador;
        this.idEquipo        = idEquipo;
        this.fechaAsignacion = fechaAsignacion;
    }

    /**
     * Obtiene el ID de la asignación.
     * @return El ID de la asignación.
     */
    public String getIdAsignacion() {
        return idAsignacion;
    }

    /**
     * Establece el ID de la asignación.
     * @param idAsignacion El nuevo ID de la asignación.
     */
    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    /**
     * Obtiene el ID del entrenador asociado a esta asignación.
     * @return El ID del entrenador.
     */
    public String getIdEntrenador() {
        return idEntrenador;
    }

    /**
     * Establece el ID del entrenador para esta asignación.
     * @param idEntrenador El nuevo ID del entrenador.
     */
    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    /**
     * Obtiene el ID del equipo asociado a esta asignación.
     * @return El ID del equipo.
     */
    public String getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el ID del equipo para esta asignación.
     * @param idEquipo El nuevo ID del equipo.
     */
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Obtiene la fecha de esta asignación.
     * @return La fecha de asignación.
     */
    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    /**
     * Establece la fecha de esta asignación.
     * @param fechaAsignacion La nueva fecha de asignación.
     */
    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    /**
     * Devuelve una representación en cadena de este {@code AsignacionEntrenadorDto}.
     * @return Una cadena que representa el DTO, incluyendo sus campos principales.
     */
    @Override
    public String toString() {
        return "AsignacionEntrenadorDto{" +
               "idAsignacion='" + idAsignacion + '\'' +
               ", idEntrenador='" + idEntrenador + '\'' +
               ", idEquipo='" + idEquipo + '\'' +
               ", fechaAsignacion=" + fechaAsignacion +
               '}';
    }

    // Opcional: Implementar equals() y hashCode() si necesitas comparar DTOs
    // o usarlos en colecciones que dependan de estos métodos (ej. HashSet).
    // Se basarían típicamente en idAsignacion.
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignacionEntrenadorDto that = (AsignacionEntrenadorDto) o;
        return Objects.equals(idAsignacion, that.idAsignacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignacion);
    }
    */
}

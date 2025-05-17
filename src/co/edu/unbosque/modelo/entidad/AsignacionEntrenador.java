package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.Objects;
// Asumo que Entrenador y Equipo están en el mismo paquete o importados.
// import java.io.Serializable; // Considerar añadir si se va a persistir directamente.

/**
 * Representa la asignación de un {@link Entrenador} a un {@link Equipo} en una fecha específica.
 * <p>
 * Esta clase entidad vincula un entrenador con un equipo y registra cuándo se realizó
 * dicha asignación. Cada asignación tiene un identificador único.
 * </p>
 *
 * @see Entrenador
 * @see Equipo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class AsignacionEntrenador /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único para esta asignación específica.
     */
    private String idAsignacion;

    /**
     * El entrenador que es parte de esta asignación.
     */
    private Entrenador entrenador;

    /**
     * El equipo que es parte de esta asignación.
     */
    private Equipo equipo;

    /**
     * La fecha en que se efectuó o inició esta asignación.
     */
    private LocalDate fechaAsignacion;

    /**
     * Constructor por defecto.
     */
    public AsignacionEntrenador() {
    }

    /**
     * Constructor para crear una instancia de {@code AsignacionEntrenador} con todos sus atributos.
     *
     * @param idAsignacion    El identificador único de la asignación.
     * @param entrenador      La instancia del {@link Entrenador} asignado.
     * @param equipo          La instancia del {@link Equipo} al que se asigna el entrenador.
     * @param fechaAsignacion La fecha en que se realiza la asignación.
     */
    public AsignacionEntrenador(String idAsignacion, Entrenador entrenador, Equipo equipo, LocalDate fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.entrenador = entrenador;
        this.equipo = equipo;
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
     * Obtiene el entrenador asociado a esta asignación.
     * @return La instancia del {@link Entrenador}.
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Establece el entrenador para esta asignación.
     * @param entrenador La nueva instancia del {@link Entrenador}.
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Obtiene el equipo asociado a esta asignación.
     * @return La instancia del {@link Equipo}.
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Establece el equipo para esta asignación.
     * @param equipo La nueva instancia del {@link Equipo}.
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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
     * Compara este objeto {@code AsignacionEntrenador} con otro objeto para determinar si son iguales.
     * La igualdad se basa únicamente en el campo {@code idAsignacion}.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo {@code idAsignacion}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AsignacionEntrenador)) // También se puede usar getClass() != o.getClass() si no hay herencia
            return false;
        AsignacionEntrenador that = (AsignacionEntrenador) o;
        return Objects.equals(idAsignacion, that.idAsignacion);
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code AsignacionEntrenador}.
     * El código hash se basa únicamente en el campo {@code idAsignacion}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idAsignacion);
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code AsignacionEntrenador}.
     * La cadena incluye el {@code idAsignacion}, el ID del entrenador, el ID del equipo y la fecha de asignación.
     * Asume que las entidades {@link Entrenador} y {@link Equipo} tienen un método {@code getId()}.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        // El código asume que Entrenador y Equipo tienen un método getId()
        // y que ese ID es un String.
        String entrenadorId = (entrenador != null && entrenador.getId() != null) ? entrenador.getId() : "null";
        String equipoId = (equipo != null && equipo.getId() != null) ? equipo.getId() : "null";

        return "AsignacionEntrenador{" +
               "idAsignacion='" + idAsignacion + '\'' +
               ", entrenadorId=" + entrenadorId + // Se muestra el ID del entrenador
               ", equipoId=" + equipoId + // Se muestra el ID del equipo
               ", fechaAsignacion=" + fechaAsignacion +
               '}';
    }
}
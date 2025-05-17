package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.Objects;
// Asumo que Equipo y Torneo están en el mismo paquete o importados correctamente.
// import java.io.Serializable; // Considerar añadir si se va a persistir.

/**
 * Representa la participación de un {@link Equipo} en un {@link Torneo} específico.
 * <p>
 * Esta clase entidad vincula un equipo con un torneo y registra la fecha
 * en que se inscribió o se registró dicha participación. Cada instancia de participación
 * tiene un identificador único.
 * </p>
 *
 * @see Equipo
 * @see Torneo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ParticipacionTorneo /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único para esta instancia de participación en el torneo.
     */
    private String idParticipacion;

    /**
     * El {@link Equipo} que participa en el torneo.
     */
    private Equipo equipo;

    /**
     * El {@link Torneo} en el cual el equipo participa.
     */
    private Torneo torneo;

    /**
     * La fecha en que el equipo se inscribió o se registró para participar en el torneo.
     */
    private LocalDate fechaInscripcion;

    /**
     * Constructor por defecto.
     */
    public ParticipacionTorneo() { }

    /**
     * Constructor para crear una instancia de {@code ParticipacionTorneo} con todos sus atributos.
     *
     * @param idParticipacion  El identificador único de esta participación.
     * @param equipo           La instancia del {@link Equipo} participante.
     * @param torneo           La instancia del {@link Torneo} en el que se participa.
     * @param fechaInscripcion La fecha de inscripción.
     */
    public ParticipacionTorneo(String idParticipacion,
                                 Equipo equipo,
                                 Torneo torneo,
                                 LocalDate fechaInscripcion) {
        this.idParticipacion = idParticipacion;
        this.equipo          = equipo;
        this.torneo          = torneo;
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
     * Obtiene el equipo asociado a esta participación.
     * @return La instancia del {@link Equipo}.
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Establece el equipo para esta participación.
     * @param equipo La nueva instancia del {@link Equipo}.
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Obtiene el torneo asociado a esta participación.
     * @return La instancia del {@link Torneo}.
     */
    public Torneo getTorneo() {
        return torneo;
    }

    /**
     * Establece el torneo para esta participación.
     * @param torneo La nueva instancia del {@link Torneo}.
     */
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    /**
     * Obtiene la fecha de inscripción para esta participación.
     * @return La fecha de inscripción.
     */
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Establece la fecha de inscripción para esta participación.
     * @param fechaInscripcion La nueva fecha de inscripción.
     */
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Compara este objeto {@code ParticipacionTorneo} con otro objeto para determinar si son iguales.
     * La igualdad se basa únicamente en el campo {@code idParticipacion}.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo {@code idParticipacion}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipacionTorneo)) return false; // Usar instanceof para compatibilidad con posible herencia
        ParticipacionTorneo that = (ParticipacionTorneo) o;
        return Objects.equals(idParticipacion, that.idParticipacion);
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code ParticipacionTorneo}.
     * El código hash se basa únicamente en el campo {@code idParticipacion}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idParticipacion);
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code ParticipacionTorneo}.
     * La cadena incluye el {@code idParticipacion}, el ID del equipo, el ID del torneo
     * y la fecha de inscripción.
     * Asume que las entidades {@link Equipo} y {@link Torneo} tienen un método {@code getId()}.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        // El código asume que Equipo y Torneo tienen un método getId()
        String equipoId = (equipo != null && equipo.getId() != null) ? equipo.getId() : "null";
        String torneoId = (torneo != null && torneo.getId() != null) ? torneo.getId() : "null";

        return "ParticipacionTorneo{" +
               "idParticipacion='" + idParticipacion + '\'' +
               ", equipoId=" + equipoId +
               ", torneoId=" + torneoId +
               ", fechaInscripcion=" + fechaInscripcion +
               '}';
    }
}
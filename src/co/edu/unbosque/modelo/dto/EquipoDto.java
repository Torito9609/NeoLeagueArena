package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
// import java.util.Objects; // No se usa Objects.equals o .hash aquí, pero podría añadirse para id

/**
 * DTO (Data Transfer Object) para representar la información de un Equipo.
 * <p>
 * Esta clase se utiliza para transferir datos de equipos entre diferentes
 * capas de la aplicación. Contiene identificadores para el equipo, el torneo
 * al que podría estar asociado, y una lista de IDs de los jugadores que lo conforman.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class EquipoDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del equipo.
     */
    private String id;

    /**
     * Nombre del equipo.
     */
    private String nombre;

    /**
     * Identificador del torneo en el que el equipo participa o está registrado.
     * Puede ser {@code null} si el equipo no está asociado a un torneo específico.
     */
    private String idTorneo;

    /**
     * Lista de los identificadores únicos de los jugadores que pertenecen a este equipo.
     * Se inicializa como una lista vacía.
     */
    private List<String> jugadorIds = new ArrayList<>();

    /**
     * Constructor por defecto.
     * Inicializa la lista de IDs de jugadores como una lista vacía.
     */
    public EquipoDto() { }

    /**
     * Constructor con todos los campos para crear una instancia de {@code EquipoDto}.
     *
     * @param id          El identificador único del equipo.
     * @param nombre      El nombre del equipo.
     * @param idTorneo    El identificador del torneo asociado, o {@code null}.
     * @param jugadorIds  La lista de IDs de los jugadores del equipo. Si es {@code null},
     * se inicializará como una lista vacía.
     */
    public EquipoDto(String id,
                     String nombre,
                     String idTorneo,
                     List<String> jugadorIds) {
        this.id = id;
        this.nombre = nombre;
        this.idTorneo = idTorneo;
        this.jugadorIds = (jugadorIds != null ? new ArrayList<>(jugadorIds) : new ArrayList<>()); // Copia defensiva
    }

    /**
     * Obtiene el ID del equipo.
     * @return El ID del equipo.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del equipo.
     * @param id El nuevo ID del equipo.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del equipo.
     * @return El nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipo.
     * @param nombre El nuevo nombre del equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del torneo asociado a este equipo.
     * @return El ID del torneo, o {@code null} si no está asociado a ninguno.
     */
    public String getIdTorneo() {
        return idTorneo;
    }

    /**
     * Establece el ID del torneo para este equipo.
     * @param idTorneo El nuevo ID del torneo. Puede ser {@code null}.
     */
    public void setIdTorneo(String idTorneo) {
        this.idTorneo = idTorneo;
    }

    /**
     * Obtiene la lista de IDs de los jugadores del equipo.
     * @return Una lista de los IDs de los jugadores. Nunca es {@code null}.
     */
    public List<String> getJugadorIds() {
        // Devuelve una copia para evitar modificaciones externas si se desea mayor encapsulación,
        // o la referencia directa si se gestiona con cuidado.
        // Por consistencia con el setter, se devuelve la referencia actual.
        return jugadorIds;
    }

    /**
     * Establece la lista de IDs de los jugadores del equipo.
     * Si la lista proporcionada es {@code null}, se establece una lista vacía.
     * @param jugadorIds La nueva lista de IDs de jugadores.
     */
    public void setJugadorIds(List<String> jugadorIds) {
        this.jugadorIds = (jugadorIds != null ? new ArrayList<>(jugadorIds) : new ArrayList<>()); // Copia defensiva
    }

    /**
     * Devuelve una representación en cadena de este {@code EquipoDto}.
     * @return Una cadena que representa el DTO, incluyendo sus campos principales.
     */
    @Override
    public String toString() {
        return "EquipoDto{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", idTorneo='" + idTorneo + '\'' +
               ", jugadorIds=" + jugadorIds +
               '}';
    }

    // Opcional: Implementar equals() y hashCode() si es necesario,
    // típicamente basados en el 'id'.
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipoDto equipoDto = (EquipoDto) o;
        return Objects.equals(id, equipoDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    */
}
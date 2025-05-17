package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// Asumo que Torneo y Jugador están en el mismo paquete o importados correctamente.
// import java.io.Serializable; // Considerar añadir si se va a persistir.

/**
 * Representa un Equipo dentro del sistema de gestión de torneos.
 * <p>
 * Esta clase entidad almacena información sobre un equipo, incluyendo su
 * identificador único, nombre, el torneo en el que participa (si aplica)
 * y una lista de los jugadores que lo componen.
 * </p>
 *
 * @see Torneo
 * @see Jugador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Equipo /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único del equipo.
     */
    private String id;

    /**
     * Nombre oficial del equipo.
     */
    private String nombre;

    /**
     * El torneo en el que este equipo está actualmente inscrito o participando.
     * Puede ser {@code null} si el equipo no está asociado a ningún torneo.
     */
    private Torneo torneo;

    /**
     * Lista de los jugadores que forman parte de este equipo.
     * Se inicializa como una lista vacía en la declaración del atributo.
     */
    private List<Jugador> jugadores = new ArrayList<>();

    /**
     * Constructor por defecto.
     * La lista de jugadores se inicializa debido a su declaración.
     */
    public Equipo() {}

    /**
     * Constructor para crear una instancia de {@code Equipo} con ID, nombre y torneo.
     * La lista de jugadores se inicializa vacía por la declaración del atributo.
     *
     * @param id     El identificador único del equipo.
     * @param nombre El nombre del equipo.
     * @param torneo El torneo asociado al equipo. Puede ser {@code null}.
     */
    public Equipo(String id, String nombre, Torneo torneo) {
        this.id = id;
        this.nombre = nombre;
        this.torneo = torneo;
        // this.jugadores ya está inicializado por la declaración del atributo.
    }

    /**
     * Constructor para crear una instancia de {@code Equipo} con todos sus atributos.
     *
     * @param id        El identificador único del equipo.
     * @param nombre    El nombre del equipo.
     * @param torneo    El torneo asociado al equipo. Puede ser {@code null}.
     * @param jugadores La lista de jugadores del equipo. Si es {@code null},
     * se asignará una nueva lista vacía.
     */
    public Equipo(String id, String nombre, Torneo torneo, List<Jugador> jugadores) {
        this(id, nombre, torneo); // Llama al constructor anterior
        this.jugadores = jugadores != null ? new ArrayList<>(jugadores) : new ArrayList<>();
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
     * Obtiene el torneo asociado a este equipo.
     * @return El {@link Torneo} asociado, o {@code null} si no hay ninguno.
     */
    public Torneo getTorneo() {
        return torneo;
    }

    /**
     * Establece el torneo asociado a este equipo.
     * @param torneo El nuevo {@link Torneo} a asociar. Puede ser {@code null}.
     */
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    /**
     * Obtiene la lista de jugadores del equipo.
     * @return La lista de {@link Jugador} del equipo. Nunca es {@code null}.
     */
    public List<Jugador> getJugadores() {
        return jugadores; // Devuelve la referencia directa a la lista interna
    }

    /**
     * Establece la lista de jugadores del equipo.
     * Si la lista proporcionada es {@code null}, se establece una lista vacía.
     * @param jugadores La nueva lista de {@link Jugador}.
     */
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores != null ? new ArrayList<>(jugadores) : new ArrayList<>();
    }

    /**
     * Agrega un jugador a la lista de jugadores del equipo.
     * El jugador no se añade si es {@code null} o si ya está presente en la lista.
     *
     * @param jugador El {@link Jugador} a agregar.
     */
    public void agregarJugador(Jugador jugador) {
        if (jugador != null && !jugadores.contains(jugador)) {
            jugadores.add(jugador);
        }
    }

    /**
     * Elimina un jugador de la lista de jugadores del equipo.
     *
     * @param jugador El {@link Jugador} a eliminar.
     */
    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    /**
     * Compara este objeto {@code Equipo} con otro objeto para determinar si son iguales.
     * La igualdad se basa únicamente en el campo {@code id}.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo {@code id}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Equipo)) // También se puede usar getClass() != o.getClass() si no hay herencia
            return false;
        Equipo that = (Equipo) o;
        return Objects.equals(id, that.id);
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code Equipo}.
     * El código hash se basa únicamente en el campo {@code id}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code Equipo}.
     * La cadena incluye el ID y nombre del equipo, el ID del torneo asociado (si existe)
     * y el número de jugadores en el equipo.
     * Asume que la entidad {@link Torneo} tiene un método {@code getId()}.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        // El código asume que Torneo tiene un método getId() y que ese ID es un String.
        String torneoId = (torneo != null && torneo.getId() != null) ? torneo.getId() : "null"; // Asumiendo que Torneo tiene getId()
        return "Equipo{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", torneoId=" + torneoId + // Muestra el ID del torneo
               ", numJugadores=" + (jugadores != null ? jugadores.size() : 0) + // Muestra el número de jugadores
               '}';
    }
}
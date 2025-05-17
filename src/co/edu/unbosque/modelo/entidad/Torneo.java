package co.edu.unbosque.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.EstadoTorneo;
// Asumo que Resultado, Juego, ParticipacionTorneo, Fase, Partida y Equipo
// están definidos en el mismo paquete o importados correctamente.

/**
 * Representa un Torneo en el sistema de gestión de E-Sports.
 * <p>
 * Esta clase entidad encapsula toda la información y lógica relacionada con un torneo,
 * incluyendo su identificación, nombre, el juego para el que se organiza, su estado actual,
 * las participaciones de los equipos, las fases que lo componen y las partidas generadas.
 * </p>
 * <p>
 * Utiliza un parámetro genérico {@code R} que extiende {@link Resultado}, permitiendo
 * que el torneo maneje tipos de resultados específicos según el {@link Juego} asociado.
 * </p>
 *
 * @param <R> El tipo del {@link Resultado} asociado a las partidas de este torneo.
 * @see Juego
 * @see EstadoTorneo
 * @see ParticipacionTorneo
 * @see Fase
 * @see Partida
 * @see Equipo
 * @see Resultado
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Torneo<R extends Resultado> implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del torneo.
     */
    private String id;

    /**
     * Nombre oficial o descriptivo del torneo.
     */
    private String nombre;

    /**
     * El {@link Juego} específico para el cual se organiza este torneo.
     * El tipo de resultado {@code R} está vinculado a este juego.
     */
    private Juego<R> juego;

    /**
     * El estado actual del torneo (ej. PENDIENTE, EN_CURSO, FINALIZADO).
     * Se gestiona mediante el enum {@link EstadoTorneo}.
     */
    private EstadoTorneo estado;

    /**
     * Lista de las {@link ParticipacionTorneo} que registran los equipos inscritos en este torneo.
     * Se inicializa como una lista vacía.
     */
    private List<ParticipacionTorneo> participaciones = new ArrayList<>();

    /**
     * Lista de las {@link Fase}s que componen la estructura de este torneo.
     * Se inicializa como una lista vacía.
     */
    private List<Fase> fases = new ArrayList<>();

    /**
     * Lista de todas las {@link Partida}s generadas para este torneo a lo largo de sus fases.
     * Se inicializa como una lista vacía.
     */
    private List<Partida<R>> partidas = new ArrayList<>();

    /**
     * Constructor por defecto.
     * Las listas internas se inicializan en sus declaraciones.
     */
    public Torneo() { }

    /**
     * Constructor para crear una instancia de {@code Torneo} con sus atributos principales.
     * Las listas de participaciones, fases y partidas se inicializan vacías.
     *
     * @param id     El identificador único del torneo.
     * @param nombre El nombre del torneo.
     * @param juego  El {@link Juego} para el cual es el torneo.
     * @param estado El estado inicial del torneo.
     */
    public Torneo(String id, String nombre, Juego<R> juego, EstadoTorneo estado) {
        this.id     = id;
        this.nombre = nombre;
        this.juego  = juego;
        this.estado = estado;
        // Las listas ya están inicializadas en sus declaraciones.
    }

    /**
     * Obtiene el ID del torneo.
     * @return El ID del torneo.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del torneo.
     * @param id El nuevo ID del torneo.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del torneo.
     * @return El nombre del torneo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del torneo.
     * @param nombre El nuevo nombre del torneo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el juego asociado a este torneo.
     * @return El {@link Juego} del torneo.
     */
    public Juego<R> getJuego() {
        return juego;
    }

    /**
     * Establece el juego asociado a este torneo.
     * @param juego El nuevo {@link Juego} del torneo.
     */
    public void setJuego(Juego<R> juego) {
        this.juego = juego;
    }

    /**
     * Obtiene el estado actual del torneo.
     * @return El estado del torneo, como un valor del enum {@link EstadoTorneo}.
     */
    public EstadoTorneo getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del torneo.
     * @param estado El nuevo estado del torneo.
     */
    public void setEstado(EstadoTorneo estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la lista de participaciones de equipos en el torneo.
     * @return Una lista de {@link ParticipacionTorneo}. Nunca es {@code null}.
     */
    public List<ParticipacionTorneo> getParticipaciones() {
        return participaciones;
    }

    /**
     * Establece la lista de participaciones de equipos en el torneo.
     * Si la lista proporcionada es {@code null}, se establece una lista vacía.
     * @param participaciones La nueva lista de {@link ParticipacionTorneo}.
     */
    public void setParticipaciones(List<ParticipacionTorneo> participaciones) {
        this.participaciones = participaciones != null
                ? new ArrayList<>(participaciones) // Copia defensiva
                : new ArrayList<>();
    }

    /**
     * Obtiene la lista de fases que componen el torneo.
     * @return Una lista de {@link Fase}. Nunca es {@code null}.
     */
    public List<Fase> getFases() {
        return fases;
    }

    /**
     * Establece la lista de fases que componen el torneo.
     * Si la lista proporcionada es {@code null}, se establece una lista vacía.
     * @param fases La nueva lista de {@link Fase}.
     */
    public void setFases(List<Fase> fases) {
        this.fases = fases != null
                ? new ArrayList<>(fases) // Copia defensiva
                : new ArrayList<>();
    }

    /**
     * Obtiene la lista de todas las partidas generadas para el torneo.
     * @return Una lista de {@link Partida}. Nunca es {@code null}.
     */
    public List<Partida<R>> getPartidas() {
        return partidas;
    }

    /**
     * Establece la lista de todas las partidas generadas para el torneo.
     * Si la lista proporcionada es {@code null}, se establece una lista vacía.
     * @param partidas La nueva lista de {@link Partida}.
     */
    public void setPartidas(List<Partida<R>> partidas) {
        this.partidas = partidas != null
                ? new ArrayList<>(partidas) // Copia defensiva
                : new ArrayList<>();
    }

    /**
     * Inscribe un equipo en el torneo mediante un objeto {@link ParticipacionTorneo}.
     * La inscripción se añade si no es nula, si la participación corresponde a este torneo
     * y si la participación no existe previamente en la lista.
     *
     * @param p La {@link ParticipacionTorneo} que representa la inscripción del equipo.
     */
    public void inscribirEquipo(ParticipacionTorneo p) {
        if (p != null
                // Verifica que la participación sea para este torneo
                && p.getTorneo() != null && p.getTorneo().equals(this)
                && !participaciones.contains(p)) {
            participaciones.add(p);
        }
    }

    /**
     * Elimina la inscripción de un equipo del torneo.
     *
     * @param p La {@link ParticipacionTorneo} a remover.
     */
    public void removerParticipacion(ParticipacionTorneo p) {
        if (p != null) {
            participaciones.remove(p);
        }
    }

    /**
     * Obtiene una lista de todos los equipos actualmente inscritos en el torneo.
     *
     * @return Una lista de {@link Equipo}s inscritos.
     */
    public List<Equipo> listarEquipos() {
        List<Equipo> lista = new ArrayList<>();
        if (participaciones != null) {
            for (ParticipacionTorneo p : participaciones) {
                if (p != null && p.getEquipo() != null) {
                    lista.add(p.getEquipo());
                }
            }
        }
        return lista;
    }

    /**
     * Ejecuta secuencialmente todas las fases definidas para el torneo.
     * <p>
     * Para cada fase:
     * <ol>
     * <li>Genera las partidas de la fase utilizando los equipos que avanzaron de la fase anterior (o todos los inscritos para la primera fase).</li>
     * <li>Añade las partidas generadas a la lista general de partidas del torneo.</li>
     * <li>Calcula los equipos que avanzan de la actual fase para ser utilizados en la siguiente.</li>
     * </ol>
     * Al finalizar la ejecución de todas las fases, el estado del torneo se marca como {@link EstadoTorneo#FINALIZADO}.
     * </p>
     * <p>
     * Nota: El registro de resultados de las partidas generadas se asume que ocurre externamente
     * entre la generación de partidas de una fase y el cálculo de sus avanzadores.
     * </p>
     */
    public void ejecutarTorneo() {
        List<Equipo> actuales = listarEquipos(); // Comienza con todos los equipos inscritos
        partidas.clear(); // Limpia partidas previas si se re-ejecuta

        if (fases != null && juego != null) {
            for (Fase fase : fases) {
                if (fase == null || actuales.isEmpty()) { // No continuar si no hay fase o no hay equipos
                    break;
                }
                // 1) Generar partidas para esta fase
                List<Partida<R>> fasePartidas = fase.generarPartidas(actuales, juego);

                // 2) Se asume que los resultados se registran externamente aquí
                if (fasePartidas != null) {
                    partidas.addAll(fasePartidas);
                }

                // 3) Extraer avanzadores para la siguiente fase
                // Se necesita que las partidas en fasePartidas tengan sus resultados registrados
                // para que calcularAvanzadores funcione correctamente.
                if (fasePartidas != null && !fasePartidas.isEmpty()) {
                    actuales = fase.calcularAvanzadores(fasePartidas);
                } else {
                    actuales = new ArrayList<>(); // Si no hay partidas, no hay avanzadores
                }
            }
        }

        // 4) Marcar torneo como finalizado
        this.estado = EstadoTorneo.FINALIZADO;
    }

    /**
     * Compara este objeto {@code Torneo} con otro objeto para determinar si son iguales.
     * La igualdad se basa únicamente en el campo {@code id}.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo {@code id}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torneo)) return false; // Verifica si 'o' es una instancia de Torneo (o subclase)
        Torneo<?> that = (Torneo<?>) o; // Cast para acceder al id
        return Objects.equals(id, that.id);
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code Torneo}.
     * El código hash se basa únicamente en el campo {@code id}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code Torneo}.
     * La cadena incluye el ID, nombre, nombre del juego, estado, y el número
     * de equipos inscritos, fases definidas y partidas generadas.
     * Asume que la entidad {@link Juego} tiene un método {@code getNombre()}.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        String nombreJuego = (juego != null && juego.getNombre() != null) ? juego.getNombre() : "null";
        int numParticipaciones = (participaciones != null) ? participaciones.size() : 0;
        int numFases = (fases != null) ? fases.size() : 0;
        int numPartidas = (partidas != null) ? partidas.size() : 0;

        return "Torneo{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", juego=" + nombreJuego +
               ", estado=" + estado +
               ", inscritos=" + numParticipaciones +
               ", fases=" + numFases +
               ", partidas=" + numPartidas +
               '}';
    }
}
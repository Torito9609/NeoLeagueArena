package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;
// Asumo que Usuario, ParticipacionTorneo están en el mismo paquete o importados.
// import java.io.Serializable; // Considerar añadir si Usuario es Serializable.

/**
 * Representa a un Jugador dentro del sistema de gestión de torneos.
 * <p>
 * Esta clase entidad extiende {@link Usuario} y contiene información específica
 * de un jugador, como su nivel competitivo, alias (gamerTag), puntos de ranking
 * y un historial de sus participaciones en torneos.
 * </p>
 *
 * @see Usuario
 * @see NivelCompetitivoJugador
 * @see ParticipacionTorneo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Jugador extends Usuario /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Nivel competitivo actual del jugador.
     */
    private NivelCompetitivoJugador nivelCompetitivo;

    /**
     * Alias o nombre público del jugador utilizado en los juegos y torneos.
     */
    private String gamerTag;

    /**
     * Puntuación actual del jugador en el sistema de ranking.
     */
    private int rankingPuntos;

    /**
     * Lista que registra el historial de participaciones del jugador en diferentes torneos.
     * Se inicializa como una lista vacía en la declaración del atributo.
     */
    private List<ParticipacionTorneo> historialParticipacion = new ArrayList<>();

    /**
     * Constructor por defecto.
     * Llama al constructor de la superclase {@link Usuario}.
     * La lista de historial de participación se inicializa debido a su declaración.
     */
    public Jugador() {
        super();
    }

    /**
     * Constructor para crear una instancia de {@code Jugador} con todos sus atributos,
     * incluyendo los heredados de {@link Usuario}.
     *
     * @param id                       El identificador único del usuario.
     * @param nombres                  Los nombres del usuario.
     * @param apellidos                Los apellidos del usuario.
     * @param correo                   El correo electrónico del usuario.
     * @param celular                  El número de celular del usuario.
     * @param pais                     El país del usuario.
     * @param ciudad                   La ciudad del usuario.
     * @param fechaNacimiento          La fecha de nacimiento del usuario.
     * @param zonaHoraria              La zona horaria del usuario.
     * @param passwordHash             El hash de la contraseña del usuario.
     * @param rutaFoto                 La ruta a la foto de perfil del usuario.
     * @param necesitaCambioPassword   Indicador de si el usuario necesita cambiar su contraseña.
     * @param nivelCompetitivo         El nivel competitivo del jugador.
     * @param gamerTag                 El alias (gamerTag) del jugador.
     * @param rankingPuntos            Los puntos de ranking del jugador.
     * @param historialParticipacion   El historial de participaciones en torneos del jugador.
     * Si es {@code null}, se asignará una nueva lista vacía.
     */
    public Jugador(String id,
                   String nombres,
                   String apellidos,
                   String correo,
                   String celular,
                   String pais,
                   String ciudad,
                   LocalDate fechaNacimiento,
                   String zonaHoraria,
                   String passwordHash,
                   String rutaFoto,
                   boolean necesitaCambioPassword,
                   NivelCompetitivoJugador nivelCompetitivo,
                   String gamerTag,
                   int rankingPuntos,
                   List<ParticipacionTorneo> historialParticipacion) {
        super(id, nombres, apellidos, correo, celular, pais, ciudad, fechaNacimiento, zonaHoraria, passwordHash,
                rutaFoto, necesitaCambioPassword); // Llama al constructor de Usuario
        this.nivelCompetitivo = nivelCompetitivo;
        this.gamerTag = gamerTag;
        this.rankingPuntos = rankingPuntos;
        this.historialParticipacion = historialParticipacion != null ? new ArrayList<>(historialParticipacion) : new ArrayList<>();
    }

    /**
     * Obtiene el nivel competitivo del jugador.
     * @return El nivel competitivo del jugador.
     */
    public NivelCompetitivoJugador getNivelCompetitivo() {
        return nivelCompetitivo;
    }

    /**
     * Establece el nivel competitivo del jugador.
     * @param nivelCompetitivo El nuevo nivel competitivo.
     */
    public void setNivelCompetitivo(NivelCompetitivoJugador nivelCompetitivo) {
        this.nivelCompetitivo = nivelCompetitivo;
    }

    /**
     * Obtiene el gamerTag (alias) del jugador.
     * @return El gamerTag del jugador.
     */
    public String getGamerTag() {
        return gamerTag;
    }

    /**
     * Establece el gamerTag (alias) del jugador.
     * @param gamerTag El nuevo gamerTag.
     */
    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    /**
     * Obtiene los puntos de ranking del jugador.
     * @return Los puntos de ranking.
     */
    public int getRankingPuntos() {
        return rankingPuntos;
    }

    /**
     * Establece los puntos de ranking del jugador.
     * @param rankingPuntos Los nuevos puntos de ranking.
     */
    public void setRankingPuntos(int rankingPuntos) {
        this.rankingPuntos = rankingPuntos;
    }

    /**
     * Obtiene el historial de participaciones en torneos del jugador.
     * @return La lista del historial de {@link ParticipacionTorneo}. Nunca es {@code null}.
     */
    public List<ParticipacionTorneo> getHistorialParticipacion() {
        return historialParticipacion; // Devuelve la referencia directa a la lista interna
    }

    /**
     * Establece el historial de participaciones en torneos del jugador.
     * Si la lista proporcionada es {@code null}, se establece una lista vacía.
     * @param historialParticipacion La nueva lista del historial de {@link ParticipacionTorneo}.
     */
    public void setHistorialParticipacion(List<ParticipacionTorneo> historialParticipacion) {
        this.historialParticipacion = historialParticipacion != null ? new ArrayList<>(historialParticipacion) : new ArrayList<>();
    }

    /**
     * Agrega una participación a la lista del historial del jugador.
     * La participación no se añade si es {@code null} o si ya está presente en la lista.
     *
     * @param p La {@link ParticipacionTorneo} a agregar.
     */
    public void agregarParticipacion(ParticipacionTorneo p) {
        if (p != null && !historialParticipacion.contains(p)) {
            historialParticipacion.add(p);
        }
    }

    /**
     * Remueve una participación de la lista del historial del jugador.
     *
     * @param p La {@link ParticipacionTorneo} a remover.
     */
    public void removerParticipacion(ParticipacionTorneo p) {
        historialParticipacion.remove(p);
    }

    /**
     * Compara este objeto {@code Jugador} con otro objeto para determinar si son iguales.
     * La igualdad se basa en el ID heredado de la clase {@link Usuario}.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo ID de {@link Usuario}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Jugador)) // También se puede usar getClass() != o.getClass() si no hay herencia significativa que afecte equals
            return false;
        // No es necesario llamar a super.equals(o) si la igualdad se basa solo en el ID de Usuario,
        // y el ID se obtiene mediante getId() de esta clase (que lo hereda).
        return Objects.equals(getId(), ((Jugador) o).getId());
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code Jugador}.
     * El código hash se basa en el ID heredado de la clase {@link Usuario}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId()); // Usa el ID heredado de Usuario
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code Jugador}.
     * La cadena incluye el ID, gamerTag, nivel competitivo, puntos de ranking,
     * edad (calculada por un método {@code calcularEdad()} no visible en este código)
     * y el número de participaciones en torneos.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        // El método calcularEdad() no está definido en esta clase ni en la superclase Usuario (según el código proporcionado).
        // Para que esto compile, calcularEdad() debería existir en Usuario o aquí.
        // Por ahora, se comentará o se asumirá que existe en Usuario.
        // int edad = calcularEdad(); // Si existe en Usuario
        int edad = 0; // Placeholder si calcularEdad() no está disponible

        return "Jugador{" +
               "id=" + getId() + // Heredado de Usuario
               ", gamerTag='" + gamerTag + '\'' +
               ", nivel=" + nivelCompetitivo +
               ", ranking=" + rankingPuntos +
               ", edad=" + edad + // Requiere el método calcularEdad()
               ", participaciones=" + (historialParticipacion != null ? historialParticipacion.size() : 0) +
               '}';
    }

    // El método calcularEdad() no fue proporcionado. Si existe en la clase Usuario,
    // el toString() funcionará como está. Si no, necesitaría ser implementado.
    /*
    private int calcularEdad() {
        if (getFechaNacimiento() != null) { // Asumiendo que Usuario tiene getFechaNacimiento()
            return java.time.Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
        }
        return 0;
    }
    */
}
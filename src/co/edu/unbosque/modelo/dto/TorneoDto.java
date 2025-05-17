package co.edu.unbosque.modelo.dto;

// Es recomendable que los DTOs implementen Serializable
// import java.io.Serializable;
import co.edu.unbosque.modelo.enums.EstadoTorneo;
// import java.util.Objects; // Para equals y hashCode si se añaden

/**
 * DTO (Data Transfer Object) para representar la información de un Torneo.
 * <p>
 * Esta clase se utiliza para transferir datos de torneos entre diferentes
 * capas de la aplicación. Contiene el nombre del torneo, el juego al que pertenece
 * y su estado actual.
 * </p>
 * <p>Nota: Esta es una definición parcial de la clase. Se necesitarían constructores,
 * getters, setters y posiblemente la implementación de {@link java.io.Serializable}
 * para su uso completo como DTO.</p>
 *
 * @see co.edu.unbosque.modelo.enums.EstadoTorneo
 * @autor TuNombreCompletoAquí
 * @version 0.1 // Versión inicial esqueleto
 */
public class TorneoDto /* implements Serializable */ { // Considerar implementar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Nombre oficial del torneo.
     */
    private String nombre;

    /**
     * Nombre o identificador del juego para el cual se organiza el torneo.
     * Podría ser un String con el nombre del juego o un ID que referencie a una entidad Juego.
     * @see co.edu.unbosque.modelo.entidad.Juego
     */
    private String Juego; // Nota: Por convención de Java, los nombres de variables empiezan con minúscula ("juego")

    /**
     * Estado actual del torneo (ej. PENDIENTE, EN_CURSO, FINALIZADO).
     * Se define mediante el enum {@link EstadoTorneo}.
     */
    private EstadoTorneo estado;

    // --- Constructores, Getters y Setters Faltantes ---
    // A continuación, se muestra un ejemplo de cómo podrían ser:

    /**
     * Constructor por defecto.
     */
    public TorneoDto() {
    }

    /**
     * Constructor para inicializar un {@code TorneoDto} con sus campos.
     * @param nombre El nombre del torneo.
     * @param juego El identificador o nombre del juego del torneo.
     * @param estado El estado actual del torneo.
     */
    public TorneoDto(String nombre, String juego, EstadoTorneo estado) {
        this.nombre = nombre;
        this.Juego = juego; // Recordar convención de nombres para variables (juego)
        this.estado = estado;
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
     * Obtiene el nombre o identificador del juego del torneo.
     * @return El juego del torneo.
     */
    public String getJuego() {
        return Juego; // Recordar convención de nombres para variables (juego)
    }

    /**
     * Establece el nombre o identificador del juego del torneo.
     * @param juego El nuevo juego del torneo.
     */
    public void setJuego(String juego) {
        this.Juego = juego; // Recordar convención de nombres para variables (juego)
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
     * Devuelve una representación en cadena de este {@code TorneoDto}.
     * @return Una cadena que representa el DTO, incluyendo sus campos principales.
     */
    @Override
    public String toString() {
        return "TorneoDto{" +
               "nombre='" + nombre + '\'' +
               ", Juego='" + Juego + '\'' + // Recordar convención (juego)
               ", estado=" + estado +
               '}';
    }

    // Faltaría un ID para el torneo si se necesita identificar unívocamente
    // private String idTorneo;
    // Y sus correspondientes getters/setters y uso en constructores/toString/equals/hashCode.
}
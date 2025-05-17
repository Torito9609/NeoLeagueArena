package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
// import java.util.Objects; // No se usa Objects.equals o .hash aquí

/**
 * DTO (Data Transfer Object) para representar la información de un Juego.
 * <p>
 * Esta clase se utiliza para transferir datos de juegos entre diferentes
 * capas de la aplicación. Contiene el identificador, nombre y tipo del juego.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class JuegoDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del juego.
     */
    private String id;

    /**
     * Nombre del juego.
     */
    private String nombre;

    /**
     * Tipo o género del juego (por ejemplo, "MOBA", "FPS", "Deportes").
     */
    private String tipoJuego;

    /**
     * Constructor por defecto.
     */
    public JuegoDto() { }

    /**
     * Constructor con todos los campos para crear una instancia de {@code JuegoDto}.
     *
     * @param id        El identificador único del juego.
     * @param nombre    El nombre del juego.
     * @param tipoJuego El tipo o género del juego.
     */
    public JuegoDto(String id, String nombre, String tipoJuego) {
        this.id = id;
        this.nombre = nombre;
        this.tipoJuego = tipoJuego;
    }

    /**
     * Obtiene el ID del juego.
     * @return El ID del juego.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del juego.
     * @param id El nuevo ID del juego.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del juego.
     * @return El nombre del juego.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del juego.
     * @param nombre El nuevo nombre del juego.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo o género del juego.
     * @return El tipo del juego.
     */
    public String getTipoJuego() {
        return tipoJuego;
    }

    /**
     * Establece el tipo o género del juego.
     * @param tipoJuego El nuevo tipo del juego.
     */
    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    /**
     * Devuelve una representación en cadena de este {@code JuegoDto}.
     * @return Una cadena que representa el DTO, incluyendo su id, nombre y tipo de juego.
     */
    @Override
    public String toString() {
        return "JuegoDto{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", tipoJuego='" + tipoJuego + '\'' +
               '}';
    }
}
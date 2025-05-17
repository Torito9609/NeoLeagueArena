package co.edu.unbosque.modelo.exception;

// No se necesitan importaciones adicionales para esta clase, ya que extiende Exception.

/**
 * Excepción personalizada para manejar errores específicos relacionados con el acceso a datos.
 * <p>
 * Esta clase extiende {@link Exception}, lo que la convierte en una excepción de tipo
 * comprobada (checked exception). Se utiliza para señalar problemas que pueden ocurrir
 * durante operaciones de persistencia de datos, como errores al leer o escribir archivos,
 * problemas de conexión con bases de datos (si aplicara), o cualquier otra
 * condición anómala en la capa de acceso a datos.
 * </p>
 *
 * @see Exception
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class AccesoDatosException extends Exception {

    /**
     * Identificador único para la versión serializada de esta clase de excepción.
     * Es una buena práctica incluirlo en clases {@code Serializable}, incluyendo las excepciones.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que crea una nueva instancia de {@code AccesoDatosException}
     * con un mensaje descriptivo del error.
     *
     * @param mensaje El mensaje detallado que describe la causa de la excepción.
     * Este mensaje se puede recuperar usando {@link #getMessage()}.
     */
    public AccesoDatosException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor que crea una nueva instancia de {@code AccesoDatosException}
     * con un mensaje descriptivo y una causa raíz.
     * <p>
     * Este constructor es útil para encadenar excepciones, permitiendo propagar
     * la información de una excepción de nivel inferior que originó este error
     * de acceso a datos.
     * </p>
     *
     * @param mensaje El mensaje detallado que describe la causa de la excepción.
     * @param causa   La excepción original (causa raíz) que provocó esta excepción.
     * Se puede recuperar usando {@link #getCause()}.
     */
    public AccesoDatosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
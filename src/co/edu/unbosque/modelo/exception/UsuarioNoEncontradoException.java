package co.edu.unbosque.modelo.exception;

// No se necesitan importaciones adicionales para esta clase, ya que extiende Exception.

/**
 * Excepción personalizada para indicar que un usuario específico no fue encontrado
 * durante una operación de búsqueda o acceso a datos.
 * <p>
 * Esta clase extiende {@link Exception}, lo que la convierte en una excepción de tipo
 * comprobada (checked exception). Se utiliza para señalar específicamente la situación
 * en la que se intenta acceder a un usuario que no existe en la fuente de datos
 * (por ejemplo, al buscar por ID o por otro criterio único).
 * </p>
 *
 * @see Exception
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class UsuarioNoEncontradoException extends Exception {

    // Es buena práctica incluir un serialVersionUID en las clases Serializable,
    // incluidas las excepciones, aunque no lo hayas puesto explícitamente.
    // private static final long serialVersionUID = 1L; // Ejemplo

    /**
     * Constructor que crea una nueva instancia de {@code UsuarioNoEncontradoException}
     * con un mensaje descriptivo del error.
     *
     * @param mensaje El mensaje detallado que describe la causa de la excepción,
     * usualmente indicando el criterio de búsqueda que no arrojó resultados.
     * Este mensaje se puede recuperar usando {@link #getMessage()}.
     */
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    // Si en el futuro necesitaras encadenar esta excepción con otra causa raíz,
    // podrías añadir un constructor como el siguiente:
    /*
    public UsuarioNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
    */
}
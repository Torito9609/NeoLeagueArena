package co.edu.unbosque.modelo.entidad;

// import java.io.Serializable; // Considerar añadir si se va a persistir.
// import java.util.Objects; // Para equals y hashCode si se añaden.

/**
 * Representa un circuito o mapa donde se pueden llevar a cabo partidas.
 * <p>
 * Esta clase entidad contiene información básica de un circuito, como su
 * identificador, nombre y una ruta a una imagen representativa.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Circuito /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único del circuito.
     */
    private String id;

    /**
     * Nombre descriptivo del circuito.
     */
    private String nombre;

    /**
     * Ruta del sistema de archivos o URL a una imagen representativa del circuito.
     */
    private String rutaFoto;

    /**
     * Constructor para crear una instancia de {@code Circuito} con todos sus atributos.
     *
     * @param id       El identificador único del circuito.
     * @param nombre   El nombre del circuito.
     * @param rutaFoto La ruta a la imagen del circuito.
     */
    public Circuito(String id, String nombre, String rutaFoto) {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        this.id = id;
        this.nombre = nombre;
        this.rutaFoto = rutaFoto;
    }

    /**
     * Constructor por defecto.
     * Llama al constructor de la superclase {@link Object}.
     */
    public Circuito() {
        super(); // Llamada al constructor de Object, es implícita si se omite.
    }

    /**
     * Obtiene el ID del circuito.
     * @return El ID del circuito.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del circuito.
     * @param id El nuevo ID del circuito.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del circuito.
     * @return El nombre del circuito.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del circuito.
     * @param nombre El nuevo nombre del circuito.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ruta de la foto del circuito.
     * @return La ruta de la foto del circuito.
     */
    public String getRutaFoto() {
        return rutaFoto;
    }

    /**
     * Establece la ruta de la foto del circuito.
     * @param rutaFoto La nueva ruta de la foto del circuito.
     */
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    // Faltarían los métodos equals(), hashCode() y toString() para una entidad completa.
    // Ejemplo de cómo podrían ser (basados en 'id'):
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuito circuito = (Circuito) o;
        return Objects.equals(id, circuito.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Circuito{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", rutaFoto='" + rutaFoto + '\'' +
               '}';
    }
    */
}
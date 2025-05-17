package co.edu.unbosque.modelo.entidad;

// import java.time.LocalDate; // No se usa directamente en esta clase.
// import java.io.Serializable; // Considerar añadir si se va a persistir.
// import java.util.Objects; // Para equals y hashCode si se añaden.

/**
 * Representa un evento de Gran Premio (Grand Prix) dentro de un campeonato.
 * <p>
 * Esta clase entidad almacena información sobre un Gran Premio específico,
 * incluyendo su identificador único, nombre y el {@link Circuito} en el que se lleva a cabo.
 * Es utilizada típicamente en conjunto con fases de campeonato como {@link FaseCampeonato}.
 * </p>
 *
 * @see Circuito
 * @see FaseCampeonato
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class GrandPrix /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único del Gran Premio.
     */
    private String id;

    /**
     * Nombre oficial o descriptivo del Gran Premio (ej. "Gran Premio de Mónaco").
     */
    private String nombre;

    /**
     * El {@link Circuito} específico donde se realiza este Gran Premio.
     */
    private Circuito circuito;

    /**
     * Constructor por defecto.
     * Llama al constructor de la superclase {@link Object}.
     */
    public GrandPrix() {
        super(); // Llamada al constructor de Object, es implícita si se omite.
    }

    /**
     * Constructor para crear una instancia de {@code GrandPrix} con todos sus atributos.
     *
     * @param id       El identificador único del Gran Premio.
     * @param nombre   El nombre del Gran Premio.
     * @param circuito El {@link Circuito} donde se celebra el Gran Premio.
     */
    public GrandPrix(String id, String nombre, Circuito circuito) {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        this.id = id;
        this.nombre = nombre;
        this.circuito = circuito;
    }

    /**
     * Obtiene el ID del Gran Premio.
     * @return El ID del Gran Premio.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del Gran Premio.
     * @param id El nuevo ID del Gran Premio.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del Gran Premio.
     * @return El nombre del Gran Premio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del Gran Premio.
     * @param nombre El nuevo nombre del Gran Premio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el circuito donde se realiza el Gran Premio.
     * @return El {@link Circuito} del Gran Premio.
     */
    public Circuito getCircuito() {
        return circuito;
    }

    /**
     * Establece el circuito donde se realiza el Gran Premio.
     * @param circuito El nuevo {@link Circuito} del Gran Premio.
     */
    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    // Los métodos equals(), hashCode() y toString() no están definidos explícitamente
    // en el código proporcionado. Si se añaden, se documentarían aquí.
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrandPrix grandPrix = (GrandPrix) o;
        return Objects.equals(id, grandPrix.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GrandPrix{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", circuito=" + (circuito != null ? circuito.getNombre() : "null") + // Asume que Circuito tiene getNombre()
               '}';
    }
    */
}
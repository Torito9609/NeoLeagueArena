package co.edu.unbosque.modelo.entidad;

import java.util.List;
import java.util.Objects;
// Asumo que Resultado, Partida y Equipo están definidos en el mismo paquete o importados.
// import java.io.Serializable; // Considerar añadir si se va a persistir.

/**
 * Clase abstracta base para representar un tipo de juego dentro del sistema de torneos.
 * <p>
 * Proporciona la estructura común para todos los juegos, incluyendo un identificador
 * y un nombre. Define un método abstracto {@code generarPartidas} que las subclases
 * concretas deben implementar para especificar cómo se crean las partidas
 * según las reglas de ese juego particular.
 * </p>
 * <p>
 * Utiliza un parámetro genérico {@code R} que extiende {@link Resultado}, permitiendo
 * que cada tipo de juego defina el tipo específico de resultado que generan sus partidas.
 * </p>
 *
 * @param <R> El tipo del {@link Resultado} asociado a las partidas de este juego.
 * @see Resultado
 * @see Partida
 * @see Equipo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public abstract class Juego<R extends Resultado> /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único del juego.
     */
    private String id;

    /**
     * Nombre legible o descriptivo del juego.
     */
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Juego() { }

    /**
     * Constructor para inicializar un {@code Juego} con su ID y nombre.
     *
     * @param id     El identificador único del juego.
     * @param nombre El nombre del juego.
     */
    public Juego(String id, String nombre) {
        this.id     = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del juego.
     * @return El ID del juego.
     */
    public String getId()   { return id; }

    /**
     * Obtiene el nombre del juego.
     * @return El nombre del juego.
     */
    public String getNombre(){ return nombre; }

    // Los setters para id y nombre no están presentes en el código proporcionado.
    // public void setId(String id) { this.id = id; }
    // public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Método abstracto para generar una lista de partidas basadas en una lista de equipos participantes.
     * <p>
     * Las subclases deben implementar este método para definir la lógica específica de creación
     * de partidas según el formato del juego (ej. Round Robin, eliminación directa, etc.).
     * El comentario original sugiere "Round-Robin por defecto; subclases de 'partido 1-vs-1' lo implementan",
     * indicando que las implementaciones concretas definirán la estructura de los enfrentamientos.
     * </p>
     *
     * @param equipos La lista de {@link Equipo}s participantes.
     * @return Una lista de objetos {@link Partida}, cada uno parametrizado con el tipo de resultado {@code R}.
     */
    public abstract List<Partida<R>> generarPartidas(List<Equipo> equipos);

    /**
     * Compara este objeto {@code Juego} con otro objeto para determinar si son iguales.
     * La igualdad se basa únicamente en el campo {@code id}.
     * Realiza un cast seguro a {@code Juego<?>} para la comparación del ID.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo {@code id}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juego)) return false; // Verifica si 'o' es una instancia de Juego (o subclase)
        // Se realiza un cast a Juego<?> para poder acceder al campo 'id' del otro objeto,
        // asumiendo que 'id' es un campo común y accesible en todas las instancias de Juego.
        return Objects.equals(id, ((Juego<?>)o).id);
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code Juego}.
     * El código hash se basa únicamente en el campo {@code id}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena del objeto {@code Juego}.
     * Por defecto, la implementación de {@link Object#toString()} sería llamada si no se
     * sobrescribe aquí. Una implementación común sería devolver el nombre o ID del juego.
     * Ejemplo:
     * return "Juego{id='" + id + "', nombre='" + nombre + "'}";
     * El código proporcionado no incluye una implementación de toString().
     */
    // @Override
    // public String toString() {
    //     return nombre; // o alguna otra representación útil
    // }
}
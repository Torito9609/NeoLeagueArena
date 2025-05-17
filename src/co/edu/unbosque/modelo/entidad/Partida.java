package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.Objects;
// Asumo que Resultado, Equipo y EstadoPartida están definidos en el mismo paquete o importados.
// import java.io.Serializable; // Considerar añadir si se va a persistir.
// import java.util.List; // No usado directamente en los campos, pero sí en métodos abstractos.

import co.edu.unbosque.modelo.enums.EstadoPartida;

/**
 * Clase abstracta base que representa una partida o enfrentamiento entre dos equipos.
 * <p>
 * Proporciona la estructura y funcionalidad común para todas las partidas,
 * incluyendo identificadores, equipos participantes, fecha y estado. Define métodos
 * abstractos para manejar resultados específicos del juego y determinar el ganador,
 * que deben ser implementados por las subclases concretas.
 * </p>
 * <p>
 * Utiliza un parámetro genérico {@code R} que extiende {@link Resultado}, permitiendo
 * que cada tipo de partida defina el tipo específico de resultado que maneja.
 * </p>
 *
 * @param <R> El tipo del {@link Resultado} asociado a esta partida.
 * @see Resultado
 * @see Equipo
 * @see EstadoPartida
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public abstract class Partida<R extends Resultado> /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Identificador único de la partida.
     */
    private String id;

    /**
     * El equipo que juega como local en esta partida.
     */
    private Equipo equipoLocal;

    /**
     * El equipo que juega como visitante en esta partida.
     */
    private Equipo equipoVisitante;

    /**
     * La fecha programada o en la que se jugó la partida.
     */
    private LocalDate fecha;

    /**
     * El estado actual de la partida (ej. PENDIENTE, EN_CURSO, FINALIZADA).
     * Se gestiona mediante el enum {@link EstadoPartida}.
     */
    private EstadoPartida estado;

    /**
     * Constructor por defecto.
     * Llama al constructor de la superclase {@link Object}.
     * El comentario {@code // TODO Auto-generated constructor stub} sugiere que este
     * constructor podría requerir inicialización adicional o ser revisado.
     */
    public Partida() {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor para crear una instancia de {@code Partida} con sus atributos iniciales.
     * El estado de la partida se inicializa como {@link EstadoPartida#PENDIENTE}.
     *
     * @param id              El identificador único de la partida.
     * @param equipoLocal     El {@link Equipo} local.
     * @param equipoVisitante El {@link Equipo} visitante.
     * @param fecha           La fecha de la partida.
     */
    public Partida(String id, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha) {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estado = EstadoPartida.PENDIENTE; // Estado inicial por defecto
    }

    /**
     * Obtiene el ID de la partida.
     * @return El ID de la partida.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID de la partida.
     * @param id El nuevo ID de la partida.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el equipo local de la partida.
     * @return El {@link Equipo} local.
     */
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * Establece el equipo local de la partida.
     * @param equipoLocal El nuevo {@link Equipo} local.
     */
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * Obtiene el equipo visitante de la partida.
     * @return El {@link Equipo} visitante.
     */
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     * Establece el equipo visitante de la partida.
     * @param equipoVisitante El nuevo {@link Equipo} visitante.
     */
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    /**
     * Obtiene la fecha de la partida.
     * @return La fecha de la partida.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la partida.
     * @param fecha La nueva fecha de la partida.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado actual de la partida.
     * @return El estado de la partida, como un valor del enum {@link EstadoPartida}.
     */
    public EstadoPartida getEstadoPartida() {
        return estado;
    }

    /**
     * Establece el estado actual de la partida.
     * @param estadoPartida El nuevo estado de la partida.
     */
    public void setEstadoPartida(EstadoPartida estadoPartida) {
        this.estado = estadoPartida;
    }

    /**
     * Verifica si la partida ha finalizado.
     * @return {@code true} si el estado de la partida es {@link EstadoPartida#FINALIZADA},
     * {@code false} en caso contrario.
     */
    public boolean estaFinalizada() {
        return estado == EstadoPartida.FINALIZADA;
    }

    /**
     * Registra el resultado de la partida.
     * <p>
     * Solo se puede registrar un resultado si el estado actual de la partida es
     * {@link EstadoPartida#PENDIENTE}. Después de aplicar el resultado,
     * el estado de la partida cambia a {@link EstadoPartida#FINALIZADA}.
     * </p>
     *
     * @param resultado El objeto {@link Resultado} de tipo {@code R} a registrar.
     * @throws IllegalStateException Si se intenta registrar un resultado cuando la partida
     * no está en estado PENDIENTE.
     */
    public void registrarResultado(R resultado) {
        if (estado != EstadoPartida.PENDIENTE) {
            throw new IllegalStateException("No se puede registrar resultado: partida " + estado);
        }
        aplicarResultado(resultado); // Llama al método abstracto que la subclase implementará
        this.estado = EstadoPartida.FINALIZADA;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases para aplicar
     * el resultado específico del juego a la partida.
     * <p>
     * Esta es la lógica interna de cómo se procesa y almacena el resultado.
     * </p>
     *
     * @param resultado El objeto {@link Resultado} de tipo {@code R} que contiene la información del resultado.
     */
    protected abstract void aplicarResultado(R resultado);

    /**
     * Método abstracto que debe ser implementado por las subclases para obtener
     * el resultado de la partida.
     *
     * @return El objeto {@link Resultado} de tipo {@code R} asociado a esta partida.
     */
    public abstract R getResultado();

    /**
     * Método abstracto que debe ser implementado por las subclases para determinar
     * y devolver el equipo ganador de la partida.
     *
     * @return El {@link Equipo} ganador de la partida, o {@code null} si es un empate
     * o la partida no ha determinado un ganador.
     */
    public abstract Equipo getGanador();

    /**
     * Compara este objeto {@code Partida} con otro objeto para determinar si son iguales.
     * La igualdad se basa únicamente en el campo {@code id}.
     * Realiza un cast seguro a {@code Partida<?>} para la comparación del ID.
     *
     * @param o El objeto con el que se va a comparar.
     * @return {@code true} si los objetos son iguales (mismo {@code id}), {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partida)) return false; // Verifica si 'o' es una instancia de Partida (o subclase)
        Partida<?> that = (Partida<?>) o; // Cast para acceder al id
        return Objects.equals(id, that.id);
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code Partida}.
     * El código hash se basa únicamente en el campo {@code id}.
     *
     * @return El valor del código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code Partida}.
     * La cadena incluye el ID de la partida, los IDs de los equipos local y visitante,
     * la fecha y el estado actual de la partida.
     * Asume que la entidad {@link Equipo} tiene un método {@code getId()}.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        String localId = (equipoLocal != null && equipoLocal.getId() != null) ? equipoLocal.getId() : "null";
        String visitanteId = (equipoVisitante != null && equipoVisitante.getId() != null) ? equipoVisitante.getId() : "null";

        return "Partida{" +
               "id='" + id + '\'' +
               ", local=" + localId +
               ", visitante=" + visitanteId +
               ", fecha=" + fecha +
               ", estado=" + estado +
               '}';
    }
}
package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.List;
// import java.util.ArrayList; // No se usa explícitamente, la lista de participantes viene de fuera
// import java.util.Objects; // No se usa Objects.equals o .hash aquí directamente, hereda de Partida

// Asumo que Partida, ResultadoCampeonato, Equipo y Circuito
// están definidos en el mismo paquete o importados correctamente.

/**
 * Representa una partida de tipo carrera, una subclase de {@link Partida}.
 * <p>
 * Esta clase concreta modela una carrera en la que participan múltiples equipos
 * en un circuito específico. El resultado de la carrera se gestiona a través
 * de un objeto {@link ResultadoCampeonato}. A diferencia de las partidas 1 vs 1,
 * en el constructor se pasa una lista de todos los equipos participantes,
 * y los campos {@code equipoLocal} y {@code equipoVisitante} de la superclase
 * se inicializan como {@code null}.
 * </p>
 *
 * @see Partida
 * @see ResultadoCampeonato
 * @see Equipo
 * @see Circuito
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class PartidaCarrera extends Partida<ResultadoCampeonato> {

    /**
     * Lista de todos los equipos que participan en esta carrera.
     * Este campo es final y se asigna en el constructor.
     */
    private final List<Equipo> participantes;

    /**
     * El circuito específico donde se lleva a cabo esta carrera.
     * Este campo es final y se asigna en el constructor.
     */
    private final Circuito circuito;

    /**
     * Almacena el resultado de la carrera una vez que esta ha finalizado y
     * se ha registrado el resultado.
     */
    private ResultadoCampeonato resultado;

    /**
     * Constructor para crear una instancia de {@code PartidaCarrera}.
     * <p>
     * Inicializa una carrera con un ID, la lista de equipos participantes,
     * el circuito y la fecha. Los campos {@code equipoLocal} y {@code equipoVisitante}
     * de la clase base {@link Partida} se establecen en {@code null}, ya que
     * este tipo de partida involucra a múltiples participantes en lugar de un
     * enfrentamiento directo entre local y visitante.
     * </p>
     *
     * @param id             El identificador único de la partida/carrera.
     * @param participantes  La lista de {@link Equipo}s que compiten en la carrera.
     * @param circuito       El {@link Circuito} donde se realiza la carrera.
     * @param fecha          La fecha de la carrera.
     */
    public PartidaCarrera(String id, List<Equipo> participantes, Circuito circuito, LocalDate fecha) {
        super(id, null, null, fecha); // Llama al constructor de Partida, local y visitante son null
        this.participantes = participantes; // Asigna la lista de participantes
        this.circuito = circuito;
        // this.resultado se inicializa como null por defecto.
    }

    /**
     * Obtiene la lista de equipos participantes en esta carrera.
     * @return Una lista de {@link Equipo}s participantes.
     */
    public List<Equipo> getParticipantes() {
        return participantes;
    }

    /**
     * Obtiene el circuito en el que se realiza esta carrera.
     * @return El {@link Circuito} de la carrera.
     */
    public Circuito getCircuito() {
        return circuito;
    }

    /**
     * Aplica el resultado de la carrera a esta partida.
     * Este método es la implementación concreta de {@link Partida#aplicarResultado(Resultado)}.
     * Simplemente asigna el resultado proporcionado al campo interno {@code resultado}.
     * El cambio de estado de la partida a FINALIZADA lo maneja el método {@code registrarResultado}
     * de la superclase {@link Partida}.
     *
     * @param resultado El objeto {@link ResultadoCampeonato} que contiene la clasificación de la carrera.
     */
    @Override
    protected void aplicarResultado(ResultadoCampeonato resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtiene el resultado de esta carrera.
     * @return El {@link ResultadoCampeonato} de la carrera, o {@code null} si aún no se ha registrado.
     */
    @Override
    public ResultadoCampeonato getResultado() {
        return resultado;
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code PartidaCarrera}.
     * La cadena incluye el ID de la carrera, el nombre del circuito, la fecha,
     * el número de participantes y el estado actual de la carrera.
     * Asume que la entidad {@link Circuito} tiene un método {@code getNombre()}.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        String nombreCircuito = (circuito != null && circuito.getNombre() != null) ? circuito.getNombre() : "N/A";
        int numParticipantes = (participantes != null) ? participantes.size() : 0;

        return "PartidaCarrera{" +
               "id=" + getId() + // Heredado de Partida
               ", circuito=" + nombreCircuito +
               ", fecha=" + getFecha() + // Heredado de Partida
               ", participantes=" + numParticipantes +
               ", estado=" + getEstadoPartida() + // Heredado de Partida
               '}';
    }

    /**
     * Determina y devuelve el equipo ganador de la carrera.
     * <p>
     * El ganador se considera el primer equipo en la lista de clasificación
     * obtenida del {@link ResultadoCampeonato}.
     * </p>
     *
     * @return El {@link Equipo} ganador de la carrera.
     * @throws IllegalStateException Si el resultado no ha sido registrado (es {@code null})
     * o si la lista de clasificación en el resultado está vacía.
     */
    @Override
    public Equipo getGanador() {
        if (resultado == null) {
            throw new IllegalStateException("La carrera aún no tiene un resultado registrado.");
        }
        // Asume que ResultadoCampeonato tiene un método getClasificacion() que devuelve List<Equipo>
        List<Equipo> clasif = resultado.getClasificacion();
        if (clasif == null || clasif.isEmpty()) {
            throw new IllegalStateException("Carrera sin clasificación o clasificación vacía en el resultado.");
        }
        return clasif.get(0); // El primer equipo en la clasificación es el ganador.
    }
}
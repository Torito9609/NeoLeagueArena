package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
// Asumo que Partida, ResultadoRocketLeague y Equipo
// están definidos en el mismo paquete o importados correctamente.

/**
 * Representa una partida específica del juego Rocket League, una subclase de {@link Partida}.
 * <p>
 * Esta clase concreta modela un enfrentamiento 1 vs 1 (o equipo vs equipo, según la lógica
 * de {@link ResultadoRocketLeague}) en el juego Rocket League.
 * El resultado de la partida se gestiona a través de un objeto {@link ResultadoRocketLeague},
 * y el ganador se determina utilizando la lógica definida en dicho objeto de resultado.
 * </p>
 *
 * @see Partida
 * @see ResultadoRocketLeague
 * @see Equipo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class PartidaRocketLeague extends Partida<ResultadoRocketLeague> {

    /**
     * Almacena el resultado específico de esta partida de Rocket League una vez que
     * ha sido registrado.
     */
    private ResultadoRocketLeague resultado;

    /**
     * Constructor para crear una instancia de {@code PartidaRocketLeague}.
     * <p>
     * Llama al constructor de la superclase {@link Partida} para inicializar
     * el ID, los equipos local y visitante, y la fecha.
     * El resultado se inicializa como {@code null} por defecto.
     * </p>
     *
     * @param id         El identificador único de la partida.
     * @param local      El {@link Equipo} que juega como local.
     * @param visitante  El {@link Equipo} que juega como visitante.
     * @param fecha      La fecha de la partida.
     */
    public PartidaRocketLeague(String id, Equipo local, Equipo visitante, LocalDate fecha) {
        super(id, local, visitante, fecha);
        // this.resultado se inicializa como null por defecto.
    }

    /**
     * Aplica el resultado específico de Rocket League a esta partida.
     * Este método es la implementación concreta de {@link Partida#aplicarResultado(Resultado)}.
     * Asigna el resultado proporcionado al campo interno {@code resultado}.
     * El cambio de estado de la partida a FINALIZADA lo maneja el método {@code registrarResultado}
     * de la superclase {@link Partida}.
     *
     * @param res El objeto {@link ResultadoRocketLeague} que contiene la información del resultado.
     */
    @Override
    protected void aplicarResultado(ResultadoRocketLeague res) {
        this.resultado = res;
    }

    /**
     * Obtiene el resultado de esta partida de Rocket League.
     * @return El {@link ResultadoRocketLeague} de la partida, o {@code null} si aún no se ha registrado.
     */
    @Override
    public ResultadoRocketLeague getResultado() {
        return resultado;
    }

    /**
     * Determina y devuelve el equipo ganador de la partida de Rocket League.
     * <p>
     * Delega la lógica para determinar el ganador al método {@code getGanador}
     * del objeto {@link ResultadoRocketLeague}, pasándole los equipos local y visitante
     * de esta partida.
     * </p>
     *
     * @return El {@link Equipo} ganador de la partida, o {@code null} si es un empate
     * o el resultado no permite determinar un ganador claro.
     * @throws IllegalStateException Si el resultado no ha sido registrado (es {@code null}),
     * ya que se necesita para determinar el ganador.
     */
    @Override // Asegúrate de que la firma coincide con el método abstracto en Partida
    public Equipo getGanador() {
        if (resultado == null) {
            throw new IllegalStateException("No se puede determinar el ganador: el resultado de la partida Rocket League no ha sido registrado.");
        }
        // Asume que ResultadoRocketLeague tiene un método getGanador(Equipo local, Equipo visitante)
        return resultado.getGanador(getEquipoLocal(), getEquipoVisitante());
    }

    // El método toString() se hereda de la clase Partida si no se sobrescribe aquí.
    // Si se desea una representación específica para PartidaRocketLeague, se debería sobrescribir.
    /*
    @Override
    public String toString() {
        return "PartidaRocketLeague{" +
               "id='" + getId() + '\'' +
               ", local=" + (getEquipoLocal() != null ? getEquipoLocal().getId() : "null") +
               ", visitante=" + (getEquipoVisitante() != null ? getEquipoVisitante().getId() : "null") +
               ", fecha=" + getFecha() +
               ", estado=" + getEstadoPartida() +
               ", resultado=" + (resultado != null ? resultado.toString() : "pendiente") +
               '}';
    }
    */
}
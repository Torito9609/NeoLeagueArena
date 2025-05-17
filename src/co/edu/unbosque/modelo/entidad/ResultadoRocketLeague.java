package co.edu.unbosque.modelo.entidad;

// Asumo que Resultado y Equipo están definidos en el mismo paquete o importados.
// import java.io.Serializable; // No presente en el código
// import java.util.Objects; // No presente en el código

/**
 * Implementación de la interfaz {@link Resultado} para representar los resultados
 * de un partido de Rocket League.
 * <p>
 * Esta clase almacena el número de goles anotados por el equipo local,
 * el equipo visitante, y un indicador de si hubo tiempo extra.
 * Proporciona un método para determinar el equipo ganador.
 * </p>
 *
 * @see Resultado
 * @see Equipo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ResultadoRocketLeague implements Resultado {

    /**
     * Número de goles anotados por el equipo local.
     * Este campo es final y se asigna en el constructor.
     */
    private final int golesLocal;

    /**
     * Número de goles anotados por el equipo visitante.
     * Este campo es final y se asigna en el constructor.
     */
    private final int golesVisitante;

    /**
     * Indicador booleano de si el partido requirió tiempo extra.
     * {@code true} si hubo tiempo extra, {@code false} en caso contrario.
     * Este campo es final y se asigna en el constructor.
     */
    private final boolean tiempoExtra;

    /**
     * Constructor para crear una instancia de {@code ResultadoRocketLeague}.
     *
     * @param golesLocal     El número de goles anotados por el equipo local.
     * @param golesVisitante El número de goles anotados por el equipo visitante.
     * @param tiempoExtra    Indica si el partido tuvo tiempo extra.
     */
    public ResultadoRocketLeague(int golesLocal, int golesVisitante, boolean tiempoExtra) {
        this.golesLocal     = golesLocal;
        this.golesVisitante = golesVisitante;
        this.tiempoExtra    = tiempoExtra;
    }

    /**
     * Obtiene el número de goles anotados por el equipo local.
     * @return Los goles del equipo local.
     */
    public int getGolesLocal()     { return golesLocal; }

    /**
     * Obtiene el número de goles anotados por el equipo visitante.
     * @return Los goles del equipo visitante.
     */
    public int getGolesVisitante() { return golesVisitante; }

    /**
     * Verifica si el partido tuvo tiempo extra.
     * @return {@code true} si hubo tiempo extra, {@code false} de lo contrario.
     */
    public boolean isTiempoExtra()   { return tiempoExtra; }

    /**
     * Determina y devuelve el equipo ganador del partido de Rocket League.
     * <p>
     * Compara los goles del equipo local y visitante.
     * Lanza una excepción si el resultado es un empate, indicando que esta
     * condición no es manejada o permitida según la lógica de este método.
     * </p>
     *
     * @param local      El {@link Equipo} que jugó como local.
     * @param visitante  El {@link Equipo} que jugó como visitante.
     * @return El {@link Equipo} ganador.
     * @throws IllegalStateException Si el resultado es un empate.
     */
    public Equipo getGanador(Equipo local, Equipo visitante) {
        if (golesLocal > golesVisitante) return local;
        if (golesVisitante > golesLocal) return visitante;
        // El comentario original "define tu criterio de desempate (ej. flipo moneda o repite partido)"
        // está implementado como una excepción si hay empate.
        throw new IllegalStateException("Empate no permitido en eliminación");
    }
}
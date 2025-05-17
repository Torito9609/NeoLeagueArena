package co.edu.unbosque.modelo.entidad;

// Asumo que Resultado está definido en el mismo paquete o importado.

/**
 * Implementación de la interfaz {@link Resultado} para representar los resultados
 * de una partida o carrera del juego Gran Turismo.
 * <p>
 * Esta clase almacena el número de vueltas completadas por el "local" y el "visitante".
 * </p>
 *
 * @see Resultado
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ResultadoGranTurismo implements Resultado {

    /**
     * Número de vueltas completadas por el jugador o equipo "local".
     */
    private int vueltasLocal;

    /**
     * Número de vueltas completadas por el jugador o equipo "visitante".
     */
    private int vueltasVisitante;

    /**
     * Constructor para crear una instancia de {@code ResultadoGranTurismo}.
     *
     * @param vueltasLocal    El número de vueltas completadas por el "local".
     * @param vueltasVisitante El número de vueltas completadas por el "visitante".
     */
    public ResultadoGranTurismo(int vueltasLocal, int vueltasVisitante) {
        this.vueltasLocal = vueltasLocal;
        this.vueltasVisitante = vueltasVisitante;
    }

    /**
     * Obtiene el número de vueltas completadas por el "local".
     * @return Las vueltas del "local".
     */
    public int getVueltasLocal() {
        return vueltasLocal;
    }

    /**
     * Establece el número de vueltas completadas por el "local".
     * @param vueltasLocal El nuevo número de vueltas para el "local".
     */
    public void setVueltasLocal(int vueltasLocal) {
        this.vueltasLocal = vueltasLocal;
    }

    /**
     * Obtiene el número de vueltas completadas por el "visitante".
     * @return Las vueltas del "visitante".
     */
    public int getVueltasVisitante() {
        return vueltasVisitante;
    }

    /**
     * Establece el número de vueltas completadas por el "visitante".
     * @param vueltasVisitante El nuevo número de vueltas para el "visitante".
     */
    public void setVueltasVisitante(int vueltasVisitante) {
        this.vueltasVisitante = vueltasVisitante;
    }

}
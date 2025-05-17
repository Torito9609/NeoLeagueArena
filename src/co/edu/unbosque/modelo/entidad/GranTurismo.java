package co.edu.unbosque.modelo.entidad;

import java.util.List;
// Asumo que Juego, ResultadoCampeonato, Equipo y Partida
// están definidos en el mismo paquete o importados correctamente.

/**
 * Representa el juego Gran Turismo, una subclase de {@link Juego}.
 * <p>
 * Esta clase está diseñada para ser utilizada en conjunto con una fase de tipo
 * campeonato (como {@link FaseCampeonato}), donde la generación de carreras (partidas)
 * y la asignación de fechas se maneja externamente por la lógica de la fase.
 * Por lo tanto, el método {@code generarPartidas} de esta clase lanza una
 * {@link UnsupportedOperationException} si se invoca directamente.
 * </p>
 *
 * @see Juego
 * @see ResultadoCampeonato
 * @see FaseCampeonato
 * @see Equipo
 * @see Partida
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class GranTurismo extends Juego<ResultadoCampeonato> {

    /**
     * Constructor para crear una instancia del juego Gran Turismo.
     * Llama al constructor de la superclase {@link Juego} para establecer el ID y el nombre.
     *
     * @param id     El identificador único para esta instancia de juego Gran Turismo (p. ej. "gt").
     * @param nombre El nombre descriptivo para esta instancia de juego (p. ej. "Gran Turismo Sport e-sports").
     */
    public GranTurismo(String id, String nombre) {
        super(id, nombre);
    }

    /**
     * Este método no está soportado para la clase {@code GranTurismo}.
     * <p>
     * La generación de partidas (carreras) para Gran Turismo se delega a una
     * implementación de {@link Fase} (específicamente, una como {@link FaseCampeonato})
     * que puede manejar la lógica de calendarios con fechas dinámicas, circuitos
     * y el formato de un campeonato.
     * </p>
     * <p>
     * Si se llama directamente a este método, se considera un uso indebido.
     * </p>
     *
     * @param equipos La lista de equipos participantes.
     * @return No devuelve valor, ya que siempre lanza una excepción.
     * @throws UnsupportedOperationException Siempre, para indicar que este método
     * no debe ser invocado directamente para esta clase de juego.
     */
    @Override
    public List<Partida<ResultadoCampeonato>> generarPartidas(List<Equipo> equipos) {
        throw new UnsupportedOperationException(
            "Para Gran Turismo, usa FaseCampeonato con lista de GPs y fechas dinámicas"
        );
    }
}
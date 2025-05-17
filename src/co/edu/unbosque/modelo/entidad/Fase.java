package co.edu.unbosque.modelo.entidad;

import java.util.List;
// Asumo que Resultado, Partida, Equipo y Juego están definidos en el mismo paquete o importados.

/**
 * Define el contrato para una fase dentro de la estructura de un torneo.
 * <p>
 * Una fase representa una etapa específica de una competencia (por ejemplo,
 * fase de grupos, playoffs, final). Esta interfaz establece los métodos
 * esenciales que cualquier implementación de fase debe proporcionar, como
 * obtener su nombre, generar las partidas correspondientes a la fase
 * y calcular qué equipos avanzan basándose en los resultados de dichas partidas.
 * </p>
 * <p>
 * Utiliza genéricos para permitir flexibilidad en el tipo de {@link Resultado}
 * que manejan las partidas y el tipo de {@link Juego} específico.
 * </p>
 *
 * @see Partida
 * @see Equipo
 * @see Juego
 * @see Resultado
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public interface Fase {

    /**
     * Obtiene el nombre descriptivo de la fase.
     *
     * @return El nombre de la fase (ej. "Fase de Grupos", "Cuartos de Final").
     */
    String getNombre();

    /**
     * Genera la lista de partidas para esta fase, basándose en los equipos participantes
     * y las reglas del juego específico.
     * <p>
     * El tipo de resultado {@code R} de las partidas generadas debe ser compatible
     * con el tipo de resultado que maneja el {@link Juego} proporcionado.
     * </p>
     *
     * @param <R>           El tipo del {@link Resultado} específico de las partidas para este juego.
     * @param participantes La lista de {@link Equipo}s que compiten en esta fase.
     * @param juego         La instancia del {@link Juego} para el cual se generarán las partidas,
     * restringido al tipo de resultado {@code R}.
     * @return Una lista de objetos {@link Partida}, cada uno parametrizado con el tipo de resultado {@code R}.
     */
    <R extends Resultado> List<Partida<R>> generarPartidas(List<Equipo> participantes, Juego<R> juego);

    /**
     * Calcula y devuelve la lista de equipos que avanzan a la siguiente etapa
     * o se consideran ganadores de esta fase, basándose en los resultados de las partidas jugadas.
     * <p>
     * El tipo de resultado {@code R} de las partidas analizadas debe ser el mismo
     * que se utilizó al generarlas.
     * </p>
     *
     * @param <R>      El tipo del {@link Resultado} específico de las partidas analizadas.
     * @param partidas La lista de {@link Partida}s jugadas en esta fase, con sus respectivos resultados.
     * @return Una lista de {@link Equipo}s que han avanzado o ganado la fase.
     */
    <R extends Resultado> List<Equipo> calcularAvanzadores(List<Partida<R>> partidas);

}
package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Asumo que Resultado, Partida, Equipo y Juego están definidos en el mismo paquete o importados.

/**
 * Implementación de la interfaz {@link Fase} para un formato de torneo tipo liga (Round Robin).
 * <p>
 * En esta fase, todos los equipos participantes se enfrentan entre sí. La generación
 * de partidas se delega al método {@code generarPartidas} de la clase {@link Juego}.
 * La clasificación o los equipos que avanzan se determinan contando el número de
 * victorias de cada equipo y ordenándolos de forma descendente según este criterio.
 * </p>
 *
 * @see Fase
 * @see Equipo
 * @see Juego
 * @see Partida
 * @see Resultado
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class FaseRoundRobin implements Fase {

    /**
     * Nombre descriptivo de esta fase de Round Robin.
     */
    private final String nombre;

    /**
     * Constructor para crear una instancia de {@code FaseRoundRobin}.
     *
     * @param nombre El nombre de la fase (ej. "Liga Regular", "Fase de Grupos Única").
     */
    public FaseRoundRobin(String nombre) {
        this.nombre = nombre;
    }

    /**
     * {@inheritDoc}
     * <p>Devuelve el nombre de esta fase de Round Robin.</p>
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Genera todas las partidas necesarias para un formato Round Robin (todos contra todos).
     * Esta implementación delega la creación de los enfrentamientos 1 contra 1
     * directamente al método {@code generarPartidas} del objeto {@link Juego} proporcionado.
     * </p>
     */
    @Override
    public <R extends Resultado> List<Partida<R>> generarPartidas(
            List<Equipo> equipos,
            Juego<R> juego
    ) {
        // Delega al juego la creación de todos los enfrentamientos.
        return juego.generarPartidas(equipos);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Calcula la clasificación de los equipos o los equipos que avanzan de esta fase
     * de Round Robin, basándose en el número de victorias.
     * Primero, cuenta las victorias de cada equipo a partir de la lista de partidas.
     * Luego, ordena los equipos de forma descendente según el número de victorias.
     * </p>
     * <p>
     * Asume que cada {@link Partida} tiene un método {@code getGanador()} que devuelve
     * el {@link Equipo} ganador, y métodos {@code getEquipoLocal()} y {@code getEquipoVisitante()}
     * para asegurar que todos los equipos participantes sean considerados en el conteo de victorias
     * (inicializándolos con 0 victorias si aún no están en el mapa).
     * </p>
     */
    @Override
    public <R extends Resultado> List<Equipo> calcularAvanzadores(
            List<Partida<R>> partidas
    ) {
        // 1) Contar victorias por equipo
        Map<Equipo, Integer> victorias = new HashMap<>();
        if (partidas != null) {
            for (Partida<R> p : partidas) {
                if (p == null) continue; // Saltar partidas nulas

                Equipo local = p.getEquipoLocal();
                Equipo visitante = p.getEquipoVisitante();

                // Asegurar inicialización en 0 para todos los equipos participantes
                if (local != null) {
                    victorias.putIfAbsent(local, 0);
                }
                if (visitante != null) {
                    victorias.putIfAbsent(visitante, 0);
                }

                // Incrementar victoria del ganador
                Equipo ganador = p.getGanador();
                if (ganador != null) { // Solo si hay un ganador (evita error si es empate y getGanador() devuelve null)
                    victorias.put(ganador, victorias.getOrDefault(ganador, 0) + 1);
                }
            }
        }

        // 2) Ordenar equipos por victorias descendente
        List<Map.Entry<Equipo, Integer>> entradas =
                new ArrayList<>(victorias.entrySet());
        // Se usa una clase anónima Comparator para el ordenamiento.
        Collections.sort(entradas, new Comparator<Map.Entry<Equipo, Integer>>() {
            @Override
            public int compare(Map.Entry<Equipo, Integer> e1,
                               Map.Entry<Equipo, Integer> e2) {
                // Orden descendente por valor (victorias)
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        // 3) Extraer la lista de equipos en ese orden
        List<Equipo> tablaOrdenada = new ArrayList<>();
        for (Map.Entry<Equipo, Integer> entry : entradas) {
            tablaOrdenada.add(entry.getKey());
        }
        return tablaOrdenada;
    }
}
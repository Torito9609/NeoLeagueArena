package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.List;
// Asumo que Resultado, Partida, Equipo y Juego están definidos en el mismo paquete o importados.

/**
 * Implementación de la interfaz {@link Fase} para un formato de torneo de eliminación directa.
 * <p>
 * Esta clase gestiona la lógica de una fase de eliminación directa, donde los equipos
 * se emparejan según un sistema de cabezas de serie (primero contra último,
 * segundo contra penúltimo, etc.). Se asume que el método {@code generarPartidas}
 * de la clase {@link Juego} puede manejar la creación de una partida para una pareja de equipos.
 * Los ganadores de cada partida avanzan.
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
public class FaseEliminacionDirecta implements Fase {

    /**
     * Nombre descriptivo de esta fase de eliminación directa.
     */
    private final String nombre;

    /**
     * Constructor para crear una instancia de {@code FaseEliminacionDirecta}.
     *
     * @param nombre El nombre de la fase (ej. "Octavos de Final", "Semifinales").
     */
    public FaseEliminacionDirecta(String nombre) {
        this.nombre = nombre;
    }

    /**
     * {@inheritDoc}
     * <p>Devuelve el nombre de esta fase de eliminación directa.</p>
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Genera las partidas para una ronda de eliminación directa. Empareja los equipos
     * tomando el primero con el último, el segundo con el penúltimo, y así sucesivamente.
     * Para cada pareja, utiliza el método {@code generarPartidas} del {@link Juego}
     * (asumiendo que para dos equipos este método devuelve una única partida).
     * </p>
     */
    @Override
    public <R extends Resultado> List<Partida<R>> generarPartidas(List<Equipo> equipos, Juego<R> juego) {
        List<Partida<R>> bracket = new ArrayList<>();
        int n = equipos.size();
        for (int i = 0; i < n / 2; i++) {
            Equipo local = equipos.get(i);
            Equipo visitante = equipos.get(n - 1 - i);

            // Prepara la pareja de equipos para generar su partida.
            List<Equipo> pareja = new ArrayList<>();
            pareja.add(local);
            pareja.add(visitante);

            // Utiliza el método del juego para generar la partida de esta pareja.
            List<Partida<R>> partidos = juego.generarPartidas(pareja);
            if (partidos != null && !partidos.isEmpty()) {
                // Asume que para una pareja, juego.generarPartidas devuelve una lista con una sola partida.
                bracket.add(partidos.get(0));
            }
        }
        return bracket;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Determina los equipos que avanzan de esta ronda de eliminación directa.
     * Se asume que cada partida tiene un único ganador, el cual es obtenido
     * mediante el método {@code getGanador()} de la {@link Partida}.
     * </p>
     */
    @Override
    public <R extends Resultado> List<Equipo> calcularAvanzadores(List<Partida<R>> partidas) {
        List<Equipo> ganadores = new ArrayList<>();
        if (partidas != null) {
            for (Partida<R> p : partidas) {
                if (p != null && p.getGanador() != null) { // Verifica que la partida y el ganador no sean nulos
                    ganadores.add(p.getGanador());
                }
            }
        }
        return ganadores;
    }
}
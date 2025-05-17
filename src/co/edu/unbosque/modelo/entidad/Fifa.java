package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
// Asumo que Juego, ResultadoFifa, Equipo, Partida y PartidaFifa
// están definidos en el mismo paquete o importados correctamente.

/**
 * Representa el juego FIFA, una subclase de {@link Juego}.
 * <p>
 * Esta clase concreta implementa la lógica para generar partidas
 * en un formato de Round Robin (todos contra todos 1 vs 1) para el juego FIFA.
 * Las partidas generadas son de tipo {@link PartidaFifa} y utilizan
 * {@link ResultadoFifa} para registrar sus resultados.
 * </p>
 *
 * @see Juego
 * @see ResultadoFifa
 * @see PartidaFifa
 * @see Equipo
 * @see Partida
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Fifa extends Juego<ResultadoFifa> {

    /**
     * Constructor para crear una instancia del juego FIFA.
     * Llama al constructor de la superclase {@link Juego} para establecer el ID y el nombre.
     *
     * @param id     El identificador único para esta instancia de juego FIFA.
     * @param nombre El nombre descriptivo para esta instancia de juego FIFA (ej. "FIFA 2025 Torneo Principal").
     */
    public Fifa(String id, String nombre) {
        super(id, nombre); // Llama al constructor de la clase base Juego
    }

    /**
     * Genera una lista de partidas para un torneo o fase de tipo Round Robin (todos contra todos)
     * para el juego FIFA.
     * <p>
     * Por cada par único de equipos en la lista de participantes, se crea una instancia
     * de {@link PartidaFifa}. El ID de la partida se genera aleatoriamente usando UUID,
     * y la fecha de la partida se establece como la fecha actual del sistema en el momento
     * de la generación.
     * </p>
     *
     * @param equipos La lista de {@link Equipo}s participantes para los cuales se generarán las partidas.
     * @return Una lista de objetos {@link Partida} (específicamente {@link PartidaFifa}),
     * representando el calendario de enfrentamientos.
     */
    @Override
    public List<Partida<ResultadoFifa>> generarPartidas(List<Equipo> equipos) {
        List<Partida<ResultadoFifa>> calendario = new ArrayList<>();
        if (equipos != null) {
            for (int i = 0; i < equipos.size(); i++) {
                for (int j = i + 1; j < equipos.size(); j++) {
                    // Crea una nueva instancia de PartidaFifa para cada enfrentamiento único.
                    calendario.add(new PartidaFifa(
                            UUID.randomUUID().toString(), // ID de partida aleatorio
                            equipos.get(i),               // Equipo local
                            equipos.get(j),               // Equipo visitante
                            java.time.LocalDate.now()     // Fecha actual para la partida
                    ));
                }
            }
        }
        return calendario;
    }
}
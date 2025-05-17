package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// Asumo que Circuito, Resultado, Partida, Equipo, Juego, PartidaCarrera y ResultadoCampeonato
// están definidos en el mismo paquete o importados correctamente.

/**
 * Implementación de la interfaz {@link Fase} para un formato de torneo tipo campeonato.
 * <p>
 * Esta clase gestiona la lógica de una fase de campeonato, donde se juegan múltiples
 * carreras (partidas) en diferentes circuitos. Los equipos acumulan puntos
 * según su clasificación en cada carrera, y los avanzadores se determinan
 * por el total de puntos acumulados.
 * </p>
 *
 * @see Fase
 * @see Circuito
 * @see Partida
 * @see Equipo
 * @see Juego
 * @see Resultado
 * @see ResultadoCampeonato
 * @see PartidaCarrera
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class FaseCampeonato implements Fase {

    /**
     * Arreglo constante que define la puntuación otorgada para las primeras posiciones
     * en cada carrera del campeonato.
     */
    private static final int[] PUNTOS = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };

    /**
     * Nombre descriptivo de esta fase del campeonato.
     */
    private final String nombre;

    /**
     * Lista de los {@link Circuito}s en los que se correrán las partidas de esta fase.
     */
    private final List<Circuito> circuitos;

    /**
     * Fecha de inicio de la primera carrera de esta fase del campeonato.
     */
    private final LocalDate fechaInicio;

    /**
     * Intervalo en días entre cada carrera sucesiva de la fase.
     */
    private final long intervaloDias;

    /**
     * Constructor para crear una instancia de {@code FaseCampeonato}.
     *
     * @param nombre        El nombre de la fase del campeonato.
     * @param circuitos     La lista de {@link Circuito}s donde se realizarán las carreras.
     * @param fechaInicio   La fecha de inicio de la primera carrera.
     * @param intervaloDias El número de días entre cada carrera.
     */
    public FaseCampeonato(String nombre, List<Circuito> circuitos, LocalDate fechaInicio,
                          long intervaloDias) {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        this.nombre = nombre;
        this.circuitos = (circuitos != null) ? new ArrayList<>(circuitos) : new ArrayList<>(); // Copia defensiva
        this.fechaInicio = fechaInicio;
        this.intervaloDias = intervaloDias;
    }

    /**
     * {@inheritDoc}
     * <p>Devuelve el nombre de esta fase del campeonato.</p>
     */
    @Override
    public String getNombre() {
        // Debería devolver el atributo 'nombre' de la clase.
        // return null; // Código original
        return this.nombre; // Corrección para el Javadoc y funcionalidad esperada
    }

    /**
     * {@inheritDoc}
     * <p>
     * Genera una lista de partidas (carreras) para esta fase de campeonato.
     * Se crea una {@link PartidaCarrera} para cada circuito definido, asignando
     * fechas sucesivas basadas en la {@code fechaInicio} y el {@code intervaloDias}.
     * Todos los equipos participantes se incluyen en cada carrera.
     * </p>
     * <p>
     * Advierte sobre un cast no chequeado de {@code PartidaCarrera} a {@code Partida<R>}.
     * </p>
     */
    @Override
    @SuppressWarnings("unchecked") // Para el cast de PartidaCarrera a Partida<R>
    public <R extends Resultado> List<Partida<R>> generarPartidas(List<Equipo> participantes, Juego<R> juego) {
        List<Partida<R>> carreras = new ArrayList<>();
        LocalDate fecha = fechaInicio;
        for (Circuito circuito : circuitos) {
            // Asume que PartidaCarrera es compatible con Partida<R> y tiene un constructor adecuado.
            PartidaCarrera carrera = new PartidaCarrera(java.util.UUID.randomUUID().toString(), participantes,
                    circuito, fecha);
            carreras.add((Partida<R>) carrera); // Cast explícito
            fecha = fecha.plusDays(intervaloDias);
        }
        return carreras;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Calcula los equipos que avanzan (o la clasificación final) de esta fase de campeonato
     * basándose en un sistema de puntos.
     * Itera sobre las partidas, obtiene los resultados (asumiendo que son {@link ResultadoCampeonato}),
     * y suma los puntos a cada equipo según su clasificación en cada partida y la tabla {@code PUNTOS}.
     * Finalmente, devuelve una lista de equipos ordenada descendentemente por los puntos totales acumulados.
     * </p>
     */
    @Override
    public <R extends Resultado> List<Equipo> calcularAvanzadores(List<Partida<R>> partidas) {
        Map<Equipo, Integer> tablaPuntos = new HashMap<>();
        for (Partida<R> p : partidas) {
            // Asume que el resultado de la partida es de tipo ResultadoCampeonato.
            ResultadoCampeonato res = (ResultadoCampeonato) p.getResultado(); // Requiere que p.getResultado() devuelva ResultadoCampeonato o una subclase.
            List<Equipo> clasif = res.getClasificacion(); // Asume que ResultadoCampeonato tiene getClasificacion().
            for (int i = 0; i < clasif.size() && i < PUNTOS.length; i++) {
                tablaPuntos.merge(clasif.get(i), PUNTOS[i], Integer::sum);
            }
        }
        // Ordena los equipos por puntos de mayor a menor y devuelve la lista de equipos.
        return tablaPuntos.entrySet().stream()
                .sorted(Map.Entry.<Equipo, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
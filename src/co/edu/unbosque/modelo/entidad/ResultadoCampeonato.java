package co.edu.unbosque.modelo.entidad;

import java.util.List;
import java.util.Map;
// import java.util.ArrayList; // No se usa explícitamente, las listas vienen de fuera
// import java.util.HashMap; // No se usa explícitamente
// import java.io.Serializable; // Considerar añadir si se va a persistir.
// Asumo que Resultado y Equipo están definidos en el mismo paquete o importados.

/**
 * Implementación de la interfaz {@link Resultado} para representar los resultados
 * de una fase o partida de tipo campeonato.
 * <p>
 * Esta clase almacena la clasificación final de los equipos y un mapa de los tiempos
 * (o puntuaciones) obtenidos por cada equipo. Proporciona un método para obtener
 * el ganador basándose en la primera posición de la clasificación.
 * </p>
 *
 * @see Resultado
 * @see Equipo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ResultadoCampeonato implements Resultado /*, Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Lista ordenada de equipos que representa la clasificación final.
     * El primer elemento es el ganador, el segundo es el segundo lugar, y así sucesivamente.
     * Este campo es final y se asigna en el constructor.
     */
    private final List<Equipo> clasificacion;

    /**
     * Mapa que asocia cada {@link Equipo} con su tiempo o puntuación correspondiente
     * en el evento o fase del campeonato.
     * Este campo es final y se asigna en el constructor.
     */
    private final Map<Equipo, Double> tiempos;

    /**
     * Constructor para crear una instancia de {@code ResultadoCampeonato}.
     *
     * @param clasificacion La lista ordenada de {@link Equipo}s según su clasificación final.
     * @param tiempos       Un mapa que contiene los tiempos o puntuaciones de cada {@link Equipo}.
     */
    public ResultadoCampeonato(List<Equipo> clasificacion, Map<Equipo, Double> tiempos) {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        // Se recomienda crear copias defensivas si las listas/mapas pueden ser modificados externamente,
        // pero al ser final y pasados por constructor, se asume que la inmutabilidad se maneja
        // o que el que llama es responsable.
        this.clasificacion = clasificacion; // new ArrayList<>(clasificacion);
        this.tiempos = tiempos;             // new HashMap<>(tiempos);
    }

    /**
     * Obtiene la lista de equipos que representa la clasificación final.
     * El orden de la lista indica la posición (el primero es el ganador).
     *
     * @return Una lista de {@link Equipo}s ordenada por clasificación.
     */
    public List<Equipo> getClasificacion() {
        return clasificacion;
    }

    /**
     * Obtiene el mapa de tiempos o puntuaciones de los equipos.
     * Cada entrada del mapa asocia un {@link Equipo} con su respectivo tiempo/puntuación.
     *
     * @return Un mapa de {@link Equipo} a {@link Double} representando los tiempos/puntuaciones.
     */
    public Map<Equipo, Double> getTiempos() {
        return tiempos;
    }

    /**
     * Obtiene el equipo ganador de este resultado de campeonato.
     * <p>
     * El ganador se determina como el primer equipo en la lista de {@code clasificacion}.
     * </p>
     *
     * @return El {@link Equipo} ganador, o {@code null} si la lista de clasificación está vacía.
     */
    public Equipo getGanador() {
        // Si la lista de clasificación está vacía, devuelve null.
        return (clasificacion != null && !clasificacion.isEmpty()) ? clasificacion.get(0) : null;
    }

    // Los métodos equals(), hashCode() y toString() no están definidos explícitamente
    // en el código proporcionado. Si se añaden, se documentarían aquí.
    // La igualdad podría basarse en la igualdad de las listas de clasificación y los mapas de tiempos.
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoCampeonato that = (ResultadoCampeonato) o;
        return Objects.equals(clasificacion, that.clasificacion) &&
               Objects.equals(tiempos, that.tiempos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clasificacion, tiempos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ResultadoCampeonato{\n");
        sb.append("  Clasificacion:\n");
        if (clasificacion != null) {
            for (int i = 0; i < clasificacion.size(); i++) {
                Equipo eq = clasificacion.get(i);
                sb.append("    ").append(i + 1).append(". ")
                  .append(eq != null ? eq.getNombre() : "N/A") // Asume que Equipo tiene getNombre()
                  .append(" (Tiempo/Puntos: ").append(tiempos != null && tiempos.get(eq) != null ? tiempos.get(eq) : "N/A").append(")\n");
            }
        } else {
            sb.append("    N/A\n");
        }
        sb.append('}');
        return sb.toString();
    }
    */
}
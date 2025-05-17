package co.edu.unbosque.modelo.entidad;

// Asumo que Resultado y Equipo están definidos en el mismo paquete o importados.
// import java.io.Serializable; // Considerar añadir si se va a persistir.
// import java.util.Objects; // Para equals y hashCode si se añaden.

/**
 * Implementación de la interfaz {@link Resultado} para representar los resultados
 * de un partido de FIFA.
 * <p>
 * Esta clase almacena el número de goles anotados por el equipo local y el equipo
 * visitante. Proporciona métodos para acceder a estos marcadores y para determinar
 * el equipo ganador, asumiendo que en el contexto donde se utiliza (ej. playoffs)
 * no se permiten empates.
 * </p>
 *
 * @see Resultado
 * @see Equipo
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ResultadoFifa implements Resultado /*, Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

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
     * Constructor para crear una instancia de {@code ResultadoFifa}.
     *
     * @param golesLocal     El número de goles anotados por el equipo local.
     * @param golesVisitante El número de goles anotados por el equipo visitante.
     */
    public ResultadoFifa(int golesLocal, int golesVisitante) {
        this.golesLocal     = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    /**
     * Obtiene el número de goles anotados por el equipo local.
     * @return Los goles del equipo local.
     */
    public int getGolesLocal()   { return golesLocal; }

    /**
     * Obtiene el número de goles anotados por el equipo visitante.
     * @return Los goles del equipo visitante.
     */
    public int getGolesVisitante(){ return golesVisitante; }

    /**
     * Determina y devuelve el equipo ganador del partido de FIFA.
     * <p>
     * Compara los goles del equipo local y visitante. Se asume que este método
     * se utiliza en contextos donde no se permiten empates (ej. fases de eliminación directa).
     * </p>
     *
     * @param local      El {@link Equipo} que jugó como local.
     * @param visitante  El {@link Equipo} que jugó como visitante.
     * @return El {@link Equipo} ganador.
     * @throws IllegalStateException Si el resultado es un empate, indicando que
     * esta condición no es manejada o permitida en el contexto de uso.
     */
    public Equipo getGanador(Equipo local, Equipo visitante) {
        if (golesLocal > golesVisitante) return local;
        if (golesVisitante > golesLocal) return visitante;
        // El comentario original "Asume que no hay empate en playoffs." se refleja en la excepción.
        throw new IllegalStateException("Empate no permitido en eliminación");
    }

    // Los métodos equals(), hashCode() y toString() no están definidos explícitamente
    // en el código proporcionado. Si se añaden, se documentarían aquí.
    // La igualdad podría basarse en la igualdad de golesLocal y golesVisitante.
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoFifa that = (ResultadoFifa) o;
        return golesLocal == that.golesLocal &&
               golesVisitante == that.golesVisitante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(golesLocal, golesVisitante);
    }

    @Override
    public String toString() {
        return "ResultadoFifa{" +
               "golesLocal=" + golesLocal +
               ", golesVisitante=" + golesVisitante +
               '}';
    }
    */
}
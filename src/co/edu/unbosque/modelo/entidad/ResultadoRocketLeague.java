// ---------------------------
// 5) ResultadoRocketLeague.java
// ---------------------------
package co.edu.unbosque.modelo.entidad;

/** Resultado de Rocket League: goles local, visitante y tiempo extra. */
public class ResultadoRocketLeague implements Resultado {
    private final int golesLocal;
    private final int golesVisitante;
    private final boolean tiempoExtra;

    public ResultadoRocketLeague(int golesLocal, int golesVisitante, boolean tiempoExtra) {
        this.golesLocal     = golesLocal;
        this.golesVisitante = golesVisitante;
        this.tiempoExtra    = tiempoExtra;
    }

    public int getGolesLocal()      { return golesLocal; }
    public int getGolesVisitante()  { return golesVisitante; }
    public boolean isTiempoExtra()  { return tiempoExtra; }

    public Equipo getGanador(Equipo local, Equipo visitante) {
        if (golesLocal > golesVisitante) return local;
        if (golesVisitante > golesLocal) return visitante;
        // define tu criterio de desempate (ej. flipo moneda o repite partido)
        throw new IllegalStateException("Empate no permitido en eliminación");
    }
}

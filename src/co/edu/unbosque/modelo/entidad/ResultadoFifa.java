// ---------------------------
// 4) ResultadoFifa.java
// ---------------------------
package co.edu.unbosque.modelo.entidad;

/** Resultado de un partido de FIFA: goles local y visitante. */
public class ResultadoFifa implements Resultado {
    private final int golesLocal;
    private final int golesVisitante;

    public ResultadoFifa(int golesLocal, int golesVisitante) {
        this.golesLocal    = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public int getGolesLocal()    { return golesLocal; }
    public int getGolesVisitante(){ return golesVisitante; }

    /** Asume que no hay empate en playoffs. */
    public Equipo getGanador(Equipo local, Equipo visitante) {
        if (golesLocal > golesVisitante) return local;
        if (golesVisitante > golesLocal) return visitante;
        throw new IllegalStateException("Empate no permitido en eliminación");
    }
}

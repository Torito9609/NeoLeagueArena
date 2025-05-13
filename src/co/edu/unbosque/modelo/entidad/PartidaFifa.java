// ---------------------------
// 6) PartidaFifa.java
// ---------------------------
package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;

public class PartidaFifa extends Partida<ResultadoFifa> {

    private ResultadoFifa resultado;

    public PartidaFifa(String id, Equipo local, Equipo visitante, LocalDate fecha) {
        super(id, local, visitante, fecha);
    }

    @Override
    protected void aplicarResultado(ResultadoFifa res) {
        this.resultado = res;
    }

    @Override
    public ResultadoFifa getResultado() {
        return resultado;
    }

    /** Devuelve el ganador usando el resultado y equipos. */
    public Equipo getGanador() {
        return resultado.getGanador(getEquipoLocal(), getEquipoVisitante());
    }
}

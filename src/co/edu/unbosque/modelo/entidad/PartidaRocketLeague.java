// ---------------------------
// 7) PartidaRocketLeague.java
// ---------------------------
package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;

public class PartidaRocketLeague extends Partida<ResultadoRocketLeague> {

    private ResultadoRocketLeague resultado;

    public PartidaRocketLeague(String id, Equipo local, Equipo visitante, LocalDate fecha) {
        super(id, local, visitante, fecha);
    }

    @Override
    protected void aplicarResultado(ResultadoRocketLeague res) {
        this.resultado = res;
    }

    @Override
    public ResultadoRocketLeague getResultado() {
        return resultado;
    }

    public Equipo getGanador() {
        return resultado.getGanador(getEquipoLocal(), getEquipoVisitante());
    }
}

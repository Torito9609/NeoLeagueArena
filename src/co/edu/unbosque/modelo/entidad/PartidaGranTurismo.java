package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;

public class PartidaGranTurismo extends Partida<ResultadoGranTurismo> {
	private ResultadoGranTurismo resultado;

	public PartidaGranTurismo(String id, Equipo local, Equipo visitante, LocalDate fecha) {
		super(id, local, visitante, fecha);
	}

	@Override
    protected void aplicarResultado(ResultadoGranTurismo resultado) {
        this.resultado = resultado;
    }

    @Override
    public ResultadoGranTurismo getResultado() {
        return resultado;
    }

}

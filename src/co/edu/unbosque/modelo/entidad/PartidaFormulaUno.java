package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;

public class PartidaFormulaUno extends Partida<ResultadoFormulaUno>{
	private ResultadoFormulaUno resultado;
	
	public PartidaFormulaUno(String id, Equipo local, Equipo visitante, LocalDate fecha) {
        super(id, local, visitante, fecha);
    }
	
	@Override
	protected void aplicarResultado(ResultadoFormulaUno resultado) {
		this.resultado = resultado;
		
	}

	@Override
	public ResultadoFormulaUno getResultado() {
		return resultado;
	}

}

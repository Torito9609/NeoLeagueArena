package co.edu.unbosque.modelo.entidad;

public class ResultadoFifa implements Resultado {
	private int golesLocal;
	private int golesVisitante;

	public ResultadoFifa(int golesLocal, int golesVisitante) {
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}
}

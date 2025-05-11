package co.edu.unbosque.modelo.entidad;

public class ResultadoRocketLeague implements Resultado {
	private int golesLocal;
	private int golesVisitante;
	private boolean tiempoExtra;

	public ResultadoRocketLeague(int golesLocal, int golesVisitante, boolean tiempoExtra) {
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.tiempoExtra = tiempoExtra;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public boolean isTiempoExtra() {
		return tiempoExtra;
	}
}

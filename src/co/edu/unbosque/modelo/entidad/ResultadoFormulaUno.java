package co.edu.unbosque.modelo.entidad;

public class ResultadoFormulaUno implements Resultado {
	private List<Equipo> clasificacion;
	private double tiempoVisitante;

	public ResultadoFormulaUno(double tiempoLocal, double tiempoVisitante) {
		super();
		this.tiempoLocal = tiempoLocal;
		this.tiempoVisitante = tiempoVisitante;
	}

	public double getTiempoLocal() {
		return tiempoLocal;
	}

	public void setTiempoLocal(double tiempoLocal) {
		this.tiempoLocal = tiempoLocal;
	}

	public double getTiempoVisitante() {
		return tiempoVisitante;
	}

	public void setTiempoVisitante(double tiempoVisitante) {
		this.tiempoVisitante = tiempoVisitante;
	}
	
	

}

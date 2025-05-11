
package co.edu.unbosque.modelo.entidad;

public class ResultadoGranTurismo implements Resultado {
	private int vueltasLocal;
	private int vueltasVisitante;

	public ResultadoGranTurismo(int vueltasLocal, int vueltasVisitante) {
		this.vueltasLocal = vueltasLocal;
		this.vueltasVisitante = vueltasVisitante;
	}

	public int getVueltasLocal() {
		return vueltasLocal;
	}

	public int getVueltasVisitante() {
		return vueltasVisitante;
	}

	public void setVueltasLocal(int vueltasLocal) {
		this.vueltasLocal = vueltasLocal;
	}

	public void setVueltasVisitante(int vueltasVisitante) {
		this.vueltasVisitante = vueltasVisitante;
	}
	
	
}

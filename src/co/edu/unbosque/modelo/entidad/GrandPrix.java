package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;

public class GrandPrix {
	private String id;
	private String nombre;
	private Circuito circuito;

	public GrandPrix() {
		super();
	}

	public GrandPrix(String id, String nombre, Circuito circuito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.circuito = circuito;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}
}

package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EquipoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nombre;
	private String idTorneo;

	public EquipoDto() {
	}

	public EquipoDto(String id, String nombre, String idTorneo, List<String> jugadorIds) {
		this.id = id;
		this.nombre = nombre;
		this.idTorneo = idTorneo;
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

	public String getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(String idTorneo) {
		this.idTorneo = idTorneo;
	}

}

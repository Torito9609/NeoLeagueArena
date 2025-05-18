package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import co.edu.unbosque.modelo.enums.EstadoPartida;

public class PartidaFifaDto extends PartidaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String idEquipoLocal;
	private String idEquipoVisitante;
	private LocalDate fecha;
	private EstadoPartida estado;

	public PartidaFifaDto() {}

	public PartidaFifaDto(String id, String idEquipoLocal, String idEquipoVisitante,
	                      LocalDate fecha, EstadoPartida estado) {
		this.id = id;
		this.idEquipoLocal = idEquipoLocal;
		this.idEquipoVisitante = idEquipoVisitante;
		this.fecha = fecha;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public void setIdEquipoLocal(String idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}

	public String getIdEquipoVisitante() {
		return idEquipoVisitante;
	}

	public void setIdEquipoVisitante(String idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public EstadoPartida getEstado() {
		return estado;
	}

	public void setEstado(EstadoPartida estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Getters y Setters
	// ...
}

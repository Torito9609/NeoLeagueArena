package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import co.edu.unbosque.modelo.enums.EstadoPartida;

public class PartidaCarreraDto extends PartidaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private List<String> idParticipantes;
	private String nombreCircuito;
	private LocalDate fecha;
	private EstadoPartida estado;

	public PartidaCarreraDto() {}

	public PartidaCarreraDto(String id, List<String> idParticipantes,
	                         String nombreCircuito, LocalDate fecha, EstadoPartida estado) {
		this.id = id;
		this.idParticipantes = idParticipantes;
		this.nombreCircuito = nombreCircuito;
		this.fecha = fecha;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getIdParticipantes() {
		return idParticipantes;
	}

	public void setIdParticipantes(List<String> idParticipantes) {
		this.idParticipantes = idParticipantes;
	}

	public String getNombreCircuito() {
		return nombreCircuito;
	}

	public void setNombreCircuito(String nombreCircuito) {
		this.nombreCircuito = nombreCircuito;
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

	
}

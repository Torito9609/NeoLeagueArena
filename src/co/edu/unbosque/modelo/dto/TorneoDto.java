package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.enums.EstadoTorneo;

public class TorneoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nombre;
	private String juego;
	private EstadoTorneo estado;
	private String tipoPartida;
	private List<String> idEquiposInscritos;
	private List<PartidaDto> partidas;

	public TorneoDto() {
		this.idEquiposInscritos = new ArrayList<>();
		this.partidas = new ArrayList<>();
	}	

	public String getTipoPartida() {
		return tipoPartida;
	}

	public void setTipoPartida(String tipoPartida) {
		this.tipoPartida = tipoPartida;
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

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public EstadoTorneo getEstado() {
		return estado;
	}

	public void setEstado(EstadoTorneo estado) {
		this.estado = estado;
	}

	public List<String> getIdEquiposInscritos() {
		return idEquiposInscritos;
	}

	public void setIdEquiposInscritos(List<String> idEquiposInscritos) {
		this.idEquiposInscritos = idEquiposInscritos;
	}

	public List<PartidaDto> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<PartidaDto> partidas) {
		this.partidas = partidas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

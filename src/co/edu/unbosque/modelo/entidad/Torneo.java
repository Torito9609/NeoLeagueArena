package co.edu.unbosque.modelo.entidad;

import java.util.List;

import co.edu.unbosque.modelo.enums.EstadoTorneo;

public class Torneo {
	private String id;
	private String nombre;
	private Juego juego;
	private EstadoTorneo estado;
	private List<Equipo> equipos;
	private List<Partida> partidas;
}

package co.edu.unbosque.modelo.entidad;

import java.util.List;

public abstract class Juego {
	private String nombre;
	public abstract List<Partida> generarPartidas(List<Equipo> equipos);
}

package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private String id;
	private String nombre;
	private Torneo torneo;
	private List<Jugador> jugadores = new ArrayList<>();

	public Equipo() {}

	public Equipo(String id, String nombre, Torneo torneo) {
		this.id = id;
		this.nombre = nombre;
		this.torneo = torneo;
	}

	public Equipo(String id, String nombre, Torneo torneo, List<Jugador> jugadores) {
		this(id, nombre, torneo);
		this.jugadores = jugadores != null ? jugadores : new ArrayList<>();
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

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores != null ? jugadores : new ArrayList<>();
	}

	public void agregarJugador(Jugador jugador) {
		if (jugador != null && !jugadores.contains(jugador)) {
			jugadores.add(jugador);
		}
	}

	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Equipo))
			return false;
		Equipo that = (Equipo) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Equipo{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + ", torneo="
				+ (torneo != null ? torneo.getId() : "null") + ", jugadores=" + jugadores.size() + '}';
	}
}

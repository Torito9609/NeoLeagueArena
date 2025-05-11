package co.edu.unbosque.modelo.entidad;

import java.util.List;
import java.util.Objects;

public abstract class Juego<R extends Resultado> {
	private String id;
	private String nombre;

	public Juego() {
	}

	public Juego(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	public abstract List<Partida<R>> generarPartidas(List<Equipo> equipos);

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Juego))
			return false;
		Juego<?> that = (Juego<?>) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Juego{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + '}';
	}
}

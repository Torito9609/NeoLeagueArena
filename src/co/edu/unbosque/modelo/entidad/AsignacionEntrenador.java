package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.Objects;

public class AsignacionEntrenador {
	private String idAsignacion;
	private Entrenador entrenador;
	private Equipo equipo;
	private LocalDate fechaAsignacion;

	public AsignacionEntrenador() {
	}

	public AsignacionEntrenador(String idAsignacion, Entrenador entrenador, Equipo equipo, LocalDate fechaAsignacion) {
		this.idAsignacion = idAsignacion;
		this.entrenador = entrenador;
		this.equipo = equipo;
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(String idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public LocalDate getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDate fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AsignacionEntrenador))
			return false;
		AsignacionEntrenador that = (AsignacionEntrenador) o;
		return Objects.equals(idAsignacion, that.idAsignacion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAsignacion);
	}

	@Override
	public String toString() {
		return "AsignacionEntrenador{" + "idAsignacion='" + idAsignacion + '\'' + ", entrenador="
				+ (entrenador != null ? entrenador.getId() : "null") + ", equipo="
				+ (equipo != null ? equipo.getId() : "null") + ", fechaAsignacion=" + fechaAsignacion + '}';
	}
}

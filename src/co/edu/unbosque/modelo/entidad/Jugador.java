package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;

public class Jugador extends Usuario {

	private NivelCompetitivoJugador nivelCompetitivo;
	private String gamerTag;
	private int rankingPuntos;
	private List<ParticipacionTorneo> historialParticipacion = new ArrayList<>();

	public Jugador() {
		super();
	}

	public Jugador(String id, 
			String nombres, 
			String apellidos, 
			String correo, 
			String celular, 
			String pais,
			String ciudad, 
			LocalDate fechaNacimiento, 
			String zonaHoraria, 
			String passwordHash, 
			String rutaFoto,
			boolean necesitaCambioPassword,
			NivelCompetitivoJugador nivelCompetitivo, 
			String gamerTag,
			int rankingPuntos, 
			List<ParticipacionTorneo> historialParticipacion) {
		super(id, nombres, apellidos, correo, celular, pais, ciudad, fechaNacimiento, zonaHoraria, passwordHash,
				rutaFoto, necesitaCambioPassword);
		this.nivelCompetitivo = nivelCompetitivo;
		this.gamerTag = gamerTag;
		this.rankingPuntos = rankingPuntos;
		this.historialParticipacion = historialParticipacion != null ? historialParticipacion : new ArrayList<>();
	}

	public NivelCompetitivoJugador getNivelCompetitivo() {
		return nivelCompetitivo;
	}

	public void setNivelCompetitivo(NivelCompetitivoJugador nivelCompetitivo) {
		this.nivelCompetitivo = nivelCompetitivo;
	}

	public String getGamerTag() {
		return gamerTag;
	}

	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

	public int getRankingPuntos() {
		return rankingPuntos;
	}

	public void setRankingPuntos(int rankingPuntos) {
		this.rankingPuntos = rankingPuntos;
	}

	public List<ParticipacionTorneo> getHistorialParticipacion() {
		return historialParticipacion;
	}

	public void setHistorialParticipacion(List<ParticipacionTorneo> historialParticipacion) {
		this.historialParticipacion = historialParticipacion != null ? historialParticipacion : new ArrayList<>();
	}

	public void agregarParticipacion(ParticipacionTorneo p) {
		if (p != null && !historialParticipacion.contains(p)) {
			historialParticipacion.add(p);
		}
	}

	public void removerParticipacion(ParticipacionTorneo p) {
		historialParticipacion.remove(p);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Jugador))
			return false;
		return Objects.equals(getId(), ((Jugador) o).getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Jugador{" + "id=" + getId() + ", gamerTag='" + gamerTag + '\'' + ", nivel=" + nivelCompetitivo
				+ ", ranking=" + rankingPuntos + ", edad=" + calcularEdad() + ", participaciones="
				+ historialParticipacion.size() + '}';
	}
}

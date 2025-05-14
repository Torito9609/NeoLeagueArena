package co.edu.unbosque.modelo.entidad;

import java.util.List;

public class Entrenador extends Usuario{
	private String nickname;
	private int aniosExperiencia;
	private String biografia;
	private Juego<?> juegoPrincipalEspecializado;
	private List<AsignacionEntrenador> equiposAsignados;

	public Entrenador() {
	}

	public Entrenador(String nickname, int aniosExperiencia, String biografia, Juego<?> juegoPrincipalEspecializado,
		List<AsignacionEntrenador> equiposAsignados) {
		super();
		this.nickname = nickname;
		this.aniosExperiencia = aniosExperiencia;
		this.biografia = biografia;
		this.juegoPrincipalEspecializado = juegoPrincipalEspecializado;
		this.equiposAsignados = equiposAsignados;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
	public String getBiografia() {
		return biografia;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public Juego<?> getJuegoPrincipalEspecializado() {
		return juegoPrincipalEspecializado;
	}
	
	public void setJuegoPrincipalEspecializado(Juego<?> juegoPrincipalEspecializado) {
		this.juegoPrincipalEspecializado = juegoPrincipalEspecializado;
	}
	
	public List<AsignacionEntrenador> getEquiposAsignados() {
		return equiposAsignados;
	}
	
	public void setEquiposAsignados(List<AsignacionEntrenador> equiposAsignados) {
		this.equiposAsignados = equiposAsignados;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Entrenador [nickname=" + nickname + ", aniosExperiencia=" + aniosExperiencia + ", biografia=" + biografia
				+ ", juegoPrincipalEspecializado=" + juegoPrincipalEspecializado + ", equiposAsignados=" + equiposAsignados
				+ "]";
	}

}
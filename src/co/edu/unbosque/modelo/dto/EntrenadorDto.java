package co.edu.unbosque.modelo.dto;

import java.io.Serializable;

public class EntrenadorDto extends UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nickname;
	private int aniosExperiencia;
	private String biografia;

	public EntrenadorDto() {
		super();
		setTipoUsuario("Entrenador");
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

	@Override
	public String toString() {
		return "EntrenadorDto{" + "id='" + getId() + '\'' + ", nickname='" + nickname + '\'' + ", aniosExperiencia="
				+ aniosExperiencia + ", biografia='" + biografia;
	}
}

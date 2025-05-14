package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.util.List;


public class EntrenadorDto extends UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickname;
    private int aniosExperiencia;
    private String biografia;
    private String juegoPrincipalEspecializado;
    private List<AsignacionEntrenadorDto> equiposAsignados;

    public EntrenadorDto() {
        super();
        setTipoUsuario("Entrenador");
    }

    public EntrenadorDto(
            String id,
            String nombres,
            String apellidos,
            String correo,
            String celular,
            String pais,
            String ciudad,
            java.time.LocalDate fechaNacimiento,
            String zonaHoraria,
            String passwordHash,
            String rutaFoto,
            boolean necesitaCambioPassword,
            String nickname,
            int aniosExperiencia,
            String biografia
    ) {
        super(
            id,
            nombres,
            apellidos,
            correo,
            celular,
            pais,
            ciudad,
            fechaNacimiento,
            zonaHoraria,
            passwordHash,
            rutaFoto,
            necesitaCambioPassword,
            "Entrenador"
        );
        this.nickname = nickname;
        this.aniosExperiencia = aniosExperiencia;
        this.biografia = biografia;
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

    public String getJuegoPrincipalEspecializado() {
        return juegoPrincipalEspecializado;
    }
    public void setJuegoPrincipalEspecializado(String juegoPrincipalEspecializado) {
        this.juegoPrincipalEspecializado = juegoPrincipalEspecializado;
    }

    public List<AsignacionEntrenadorDto> getEquiposAsignados() {
        return equiposAsignados;
    }
    public void setEquiposAsignados(List<AsignacionEntrenadorDto> equiposAsignados) {
        this.equiposAsignados = equiposAsignados;
    }

    @Override
    public String toString() {
        return "EntrenadorDto{" +
               "id='" + getId() + '\'' +
               ", nickname='" + nickname + '\'' +
               ", aniosExperiencia=" + aniosExperiencia +
               ", biografia='" + biografia + '\'' +
               ", juegoPrincipalEspecializado='" + juegoPrincipalEspecializado + '\'' +
               ", equiposAsignados=" + equiposAsignados +
               '}';
    }
}

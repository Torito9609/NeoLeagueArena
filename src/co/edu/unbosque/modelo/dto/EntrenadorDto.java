package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO para la entidad Entrenador. Hereda los campos comunes de UsuarioDTO
 * y añade los específicos de Entrenador.
 */
public class EntrenadorDto extends UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickname;
    private int aniosExperiencia;
    private String biografia;
    /**
     * Para simplicidad aquí guardamos sólo el identificador o nombre del juego.
     * Si necesitas más campos, podrías usar un JuegoDTO.
     */
    private String juegoPrincipalEspecializado;

    /**
     * Lista de asignaciones (cada una podría ser AsignacionEntrenadorDTO).
     * Así no mezclas la entidad en tu DTO.
     */
    private List<AsignacionEntrenadorDto> equiposAsignados;

    public EntrenadorDto() {
        super();
    }

    public EntrenadorDto(String id,
                         String nombres,
                         String apellidos,
                         String correo,
                         String celular,
                         String pais,
                         String ciudad,
                         String zonaHoraria,
                         String passwordHash,
                         String rutaFoto,
                         boolean necesitaCambioPassword,
                         String tipoUsuario,                  // "Entrenador"
                         String nickname,
                         int aniosExperiencia,
                         String biografia,
                         String juegoPrincipalEspecializado,
                         List<AsignacionEntrenadorDto> equiposAsignados) {
        super(id, nombres, apellidos, correo, celular,
              pais, ciudad, zonaHoraria, passwordHash,
              rutaFoto, necesitaCambioPassword, tipoUsuario);
        this.nickname = nickname;
        this.aniosExperiencia = aniosExperiencia;
        this.biografia = biografia;
        this.juegoPrincipalEspecializado = juegoPrincipalEspecializado;
        this.equiposAsignados = equiposAsignados;
    }

    // Getters y setters

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
}

package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
// Asumo que UsuarioDto está en el mismo paquete o importado correctamente.
// import co.edu.unbosque.modelo.dto.UsuarioDto;

/**
 * DTO (Data Transfer Object) para representar la información de un Entrenador.
 * <p>
 * Esta clase extiende {@link UsuarioDto} y añade atributos específicos
 * del rol de entrenador, como nickname, años de experiencia y biografía.
 * Se utiliza para transferir datos de entrenadores entre las capas de la aplicación.
 * </p>
 *
 * @see UsuarioDto
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class EntrenadorDto extends UsuarioDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Alias o apodo público del entrenador en la comunidad.
     */
    private String nickname;

    /**
     * Número de años de experiencia profesional del entrenador.
     */
    private int aniosExperiencia;

    /**
     * Texto descriptivo sobre el entrenador, su trayectoria o filosofía.
     */
    private String biografia;

    /**
     * Constructor por defecto.
     * Inicializa el DTO y establece el tipo de usuario como "Entrenador"
     * mediante una llamada al método {@code setTipoUsuario} heredado de {@link UsuarioDto}.
     */
    public EntrenadorDto() {
        super(); // Llama al constructor de UsuarioDto
        setTipoUsuario("Entrenador");
    }

    /**
     * Obtiene el nickname del entrenador.
     * @return El nickname del entrenador.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Establece el nickname del entrenador.
     * @param nickname El nuevo nickname del entrenador.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Obtiene los años de experiencia del entrenador.
     * @return Los años de experiencia.
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece los años de experiencia del entrenador.
     * @param aniosExperiencia Los nuevos años de experiencia.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene la biografía del entrenador.
     * @return La biografía del entrenador.
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Establece la biografía del entrenador.
     * @param biografia La nueva biografía del entrenador.
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * Devuelve una representación en cadena de este {@code EntrenadorDto}.
     * Incluye el ID (heredado), nickname, años de experiencia y biografía.
     * @return Una cadena que representa el DTO.
     */
    @Override
    public String toString() {
        // La cadena original del código del usuario es:
        // "EntrenadorDto{" + "id='" + getId() + '\'' + ", nickname='" + nickname + '\'' + ", aniosExperiencia="
		//		+ aniosExperiencia + ", biografia='" + biografia;
        // Para un toString() completo, normalmente se cerraría con '}'
        return "EntrenadorDto{" +
               "id='" + getId() + '\'' +
               ", nickname='" + nickname + '\'' +
               ", aniosExperiencia=" + aniosExperiencia +
               ", biografia='" + biografia +
               "'}"; // Corregido para Javadoc, el código original del usuario no tiene el '}'
    }
}
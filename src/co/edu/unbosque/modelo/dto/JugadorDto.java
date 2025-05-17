package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
// import java.time.LocalDate; // No se usa directamente en los campos de esta clase, pero sí en UsuarioDto
// import java.util.ArrayList; // No se usa
// import java.util.List; // No se usa
import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;

/**
 * DTO (Data Transfer Object) para representar la información de un Jugador.
 * <p>
 * Esta clase extiende {@link UsuarioDto} y añade atributos específicos
 * del rol de jugador, como su nivel competitivo, gamerTag (alias) y puntos de ranking.
 * Se utiliza para transferir datos de jugadores entre las capas de la aplicación.
 * </p>
 *
 * @see UsuarioDto
 * @see NivelCompetitivoJugador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class JugadorDto extends UsuarioDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Nivel competitivo actual del jugador.
     * Se define mediante el enum {@link NivelCompetitivoJugador}.
     */
    private NivelCompetitivoJugador nivelCompetitivo;

    /**
     * Alias o nombre público del jugador utilizado en los juegos y torneos.
     */
    private String gamerTag;

    /**
     * Puntuación actual del jugador en el sistema de ranking.
     */
    private int rankingPuntos;

    /**
     * Constructor por defecto.
     * Inicializa el DTO y establece el tipo de usuario como "Jugador"
     * mediante una llamada al método {@code setTipoUsuario} heredado de {@link UsuarioDto}.
     */
    public JugadorDto() {
        super(); // Llama al constructor de UsuarioDto
        setTipoUsuario("Jugador");
    }

    // Nota: El constructor con parámetros que inicializa todos los campos
    // (incluyendo los de UsuarioDto) no está presente en el código proporcionado.

    /**
     * Obtiene el nivel competitivo del jugador.
     * @return El nivel competitivo del jugador, como un valor del enum {@link NivelCompetitivoJugador}.
     */
    public NivelCompetitivoJugador getNivelCompetitivo() {
        return nivelCompetitivo;
    }

    /**
     * Establece el nivel competitivo del jugador.
     * @param nivelCompetitivo El nuevo nivel competitivo del jugador.
     */
    public void setNivelCompetitivo(NivelCompetitivoJugador nivelCompetitivo) {
        this.nivelCompetitivo = nivelCompetitivo;
    }

    /**
     * Obtiene el gamerTag (alias) del jugador.
     * @return El gamerTag del jugador.
     */
    public String getGamerTag() {
        return gamerTag;
    }

    /**
     * Establece el gamerTag (alias) del jugador.
     * @param gamerTag El nuevo gamerTag del jugador.
     */
    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    /**
     * Obtiene los puntos de ranking del jugador.
     * @return Los puntos de ranking del jugador.
     */
    public int getRankingPuntos() {
        return rankingPuntos;
    }

    /**
     * Establece los puntos de ranking del jugador.
     * @param rankingPuntos Los nuevos puntos de ranking del jugador.
     */
    public void setRankingPuntos(int rankingPuntos) {
        this.rankingPuntos = rankingPuntos;
    }

    /**
     * Devuelve una representación en cadena de este {@code JugadorDto}.
     * Incluye el ID (heredado), gamerTag, nivel competitivo y puntos de ranking.
     * @return Una cadena que representa el DTO.
     */
    @Override
    public String toString() {
        // Cuidado: El String de salida está incompleto, le falta el '}' al final.
        // Lo corregiré en esta documentación para reflejar un toString completo.
        return "JugadorDto{" +
               "id='" + getId() + '\'' + // Heredado de UsuarioDto
               ", gamerTag='" + gamerTag + '\'' +
               ", nivelCompetitivo=" + nivelCompetitivo +
               ", rankingPuntos=" + rankingPuntos +
               "}"; // Corregido para Javadoc, el código original del usuario no tiene el '}'
    }
}
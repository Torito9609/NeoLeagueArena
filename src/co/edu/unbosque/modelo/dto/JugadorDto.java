package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;

public class JugadorDto extends UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private NivelCompetitivoJugador nivelCompetitivo;
    private String gamerTag;
    private int rankingPuntos;
    private List<ParticipacionTorneoDto> historialParticipacion = new ArrayList<>();

    public JugadorDto() {
        super();
        setTipoUsuario("Jugador");
    }

    public JugadorDto(
            String id,
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
            List<ParticipacionTorneoDto> historialParticipacion
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
            "Jugador"
        );
        this.nivelCompetitivo = nivelCompetitivo;
        this.gamerTag = gamerTag;
        this.rankingPuntos = rankingPuntos;
        this.historialParticipacion = historialParticipacion != null
            ? historialParticipacion
            : new ArrayList<>();
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

    public List<ParticipacionTorneoDto> getHistorialParticipacion() {
        return historialParticipacion;
    }

    public void setHistorialParticipacion(List<ParticipacionTorneoDto> historialParticipacion) {
        this.historialParticipacion = historialParticipacion != null
            ? historialParticipacion
            : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "JugadorDto{" +
               "id='" + getId() + '\'' +
               ", gamerTag='" + gamerTag + '\'' +
               ", nivelCompetitivo=" + nivelCompetitivo +
               ", rankingPuntos=" + rankingPuntos +
               ", historialParticipacion=" + historialParticipacion.size() +
               '}';
    }
}

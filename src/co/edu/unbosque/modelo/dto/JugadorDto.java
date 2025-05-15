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
    
    public JugadorDto() {
    	super();
    	setTipoUsuario("Jugador");
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

    @Override
    public String toString() {
        return "JugadorDto{" +
               "id='" + getId() + '\'' +
               ", gamerTag='" + gamerTag + '\'' +
               ", nivelCompetitivo=" + nivelCompetitivo +
               ", rankingPuntos=" + rankingPuntos;
    }
}

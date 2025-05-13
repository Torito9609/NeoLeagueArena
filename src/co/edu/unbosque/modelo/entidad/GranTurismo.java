package co.edu.unbosque.modelo.entidad;

import java.util.List;

/**
 * Gran Turismo como Juego de campeonato:
 * la fase (FaseCampeonato) se encarga de crear las carreras
 * con fechas dinámicas según el calendario cargado.
 */
public class GranTurismo extends Juego<ResultadoCampeonato> {

    /**
     * @param id     identificador único (p. ej. "gt")
     * @param nombre nombre legible (p. ej. "Gran Turismo Sport e-sports")
     */
    public GranTurismo(String id, String nombre) {
        super(id, nombre);
    }

    /**
     * No se usan emparejamientos 1-vs-1: las carreras las genera la fase.
     * Si se llama aquí, es un uso indebido.
     */
    @Override
    public List<Partida<ResultadoCampeonato>> generarPartidas(List<Equipo> equipos) {
        throw new UnsupportedOperationException(
            "Para Gran Turismo, usa FaseCampeonato con lista de GPs y fechas dinámicas"
        );
    }
}

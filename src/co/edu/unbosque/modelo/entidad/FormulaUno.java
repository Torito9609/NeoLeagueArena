package co.edu.unbosque.modelo.entidad;

import java.util.List;

/**
 * Fórmula 1 como Juego: ya no se encarga de generar sus carreras,
 * esa responsabilidad recae sobre la FaseCampeonato (que añade fechas dinámicas).
 */
public class FormulaUno extends Juego<ResultadoCampeonato> {

    /**
     * @param id     identificador único (p. ej. "f1")
     * @param nombre nombre legible (p. ej. "F1 e-sports 2025")
     */
    public FormulaUno(String id, String nombre) {
        super(id, nombre);
    }

    /**
     * La generación de partidas (carreras) se hace en la fase de campeonato,
     * porque allí se calculan las fechas dinámicas a partir de la fecha de inicio
     * y el intervalo entre Grand Prix. 
     * Si alguien llama directamente a este método, es un uso incorrecto.
     */
    @Override
    public List<Partida<ResultadoCampeonato>> generarPartidas(List<Equipo> equipos) {
        throw new UnsupportedOperationException(
            "Para F1, usa FaseCampeonato con la lista de GrandPrix y fechas dinámicas"
        );
    }
}

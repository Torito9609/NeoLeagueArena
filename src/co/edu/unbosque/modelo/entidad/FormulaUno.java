package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FormulaUno extends Juego<ResultadoFormulaUno> {

    public FormulaUno(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public List<Partida<ResultadoFormulaUno>> generarPartidas(List<Equipo> equipos) {
        List<Partida<ResultadoFormulaUno>> calendario = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                calendario.add(
                	new PartidaFormulaUno(UUID.randomUUID().toString(),
                    equipos.get(i),
                    equipos.get(j),
                    hoy
                ));
            }
        }
        return calendario;
    }
}

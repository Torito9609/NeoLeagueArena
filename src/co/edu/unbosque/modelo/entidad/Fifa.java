// ---------------------------
// 8) Fifa.java
// ---------------------------
package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** Juego FIFA: implementa round‐robin 1-vs-1. */
public class Fifa extends Juego<ResultadoFifa> {

    public Fifa(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public List<Partida<ResultadoFifa>> generarPartidas(List<Equipo> equipos) {
        List<Partida<ResultadoFifa>> calendario = new ArrayList<>();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                calendario.add(new PartidaFifa(
                    UUID.randomUUID().toString(),
                    equipos.get(i),
                    equipos.get(j),
                    java.time.LocalDate.now()  // o pasa fecha externa
                ));
            }
        }
        return calendario;
    }
}

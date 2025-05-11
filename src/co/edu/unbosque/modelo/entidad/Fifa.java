package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Fifa extends Juego<ResultadoFifa>{
	
	public Fifa(String id, String nombre) {
        super(id, nombre);
    }

	@Override
	public List<Partida<ResultadoFifa>> generarPartidas(List<Equipo> equipos) {
		List<Partida<ResultadoFifa>> calendario = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                calendario.add(
                	new PartidaFifa(UUID.randomUUID().toString(),
                    equipos.get(i),
                    equipos.get(j),
                    hoy
                ));
            }
        }
        return calendario;
	}


}

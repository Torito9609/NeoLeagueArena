package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GranTurismo extends Juego<ResultadoGranTurismo> {

	public GranTurismo(String id, String nombre) {
		super(id, nombre);
	}

	@Override
	public List<Partida<ResultadoGranTurismo>> generarPartidas(List<Equipo> equipos) {
		List<Partida<ResultadoGranTurismo>> calendario = new ArrayList<>();
		LocalDate hoy = LocalDate.now();
		for (int i = 0; i < equipos.size(); i++) {
			for (int j = i + 1; j < equipos.size(); j++) {
				calendario
						.add(new PartidaGranTurismo(UUID.randomUUID().toString(), equipos.get(i), equipos.get(j), hoy));
			}
		}
		return calendario;
	}

}

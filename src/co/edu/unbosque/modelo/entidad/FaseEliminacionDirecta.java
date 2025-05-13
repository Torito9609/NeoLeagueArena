package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Fase de bracket de eliminación directa: empareja primero vs último, segundo
 * vs penúltimo, etc. Requiere que Juego.generarPartidas(...) funcione para
 * listas de tamaño 2.
 */
public class FaseEliminacionDirecta implements Fase {

	private final String nombre;

	public FaseEliminacionDirecta(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public <R extends Resultado> List<Partida<R>> generarPartidas(List<Equipo> equipos, Juego<R> juego) {

		List<Partida<R>> bracket = new ArrayList<>();
		int n = equipos.size();
		for (int i = 0; i < n / 2; i++) {
			Equipo local = equipos.get(i);
			Equipo visitante = equipos.get(n - 1 - i);

			// Reutilizamos el round-robin de Juego para 2 equipos:
			List<Equipo> pareja = new ArrayList<>();
			pareja.add(local);
			pareja.add(visitante);

			List<Partida<R>> partidos = juego.generarPartidas(pareja);
			if (!partidos.isEmpty()) {
				// siempre habrá exactamente 1 partido para 2 equipos
				bracket.add(partidos.get(0));
			}
		}
		return bracket;
	}

	@Override
	public <R extends Resultado> List<Equipo> calcularAvanzadores(List<Partida<R>> partidas) {

		List<Equipo> ganadores = new ArrayList<>();
		for (Partida<R> p : partidas) {
			ganadores.add(p.getGanador());
		}
		return ganadores;
	}
}

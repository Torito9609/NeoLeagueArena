package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FaseCampeonato implements Fase {

	private static final int[] PUNTOS = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };
	private final String nombre;
	private final List<Circuito> circuitos;
	private final LocalDate fechaInicio;
	private final long intervaloDias;

	public FaseCampeonato(String nombre, List<Circuito> circuitos, LocalDate fechaInicio,
			long intervaloDias) {
		super();
		this.nombre = nombre;
		this.circuitos = circuitos;
		this.fechaInicio = fechaInicio;
		this.intervaloDias = intervaloDias;
	}

	@Override
	public String getNombre() {
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <R extends Resultado> List<Partida<R>> generarPartidas(List<Equipo> participantes, Juego<R> juego) {

		List<Partida<R>> carreras = new ArrayList<>();
		LocalDate fecha = fechaInicio;
		for (Circuito circuito : circuitos) {
			PartidaCarrera carrera = new PartidaCarrera(java.util.UUID.randomUUID().toString(), participantes,
					circuito, fecha);
			carreras.add((Partida<R>) carrera);
			fecha = fecha.plusDays(intervaloDias);
		}
		return carreras;
	}

	@Override
	public <R extends Resultado> List<Equipo> calcularAvanzadores(List<Partida<R>> partidas) {
		Map<Equipo, Integer> tablaPuntos = new HashMap<>();
		for (Partida<R> p : partidas) {
			ResultadoCampeonato res = (ResultadoCampeonato) p.getResultado();
			List<Equipo> clasif = res.getClasificacion();
			for (int i = 0; i < clasif.size() && i < PUNTOS.length; i++) {
				tablaPuntos.merge(clasif.get(i), PUNTOS[i], Integer::sum);
			}
		}
		return tablaPuntos.entrySet().stream().sorted(Map.Entry.<Equipo, Integer>comparingByValue().reversed())
				.map(Map.Entry::getKey).collect(Collectors.toList());
	}

}

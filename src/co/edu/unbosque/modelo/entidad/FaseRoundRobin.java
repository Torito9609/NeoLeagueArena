package co.edu.unbosque.modelo.entidad;

import java.util.*;

public class FaseRoundRobin implements Fase {

    private final String nombre;

    public FaseRoundRobin(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Partida<?>> generarPartidas(List<Equipo> equipos, Juego<?> juego) {
        return new ArrayList<>(juego.generarPartidas(equipos)); // se permite return List<? extends Partida<?>> como List<Partida<?>>
    }

    @Override
    public List<Equipo> calcularAvanzadores(List<Partida<?>> partidas) {
        Map<Equipo, Integer> victorias = new HashMap<>();

        for (Partida<?> p : partidas) {
            Equipo local = p.getEquipoLocal();
            Equipo visitante = p.getEquipoVisitante();

            victorias.putIfAbsent(local, 0);
            victorias.putIfAbsent(visitante, 0);

            Equipo ganador = p.getGanador();
            victorias.put(ganador, victorias.get(ganador) + 1);
        }

        return victorias.entrySet().stream()
                .sorted(Map.Entry.<Equipo, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }
}

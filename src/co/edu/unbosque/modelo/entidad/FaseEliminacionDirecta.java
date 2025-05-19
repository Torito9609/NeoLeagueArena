package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

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
    public List<Partida<?>> generarPartidas(List<Equipo> equipos, Juego<?> juego) {
        List<Partida<?>> bracket = new ArrayList<>();
        int n = equipos.size();

        for (int i = 0; i < n / 2; i++) {
            Equipo local = equipos.get(i);
            Equipo visitante = equipos.get(n - 1 - i);

            List<Equipo> pareja = List.of(local, visitante);
            List<? extends Partida<?>> partidos = juego.generarPartidas(pareja);
            if (!partidos.isEmpty()) {
                bracket.add(partidos.get(0)); // 1 partido por pareja
            }
        }
        return bracket;
    }

    @Override
    public List<Equipo> calcularAvanzadores(List<Partida<?>> partidas) {
        List<Equipo> ganadores = new ArrayList<>();
        for (Partida<?> p : partidas) {
            ganadores.add(p.getGanador());
        }
        return ganadores;
    }
}

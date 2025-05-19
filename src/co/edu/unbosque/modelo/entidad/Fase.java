package co.edu.unbosque.modelo.entidad;

import java.util.List;

public interface Fase {

    String getNombre();

    List<Partida<?>> generarPartidas(List<Equipo> participantes, Juego<?> juego);

    List<Equipo> calcularAvanzadores(List<Partida<?>> partidas);
}

package co.edu.unbosque.modelo.entidad;

import java.util.List;

public interface Fase {

	String getNombre();

	<R extends Resultado> List<Partida<R>> generarPartidas(List<Equipo> participantes, Juego<R> juego);

	<R extends Resultado> List<Equipo> calcularAvanzadores(List<Partida<R>> partidas);

}

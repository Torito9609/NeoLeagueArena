package co.edu.unbosque.modelo.entidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Fase de liga (Round Robin): todos contra todos.
 * Genera los partidos delegando en Juego.generarPartidas(...)
 * y ordena los equipos por número de victorias.
 */
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
    public <R extends Resultado> List<Partida<R>> generarPartidas(
            List<Equipo> equipos, 
            Juego<R> juego
    ) {
        // Delegamos al juego: crea todos los enfrentamientos 1-vs-1
        return juego.generarPartidas(equipos);
    }

    @Override
    public <R extends Resultado> List<Equipo> calcularAvanzadores(
            List<Partida<R>> partidas
    ) {
        // 1) Contar victorias por equipo
        Map<Equipo, Integer> victorias = new HashMap<>();
        for (Partida<R> p : partidas) {
            Equipo local     = p.getEquipoLocal();
            Equipo visitante = p.getEquipoVisitante();
            // Aseguramos inicialización en 0
            if (!victorias.containsKey(local)) {
                victorias.put(local, 0);
            }
            if (!victorias.containsKey(visitante)) {
                victorias.put(visitante, 0);
            }
            // Incrementar victoria del ganador
            Equipo ganador = p.getGanador();
            victorias.put(ganador, victorias.get(ganador) + 1);
        }

        // 2) Ordenar equipos por victorias descendente
        List<Map.Entry<Equipo,Integer>> entradas =
            new ArrayList<>(victorias.entrySet());
        Collections.sort(entradas, new Comparator<Map.Entry<Equipo,Integer>>() {
            @Override
            public int compare(Map.Entry<Equipo,Integer> e1,
                               Map.Entry<Equipo,Integer> e2) {
                // Descendente: e2 - e1
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        // 3) Extraer la lista de equipos en ese orden
        List<Equipo> tablaOrdenada = new ArrayList<>();
        for (Map.Entry<Equipo,Integer> entry : entradas) {
            tablaOrdenada.add(entry.getKey());
        }
        return tablaOrdenada;
    }
}

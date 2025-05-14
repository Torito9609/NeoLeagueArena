package co.edu.unbosque.modelo.entidad;

import java.util.List;
import java.util.Objects;

public abstract class Juego<R extends Resultado> {

    private String id;
    private String nombre;

    public Juego() { }
    public Juego(String id, String nombre) {
        this.id     = id;
        this.nombre = nombre;
    }

    public String getId()     { return id; }
    public String getNombre(){ return nombre; }

    /** Round-Robin por defecto; subclases de "partido 1-vs-1" lo implementan. */
    public abstract List<Partida<R>> generarPartidas(List<Equipo> equipos);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juego)) return false;
        return Objects.equals(id, ((Juego<?>)o).id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

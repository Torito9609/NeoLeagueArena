package co.edu.unbosque.modelo.dto;

import java.io.Serializable;

public class JuegoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String tipoJuego;

    public JuegoDto() { }

    public JuegoDto(String id, String nombre, String tipoJuego) {
        this.id = id;
        this.nombre = nombre;
        this.tipoJuego = tipoJuego;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoJuego() {
        return tipoJuego;
    }
    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    @Override
    public String toString() {
        return "JuegoDto{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", tipoJuego='" + tipoJuego + '\'' +
               '}';
    }
}

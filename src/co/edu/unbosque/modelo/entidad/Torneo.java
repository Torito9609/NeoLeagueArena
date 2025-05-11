package co.edu.unbosque.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.EstadoTorneo;

/**
 * Representa un torneo de un juego específico.  
 * La relación Equipo–Torneo se maneja vía ParticipacionTorneo.
 */
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único del torneo */
    private String id;

    /** Nombre descriptivo */
    private String nombre;

    /** Juego al que pertenece este torneo */
    private Juego juego;

    /** Estado actual (PLANIFICACIÓN, ABIERTO, FINALIZADO, etc.) */
    private EstadoTorneo estado;

    /**
     * Participaciones de equipos en este torneo.
     * Cada ParticipacionTorneo liga un Equipo con este Torneo.
     */
    private List<ParticipacionTorneo> participaciones = new ArrayList<>();

    /** Partidas jugadas en el marco de este torneo */
    private List<Partida> partidas = new ArrayList<>();

    public Torneo() { }

    public Torneo(String id,
                  String nombre,
                  Juego juego,
                  EstadoTorneo estado) {
        this.id     = id;
        this.nombre = nombre;
        this.juego  = juego;
        this.estado = estado;
    }

    public Torneo(String id,
                  String nombre,
                  Juego juego,
                  EstadoTorneo estado,
                  List<ParticipacionTorneo> participaciones,
                  List<Partida> partidas) {
        this(id, nombre, juego, estado);
        this.participaciones = participaciones != null
            ? participaciones
            : new ArrayList<>();
        this.partidas = partidas != null
            ? partidas
            : new ArrayList<>();
    }

    // —— Getters y setters ——

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

    public Juego getJuego() {
        return juego;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public EstadoTorneo getEstado() {
        return estado;
    }
    public void setEstado(EstadoTorneo estado) {
        this.estado = estado;
    }

    public List<ParticipacionTorneo> getParticipaciones() {
        return participaciones;
    }
    public void setParticipaciones(List<ParticipacionTorneo> participaciones) {
        this.participaciones = participaciones != null
            ? participaciones
            : new ArrayList<>();
    }

    public List<Partida> getPartidas() {
        return partidas;
    }
    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas != null
            ? partidas
            : new ArrayList<>();
    }

    // —— Métodos de conveniencia ——

    /**
     * Inscribe un equipo en el torneo.
     */
    public void inscribirEquipo(ParticipacionTorneo participacion) {
        if (participacion != null && 
            participacion.getTorneo().equals(this) &&
            !participaciones.contains(participacion)) {
            participaciones.add(participacion);
        }
    }

    /**
     * Quita la inscripción de un equipo.
     */
    public void removerParticipacion(ParticipacionTorneo participacion) {
        participaciones.remove(participacion);
    }

    /**
     * Devuelve la lista de equipos inscritos actualmente.
     */
    public List<Equipo> listarEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        for (ParticipacionTorneo p : participaciones) {
            equipos.add(p.getEquipo());
        }
        return equipos;
    }

    // —— equals/hashCode basados en id ——

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torneo)) return false;
        Torneo that = (Torneo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // —— toString para depuración ——

    @Override
    public String toString() {
        return "Torneo{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", juego=" + (juego != null ? juego.getNombre() : "null") +
               ", estado=" + estado +
               ", equiposInscritos=" + participaciones.size() +
               ", partidas=" + partidas.size() +
               '}';
    }
}

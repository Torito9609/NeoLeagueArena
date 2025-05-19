package co.edu.unbosque.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.EstadoTorneo;

public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private Juego<?> juego;
    private EstadoTorneo estado;
    private List<ParticipacionTorneo> participaciones = new ArrayList<>();
    private List<Fase> fases = new ArrayList<>();
    private List<Partida<?>> partidas = new ArrayList<>();

    public Torneo() { }

    public Torneo(String id, String nombre, Juego<?> juego, EstadoTorneo estado) {
        this.id = id;
        this.nombre = nombre;
        this.juego = juego;
        this.estado = estado;
    }

    // —— Getters y Setters ——

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

    public Juego<?> getJuego() {
        return juego;
    }

    public void setJuego(Juego<?> juego) {
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
        this.participaciones = participaciones != null ? participaciones : new ArrayList<>();
    }

    public List<Fase> getFases() {
        return fases;
    }

    public void setFases(List<Fase> fases) {
        this.fases = fases != null ? fases : new ArrayList<>();
    }

    public List<Partida<?>> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida<?>> partidas) {
        this.partidas = partidas != null ? partidas : new ArrayList<>();
    }

    // —— Gestión de Participaciones ——

    public void inscribirEquipo(ParticipacionTorneo p) {
        if (p != null && p.getTorneo().equals(this) && !participaciones.contains(p)) {
            participaciones.add(p);
        }
    }

    public void removerParticipacion(ParticipacionTorneo p) {
        participaciones.remove(p);
    }

    public List<Equipo> listarEquipos() {
        List<Equipo> lista = new ArrayList<>();
        for (ParticipacionTorneo p : participaciones) {
            lista.add(p.getEquipo());
        }
        return lista;
    }

    // —— Lógica de ejecución del torneo ——

    public void ejecutarTorneo() {
        List<Equipo> actuales = listarEquipos();
        partidas.clear();

        for (Fase fase : fases) {
            List<Partida<?>> fasePartidas = fase.generarPartidas(actuales, juego);
            partidas.addAll(fasePartidas);
            actuales = fase.calcularAvanzadores(fasePartidas);
        }

        estado = EstadoTorneo.FINALIZADO;
    }

    // —— Métodos estándar ——

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

    @Override
    public String toString() {
        return "Torneo{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", juego=" + (juego != null ? juego.getNombre() : "null") +
               ", estado=" + estado +
               ", inscritos=" + participaciones.size() +
               ", fases=" + fases.size() +
               ", partidas=" + partidas.size() +
               '}';
    }
}

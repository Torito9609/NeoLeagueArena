package co.edu.unbosque.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.EstadoTorneo;

public class Torneo<R extends Resultado> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private Juego<R> juego;
    private EstadoTorneo estado;
    private List<ParticipacionTorneo> participaciones = new ArrayList<>();
    private List<Fase> fases = new ArrayList<>();
    private List<Partida<R>> partidas = new ArrayList<>();

    public Torneo() { }

    public Torneo(String id, String nombre, Juego<R> juego, EstadoTorneo estado) {
        this.id     = id;
        this.nombre = nombre;
        this.juego  = juego;
        this.estado = estado;
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

    public Juego<R> getJuego() {
        return juego;
    }
    public void setJuego(Juego<R> juego) {
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

    public List<Fase> getFases() {
        return fases;
    }
    public void setFases(List<Fase> fases) {
        this.fases = fases != null
            ? fases
            : new ArrayList<>();
    }

    public List<Partida<R>> getPartidas() {
        return partidas;
    }
    public void setPartidas(List<Partida<R>> partidas) {
        this.partidas = partidas != null
            ? partidas
            : new ArrayList<>();
    }

    // —— Inscripción de equipos ——

    /** Inscribe un equipo (vía ParticipacionTorneo) en el torneo */
    public void inscribirEquipo(ParticipacionTorneo p) {
        if (p != null
         && p.getTorneo().equals(this)
         && !participaciones.contains(p)) {
            participaciones.add(p);
        }
    }

    /** Elimina la inscripción de un equipo */
    public void removerParticipacion(ParticipacionTorneo p) {
        participaciones.remove(p);
    }

    /** Devuelve la lista de equipos actualmente inscritos */
    public List<Equipo> listarEquipos() {
        List<Equipo> lista = new ArrayList<>();
        for (ParticipacionTorneo p : participaciones) {
            lista.add(p.getEquipo());
        }
        return lista;
    }

    // —— Ejecución del torneo ——

    /**
     * Ejecuta todas las fases en orden:
     *  1) Genera las partidas de la fase
     *  2) (aquí se registrarían resultados)
     *  3) Calcula avanzadores
     *  4) Repite hasta acabar
     */
    public void ejecutarTorneo() {
        List<Equipo> actuales = listarEquipos();
        partidas.clear();

        for (Fase fase : fases) {
            // 1) Generar partidas para esta fase
            List<Partida<R>> fasePartidas = fase.generarPartidas(actuales, juego);

            // 2) (El registro de resultados se haría externamente, 
            //    antes de calcular avanzadores)
            partidas.addAll(fasePartidas);

            // 3) Extraer avanzadores
            actuales = fase.calcularAvanzadores(fasePartidas);
        }

        // 4) Marcar torneo como finalizado
        estado = EstadoTorneo.FINALIZADO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torneo)) return false;
        Torneo<?> that = (Torneo<?>) o;
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

package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.Objects;

public class ParticipacionTorneo{
    private String idParticipacion;
    private Equipo equipo;
    private Torneo torneo;
    private LocalDate fechaInscripcion;

    public ParticipacionTorneo() { }

    public ParticipacionTorneo(String idParticipacion,
                               Equipo equipo,
                               Torneo torneo,
                               LocalDate fechaInscripcion) {
        this.idParticipacion = idParticipacion;
        this.equipo          = equipo;
        this.torneo          = torneo;
        this.fechaInscripcion = fechaInscripcion;
    }


    public String getIdParticipacion() {
        return idParticipacion;
    }
    public void setIdParticipacion(String idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Torneo getTorneo() {
        return torneo;
    }
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipacionTorneo)) return false;
        ParticipacionTorneo that = (ParticipacionTorneo) o;
        return Objects.equals(idParticipacion, that.idParticipacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipacion);
    }

    @Override
    public String toString() {
        return "ParticipacionTorneo{" +
               "idParticipacion='" + idParticipacion + '\'' +
               ", equipo=" + (equipo != null ? equipo.getId() : "null") +
               ", torneo=" + (torneo != null ? torneo.getId() : "null") +
               ", fechaInscripcion=" + fechaInscripcion +
               '}';
    }
}

package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ParticipacionTorneoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idParticipacion;
    private String idEquipo;
    private String idTorneo;
    private LocalDate fechaInscripcion;

    public ParticipacionTorneoDto() { }

    public ParticipacionTorneoDto(
            String idParticipacion,
            String idEquipo,
            String idTorneo,
            LocalDate fechaInscripcion
    ) {
        this.idParticipacion = idParticipacion;
        this.idEquipo        = idEquipo;
        this.idTorneo        = idTorneo;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getIdParticipacion() {
        return idParticipacion;
    }
    public void setIdParticipacion(String idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public String getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdTorneo() {
        return idTorneo;
    }
    public void setIdTorneo(String idTorneo) {
        this.idTorneo = idTorneo;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "ParticipacionTorneoDto{" +
               "idParticipacion='" + idParticipacion + '\'' +
               ", idEquipo='" + idEquipo + '\'' +
               ", idTorneo='" + idTorneo + '\'' +
               ", fechaInscripcion=" + fechaInscripcion +
               '}';
    }
}

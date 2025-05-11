package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class AsignacionEntrenadorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idAsignacion;
    private String idEntrenador;
    private String idEquipo;
    private LocalDate fechaAsignacion;

    public AsignacionEntrenadorDto() { }

    public AsignacionEntrenadorDto(
            String idAsignacion,
            String idEntrenador,
            String idEquipo,
            LocalDate fechaAsignacion
    ) {
        this.idAsignacion   = idAsignacion;
        this.idEntrenador   = idEntrenador;
        this.idEquipo       = idEquipo;
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }
    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }
    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }
    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Override
    public String toString() {
        return "AsignacionEntrenadorDto{" +
               "idAsignacion='" + idAsignacion + '\'' +
               ", idEntrenador='" + idEntrenador + '\'' +
               ", idEquipo='" + idEquipo + '\'' +
               ", fechaAsignacion=" + fechaAsignacion +
               '}';
    }
}

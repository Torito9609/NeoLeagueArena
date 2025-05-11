package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO para AsignacionEntrenador: representa la relación
 * entre un Entrenador y un Equipo, sin referenciar entidades
 * directamente, solo sus identificadores.
 */
public class AsignacionEntrenadorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único de la asignación (p.ej. UUID) */
    private String idAsignacion;

    /** ID del entrenador asignado */
    private String idEntrenador;

    /** ID del equipo al que se asigna */
    private String idEquipo;

    /** Fecha en que se realizó la asignación */
    private LocalDate fechaAsignacion;

    public AsignacionEntrenadorDto() { }

    public AsignacionEntrenadorDto(String idAsignacion,
                                   String idEntrenador,
                                   String idEquipo,
                                   LocalDate fechaAsignacion) {
        this.idAsignacion   = idAsignacion;
        this.idEntrenador   = idEntrenador;
        this.idEquipo       = idEquipo;
        this.fechaAsignacion = fechaAsignacion;
    }

    // —— Getters y setters ——

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

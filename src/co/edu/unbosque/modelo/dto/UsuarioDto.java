package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String celular;
    private String pais;
    private String ciudad;
    private LocalDate fechaNacimiento;
    private String zonaHoraria;
    private String passwordHash;
    private String rutaFoto;
    private boolean necesitaCambioPassword;
    private String tipoUsuario;

    // Getters y setters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public boolean isNecesitaCambioPassword() {
        return necesitaCambioPassword;
    }
    public void setNecesitaCambioPassword(boolean necesitaCambioPassword) {
        this.necesitaCambioPassword = necesitaCambioPassword;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
               "id='" + id + '\'' +
               ", nombres='" + nombres + '\'' +
               ", apellidos='" + apellidos + '\'' +
               ", correo='" + correo + '\'' +
               ", tipoUsuario='" + tipoUsuario + '\'' +
               '}';
    }
}

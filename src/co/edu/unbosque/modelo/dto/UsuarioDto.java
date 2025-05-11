package co.edu.unbosque.modelo.dto;

import java.io.Serializable;

/**
 * DTO base para todos los usuarios del sistema.
 * Incluye los atributos comunes y un campo tipoUsuario
 * para identificar si es "Entrenador", "Jugador", etc.
 */
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String celular;
    private String pais;
    private String ciudad;
    private String zonaHoraria;
    private String passwordHash;
    private String rutaFoto;
    private boolean necesitaCambioPassword;

    /** Para saber si al deserializar o en la vista es Entrenador, Jugador, etc. */
    private String tipoUsuario;  

    public UsuarioDto() { }

    public UsuarioDto(String id,
                      String nombres,
                      String apellidos,
                      String correo,
                      String celular,
                      String pais,
                      String ciudad,
                      String zonaHoraria,
                      String passwordHash,
                      String rutaFoto,
                      boolean necesitaCambioPassword,
                      String tipoUsuario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.pais = pais;
        this.ciudad = ciudad;
        this.zonaHoraria = zonaHoraria;
        this.passwordHash = passwordHash;
        this.rutaFoto = rutaFoto;
        this.necesitaCambioPassword = necesitaCambioPassword;
        this.tipoUsuario = tipoUsuario;
    }

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
}

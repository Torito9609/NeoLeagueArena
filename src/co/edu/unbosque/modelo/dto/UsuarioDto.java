package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
// import java.util.Objects; // No se usa Objects.equals o .hash aquí

/**
 * DTO (Data Transfer Object) base para representar la información de un Usuario del sistema.
 * <p>
 * Esta clase contiene los atributos comunes a todos los tipos de usuarios
 * y se utiliza para transferir datos de usuarios entre las diferentes capas
 * de la aplicación. Es la superclase de DTOs más específicos como
 * {@code EntrenadorDto} y {@code JugadorDto}.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class UsuarioDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del usuario.
     */
    private String id;

    /**
     * Nombres del usuario.
     */
    private String nombres;

    /**
     * Apellidos del usuario.
     */
    private String apellidos;

    /**
     * Dirección de correo electrónico del usuario.
     */
    private String correo;

    /**
     * Número de teléfono celular del usuario.
     */
    private String celular;

    /**
     * País de residencia o nacionalidad del usuario.
     */
    private String pais;

    /**
     * Ciudad de residencia del usuario.
     */
    private String ciudad;

    /**
     * Fecha de nacimiento del usuario.
     */
    private LocalDate fechaNacimiento;

    /**
     * Zona horaria del usuario (ej. "GMT-5").
     */
    private String zonaHoraria;

    /**
     * Hash de la contraseña del usuario. No se almacena la contraseña en texto plano.
     */
    private String passwordHash;

    /**
     * Ruta o URL a la imagen de perfil del usuario.
     */
    private String rutaFoto;

    /**
     * Indicador de si el usuario necesita cambiar su contraseña en el próximo inicio de sesión.
     * {@code true} si necesita cambio, {@code false} en caso contrario.
     */
    private boolean necesitaCambioPassword;

    /**
     * Cadena que identifica el tipo de usuario (ej. "Administrador", "Entrenador", "Jugador").
     */
    private String tipoUsuario;

    // Constructores no están presentes en el fragmento de código proporcionado.
    // Si existieran, se documentarían aquí. Ejemplo:
    /*
    public UsuarioDto() {}

    public UsuarioDto(String id, String nombres, String apellidos, String correo, String celular,
                      String pais, String ciudad, LocalDate fechaNacimiento, String zonaHoraria,
                      String passwordHash, String rutaFoto, boolean necesitaCambioPassword, String tipoUsuario) {
        this.id = id;
        this.nombres = nombres;
        // ... y así sucesivamente para todos los campos
        this.tipoUsuario = tipoUsuario;
    }
    */

    /**
     * Obtiene el ID del usuario.
     * @return El ID del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id El nuevo ID del usuario.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres del usuario.
     * @return Los nombres del usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     * @param nombres Los nuevos nombres del usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene los apellidos del usuario.
     * @return Los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     * @param apellidos Los nuevos apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo El nuevo correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de celular del usuario.
     * @return El número de celular del usuario.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del usuario.
     * @param celular El nuevo número de celular del usuario.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtiene el país del usuario.
     * @return El país del usuario.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del usuario.
     * @param pais El nuevo país del usuario.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la ciudad del usuario.
     * @return La ciudad del usuario.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del usuario.
     * @param ciudad La nueva ciudad del usuario.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     * @return La fecha de nacimiento del usuario.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     * @param fechaNacimiento La nueva fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la zona horaria del usuario.
     * @return La zona horaria del usuario.
     */
    public String getZonaHoraria() {
        return zonaHoraria;
    }

    /**
     * Establece la zona horaria del usuario.
     * @param zonaHoraria La nueva zona horaria del usuario.
     */
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    /**
     * Obtiene el hash de la contraseña del usuario.
     * @return El hash de la contraseña.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Establece el hash de la contraseña del usuario.
     * @param passwordHash El nuevo hash de la contraseña.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Obtiene la ruta o URL de la foto de perfil del usuario.
     * @return La ruta de la foto de perfil.
     */
    public String getRutaFoto() {
        return rutaFoto;
    }

    /**
     * Establece la ruta o URL de la foto de perfil del usuario.
     * @param rutaFoto La nueva ruta de la foto de perfil.
     */
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    /**
     * Verifica si el usuario necesita cambiar su contraseña.
     * @return {@code true} si el usuario necesita cambiar la contraseña, {@code false} de lo contrario.
     */
    public boolean isNecesitaCambioPassword() {
        return necesitaCambioPassword;
    }

    /**
     * Establece el indicador de necesidad de cambio de contraseña.
     * @param necesitaCambioPassword {@code true} si necesita cambio, {@code false} de lo contrario.
     */
    public void setNecesitaCambioPassword(boolean necesitaCambioPassword) {
        this.necesitaCambioPassword = necesitaCambioPassword;
    }

    /**
     * Obtiene el tipo de usuario.
     * @return El tipo de usuario (ej. "Administrador", "Entrenador", "Jugador").
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     * @param tipoUsuario El nuevo tipo de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Devuelve una representación en cadena de este {@code UsuarioDto}.
     * Incluye id, nombres, apellidos, correo y tipo de usuario.
     * @return Una cadena que representa el DTO.
     */
    @Override
    public String toString() {
        return "UsuarioDTO{" + // Nombre de clase original
               "id='" + id + '\'' +
               ", nombres='" + nombres + '\'' +
               ", apellidos='" + apellidos + '\'' +
               ", correo='" + correo + '\'' +
               ", tipoUsuario='" + tipoUsuario + '\'' +
               '}';
    }
}
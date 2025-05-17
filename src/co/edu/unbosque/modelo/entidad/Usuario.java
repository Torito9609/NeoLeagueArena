package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.time.Period;
// import java.io.Serializable; // Considerar añadir si no está ya en una superclase o si se persiste directamente.
// import java.util.Objects; // No se usa Objects.equals o .hash aquí explícitamente, hereda de Object.

/**
 * Representa un Usuario genérico dentro del sistema.
 * <p>
 * Esta clase entidad contiene la información común a todos los usuarios,
 * como sus datos personales, de contacto y credenciales. Sirve como
 * superclase para entidades más específicas como {@link Entrenador} y {@link Jugador}.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Usuario /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

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
     * Ruta del sistema de archivos o URL a la imagen de perfil del usuario.
     */
    private String rutaFoto;

    /**
     * Indicador de si el usuario necesita cambiar su contraseña en el próximo inicio de sesión.
     * {@code true} si necesita cambio, {@code false} en caso contrario.
     */
    private boolean necesitaCambioPassword;

    /**
     * Constructor por defecto.
     * Llama al constructor de la superclase {@link Object}.
     */
    public Usuario() {
        super(); // Llamada al constructor de Object, es implícita si se omite.
    }

    /**
     * Constructor para crear una instancia de {@code Usuario} con todos sus atributos.
     *
     * @param id                     El identificador único del usuario.
     * @param nombres                Los nombres del usuario.
     * @param apellidos              Los apellidos del usuario.
     * @param correo                 El correo electrónico del usuario.
     * @param celular                El número de celular del usuario.
     * @param pais                   El país del usuario.
     * @param ciudad                 La ciudad del usuario.
     * @param fechaNacimiento        La fecha de nacimiento del usuario.
     * @param zonaHoraria            La zona horaria del usuario.
     * @param passwordHash           El hash de la contraseña del usuario.
     * @param rutaFoto               La ruta a la foto de perfil del usuario.
     * @param necesitaCambioPassword Indicador de si el usuario debe cambiar su contraseña.
     */
    public Usuario(String id, String nombres, String apellidos, String correo, String celular, String pais,
                   String ciudad, LocalDate fechaNacimiento, String zonaHoraria, String passwordHash, String rutaFoto,
                   boolean necesitaCambioPassword) {
        super(); // Llamada al constructor de Object, es implícita si se omite.
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.pais = pais;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.zonaHoraria = zonaHoraria;
        this.passwordHash = passwordHash;
        this.rutaFoto = rutaFoto;
        this.necesitaCambioPassword = necesitaCambioPassword;
    }

    /**
     * Calcula la edad actual del usuario basándose en su {@code fechaNacimiento}.
     *
     * @return La edad del usuario en años, o 0 si la fecha de nacimiento es {@code null}.
     */
    public int calcularEdad() {
        LocalDate fn = getFechaNacimiento();
        return (fn == null) ? 0 : Period.between(fn, LocalDate.now()).getYears();
    }

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

    // Los métodos equals(), hashCode() y toString() no están definidos explícitamente.
    // Heredará la implementación de Object a menos que se sobrescriban.
    // Un toString() típico podría ser:
    /*
    @Override
    public String toString() {
        return "Usuario{" +
               "id='" + id + '\'' +
               ", nombres='" + nombres + '\'' +
               ", apellidos='" + apellidos + '\'' +
               ", correo='" + correo + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    */
}
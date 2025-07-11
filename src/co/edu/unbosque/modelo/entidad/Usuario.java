package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {

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

	public Usuario() {
		super();
	}

	public Usuario(String id, String nombres, String apellidos, String correo, String celular, String pais,
			String ciudad, LocalDate fechaNacimiento, String zonaHoraria, String passwordHash, String rutaFoto,
			boolean necesitaCambioPassword) {
		super();
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

	public int calcularEdad() {
		LocalDate fn = getFechaNacimiento();
		return (fn == null) ? 0 : Period.between(fn, LocalDate.now()).getYears();
	}

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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}

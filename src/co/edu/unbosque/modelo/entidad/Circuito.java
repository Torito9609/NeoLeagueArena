package co.edu.unbosque.modelo.entidad;

public class Circuito {
	private String id;
	private String nombre;
	private String rutaFoto;

	public Circuito(String id, String nombre, String rutaFoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rutaFoto = rutaFoto;
	}
	
	

	public Circuito() {
		super();
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

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

}

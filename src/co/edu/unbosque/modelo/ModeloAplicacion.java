package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.servicio.UsuarioService;

public class ModeloAplicacion {
	private UsuarioService usuarioService;
	
	public ModeloAplicacion() {
		usuarioService = new UsuarioService();
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
}

package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.servicio.EntrenadorService;
import co.edu.unbosque.modelo.servicio.JugadorService;
import co.edu.unbosque.modelo.servicio.UsuarioService;
import co.edu.unbosque.vista.admin.VistaAdmin;

public class AdminController implements ActionListener {
	private VistaAdmin vistaAdmin;
	private Map<String, Runnable> comandos;
	private UsuarioService usuarioService;
	private EntrenadorService entrenadorService;
	private JugadorService jugadorService;

	public AdminController() {
		vistaAdmin = new VistaAdmin();
		comandos = new HashMap<>();
		try {
			usuarioService = new UsuarioService();
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
		}
		registrarComandos();
		asignaOyentesPanelLateral();
	}

	private void registrarComandos() {
		comandos.put("GESTIONAR_USUARIOS", this::mostrarPanelUsuarios);
		comandos.put("GESTIONAR_EQUIPOS", this::mostrarPanelEquipos);
		comandos.put("GESTIONAR_TORNEOS", this::mostrarPanelTorneos);
		comandos.put("GESTIONAR_PARTIDAS", this::mostrarPanelPartidas);
		comandos.put("ANALISIS_REPORTES", this::mostrarPanelReportes);
		comandos.put("MODULO_NOTIFICACIONES", this::mostrarPanelNotificaciones);
		comandos.put("IR_A_INICIO", this::mostrarPanelInicio);
		comandos.put("CERRAR_SESION", this::cerrarSesion);
		comandos.put("BUSCAR_POR", this::buscarPorOpcion);
		comandos.put("BUSCAR", this::buscarUsuario);
		comandos.put("FILTRO_POR", this::filtrarPorOpcion);
		comandos.put("FILTRO_TIPO", this::filtrarPorTipoUsuario);
		comandos.put("FILTRO_PAIS", this::filtrarPorPais);
		comandos.put("FILTRO_CIUDAD", this::filtrarPorCiudad);
		comandos.put("CREAR_USUARIO", this::mostrarVentanaCrearUsuario);
		comandos.put("CREAR_GUARDAR_USUARIO", this::crearGuardarUsuario);
		comandos.put("CANCELAR_GUARDAR_USUARIO", this::cancelarGuardarUsuario);
		comandos.put("EDITAR_GUARDAR_USUARIO", this::editarGuardarUsuario);
		comandos.put("SELECCIONAR_TIPO_USUARIO", this::mostrarPanelDinamicoUsuario);

	}

	private void asignaOyentesPanelLateral() {
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getGestionarTorneoBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getGestionarEquipoBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getGestionarUsuarioBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getGestionarPartidaBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getAnalisisReportesBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getModuloNotificacionesBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getInicioBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelLateral().getCerrarSesionBtn().addActionListener(this);

	}

	// ---------------------------------- GESTION DE USUARIOS --------------------------------------------------------------------------------------------//
	private void mostrarPanelUsuarios() {
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(), "USUARIOS");
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getFiltroComboBox().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(true);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().getCrearButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().getEditarButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().getEliminarButton().addActionListener(this);
	}

	private String buscarPorOpcion() {
		return vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().getSelectedItem().toString();
	}

	private void buscarUsuario() {
		String opcion = buscarPorOpcion();

		switch (opcion.trim().toLowerCase()) {
		case "nombre":
			buscarUsuarioPorNombre();
			break;
		case "cedula":
			buscarUsuarioPorCedula();
			break;
		case "correo":
			buscarUsuarioPorCorreo();
			break;
		default:
			vistaAdmin.mostrarMensajeError("Por favor seleccione un criterio de busqueda.");
		}
	}

	private void buscarUsuarioPorCorreo() {
		// TODO Auto-generated method stub

	}

	private void buscarUsuarioPorCedula() {
		// TODO Auto-generated method stub

	}

	private void buscarUsuarioPorNombre() {
		// TODO Auto-generated method stub

	}

	private void filtrarPorOpcion() {
		String tipo = vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getFiltroComboBox().getSelectedItem().toString();
		switch(tipo.trim().toLowerCase()) {
		case  "tipo usuario" :
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().mostrarFiltroPorTipo();
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getTipoUsuarioComboBox().addActionListener(this);
			break;
		case "ciudad" :
			ArrayList<String> ciudades = new ArrayList<String> ();
			ciudades.add("1");
			ciudades.add("12");
			ciudades.add("3");
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().mostrarFiltroCiudad(ciudades);
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getCiudadComboBox().addActionListener(this);
			break;
		case "pais" :
			ArrayList<String> paises = new ArrayList<String> ();
			paises.add("1");
			paises.add("12");
			paises.add("3");
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().mostrarFiltroPais(paises);
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getPaisComboBox().addActionListener(this);
			break;
		case "seleccionar" :
			vistaAdmin.getVentanaPrincipal().getPanelBusqueda().limpiarFiltroDinamico();
			break;
		default:
			vistaAdmin.mostrarMensajeError("Seleccione una opcion valida.");
	}
	}

	private void filtrarPorTipoUsuario() {
		
	}

	private void filtrarPorPais() {

	}

	private void filtrarPorCiudad() {

	}
	
	private void mostrarVentanaCrearUsuario() {
		vistaAdmin.getVentanaCreacionUsuario().setVisible(true);
		vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getSeleccionarFotoButton().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCrearButton().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getEditarButton().setVisible(false);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCancelarButton().addActionListener(this);		
	}
	
	private void cancelarGuardarUsuario() {
		vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
	}
	
	private void crearGuardarUsuario() {
		
	}
	
	private void editarGuardarUsuario() {
		
	}
	
	private void mostrarPanelDinamicoUsuario() {
		
	}

	// ------------------------------------------- GESTION DE USUARIOS  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE EQUIPOS  -------------------------------------------------------------------//

	private void mostrarPanelEquipos() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
	}
	
	// ------------------------------------------- GESTION DE EQUIPOS  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE TORNEOS  -------------------------------------------------------------------//

	private void mostrarPanelTorneos() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
	}
	
	// ------------------------------------------- GESTION DE TORNEOS  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE PARTIDAS  -------------------------------------------------------------------//

	private void mostrarPanelPartidas() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
	}
	
	// ------------------------------------------- GESTION DE PARTIDAS  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE REPORTES  -------------------------------------------------------------------//

	private void mostrarPanelReportes() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(),
				"ANALISIS");
	}
	
	// ------------------------------------------- GESTION DE REPORTES  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE NOTIFICACIONES  -------------------------------------------------------------------//

	private void mostrarPanelNotificaciones() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(),
				"NOTIFICACIONES");
	}
	
	// ------------------------------------------- GESTION DE NOTIFICACIONES  -------------------------------------------------------------------//

	private void mostrarPanelInicio() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(),
				"INICIO");
	}

	private void cerrarSesion() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		Runnable action = comandos.get(comando);
		System.out.println(comando);
		if (action != null) {
			action.run();
		} else {
			System.out.println("Comando no reconocido.");
		}

	}
}

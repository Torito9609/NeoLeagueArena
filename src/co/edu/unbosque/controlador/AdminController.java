package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.vista.admin.VistaAdmin;

public class AdminController implements ActionListener {
	private VistaAdmin vistaAdmin;
	private Map<String, Runnable> comandos;

	public AdminController() {
		vistaAdmin = new VistaAdmin();
		comandos = new HashMap<>();
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

	// ------------------------------------------- GESTION DE USUARIOS  -------------------------------------------------------------------//

	private void mostrarPanelEquipos() {

	}

	private void mostrarPanelTorneos() {

	}

	private void mostrarPanelPartidas() {

	}

	private void mostrarPanelReportes() {
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(),
				"ANALISIS");
	}

	private void mostrarPanelNotificaciones() {
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(),
				"NOTIFICACIONES");
	}

	private void mostrarPanelInicio() {
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(),
				"INICIO");
	}

	private void cerrarSesion() {

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

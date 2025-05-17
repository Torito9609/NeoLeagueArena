package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.EntrenadorMapHandler;
import co.edu.unbosque.modelo.mapper.JugadorMapHandler;
import co.edu.unbosque.modelo.mapper.UsuarioMapHandler;
import co.edu.unbosque.modelo.servicio.EntrenadorService;
import co.edu.unbosque.modelo.servicio.JugadorService;
import co.edu.unbosque.modelo.servicio.UsuarioService;
import co.edu.unbosque.utils.Encriptador;
import co.edu.unbosque.vista.admin.PanelEntrenador;
import co.edu.unbosque.vista.admin.PanelJugador;
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
			entrenadorService = new EntrenadorService();
			jugadorService = new JugadorService();
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
		}
		registrarComandos();
		asignaOyentesPanelLateral();
		System.out.println("xc");	
		System.out.println("Prueba de github con Miguel");
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
		comandos.put("CREAR_GUARDAR_USUARIO", () -> {
			try {
				int confirmacion = vistaAdmin.mostrarMensajeConfirmacion("¿Esta seguro que desea crear el usuario?");
				
				if(confirmacion == JOptionPane.YES_OPTION) {
					crearGuardarUsuario();
					reiniciarTablaUsuarios();
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
				}else {
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
					return;
				}		
			} catch (AccesoDatosException e) {
				vistaAdmin.mostrarMensajeAdvertencia(e.getMessage());
			}
		});
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
	
	private void reiniciarTablaUsuarios() {
		List<UsuarioDto> todosUsuarios = new ArrayList<UsuarioDto>();
		try {
			for(Usuario u : usuarioService.obtenerTodos()) {
				System.out.println(u.getClass());
				//todosUsuarios.add(UsuarioMapHandler.convertirADto(u));
			}
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
		}
		
		vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(todosUsuarios);
	}
	
	private void mostrarPanelUsuarios() {
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(), "USUARIOS");
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getFiltroComboBox().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(true);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().getCrearButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().getEditarButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelInferior().getEliminarButton().addActionListener(this);
		reiniciarTablaUsuarios();
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
	
	private void crearGuardarUsuario() throws AccesoDatosException {
		String tipoUsuario = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().getSelectedItem().toString().toLowerCase();
		switch(tipoUsuario) {
			case "entrenador":
				String id = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getIdField().getText().trim();
				String nombres = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getNombreField().getText().trim();
				String apellidos = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getApellidoField().getText().trim();
				String correo = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getCorreoField().getText().trim();
				String celular = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getCelularField().getText().trim();
				String pais = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getPaisComboBox().getSelectedItem().toString();
				String ciudad = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getCiudadComboBox().getSelectedItem().toString();
				String fechaString = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getFechaNacimientoField().getText().toString().trim();
				LocalDate fechaNacimiento = LocalDate.parse(fechaString);
				String zonaHoraria = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getZonaHorariaComboBox().getSelectedItem().toString();
				String passworHash = Encriptador.encriptarSHA256(nombres+apellidos+id+"*");
				String rutaFoto = "";
				boolean necesitaCambioPassword = true;
				PanelEntrenador panelEntrenador = (PanelEntrenador) vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getPanelActual();
				String nickName = panelEntrenador.getNickNameField().getText().toString().trim();
				int aniosExp = Integer.parseInt(panelEntrenador.getAniosXpField().getText().trim());
				String biografia = panelEntrenador.getBioTextArea().getText().trim();
				String tipoUsuarioE = "Entrenador";
				
				EntrenadorDto entrenadorDto= new EntrenadorDto();
				
				entrenadorDto.setId(id);
				entrenadorDto.setNombres(nombres);
				entrenadorDto.setApellidos(apellidos);
				entrenadorDto.setCorreo(correo);
				entrenadorDto.setCelular(celular);
				entrenadorDto.setPais(pais);
				entrenadorDto.setCiudad(ciudad);
				entrenadorDto.setFechaNacimiento(fechaNacimiento);
				entrenadorDto.setZonaHoraria(zonaHoraria);
				entrenadorDto.setPasswordHash(passworHash);
				entrenadorDto.setRutaFoto(rutaFoto);
				entrenadorDto.setNecesitaCambioPassword(necesitaCambioPassword);
				entrenadorDto.setNickname(nickName);
				entrenadorDto.setAniosExperiencia(aniosExp);
				entrenadorDto.setBiografia(biografia);
				entrenadorDto.setTipoUsuario(tipoUsuario);
				
				entrenadorService.crearEntrenador(EntrenadorMapHandler.convertirAEntidad(entrenadorDto), passworHash);
				break;
				
			case "jugador" :
				String idJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getIdField().getText().trim();
				String nombresJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getNombreField().getText().trim();
				String apellidosJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getApellidoField().getText().trim();
				String correoJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getCorreoField().getText().trim();
				String celularJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getCelularField().getText().trim();
				String paisJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getPaisComboBox().getSelectedItem().toString();
				String ciudadJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getCiudadComboBox().getSelectedItem().toString();
				String fechaStringJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getFechaNacimientoField().getText().toString().trim();
				LocalDate fechaNacimientoJ = LocalDate.parse(fechaStringJ);
				String zonaHorariaJ = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getZonaHorariaComboBox().getSelectedItem().toString();
				String passworHashJ = Encriptador.encriptarSHA256(nombresJ.split(" ")[0] + apellidosJ.split(" ")[0] + idJ + "*");
				String rutaFotoJ = "";
				boolean necesitaCambioPasswordJ = true;
				PanelJugador panelJugador = (PanelJugador) vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getPanelActual();
				NivelCompetitivoJugador nivel = NivelCompetitivoJugador.valueOf(panelJugador.getNivelCompetitivoComboBox().getSelectedItem().toString());
				String gamerTag = panelJugador.getGamerTagField().getText().trim();
				int rankingPuntos = Integer.parseInt(panelJugador.getRankingPuntosField().getText().trim());
				String tipoUsuarioJ = "Jugador";
				
				JugadorDto jugadorDto = new JugadorDto();
				
				jugadorDto.setId(idJ);
				jugadorDto.setNombres(nombresJ);
				jugadorDto.setApellidos(apellidosJ);
				jugadorDto.setCorreo(correoJ);
				jugadorDto.setCelular(celularJ);
				jugadorDto.setPais(paisJ);
				jugadorDto.setCiudad(ciudadJ);
				jugadorDto.setFechaNacimiento(fechaNacimientoJ);
				jugadorDto.setZonaHoraria(zonaHorariaJ);
				jugadorDto.setPasswordHash(passworHashJ);
				jugadorDto.setRutaFoto(rutaFotoJ);
				jugadorDto.setNecesitaCambioPassword(necesitaCambioPasswordJ);
				jugadorDto.setNivelCompetitivo(nivel);
				jugadorDto.setGamerTag(gamerTag);
				jugadorDto.setRankingPuntos(rankingPuntos);
				jugadorDto.setTipoUsuario(tipoUsuarioJ);
				
				jugadorService.crearJugador(JugadorMapHandler.convertirAEntidad(jugadorDto), passworHashJ);
				break;
		}
		
	}
	
	private void editarGuardarUsuario() {
		
	}
	
	private void mostrarPanelDinamicoUsuario() {
		String tipoUsuario = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().getSelectedItem().toString();
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().mostrarPanel(tipoUsuario);	
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

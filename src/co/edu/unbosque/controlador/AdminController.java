package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.RegistroDuplicadoException;
import co.edu.unbosque.modelo.exception.RegistroNoEncontradoException;
import co.edu.unbosque.modelo.mapper.EntrenadorMapHandler;
import co.edu.unbosque.modelo.mapper.JugadorMapHandler;
import co.edu.unbosque.modelo.mapper.UsuarioMapHandler;
import co.edu.unbosque.modelo.servicio.EntrenadorService;
import co.edu.unbosque.modelo.servicio.JugadorService;
import co.edu.unbosque.modelo.servicio.UsuarioService;
import co.edu.unbosque.modelo.utils.Encriptador;
import co.edu.unbosque.vista.admin.PanelEntrenador;
import co.edu.unbosque.vista.admin.PanelJugador;
import co.edu.unbosque.vista.admin.PanelUsuarioSuperior;
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
		comandos.put("BUSCAR", this::buscarUsuario);
		comandos.put("LIMPIAR_FILTROS", this::limpiarFiltrosBusqueda);
		comandos.put("FILTRO_POR", this::filtrarPorOpcion);
		comandos.put("FILTRO_TIPO", this::filtrarPorTipoUsuario);
		comandos.put("FILTRO_PAIS", this::filtrarPorPais);
		comandos.put("FILTRO_CIUDAD", this::filtrarPorCiudad);
		comandos.put("CREAR_USUARIO", this::mostrarVentanaCrearUsuario);
		comandos.put("EDITAR_USUARIO", this::mostrarVentanaEdicionUsuario);
		comandos.put("CREAR_GUARDAR_USUARIO", this::crearGuardarUsuario);
		comandos.put("CANCELAR_GUARDAR_USUARIO", this::cancelarGuardarUsuario);
		comandos.put("EDITAR_GUARDAR_USUARIO", this::editarGuardarUsuario);
		comandos.put("ELIMINAR_USUARIO", this::eliminarUsuario);
		comandos.put("SELECCIONAR_TIPO_USUARIO", this::mostrarPanelDinamicoUsuario);
		comandos.put("CREAR_EQUIPO", this::mostrarVentanaCreacionEquipo);
		comandos.put("MOSTRAR_PANEL_INICIO_TORNEO", this::mostraVentanaIniciarTorneo);

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
				String tipo = u.getClass().getName();
				//System.out.println(tipo);
				switch(tipo) {
					case "Entrenador":
						todosUsuarios.add(EntrenadorMapHandler.convertirADto((Entrenador)u));
						break;
					case "Jugador":
						todosUsuarios.add(JugadorMapHandler.convertirADto((Jugador)u));
						break;
					default:
						todosUsuarios.add(UsuarioMapHandler.convertirADto(u));
				}
				//System.out.println(UsuarioMapHandler.convertirADto(u).getTipoUsuario());
			}
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
		}
		
		vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(todosUsuarios);
	}
	
	private void limpiarFiltrosBusqueda() {
		reiniciarTablaUsuarios();
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().setText("");
		//vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getTipoUsuarioComboBox().setSelectedIndex(0);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getFiltroComboBox().setSelectedIndex(0);
	}
	
	private boolean validarDatosFormularioUsuarios() {
	    PanelUsuarioSuperior panel = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior();

	    String id = panel.getIdField().getText().trim();
	    String nombres = panel.getNombreField().getText().trim();
	    String apellidos = panel.getApellidoField().getText().trim();
	    String correo = panel.getCorreoField().getText().trim();
	    String celular = panel.getCelularField().getText().trim();
	    String fechaNacimiento = panel.getFechaNacimientoField().getText().trim();

	    String pais = panel.getPaisComboBox().getSelectedItem().toString();
	    String ciudad = panel.getCiudadComboBox().getSelectedItem().toString();
	    String zonaHoraria = panel.getZonaHorariaComboBox().getSelectedItem().toString();
	    String tipoUsuario = panel.getTipoUsuarioComboBox().getSelectedItem().toString();

	    if (id.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty()
	            || celular.isEmpty() || fechaNacimiento.isEmpty()) {
	        vistaAdmin.mostrarMensajeError("Todos los campos de texto deben estar completos.");
	        return false;
	    }

	    if (!id.matches("\\d+")) {
	        vistaAdmin.mostrarMensajeError("El ID solo debe contener números.");
	        return false;
	    }

	    if (!nombres.matches("[a-zA-Z]+")) {
	        vistaAdmin.mostrarMensajeError("El nombre solo debe contener letras.");
	        return false;
	    }

	    if (!apellidos.matches("[a-zA-Z]+")) {
	        vistaAdmin.mostrarMensajeError("El apellido solo debe contener letras.");
	        return false;
	    }

	    if (!correo.contains("@") || !correo.contains(".")) {
	        vistaAdmin.mostrarMensajeError("El correo ingresado no es válido.");
	        return false;
	    }

	    if (!celular.matches("\\d{7,10}")) {
	        vistaAdmin.mostrarMensajeError("El celular debe tener entre 7 y 10 dígitos numéricos.");
	        return false;
	    }

	    try {
	        LocalDate.parse(fechaNacimiento);
	    } catch (DateTimeParseException e) {
	        vistaAdmin.mostrarMensajeError("La fecha de nacimiento debe tener el formato yyyy-MM-dd.");
	        return false;
	    }

	    if (pais.equals("Seleccionar")) {
	        vistaAdmin.mostrarMensajeError("Debe seleccionar un país.");
	        return false;
	    }

	    if (ciudad.equals("Seleccionar")) {
	        vistaAdmin.mostrarMensajeError("Debe seleccionar una ciudad.");
	        return false;
	    }

	    if (zonaHoraria.equals("Seleccionar")) {
	        vistaAdmin.mostrarMensajeError("Debe seleccionar una zona horaria.");
	        return false;
	    }

	    if (tipoUsuario.equals("Seleccionar")) {
	        vistaAdmin.mostrarMensajeError("Debe seleccionar un tipo de usuario.");
	        return false;
	    }

	    return true;
	}



	
	private void mostrarPanelUsuarios() {
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(), "USUARIOS");
		//vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarPorComboBox().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getFiltroComboBox().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarButton().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getLimpiarFiltrosButton().addActionListener(this);
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
			reiniciarTablaUsuarios();
			//vistaAdmin.mostrarMensajeError("Por favor seleccione un criterio de busqueda.");
		}
	}

	private void buscarUsuarioPorCorreo() {
		String correoBuscar = vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().getText().trim().toLowerCase();
		List<UsuarioDto> coincidencias = new ArrayList<UsuarioDto>();
		
		if(correoBuscar == null || correoBuscar.isEmpty()) {
			vistaAdmin.mostrarMensajeError("Por favor seleccione un criterio de busqueda");
		} 
		
		try {
			Usuario usuario = usuarioService.buscarPorCorreo(correoBuscar);
			if(usuario instanceof Entrenador) {
				coincidencias.add(EntrenadorMapHandler.convertirADto((Entrenador)usuario));
			} else if(usuario instanceof Jugador) {
				coincidencias.add(JugadorMapHandler.convertirADto((Jugador)usuario));
			} else {
				coincidencias.add(UsuarioMapHandler.convertirADto(usuario));
			}
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
			return;
		}
		
		if(coincidencias.isEmpty()) {
			vistaAdmin.mostrarMensajeAdvertencia("No se encontro alguna coincidencia con el correo: " + correoBuscar);
		} else {
			vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
		}
		
	}

	private void buscarUsuarioPorCedula() {
		String cedulaBuscar = vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().getText().trim().toLowerCase();
		List<UsuarioDto> coincidencias = new ArrayList<UsuarioDto>();
		
		if(cedulaBuscar == null || cedulaBuscar.isEmpty()) {
			vistaAdmin.mostrarMensajeError("Por favor seleccione un criterio de busqueda");
		} 
		
		try {
			Usuario usuario = usuarioService.buscarPorId(cedulaBuscar);		
			if(usuario instanceof Entrenador) {
				coincidencias.add(EntrenadorMapHandler.convertirADto((Entrenador)usuario));
			} else if(usuario instanceof Jugador) {
				coincidencias.add(JugadorMapHandler.convertirADto((Jugador)usuario));
			} else {
				coincidencias.add(UsuarioMapHandler.convertirADto(usuario));
			}
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
			return;
		}
		
		if(coincidencias.isEmpty()) {
			vistaAdmin.mostrarMensajeAdvertencia("No se encontro alguna coincidencia con la cedula: " + cedulaBuscar);
		} else {
			vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
		}
		
	}

	private void buscarUsuarioPorNombre() {
		String nombreBuscar = vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getBuscarTextField().getText().trim().toLowerCase();
		List<UsuarioDto> coincidencias = new ArrayList<UsuarioDto>();
		
		if(nombreBuscar == null || nombreBuscar.isEmpty()) {
			vistaAdmin.mostrarMensajeError("Por favor seleccione un criterio de busqueda");
		} 
		
		try {
			for(Usuario u : usuarioService.buscarPorNombre(nombreBuscar)) {
				if(u instanceof Entrenador) {
					coincidencias.add(EntrenadorMapHandler.convertirADto((Entrenador)u));
				}else if(u instanceof Jugador) {
					coincidencias.add(JugadorMapHandler.convertirADto((Jugador)u));
				}else {
					coincidencias.add(UsuarioMapHandler.convertirADto(u));
				}
			}
		} catch (AccesoDatosException e) {
			vistaAdmin.mostrarMensajeError(e.getMessage());
			return;
		}
		
		if(coincidencias.isEmpty()) {
			vistaAdmin.mostrarMensajeAdvertencia("No se encontro alguna coincidencia con el nombre: " + nombreBuscar);
		} else {
			vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
		}
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
		String tipo = vistaAdmin.getVentanaPrincipal().getPanelBusqueda().getTipoUsuarioComboBox().getSelectedItem().toString();
		List<UsuarioDto> coincidencias = new ArrayList<>();
		
		switch(tipo) {
			case "Entrenador":
				try {
					for(Entrenador e : entrenadorService.obtenerTodos()) {
						coincidencias.add(EntrenadorMapHandler.convertirADto(e));
					}
				} catch (AccesoDatosException e) {
					vistaAdmin.mostrarMensajeError(e.getMessage());
					return;
				}
				break;
				
			case "Jugador":
				try {
					for(Jugador j : jugadorService.obtenerTodos()) {
						coincidencias.add(JugadorMapHandler.convertirADto(j));
					}
				} catch (AccesoDatosException e) {
					vistaAdmin.mostrarMensajeError(e.getMessage());
					return;
				}
				break;
				
			default:
				reiniciarTablaUsuarios();
		}
		
		vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
	}

	private void filtrarPorPais() {
	    String paisSeleccionado = vistaAdmin.getVentanaPrincipal().getPanelBusqueda()
	            .getPaisComboBox().getSelectedItem().toString();

	    if (paisSeleccionado == null || paisSeleccionado.equals("Seleccionar")) {
	        vistaAdmin.mostrarMensajeAdvertencia("Por favor seleccione un país para filtrar.");
	        return;
	    }

	    List<UsuarioDto> coincidencias = new ArrayList<>();

	    try {
	        for (Usuario u : usuarioService.filtrarPorPais(paisSeleccionado)) {
	            if (u instanceof Entrenador) {
	                coincidencias.add(EntrenadorMapHandler.convertirADto((Entrenador) u));
	            } else if (u instanceof Jugador) {
	                coincidencias.add(JugadorMapHandler.convertirADto((Jugador) u));
	            } else {
	                coincidencias.add(UsuarioMapHandler.convertirADto(u));
	            }
	        }
	    } catch (AccesoDatosException e) {
	        vistaAdmin.mostrarMensajeError("Error al filtrar por país: " + e.getMessage());
	        return;
	    }

	    if (coincidencias.isEmpty()) {
	        vistaAdmin.mostrarMensajeAdvertencia("No se encontraron usuarios para el país: " + paisSeleccionado);
	    } else {
	        vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
	    }
	}

	private void filtrarPorCiudad() {
	    String ciudadSeleccionada = vistaAdmin.getVentanaPrincipal().getPanelBusqueda()
	            .getCiudadComboBox().getSelectedItem().toString();

	    if (ciudadSeleccionada == null || ciudadSeleccionada.equals("Seleccionar")) {
	        vistaAdmin.mostrarMensajeAdvertencia("Por favor seleccione una ciudad para filtrar.");
	        return;
	    }

	    List<UsuarioDto> coincidencias = new ArrayList<>();

	    try {
	        for (Usuario u : usuarioService.filtrarPorCiudad(ciudadSeleccionada)) {
	            if (u instanceof Entrenador) {
	                coincidencias.add(EntrenadorMapHandler.convertirADto((Entrenador) u));
	            } else if (u instanceof Jugador) {
	                coincidencias.add(JugadorMapHandler.convertirADto((Jugador) u));
	            } else {
	                coincidencias.add(UsuarioMapHandler.convertirADto(u));
	            }
	        }
	    } catch (AccesoDatosException e) {
	        vistaAdmin.mostrarMensajeError("Error al filtrar por ciudad: " + e.getMessage());
	        return;
	    }

	    if (coincidencias.isEmpty()) {
	        vistaAdmin.mostrarMensajeAdvertencia("No se encontraron usuarios para la ciudad: " + ciudadSeleccionada);
	    } else {
	        vistaAdmin.getVentanaPrincipal().getPanelTabla().actualizarTabla(coincidencias);
	    }
	}

	
	private void mostrarVentanaCrearUsuario() {
		vistaAdmin.getVentanaCreacionUsuario().setVisible(true);
		vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getSeleccionarFotoButton().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCrearButton().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getEditarButton().setVisible(false);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCrearButton().setVisible(true);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCancelarButton().addActionListener(this);		
	}
	
	private void mostrarVentanaEdicionUsuario() {
		vistaAdmin.getVentanaCreacionUsuario().setVisible(true);
		vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getSeleccionarFotoButton().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCrearButton().setVisible(false);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getEditarButton().setVisible(true);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getCancelarButton().addActionListener(this);
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getEditarButton().addActionListener(this);
		int filaSeleccionada = vistaAdmin.getVentanaPrincipal().getPanelTabla().getTablaUsuarios().getSelectedRow();
		if(filaSeleccionada == -1) {
			vistaAdmin.mostrarMensajeError("Por favor seleccione un usuario para editar");
			return;
		}
		else {
			String cedulaEditar = vistaAdmin.getVentanaPrincipal().getPanelTabla().getTablaUsuarios().getValueAt(filaSeleccionada,0).toString();
			try {
				Usuario usuario = usuarioService.buscarPorId(cedulaEditar);
				if(usuario instanceof Entrenador) {
					EntrenadorDto usuarioEditar = (EntrenadorMapHandler.convertirADto((Entrenador)usuario));
					vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().rellenarCamposFormulario(usuarioEditar);
					mostrarPanelDinamicoUsuario();
					PanelEntrenador panelEntrenador = (PanelEntrenador)vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getPanelActual();
					panelEntrenador.getNickNameField().setText(usuarioEditar.getNickname());
					panelEntrenador.getAniosXpField().setText(String.valueOf(usuarioEditar.getAniosExperiencia()));
					panelEntrenador.getBioTextArea().setText(usuarioEditar.getBiografia());
					
				} else if(usuario instanceof Jugador) {
					JugadorDto usuarioEditar = JugadorMapHandler.convertirADto((Jugador)usuario);
					vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().rellenarCamposFormulario(usuarioEditar);
					mostrarPanelDinamicoUsuario();
					PanelJugador panelJugador = (PanelJugador)vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getPanelActual();
					panelJugador.getNivelCompetitivoComboBox().setSelectedItem(usuarioEditar.getNivelCompetitivo().toString());
					panelJugador.getGamerTagField().setText(usuarioEditar.getGamerTag());
					panelJugador.getRankingPuntosField().setText(String.valueOf(usuarioEditar.getRankingPuntos()));
					
				}
				
				vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getIdField().setEditable(false);
				vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().setEnabled(false);
				vistaAdmin.getVentanaCreacionUsuario().setVisible(true);

			} catch (AccesoDatosException e) {
				vistaAdmin.mostrarMensajeError(e.getMessage());
				return;
			}
		}			
	}
	
	private void cancelarGuardarUsuario() {
		vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
	}
	
	private void eliminarUsuario() {
		int filaSeleccionada = vistaAdmin.getVentanaPrincipal().getPanelTabla().getTablaUsuarios().getSelectedRow();
		if(filaSeleccionada == -1) {
			vistaAdmin.mostrarMensajeError("Por favor, seleccione un usuario de la tabla para eliminar.");
		}else {
			int opcion = vistaAdmin.mostrarMensajeConfirmacion("¿Esta seguro que desea eliminar el Usuario?");
			
			if(opcion == JOptionPane.YES_OPTION) {
				String cedulaEliminar = vistaAdmin.getVentanaPrincipal().getPanelTabla().getTablaUsuarios().getValueAt(opcion,0).toString();
				String tipoEliminar = vistaAdmin.getVentanaPrincipal().getPanelTabla().getTablaUsuarios().getValueAt(opcion, 1).toString();
				try {
					usuarioService.eliminarUsuario(cedulaEliminar);
					if("Entrenador".equalsIgnoreCase(tipoEliminar)) {
						entrenadorService.eliminarEntrenador(cedulaEliminar);
					}else if("Jugador".equalsIgnoreCase(cedulaEliminar)) {
						jugadorService.eliminarJugador(cedulaEliminar);
					}
					
				} catch (AccesoDatosException e) {
					vistaAdmin.mostrarMensajeError(e.getMessage());
					return;
				} catch (IOException e) {
					vistaAdmin.mostrarMensajeError(e.getMessage());
					return;
				}
				vistaAdmin.mostrarMensajeExito("Usuario Eliminado Exitosamente");
				reiniciarTablaUsuarios();
			} else {
				vistaAdmin.mostrarMensajeExito("Operacion cancelada exitosamente");
			}
		}
	}
	
	private void crearGuardarUsuario() {
		String tipoUsuario = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().getSelectedItem().toString().toLowerCase();
		switch(tipoUsuario) {
			case "entrenador":
				if(!validarDatosFormularioUsuarios()) return;
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
				String passwordPlanoE = id + "*";
				System.out.println("ID usado para el hash: " + id);
				System.out.println("HASH generado y asignado: " + passwordPlanoE);
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
				entrenadorDto.setRutaFoto(rutaFoto);
				entrenadorDto.setNecesitaCambioPassword(necesitaCambioPassword);
				entrenadorDto.setNickname(nickName);
				entrenadorDto.setAniosExperiencia(aniosExp);
				entrenadorDto.setBiografia(biografia);
				entrenadorDto.setTipoUsuario(tipoUsuarioE);
				
				
			try {
				int confirmacion = vistaAdmin.mostrarMensajeConfirmacion("¿Desea crear el nuevo usuario?");
				if(confirmacion == JOptionPane.YES_OPTION) {
					Entrenador entidad = EntrenadorMapHandler.convertirAEntidad(entrenadorDto);
					//System.out.println("Hash en entidad antes de guardar: " + entidad.getPasswordHash());
					entrenadorService.crearEntrenador(entidad, passwordPlanoE);
					reiniciarTablaUsuarios();
					vistaAdmin.mostrarMensajeExito("Usuario creado con extito");
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
					vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().reiniciarCamposEdicion();
				}else {
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);	
					vistaAdmin.mostrarMensajeExito("Operacion cancelada exitosamente");
				}
				
			} catch (AccesoDatosException e) {
				vistaAdmin.mostrarMensajeError(e.getMessage());
				return;
			} catch (RegistroDuplicadoException e) {
				vistaAdmin.mostrarMensajeError(e.getMessage());
			}
				break;
				
			case "jugador" :
				if(!validarDatosFormularioUsuarios()) return;
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
				String passwordPlanoJ = idJ + "*";
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
				jugadorDto.setRutaFoto(rutaFotoJ);
				jugadorDto.setNecesitaCambioPassword(necesitaCambioPasswordJ);
				jugadorDto.setNivelCompetitivo(nivel);
				jugadorDto.setGamerTag(gamerTag);
				jugadorDto.setRankingPuntos(rankingPuntos);
				jugadorDto.setTipoUsuario(tipoUsuarioJ);
				
			try {
				int confirmacion = vistaAdmin.mostrarMensajeConfirmacion("¿Desea crear el nuevo usuario?");
				if(confirmacion == JOptionPane.YES_OPTION) {
					try {
						jugadorService.crearJugador(JugadorMapHandler.convertirAEntidad(jugadorDto), passwordPlanoJ);
					} catch (RegistroDuplicadoException e) {
						vistaAdmin.mostrarMensajeError(e.getMessage());
					} catch (RegistroNoEncontradoException e) {
						vistaAdmin.mostrarMensajeError(e.getMessage());
					}
					reiniciarTablaUsuarios();
					vistaAdmin.mostrarMensajeExito("Usuario creado con extito");
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
					vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().reiniciarCamposEdicion();
				}else {
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);	
					vistaAdmin.mostrarMensajeExito("Operacion cancelada exitosamente");
				}
			} catch (AccesoDatosException e) {
				vistaAdmin.mostrarMensajeError(e.getMessage());
			}
				break;
		}
		
	}
	
	private void editarGuardarUsuario() {
		if(!validarDatosFormularioUsuarios()) return;
		String[] datos = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().obtenerCamposFormulario();
		String id = datos[0];
		String nombres = datos[1];
		String apellidos = datos[2];
		String correo = datos[3];
		String celular = datos[4];
		String pais = datos[5];
		String ciudad = datos[6];
		String zonaHoraria = datos[7];
		LocalDate fechaNacimiento = LocalDate.parse(datos[8]);
		String tipoUsuario = datos[9];
		String passwordHash = datos[10];
		
		if(tipoUsuario.equals("Entrenador")) {
			EntrenadorDto usuarioGuardar = new EntrenadorDto();
			PanelEntrenador panelEntrenador = (PanelEntrenador)vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getPanelActual();
			String nickName = panelEntrenador.getNickNameField().getText();
			int anioExp = Integer.parseInt(panelEntrenador.getAniosXpField().getText());
			String biografia = panelEntrenador.getBioTextArea().getText();
			usuarioGuardar.setId(id);
			usuarioGuardar.setNombres(nombres);
			usuarioGuardar.setApellidos(apellidos);
			usuarioGuardar.setCorreo(correo);
			usuarioGuardar.setCelular(celular);
			usuarioGuardar.setPais(pais);
			usuarioGuardar.setCiudad(ciudad);
			usuarioGuardar.setZonaHoraria(zonaHoraria);
			usuarioGuardar.setFechaNacimiento(fechaNacimiento);
			usuarioGuardar.setNickname(nickName);
			usuarioGuardar.setAniosExperiencia(anioExp);
			usuarioGuardar.setBiografia(biografia);
			usuarioGuardar.setPasswordHash(passwordHash);
			
			int confirmacion = vistaAdmin.mostrarMensajeConfirmacion("¿Esta seguro que desea editar el usuario?");
			
			if(confirmacion == JOptionPane.YES_OPTION) {
				try {
					entrenadorService.actualizarEntrenador(EntrenadorMapHandler.convertirAEntidad(usuarioGuardar));;
					vistaAdmin.mostrarMensajeExito("Usuario editado con exito");
					reiniciarTablaUsuarios();
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
				} catch (AccesoDatosException e) {
					vistaAdmin.mostrarMensajeExito("Usuario editado con exito");
				} catch (IOException e) {
					vistaAdmin.mostrarMensajeError(e.getMessage());
				}
			}
		} else if(tipoUsuario.equals("Jugador")) {
			JugadorDto usuarioGuardar = new JugadorDto();
			PanelJugador panelJugador = (PanelJugador)vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().getPanelActual();
			NivelCompetitivoJugador nivel = NivelCompetitivoJugador.valueOf(panelJugador.getNivelCompetitivoComboBox().getSelectedItem().toString());
			String gamerTag = panelJugador.getGamerTagField().getText();
			int rankingPuntos = Integer.parseInt(panelJugador.getRankingPuntosField().getText());
			usuarioGuardar.setId(id);
			usuarioGuardar.setNombres(nombres);
			usuarioGuardar.setApellidos(apellidos);
			usuarioGuardar.setCorreo(correo);
			usuarioGuardar.setCelular(celular);
			usuarioGuardar.setPais(pais);
			usuarioGuardar.setCiudad(ciudad);
			usuarioGuardar.setZonaHoraria(zonaHoraria);
			usuarioGuardar.setFechaNacimiento(fechaNacimiento);
			usuarioGuardar.setNivelCompetitivo(nivel);;
			usuarioGuardar.setGamerTag(gamerTag);
			usuarioGuardar.setRankingPuntos(rankingPuntos);;
			usuarioGuardar.setPasswordHash(passwordHash);
			
			int confirmacion = vistaAdmin.mostrarMensajeConfirmacion("¿Esta seguro que desea editar el usuario?");
			
			if(confirmacion == JOptionPane.YES_OPTION) {
				try {
					jugadorService.actualizarJugador(JugadorMapHandler.convertirAEntidad(usuarioGuardar));;
					vistaAdmin.mostrarMensajeExito("Usuario editado con exito");
					reiniciarTablaUsuarios();
					vistaAdmin.getVentanaCreacionUsuario().setVisible(false);
				} catch (AccesoDatosException e) {
					vistaAdmin.mostrarMensajeExito("Usuario editado con exito");
				} catch (IOException e) {
					vistaAdmin.mostrarMensajeError(e.getMessage());
				}
			}
		}
	}
	
	private void mostrarPanelDinamicoUsuario() {
		String tipoUsuario = vistaAdmin.getVentanaCreacionUsuario().getPanelSuperior().getTipoUsuarioComboBox().getSelectedItem().toString();
		vistaAdmin.getVentanaCreacionUsuario().getPanelDinamico().mostrarPanel(tipoUsuario);
		System.out.println("tipo usuario desde el controlador " + tipoUsuario);
	}

	// ------------------------------------------- GESTION DE USUARIOS  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE EQUIPOS  -------------------------------------------------------------------//

	private void mostrarPanelEquipos() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(), "EQUIPOS");
		vistaAdmin.getVentanaPrincipal().getPanelEquipos().getCrearBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelEquipos().getActualizarBtn().addActionListener(this);
		vistaAdmin.getVentanaPrincipal().getPanelEquipos().getEliminarBtn().addActionListener(this);
	}
	
	private void mostrarVentanaCreacionEquipo(){
		vistaAdmin.getVentanaCreacionEquipo().setVisible(true);
	}
	
	// ------------------------------------------- GESTION DE EQUIPOS  -------------------------------------------------------------------//
	
	// ------------------------------------------- GESTION DE TORNEOS  -------------------------------------------------------------------//

	private void mostrarPanelTorneos() {
		vistaAdmin.getVentanaPrincipal().getPanelInferior().setVisible(false);
		vistaAdmin.getVentanaPrincipal().getLayoutCentral().show(vistaAdmin.getVentanaPrincipal().getPanelCentral(), "TORNEOS");
		vistaAdmin.getVentanaPrincipal().getPanelTorneos().getBotonIniciarTorneo().addActionListener(this);
	}
	
	private void mostraVentanaIniciarTorneo() {
		vistaAdmin.getVentanaInicioTorneo().setVisible(true);
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

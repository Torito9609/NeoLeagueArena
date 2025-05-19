package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.vista.jugador.SubPanelMiPerfilJugador;
import co.edu.unbosque.vista.jugador.VentanaPrincipalJugador;
import co.edu.unbosque.vista.jugador.VistaJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador encargado de gestionar la interacción del jugador con la interfaz gráfica
 * del sistema NeoLeague Arena.
 * <p>
 * Este controlador administra la navegación por los distintos paneles de la vista del jugador,
 * así como la edición y actualización del perfil personal. Se encarga de conectar la vista con
 * la lógica que manipula los datos del jugador actualmente autenticado.
 * <p>
 * Implementa {@link ActionListener} para responder a los eventos generados por los botones
 * de navegación y acciones dentro de los subpaneles.
 */
public class JugadorController implements ActionListener {

    private VistaJugador vistaJugador;
    private Map<String, Runnable> comandos;
    private JugadorDto jugadorActual;

    /**
     * Crea e inicializa el controlador para el jugador autenticado.
     * Se cargan los paneles de la vista, se simula la carga de datos del jugador
     * y se configuran los comandos y oyentes.
     *
     * @param jugadorLoggeado instancia del jugador que ha iniciado sesión
     */
    public JugadorController(Jugador jugadorLoggeado) {
        vistaJugador = new VistaJugador();
        comandos = new HashMap<>();

        simularCargaJugadorActual();
        actualizarInfoPanelSuperior();

        registrarComandos();
        asignarOyentes();

        vistaJugador.mostrarVentana();
        vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico()
                    .mostrarPanel(VentanaPrincipalJugador.DASHBOARD_JUGADOR);
    }

    /**
     * Método temporal que simula la carga del jugador actual.
     * En una implementación real, este debería convertir o asignar los datos del jugador logueado.
     */
    private void simularCargaJugadorActual() {
        // Simulación de carga del jugador desde la base de datos o servicio
    }

    /**
     * Actualiza los datos del panel superior con la información del jugador actual.
     */
    private void actualizarInfoPanelSuperior() {
        if (this.jugadorActual != null) {
            vistaJugador.getVentanaPrincipal().getPanelInfoSuperior().actualizarId(jugadorActual.getId());
            vistaJugador.getVentanaPrincipal().getPanelInfoSuperior().actualizarGamerTag(jugadorActual.getGamerTag());
            vistaJugador.getVentanaPrincipal().getPanelInfoSuperior().actualizarFoto(jugadorActual.getRutaFoto());
        }
    }

    /**
     * Registra los comandos que el controlador puede ejecutar en respuesta a eventos.
     * Cada comando está asociado a una acción específica como navegar o guardar el perfil.
     */
    private void registrarComandos() {
        comandos.put(VentanaPrincipalJugador.DASHBOARD_JUGADOR, this::mostrarPanelDashboard);
        comandos.put(VentanaPrincipalJugador.MI_PERFIL_JUGADOR, this::mostrarPanelMiPerfil);
        comandos.put(VentanaPrincipalJugador.MIS_EQUIPOS_JUGADOR, this::mostrarPanelMisEquipos);
        comandos.put(VentanaPrincipalJugador.MIS_TORNEOS_JUGADOR, this::mostrarPanelMisTorneos);
        comandos.put(VentanaPrincipalJugador.MIS_PARTIDAS_JUGADOR, this::mostrarPanelMisPartidas);
        comandos.put(VentanaPrincipalJugador.CONFIGURACION_JUGADOR, this::mostrarPanelConfiguracion);
        comandos.put("CERRAR_SESION_JUGADOR", this::cerrarSesion);
        comandos.put("GUARDAR_PERFIL_JUGADOR", this::guardarPerfilJugador);
    }

    /**
     * Asigna los oyentes de eventos a los botones de navegación y acciones de la vista del jugador.
     */
    private void asignarOyentes() {
        VentanaPrincipalJugador vp = vistaJugador.getVentanaPrincipal();
        vp.getPanelNavegacion().getBtnDashboard().addActionListener(this);
        vp.getPanelNavegacion().getBtnMiPerfil().addActionListener(this);
        vp.getPanelNavegacion().getBtnMisEquipos().addActionListener(this);
        vp.getPanelNavegacion().getBtnMisTorneos().addActionListener(this);
        vp.getPanelNavegacion().getBtnMisPartidas().addActionListener(this);
        vp.getPanelNavegacion().getBtnConfiguracion().addActionListener(this);
        vp.getPanelInfoSuperior().getBtnCerrarSesion().setActionCommand("CERRAR_SESION_JUGADOR");
        vp.getPanelInfoSuperior().getBtnCerrarSesion().addActionListener(this);
        SubPanelMiPerfilJugador panelPerfil = vp.getPanelContenidoDinamico().getPanelMiPerfil();
        panelPerfil.getBtnGuardarCambiosPerfil().addActionListener(this);
    }

    /**
     * Maneja los eventos de acción provenientes de la vista del jugador.
     * Busca el comando en el mapa y ejecuta la acción asociada si existe.
     *
     * @param e el evento de acción generado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        Runnable action = comandos.get(comando);
        if (action != null) {
            action.run();
        } else {
            System.out.println("JugadorController: Comando no reconocido - " + comando);
        }
    }

    // Métodos de navegación

    private void mostrarPanel(String nombrePanel) {
        vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico().mostrarPanel(nombrePanel);
    }

    private void mostrarPanelDashboard() { mostrarPanel(VentanaPrincipalJugador.DASHBOARD_JUGADOR); }

    private void mostrarPanelMisEquipos() { mostrarPanel(VentanaPrincipalJugador.MIS_EQUIPOS_JUGADOR); }

    private void mostrarPanelMisTorneos() { mostrarPanel(VentanaPrincipalJugador.MIS_TORNEOS_JUGADOR); }

    private void mostrarPanelMisPartidas() { mostrarPanel(VentanaPrincipalJugador.MIS_PARTIDAS_JUGADOR); }

    private void mostrarPanelConfiguracion() { mostrarPanel(VentanaPrincipalJugador.CONFIGURACION_JUGADOR); }

    /**
     * Carga los datos del jugador en el panel de perfil antes de mostrarlo.
     */
    private void mostrarPanelMiPerfil() {
        if (jugadorActual != null) {
            vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico().getPanelMiPerfil()
                        .cargarDatosPerfil(jugadorActual);
        }
        mostrarPanel(VentanaPrincipalJugador.MI_PERFIL_JUGADOR);
    }

    /**
     * Cierra la sesión del jugador, ocultando la ventana y redirigiendo al login.
     */
    private void cerrarSesion() {
        vistaJugador.cerrarVentana();
        System.out.println("JugadorController: Cerrando sesión... Volver al Login.");
    }

    /**
     * Guarda los datos del perfil del jugador simulando la actualización local.
     * También actualiza la previsualización de la foto de perfil si fue modificada.
     */
    private void guardarPerfilJugador() {
        SubPanelMiPerfilJugador panelPerfil = vistaJugador.getVentanaPrincipal()
                                                           .getPanelContenidoDinamico().getPanelMiPerfil();
        JugadorDto datosFormulario = panelPerfil.obtenerDatosParaGuardar();
        File nuevaFotoFile = panelPerfil.getArchivoFotoSeleccionada();

        if (jugadorActual != null && datosFormulario != null) {
            jugadorActual.setGamerTag(datosFormulario.getGamerTag());
            jugadorActual.setNombres(datosFormulario.getNombres());
            jugadorActual.setApellidos(datosFormulario.getApellidos());
            jugadorActual.setCorreo(datosFormulario.getCorreo());
            jugadorActual.setCelular(datosFormulario.getCelular());
            jugadorActual.setPais(datosFormulario.getPais());
            jugadorActual.setCiudad(datosFormulario.getCiudad());
            jugadorActual.setFechaNacimiento(datosFormulario.getFechaNacimiento());
            jugadorActual.setZonaHoraria(datosFormulario.getZonaHoraria());
            jugadorActual.setNivelCompetitivo(datosFormulario.getNivelCompetitivo());

            if (nuevaFotoFile != null) {
                jugadorActual.setRutaFoto(nuevaFotoFile.getAbsolutePath()); // Simulado
                System.out.println("JugadorController: Nueva foto para guardar: " + nuevaFotoFile.getAbsolutePath());
            }

            System.out.println("JugadorController: Perfil 'guardado' (simulado) para: " + jugadorActual.getGamerTag());
            actualizarInfoPanelSuperior();
            panelPerfil.mostrarPrevisualizacionFoto(jugadorActual.getRutaFoto());
            vistaJugador.mostrarMensajeExito("Perfil actualizado (simulado).", vistaJugador.getVentanaPrincipal());
        } else {
            vistaJugador.mostrarMensajeError("No se pudieron obtener datos para guardar.", vistaJugador.getVentanaPrincipal());
        }
    }
}

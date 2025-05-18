package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador; // Usar tu enum
import co.edu.unbosque.vista.jugador.SubPanelMiPerfilJugador;
import co.edu.unbosque.vista.jugador.VentanaPrincipalJugador;
import co.edu.unbosque.vista.jugador.VistaJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JugadorController implements ActionListener {
    private VistaJugador vistaJugador;
    private Map<String, Runnable> comandos;
    private JugadorDto jugadorActual;

    public JugadorController() {
        vistaJugador = new VistaJugador();
        comandos = new HashMap<>();

        simularCargaJugadorActual();
        actualizarInfoPanelSuperior();

        registrarComandos();
        asignarOyentes();

        vistaJugador.mostrarVentana();
        vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico().mostrarPanel(VentanaPrincipalJugador.DASHBOARD_JUGADOR);
    }

    private void simularCargaJugadorActual() {
       
    }

    private void actualizarInfoPanelSuperior() {
        if (this.jugadorActual != null) {
            vistaJugador.getVentanaPrincipal().getPanelInfoSuperior().actualizarId(this.jugadorActual.getId());
            vistaJugador.getVentanaPrincipal().getPanelInfoSuperior().actualizarGamerTag(this.jugadorActual.getGamerTag());
            vistaJugador.getVentanaPrincipal().getPanelInfoSuperior().actualizarFoto(this.jugadorActual.getRutaFoto());
        }
    }

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

    private void mostrarPanel(String nombrePanel) {
        vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico().mostrarPanel(nombrePanel);
    }

    private void mostrarPanelDashboard() { mostrarPanel(VentanaPrincipalJugador.DASHBOARD_JUGADOR); }
    private void mostrarPanelMisEquipos() { mostrarPanel(VentanaPrincipalJugador.MIS_EQUIPOS_JUGADOR); }
    private void mostrarPanelMisTorneos() { mostrarPanel(VentanaPrincipalJugador.MIS_TORNEOS_JUGADOR); }
    private void mostrarPanelMisPartidas() { mostrarPanel(VentanaPrincipalJugador.MIS_PARTIDAS_JUGADOR); }
    private void mostrarPanelConfiguracion() { mostrarPanel(VentanaPrincipalJugador.CONFIGURACION_JUGADOR); }

    private void mostrarPanelMiPerfil() {
        if (jugadorActual != null) {
            vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico().getPanelMiPerfil().cargarDatosPerfil(jugadorActual);
        }
        mostrarPanel(VentanaPrincipalJugador.MI_PERFIL_JUGADOR);
    }

    private void cerrarSesion() {
        vistaJugador.cerrarVentana();
        System.out.println("JugadorController: Cerrando sesión... Volver al Login.");
    }

    private void guardarPerfilJugador() {
        SubPanelMiPerfilJugador panelPerfil = vistaJugador.getVentanaPrincipal().getPanelContenidoDinamico().getPanelMiPerfil();
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
                // Lógica para guardar/copiar la nueva foto
                // String nuevaRuta = servicioArchivos.guardarFotoPerfil(nuevaFotoFile, jugadorActual.getId());
                // jugadorActual.setRutaFoto(nuevaRuta);
                jugadorActual.setRutaFoto(nuevaFotoFile.getAbsolutePath()); // Simulación
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
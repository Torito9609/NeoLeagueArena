package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel dinámico que organiza y muestra diferentes secciones
 * de la interfaz del jugador mediante un sistema de tarjetas (`CardLayout`).
 */
public class PanelContenidoDinamicoJugador extends JPanel {

    private CardLayout cardLayout;

    private SubPanelDashboardJugador panelDashboard;
    private SubPanelMiPerfilJugador panelMiPerfil;
    private SubPanelMisEquiposJugador panelMisEquipos;
    private SubPanelMisTorneosJugador panelMisTorneos;
    private SubPanelMisPartidasJugador panelMisPartidas;
    private SubPanelConfiguracionJugador panelConfiguracion;

    /**
     * Constructor que inicializa el panel y agrega las distintas vistas.
     */
    public PanelContenidoDinamicoJugador() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setBackground(Color.WHITE);

        panelDashboard = new SubPanelDashboardJugador();
        add(panelDashboard, VentanaPrincipalJugador.DASHBOARD_JUGADOR);

        panelMiPerfil = new SubPanelMiPerfilJugador();
        add(panelMiPerfil, VentanaPrincipalJugador.MI_PERFIL_JUGADOR);

        panelMisEquipos = new SubPanelMisEquiposJugador();
        add(panelMisEquipos, VentanaPrincipalJugador.MIS_EQUIPOS_JUGADOR);

        panelMisTorneos = new SubPanelMisTorneosJugador();
        add(panelMisTorneos, VentanaPrincipalJugador.MIS_TORNEOS_JUGADOR);

        panelMisPartidas = new SubPanelMisPartidasJugador();
        add(panelMisPartidas, VentanaPrincipalJugador.MIS_PARTIDAS_JUGADOR);

        panelConfiguracion = new SubPanelConfiguracionJugador();
        add(panelConfiguracion, VentanaPrincipalJugador.CONFIGURACION_JUGADOR);
    }

    /**
     * Cambia la vista mostrada en el panel dinámico.
     *
     * @param nombrePanel Nombre de la vista que se desea mostrar.
     */
    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(this, nombrePanel);
    }

    // Métodos de acceso a los subpaneles
    public SubPanelDashboardJugador getPanelDashboard() { return panelDashboard; }
    public SubPanelMiPerfilJugador getPanelMiPerfil() { return panelMiPerfil; }
    public SubPanelMisEquiposJugador getPanelMisEquipos() { return panelMisEquipos; }
    public SubPanelMisTorneosJugador getPanelMisTorneos() { return panelMisTorneos; }
    public SubPanelMisPartidasJugador getPanelMisPartidas() { return panelMisPartidas; }
    public SubPanelConfiguracionJugador getPanelConfiguracion() { return panelConfiguracion; }
}
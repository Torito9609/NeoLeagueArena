package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import java.awt.*;

public class PanelContenidoDinamicoJugador extends JPanel {
    private CardLayout cardLayout;

 
    private SubPanelDashboardJugador panelDashboard;
    private SubPanelMiPerfilJugador panelMiPerfil;
    private SubPanelMisEquiposJugador panelMisEquipos;
    private SubPanelMisTorneosJugador panelMisTorneos;
    private SubPanelMisPartidasJugador panelMisPartidas;
    private SubPanelConfiguracionJugador panelConfiguracion;


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

    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(this, nombrePanel);
    }

  
    public SubPanelDashboardJugador getPanelDashboard() { return panelDashboard; }
    public SubPanelMiPerfilJugador getPanelMiPerfil() { return panelMiPerfil; }
    public SubPanelMisEquiposJugador getPanelMisEquipos() { return panelMisEquipos; }
    public SubPanelMisTorneosJugador getPanelMisTorneos() { return panelMisTorneos; }
    public SubPanelMisPartidasJugador getPanelMisPartidas() { return panelMisPartidas; }
    public SubPanelConfiguracionJugador getPanelConfiguracion() { return panelConfiguracion; }
}
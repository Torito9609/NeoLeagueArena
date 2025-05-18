package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipalJugador extends JFrame {

    private PanelInfoJugadorSuperior panelInfoSuperior;
    private PanelNavegacionJugador panelNavegacion;
    private PanelContenidoDinamicoJugador panelContenidoDinamico;

 
    public static final String DASHBOARD_JUGADOR = "DASHBOARD_JUGADOR";
    public static final String MI_PERFIL_JUGADOR = "MI_PERFIL_JUGADOR";
    public static final String MIS_EQUIPOS_JUGADOR = "MIS_EQUIPOS_JUGADOR";
    public static final String MIS_TORNEOS_JUGADOR = "MIS_TORNEOS_JUGADOR";
    public static final String MIS_PARTIDAS_JUGADOR = "MIS_PARTIDAS_JUGADOR";
    public static final String CONFIGURACION_JUGADOR = "CONFIGURACION_JUGADOR";


    public VentanaPrincipalJugador(String idJugador, String nickname, String rutaFotoActual) {
        setTitle("NeoLeague Arena - Jugador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700); 
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5)); 
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5)); 

        
        panelInfoSuperior = new PanelInfoJugadorSuperior(idJugador, nickname, rutaFotoActual);
        panelNavegacion = new PanelNavegacionJugador();
        panelContenidoDinamico = new PanelContenidoDinamicoJugador();

    
        add(panelInfoSuperior, BorderLayout.NORTH);
        add(panelNavegacion, BorderLayout.WEST);
        add(panelContenidoDinamico, BorderLayout.CENTER);


        getPanelContenidoDinamico().mostrarPanel(DASHBOARD_JUGADOR);
    }

  
    public PanelInfoJugadorSuperior getPanelInfoSuperior() {
        return panelInfoSuperior;
    }

    public PanelNavegacionJugador getPanelNavegacion() {
        return panelNavegacion;
    }

    public PanelContenidoDinamicoJugador getPanelContenidoDinamico() {
        return panelContenidoDinamico;
    }


}
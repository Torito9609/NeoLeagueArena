package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelNavegacionJugador extends JPanel {
    private JButton btnDashboard;
    private JButton btnMiPerfil;
    private JButton btnMisEquipos;
    private JButton btnMisTorneos;
    private JButton btnMisPartidas;
    private JButton btnConfiguracion;

    public PanelNavegacionJugador() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY), 
                new EmptyBorder(10, 10, 10, 10)
        ));
        setBackground(Color.decode("#ecf0f1")); 
        setPreferredSize(new Dimension(200, getHeight())); 

        Dimension buttonSize = new Dimension(180, 40);

        btnDashboard = crearBotonNavegacion("Dashboard", VentanaPrincipalJugador.DASHBOARD_JUGADOR, buttonSize);
        btnMiPerfil = crearBotonNavegacion("Mi Perfil / Editar", VentanaPrincipalJugador.MI_PERFIL_JUGADOR, buttonSize);
        btnMisEquipos = crearBotonNavegacion("Mis Equipos", VentanaPrincipalJugador.MIS_EQUIPOS_JUGADOR, buttonSize);
        btnMisTorneos = crearBotonNavegacion("Mis Torneos", VentanaPrincipalJugador.MIS_TORNEOS_JUGADOR, buttonSize);
        btnMisPartidas = crearBotonNavegacion("Mis Partidas", VentanaPrincipalJugador.MIS_PARTIDAS_JUGADOR, buttonSize);
        btnConfiguracion = crearBotonNavegacion("Configuración", VentanaPrincipalJugador.CONFIGURACION_JUGADOR, buttonSize);

        add(btnDashboard);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnMiPerfil);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnMisEquipos);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnMisTorneos);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnMisPartidas);
        add(Box.createVerticalGlue()); // Empuja el último botón hacia abajo si hay espacio
        add(btnConfiguracion);
    }

    private JButton crearBotonNavegacion(String texto, String actionCommand, Dimension size) {
        JButton boton = new JButton(texto);
        boton.setActionCommand(actionCommand);
        boton.setMaximumSize(size);
        boton.setPreferredSize(size);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Estilo simple
        boton.setBackground(Color.decode("#3498db")); // Azul
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        return boton;
    }

  
    public JButton getBtnDashboard() { return btnDashboard; }
    public JButton getBtnMiPerfil() { return btnMiPerfil; }
    public JButton getBtnMisEquipos() { return btnMisEquipos; }
    public JButton getBtnMisTorneos() { return btnMisTorneos; }
    public JButton getBtnMisPartidas() { return btnMisPartidas; }
    public JButton getBtnConfiguracion() { return btnConfiguracion; }
}
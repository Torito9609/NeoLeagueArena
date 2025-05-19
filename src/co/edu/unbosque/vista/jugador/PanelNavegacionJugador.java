package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Representa el panel de navegación en la interfaz del jugador.
 * Contiene botones para acceder a diferentes secciones, 
 * como el dashboard, perfil, equipos, torneos, partidas y configuración.
 */
public class PanelNavegacionJugador extends JPanel {

    private JButton btnDashboard;
    private JButton btnMiPerfil;
    private JButton btnMisEquipos;
    private JButton btnMisTorneos;
    private JButton btnMisPartidas;
    private JButton btnConfiguracion;

    /**
     * Constructor de la clase que inicializa el panel de navegación 
     * con sus respectivos botones y diseño.
     */
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
        add(Box.createVerticalGlue());
        add(btnConfiguracion);
    }

    /**
     * Crea un botón de navegación con el estilo y acción especificada.
     *
     * @param texto Texto del botón.
     * @param actionCommand Comando de acción asociado al botón.
     * @param size Tamaño preferido del botón.
     * @return Un botón personalizado para la navegación.
     */
    private JButton crearBotonNavegacion(String texto, String actionCommand, Dimension size) {
        JButton boton = new JButton(texto);
        boton.setActionCommand(actionCommand);
        boton.setMaximumSize(size);
        boton.setPreferredSize(size);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setBackground(Color.decode("#3498db"));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        return boton;
    }

    // Métodos de acceso a los botones del panel
    public JButton getBtnDashboard() { return btnDashboard; }
    public JButton getBtnMiPerfil() { return btnMiPerfil; }
    public JButton getBtnMisEquipos() { return btnMisEquipos; }
    public JButton getBtnMisTorneos() { return btnMisTorneos; }
    public JButton getBtnMisPartidas() { return btnMisPartidas; }
    public JButton getBtnConfiguracion() { return btnConfiguracion; }
}
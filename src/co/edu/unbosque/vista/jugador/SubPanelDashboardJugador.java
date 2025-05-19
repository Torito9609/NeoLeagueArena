package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel de dashboard para el jugador.
 * Este panel muestra un mensaje de bienvenida al usuario.
 */
public class SubPanelDashboardJugador extends JPanel {

    /**
     * Constructor de la clase que inicializa el panel con su diseño y contenido.
     */
    public SubPanelDashboardJugador() {
        setLayout(new BorderLayout());
        add(new JLabel("Bienvenido al Dashboard del Jugador (Contenido Próximamente)", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
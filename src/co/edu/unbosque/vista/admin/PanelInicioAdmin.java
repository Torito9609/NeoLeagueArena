package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa el panel de inicio para el administrador.
 * Muestra tarjetas con resúmenes de partidas, torneos y usuarios en la interfaz de administración.
 */
public class PanelInicioAdmin extends JPanel {

    /**
     * Constructor que inicializa el panel con un diseño de cuadrícula y tarjetas informativas.
     */
    public PanelInicioAdmin() {
        setLayout(new GridLayout(2, 3, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setVisible(false);
        setBackground(Color.WHITE);

        // Creación de tarjetas de resumen
        for (int i = 1; i <= 6; i++) {
            JPanel card = new JPanel();
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            card.setBackground(new Color(240, 240, 240));
            card.setLayout(new BorderLayout());

            JLabel label = new JLabel("Resumen " + i, SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            card.add(label, BorderLayout.CENTER);

            add(card);
        }
    }
}
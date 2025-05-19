package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Representa un panel con las opciones disponibles para el entrenador.
 * Incluye botones para gestionar torneos, comparar equipos y consultar el historial de partidas.
 */
public class PanelOpcionesEntrenador extends JPanel {

    private JButton btnTorneo;
    private JButton btnCompararEquipos;
    private JButton btnHistorialPartidas;

    /**
     * Constructor que inicializa el panel y sus botones con un diseño estructurado.
     */
    public PanelOpcionesEntrenador() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 123, 255), 1),
            " Opciones ",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            new Font("Arial", Font.BOLD, 16),
            new Color(0, 123, 255)
        ));

        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color buttonBgColor = new Color(70, 130, 180);
        Color buttonFgColor = Color.WHITE;

        // Inicialización de los botones del panel
        btnTorneo = new JButton("Torneo");
        styleButton(btnTorneo, buttonSize, buttonFont, buttonBgColor, buttonFgColor);

        btnCompararEquipos = new JButton("Comparar equipos");
        styleButton(btnCompararEquipos, buttonSize, buttonFont, buttonBgColor, buttonFgColor);

        btnHistorialPartidas = new JButton("Historial De Partidas");
        styleButton(btnHistorialPartidas, buttonSize, buttonFont, buttonBgColor, buttonFgColor);

        add(Box.createVerticalGlue());
        add(createButtonPanel(btnTorneo));
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(createButtonPanel(btnCompararEquipos));
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(createButtonPanel(btnHistorialPartidas));
        add(Box.createVerticalGlue());
    }

    /**
     * Aplica estilos a un botón especificado.
     *
     * @param button Botón a personalizar.
     * @param size Tamaño del botón.
     * @param font Fuente del texto del botón.
     * @param bgColor Color de fondo del botón.
     * @param fgColor Color de texto del botón.
     */
    private void styleButton(JButton button, Dimension size, Font font, Color bgColor, Color fgColor) {
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * Crea un panel contenedor para un botón, alineando su presentación en la interfaz.
     *
     * @param button Botón a encapsular en el panel.
     * @return Panel contenedor del botón.
     */
    private JPanel createButtonPanel(JButton button) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false);
        panel.add(button);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height + 5));
        return panel;
    }

    // Métodos de acceso a los botones del panel
    public JButton getBtnTorneo() { return btnTorneo; }
    public JButton getBtnCompararEquipos() { return btnCompararEquipos; }
    public JButton getBtnHistorialPartidas() { return btnHistorialPartidas; }
}
package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class PanelLateral extends JPanel {

    public PanelLateral() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);

        setPreferredSize(new Dimension(150, getHeight()));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource("imagenes/logo.png"));
        Image imgEscalada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(imgEscalada));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(logoLabel);

    }
}

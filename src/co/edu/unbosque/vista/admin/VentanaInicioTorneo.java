package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana independiente para iniciar y configurar fases de un torneo.
 */
public class VentanaInicioTorneo extends JFrame {

    private PanelInicioTorneo panelInicioTorneo;

    public VentanaInicioTorneo() {
        setTitle("Inicio de Torneo");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        panelInicioTorneo = new PanelInicioTorneo();
        add(panelInicioTorneo, BorderLayout.CENTER);
    }

    public PanelInicioTorneo getPanelInicioTorneo() {
        return panelInicioTorneo;
    }
}

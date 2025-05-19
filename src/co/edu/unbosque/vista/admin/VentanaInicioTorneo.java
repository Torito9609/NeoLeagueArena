package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa una ventana independiente para iniciar y configurar fases de un torneo.
 * Se encarga de gestionar la interfaz de inicio del torneo en el módulo de administración.
 */
public class VentanaInicioTorneo extends JFrame {

    private PanelInicioTorneo panelInicioTorneo;

    /**
     * Constructor que inicializa la ventana de inicio de torneo con sus configuraciones básicas.
     */
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

    /**
     * Devuelve el panel de inicio del torneo.
     * 
     * @return Instancia de {@code PanelInicioTorneo}.
     */
    public PanelInicioTorneo getPanelInicioTorneo() {
        return panelInicioTorneo;
    }
}
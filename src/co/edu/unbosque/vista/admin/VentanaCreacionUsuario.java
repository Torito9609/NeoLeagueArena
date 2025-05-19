package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa una ventana para la creación y edición de usuarios dentro del módulo de administración.
 * Contiene un panel superior con información relevante y un panel dinámico para la configuración del usuario.
 */
public class VentanaCreacionUsuario extends JFrame {

    private PanelUsuarioSuperior panelSuperior;
    private PanelUsuarioDinamico panelDinamico;

    /**
     * Constructor que inicializa la ventana de creación de usuario y configura su diseño.
     */
    public VentanaCreacionUsuario() {
        setTitle("Editar/Crear Producto");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(false);

        panelSuperior = new PanelUsuarioSuperior();
        panelDinamico = new PanelUsuarioDinamico();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDinamico, BorderLayout.CENTER);
    }

    /**
     * Devuelve el panel superior de la ventana de usuario.
     * 
     * @return Instancia de {@code PanelUsuarioSuperior}.
     */
    public PanelUsuarioSuperior getPanelSuperior() {
        return panelSuperior;
    }

    /**
     * Devuelve el panel dinámico de la ventana de usuario.
     * 
     * @return Instancia de {@code PanelUsuarioDinamico}.
     */
    public PanelUsuarioDinamico getPanelDinamico() {
        return panelDinamico;
    }
}
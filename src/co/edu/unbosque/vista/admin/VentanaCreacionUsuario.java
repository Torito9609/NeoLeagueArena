package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class VentanaCreacionUsuario extends JFrame {

	private PanelUsuarioSuperior panelSuperior;
    private PanelUsuarioDinamico panelDinamico;

    public VentanaCreacionUsuario() {
        setTitle("Editar/Crear Producto");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(false);

        panelSuperior = new PanelUsuarioSuperior();
        panelDinamico = new PanelUsuarioDinamico();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDinamico, BorderLayout.CENTER);
    }

    public PanelUsuarioSuperior getPanelSuperior() {
        return panelSuperior;
    }

    public PanelUsuarioDinamico getPanelDinamico() {
        return panelDinamico;
    }
}

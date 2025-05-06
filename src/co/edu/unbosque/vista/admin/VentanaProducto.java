package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class VentanaProducto extends JFrame {

	private PanelProductoSuperior panelSuperior;
    private PanelProductoDinamico panelDinamico;

    public VentanaProducto() {
        setTitle("Editar/Crear Producto");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(false);

        panelSuperior = new PanelProductoSuperior();
        panelDinamico = new PanelProductoDinamico();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDinamico, BorderLayout.CENTER);
    }

    public PanelProductoSuperior getPanelSuperior() {
        return panelSuperior;
    }

    public PanelProductoDinamico getPanelDinamico() {
        return panelDinamico;
    }
}

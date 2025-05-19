package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class VentanaCreacionEquipo extends JFrame {

    private JTextField campoId;
    private JTextField campoNombre;
    private JComboBox<String> comboTorneo;
    private JButton botonCrear;

    public VentanaCreacionEquipo() {
        setTitle("Crear Nuevo Equipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelCampos.add(new JLabel("ID del Equipo:"));
        campoId = new JTextField();
        panelCampos.add(campoId);

        panelCampos.add(new JLabel("Nombre del Equipo:"));
        campoNombre = new JTextField();
        panelCampos.add(campoNombre);

        panelCampos.add(new JLabel("Torneo:"));
        comboTorneo = new JComboBox<>();
        comboTorneo.addItem("Seleccionar");
        // Aquí luego agregas los torneos reales desde el controlador
        panelCampos.add(comboTorneo);

        botonCrear = new JButton("Crear Equipo");
        botonCrear.setActionCommand("CREAR_EQUIPO");

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(botonCrear);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    // —— Getters públicos ——

    public JTextField getCampoId() {
        return campoId;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JComboBox<String> getComboTorneo() {
        return comboTorneo;
    }

    public JButton getBotonCrear() {
        return botonCrear;
    }
}

package co.edu.unbosque.vista.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class PanelGestionEquipos extends JPanel {

    private JTextField campoNombreEquipo;
    private JComboBox<String> comboTorneos;
    private JButton crearBtn;
    private JButton actualizarBtn;
    private JButton eliminarBtn;
    private JTable tablaEquipos;
    private DefaultTableModel modeloTabla;

    public PanelGestionEquipos() {
        setLayout(new BorderLayout(15, 15));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- Panel de entrada (nombre + torneo)
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));

        campoNombreEquipo = new JTextField();
        comboTorneos = new JComboBox<>();
        comboTorneos.addItem("Seleccionar torneo");

        panelEntrada.add(new JLabel("Nombre del equipo:"));
        panelEntrada.add(campoNombreEquipo);
        panelEntrada.add(new JLabel("Torneo asignado:"));
        panelEntrada.add(comboTorneos);

        add(panelEntrada, BorderLayout.NORTH);

        // --- Tabla
        String[] columnas = {"ID", "Nombre", "Torneo"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEquipos = new JTable(modeloTabla);
        add(new JScrollPane(tablaEquipos), BorderLayout.CENTER);

        // --- Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        crearBtn = new JButton("Crear equipo");
        crearBtn.setActionCommand("CREAR_EQUIPO");

        actualizarBtn = new JButton("Actualizar equipo");
        actualizarBtn.setActionCommand("ACTUALIZAR_EQUIPO");

        eliminarBtn = new JButton("Eliminar equipo");
        eliminarBtn.setActionCommand("ELIMINAR_EQUIPO");

        panelBotones.add(crearBtn);
        panelBotones.add(actualizarBtn);
        panelBotones.add(eliminarBtn);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters

    public JTextField getCampoNombreEquipo() {
        return campoNombreEquipo;
    }

    public JComboBox<String> getComboTorneos() {
        return comboTorneos;
    }

    public JButton getCrearBtn() {
        return crearBtn;
    }

    public JButton getActualizarBtn() {
        return actualizarBtn;
    }

    public JButton getEliminarBtn() {
        return eliminarBtn;
    }

    public JTable getTablaEquipos() {
        return tablaEquipos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}

package co.edu.unbosque.vista.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelTorneoAdmin extends JPanel {

    private JTextField campoId;
    private JTextField campoNombre;
    private JComboBox<String> comboJuego;
    private JComboBox<String> comboEstado;
    private JTextField campoIdEquipo;
    private JButton botonCrear;
    private JButton botonAsignarEquipo;
    private JButton botonRemoverEquipo;
    private JTable tablaTorneos;
    private DefaultTableModel modeloTabla;

    public PanelTorneoAdmin() {
        setLayout(new BorderLayout(10, 10));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelCampos = new JPanel(new GridLayout(5, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Datos del torneo"));

        campoId = new JTextField();
        campoNombre = new JTextField();

        comboJuego = new JComboBox<>();
        comboJuego.addItem("Seleccionar");
        comboJuego.addItem("FIFA");
        comboJuego.addItem("Rocket League");
        comboJuego.addItem("Formula 1");
        comboJuego.addItem("Gran Turismo");

        comboEstado = new JComboBox<>();
        comboEstado.addItem("Seleccionar");
        comboEstado.addItem("PENDIENTE");
        comboEstado.addItem("EN_CURSO");
        comboEstado.addItem("FINALIZADO");

        campoIdEquipo = new JTextField();

        panelCampos.add(new JLabel("ID del Torneo:"));
        panelCampos.add(campoId);

        panelCampos.add(new JLabel("Nombre del Torneo:"));
        panelCampos.add(campoNombre);

        panelCampos.add(new JLabel("Juego:"));
        panelCampos.add(comboJuego);

        panelCampos.add(new JLabel("Estado del Torneo:"));
        panelCampos.add(comboEstado);

        panelCampos.add(new JLabel("ID de Equipo a Asignar/Remover:"));
        panelCampos.add(campoIdEquipo);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonCrear = new JButton("Crear Torneo");
        botonCrear.setActionCommand("CREAR_TORNEO");

        botonAsignarEquipo = new JButton("Asignar Equipo");
        botonAsignarEquipo.setActionCommand("ASIGNAR_EQUIPO_TORNEO");

        botonRemoverEquipo = new JButton("Remover Equipo");
        botonRemoverEquipo.setActionCommand("REMOVER_EQUIPO_TORNEO");

        panelBotones.add(botonCrear);
        panelBotones.add(botonAsignarEquipo);
        panelBotones.add(botonRemoverEquipo);

        JPanel panelSuperior = new JPanel(new BorderLayout(10, 10));
        panelSuperior.add(panelCampos, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);

        // Tabla de torneos
        String[] columnas = { "ID", "Nombre", "Juego", "Estado", "Equipos Inscritos", "Partidas" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaTorneos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaTorneos);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Lista de torneos"));

        add(scrollTabla, BorderLayout.CENTER);
    }

    // Getters
    public JTextField getCampoId() {
        return campoId;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JComboBox<String> getComboJuego() {
        return comboJuego;
    }

    public JComboBox<String> getComboEstado() {
        return comboEstado;
    }

    public JTextField getCampoIdEquipo() {
        return campoIdEquipo;
    }

    public JButton getBotonCrear() {
        return botonCrear;
    }

    public JButton getBotonAsignarEquipo() {
        return botonAsignarEquipo;
    }

    public JButton getBotonRemoverEquipo() {
        return botonRemoverEquipo;
    }

    public JTable getTablaTorneos() {
        return tablaTorneos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}

package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa una ventana para la creación de equipos dentro del módulo de administración.
 * Permite ingresar el ID del equipo, su nombre y seleccionar el torneo en el que participará.
 */
public class VentanaCreacionEquipo extends JFrame {

    private JTextField campoId;
    private JTextField campoNombre;
    private JComboBox<String> comboTorneo;
    private JButton botonCrear;

    /**
     * Constructor que inicializa la ventana con su diseño y configuraciones básicas.
     */
    public VentanaCreacionEquipo() {
        setTitle("Crear Nuevo Equipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        setVisible(false);
    }

    /**
     * Inicializa los componentes de la ventana, incluyendo los campos de entrada y botones.
     */
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
        panelCampos.add(comboTorneo);

        botonCrear = new JButton("Crear Equipo");
        botonCrear.setActionCommand("CREAR_EQUIPO");

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(botonCrear);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    // Métodos de acceso a los componentes de la ventana

    /**
     * Devuelve el campo de entrada para el ID del equipo.
     * 
     * @return Campo de texto para el ID del equipo.
     */
    public JTextField getCampoId() {
        return campoId;
    }

    /**
     * Devuelve el campo de entrada para el nombre del equipo.
     * 
     * @return Campo de texto para el nombre del equipo.
     */
    public JTextField getCampoNombre() {
        return campoNombre;
    }

    /**
     * Devuelve el combo box para seleccionar el torneo.
     * 
     * @return Combo box con la lista de torneos disponibles.
     */
    public JComboBox<String> getComboTorneo() {
        return comboTorneo;
    }

    /**
     * Devuelve el botón para crear el equipo.
     * 
     * @return Botón para ejecutar la acción de creación de equipo.
     */
    public JButton getBotonCrear() {
        return botonCrear;
    }
}
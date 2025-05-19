package co.edu.unbosque.vista.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Representa un panel para la gestión de equipos dentro del sistema de administración.
 * Permite la creación, actualización y eliminación de equipos, además de asignarlos a torneos.
 */
public class PanelGestionEquipos extends JPanel {

    private JTextField campoNombreEquipo;
    private JComboBox<String> comboTorneos;
    private JButton crearBtn;
    private JButton actualizarBtn;
    private JButton eliminarBtn;
    private JTable tablaEquipos;
    private DefaultTableModel modeloTabla;

    /**
     * Constructor que inicializa el panel con su diseño y configuración.
     */
    public PanelGestionEquipos() {
        setLayout(new BorderLayout(15, 15));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos del panel, incluyendo los campos de entrada, botones y tabla de equipos.
     */
    private void inicializarComponentes() {
        // Panel de entrada para nombre del equipo y torneo
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));

        campoNombreEquipo = new JTextField();
        comboTorneos = new JComboBox<>();
        comboTorneos.addItem("Seleccionar torneo");

        panelEntrada.add(new JLabel("Nombre del equipo:"));
        panelEntrada.add(campoNombreEquipo);
        panelEntrada.add(new JLabel("Torneo asignado:"));
        panelEntrada.add(comboTorneos);

        add(panelEntrada, BorderLayout.NORTH);

        // Configuración de la tabla de equipos
        String[] columnas = { "ID", "Nombre", "Torneo" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEquipos = new JTable(modeloTabla);
        add(new JScrollPane(tablaEquipos), BorderLayout.CENTER);

        // Panel de botones para la gestión de equipos
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

    // Métodos de acceso a los componentes del panel

    /**
     * Devuelve el campo de texto para ingresar el nombre del equipo.
     * 
     * @return Campo de texto para el nombre del equipo.
     */
    public JTextField getCampoNombreEquipo() {
        return campoNombreEquipo;
    }

    /**
     * Devuelve el combo box de selección de torneos.
     * 
     * @return Combo box con la lista de torneos disponibles.
     */
    public JComboBox<String> getComboTorneos() {
        return comboTorneos;
    }

    /**
     * Devuelve el botón para crear un nuevo equipo.
     * 
     * @return Botón para la creación de un equipo.
     */
    public JButton getCrearBtn() {
        return crearBtn;
    }

    /**
     * Devuelve el botón para actualizar un equipo existente.
     * 
     * @return Botón para actualizar un equipo.
     */
    public JButton getActualizarBtn() {
        return actualizarBtn;
    }

    /**
     * Devuelve el botón para eliminar un equipo.
     * 
     * @return Botón para eliminar un equipo.
     */
    public JButton getEliminarBtn() {
        return eliminarBtn;
    }

    /**
     * Devuelve la tabla que muestra los equipos gestionados.
     * 
     * @return Tabla de equipos.
     */
    public JTable getTablaEquipos() {
        return tablaEquipos;
    }

    /**
     * Devuelve el modelo de la tabla de equipos.
     * 
     * @return Modelo de la tabla con los datos de los equipos.
     */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Panel que muestra los equipos a los que pertenece un jugador.
 * Permite visualizar detalles y abandonar un equipo seleccionado.
 */
public class SubPanelMisEquiposJugador extends JPanel {

    private JTable tablaMisEquipos;
    private DefaultTableModel modeloTablaEquipos;
    private JScrollPane scrollPaneEquipos;
    private JButton btnVerDetallesEquipo; 
    private JButton btnAbandonarEquipo;  

    /**
     * Construye el panel con el diseño, la tabla de equipos y botones de acción.
     */
    public SubPanelMisEquiposJugador() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Mis Equipos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID Equipo", "Nombre del Equipo", "Juego Principal", "Rol en el Equipo"};
        modeloTablaEquipos = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tablaMisEquipos = new JTable(modeloTablaEquipos);
        tablaMisEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMisEquipos.setFillsViewportHeight(true);
        scrollPaneEquipos = new JScrollPane(tablaMisEquipos);
        add(scrollPaneEquipos, BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnVerDetallesEquipo = new JButton("Ver Detalles del Equipo Seleccionado");
        btnAbandonarEquipo = new JButton("Abandonar Equipo Seleccionado");

        btnVerDetallesEquipo.setActionCommand("VER_DETALLES_EQUIPO_JUGADOR");
        btnAbandonarEquipo.setActionCommand("ABANDONAR_EQUIPO_JUGADOR");

        panelAcciones.add(btnVerDetallesEquipo);
        panelAcciones.add(btnAbandonarEquipo);
        add(panelAcciones, BorderLayout.SOUTH);
    }

    /**
     * Actualiza la tabla de equipos con los datos del jugador.
     * Este método debe ser llamado por el controlador con los datos reales.
     */
    public void actualizarTablaEquipos() {
        modeloTablaEquipos.setRowCount(0); // Limpiar tabla

        // Ejemplo con datos falsos. Reemplazar con datos reales desde el controlador.
        modeloTablaEquipos.addRow(new Object[]{"EQ001", "Los Invencibles", "Valorant", "Duelista"});
        modeloTablaEquipos.addRow(new Object[]{"EQ002", "Titanes del Rift", "League of Legends", "Mid Laner"});
    }

    /**
     * Retorna la tabla que muestra los equipos del jugador.
     *
     * @return la tabla de equipos.
     */
    public JTable getTablaMisEquipos() {
        return tablaMisEquipos;
    }

    /**
     * Retorna el botón para ver detalles del equipo seleccionado.
     *
     * @return el botón de ver detalles.
     */
    public JButton getBtnVerDetallesEquipo() {
        return btnVerDetallesEquipo;
    }

    /**
     * Retorna el botón para abandonar el equipo seleccionado.
     *
     * @return el botón de abandonar equipo.
     */
    public JButton getBtnAbandonarEquipo() {
        return btnAbandonarEquipo;
    }

    /**
     * Método de ejemplo para cargar equipos falsos.
     * Puede ser usado para pruebas temporales.
     */
    private void cargarEquiposDeEjemplo() {
        actualizarTablaEquipos();
    }
}

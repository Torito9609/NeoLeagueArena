package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SubPanelMisEquiposJugador extends JPanel {

    private JTable tablaMisEquipos;
    private DefaultTableModel modeloTablaEquipos;
    private JScrollPane scrollPaneEquipos;
    private JButton btnVerDetallesEquipo; 
    private JButton btnAbandonarEquipo;  

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

        // Cargar datos de ejemplo o dejar para el controlador
        // cargarEquiposDeEjemplo();
    }

    // Método para que el controlador actualice los datos de la tabla
    public void actualizarTablaEquipos(/* List<EquipoDto> equiposDelJugador */) {
        modeloTablaEquipos.setRowCount(0); // Limpiar tabla
        // for (EquipoDto equipo : equiposDelJugador) {
        //     Object[] fila = {
        //         equipo.getId(),
        //         equipo.getNombre(),
        //         equipo.getJuegoPrincipal() != null ? equipo.getJuegoPrincipal().getNombre() : "N/A",
        //         "Rol del jugador en este equipo" // Este dato vendría de la asignación o de otro lugar
        //     };
        //     modeloTablaEquipos.addRow(fila);
        // }
        System.out.println("SubPanelMisEquiposJugador: actualizarTablaEquipos() necesita implementación con datos reales.");
        // Ejemplo con datos falsos:
        modeloTablaEquipos.addRow(new Object[]{"EQ001", "Los Invencibles", "Valorant", "Duelista"});
        modeloTablaEquipos.addRow(new Object[]{"EQ002", "Titanes del Rift", "League of Legends", "Mid Laner"});
    }

    public JTable getTablaMisEquipos() {
        return tablaMisEquipos;
    }

    public JButton getBtnVerDetallesEquipo() {
        return btnVerDetallesEquipo;
    }

    public JButton getBtnAbandonarEquipo() {
        return btnAbandonarEquipo;
    }


    private void cargarEquiposDeEjemplo() {
        actualizarTablaEquipos(/* pasar una lista vacía o de ejemplo */);
    }
}
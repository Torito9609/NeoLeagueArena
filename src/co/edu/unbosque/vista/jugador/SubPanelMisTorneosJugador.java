package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Subpanel que muestra al jugador una tabla con los torneos en los que ha participado.
 * <p>
 * Incluye un botón para ver detalles del torneo seleccionado y una tabla no editable
 * con información como ID, nombre, juego, equipo participante y estado actual.
 */
public class SubPanelMisTorneosJugador extends JPanel {

    private JTable tablaMisTorneos;
    private DefaultTableModel modeloTablaTorneos;
    private JScrollPane scrollPaneTorneos;
    private JButton btnVerDetallesTorneo;

    /**
     * Constructor que inicializa y organiza los componentes del subpanel.
     * Crea una tabla para listar los torneos y un botón para visualizar detalles del torneo seleccionado.
     */
    public SubPanelMisTorneosJugador() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Mis Torneos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID Torneo", "Nombre del Torneo", "Juego", "Equipo Participante", "Estado Actual"};
        modeloTablaTorneos = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaMisTorneos = new JTable(modeloTablaTorneos);
        tablaMisTorneos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMisTorneos.setFillsViewportHeight(true);

        scrollPaneTorneos = new JScrollPane(tablaMisTorneos);
        add(scrollPaneTorneos, BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnVerDetallesTorneo = new JButton("Ver Detalles del Torneo Seleccionado");
        btnVerDetallesTorneo.setActionCommand("VER_DETALLES_TORNEO_JUGADOR");
        panelAcciones.add(btnVerDetallesTorneo);
        add(panelAcciones, BorderLayout.SOUTH);

        // cargarTorneosDeEjemplo();
    }

    /**
     * Método para actualizar la tabla con los torneos en los que participa el jugador.
     * <p>
     * Actualmente agrega datos de ejemplo y muestra un mensaje en consola.
     * Se recomienda implementar con datos reales en producción.
     */
    public void actualizarTablaTorneos(/* List<ParticipacionTorneoDto> participaciones */) {
        modeloTablaTorneos.setRowCount(0);
        // for (ParticipacionTorneoDto participacion : participaciones) {
        //     Object[] fila = {
        //         participacion.getTorneo().getId(),
        //         participacion.getTorneo().getNombre(),
        //         participacion.getTorneo().getJuego().getNombre(),
        //         participacion.getEquipo().getNombre(),
        //         "Estado del jugador/equipo en el torneo"
        //     };
        //     modeloTablaTorneos.addRow(fila);
        // }
        System.out.println("SubPanelMisTorneosJugador: actualizarTablaTorneos() necesita implementación con datos reales.");
        modeloTablaTorneos.addRow(new Object[]{"TRN001", "Copa Verano NeoLeague", "Valorant", "Los Invencibles", "Cuartos de Final"});
    }

    /**
     * Obtiene la tabla que contiene los torneos del jugador.
     *
     * @return tabla de torneos.
     */
    public JTable getTablaMisTorneos() {
        return tablaMisTorneos;
    }

    /**
     * Devuelve el botón para ver detalles del torneo seleccionado.
     *
     * @return botón de ver detalles del torneo.
     */
    public JButton getBtnVerDetallesTorneo() {
        return btnVerDetallesTorneo;
    }
}

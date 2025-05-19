package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Panel que muestra las partidas asociadas al jugador.
 * Permite filtrar partidas por estado y ver los detalles de una partida seleccionada.
 */
public class SubPanelMisPartidasJugador extends JPanel {

    private JTable tablaMisPartidas;
    private DefaultTableModel modeloTablaPartidas;
    private JScrollPane scrollPanePartidas;
    private JComboBox<String> filtroEstadoPartida; 
    private JButton btnVerDetallesPartida;

    /**
     * Construye el panel con los componentes gráficos para listar y filtrar partidas del jugador.
     */
    public SubPanelMisPartidasJugador() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Mis Partidas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(titulo, BorderLayout.NORTH);

        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFiltros.add(new JLabel("Filtrar por:"));
        filtroEstadoPartida = new JComboBox<>(new String[]{"Todas", "Próximas Partidas", "Partidas Jugadas"});
        filtroEstadoPartida.setActionCommand("FILTRAR_PARTIDAS_JUGADOR");
        panelFiltros.add(filtroEstadoPartida);
        panelSuperior.add(panelFiltros, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);

        String[] columnas = {"ID Partida", "Fecha", "Hora", "Juego", "Equipo Local", "Equipo Visitante", "Resultado/Estado"};
        modeloTablaPartidas = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaMisPartidas = new JTable(modeloTablaPartidas);
        tablaMisPartidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMisPartidas.setFillsViewportHeight(true);
        scrollPanePartidas = new JScrollPane(tablaMisPartidas);
        add(scrollPanePartidas, BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnVerDetallesPartida = new JButton("Ver Detalles de la Partida Seleccionada");
        btnVerDetallesPartida.setActionCommand("VER_DETALLES_PARTIDA_JUGADOR");
        panelAcciones.add(btnVerDetallesPartida);
        add(panelAcciones, BorderLayout.SOUTH);
    }

    /**
     * Actualiza los datos de la tabla de partidas, aplicando filtros si es necesario.
     * Este método debe ser llamado por el controlador con los datos reales.
     */
    public void actualizarTablaPartidas() {
        modeloTablaPartidas.setRowCount(0);

        // Datos de ejemplo. Reemplazar por datos reales desde el controlador.
        modeloTablaPartidas.addRow(new Object[]{"P001", "2025-05-20", "18:00", "Valorant", "Los Invencibles", "Team Rival", "Próxima"});
        modeloTablaPartidas.addRow(new Object[]{"P002", "2025-05-15", "20:00", "Valorant", "Los Invencibles", "Otro Equipo", "Ganada 2-0"});
    }

    /**
     * Retorna la tabla que muestra las partidas del jugador.
     *
     * @return la tabla de partidas.
     */
    public JTable getTablaMisPartidas() {
        return tablaMisPartidas;
    }

    /**
     * Retorna el componente desplegable para filtrar partidas por estado.
     *
     * @return el combo box de filtro de estado.
     */
    public JComboBox<String> getFiltroEstadoPartida() {
        return filtroEstadoPartida;
    }

    /**
     * Retorna el botón para ver los detalles de la partida seleccionada.
     *
     * @return el botón de ver detalles de partida.
     */
    public JButton getBtnVerDetallesPartida() {
        return btnVerDetallesPartida;
    }
}

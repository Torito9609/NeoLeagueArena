package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa un panel que muestra la lista de equipos del entrenador.
 * Permite visualizar los equipos y acceder a más detalles mediante botones interactivos.
 */
public class PanelEquiposEntrenador extends JPanel {

    private JPanel panelListaEquipos;
    private Map<String, JButton> botonesVerDetallesEquipos;

    /**
     * Constructor que inicializa el panel y su lista de equipos.
     */
    public PanelEquiposEntrenador() {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 123, 255), 1),
            " Mis Equipos ",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            new Font("Arial", Font.BOLD, 16),
            new Color(0, 123, 255)
        ));

        panelListaEquipos = new JPanel();
        panelListaEquipos.setLayout(new BoxLayout(panelListaEquipos, BoxLayout.Y_AXIS));
        panelListaEquipos.setOpaque(false);
        panelListaEquipos.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Inicializar el mapa de botones
        botonesVerDetallesEquipos = new HashMap<>();

        // Agregar equipos de ejemplo
        agregarEquipo("Nacional", "imagenes/nacional_logo.png");
        agregarEquipo("Cali", "imagenes/cali_logo.png");

        JScrollPane scrollPane = new JScrollPane(panelListaEquipos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Agrega un equipo a la lista del entrenador.
     *
     * @param nombreEquipo Nombre del equipo.
     * @param rutaLogo Ruta del logo del equipo.
     */
    public void agregarEquipo(String nombreEquipo, String rutaLogo) {
        JPanel panelEquipoItem = new JPanel(new BorderLayout(10, 0));
        panelEquipoItem.setOpaque(false);
        panelEquipoItem.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
            new EmptyBorder(10, 5, 10, 5)
        ));
        panelEquipoItem.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        JLabel lblLogo = new JLabel();
        ImageIcon logoIcon = new ImageIcon(rutaLogo);

        if (logoIcon.getImageLoadStatus() == MediaTracker.COMPLETE && logoIcon.getIconWidth() > 0) {
            Image img = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(img));
        } else {
            System.err.println("Advertencia: No se pudo cargar el logo: " + rutaLogo);
            lblLogo.setText("NoLogo");
            lblLogo.setPreferredSize(new Dimension(40, 40));
            lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
            lblLogo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }
        lblLogo.setPreferredSize(new Dimension(40, 40));
        panelEquipoItem.add(lblLogo, BorderLayout.WEST);

        JLabel lblNombreEquipo = new JLabel(nombreEquipo);
        lblNombreEquipo.setFont(new Font("Arial", Font.BOLD, 14));
        panelEquipoItem.add(lblNombreEquipo, BorderLayout.CENTER);

        JButton btnVerDetalles = new JButton("Ver detalles");
        btnVerDetalles.setFont(new Font("Arial", Font.PLAIN, 12));
        btnVerDetalles.setPreferredSize(new Dimension(100, 25));
        btnVerDetalles.setActionCommand("DETALLES_" + nombreEquipo);
        panelEquipoItem.add(btnVerDetalles, BorderLayout.EAST);

        // Guardar el botón en el mapa para acceso externo
        botonesVerDetallesEquipos.put(nombreEquipo, btnVerDetalles);

        panelListaEquipos.add(panelEquipoItem);
        panelListaEquipos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelListaEquipos.revalidate();
        panelListaEquipos.repaint();
    }

    /**
     * Devuelve el mapa con los botones de ver detalles de los equipos.
     *
     * @return Mapa con los botones de los equipos.
     */
    public Map<String, JButton> getBotonesVerDetallesEquipos() {
        return botonesVerDetallesEquipos;
    }

    /**
     * Limpia la lista de equipos y los botones asociados.
     */
    public void limpiarEquipos() {
        panelListaEquipos.removeAll();
        botonesVerDetallesEquipos.clear();
        panelListaEquipos.revalidate();
        panelListaEquipos.repaint();
    }
}
package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Representa la ventana principal de la interfaz del entrenador en NeoLeague Arena.
 * Organiza los distintos paneles de información, opciones y partidas.
 */
public class VentanaPrincipalEntrenador extends JFrame {

    private PanelPerfilEntrenador panelPerfil;
    private PanelEquiposEntrenador panelEquipos;
    private PanelOpcionesEntrenador panelOpciones;
    private PanelProximasPartidas panelProximasPartidas;
    private JButton btnCerrarSesion;

    private String nombreEntrenador = "Andrés Toro";
    private String idEntrenador = "ID 1028796325";
    private ImageIcon fotoPerfilEntrenador;

    /**
     * Constructor de la clase que inicializa la ventana principal y sus componentes.
     */
    public VentanaPrincipalEntrenador() {
        String rutaImagenPerfil = "imagenes/default_perfil.jpg";
        fotoPerfilEntrenador = new ImageIcon(rutaImagenPerfil);

        if (fotoPerfilEntrenador.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.err.println("Advertencia: No se pudo cargar la imagen de perfil: " + rutaImagenPerfil);
        }

        setTitle("NeoLeague Arena - Entrenador");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        inicializarComponentes();
        setVisible(true);
    }

    /**
     * Inicializa los componentes y paneles de la interfaz del entrenador.
     */
    private void inicializarComponentes() {
        JPanel panelSuperior = new JPanel(new BorderLayout(10, 0));
        panelSuperior.setOpaque(false);

        panelPerfil = new PanelPerfilEntrenador(nombreEntrenador, idEntrenador, fotoPerfilEntrenador);
        panelSuperior.add(panelPerfil, BorderLayout.WEST);

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBackground(new Color(220, 53, 69));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 12));
        JPanel panelBtnCerrarSesion = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBtnCerrarSesion.setOpaque(false);
        panelBtnCerrarSesion.add(btnCerrarSesion);
        panelSuperior.add(panelBtnCerrarSesion, BorderLayout.EAST);
        btnCerrarSesion.setPreferredSize(new Dimension(130, 30));

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();

        panelEquipos = new PanelEquiposEntrenador();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 10);
        panelCentral.add(panelEquipos, gbc);

        panelOpciones = new PanelOpcionesEntrenador();
        gbc.gridx = 1;
        gbc.weightx = 0.6;
        gbc.insets = new Insets(0, 0, 0, 0);
        panelCentral.add(panelOpciones, gbc);

        add(panelCentral, BorderLayout.CENTER);

        panelProximasPartidas = new PanelProximasPartidas();
        add(panelProximasPartidas, BorderLayout.SOUTH);
    }

    /**
     * Devuelve el botón de cerrar sesión.
     * 
     * @return Botón de cerrar sesión.
     */
    public JButton getBtnCerrarSesion() { return btnCerrarSesion; }

    /**
     * Devuelve el panel de perfil del entrenador.
     * 
     * @return Panel de perfil.
     */
    public PanelPerfilEntrenador getPanelPerfil() { return panelPerfil; }

    /**
     * Devuelve el panel de equipos del entrenador.
     * 
     * @return Panel de equipos.
     */
    public PanelEquiposEntrenador getPanelEquipos() { return panelEquipos; }

    /**
     * Devuelve el panel de opciones del entrenador.
     * 
     * @return Panel de opciones.
     */
    public PanelOpcionesEntrenador getPanelOpciones() { return panelOpciones; }

    /**
     * Devuelve el panel de próximas partidas del entrenador.
     * 
     * @return Panel de próximas partidas.
     */
    public PanelProximasPartidas getPanelProximasPartidas() { return panelProximasPartidas; }
}
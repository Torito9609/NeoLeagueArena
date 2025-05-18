package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipalEntrenador extends JFrame {

    private PanelPerfilEntrenador panelPerfil;
    private PanelEquiposEntrenador panelEquipos;
    private PanelOpcionesEntrenador panelOpciones;
    private PanelProximasPartidas panelProximasPartidas;
    private JButton btnCerrarSesion;

    private String nombreEntrenador = "Andrés Toro";
    private String idEntrenador = "ID 1028796325";
    private ImageIcon fotoPerfilEntrenador;

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
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panelSuperior = new JPanel(new BorderLayout(10,0));
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

    // Getters para los componentes principales y paneles
    public JButton getBtnCerrarSesion() { return btnCerrarSesion; }
    public PanelPerfilEntrenador getPanelPerfil() { return panelPerfil; }
    public PanelEquiposEntrenador getPanelEquipos() { return panelEquipos; }
    public PanelOpcionesEntrenador getPanelOpciones() { return panelOpciones; }
    public PanelProximasPartidas getPanelProximasPartidas() { return panelProximasPartidas; }


   
}
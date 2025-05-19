package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Representa el panel de perfil del entrenador en la interfaz.
 * Muestra la foto de perfil, nombre, identificación y rol del entrenador.
 */
public class PanelPerfilEntrenador extends JPanel {

    private JLabel lblNombreEntrenador;
    private JLabel lblIdEntrenador;
    private JLabel lblFotoPerfil;
    private JLabel lblRol;

    /**
     * Constructor que inicializa el panel con la información del entrenador.
     *
     * @param nombre Nombre del entrenador.
     * @param id Identificación del entrenador.
     * @param foto Imagen de perfil del entrenador.
     */
    public PanelPerfilEntrenador(String nombre, String id, ImageIcon foto) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        setOpaque(false);

        JPanel panelFoto = new JPanel();
        panelFoto.setOpaque(false);
        lblFotoPerfil = new JLabel();

        if (foto != null && foto.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image img = foto.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            lblFotoPerfil.setIcon(new ImageIcon(img));
        } else {
            lblFotoPerfil.setText("NoImg");
            lblFotoPerfil.setPreferredSize(new Dimension(80, 80));
            lblFotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
            lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }
        lblFotoPerfil.setPreferredSize(new Dimension(80, 80));
        lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        panelFoto.add(lblFotoPerfil);
        add(panelFoto);

        JPanel panelInfoTexto = new JPanel();
        panelInfoTexto.setOpaque(false);
        panelInfoTexto.setLayout(new BoxLayout(panelInfoTexto, BoxLayout.Y_AXIS));

        lblRol = new JLabel("ENTRENADOR");
        lblRol.setFont(new Font("Arial", Font.BOLD, 14));
        lblRol.setForeground(Color.WHITE);
        lblRol.setBackground(new Color(0, 123, 255));
        lblRol.setOpaque(true);
        lblRol.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panelRolWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelRolWrapper.setOpaque(false);
        lblRol.setBorder(new EmptyBorder(5, 10, 5, 10));
        panelRolWrapper.add(lblRol);
        panelInfoTexto.add(panelRolWrapper);

        panelInfoTexto.add(Box.createRigidArea(new Dimension(0, 8)));

        lblNombreEntrenador = new JLabel(nombre);
        lblNombreEntrenador.setFont(new Font("Arial", Font.BOLD, 18));
        panelInfoTexto.add(lblNombreEntrenador);

        lblIdEntrenador = new JLabel(id);
        lblIdEntrenador.setFont(new Font("Arial", Font.PLAIN, 12));
        lblIdEntrenador.setForeground(Color.DARK_GRAY);
        panelInfoTexto.add(lblIdEntrenador);

        add(panelInfoTexto);
    }

    // Métodos de acceso y modificación de atributos
    public void setLblNombreEntrenador(JLabel lblNombreEntrenador) { this.lblNombreEntrenador = lblNombreEntrenador; }
    public void setLblIdEntrenador(JLabel lblIdEntrenador) { this.lblIdEntrenador = lblIdEntrenador; }
    public void setLblFotoPerfil(JLabel lblFotoPerfil) { this.lblFotoPerfil = lblFotoPerfil; }
    public void setLblRol(JLabel lblRol) { this.lblRol = lblRol; }
}
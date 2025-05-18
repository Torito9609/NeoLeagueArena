package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage; // Para el placeholder

public class PanelInfoJugadorSuperior extends JPanel {
    private JLabel lblFotoJugador;
    private JLabel lblGamerTag; 
    private JLabel lblIdJugador;
    private JButton btnCerrarSesion;
   

    public PanelInfoJugadorSuperior(String idJugador, String gamerTag, String rutaFotoActual) { 
        setLayout(new BorderLayout(10, 0));
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setBackground(Color.decode("#2c3e50"));

        JPanel panelInfoIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelInfoIzquierda.setOpaque(false);

        lblFotoJugador = new JLabel();
        actualizarFoto(rutaFotoActual);
        lblFotoJugador.setPreferredSize(new Dimension(50, 50));
        lblFotoJugador.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        panelInfoIzquierda.add(lblFotoJugador);

        JPanel panelTextos = new JPanel();
        panelTextos.setLayout(new BoxLayout(panelTextos, BoxLayout.Y_AXIS));
        panelTextos.setOpaque(false);

        lblGamerTag = new JLabel(gamerTag); // Usar gamerTag
        lblGamerTag.setForeground(Color.WHITE);
        lblGamerTag.setFont(new Font("Arial", Font.BOLD, 16));
        panelTextos.add(lblGamerTag);

        lblIdJugador = new JLabel("ID: " + idJugador);
        lblIdJugador.setForeground(Color.LIGHT_GRAY);
        lblIdJugador.setFont(new Font("Arial", Font.PLAIN, 12));
        panelTextos.add(lblIdJugador);
        panelInfoIzquierda.add(panelTextos);

        add(panelInfoIzquierda, BorderLayout.WEST);

        btnCerrarSesion = new JButton("Cerrar Sesión");
        // ... (estilos del botón como estaban)
        btnCerrarSesion.setBackground(new Color(231, 76, 60));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFocusPainted(false);
        JPanel panelBotonDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonDerecha.setOpaque(false);
        panelBotonDerecha.add(btnCerrarSesion);
        add(panelBotonDerecha, BorderLayout.EAST);
    }

    public void actualizarFoto(String nuevaRutaFoto) {
        ImageIcon icono;
        if (nuevaRutaFoto != null && !nuevaRutaFoto.isEmpty() && new java.io.File(nuevaRutaFoto).exists()) {
            icono = new ImageIcon(nuevaRutaFoto);
        } else {
            icono = createPlaceholderIcon(50, 50, "Foto");
        }

        if (icono.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image img = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            lblFotoJugador.setIcon(new ImageIcon(img));
        } else {
            lblFotoJugador.setIcon(createPlaceholderIcon(50, 50, "Err"));
            System.err.println("PanelInfoJugadorSuperior: No se pudo cargar la imagen: " + nuevaRutaFoto);
        }
        this.revalidate();
        this.repaint();
    }

    public void actualizarGamerTag(String nuevoGamerTag) {
        lblGamerTag.setText(nuevoGamerTag);
    }

    public void actualizarId(String nuevoId) {
        lblIdJugador.setText("ID: " + nuevoId);
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    private ImageIcon createPlaceholderIcon(int width, int height, String text) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.WHITE);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        FontMetrics fm = g2d.getFontMetrics();
        int x = (width - fm.stringWidth(text)) / 2;
        int y = (fm.getAscent() + (height - (fm.getAscent() + fm.getDescent())) / 2);
        g2d.drawString(text, x, y);
        g2d.dispose();
        return new ImageIcon(image);
    }
}
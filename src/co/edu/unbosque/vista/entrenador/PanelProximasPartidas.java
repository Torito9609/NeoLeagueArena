package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Representa un panel que muestra las próximas partidas en la interfaz del entrenador.
 * Permite visualizar una lista de encuentros programados con información relevante.
 */
public class PanelProximasPartidas extends JPanel {

    private JPanel panelListaPartidas;

    /**
     * Constructor que inicializa el panel y configura su apariencia.
     */
    public PanelProximasPartidas() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 220));
        setOpaque(false);
        setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(50,50,50), 1),
            " Próximas Partidas ",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            new Font("Arial", Font.BOLD, 16),
            new Color(50,50,50)
        ));

        panelListaPartidas = new JPanel();
        panelListaPartidas.setLayout(new BoxLayout(panelListaPartidas, BoxLayout.Y_AXIS));
        panelListaPartidas.setOpaque(false);
        panelListaPartidas.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Datos de ejemplo de partidas
        agregarPartida("28 abr, 2024", "18:00", "GTA V", "Nacional-Bolinches", new Color(255, 152, 0));
        agregarPartida("29 abr, 2024", "20:00", "Fortnite", "Cali-Picapiedras", new Color(106, 27, 154));
        agregarPartida("30 abr, 2024", "19:30", "FIFA 2025", "Millos-Patacones", new Color(0, 105, 92));
        agregarPartida("01 may, 2024", "21:00", "Rocket League", "SantaFe-Arepas", new Color(211, 47, 47));

        JScrollPane scrollPane = new JScrollPane(panelListaPartidas);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Agrega una nueva partida a la lista de próximas partidas.
     * 
     * @param fecha  Fecha de la partida.
     * @param hora   Hora de la partida.
     * @param juego  Nombre del juego.
     * @param equipos Equipos que participan en la partida.
     * @param colorJuego Color asociado al juego.
     */
    public void agregarPartida(String fecha, String hora, String juego, String equipos, Color colorJuego) {
        PanelPartido panelPartido = new PanelPartido(fecha, hora, juego, equipos, colorJuego);
        panelListaPartidas.add(panelPartido);
        panelListaPartidas.add(Box.createRigidArea(new Dimension(0, 8)));
        panelListaPartidas.revalidate();
        panelListaPartidas.repaint();
    }

    /**
     * Limpia la lista de partidas, eliminando todos los encuentros programados.
     */
    public void limpiarPartidas() {
        panelListaPartidas.removeAll();
        panelListaPartidas.revalidate();
        panelListaPartidas.repaint();
    }
}
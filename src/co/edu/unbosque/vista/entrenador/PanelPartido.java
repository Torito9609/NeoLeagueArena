package co.edu.unbosque.vista.entrenador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Representa un panel que muestra la información de una partida programada.
 * Incluye detalles como la fecha, hora, juego y los equipos participantes.
 */
public class PanelPartido extends JPanel {

    /**
     * Constructor que inicializa el panel con los detalles de la partida.
     *
     * @param fecha      Fecha de la partida.
     * @param hora       Hora de la partida.
     * @param juego      Nombre del juego de la partida.
     * @param equipos    Equipos que participan en la partida.
     * @param colorJuego Color representativo del juego.
     */
    public PanelPartido(String fecha, String hora, String juego, String equipos, Color colorJuego) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                new EmptyBorder(8, 15, 8, 15)
        ));
        setPreferredSize(new Dimension(getPreferredSize().width, 65));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));

        // Etiqueta con la fecha y hora de la partida
        JLabel lblFechaHora = new JLabel("<html>" + fecha + "<br>" + hora + "</html>");
        lblFechaHora.setFont(new Font("Arial", Font.PLAIN, 12));
        lblFechaHora.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.2;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(lblFechaHora, gbc);

        // Etiqueta con el nombre del juego
        JLabel lblJuego = new JLabel(juego);
        lblJuego.setFont(new Font("Arial", Font.BOLD, 18));
        lblJuego.setForeground(colorJuego);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        gbc.weightx = 0.8;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(lblJuego, gbc);

        // Etiqueta con los equipos participantes
        JLabel lblEquipos = new JLabel(equipos);
        lblEquipos.setFont(new Font("Arial", Font.PLAIN, 11));
        lblEquipos.setForeground(Color.GRAY);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(lblEquipos, gbc);
    }
}
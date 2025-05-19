package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel con atributos específicos del jugador.
 * Permite configurar el nivel competitivo, Gamer Tag y puntos de ranking.
 */
public class PanelJugador extends JPanel {

    private JComboBox<String> nivelCompetitivoComboBox;
    private JTextField gamerTagField;
    private JTextField rankingPuntosField;

    /**
     * Constructor que inicializa el panel con sus componentes y diseño estructurado.
     */
    public PanelJugador() {
        setBorder(BorderFactory.createTitledBorder("Atributos específicos del Jugador"));
        setLayout(new BorderLayout());

        JPanel camposPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        nivelCompetitivoComboBox = new JComboBox<>(new String[]{
            "PRINCIPIANTE", "INTERMEDIO", "AVANZADO", "PROFESIONAL", "ELITE"
        });
        gamerTagField = new JTextField(20);
        rankingPuntosField = new JTextField(10);

        camposPanel.add(new JLabel("Nivel competitivo:"));
        camposPanel.add(nivelCompetitivoComboBox);
        camposPanel.add(new JLabel("Gamer Tag:"));
        camposPanel.add(gamerTagField);
        camposPanel.add(new JLabel("Ranking Puntos:"));
        camposPanel.add(rankingPuntosField);

        add(camposPanel, BorderLayout.NORTH);
    }

    /**
     * Devuelve el campo de selección del nivel competitivo.
     * 
     * @return Combo box con los niveles de competencia.
     */
    public JComboBox<String> getNivelCompetitivoComboBox() {
        return nivelCompetitivoComboBox;
    }

    /**
     * Devuelve el campo de texto para el Gamer Tag.
     * 
     * @return Campo de texto donde se ingresa el Gamer Tag.
     */
    public JTextField getGamerTagField() {
        return gamerTagField;
    }

    /**
     * Devuelve el campo de texto para los puntos de ranking del jugador.
     * 
     * @return Campo de texto para los puntos de ranking.
     */
    public JTextField getRankingPuntosField() {
        return rankingPuntosField;
    }
}
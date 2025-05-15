package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class PanelJugador extends JPanel {

	private JComboBox<String> nivelCompetitivoComboBox;
	private JTextField gamerTagField;
	private JTextField rankingPuntosField;

	public PanelJugador() {
		setBorder(BorderFactory.createTitledBorder("Atributos específicos del Jugador"));
		setLayout(new BorderLayout());

		JPanel camposPanel = new JPanel(new GridLayout(3, 2, 10, 10));

		nivelCompetitivoComboBox = new JComboBox<>(new String[] {
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

	public JComboBox<String> getNivelCompetitivoComboBox() {
		return nivelCompetitivoComboBox;
	}

	public JTextField getGamerTagField() {
		return gamerTagField;
	}

	public JTextField getRankingPuntosField() {
		return rankingPuntosField;
	}
}

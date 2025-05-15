package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class PanelEntrenador extends JPanel {

	private JTextField nickNameField;
	private JTextField aniosXpField;
	private JTextArea bioTextArea;

	public PanelEntrenador() {
		setBorder(BorderFactory.createTitledBorder("Atributos específicos del Entrenador"));
		setLayout(new BorderLayout());

		JPanel camposPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		nickNameField = new JTextField(20);
		aniosXpField = new JTextField(5);

		camposPanel.add(new JLabel("Nickname:"));
		camposPanel.add(nickNameField);
		camposPanel.add(new JLabel("Años de experiencia:"));
		camposPanel.add(aniosXpField);

		JPanel bioPanel = new JPanel(new BorderLayout(5, 5));
		bioTextArea = new JTextArea(4, 20);
		bioTextArea.setLineWrap(true);
		bioTextArea.setWrapStyleWord(true);
		JScrollPane bioScroll = new JScrollPane(bioTextArea);

		bioPanel.add(new JLabel("Biografía:"), BorderLayout.NORTH);
		bioPanel.add(bioScroll, BorderLayout.CENTER);

		add(camposPanel, BorderLayout.NORTH);
		add(bioPanel, BorderLayout.CENTER);
	}

	public JTextField getNickNameField() {
		return nickNameField;
	}

	public JTextField getAniosXpField() {
		return aniosXpField;
	}

	public JTextArea getBioTextArea() {
		return bioTextArea;
	}
}

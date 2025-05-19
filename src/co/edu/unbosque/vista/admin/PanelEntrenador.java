package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel con atributos específicos del entrenador.
 * Permite la configuración del nickname, años de experiencia y biografía.
 */
public class PanelEntrenador extends JPanel {

    private JTextField nickNameField;
    private JTextField aniosXpField;
    private JTextArea bioTextArea;

    /**
     * Constructor que inicializa el panel con sus componentes y diseño estructurado.
     */
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

    /**
     * Devuelve el campo de texto para ingresar el nickname del entrenador.
     * 
     * @return Campo de texto para el nickname.
     */
    public JTextField getNickNameField() {
        return nickNameField;
    }

    /**
     * Devuelve el campo de texto para ingresar los años de experiencia del entrenador.
     * 
     * @return Campo de texto para los años de experiencia.
     */
    public JTextField getAniosXpField() {
        return aniosXpField;
    }

    /**
     * Devuelve el área de texto donde se ingresa la biografía del entrenador.
     * 
     * @return Área de texto para la biografía.
     */
    public JTextArea getBioTextArea() {
        return bioTextArea;
    }
}
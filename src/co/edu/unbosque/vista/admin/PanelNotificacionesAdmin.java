package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para gestión de notificaciones, permite escribir y enviar notificaciones por correo.
 */
public class PanelNotificacionesAdmin extends JPanel {

    private JTextField campoAsunto;
    private JTextArea areaMensaje;
    private JButton enviarBtn;

    public PanelNotificacionesAdmin() {
        setLayout(new BorderLayout(15, 15));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
    	JPanel panelCampos = new JPanel(new GridLayout(2, 1, 10, 10));
        campoAsunto = new JTextField();
        areaMensaje = new JTextArea();
        areaMensaje.setLineWrap(true);
        areaMensaje.setWrapStyleWord(true);

        panelCampos.add(new JLabel("Asunto:"));
        panelCampos.add(campoAsunto);
        add(panelCampos, BorderLayout.NORTH);

        add(new JScrollPane(areaMensaje), BorderLayout.CENTER);

        enviarBtn = new JButton("Enviar notificación");
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(enviarBtn);
        add(panelBoton, BorderLayout.SOUTH);
		
	}

	public JTextField getCampoAsunto() {
        return campoAsunto;
    }

    public JTextArea getAreaMensaje() {
        return areaMensaje;
    }

    public JButton getEnviarBtn() {
        return enviarBtn;
    }
}

package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel para la gestión de notificaciones dentro del módulo de administración.
 * Permite redactar y enviar notificaciones por correo a los usuarios del sistema.
 */
public class PanelNotificacionesAdmin extends JPanel {

    private JTextField campoAsunto;
    private JTextArea areaMensaje;
    private JButton enviarBtn;

    /**
     * Constructor que inicializa el panel con su distribución y configuración de estilo.
     */
    public PanelNotificacionesAdmin() {
        setLayout(new BorderLayout(15, 15));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos del panel, incluyendo los campos de entrada y el botón de envío.
     */
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

    // Métodos de acceso a los componentes del panel

    /**
     * Devuelve el campo de texto para ingresar el asunto de la notificación.
     * 
     * @return Campo de texto para el asunto.
     */
    public JTextField getCampoAsunto() {
        return campoAsunto;
    }

    /**
     * Devuelve el área de texto donde se redacta el mensaje de la notificación.
     * 
     * @return Área de texto para el mensaje.
     */
    public JTextArea getAreaMensaje() {
        return areaMensaje;
    }

    /**
     * Devuelve el botón de envío de la notificación.
     * 
     * @return Botón para enviar la notificación.
     */
    public JButton getEnviarBtn() {
        return enviarBtn;
    }
}
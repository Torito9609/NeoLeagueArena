package co.edu.unbosque.vista.login;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Panel gráfico que contiene los componentes para el inicio de sesión de usuarios.
 * Incluye campos para correo electrónico y contraseña, junto con botones de acción.
 * 
 * @version 1.0
 * @since 2025-05-01
 */
public class PanelLogin extends JPanel {

    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton ingresarButton;
    private JButton cancelarButton;

    /**
     * Constructor que inicializa el panel de login con todos sus componentes.
     * Configura el layout y los márgenes del panel.
     */
    public PanelLogin() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        inicializarComponentes();
    }

    /**
     * Inicializa y posiciona todos los componentes gráficos del panel:
     * - Logo de la aplicación
     * - Campos para correo y contraseña
     * - Botones de acción
     */
    private void inicializarComponentes() {
        // Configuración del logo
        JLabel logoLabel = new JLabel();
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        File archivo = new File("img/logoApp.png");
        ImageIcon icono = new ImageIcon(archivo.getAbsolutePath());
        Image imgEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        logoLabel = new JLabel(new ImageIcon(imgEscalada));

        // Panel para campos de texto
        JPanel camposPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField(20);
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField(20);

        camposPanel.add(correoLabel);
        camposPanel.add(correoField);
        camposPanel.add(contrasenaLabel);
        camposPanel.add(contrasenaField);

        // Panel para botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        ingresarButton = new JButton("Ingresar");
        ingresarButton.setActionCommand("INGRESAR");
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setActionCommand("CANCELAR");
        botonesPanel.add(ingresarButton);
        botonesPanel.add(cancelarButton);

        // Ensamblado final
        add(logoLabel);
        add(Box.createVerticalStrut(15));
        add(camposPanel);
        add(Box.createVerticalStrut(20));
        add(botonesPanel);
    }

    /**
     * Obtiene el campo de texto para el correo electrónico.
     * 
     * @return Referencia al JTextField del correo
     */
    public JTextField getCorreoField() {
        return correoField;
    }

    /**
     * Establece el campo de texto para el correo electrónico.
     * 
     * @param correoField Nuevo JTextField para el correo
     */
    public void setCorreoField(JTextField correoField) {
        this.correoField = correoField;
    }

    /**
     * Obtiene el campo de contraseña.
     * 
     * @return Referencia al JPasswordField de la contraseña
     */
    public JPasswordField getContrasenaField() {
        return contrasenaField;
    }

    /**
     * Establece el campo de contraseña.
     * 
     * @param contrasenaField Nuevo JPasswordField para la contraseña
     */
    public void setContrasenaField(JPasswordField contrasenaField) {
        this.contrasenaField = contrasenaField;
    }

    /**
     * Obtiene el botón de ingreso al sistema.
     * 
     * @return Referencia al JButton de ingreso
     */
    public JButton getIngresarButton() {
        return ingresarButton;
    }

    /**
     * Establece el botón de ingreso al sistema.
     * 
     * @param ingresarButton Nuevo JButton para ingreso
     */
    public void setIngresarButton(JButton ingresarButton) {
        this.ingresarButton = ingresarButton;
    }

    /**
     * Obtiene el botón de cancelación.
     * 
     * @return Referencia al JButton de cancelación
     */
    public JButton getCancelarButton() {
        return cancelarButton;
    }

    /**
     * Establece el botón de cancelación.
     * 
     * @param cancelarButton Nuevo JButton para cancelación
     */
    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }
}
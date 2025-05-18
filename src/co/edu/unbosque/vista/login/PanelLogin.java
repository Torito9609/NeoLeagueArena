package co.edu.unbosque.vista.login;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PanelLogin extends JPanel {

    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton ingresarButton;
    private JButton cancelarButton;

    public PanelLogin() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JLabel logoLabel = new JLabel();
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        File archivo = new File("img/logoApp.png");
        ImageIcon icono = new ImageIcon(archivo.getAbsolutePath());

        Image imgEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        logoLabel = new JLabel(new ImageIcon(imgEscalada));

        JPanel camposPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField(20);
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField(20);

        camposPanel.add(correoLabel);
        camposPanel.add(correoField);
        camposPanel.add(contrasenaLabel);
        camposPanel.add(contrasenaField);

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        ingresarButton = new JButton("Ingresar");
        cancelarButton = new JButton("Cancelar");
        botonesPanel.add(ingresarButton);
        botonesPanel.add(cancelarButton);

        add(logoLabel);
        add(Box.createVerticalStrut(15));
        add(camposPanel);
        add(Box.createVerticalStrut(20));
        add(botonesPanel);
    }

    public JTextField getCorreoField() {
        return correoField;
    }

    public void setCorreoField(JTextField correoField) {
        this.correoField = correoField;
    }

    public JPasswordField getContrasenaField() {
        return contrasenaField;
    }

    public void setContrasenaField(JPasswordField contrasenaField) {
        this.contrasenaField = contrasenaField;
    }

    public JButton getIngresarButton() {
        return ingresarButton;
    }

    public void setIngresarButton(JButton ingresarButton) {
        this.ingresarButton = ingresarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }
}

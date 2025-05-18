package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SubPanelConfiguracionJugador extends JPanel {

    private JCheckBox chkNotificacionesEmail;
    private JComboBox<String> comboIdioma;
    private JPasswordField passActual;
    private JPasswordField passNueva;
    private JPasswordField passConfirmarNueva;
    private JButton btnGuardarConfiguracion;
    private JButton btnCambiarPassword;


    public SubPanelConfiguracionJugador() {
        setLayout(new BorderLayout(10,10));
        setBorder(new EmptyBorder(20,20,20,20));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Configuración de la Cuenta", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        chkNotificacionesEmail = new JCheckBox("Recibir notificaciones por correo electrónico", true);
        panelFormulario.add(chkNotificacionesEmail, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        panelFormulario.add(new JLabel("Idioma preferido:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        comboIdioma = new JComboBox<>(new String[]{"Español", "Inglés"});
        panelFormulario.add(comboIdioma, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Separador para la sección de cambio de contraseña
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
        gbc.fill = GridBagConstraints.NONE; gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        JLabel lblCambioPass = new JLabel("Cambiar Contraseña:");
        lblCambioPass.setFont(new Font("Arial", Font.BOLD, 14));
        panelFormulario.add(lblCambioPass, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 4;
        panelFormulario.add(new JLabel("Contraseña Actual:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        passActual = new JPasswordField(20);
        panelFormulario.add(passActual, gbc);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0; gbc.gridy = 5;
        panelFormulario.add(new JLabel("Nueva Contraseña:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        passNueva = new JPasswordField(20);
        panelFormulario.add(passNueva, gbc);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0; gbc.gridy = 6;
        panelFormulario.add(new JLabel("Confirmar Nueva Contraseña:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        passConfirmarNueva = new JPasswordField(20);
        panelFormulario.add(passConfirmarNueva, gbc);
        gbc.fill = GridBagConstraints.NONE;
        
        gbc.gridx = 1; gbc.gridy = 7; gbc.anchor = GridBagConstraints.EAST;
        btnCambiarPassword = new JButton("Cambiar Contraseña");
        btnCambiarPassword.setActionCommand("CAMBIAR_PASSWORD_JUGADOR");
        panelFormulario.add(btnCambiarPassword, gbc);
        gbc.anchor = GridBagConstraints.WEST; // Reset anchor

        // Espaciador
        gbc.gridx = 0; gbc.gridy = 8; gbc.weighty = 1.0;
        panelFormulario.add(new JLabel(), gbc);
        gbc.weighty = 0;

        add(new JScrollPane(panelFormulario), BorderLayout.CENTER);

        btnGuardarConfiguracion = new JButton("Guardar Configuración General");
        btnGuardarConfiguracion.setActionCommand("GUARDAR_CONFIG_JUGADOR");
        JPanel panelBotonGuardar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonGuardar.add(btnGuardarConfiguracion);
        add(panelBotonGuardar, BorderLayout.SOUTH);
    }

    public void cargarConfiguracion(/* ConfiguracionJugadorDto configDto */) {
        // chkNotificacionesEmail.setSelected(configDto.isRecibirNotificaciones());
        // comboIdioma.setSelectedItem(configDto.getIdioma());
        System.out.println("SubPanelConfiguracionJugador: cargarConfiguracion() necesita implementación.");
    }

    // Getters para los componentes
    public JCheckBox getChkNotificacionesEmail() { return chkNotificacionesEmail; }
    public JComboBox<String> getComboIdioma() { return comboIdioma; }
    public JPasswordField getPassActual() { return passActual; }
    public JPasswordField getPassNueva() { return passNueva; }
    public JPasswordField getPassConfirmarNueva() { return passConfirmarNueva; }
    public JButton getBtnGuardarConfiguracion() { return btnGuardarConfiguracion; }
    public JButton getBtnCambiarPassword() { return btnCambiarPassword; }
}
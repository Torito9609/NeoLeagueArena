package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;
import co.edu.unbosque.modelo.dto.UsuarioDto;

/**
 * Representa el panel superior de la ventana de gestión de usuarios.
 * Contiene campos para la edición y creación de datos de usuario, incluyendo 
 * información personal, tipo de usuario y selección de foto de perfil.
 */
public class PanelUsuarioSuperior extends JPanel {

    private JTextField idField, nombreField, apellidoField, correoField, celularField, fechaNacimientoField;
    private JComboBox<String> paisComboBox, zonaHorariaComboBox, ciudadComboBox, tipoUsuarioComboBox;
    private JLabel fotoLabel, passwordLabel;
    private JButton seleccionarFotoButton;

    /**
     * Constructor que inicializa el panel con su distribución de componentes.
     */
    public PanelUsuarioSuperior() {
        setLayout(new GridLayout(13, 2, 13, 13));
        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos del panel, incluyendo campos de entrada y botones.
     */
    private void inicializarComponentes() {
        add(new JLabel("Cédula:"));
        idField = new JTextField(20);
        add(idField);

        add(new JLabel("Nombres:"));
        nombreField = new JTextField(20);
        add(nombreField);

        add(new JLabel("Apellidos:"));
        apellidoField = new JTextField(20);
        add(apellidoField);

        add(new JLabel("Correo:"));
        correoField = new JTextField(20);
        add(correoField);

        add(new JLabel("Celular:"));
        celularField = new JTextField(20);
        add(celularField);

        add(new JLabel("País:"));
        paisComboBox = new JComboBox<>(new String[] {"Seleccionar", "Colombia", "México", "Argentina", "..."});
        add(paisComboBox);

        add(new JLabel("Ciudad:"));
        ciudadComboBox = new JComboBox<>(new String[] {"Seleccionar", "Bogotá", "Medellín", "Cali", "..."});
        add(ciudadComboBox);

        add(new JLabel("Fecha de Nacimiento:"));
        fechaNacimientoField = new JTextField();
        add(fechaNacimientoField);

        add(new JLabel("Zona Horaria:"));
        zonaHorariaComboBox = new JComboBox<>(new String[] {"Seleccionar", "GMT-5", "GMT-6", "GMT-3", "..."});
        add(zonaHorariaComboBox);

        add(new JLabel("Foto de perfil:"));
        JPanel fotoPanel = new JPanel(new BorderLayout());
        fotoLabel = new JLabel("Ninguna foto seleccionada");
        seleccionarFotoButton = new JButton("Seleccionar...");
        seleccionarFotoButton.setActionCommand("SELECCIONAR_FOTO");
        fotoPanel.add(fotoLabel, BorderLayout.CENTER);
        fotoPanel.add(seleccionarFotoButton, BorderLayout.EAST);
        add(fotoPanel);

        add(new JLabel("Tipo de usuario:"));
        tipoUsuarioComboBox = new JComboBox<>(new String[] {"Seleccionar", "Entrenador", "Jugador"});
        tipoUsuarioComboBox.setActionCommand("SELECCIONAR_TIPO_USUARIO");
        add(tipoUsuarioComboBox);

        passwordLabel = new JLabel();
        add(passwordLabel);
        passwordLabel.setVisible(false);
    }

    /**
     * Limpia los campos del formulario restableciendo sus valores por defecto.
     */
    public void limpiarCamposFormulario() {
        nombreField.setText("");
        apellidoField.setText("");
        correoField.setText("");
        celularField.setText("");
        paisComboBox.setSelectedItem("Seleccionar");
        zonaHorariaComboBox.setSelectedItem("Seleccionar");
    }

    /**
     * Obtiene los valores actuales de los campos del formulario.
     * 
     * @return Arreglo con la información ingresada en los campos.
     */
    public String[] obtenerCamposFormulario() {
        return new String[] {
            idField.getText().trim(),
            nombreField.getText().trim(),
            apellidoField.getText().trim(),
            correoField.getText().trim(),
            celularField.getText().trim(),
            paisComboBox.getSelectedItem().toString(),
            zonaHorariaComboBox.getSelectedItem().toString(),
            ciudadComboBox.getSelectedItem().toString(),
            fechaNacimientoField.getText(),
            tipoUsuarioComboBox.getSelectedItem().toString(),
            passwordLabel.getText()
        };
    }

    /**
     * Reinicia los campos del formulario para edición, restableciendo sus valores por defecto.
     */
    public void reiniciarCamposEdicion() {
        idField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        correoField.setText("");
        celularField.setText("");
        paisComboBox.setSelectedIndex(0);
        zonaHorariaComboBox.setSelectedIndex(0);
        ciudadComboBox.setSelectedIndex(0);
    }

    // Métodos de acceso a los componentes del formulario

    public JTextField getIdField() { return idField; }
    public JTextField getNombreField() { return nombreField; }
    public JTextField getApellidoField() { return apellidoField; }
    public JTextField getCorreoField() { return correoField; }
    public JTextField getCelularField() { return celularField; }
    public JComboBox<String> getPaisComboBox() { return paisComboBox; }
    public JComboBox<String> getZonaHorariaComboBox() { return zonaHorariaComboBox; }
    public JComboBox<String> getCiudadComboBox() { return ciudadComboBox; }
    public JComboBox<String> getTipoUsuarioComboBox() { return tipoUsuarioComboBox; }
    public JLabel getFotoLabel() { return fotoLabel; }
    public JButton getSeleccionarFotoButton() { return seleccionarFotoButton; }
    public JTextField getFechaNacimientoField() { return fechaNacimientoField; }
    public JLabel getPasswordLabel() { return passwordLabel; }

    /**
     * Rellena los campos del formulario con los datos de un usuario existente.
     * 
     * @param usuarioDto Instancia de {@code UsuarioDto} con los datos del usuario.
     */
    public void rellenarCamposFormulario(UsuarioDto usuarioDto) {
        idField.setText(usuarioDto.getId());
        nombreField.setText(usuarioDto.getNombres());
        apellidoField.setText(usuarioDto.getApellidos());
        correoField.setText(usuarioDto.getCorreo());
        celularField.setText(usuarioDto.getCelular());
        fechaNacimientoField.setText(usuarioDto.getFechaNacimiento().toString());
        paisComboBox.setSelectedItem(usuarioDto.getPais());
        ciudadComboBox.setSelectedItem(usuarioDto.getCiudad());
        tipoUsuarioComboBox.setSelectedItem(usuarioDto.getTipoUsuario());
        passwordLabel.setText(usuarioDto.getPasswordHash());
    }
}
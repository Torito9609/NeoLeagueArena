package co.edu.unbosque.vista.admin;

import javax.swing.*;

import co.edu.unbosque.modelo.dto.UsuarioDto;

import java.awt.*;

public class PanelUsuarioSuperior extends JPanel {

	private JTextField idField, nombreField, apellidoField, correoField, celularField;
	private JComboBox<String> paisComboBox, zonaHorariaComboBox, ciudadComboBox, tipoUsuarioComboBox;
	private JLabel fotoLabel;
	private JButton seleccionarFotoButton;

	public PanelUsuarioSuperior() {
		setLayout(new GridLayout(10, 2, 10, 10));
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		add(new JLabel("Cedula:"));
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
		paisComboBox = new JComboBox<>(new String[] { "Colombia", "México", "Argentina", "..." });
		add(paisComboBox);

		add(new JLabel("Zona Horaria:"));
		zonaHorariaComboBox = new JComboBox<>(new String[] { "GMT-5", "GMT-6", "GMT-3", "..." });
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
		tipoUsuarioComboBox = new JComboBox<>(new String[] {"Entrenador", "Jugador"});
		add(tipoUsuarioComboBox);
	}

	public void limpiarCamposFormulario() {
		nombreField.setText("");
		apellidoField.setText("");
		correoField.setText("");
		celularField.setText("");
		paisComboBox.setSelectedItem("Seleccionar");
		zonaHorariaComboBox.setSelectedItem("Seleccionar");
	}

	public String[] obtenerCamposFormulario() {
		String[] campos = new String[8];
		campos[0] = idField.getText().trim();
		campos[1] = nombreField.getText().trim();
		campos[2] = apellidoField.getText().trim();
		campos[3] = correoField.getText().trim();
		campos[4] = celularField.getText().trim();
		campos[5] = paisComboBox.getSelectedItem().toString();
		campos[6] = zonaHorariaComboBox.getSelectedItem().toString();
		campos[7] = ciudadComboBox.getSelectedItem().toString();

		return campos;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(JTextField nombreField) {
		this.nombreField = nombreField;
	}

	public JTextField getApellidoField() {
		return apellidoField;
	}

	public void setApellidoField(JTextField apellidoField) {
		this.apellidoField = apellidoField;
	}

	public JTextField getCorreoField() {
		return correoField;
	}

	public void setCorreoField(JTextField correoField) {
		this.correoField = correoField;
	}

	public JTextField getCelularField() {
		return celularField;
	}

	public void setCelularField(JTextField celularField) {
		this.celularField = celularField;
	}

	public JComboBox<String> getPaisComboBox() {
		return paisComboBox;
	}

	public void setPaisComboBox(JComboBox<String> paisComboBox) {
		this.paisComboBox = paisComboBox;
	}

	public JComboBox<String> getZonaHorariaComboBox() {
		return zonaHorariaComboBox;
	}

	public void setZonaHorariaComboBox(JComboBox<String> zonaHorariaComboBox) {
		this.zonaHorariaComboBox = zonaHorariaComboBox;
	}

	public JComboBox<String> getCiudadComboBox() {
		return ciudadComboBox;
	}

	public void setCiudadComboBox(JComboBox<String> ciudadComboBox) {
		this.ciudadComboBox = ciudadComboBox;
	}

	public JComboBox<String> getTipoUsuarioComboBox() {
		return tipoUsuarioComboBox;
	}

	public void setTipoUsuarioComboBox(JComboBox<String> tipoUsuarioComboBox) {
		this.tipoUsuarioComboBox = tipoUsuarioComboBox;
	}

	public JLabel getFotoLabel() {
		return fotoLabel;
	}

	public void setFotoLabel(JLabel fotoLabel) {
		this.fotoLabel = fotoLabel;
	}

	public JButton getSeleccionarFotoButton() {
		return seleccionarFotoButton;
	}

	public void setSeleccionarFotoButton(JButton seleccionarFotoButton) {
		this.seleccionarFotoButton = seleccionarFotoButton;
	}

}

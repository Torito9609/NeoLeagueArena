package co.edu.unbosque.vista.admin;

import javax.swing.*;

import co.edu.unbosque.modelo.dto.UsuarioDto;

import java.awt.*;

public class PanelProductoSuperior extends JPanel {

	private JTextField nombreField, precioVentaField, costoProduccionField, cantidadField;
	private JComboBox<String> tipoProductoComboBox;

	public PanelProductoSuperior() {
		setLayout(new GridLayout(10, 2, 10, 10));
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		add(new JLabel("Nombre:"));
		nombreField = new JTextField(20);
		add(nombreField);

		add(new JLabel("Precio de Venta:"));
		precioVentaField = new JTextField(20);
		add(precioVentaField);

		add(new JLabel("Costo de produccion:"));
		costoProduccionField = new JTextField(20);
		add(costoProduccionField);

		add(new JLabel("Cantidad:"));
		cantidadField = new JTextField(20);
		add(cantidadField);

		add(new JLabel("Tipo de producto:"));
		tipoProductoComboBox = new JComboBox<>(new String[] { "Seleccionar", "Pan", "Galleta" });
		tipoProductoComboBox.setActionCommand("TIPO_PRODUCTO");
		add(tipoProductoComboBox);
	}

	public void limpiarCamposFormulario() {
		nombreField.setText("");
		precioVentaField.setText("");
		costoProduccionField.setText("");
		cantidadField.setText("");
		tipoProductoComboBox.setSelectedItem("Seleccionar");
	}
	
	public String[] obtenerCamposFormulario() {
		String[] campos = new String[5];
		campos[0] = nombreField.getText().trim();
		campos[1] = precioVentaField.getText().trim();
		campos[2] = costoProduccionField.getText().trim();
		campos[3] = cantidadField.getText().trim();
		campos[4] = tipoProductoComboBox.getSelectedItem().toString();
		
		return campos;
	}
	/*
	public void rellenarCamposFormulario(UsuarioDto producto) {
		nombreField.setText(producto.getNombre());
		precioVentaField.setText(String.valueOf(producto.getPrecioVenta()));
		costoProduccionField.setText(String.valueOf(producto.getCostoProduccion()));
		cantidadField.setText(String.valueOf(producto.getCantidad()));
		tipoProductoComboBox.setSelectedItem(producto.getTipo());
	}*/

	public JTextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(JTextField nombreField) {
		this.nombreField = nombreField;
	}

	public JTextField getPrecioVentaField() {
		return precioVentaField;
	}

	public void setPrecioVentaField(JTextField precioVentaField) {
		this.precioVentaField = precioVentaField;
	}

	public JTextField getCostoProduccionField() {
		return costoProduccionField;
	}

	public void setCostoProduccionField(JTextField costoProduccionField) {
		this.costoProduccionField = costoProduccionField;
	}

	public JTextField getCantidadField() {
		return cantidadField;
	}

	public void setCantidadField(JTextField cantidadField) {
		this.cantidadField = cantidadField;
	}

	public JComboBox<String> getTipoProductoComboBox() {
		return tipoProductoComboBox;
	}

	public void setTipoProductoComboBox(JComboBox<String> tipoProductoComboBox) {
		this.tipoProductoComboBox = tipoProductoComboBox;
	}

}

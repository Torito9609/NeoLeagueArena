package co.edu.unbosque.vista.admin;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VistaAdmin {
	private VentanaPrincipalAdmin ventanaPrincipal;
	private VentanaCreacionUsuario ventanaCreacionUsuario;
	private VentanaCreacionEquipo ventanaCreacionEquipo;
	private VentanaInicioTorneo ventanaInicioTorneo;

	public VistaAdmin() {
		ventanaPrincipal = new VentanaPrincipalAdmin();
		ventanaCreacionUsuario = new VentanaCreacionUsuario();
		ventanaCreacionEquipo = new VentanaCreacionEquipo();
		ventanaInicioTorneo = new VentanaInicioTorneo();
	}

	public VentanaPrincipalAdmin getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipalAdmin ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public VentanaCreacionUsuario getVentanaCreacionUsuario() {
		return ventanaCreacionUsuario;
	}

	public void setVentanaProducto(VentanaCreacionUsuario ventanaProducto) {
		this.ventanaCreacionUsuario = ventanaProducto;
	}

	public VentanaCreacionEquipo getVentanaCreacionEquipo() {
		return ventanaCreacionEquipo;
	}

	public void setVentanaCreacionEquipo(VentanaCreacionEquipo ventanaCreacionEquipo) {
		this.ventanaCreacionEquipo = ventanaCreacionEquipo;
	}

	public void setVentanaCreacionUsuario(VentanaCreacionUsuario ventanaCreacionUsuario) {
		this.ventanaCreacionUsuario = ventanaCreacionUsuario;
	}

	public VentanaInicioTorneo getVentanaInicioTorneo() {
		return ventanaInicioTorneo;
	}

	public void setVentanaInicioTorneo(VentanaInicioTorneo ventanaInicioTorneo) {
		this.ventanaInicioTorneo = ventanaInicioTorneo;
	}

	public void mostrarMensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE,
				UIManager.getIcon("OptionPane.informationIcon"));
	}

	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE,
				UIManager.getIcon("OptionPane.warningIcon"));
	}

	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE,
				UIManager.getIcon("OptionPane.errorIcon"));
	}

	public int mostrarMensajeConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));
	}
}

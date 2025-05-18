package co.edu.unbosque.vista.login;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VistaLogin {
	private VentanaLogin ventanaLogin;

	public VistaLogin() {
		ventanaLogin = new VentanaLogin();
		ventanaLogin.setVisible(true);
	}

	public VentanaLogin getVentanaLogin() {
		return ventanaLogin;
	}

	public void setVentanaLogin(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;
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

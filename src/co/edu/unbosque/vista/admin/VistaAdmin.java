package co.edu.unbosque.vista.admin;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VistaAdmin {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaProducto ventanaProducto;
	
	public VistaAdmin() {
		ventanaPrincipal = new VentanaPrincipal();
		ventanaProducto = new VentanaProducto();
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	public VentanaProducto getVentanaProducto() {
		return ventanaProducto;
	}
	public void setVentanaProducto(VentanaProducto ventanaProducto) {
		this.ventanaProducto = ventanaProducto;
	}
	
   
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE, UIManager.getIcon("OptionPane.informationIcon"));
    }

    public void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE, UIManager.getIcon("OptionPane.warningIcon"));
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE, UIManager.getIcon("OptionPane.errorIcon"));
    }

    public int mostrarMensajeConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));
    }
}

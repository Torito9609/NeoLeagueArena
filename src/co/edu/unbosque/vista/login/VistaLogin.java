package co.edu.unbosque.vista.login;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Clase que gestiona la interfaz gráfica para el sistema de autenticación.
 * Proporciona métodos para mostrar diferentes tipos de mensajes al usuario
 * y maneja la visualización de la ventana de login.
 * 
 * @version 1.0
 * @since 2025-05-01
 */
public class VistaLogin {
    private VentanaLogin ventanaLogin;

    /**
     * Construye una nueva instancia de VistaLogin inicializando
     * y mostrando la ventana de login.
     */
    public VistaLogin() {
        ventanaLogin = new VentanaLogin();
        ventanaLogin.setVisible(true);
    }

    /**
     * Obtiene la ventana de login asociada a esta vista.
     * 
     * @return La instancia de VentanaLogin actualmente en uso
     */
    public VentanaLogin getVentanaLogin() {
        return ventanaLogin;
    }

    /**
     * Establece una nueva ventana de login para esta vista.
     * 
     * @param ventanaLogin La nueva instancia de VentanaLogin a utilizar
     */
    public void setVentanaLogin(VentanaLogin ventanaLogin) {
        this.ventanaLogin = ventanaLogin;
    }

    /**
     * Muestra un mensaje de operación exitosa al usuario.
     * 
     * @param mensaje El texto del mensaje a mostrar
     */
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE,
                UIManager.getIcon("OptionPane.informationIcon"));
    }

    /**
     * Muestra un mensaje de advertencia al usuario.
     * 
     * @param mensaje El texto de la advertencia a mostrar
     */
    public void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE,
                UIManager.getIcon("OptionPane.warningIcon"));
    }

    /**
     * Muestra un mensaje de error al usuario.
     * 
     * @param mensaje El texto del error a mostrar
     */
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE,
                UIManager.getIcon("OptionPane.errorIcon"));
    }

    /**
     * Muestra un diálogo de confirmación al usuario.
     * 
     * @param mensaje La pregunta o mensaje de confirmación
     * @return Entero que representa la opción seleccionada por el usuario
     *         (JOptionPane.YES_OPTION o JOptionPane.NO_OPTION)
     */
    public int mostrarMensajeConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));
    }
}
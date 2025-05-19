package co.edu.unbosque.vista.admin;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Representa la vista principal del administrador en la aplicación.
 * Gestiona el acceso a las diferentes ventanas de administración y proporciona métodos 
 * para mostrar mensajes de información, advertencia, error y confirmación.
 */
public class VistaAdmin {

    private VentanaPrincipalAdmin ventanaPrincipal;
    private VentanaCreacionUsuario ventanaCreacionUsuario;
    private VentanaCreacionEquipo ventanaCreacionEquipo;
    private VentanaInicioTorneo ventanaInicioTorneo;

    /**
     * Constructor que inicializa las ventanas de administración.
     */
    public VistaAdmin() {
        ventanaPrincipal = new VentanaPrincipalAdmin();
        ventanaCreacionUsuario = new VentanaCreacionUsuario();
        ventanaCreacionEquipo = new VentanaCreacionEquipo();
        ventanaInicioTorneo = new VentanaInicioTorneo();
    }

    /**
     * Devuelve la ventana principal de administración.
     * 
     * @return Instancia de {@code VentanaPrincipalAdmin}.
     */
    public VentanaPrincipalAdmin getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    /**
     * Establece una nueva ventana principal de administración.
     * 
     * @param ventanaPrincipal Nueva instancia de {@code VentanaPrincipalAdmin}.
     */
    public void setVentanaPrincipal(VentanaPrincipalAdmin ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    /**
     * Devuelve la ventana de creación de usuario.
     * 
     * @return Instancia de {@code VentanaCreacionUsuario}.
     */
    public VentanaCreacionUsuario getVentanaCreacionUsuario() {
        return ventanaCreacionUsuario;
    }

    /**
     * Establece una nueva ventana de creación de usuario.
     * 
     * @param ventanaCreacionUsuario Nueva instancia de {@code VentanaCreacionUsuario}.
     */
    public void setVentanaCreacionUsuario(VentanaCreacionUsuario ventanaCreacionUsuario) {
        this.ventanaCreacionUsuario = ventanaCreacionUsuario;
    }

    /**
     * Devuelve la ventana de creación de equipo.
     * 
     * @return Instancia de {@code VentanaCreacionEquipo}.
     */
    public VentanaCreacionEquipo getVentanaCreacionEquipo() {
        return ventanaCreacionEquipo;
    }

    /**
     * Establece una nueva ventana de creación de equipo.
     * 
     * @param ventanaCreacionEquipo Nueva instancia de {@code VentanaCreacionEquipo}.
     */
    public void setVentanaCreacionEquipo(VentanaCreacionEquipo ventanaCreacionEquipo) {
        this.ventanaCreacionEquipo = ventanaCreacionEquipo;
    }

    /**
     * Devuelve la ventana de inicio de torneo.
     * 
     * @return Instancia de {@code VentanaInicioTorneo}.
     */
    public VentanaInicioTorneo getVentanaInicioTorneo() {
        return ventanaInicioTorneo;
    }

    /**
     * Establece una nueva ventana de inicio de torneo.
     * 
     * @param ventanaInicioTorneo Nueva instancia de {@code VentanaInicioTorneo}.
     */
    public void setVentanaInicioTorneo(VentanaInicioTorneo ventanaInicioTorneo) {
        this.ventanaInicioTorneo = ventanaInicioTorneo;
    }

    /**
     * Muestra un mensaje de éxito en una ventana emergente.
     * 
     * @param mensaje Texto del mensaje a mostrar.
     */
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE,
                UIManager.getIcon("OptionPane.informationIcon"));
    }

    /**
     * Muestra un mensaje de advertencia en una ventana emergente.
     * 
     * @param mensaje Texto del mensaje a mostrar.
     */
    public void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE,
                UIManager.getIcon("OptionPane.warningIcon"));
    }

    /**
     * Muestra un mensaje de error en una ventana emergente.
     * 
     * @param mensaje Texto del mensaje a mostrar.
     */
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE,
                UIManager.getIcon("OptionPane.errorIcon"));
    }

    /**
     * Muestra un cuadro de diálogo de confirmación y devuelve la opción seleccionada.
     * 
     * @param mensaje Texto del mensaje de confirmación.
     * @return {@code JOptionPane.YES_OPTION} si el usuario confirma, {@code JOptionPane.NO_OPTION} en caso contrario.
     */
    public int mostrarMensajeConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));
    }
}
package co.edu.unbosque.vista.jugador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que representa la vista principal del módulo Jugador.
 * <p>
 * Se encarga de inicializar y mostrar la interfaz gráfica del jugador,
 * así como de proporcionar métodos auxiliares para mostrar mensajes
 * de error, éxito o confirmación.
 */
public class VistaJugador {

    private VentanaPrincipalJugador ventanaPrincipal;

    /**
     * Constructor de la clase que inicializa la ventana principal del jugador
     * con datos simulados por defecto.
     */
    public VistaJugador() {
        String idJugador = "JUG-001";
        String nickname = "PlayerOne";
        String rutaFotoActual = "imagenes/default_perfil_jugador.png";

        ventanaPrincipal = new VentanaPrincipalJugador(idJugador, nickname, rutaFotoActual);
    }

    /**
     * Obtiene la instancia de la ventana principal del jugador.
     *
     * @return ventana principal del jugador.
     */
    public VentanaPrincipalJugador getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    /**
     * Muestra la ventana principal del jugador.
     */
    public void mostrarVentana() {
        ventanaPrincipal.setVisible(true);
    }

    /**
     * Cierra la ventana principal del jugador.
     */
    public void cerrarVentana() {
        ventanaPrincipal.dispose();
    }

    /**
     * Muestra un mensaje de error en una ventana emergente.
     *
     * @param mensaje Texto del mensaje de error.
     * @param parent  Componente padre de la ventana emergente.
     */
    public void mostrarMensajeError(String mensaje, JFrame parent) {
        JOptionPane.showMessageDialog(parent, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de éxito en una ventana emergente.
     *
     * @param mensaje Texto del mensaje de éxito.
     * @param parent  Componente padre de la ventana emergente.
     */
    public void mostrarMensajeExito(String mensaje, JFrame parent) {
        JOptionPane.showMessageDialog(parent, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra una ventana de confirmación al usuario.
     *
     * @param mensaje Texto de la pregunta a confirmar.
     * @param parent  Componente padre de la ventana emergente.
     * @return {@code JOptionPane.YES_OPTION} o {@code JOptionPane.NO_OPTION} según la elección del usuario.
     */
    public int mostrarMensajeConfirmacion(String mensaje, JFrame parent) {
        return JOptionPane.showConfirmDialog(parent, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}

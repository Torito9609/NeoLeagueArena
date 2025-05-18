package co.edu.unbosque.vista.jugador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VistaJugador {
    private VentanaPrincipalJugador ventanaPrincipal;
  

    public VistaJugador() {
    
        String idJugador = "JUG-001";
        String nickname = "PlayerOne";
        String rutaFotoActual = "imagenes/default_perfil_jugador.png"; 

        ventanaPrincipal = new VentanaPrincipalJugador(idJugador, nickname, rutaFotoActual);
    }

    public VentanaPrincipalJugador getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void mostrarVentana() {
        ventanaPrincipal.setVisible(true);
    }

    public void cerrarVentana() {
        ventanaPrincipal.dispose();
    }

    public void mostrarMensajeError(String mensaje, JFrame parent) {
        JOptionPane.showMessageDialog(parent, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeExito(String mensaje, JFrame parent) {
        JOptionPane.showMessageDialog(parent, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public int mostrarMensajeConfirmacion(String mensaje, JFrame parent) {
        return JOptionPane.showConfirmDialog(parent, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
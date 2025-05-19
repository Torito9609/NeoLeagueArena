package co.edu.unbosque.vista.entrenador;

import javax.swing.*;

/**
 * Representa la vista principal de la interfaz del entrenador.
 * Se encarga de gestionar la ventana principal del entrenador.
 */
public class VistaEntrenador {

    private VentanaPrincipalEntrenador ventanaPrincipal;

    /**
     * Constructor que inicializa la ventana principal de la interfaz del entrenador.
     */
    public VistaEntrenador() {
        ventanaPrincipal = new VentanaPrincipalEntrenador();
    }

    /**
     * Devuelve la ventana principal de la interfaz del entrenador.
     * 
     * @return Instancia de {@code VentanaPrincipalEntrenador}.
     */
    public VentanaPrincipalEntrenador getVentanaPrincipal() {
        return ventanaPrincipal;
    }
}
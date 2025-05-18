package co.edu.unbosque.vista.entrenador;

import javax.swing.*;

public class VistaEntrenador {
    private VentanaPrincipalEntrenador ventanaPrincipal;

    public VistaEntrenador() {
        ventanaPrincipal = new VentanaPrincipalEntrenador();
    }

    public VentanaPrincipalEntrenador getVentanaPrincipal() {
        return ventanaPrincipal;
    }
}
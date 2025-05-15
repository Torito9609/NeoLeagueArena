package co.edu.unbosque.vista.admin;

import javax.swing.*;

public class FabricaPanelUsuarioDinamico {
    
	public static JPanel crearPanel(String tipoUsuario) {
	    if (tipoUsuario == null) return new JPanel();

	    switch (tipoUsuario.trim().toLowerCase()) {
	        case "jugador":
	            return new PanelJugador();
	        case "entrenador":
	            return new PanelEntrenador();
	        default:
	            return new JPanel();
	    }
	}

}

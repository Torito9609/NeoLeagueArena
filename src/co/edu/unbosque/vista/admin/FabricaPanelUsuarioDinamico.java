package co.edu.unbosque.vista.admin;

import javax.swing.*;

public class FabricaPanelUsuarioDinamico {
    
	public static JPanel crearPanel(String tipoProducto) {
	    if (tipoProducto == null) return new JPanel();

	    switch (tipoProducto.trim().toLowerCase()) {
	        case "pan":
	            return new PanelPan();
	        case "galleta":
	            return new PanelGalleta();
	        default:
	            return new JPanel();
	    }
	}

}

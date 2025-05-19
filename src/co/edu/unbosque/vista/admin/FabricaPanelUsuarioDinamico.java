package co.edu.unbosque.vista.admin;

import javax.swing.*;

/**
 * Clase que representa una fábrica para la creación de paneles de usuario dinámicos.
 * Permite generar instancias de diferentes tipos de paneles según el tipo de usuario especificado.
 */
public class FabricaPanelUsuarioDinamico {

    /**
     * Crea y devuelve un panel dinámico según el tipo de usuario especificado.
     *
     * @param tipoUsuario Tipo de usuario para el cual se debe generar un panel. 
     *                    Puede ser "jugador" o "entrenador".
     * @return Un {@code JPanel} correspondiente al tipo de usuario o un panel vacío si el tipo es desconocido.
     */
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
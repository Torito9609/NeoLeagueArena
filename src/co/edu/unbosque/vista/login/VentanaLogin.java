package co.edu.unbosque.vista.login;

import javax.swing.*;

/**
 * Clase que representa una ventana de inicio de sesión.
 * Extiende de JFrame para proporcionar una interfaz gráfica.
 */
public class VentanaLogin extends JFrame {

    private PanelLogin panelLogin;

    /**
     * Constructor que inicializa la ventana de login con configuración básica.
     * Establece el título, tamaño, posición y comportamiento de cierre.
     * Agrega un panel de login como contenido principal.
     */
    public VentanaLogin() {
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); 
        setResizable(false);

        panelLogin = new PanelLogin();
        add(panelLogin);
    }

    /**
     * Obtiene el panel de login asociado a esta ventana.
     * 
     * @return El panel de login actual.
     */
    public PanelLogin getPanelLogin() {
        return panelLogin;
    }

    /**
     * Establece un nuevo panel de login para esta ventana.
     * 
     * @param panelLogin El nuevo panel de login a establecer.
     */
    public void setPanelLogin(PanelLogin panelLogin) {
        this.panelLogin = panelLogin;
    }
}
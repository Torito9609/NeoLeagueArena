package co.edu.unbosque.vista.login;

import javax.swing.*;

public class VentanaLogin extends JFrame {

    private PanelLogin panelLogin;

    public VentanaLogin() {
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); 
        setResizable(false);

        panelLogin = new PanelLogin();
        add(panelLogin);
    }

    public PanelLogin getPanelLogin() {
        return panelLogin;
    }

    public void setPanelLogin(PanelLogin panelLogin) {
        this.panelLogin = panelLogin;
    }
}


package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;

public class ControladorPrincipal {
    private AdminController adminController;
    private EntrenadorController entrenadorController;
    private JugadorController jugadorController;
    private LoginController loginController;
    private TorneoController torneoController;

    public ControladorPrincipal() {
        loginController = new LoginController(this);
    }

    public void lanzarJugadorController(Jugador jugador) {
        //jugadorController = new JugadorController(jugador, this);
        jugadorController = new JugadorController();
    }

    public void lanzarEntrenadorController(Entrenador entrenador) {
        //entrenadorController = new EntrenadorController(entrenador, this);
        entrenadorController = new EntrenadorController();
    }
    
    public void lanzarAdminController() {
    	adminController = new AdminController();
    }
}

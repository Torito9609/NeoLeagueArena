package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;

/**
 * Clase central del sistema NeoLeague Arena que coordina el flujo de control
 * entre los diferentes roles de usuario y sus respectivas interfaces.
 * <p>
 * Esta clase se instancia al iniciar la aplicación y lanza el controlador
 * de login. A partir de ahí, es responsable de determinar qué controlador
 * específico se debe invocar dependiendo del tipo de usuario autenticado.
 */
public class ControladorPrincipal {

    private AdminController adminController;
    private EntrenadorController entrenadorController;
    private JugadorController jugadorController;
    private LoginController loginController;
    private TorneoController torneoController;

    /**
     * Constructor principal que inicia la aplicación lanzando el controlador de login.
     */
    public ControladorPrincipal() {
        loginController = new LoginController(this);
    }

    /**
     * Lanza el controlador correspondiente al jugador autenticado,
     * inicializando su vista y lógica específica.
     *
     * @param jugador instancia del jugador autenticado
     */
    public void lanzarJugadorController(Jugador jugador) {
        jugadorController = new JugadorController(jugador);
    }

    /**
     * Lanza el controlador correspondiente al entrenador autenticado,
     * inicializando su vista y lógica específica.
     *
     * @param entrenador instancia del entrenador autenticado
     */
    public void lanzarEntrenadorController(Entrenador entrenador) {
        entrenadorController = new EntrenadorController(entrenador);
    }

    /**
     * Lanza el controlador del administrador, que permite gestionar
     * usuarios, torneos, reportes y otras funcionalidades avanzadas del sistema.
     */
    public void lanzarAdminController() {
        adminController = new AdminController();
    }
}

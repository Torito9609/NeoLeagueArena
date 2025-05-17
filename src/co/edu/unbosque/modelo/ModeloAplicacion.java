package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.servicio.UsuarioService;

/**
 * Clase principal del modelo que encapsula y proporciona acceso a los diferentes
 * servicios de la aplicación.
 * <p>
 * Esta clase actúa como una fachada para la capa de modelo, permitiendo a los
 * controladores interactuar con los servicios de negocio de una manera centralizada.
 * Actualmente, maneja el servicio de usuarios.
 * </p>
 *
 * @see co.edu.unbosque.modelo.servicio.UsuarioService
 * @see co.edu.unbosque.modelo.exception.AccesoDatosException
 *
 * @autor TuNombreCompletoAquí ReemplázamePorFavor
 * @version 1.0
 * @since 2024-05-17 // Fecha de creación o última modificación importante
 */
public class ModeloAplicacion {

    /**
     * Servicio encargado de la lógica de negocio relacionada con los usuarios.
     */
    private UsuarioService usuarioService;

    /**
     * Constructor de ModeloAplicacion.
     * <p>
     * Inicializa los servicios necesarios para el funcionamiento del modelo.
     * En este caso, inicializa el {@link UsuarioService}.
     * </p>
     *
     * @throws AccesoDatosException Si ocurre un error al inicializar los servicios,
     * por ejemplo, al intentar acceder a la capa de persistencia
     * y esta no está disponible o configurada correctamente.
     */
    public ModeloAplicacion() throws AccesoDatosException {
        // Se instancia el servicio de usuarios.
        // Este servicio podría, a su vez, inicializar DAOs u otros componentes.
        usuarioService = new UsuarioService();
    }

    /**
     * Obtiene la instancia del servicio de usuarios.
     * <p>
     * Este método permite a otras partes de la aplicación, como los controladores,
     * acceder a las funcionalidades ofrecidas por el {@link UsuarioService}.
     * </p>
     *
     * @return La instancia de {@code UsuarioService} gestionada por este modelo.
     */
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    /**
     * Establece la instancia del servicio de usuarios.
     * <p>
     * Este método puede ser utilizado para inyectar una instancia específica de
     * {@code UsuarioService}, lo cual podría ser útil en escenarios de prueba
     * (mocking) o si la creación del servicio se maneja externamente.
     * </p>
     *
     * @param usuarioService La nueva instancia de {@code UsuarioService} a utilizar.
     */
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.JugadorDaoImpl;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

/**
 * Servicio encargado de la lógica de negocio para la entidad {@link Jugador}.
 * <p>
 * Esta clase actúa como intermediario entre la capa de presentación (controladores)
 * y la capa de acceso a datos (DAOs). Coordina operaciones que involucran
 * al {@link JugadorDaoImpl} y al {@link UsuarioService} para gestionar
 * la información de los jugadores de manera integral.
 * </p>
 *
 * @see JugadorDaoImpl
 * @see UsuarioService
 * @see Jugador
 * @see AccesoDatosException
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class JugadorService {

    /**
     * Instancia del DAO para la entidad {@link Jugador}.
     */
    private final JugadorDaoImpl jugadorDao;

    /**
     * Instancia del servicio para la entidad {@link Usuario}, utilizado para operaciones
     * comunes a todos los usuarios, incluyendo jugadores.
     */
    private final UsuarioService usuarioService;

    /**
     * Constructor del servicio {@code JugadorService}.
     * <p>
     * Inicializa las instancias de {@link JugadorDaoImpl} y {@link UsuarioService}
     * necesarias para su funcionamiento.
     * </p>
     *
     * @throws AccesoDatosException Si ocurre un error al inicializar alguno de los
     * DAOs o servicios dependientes (por ejemplo, al cargar datos).
     */
    public JugadorService() throws AccesoDatosException {
        jugadorDao = new JugadorDaoImpl();
        usuarioService = new UsuarioService();
    }

    /**
     * Obtiene todos los usuarios que son instancias de {@link Jugador}.
     * <p>
     * Recupera todos los usuarios del sistema a través del {@link UsuarioService}
     * y filtra aquellos que son específicamente jugadores.
     * </p>
     *
     * @return Una lista de todas las entidades {@link Jugador}.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos de usuarios.
     */
    public List<Jugador> obtenerTodos() throws AccesoDatosException {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        // Se asume que usuarioService.obtenerTodos() no devuelve null.
        for (Usuario u : usuarioService.obtenerTodos()) {
            if (u instanceof Jugador) {
                jugadores.add((Jugador) u);
            }
        }
        return jugadores;
    }

    /**
     * Busca y recupera un jugador por su identificador único.
     * <p>
     * Utiliza el {@link UsuarioService} para buscar el usuario y luego verifica
     * si es una instancia de {@link Jugador}.
     * </p>
     *
     * @param id El ID del jugador (que es también su ID de usuario) a buscar.
     * @return La entidad {@link Jugador} encontrada, o {@code null}
     * si no se encuentra ningún usuario con ese ID o si el usuario encontrado no es un jugador.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos de usuarios.
     */
    public Jugador buscarPorId(String id) throws AccesoDatosException {
        Usuario u = usuarioService.buscarPorId(id);
        if (u instanceof Jugador) {
            return (Jugador) u;
        }
        return null;
    }

    /**
     * Crea un nuevo jugador en el sistema.
     * <p>
     * Prepara los datos del nuevo usuario (jugador) y su contraseña inicial a través
     * del {@link UsuarioService}, luego crea el registro de usuario y finalmente
     * guarda la entidad jugador específica usando el {@link JugadorDaoImpl}.
     * </p>
     *
     * @param jugador         La entidad {@link Jugador} a crear, con sus datos específicos.
     * @param passwordInicial La contraseña en texto plano para el nuevo jugador.
     * Será hasheada por el {@code UsuarioService}.
     * @throws AccesoDatosException Si ocurre un error al crear el usuario o guardar el jugador.
     */
    public void crearJugador(Jugador jugador, String passwordInicial) throws AccesoDatosException {
        // Asume que estos métodos de UsuarioService preparan y guardan la parte de Usuario de la entidad Jugador.
        usuarioService.prepararNuevoUsuario(jugador, passwordInicial);
        usuarioService.crearUsuario(jugador, passwordInicial);
        jugadorDao.guardar(jugador); // Guarda los datos específicos del Jugador
    }

    /**
     * Actualiza la información de un jugador existente.
     * <p>
     * Actualiza los datos base del usuario a través del {@link UsuarioService} y luego
     * actualiza los datos específicos del jugador a través del {@link JugadorDaoImpl}.
     * </p>
     *
     * @param jugadorActualizado La entidad {@link Jugador} con los nuevos datos.
     * @throws AccesoDatosException Si ocurre un error al actualizar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void actualizarJugador(Jugador jugadorActualizado) throws AccesoDatosException, IOException {
        usuarioService.actualizarUsuario(jugadorActualizado); // Actualiza datos de Usuario
        jugadorDao.actualizar(jugadorActualizado.getId(), jugadorActualizado); // Actualiza datos de Jugador
    }

    /**
     * Elimina un jugador del sistema.
     * <p>
     * Primero elimina el registro de usuario base a través del {@link UsuarioService}
     * y luego elimina el registro específico del jugador a través del {@link JugadorDaoImpl}.
     * Se deben considerar las implicaciones en otras entidades relacionadas (ej. participaciones en torneos, equipos).
     * </p>
     *
     * @param id El ID del jugador a eliminar.
     * @throws AccesoDatosException Si ocurre un error al eliminar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void eliminarJugador(String id) throws AccesoDatosException, IOException {
        // Considerar la lógica para eliminar participaciones o desvincular de equipos antes de eliminar.
        usuarioService.eliminarUsuario(id); // Elimina el Usuario base
        jugadorDao.eliminar(id); // Elimina los datos específicos de Jugador
    }
}
package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.UsuarioDaoImpl;
import co.edu.unbosque.modelo.entidad.Entrenador; // Usado para instanceof
import co.edu.unbosque.modelo.entidad.Jugador;   // Usado para instanceof
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.UsuarioNoEncontradoException;
import co.edu.unbosque.utils.Encriptador; // Asumo que esta clase existe para encriptar

/**
 * Servicio encargado de la lógica de negocio para la entidad {@link Usuario}.
 * <p>
 * Esta clase actúa como intermediario entre la capa de presentación (controladores)
 * y la capa de acceso a datos ({@link UsuarioDaoImpl}). Proporciona métodos
 * para gestionar usuarios, incluyendo operaciones CRUD, filtrado, preparación
 * de nuevos usuarios y verificación de credenciales.
 * </p>
 *
 * @see UsuarioDaoImpl
 * @see Usuario
 * @see AccesoDatosException
 * @see UsuarioNoEncontradoException
 * @see Encriptador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class UsuarioService {

    /**
     * Instancia del DAO para la entidad {@link Usuario}.
     * Este campo es final y se inicializa en el constructor.
     */
    private final UsuarioDaoImpl usuarioDao;

    /**
     * Constructor del servicio {@code UsuarioService}.
     * <p>
     * Inicializa una nueva instancia de {@link UsuarioDaoImpl} para
     * interactuar con la capa de persistencia de usuarios.
     * </p>
     *
     * @throws AccesoDatosException Si ocurre un error al inicializar el DAO,
     * por ejemplo, al intentar cargar datos desde un archivo.
     */
    public UsuarioService() throws AccesoDatosException {
        usuarioDao = new UsuarioDaoImpl();
    }

    /**
     * Obtiene todos los usuarios registrados en el sistema.
     *
     * @return Una lista de todas las entidades {@link Usuario}.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public List<Usuario> obtenerTodos() throws AccesoDatosException {
        return usuarioDao.obtenerTodos();
    }

    /**
     * Busca y recupera un usuario por su identificador único.
     * <p>
     * Este método itera sobre la lista de todos los usuarios obtenidos del DAO.
     * Considerar la eficiencia si la lista de usuarios es muy grande.
     * </p>
     *
     * @param id El ID del usuario a buscar.
     * @return La entidad {@link Usuario} encontrada, o {@code null}
     * si no se encuentra ningún usuario con el ID proporcionado.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public Usuario buscarPorId(String id) throws AccesoDatosException {
        // Se asume que usuarioDao.obtenerTodos() no devuelve null.
        List<Usuario> todos = usuarioDao.obtenerTodos();
        if (todos != null && id != null) {
            for (Usuario u : todos) {
                if (u != null && u.getId() != null && u.getId().equals(id)) {
                    return u;
                }
            }
        }
        return null;
    }

    /**
     * Crea un nuevo usuario en el sistema.
     * <p>
     * Primero prepara al nuevo usuario (encriptando su contraseña inicial y marcándola
     * para cambio) y luego lo guarda utilizando el DAO.
     * </p>
     *
     * @param usuario         La entidad {@link Usuario} (o subclase como {@link Entrenador}, {@link Jugador}) a crear.
     * @param passwordInicial La contraseña en texto plano para el nuevo usuario.
     * @throws AccesoDatosException Si ocurre un error al guardar los datos.
     */
    public void crearUsuario(Usuario usuario, String passwordInicial) throws AccesoDatosException {
        prepararNuevoUsuario(usuario, passwordInicial);
        // El método guardar del DAO devuelve un booleano que no se está utilizando aquí.
        usuarioDao.guardar(usuario);
    }

    /**
     * Actualiza la información de un usuario existente en el sistema.
     *
     * @param usuarioActualizado La entidad {@link Usuario} con los nuevos datos. Su ID se utiliza
     * para identificar el registro a actualizar.
     * @throws AccesoDatosException Si ocurre un error al actualizar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void actualizarUsuario(Usuario usuarioActualizado)
            throws AccesoDatosException, IOException {
        // El método actualizar del DAO devuelve un booleano.
        usuarioDao.actualizar(usuarioActualizado.getId(), usuarioActualizado);
    }

    /**
     * Elimina un usuario del sistema, identificado por su ID.
     *
     * @param id El ID del usuario a eliminar.
     * @throws AccesoDatosException Si ocurre un error al eliminar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void eliminarUsuario(String id) throws AccesoDatosException, IOException {
        // El método eliminar del DAO devuelve un booleano.
        usuarioDao.eliminar(id);
    }

    /**
     * Filtra la lista de todos los usuarios por país.
     *
     * @param pais El nombre del país por el cual filtrar (ignora mayúsculas/minúsculas).
     * @return Una lista de {@link Usuario}s cuyo país coincide con el criterio.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public List<Usuario> filtrarPorPais(String pais) throws AccesoDatosException {
        List<Usuario> resultado = new ArrayList<>();
        // Se asume que usuarioDao.obtenerTodos() no devuelve null.
        if (pais != null) {
            for (Usuario u : usuarioDao.obtenerTodos()) {
                if (u != null && u.getPais() != null && u.getPais().equalsIgnoreCase(pais)) {
                    resultado.add(u);
                }
            }
        }
        return resultado;
    }

    /**
     * Filtra la lista de todos los usuarios por ciudad.
     *
     * @param ciudad El nombre de la ciudad por la cual filtrar (ignora mayúsculas/minúsculas).
     * @return Una lista de {@link Usuario}s cuya ciudad coincide con el criterio.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public List<Usuario> filtrarPorCiudad(String ciudad) throws AccesoDatosException {
        List<Usuario> resultado = new ArrayList<>();
        // Se asume que usuarioDao.obtenerTodos() no devuelve null.
        if (ciudad != null) {
            for (Usuario u : usuarioDao.obtenerTodos()) {
                if (u != null && u.getCiudad() != null && u.getCiudad().equalsIgnoreCase(ciudad)) {
                    resultado.add(u);
                }
            }
        }
        return resultado;
    }

    /**
     * Prepara un objeto {@link Usuario} para su creación.
     * Establece el hash de la contraseña inicial y marca la contraseña para ser cambiada.
     *
     * @param usuario         El objeto {@link Usuario} a preparar.
     * @param passwordInicial La contraseña en texto plano que se encriptará.
     */
    public void prepararNuevoUsuario(Usuario usuario, String passwordInicial) {
        if (usuario != null && passwordInicial != null) {
            String passwordHash = Encriptador.encriptarSHA256(passwordInicial);
            usuario.setPasswordHash(passwordHash);
            usuario.setNecesitaCambioPassword(true);
        }
    }

    /**
     * Verifica las credenciales de un usuario (correo y contraseña).
     *
     * @param correo   El correo electrónico del usuario.
     * @param password La contraseña en texto plano a verificar.
     * @return {@code true} si el correo y el hash de la contraseña coinciden con un
     * usuario registrado, {@code false} en caso contrario.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public boolean verificarCredenciales(String correo, String password)
            throws AccesoDatosException {
        if (correo == null || password == null) return false;
        String hash = Encriptador.encriptarSHA256(password);
        // Se asume que usuarioDao.obtenerTodos() no devuelve null.
        for (Usuario u : usuarioDao.obtenerTodos()) {
            if (u != null && u.getCorreo() != null && u.getPasswordHash() != null &&
                u.getCorreo().equalsIgnoreCase(correo) &&
                u.getPasswordHash().equals(hash)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cambia la contraseña de un usuario específico.
     *
     * @param idUsuario     El ID del usuario cuya contraseña se cambiará.
     * @param nuevaPassword La nueva contraseña en texto plano.
     * @throws UsuarioNoEncontradoException Si no se encuentra ningún usuario con el {@code idUsuario} proporcionado.
     * @throws AccesoDatosException         Si ocurre un error al actualizar los datos del usuario.
     * @throws IOException                  Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void cambiarPassword(String idUsuario, String nuevaPassword)
            throws UsuarioNoEncontradoException, AccesoDatosException, IOException {
        if (idUsuario == null || nuevaPassword == null) {
            // Podría lanzar IllegalArgumentException o similar si los parámetros son inválidos.
            // Por ahora, si buscarPorId devuelve null, se lanzará UsuarioNoEncontradoException.
        }
        Usuario u = buscarPorId(idUsuario);
        if (u == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado con ID: " + idUsuario + " para cambiar contraseña.");
        }
        u.setPasswordHash(Encriptador.encriptarSHA256(nuevaPassword));
        u.setNecesitaCambioPassword(false);
        actualizarUsuario(u);
    }
}
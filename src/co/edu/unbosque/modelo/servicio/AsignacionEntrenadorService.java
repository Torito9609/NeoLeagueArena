package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.AsignacionEntrenadorDaoImpl;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.entidad.Entrenador; // Usado para obtener ID en listarPorEntrenador
import co.edu.unbosque.modelo.entidad.Equipo;    // Usado para obtener ID en listarPorEquipo
import co.edu.unbosque.modelo.exception.AccesoDatosException;
// No se usa AsignacionEntrenadorDto directamente en la firma de los métodos públicos de esta clase,
// pero es relevante para el AsignacionEntrenadorDaoImpl.

/**
 * Servicio encargado de la lógica de negocio para las asignaciones de entrenadores a equipos.
 * <p>
 * Esta clase actúa como intermediario entre la capa de presentación (controladores)
 * y la capa de acceso a datos (DAO) para las operaciones relacionadas con
 * {@link AsignacionEntrenador}. Proporciona métodos para crear, leer, actualizar,
 * eliminar y listar asignaciones.
 * </p>
 *
 * @see AsignacionEntrenadorDaoImpl
 * @see AsignacionEntrenador
 * @see AccesoDatosException
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class AsignacionEntrenadorService {

    /**
     * Instancia del DAO para la entidad {@link AsignacionEntrenador}.
     * Este campo es final y se inicializa en el constructor.
     */
    private final AsignacionEntrenadorDaoImpl asignacionDao;

    /**
     * Constructor del servicio {@code AsignacionEntrenadorService}.
     * <p>
     * Inicializa una nueva instancia de {@link AsignacionEntrenadorDaoImpl} para
     * interactuar con la capa de persistencia.
     * </p>
     *
     * @throws AccesoDatosException Si ocurre un error al inicializar el DAO,
     * por ejemplo, al intentar cargar datos desde un archivo.
     */
    public AsignacionEntrenadorService() throws AccesoDatosException {
        this.asignacionDao = new AsignacionEntrenadorDaoImpl();
    }

    /**
     * Obtiene todas las asignaciones de entrenadores registradas.
     *
     * @return Una lista de todas las entidades {@link AsignacionEntrenador}.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public List<AsignacionEntrenador> obtenerTodos() throws AccesoDatosException {
        return asignacionDao.obtenerTodos();
    }

    /**
     * Busca y recupera una asignación de entrenador por su identificador único.
     *
     * @param id El ID de la asignación a buscar.
     * @return La entidad {@link AsignacionEntrenador} encontrada, o {@code null}
     * si no se encuentra ninguna asignación con el ID proporcionado.
     */
    public AsignacionEntrenador buscarPorId(String id) {
        return asignacionDao.buscarPorId(id);
    }

    /**
     * Crea una nueva asignación de entrenador en el sistema.
     *
     * @param asignacion La entidad {@link AsignacionEntrenador} a crear.
     * @throws AccesoDatosException Si ocurre un error al guardar los datos.
     */
    public void crearAsignacion(AsignacionEntrenador asignacion)
            throws AccesoDatosException {
        // El método guardar del DAO devuelve un booleano que no se está utilizando aquí.
        // Podría considerarse verificarlo y lanzar una excepción si falla el guardado.
        asignacionDao.guardar(asignacion);
    }

    /**
     * Actualiza una asignación de entrenador existente en el sistema.
     *
     * @param id                     El ID de la asignación a actualizar.
     * @param asignacionActualizada La entidad {@link AsignacionEntrenador} con los nuevos datos.
     * @throws AccesoDatosException Si ocurre un error al actualizar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la operación.
     */
    public void actualizarAsignacion(String id, AsignacionEntrenador asignacionActualizada)
            throws AccesoDatosException, IOException {
        // El método actualizar del DAO devuelve un booleano.
        asignacionDao.actualizar(id, asignacionActualizada);
    }

    /**
     * Elimina una asignación de entrenador del sistema.
     *
     * @param id El ID de la asignación a eliminar.
     * @throws AccesoDatosException Si ocurre un error al eliminar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la operación.
     */
    public void eliminarAsignacion(String id)
            throws AccesoDatosException, IOException {
        // El método eliminar del DAO devuelve un booleano.
        asignacionDao.eliminar(id);
    }

    /**
     * Obtiene todas las asignaciones correspondientes a un entrenador específico.
     *
     * @param idEntrenador El ID del {@link Entrenador} cuyas asignaciones se desean listar.
     * @return Una lista de {@link AsignacionEntrenador} donde el entrenador coincide
     * con el ID proporcionado. La lista estará vacía si no se encuentran asignaciones.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public List<AsignacionEntrenador> listarPorEntrenador(String idEntrenador)
            throws AccesoDatosException {
        List<AsignacionEntrenador> resultado = new ArrayList<>();
        // Se asume que asignacionDao.obtenerTodos() no devuelve null.
        for (AsignacionEntrenador a : asignacionDao.obtenerTodos()) {
            // Se asume que a.getEntrenador() no es null y tiene un método getId().
            if (a.getEntrenador() != null && a.getEntrenador().getId().equals(idEntrenador)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    /**
     * Obtiene todas las asignaciones correspondientes a un equipo específico.
     *
     * @param idEquipo El ID del {@link Equipo} cuyas asignaciones se desean listar.
     * @return Una lista de {@link AsignacionEntrenador} donde el equipo coincide
     * con el ID proporcionado. La lista estará vacía si no se encuentran asignaciones.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos.
     */
    public List<AsignacionEntrenador> listarPorEquipo(String idEquipo)
            throws AccesoDatosException {
        List<AsignacionEntrenador> resultado = new ArrayList<>();
        // Se asume que asignacionDao.obtenerTodos() no devuelve null.
        for (AsignacionEntrenador a : asignacionDao.obtenerTodos()) {
            // Se asume que a.getEquipo() no es null y tiene un método getId().
            if (a.getEquipo() != null && a.getEquipo().getId().equals(idEquipo)) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
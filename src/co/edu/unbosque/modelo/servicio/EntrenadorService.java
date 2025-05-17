package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID; // Usado para generar IDs de asignación

import co.edu.unbosque.modelo.dao.EntrenadorDaoImpl;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

/**
 * Servicio encargado de la lógica de negocio para la entidad {@link Entrenador}.
 * <p>
 * Esta clase actúa como intermediario entre la capa de presentación (controladores)
 * y la capa de acceso a datos (DAOs). Coordina operaciones que involucran
 * no solo al {@link EntrenadorDaoImpl}, sino también a otros servicios como
 * {@link UsuarioService}, {@link AsignacionEntrenadorService} y {@link EquipoService}
 * para mantener la integridad y consistencia de los datos.
 * </p>
 *
 * @see EntrenadorDaoImpl
 * @see UsuarioService
 * @see AsignacionEntrenadorService
 * @see EquipoService
 * @see Entrenador
 * @see AccesoDatosException
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class EntrenadorService {

    /**
     * Instancia del DAO para la entidad {@link Entrenador}.
     */
    private final EntrenadorDaoImpl entrenadorDao;

    /**
     * Instancia del servicio para la entidad {@link Usuario}, utilizado para operaciones
     * comunes a todos los usuarios, incluyendo entrenadores.
     */
    private final UsuarioService usuarioService;

    /**
     * Instancia del servicio para las asignaciones entrenador-equipo.
     */
    private final AsignacionEntrenadorService asignacionService;

    /**
     * Instancia del servicio para la entidad {@link Equipo}, utilizado para buscar equipos
     * al realizar asignaciones.
     */
    private final EquipoService equipoService;

    /**
     * Constructor del servicio {@code EntrenadorService}.
     * <p>
     * Inicializa las instancias de los DAOs y servicios necesarios.
     * </p>
     *
     * @throws AccesoDatosException Si ocurre un error al inicializar alguno de los
     * DAOs o servicios dependientes (por ejemplo, al cargar datos).
     */
    public EntrenadorService() throws AccesoDatosException {
        entrenadorDao = new EntrenadorDaoImpl();
        usuarioService = new UsuarioService();
        asignacionService = new AsignacionEntrenadorService();
        equipoService = new EquipoService(); // Asume que EquipoService tiene un constructor similar
    }

    /**
     * Obtiene todos los usuarios que son instancias de {@link Entrenador}.
     * <p>
     * Recupera todos los usuarios del sistema a través del {@link UsuarioService}
     * y filtra aquellos que son específicamente entrenadores.
     * </p>
     *
     * @return Una lista de todas las entidades {@link Entrenador}.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos de usuarios.
     */
    public List<Entrenador> obtenerTodos() throws AccesoDatosException {
        List<Entrenador> entrenadores = new ArrayList<Entrenador>();
        // Se asume que usuarioService.obtenerTodos() no devuelve null
        for (Usuario u : usuarioService.obtenerTodos()) {
            if (u instanceof Entrenador) {
                entrenadores.add((Entrenador) u);
            }
        }
        return entrenadores;
    }

    /**
     * Busca y recupera un entrenador por su identificador único.
     * <p>
     * Utiliza el {@link UsuarioService} para buscar el usuario y luego verifica
     * si es una instancia de {@link Entrenador}.
     * </p>
     *
     * @param id El ID del entrenador (que es también su ID de usuario) a buscar.
     * @return La entidad {@link Entrenador} encontrada, o {@code null}
     * si no se encuentra ningún usuario con ese ID o si el usuario encontrado no es un entrenador.
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos de usuarios.
     */
    public Entrenador buscarPorId(String id) throws AccesoDatosException {
        Usuario u = usuarioService.buscarPorId(id);
        if (u instanceof Entrenador) {
            return (Entrenador) u;
        }
        return null;
    }

    /**
     * Crea un nuevo entrenador en el sistema.
     * <p>
     * Prepara los datos del nuevo usuario (entrenador) y su contraseña inicial a través
     * del {@link UsuarioService}, luego crea el registro de usuario y finalmente
     * guarda la entidad entrenador específica usando el {@link EntrenadorDaoImpl}.
     * </p>
     *
     * @param entrenador      La entidad {@link Entrenador} a crear, con sus datos específicos.
     * @param passwordInicial La contraseña en texto plano para el nuevo entrenador.
     * Será hasheada por el {@code UsuarioService}.
     * @throws AccesoDatosException Si ocurre un error al crear el usuario o guardar el entrenador.
     */
    public void crearEntrenador(Entrenador entrenador, String passwordInicial) throws AccesoDatosException {
        usuarioService.prepararNuevoUsuario(entrenador, passwordInicial); // Asume que este método existe y prepara el Usuario
        usuarioService.crearUsuario(entrenador, passwordInicial); // Asume que este método guarda el Usuario base
        entrenadorDao.guardar(entrenador); // Guarda los datos específicos del Entrenador
    }

    /**
     * Actualiza la información de un entrenador existente.
     * <p>
     * Actualiza los datos base del usuario a través del {@link UsuarioService} y luego
     * actualiza los datos específicos del entrenador a través del {@link EntrenadorDaoImpl}.
     * </p>
     *
     * @param entrenadorActualizado La entidad {@link Entrenador} con los nuevos datos.
     * @throws AccesoDatosException Si ocurre un error al actualizar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void actualizarEntrenador(Entrenador entrenadorActualizado) throws AccesoDatosException, IOException {
        usuarioService.actualizarUsuario(entrenadorActualizado); // Actualiza datos de Usuario
        entrenadorDao.actualizar(entrenadorActualizado.getId(), entrenadorActualizado); // Actualiza datos de Entrenador
    }

    /**
     * Elimina un entrenador del sistema.
     * <p>
     * Primero elimina el registro de usuario base a través del {@link UsuarioService}
     * y luego elimina el registro específico del entrenador a través del {@link EntrenadorDaoImpl}.
     * También se deberían eliminar las asignaciones asociadas.
     * </p>
     *
     * @param id El ID del entrenador a eliminar.
     * @throws AccesoDatosException Si ocurre un error al eliminar los datos.
     * @throws IOException          Si ocurre un error de entrada/salida durante la persistencia.
     */
    public void eliminarEntrenador(String id) throws AccesoDatosException, IOException {
        // Considerar eliminar primero las asignaciones del entrenador para mantener integridad referencial
        // List<AsignacionEntrenador> asignaciones = asignacionService.listarPorEntrenador(id);
        // for (AsignacionEntrenador a : asignaciones) {
        //     asignacionService.eliminarAsignacion(a.getIdAsignacion());
        // }
        usuarioService.eliminarUsuario(id); // Elimina el Usuario base
        entrenadorDao.eliminar(id); // Elimina los datos específicos de Entrenador
    }

    /**
     * Asigna un equipo a un entrenador.
     * <p>
     * Busca el entrenador y el equipo por sus IDs. Si ambos existen, crea una nueva
     * {@link AsignacionEntrenador} con una fecha actual y la persiste utilizando el
     * {@link AsignacionEntrenadorService}.
     * </p>
     *
     * @param idEntrenador El ID del {@link Entrenador} al que se asignará el equipo.
     * @param idEquipo     El ID del {@link Equipo} a asignar.
     * @throws AccesoDatosException Si el entrenador o el equipo no son encontrados,
     * o si ocurre un error al crear la asignación.
     * @throws IOException (Heredado de la firma, pero no lanzado directamente por este método,
     * sino potencialmente por {@code asignacionService.crearAsignacion} si ese método lo declara)
     */
    public void asignarEquipo(String idEntrenador, String idEquipo) throws AccesoDatosException, IOException {
        Entrenador e = buscarPorId(idEntrenador);
        if (e == null) {
            throw new AccesoDatosException("Entrenador no encontrado con ID: " + idEntrenador);
        }
        Equipo equipo = equipoService.buscarPorId(idEquipo); // Asume que EquipoService tiene buscarPorId
        if (equipo == null) {
            throw new AccesoDatosException("Equipo no encontrado con ID: " + idEquipo);
        }

        // Crea una nueva asignación con un ID único.
        AsignacionEntrenador a = new AsignacionEntrenador(UUID.randomUUID().toString(), e, equipo, LocalDate.now());
        asignacionService.crearAsignacion(a);
    }

    /**
     * Remueve la asignación de un equipo a un entrenador.
     * <p>
     * Busca todas las asignaciones del entrenador, y si encuentra una que corresponda
     * al ID del equipo especificado, la elimina utilizando el {@link AsignacionEntrenadorService}.
     * </p>
     *
     * @param idEntrenador El ID del {@link Entrenador}.
     * @param idEquipo     El ID del {@link Equipo} cuya asignación se removerá.
     * @throws AccesoDatosException Si el entrenador no tiene asignado el equipo especificado,
     * o si ocurre un error al listar o eliminar las asignaciones.
     * @throws IOException Si ocurre un error de entrada/salida al eliminar la asignación.
     */
    public void removerEquipo(String idEntrenador, String idEquipo) throws AccesoDatosException, IOException {
        List<AsignacionEntrenador> lista = asignacionService.listarPorEntrenador(idEntrenador);
        boolean encontrado = false;
        if (lista != null) {
            for (AsignacionEntrenador a : lista) {
                if (a.getEquipo() != null && a.getEquipo().getId().equals(idEquipo)) {
                    asignacionService.eliminarAsignacion(a.getIdAsignacion());
                    encontrado = true;
                    return; // Asume que un equipo solo puede estar asignado una vez al mismo entrenador
                }
            }
        }
        if (!encontrado) {
            throw new AccesoDatosException("El entrenador con ID " + idEntrenador + " no tiene asignado el equipo con ID " + idEquipo);
        }
    }

    /**
     * Lista todos los equipos asignados a un entrenador específico.
     *
     * @param idEntrenador El ID del {@link Entrenador}.
     * @return Una lista de {@link Equipo}s asignados al entrenador.
     * @throws AccesoDatosException Si ocurre un error al listar las asignaciones.
     */
    public List<Equipo> listarEquiposAsignados(String idEntrenador) throws AccesoDatosException {
        List<Equipo> resultado = new ArrayList<>();
        List<AsignacionEntrenador> listaAsignaciones = asignacionService.listarPorEntrenador(idEntrenador);
        if (listaAsignaciones != null) {
            for (AsignacionEntrenador a : listaAsignaciones) {
                if (a.getEquipo() != null) {
                    resultado.add(a.getEquipo());
                }
            }
        }
        return resultado;
    }
}
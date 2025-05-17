package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.AsignacionEntrenadorDto;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.AsignacionEntrenadorMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

/**
 * DAO para la entidad {@link AsignacionEntrenador}.
 * Gestiona las operaciones CRUD para las asignaciones de entrenadores
 * utilizando un {@link GestorPersistencia} para la persistencia en archivo.
 *
 * @see ICrudDao
 * @see AsignacionEntrenador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class AsignacionEntrenadorDaoImpl implements ICrudDao<AsignacionEntrenador> {

    /**
     * Ruta del archivo de persistencia para las asignaciones.
     */
    private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_ASIGNACION_ENTRENADORES;

    /**
     * Gestor para la lectura y escritura de datos de asignación.
     */
    private final GestorPersistencia<AsignacionEntrenador, AsignacionEntrenadorDto> gestor;

    /**
     * Lista en memoria de las asignaciones de entrenadores.
     */
    private List<AsignacionEntrenador> asignaciones;

    /**
     * Constructor que inicializa el DAO y carga los datos desde el archivo.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    public AsignacionEntrenadorDaoImpl() throws AccesoDatosException {
        this.asignaciones = new ArrayList<AsignacionEntrenador>();
        AsignacionEntrenadorMapHandler asignacionMapper = new AsignacionEntrenadorMapHandler();
        this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, asignacionMapper);
        actualizarBD();
    }

    /**
     * Actualiza la lista en memoria {@code asignaciones} desde el archivo de persistencia.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    private void actualizarBD() throws AccesoDatosException {
        asignaciones = gestor.cargar();
        if (this.asignaciones == null) {
            this.asignaciones = new ArrayList<>();
        }
    }

    /**
     * Elimina el archivo de persistencia existente y crea uno nuevo vacío.
     *
     * @throws IOException Si ocurre un error de E/S durante la operación.
     */
    private void recrearArchivo() throws IOException {
        if (gestor.getUbicacionArchivo().exists()) {
            gestor.getUbicacionArchivo().delete();
        }
        gestor.getUbicacionArchivo().createNewFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AsignacionEntrenador> obtenerTodos() throws AccesoDatosException {
        return gestor.cargar(); // Siempre lee del archivo para obtener la versión más reciente
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean guardar(AsignacionEntrenador u) throws AccesoDatosException {
        if (buscarPorId(u.getIdAsignacion()) == null) {
            asignaciones.add(u);
            gestor.guardar(asignaciones);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminar(String id) throws AccesoDatosException, IOException {
        AsignacionEntrenador asignacionEliminar = buscarPorId(id);
        if (asignacionEliminar != null) {
            asignaciones.remove(asignacionEliminar);
            recrearArchivo();
            gestor.guardar(asignaciones);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean actualizar(String idActualizar, AsignacionEntrenador uActualizado)
            throws AccesoDatosException, IOException {
        AsignacionEntrenador asignacionActualizar = buscarPorId(idActualizar);
        if (asignacionActualizar != null) {
            int indice = asignaciones.indexOf(asignacionActualizar);
            if (indice != -1) {
                asignaciones.set(indice, uActualizado);
                recrearArchivo();
                gestor.guardar(asignaciones);
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AsignacionEntrenador buscarPorId(String id) {
        for (AsignacionEntrenador asignacion : asignaciones) {
            if (asignacion.getIdAsignacion().equals(id)) {
                return asignacion;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>Este método aún no está implementado.</p>
     */
    @Override
    public boolean guardarTodos(List<AsignacionEntrenador> u) {
        // TODO: Implementar la lógica para guardar una lista completa de asignaciones.
        System.err.println("El método guardarTodos(List<AsignacionEntrenador>) aún no está implementado.");
        return false;
    }
}
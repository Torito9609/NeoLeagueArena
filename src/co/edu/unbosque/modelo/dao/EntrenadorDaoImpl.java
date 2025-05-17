package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
// import co.edu.unbosque.modelo.dto.UsuarioDto; // No se usa directamente aquí
import co.edu.unbosque.modelo.entidad.Entrenador;
// import co.edu.unbosque.modelo.entidad.Usuario; // No se usa directamente aquí
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.EntrenadorMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

/**
 * DAO para la entidad {@link Entrenador}.
 * Gestiona las operaciones CRUD para los entrenadores utilizando un
 * {@link GestorPersistencia} para la persistencia en archivo.
 *
 * @see ICrudDao
 * @see Entrenador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class EntrenadorDaoImpl implements ICrudDao<Entrenador> {

    /**
     * Ruta del archivo de persistencia para los entrenadores.
     */
    private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_ENTRENADORES;

    /**
     * Gestor para la lectura y escritura de datos de entrenadores.
     */
    private final GestorPersistencia<Entrenador, EntrenadorDto> gestor;

    /**
     * Lista en memoria de los entrenadores.
     */
    private List<Entrenador> entrenadores;

    /**
     * Constructor que inicializa el DAO y carga los datos desde el archivo.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    public EntrenadorDaoImpl() throws AccesoDatosException {
        this.entrenadores = new ArrayList<Entrenador>();
        EntrenadorMapHandler entrenadorMapper = new EntrenadorMapHandler();
        this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, entrenadorMapper);
        actualizarBD();
    }

    /**
     * Actualiza la lista en memoria {@code entrenadores} desde el archivo de persistencia.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    private void actualizarBD() throws AccesoDatosException {
        entrenadores = gestor.cargar();
        if (this.entrenadores == null) {
            this.entrenadores = new ArrayList<>();
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
    public List<Entrenador> obtenerTodos() throws AccesoDatosException {
        // Actualiza la lista desde el archivo antes de devolverla
        actualizarBD();
        return new ArrayList<>(entrenadores); // Devuelve una copia para evitar modificaciones externas
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean guardar(Entrenador u) throws AccesoDatosException {
        // Asumiendo que Entrenador tiene un método getId() heredado de Usuario
        if (buscarPorId(u.getId()) == null) {
            entrenadores.add(u);
            gestor.guardar(entrenadores);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminar(String id) throws AccesoDatosException, IOException {
        Entrenador entrenadorEliminar = buscarPorId(id);
        if (entrenadorEliminar != null) {
            entrenadores.remove(entrenadorEliminar);
            recrearArchivo();
            gestor.guardar(entrenadores);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean actualizar(String idActualizar, Entrenador uActualizado) throws AccesoDatosException, IOException {
        Entrenador entrenadorActualizar = buscarPorId(idActualizar);
        if (entrenadorActualizar != null) {
            int indice = entrenadores.indexOf(entrenadorActualizar);
            if (indice != -1) {
                entrenadores.set(indice, uActualizado);
                recrearArchivo();
                gestor.guardar(entrenadores);
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * Busca un entrenador en la lista en memoria por su ID.
     * Asume que la clase {@link Entrenador} hereda un método {@code getId()} de {@link Usuario}.
     */
    @Override
    public Entrenador buscarPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Entrenador entrenador : entrenadores) {
            // Asumiendo que Entrenador tiene un método getId() (heredado de Usuario)
            if (entrenador.getId() != null && entrenador.getId().equals(id)) {
                return entrenador;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>Este método aún no está implementado.</p>
     */
    @Override
    public boolean guardarTodos(List<Entrenador> u) {
        // TODO: Implementar la lógica para guardar una lista completa de entrenadores.
        System.err.println("El método guardarTodos(List<Entrenador>) aún no está implementado.");
        return false;
    }
}
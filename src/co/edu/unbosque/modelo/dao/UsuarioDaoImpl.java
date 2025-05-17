package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.UsuarioMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

/**
 * DAO para la entidad {@link Usuario}.
 * Gestiona las operaciones CRUD para los usuarios (que pueden ser la base
 * para Entrenadores, Jugadores u otros tipos de usuarios) utilizando un
 * {@link GestorPersistencia} para la persistencia en archivo.
 *
 * @see ICrudDao
 * @see Usuario
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class UsuarioDaoImpl implements ICrudDao<Usuario> {

    /**
     * Ruta del archivo de persistencia para los usuarios.
     */
    private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_USUARIOS;

    /**
     * Gestor para la lectura y escritura de datos de usuarios.
     * Utiliza UsuarioMapHandler para la conversión entre Usuario (entidad) y UsuarioDto.
     */
    private final GestorPersistencia<Usuario, UsuarioDto> gestor;

    /**
     * Lista en memoria de los usuarios.
     */
    private List<Usuario> usuarios;

    /**
     * Constructor que inicializa el DAO y carga los datos de usuarios desde el archivo.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    public UsuarioDaoImpl() throws AccesoDatosException {
        this.usuarios = new ArrayList<Usuario>();
        UsuarioMapHandler usuarioMapper = new UsuarioMapHandler();
        this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, usuarioMapper);
        actualizarBD();
    }

    /**
     * Actualiza la lista en memoria {@code usuarios} desde el archivo de persistencia.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    private void actualizarBD() throws AccesoDatosException {
        usuarios = gestor.cargar();
        if (this.usuarios == null) {
            this.usuarios = new ArrayList<>();
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
    public List<Usuario> obtenerTodos() throws AccesoDatosException {
        // Actualiza la lista desde el archivo antes de devolverla
        actualizarBD();
        return usuarios.isEmpty() ? List.of() : new ArrayList<>(usuarios); // Devuelve copia o lista inmutable vacía
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean guardar(Usuario u) throws AccesoDatosException {
        if (u == null || u.getId() == null) { // Verifica nulidad de 'u' también
            System.err.println("UsuarioDaoImpl.guardar: El usuario o su ID no pueden ser nulos.");
            return false;
        }
        if (buscarPorId(u.getId()) == null) {
            usuarios.add(u);
            gestor.guardar(usuarios);
            return true;
        }
        System.err.println("UsuarioDaoImpl.guardar: Ya existe un usuario con el ID " + u.getId());
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminar(String id) throws AccesoDatosException, IOException {
        if (id == null || id.trim().isEmpty()) {
            System.err.println("UsuarioDaoImpl.eliminar: El ID del usuario a eliminar no puede ser nulo o vacío.");
            return false;
        }
        Usuario usuarioEliminar = buscarPorId(id);
        if (usuarioEliminar != null) {
            boolean removido = usuarios.remove(usuarioEliminar);
            if (removido) {
                recrearArchivo();
                gestor.guardar(usuarios);
            }
            return removido;
        }
        System.err.println("UsuarioDaoImpl.eliminar: No se encontró usuario con ID " + id);
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean actualizar(String idActualizar, Usuario uActualizado) throws AccesoDatosException, IOException {
        if (idActualizar == null || idActualizar.trim().isEmpty() || uActualizado == null || uActualizado.getId() == null) {
             System.err.println("UsuarioDaoImpl.actualizar: IDs o usuario actualizado no pueden ser nulos.");
            return false;
        }
        // Opcional: verificar si idActualizar coincide con uActualizado.getId()
        // if (!idActualizar.equals(uActualizado.getId())) {
        //     System.err.println("UsuarioDaoImpl.actualizar: El ID a actualizar no coincide con el ID del objeto actualizado.");
        //     return false;
        // }

        Usuario usuarioActualizar = buscarPorId(idActualizar);
        if (usuarioActualizar != null) {
            int indice = usuarios.indexOf(usuarioActualizar);
            if (indice != -1) {
                usuarios.set(indice, uActualizado);
                recrearArchivo();
                gestor.guardar(usuarios);
                return true;
            }
        }
        System.err.println("UsuarioDaoImpl.actualizar: No se encontró usuario con ID " + idActualizar);
        return false;
    }

    /**
     * {@inheritDoc}
     * Busca un usuario en la lista en memoria por su ID.
     */
    @Override
    public Usuario buscarPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        // Considerar llamar a actualizarBD() aquí si la lista en memoria podría no estar fresca
        // y no se llama en cada obtenerTodos() u otra operación de lectura.
        // try { actualizarBD(); } catch (AccesoDatosException e) { e.printStackTrace(); return null; }

        for (Usuario usuario : usuarios) {
            if (usuario.getId() != null && usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>Este método aún no está implementado.</p>
     */
    @Override
    public boolean guardarTodos(List<Usuario> u) {
        // TODO: Implementar la lógica para guardar una lista completa de usuarios.
        System.err.println("El método guardarTodos(List<Usuario>) aún no está implementado.");
        return false;
    }
}

package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.JugadorMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

/**
 * DAO para la entidad {@link Jugador}.
 * Gestiona las operaciones CRUD para los jugadores utilizando un
 * {@link GestorPersistencia} para la persistencia en archivo.
 *
 * @see ICrudDao
 * @see Jugador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class JugadorDaoImpl implements ICrudDao<Jugador> {

    /**
     * Ruta del archivo de persistencia para los jugadores.
     */
    private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_JUGADORES;

    /**
     * Gestor para la lectura y escritura de datos de jugadores.
     */
    private final GestorPersistencia<Jugador, JugadorDto> gestor;

    /**
     * Lista en memoria de los jugadores.
     */
    private List<Jugador> jugadores;

    /**
     * Constructor que inicializa el DAO y carga los datos desde el archivo.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    public JugadorDaoImpl() throws AccesoDatosException {
        this.jugadores = new ArrayList<Jugador>();
        JugadorMapHandler jugadorMapper = new JugadorMapHandler();
        this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, jugadorMapper); // Corregido aquí para usar la instancia local
        actualizarBD();
    }

    /**
     * Actualiza la lista en memoria {@code jugadores} desde el archivo de persistencia.
     *
     * @throws AccesoDatosException Si ocurre un error al cargar los datos.
     */
    private void actualizarBD() throws AccesoDatosException {
        jugadores = gestor.cargar();
        if (this.jugadores == null) {
            this.jugadores = new ArrayList<>();
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
    public List<Jugador> obtenerTodos() throws AccesoDatosException {
        // Actualiza la lista desde el archivo antes de devolverla
        actualizarBD();
        return new ArrayList<>(jugadores); // Devuelve una copia
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean guardar(Jugador u) throws AccesoDatosException {
        // Asumiendo que Jugador tiene un método getId() heredado de Usuario
        if (buscarPorId(u.getId()) == null) {
            jugadores.add(u);
            gestor.guardar(jugadores);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminar(String id) throws AccesoDatosException, IOException {
        Jugador jugadorEliminar = buscarPorId(id);
        if (jugadorEliminar != null) {
            jugadores.remove(jugadorEliminar);
            recrearArchivo();
            gestor.guardar(jugadores);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean actualizar(String idActualizar, Jugador uActualizado) throws AccesoDatosException, IOException {
        Jugador jugadorActualizar = buscarPorId(idActualizar);
        if (jugadorActualizar != null) {
            int indice = jugadores.indexOf(jugadorActualizar);
            if (indice != -1) {
                jugadores.set(indice, uActualizado);
                recrearArchivo();
                gestor.guardar(jugadores);
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * Busca un jugador en la lista en memoria por su ID.
     * Asume que la clase {@link Jugador} hereda un método {@code getId()} de {@link co.edu.unbosque.modelo.entidad.Usuario}.
     */
    @Override
    public Jugador buscarPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Jugador jugador : jugadores) {
            // Asumiendo que Jugador tiene un método getId() (heredado de Usuario)
            if (jugador.getId() != null && jugador.getId().equals(id)) {
                return jugador;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>Este método aún no está implementado.</p>
     */
    @Override
    public boolean guardarTodos(List<Jugador> u) {
        // TODO: Implementar la lógica para guardar una lista completa de jugadores.
        System.err.println("El método guardarTodos(List<Jugador>) aún no está implementado.");
        return false;
    }
}

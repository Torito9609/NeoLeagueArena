package co.edu.unbosque.modelo.persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.Mapper;

/**
 * Gestor genérico de persistencia que:
 * - Recibe una lista de entidades E
 * - Mapea a DTOs D usando un Mapper<E,D>
 * - Guarda la lista de DTOs en un archivo binario
 * - Carga la lista de DTOs y la vuelve a mapear a entidades
 *
 * @param <E> El tipo del objeto de entidad.
 * @param <D> El tipo del objeto de transferencia de datos (DTO).
 *
 * @autor TuNombreCompletoAquí // O el autor original del comentario
 * @version 1.0 // Asumiendo una versión inicial
 */
public class GestorPersistencia<E, D> {

    /**
     * Objeto {@link File} que representa la ubicación del archivo de persistencia.
     * Es final y se inicializa en el constructor.
     */
    private final File ubicacionArchivo;

    /**
     * Instancia del {@link Mapper} utilizado para convertir entre entidades (E) y DTOs (D).
     * Es final y se inicializa en el constructor.
     */
    private final Mapper<E, D> mapper;

    /**
     * Constructor para {@code GestorPersistencia}.
     * <p>
     * Inicializa el gestor con la ruta del archivo de persistencia y el {@link Mapper}
     * correspondiente. También se encarga de crear el archivo y su directorio padre
     * si estos no existen.
     * </p>
     *
     * @param rutaArchivo La ruta del sistema de archivos donde se guardarán/cargarán los datos.
     * @param mapper      El {@link Mapper} para convertir entre entidades y DTOs.
     * @throws AccesoDatosException Si ocurre un error al crear el archivo de persistencia
     * o su directorio padre.
     */
    public GestorPersistencia(String rutaArchivo, Mapper<E, D> mapper)
            throws AccesoDatosException {
        this.ubicacionArchivo = new File(rutaArchivo);
        this.mapper = mapper;

        try {
            File parent = ubicacionArchivo.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!ubicacionArchivo.exists()) {
                ubicacionArchivo.createNewFile();
            }
        } catch (IOException ex) {
            throw new AccesoDatosException(
                "No se pudo inicializar el archivo de persistencia: " + rutaArchivo, ex);
        }
    }

    /**
     * Guarda en disco la lista de entidades E:
     * 1) Mapea cada E a su D con mapper.toDto(...)
     * 2) Serializa la lista de D al archivo
     *
     * @param entidades La lista de entidades {@code E} a guardar.
     * @throws AccesoDatosException Si ocurre un error de entrada/salida durante la escritura
     * en el archivo.
     */
    public void guardar(List<E> entidades) throws AccesoDatosException {
        // El código original crea un ArrayList con un tamaño inicial basado en entidades.size().
        // Si 'entidades' es null, esto lanzaría un NullPointerException.
        // Se asume que 'entidades' no será null o que el mapper maneja entidades null.
        List<D> dtos = new ArrayList<>(entidades.size());
        for (E entidad : entidades) {
            dtos.add(mapper.toDto(entidad));
        }

        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(ubicacionArchivo))) {
            oos.writeObject(dtos);
        } catch (IOException ex) {
            throw new AccesoDatosException(
                "Error al escribir en el archivo: " + ubicacionArchivo.getAbsolutePath(), ex);
        }
    }

    /**
     * Carga desde disco la lista de DTOs, los mapea a entidades E
     * y devuelve la lista de E.
     * <p>
     * Si el archivo está vacío, se devuelve una lista vacía de entidades.
     * </p>
     *
     * @return Una lista de entidades {@code E} cargadas desde el archivo. Nunca es {@code null}.
     * @throws AccesoDatosException Si ocurre un error de entrada/salida durante la lectura
     * del archivo o si la clase de los objetos serializados no se encuentra.
     */
    @SuppressWarnings("unchecked") // Para el cast de List<D>
    public List<E> cargar() throws AccesoDatosException {
        // fichero vacío → lista vacía
        if (ubicacionArchivo.length() == 0) {
            return new ArrayList<>();
        }

        List<D> dtos;
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(ubicacionArchivo))) {
            // Se asume que el objeto leído es una List<D>.
            // No hay verificación explícita del tipo de objeto leído como en la versión anterior del Javadoc.
            dtos = (List<D>) ois.readObject();
        } catch (EOFException e) {
             // Si el archivo existe pero está vacío o se llega al final inesperadamente.
             return new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new AccesoDatosException(
                "Error al leer desde el archivo: " + ubicacionArchivo.getAbsolutePath(), ex);
        }

        List<E> entidades = new ArrayList<>();
        if (dtos != null) { // Es buena práctica verificar si dtos es null después del cast.
            for (D dto : dtos) {
                // Se asume que mapper.toEntity maneja DTOs null si es necesario.
                entidades.add(mapper.toEntity(dto));
            }
        }
        return entidades;
    }

    /**
     * Obtiene el objeto {@link File} que representa la ubicación del archivo de persistencia.
     * @return El archivo de persistencia.
     */
	public File getUbicacionArchivo() {
		return ubicacionArchivo;
	}
}
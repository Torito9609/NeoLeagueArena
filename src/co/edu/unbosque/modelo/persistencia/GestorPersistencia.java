package co.edu.unbosque.modelo.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.Mapper;

/**
 * Gestor genérico de persistencia que:
 *  - Recibe una lista de entidades E
 *  - Mapea a DTOs D usando un Mapper<E,D>
 *  - Guarda la lista de DTOs en un archivo binario
 *  - Carga la lista de DTOs y la vuelve a mapear a entidades
 */
public class GestorPersistencia<E, D> {

    private final File ubicacionArchivo;
    private final Mapper<E, D> mapper;

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
     *   1) Mapea cada E a su D con mapper.toDto(...)
     *   2) Serializa la lista de D al archivo
     */
    public void guardar(List<E> entidades) throws AccesoDatosException {
        List<D> dtos = new ArrayList<>(entidades.size());
        for (E entidad : entidades) {
            dtos.add(mapper.toDto(entidad));
        }

        try (ObjectOutputStream oos = 
                 new ObjectOutputStream(new FileOutputStream(ubicacionArchivo))) {
            oos.writeObject(dtos);
        } catch (IOException ex) {
            throw new AccesoDatosException(
                "Error al escribir en el archivo: " + ubicacionArchivo, ex);
        }
    }

    /**
     * Carga desde disco la lista de DTOs, los mapea a entidades E
     * y devuelve la lista de E.
     */
    @SuppressWarnings("unchecked")
    public List<E> cargar() throws AccesoDatosException {
        if (ubicacionArchivo.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = 
                 new ObjectInputStream(new FileInputStream(ubicacionArchivo))) {
            List<D> dtos = (List<D>) ois.readObject();
            List<E> entidades = new ArrayList<>();
            for (D dto : dtos) {
                entidades.add(mapper.toEntity(dto));
            }
            return entidades;

        } catch (IOException | ClassNotFoundException ex) {
            throw new AccesoDatosException(
                "Error al leer desde el archivo: " + ubicacionArchivo, ex);
        }
    }

	public File getUbicacionArchivo() {
		return ubicacionArchivo;
	}
}

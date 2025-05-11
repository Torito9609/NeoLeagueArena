package co.edu.unbosque.modelo.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.dto.ProductoDTO;
import co.edu.unbosque.model.entity.Producto;
import co.edu.unbosque.model.persistence.MapHandler;
import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class GestorPersistencia<T> {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File ubicacionArchivo;

	public GestorPersistencia(String rutaArchivo) throws AccesoDatosException{
		ubicacionArchivo = new File(rutaArchivo);
		try {
			File parentDir = ubicacionArchivo.getParentFile();
	        if (parentDir != null && !parentDir.exists()) {
	            if (!parentDir.mkdirs()) {
	                throw new AccesoDatosException("No se pudo crear el directorio para el archivo de usuarios.");
	            }
	        }

	        if (!ubicacionArchivo.exists()) {
	            if (!ubicacionArchivo.createNewFile()) {
	                throw new AccesoDatosException("No se pudo crear el archivo de usuarios");
	            }
	        }
		}catch(IOException ex) {
			throw new AccesoDatosException("Error al cargar el archivo de usuarios. ", ex);
		}
	}

	public void guardar(List<Usuario> usuarios) throws AccesoDatosException {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(ubicacionArchivo));
			List<UsuarioDto> datos = MapHandler.todosProductoADTO(productos);
			salida.writeObject(datos);
			salida.close();
		} catch (IOException e) {
			throw new AccesoDatosException("Error al escribir en el archivo de datos.", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> cargarLista(String rutaArchivo) throws IOException, ClassNotFoundException {
		File file = new File(rutaArchivo);
		if (!file.exists())
			return new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			return (List<T>) ois.readObject();
		}
	}
}

package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.List;

import co.edu.unbosque.modelo.dao.EntrenadorDaoImpl;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.utils.Encriptador;

public class EntrenadorService {
	private final EntrenadorDaoImpl entrenadorDao;
	
	public EntrenadorService() throws AccesoDatosException {
		entrenadorDao = new EntrenadorDaoImpl();
	}
	
	public List<Entrenador> obtenerTodos() throws AccesoDatosException{
		return entrenadorDao.obtenerTodos();
	}
	
	public Entrenador buscarPorId(String id) throws AccesoDatosException {
        return entrenadorDao.obtenerTodos().stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
	
	public void crearEntrenador(Entrenador entrenador, String passwordInicial) throws AccesoDatosException {
        entrenador.setPasswordHash(Encriptador.encriptarSHA256(passwordInicial));
        entrenador.setNecesitaCambioPassword(true);
        entrenadorDao.guardar(entrenador);
    }
	
	public void actualizarEntrenador(Entrenador entrenadorActualizado)
            throws AccesoDatosException, IOException {
        entrenadorDao.actualizar(entrenadorActualizado.getId(), entrenadorActualizado);
    }
	
	public void eliminarEntrenador(String id) throws AccesoDatosException, IOException {
        entrenadorDao.eliminar(id);
    }
}

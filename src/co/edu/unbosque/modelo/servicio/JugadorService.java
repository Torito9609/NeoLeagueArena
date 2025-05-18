package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.JugadorDaoImpl;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.RegistroDuplicadoException;
import co.edu.unbosque.modelo.exception.RegistroNoEncontradoException;

public class JugadorService {
	private final JugadorDaoImpl jugadorDao;
	private final UsuarioService usuarioService;
	
	public JugadorService() throws AccesoDatosException {
		jugadorDao = new JugadorDaoImpl();
		usuarioService = new UsuarioService();
	}
	
	public List<Jugador> obtenerTodos() throws AccesoDatosException{
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for(Usuario u : usuarioService.obtenerTodos()) {
			if(u instanceof Jugador) {
				jugadores.add((Jugador)u);
			}
		}
		return jugadores;
	}
	
	public Jugador buscarPorId(String id) throws AccesoDatosException, RegistroNoEncontradoException{
		Usuario u = usuarioService.buscarPorId(id);
		
		if(u == null) {
			throw new RegistroNoEncontradoException("No se encontro el jugador con id " + id);
		}
		if (u instanceof Jugador) {
			return (Jugador) u;
		}
		return null;
	}
	
	public void crearJugador(Jugador jugador, String passwordInicial) throws AccesoDatosException, RegistroDuplicadoException, RegistroNoEncontradoException{
		if (buscarPorId(jugador.getId()) != null) {
	        throw new RegistroDuplicadoException("El ID ingresado ya existe: " + jugador.getId());
	    }

	    if (usuarioService.correoExiste(jugador.getCorreo())) {
	        throw new RegistroDuplicadoException("El correo ya está en uso: " + jugador.getCorreo());
	    }

	    usuarioService.crearUsuario(jugador, passwordInicial);
	    jugadorDao.guardar(jugador);
	}
	
	public void actualizarJugador(Jugador jugadorActualizado) throws AccesoDatosException, IOException{
		usuarioService.actualizarUsuario(jugadorActualizado);
		jugadorDao.actualizar(jugadorActualizado.getId(), jugadorActualizado);
	}
	
	public void eliminarJugador(String id) throws AccesoDatosException, IOException {
		usuarioService.eliminarUsuario(id);
		jugadorDao.eliminar(id);
	}
}

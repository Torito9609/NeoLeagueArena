package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.unbosque.modelo.dao.EntrenadorDaoImpl;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class EntrenadorService {
	private final EntrenadorDaoImpl entrenadorDao;
	private final UsuarioService usuarioService;
	private final AsignacionEntrenadorService asignacionService;
	private final EquipoService equipoService;

	public EntrenadorService() throws AccesoDatosException {
		entrenadorDao = new EntrenadorDaoImpl();
		usuarioService = new UsuarioService();
		asignacionService = new AsignacionEntrenadorService();
		equipoService = new EquipoService();
	}

	public List<Entrenador> obtenerTodos() throws AccesoDatosException {
		List<Entrenador> entrenadores = new ArrayList<Entrenador>();
		for (Usuario u : usuarioService.obtenerTodos()) {
			if (u instanceof Entrenador) {
				entrenadores.add((Entrenador) u);
			}
		}
		return entrenadores;
	}

	public Entrenador buscarPorId(String id) throws AccesoDatosException {
		Usuario u = usuarioService.buscarPorId(id);
		if (u instanceof Entrenador) {
			return (Entrenador) u;
		}
		return null;
	}

	public void crearEntrenador(Entrenador entrenador, String passwordInicial) throws AccesoDatosException {
		usuarioService.crearUsuario(entrenador, passwordInicial);
		entrenadorDao.guardar(entrenador);
	}

	public void actualizarEntrenador(Entrenador entrenadorActualizado) throws AccesoDatosException, IOException {
		usuarioService.actualizarUsuario(entrenadorActualizado);
		entrenadorDao.actualizar(entrenadorActualizado.getId(), entrenadorActualizado);
	}

	public void eliminarEntrenador(String id) throws AccesoDatosException, IOException {
		usuarioService.eliminarUsuario(id);
		entrenadorDao.eliminar(id);
	}

	public void asignarEquipo(String idEntrenador, String idEquipo) throws AccesoDatosException, IOException {
		Entrenador e = buscarPorId(idEntrenador);
		if (e == null) {
			throw new AccesoDatosException("Entrenador no encontrado: " + idEntrenador);
		}
		Equipo equipo = equipoService.buscarPorId(idEquipo);
		if (equipo == null) {
			throw new AccesoDatosException("Equipo no encontrado: " + idEquipo);
		}

		AsignacionEntrenador a = new AsignacionEntrenador(UUID.randomUUID().toString(), e, equipo, LocalDate.now());
		asignacionService.crearAsignacion(a);
	}

	public void removerEquipo(String idEntrenador, String idEquipo) throws AccesoDatosException, IOException {
		List<AsignacionEntrenador> lista = asignacionService.listarPorEntrenador(idEntrenador);

		for (AsignacionEntrenador a : lista) {
			if (a.getEquipo().getId().equals(idEquipo)) {
				asignacionService.eliminarAsignacion(a.getIdAsignacion());
				return;
			}
		}
		throw new AccesoDatosException("El entrenador " + idEntrenador + " no tiene asignado el equipo " + idEquipo);
	}

	public List<Equipo> listarEquiposAsignados(String idEntrenador) throws AccesoDatosException {
		List<Equipo> resultado = new ArrayList<>();
		List<AsignacionEntrenador> lista = asignacionService.listarPorEntrenador(idEntrenador);
		for (AsignacionEntrenador a : lista) {
			resultado.add(a.getEquipo());
		}
		return resultado;
	}
}
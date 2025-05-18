package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.EntrenadorMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class EntrenadorDaoImpl implements ICrudDao<Entrenador> {
	private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_ENTRENADORES;
	private final GestorPersistencia<Entrenador, EntrenadorDto> gestor;
	private List<Entrenador> entrenadores;

	public EntrenadorDaoImpl() throws AccesoDatosException {
		this.entrenadores = new ArrayList<Entrenador>();
		EntrenadorMapHandler entrenadorMapper = new EntrenadorMapHandler();
		this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, entrenadorMapper);
		actualizarBD();

	}

	private void actualizarBD() throws AccesoDatosException {
		entrenadores = gestor.cargar();

	}

	private void recrearArchivo() throws IOException {
		if (gestor.getUbicacionArchivo().exists()) {
			gestor.getUbicacionArchivo().delete();
		}
		gestor.getUbicacionArchivo().createNewFile();

	}

	@Override
	public List<Entrenador> obtenerTodos() throws AccesoDatosException {
		entrenadores = gestor.cargar();
		return entrenadores;
	}

	@Override
	public boolean guardar(Entrenador u) throws AccesoDatosException {
		if (buscarPorId(u.getId()) == null) {
			entrenadores.add(u);
			gestor.guardar(entrenadores);
			return true;
		}
		return false;
	}

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

	@Override
	public boolean actualizar(String idActualizar, Entrenador uActualizado) throws AccesoDatosException, IOException {
		Entrenador entrenadorActualizar = buscarPorId(idActualizar);
		if(entrenadorActualizar != null) {
			int indice = entrenadores.indexOf(entrenadorActualizar);
			if(indice != -1) {
				entrenadores.set(indice, uActualizado);
				recrearArchivo();
				gestor.guardar(entrenadores);
				return true;
			}
		}
		return false;
	}

	@Override
	public Entrenador buscarPorId(String id) {
		for(Entrenador entrenador : entrenadores) {
			if(entrenador.getId().equals(id)) {
				return entrenador;
			}
		}
		return null;
	}

	@Override
	public boolean guardarTodos(List<Entrenador> u) {
		// TODO Auto-generated method stub
		return false;
	}

}

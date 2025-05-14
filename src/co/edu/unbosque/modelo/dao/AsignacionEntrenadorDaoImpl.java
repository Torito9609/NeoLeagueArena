package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.AsignacionEntrenadorDto;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.AsignacionEntrenadorMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class AsignacionEntrenadorDaoImpl implements ICrudDao<AsignacionEntrenador>{
	private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_ASIGNACION_ENTRENADORES;
	private final GestorPersistencia<AsignacionEntrenador, AsignacionEntrenadorDto> gestor;
	private List<AsignacionEntrenador> asignaciones;
	
	

	public AsignacionEntrenadorDaoImpl() throws AccesoDatosException {
		this.asignaciones = new ArrayList<AsignacionEntrenador>();
		AsignacionEntrenadorMapHandler asignacionMapper = new AsignacionEntrenadorMapHandler();
		this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, asignacionMapper);
		actualizarBD();
	}

	private void actualizarBD() throws AccesoDatosException {
		asignaciones = gestor.cargar();
		
	}
	
	private void recrearArchivo() throws IOException {
		if (gestor.getUbicacionArchivo().exists()) {
			gestor.getUbicacionArchivo().delete();
		}
		gestor.getUbicacionArchivo().createNewFile();

	}

	@Override
	public List<AsignacionEntrenador> obtenerTodos() throws AccesoDatosException {
		return gestor.cargar();
	}

	@Override
	public boolean guardar(AsignacionEntrenador u) throws AccesoDatosException {
		if(buscarPorId(u.getIdAsignacion())== null) {
			asignaciones.add(u);
			gestor.guardar(asignaciones);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar(String id) throws AccesoDatosException, IOException {
		AsignacionEntrenador asignacionEliminar = buscarPorId(id);
		if(asignacionEliminar != null) {
			asignaciones.remove(asignacionEliminar);
			recrearArchivo();
			gestor.guardar(asignaciones);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, AsignacionEntrenador uActualizado)
			throws AccesoDatosException, IOException {
		AsignacionEntrenador asignacionActualizar = buscarPorId(idActualizar);
		if(asignacionActualizar != null) {
			int indice = asignaciones.indexOf(asignacionActualizar);
			if(indice != -1) {
				asignaciones.set(indice, uActualizado);
				recrearArchivo();
				gestor.guardar(asignaciones);
				return true;
			}
		}
		return false;
	}

	@Override
	public AsignacionEntrenador buscarPorId(String id) {
		for(AsignacionEntrenador asignacion : asignaciones) {
			if(asignacion.getIdAsignacion().equals(id)) {
				return asignacion;
			}
		}
		return null;
	}

	@Override
	public boolean guardarTodos(List<AsignacionEntrenador> u) {
		// TODO Auto-generated method stub
		return false;
	}

}

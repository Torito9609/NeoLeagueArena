package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.EquipoDto;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.EquipoMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class EquipoDaoImpl implements ICrudDao<Equipo>{
	private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_EQUIPOS;
	private final GestorPersistencia<Equipo, EquipoDto> gestor;
	private List<Equipo> equipos;
	
	public EquipoDaoImpl() throws AccesoDatosException {
		this.equipos = new ArrayList<Equipo>();
		EquipoMapHandler equipoMapper = new EquipoMapHandler();
		this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, equipoMapper);
		actualizarBD();
	}

	private void actualizarBD() throws AccesoDatosException {
		equipos = gestor.cargar();
		
	}
	
	private void recrearArchivo() throws IOException {
		if (gestor.getUbicacionArchivo().exists()) {
			gestor.getUbicacionArchivo().delete();
		}
		gestor.getUbicacionArchivo().createNewFile();
	}

	@Override
	public List obtenerTodos() throws AccesoDatosException {
		equipos = gestor.cargar();
		return equipos;
	}

	@Override
	public boolean guardar(Equipo u) throws AccesoDatosException {
		if(buscarPorId(u.getId()) == null) {
			equipos.add(u);
			gestor.guardar(equipos);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar(String id) throws AccesoDatosException, IOException {
		Equipo equipoEliminar = buscarPorId(id);
		if(equipoEliminar != null) {
			equipos.remove(equipoEliminar);
			recrearArchivo();
			gestor.guardar(equipos);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, Equipo uActualizado) throws AccesoDatosException, IOException {
		Equipo equipoActualizar = buscarPorId(idActualizar);
		if(equipoActualizar != null) {
			int indice = equipos.indexOf(equipoActualizar);
			if(indice != -1) {
				equipos.set(indice, uActualizado);
				recrearArchivo();
				gestor.guardar(equipos);
				return true;
			}
		}
		return false;
	}

	@Override
	public Equipo buscarPorId(String id) {
		for(Equipo e : equipos) {
			if(e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public boolean guardarTodos(List u) {
		// TODO Auto-generated method stub
		return false;
	}

}

package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.ParticipacionTorneoDto;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.ParticipacionTorneoMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;
import co.edu.unbosque.modelo.servicio.EquipoService;
import co.edu.unbosque.modelo.servicio.TorneoService;

public class ParticipacionTorneoDaoImpl implements ICrudDao<ParticipacionTorneo> {
	private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_PARTICIPACIONES_TORNEO;
	private final GestorPersistencia<ParticipacionTorneo, ParticipacionTorneoDto> gestor;
	private List<ParticipacionTorneo> asignaciones;

	public ParticipacionTorneoDaoImpl(ParticipacionTorneoMapHandler mapper) throws AccesoDatosException {
	    this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, mapper);
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
	public List<ParticipacionTorneo> obtenerTodos() throws AccesoDatosException {
		return new ArrayList<>(asignaciones); 
	}

	@Override
	public boolean guardar(ParticipacionTorneo u) throws AccesoDatosException {
		if (u == null || buscarPorId(u.getIdParticipacion()) != null) {
			return false;
		}
		asignaciones.add(u);
		gestor.guardar(asignaciones);
		return true;
	}

	@Override
	public boolean eliminar(String id) throws AccesoDatosException, IOException {
		ParticipacionTorneo encontrada = buscarPorId(id);
		if (encontrada != null) {
			asignaciones.remove(encontrada);
			recrearArchivo();
			gestor.guardar(asignaciones);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, ParticipacionTorneo uActualizado)
			throws AccesoDatosException, IOException {
		for (int i = 0; i < asignaciones.size(); i++) {
			if (asignaciones.get(i).getIdParticipacion().equals(idActualizar)) {
				asignaciones.set(i, uActualizado);
				recrearArchivo();
				gestor.guardar(asignaciones);
				return true;
			}
		}
		return false;
	}


	@Override
	public ParticipacionTorneo buscarPorId(String id) {
		for (ParticipacionTorneo p : asignaciones) {
			if (p.getIdParticipacion().equals(id)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean guardarTodos(List<ParticipacionTorneo> u) {
		try {
			asignaciones = u;
			gestor.guardar(asignaciones);
			return true;
		} catch (AccesoDatosException e) {
			e.printStackTrace();
			return false;
		}
	}
}

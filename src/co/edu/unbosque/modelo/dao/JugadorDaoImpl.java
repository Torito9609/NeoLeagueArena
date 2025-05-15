package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.JugadorMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class JugadorDaoImpl implements ICrudDao<Jugador>{
	private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_JUGADORES;
	private final GestorPersistencia<Jugador, JugadorDto> gestor;
	private List<Jugador> jugadores;
	
	public JugadorDaoImpl() throws AccesoDatosException{
		this.jugadores = new ArrayList<Jugador>();
		JugadorMapHandler jugadorMapper = new JugadorMapHandler();
		this.gestor = new GestorPersistencia(RUTA_ARCHIVO, jugadorMapper);
		actualizarBD();
	}
	

	private void actualizarBD() throws AccesoDatosException {
		jugadores = gestor.cargar();
		
	}
	
	private void recrearArchivo() throws IOException {
		if (gestor.getUbicacionArchivo().exists()) {
			gestor.getUbicacionArchivo().delete();
		}
		gestor.getUbicacionArchivo().createNewFile();

	}


	@Override
	public List<Jugador> obtenerTodos() throws AccesoDatosException {
		jugadores = gestor.cargar();
		return jugadores;
	}

	@Override
	public boolean guardar(Jugador u) throws AccesoDatosException {
		if (buscarPorId(u.getId()) == null) {
			jugadores.add(u);
			gestor.guardar(jugadores);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar(String id) throws AccesoDatosException, IOException {
		Jugador jugadorEliminar = buscarPorId(id);
		if (jugadorEliminar != null) {
			jugadores.remove(jugadorEliminar);
			recrearArchivo();
			gestor.guardar(jugadores);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, Jugador uActualizado) throws AccesoDatosException, IOException {
		Jugador jugadorActualizar = buscarPorId(idActualizar);
		if(jugadorActualizar != null) {
			int indice = jugadores.indexOf(jugadorActualizar);
			if(indice != -1) {
				jugadores.set(indice, uActualizado);
				recrearArchivo();
				gestor.guardar(jugadores);
				return true;
			}
		}
		return false;
	}

	@Override
	public Jugador buscarPorId(String id) {
		for(Jugador jugador : jugadores) {
			if(jugador.getId().equals(id)) {
				return jugador;
			}
		}
		return null;
	}

	@Override
	public boolean guardarTodos(List<Jugador> u) {
		// TODO Auto-generated method stub
		return false;
	}

}

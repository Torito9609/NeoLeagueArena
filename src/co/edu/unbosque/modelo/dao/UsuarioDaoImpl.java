package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.UsuarioMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class UsuarioDaoImpl implements ICrudDao<Usuario> {

	private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_USUARIOS;
	private final GestorPersistencia<Usuario, UsuarioDto> gestor;
	private List<Usuario> usuarios;

	public UsuarioDaoImpl() throws AccesoDatosException {
		this.usuarios = new ArrayList<Usuario>();
		UsuarioMapHandler usuarioMapper = new UsuarioMapHandler();
		this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, usuarioMapper);
		actualizarBD();
	}

	private void actualizarBD() throws AccesoDatosException {
		usuarios = gestor.cargar();

	}

	private void recrearArchivo() throws IOException {
		if (gestor.getUbicacionArchivo().exists()) {
			gestor.getUbicacionArchivo().delete();
		}
		gestor.getUbicacionArchivo().createNewFile();

	}

	@Override
	public List<Usuario> obtenerTodos() throws AccesoDatosException {
		usuarios = gestor.cargar();
		return usuarios.isEmpty() ? List.of() : usuarios;
	}

	@Override
	public boolean guardar(Usuario u) throws AccesoDatosException {
		if (buscarPorId(u.getId()) == null) {
			usuarios.add(u);
			gestor.guardar(usuarios);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar(String id) throws AccesoDatosException, IOException {
		Usuario usuarioEliminar = buscarPorId(id);
		if (usuarioEliminar != null) {
			usuarios.remove(usuarioEliminar);
			recrearArchivo();
			gestor.guardar(usuarios);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, Usuario uActualizado) throws AccesoDatosException, IOException {
		Usuario usuarioActualizar = buscarPorId(idActualizar);
		if (usuarioActualizar != null) {
			int indice = usuarios.indexOf(usuarioActualizar);
			if (indice != -1) {
				usuarios.set(indice, uActualizado);
				recrearArchivo();
				gestor.guardar(usuarios);
				return true;
			}
		}
		return false;
	}

	@Override
	public Usuario buscarPorId(String id) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public boolean guardarTodos(List<Usuario> u) {
		// TODO Auto-generated method stub
		return false;
	}

}

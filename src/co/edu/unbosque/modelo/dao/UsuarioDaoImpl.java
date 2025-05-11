package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class UsuarioDaoImpl implements IUsuarioDao<Usuario>{

    private final String ruta = ConstanteArchivo.ARCHIVO_USUARIOS;
    private final GestorPersistencia<Usuario> gestor; 
    private List<Usuario> usuarios;
    
    public UsuarioDaoImpl() {
    	this.usuarios = new ArrayList<Usuario>();
    	this.gestor = new GestorPersistencia<>();
    	actualizarBD();
    }

    private void actualizarBD() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, Usuario uActualizado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardarTodos(List<Usuario> u) {
		// TODO Auto-generated method stub
		return false;
	}

}

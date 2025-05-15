package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.List;

import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class JuegoDaoImpl implements ICrudDao{

	@Override
	public List obtenerTodos() throws AccesoDatosException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(Object u) throws AccesoDatosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String id) throws AccesoDatosException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(String idActualizar, Object uActualizado) throws AccesoDatosException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardarTodos(List u) {
		// TODO Auto-generated method stub
		return false;
	}

}

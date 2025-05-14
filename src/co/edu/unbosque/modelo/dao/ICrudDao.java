package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.List;

import co.edu.unbosque.modelo.exception.AccesoDatosException;

public interface ICrudDao<T> {
	List<T> obtenerTodos() throws AccesoDatosException;

	boolean guardar(T u) throws AccesoDatosException;

	boolean eliminar(String id) throws AccesoDatosException, IOException;

	boolean actualizar(String idActualizar, T uActualizado) throws AccesoDatosException, IOException;

	T buscarPorId(String id);

	boolean guardarTodos(List<T> u);

}

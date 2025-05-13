package co.edu.unbosque.modelo.dao;

import java.util.List;

public interface IUsuarioDao<T> {
	List<T> obtenerTodos();

	boolean guardar(T u);

	boolean eliminar(String id);

	boolean actualizar(String idActualizar, T uActualizado);

	T buscarPorId(String id);

	boolean guardarTodos(List<T> u);

}

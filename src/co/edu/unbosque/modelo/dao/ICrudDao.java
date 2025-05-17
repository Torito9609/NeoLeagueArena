package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.List;

import co.edu.unbosque.modelo.exception.AccesoDatosException;

/**
 * Interfaz genérica que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la capa de acceso a datos (DAO).
 *
 * @param <T> El tipo de la entidad que este DAO manejará.
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public interface ICrudDao<T> {

    /**
     * Obtiene todas las entidades del tipo {@code T} almacenadas.
     *
     * @return Una lista de todas las entidades {@code T}. Puede ser una lista vacía si no hay entidades.
     * @throws AccesoDatosException Si ocurre un error al acceder a la fuente de datos.
     */
    List<T> obtenerTodos() throws AccesoDatosException;

    /**
     * Guarda una nueva entidad {@code T} en la fuente de datos.
     *
     * @param u La entidad {@code T} a guardar.
     * @return {@code true} si la entidad fue guardada exitosamente, {@code false} en caso contrario
     * (por ejemplo, si la entidad ya existe o si el parámetro es inválido).
     * @throws AccesoDatosException Si ocurre un error al acceder a la fuente de datos.
     */
    boolean guardar(T u) throws AccesoDatosException;

    /**
     * Elimina una entidad {@code T} de la fuente de datos, identificada por su ID.
     *
     * @param id El identificador único de la entidad {@code T} a eliminar.
     * @return {@code true} si la entidad fue eliminada exitosamente, {@code false} si no se encontró
     * o no se pudo eliminar.
     * @throws AccesoDatosException Si ocurre un error al acceder a la fuente de datos.
     * @throws IOException Si ocurre un error de entrada/salida durante la operación (por ejemplo, al interactuar con archivos).
     */
    boolean eliminar(String id) throws AccesoDatosException, IOException;

    /**
     * Actualiza una entidad {@code T} existente en la fuente de datos.
     *
     * @param idActualizar El identificador único de la entidad {@code T} a actualizar.
     * @param uActualizado La entidad {@code T} con los nuevos datos.
     * @return {@code true} si la entidad fue actualizada exitosamente, {@code false} si no se encontró
     * o no se pudo actualizar.
     * @throws AccesoDatosException Si ocurre un error al acceder a la fuente de datos.
     * @throws IOException Si ocurre un error de entrada/salida durante la operación.
     */
    boolean actualizar(String idActualizar, T uActualizado) throws AccesoDatosException, IOException;

    /**
     * Busca y recupera una entidad {@code T} por su identificador único.
     *
     * @param id El identificador único de la entidad {@code T} a buscar.
     * @return La entidad {@code T} encontrada, o {@code null} si no se encuentra ninguna entidad
     * con el ID proporcionado.
     */
    T buscarPorId(String id);

    /**
     * Guarda una lista de entidades {@code T} en la fuente de datos.
     * <p>Nota: La implementación específica puede variar (ej. reemplazar todas las existentes,
     * añadir solo las nuevas, o actualizar las existentes y añadir las nuevas).</p>
     *
     * @param u La lista de entidades {@code T} a guardar.
     * @return {@code true} si todas las entidades fueron guardadas exitosamente,
     * {@code false} si al menos una falló o si la operación no se completó.
     * La semántica exacta puede depender de la implementación.
     */
    boolean guardarTodos(List<T> u);
}
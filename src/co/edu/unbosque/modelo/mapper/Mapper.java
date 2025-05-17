package co.edu.unbosque.modelo.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz genérica que define el contrato para las clases Mapper.
 * <p>
 * Un Mapper es responsable de convertir objetos de un tipo (generalmente una entidad)
 * a otro tipo (generalmente un DTO - Data Transfer Object), y viceversa.
 * Esta interfaz proporciona métodos para la conversión individual de objetos y
 * métodos por defecto para la conversión de listas de objetos.
 * </p>
 *
 * @param <T> El tipo del objeto de entidad.
 * @param <D> El tipo del objeto de transferencia de datos (DTO).
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public interface Mapper<T, D> {

    /**
     * Convierte un objeto de entidad de tipo {@code T} a un objeto de transferencia de datos (DTO) de tipo {@code D}.
     *
     * @param entidad El objeto de entidad a convertir.
     * @return El objeto DTO resultante de la conversión. Puede ser {@code null} si la entidad es {@code null}.
     */
    D toDto(T entidad);

    /**
     * Convierte un objeto de transferencia de datos (DTO) de tipo {@code D} a un objeto de entidad de tipo {@code T}.
     *
     * @param dto El objeto DTO a convertir.
     * @return El objeto de entidad resultante de la conversión. Puede ser {@code null} si el DTO es {@code null}.
     */
    T toEntity(D dto);

    /**
     * Convierte una lista de objetos de entidad de tipo {@code T} a una lista de objetos DTO de tipo {@code D}.
     * <p>
     * Este es un método por defecto que itera sobre la lista de entidades y aplica el método
     * {@link #toDto(Object)} a cada una. Si la lista de entidades es {@code null} o está vacía,
     * se devuelve una lista de DTOs vacía.
     * </p>
     *
     * @param entidades La lista de objetos de entidad a convertir.
     * @return Una lista de objetos DTO. Nunca es {@code null}, puede ser una lista vacía.
     */
    default List<D> toDto(List<T> entidades) {
        List<D> dtos = new ArrayList<D>();
        if (entidades != null) {
            for (T entidad : entidades) {
                // Se asume que toDto(T entidad) maneja entidades null si es necesario,
                // o que la lista 'entidades' no contiene elementos null que causarían problemas.
                dtos.add(toDto(entidad));
            }
        }
        return dtos;
    }

    /**
     * Convierte una lista de objetos DTO de tipo {@code D} a una lista de objetos de entidad de tipo {@code T}.
     * <p>
     * Este es un método por defecto que itera sobre la lista de DTOs y aplica el método
     * {@link #toEntity(Object)} a cada uno. Si la lista de DTOs es {@code null} o está vacía,
     * se devuelve una lista de entidades vacía.
     * </p>
     *
     * @param dtos La lista de objetos DTO a convertir.
     * @return Una lista de objetos de entidad. Nunca es {@code null}, puede ser una lista vacía.
     */
    default List<T> toEntity(List<D> dtos) {
        List<T> entidades = new ArrayList<T>();
        if (dtos != null) {
            for (D dto : dtos) {
                // Se asume que toEntity(D dto) maneja DTOs null si es necesario,
                // o que la lista 'dtos' no contiene elementos null que causarían problemas.
                entidades.add(toEntity(dto));
            }
        }
        return entidades;
    }
}
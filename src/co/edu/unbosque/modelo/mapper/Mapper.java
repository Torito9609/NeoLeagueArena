package co.edu.unbosque.modelo.mapper;

import java.util.ArrayList;
import java.util.List;

public interface Mapper<T, D> {

	D toDto(T entidad);

	T toEntity(D dto);

	default List<D> toDto(List<T> entidades) {
		List<D> dtos = new ArrayList<D>();
		if (entidades != null) {
			for (T entidad : entidades) {
				dtos.add(toDto(entidad));
			}
		}
		return dtos;
	}

	default List<T> toEntity(List<D> dtos) {
		List<T> entidades = new ArrayList<T>();
		if (dtos != null) {
			for (D dto : dtos) {
				entidades.add(toEntity(dto));
			}
		}
		return entidades;
	}
}

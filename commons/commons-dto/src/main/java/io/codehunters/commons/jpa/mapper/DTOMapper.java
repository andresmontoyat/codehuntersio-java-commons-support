package io.codehunters.commons.jpa.mapper;

import java.util.List;

public interface DTOMapper<D, E> {

    D toDTO(E entity);

    List<D> toDTOS(List<E> entities);

    E toEntity(D dto);

}

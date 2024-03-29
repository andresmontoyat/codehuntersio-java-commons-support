package io.codehunters.commons.dto.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface DTOMapper<D, E> {

    D toDTO(E entity);

    List<D> toDTOS(List<E> entities);

    E toEntity(D dto);

    void toEntity(D dto, @MappingTarget E entity);
}

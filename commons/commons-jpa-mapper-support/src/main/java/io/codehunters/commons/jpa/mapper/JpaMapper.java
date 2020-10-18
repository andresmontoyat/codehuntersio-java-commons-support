package io.codehunters.commons.jpa.mapper;

import io.codehunters.commons.dto.DTO;
import io.codehunters.commons.repository.domain.JpaEntities;
import org.mapstruct.MapperConfig;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@MapperConfig(componentModel = "spring")
public interface JpaMapper<D extends DTO, E extends JpaEntities> extends PageDTOMapper<D, E>{

    @ObjectFactory
    default E reference(D dto, @TargetType Class<E> entityClass,  @Autowired EntityManager em) {
        try {
            return (dto.getId() != null) ? em.getReference(entityClass, dto.getId()) : entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new JpaMapperException("An error has occurred trying to get new reference of entity", e);
        }
    }
}

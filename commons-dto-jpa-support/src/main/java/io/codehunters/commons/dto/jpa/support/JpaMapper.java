package io.codehunters.commons.dto.jpa.support;

import io.codehunters.commons.dto.support.DTO;
import io.codehunters.commons.repository.domain.support.Entities;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.MapperConfig;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@MapperConfig(componentModel = "spring")
public abstract class JpaMapper<D extends DTO, E extends Entities> {

    @PersistenceContext
    protected EntityManager em;

    @ObjectFactory
    public E reference(D dto, @TargetType Class<E> entityClass) {
        try {
            return (dto.getId() != null) ? em.getReference(entityClass, dto.getId()) : entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new JpaMapperException("An error has occurred trying to get new reference of entity", e);
        }
    }

}

package io.codehunters.commons.jpa.mapper;

import io.codehunters.commons.dto.DTO;
import io.codehunters.commons.repository.domain.JpaEntities;
import org.mapstruct.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class JpaMapper {

    @PersistenceContext
    protected EntityManager em;

    @ObjectFactory
    public <E extends JpaEntities> E reference(DTO dto, @TargetType Class<E> entityClass) {
        try {
            return (dto.getId() != null) ? em.getReference(entityClass, dto.getId()) : entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new JpaMapperException("An error has occurred trying to get new reference of entity", e);
        }
    }
}

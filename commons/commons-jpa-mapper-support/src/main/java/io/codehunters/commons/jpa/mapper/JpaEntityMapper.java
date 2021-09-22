package io.codehunters.commons.jpa.mapper;

import io.codehunters.commons.dto.DTO;
import io.codehunters.commons.jpa.repository.domain.JpaEntity;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ObjectFactory;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.TargetType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Getter
@Setter
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class JpaEntityMapper {

    @PersistenceContext
    protected EntityManager em;

    @ObjectFactory
    public <E extends JpaEntity> E reference(DTO<? extends Serializable> dto, @TargetType Class<E> entityClass) {
        try {
            return (dto.getId() != null) ? em.getReference(entityClass, dto.getId()) : entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new JpaEntityMapperException("An error has occurred trying to get new reference of entity", e);
        }
    }
}

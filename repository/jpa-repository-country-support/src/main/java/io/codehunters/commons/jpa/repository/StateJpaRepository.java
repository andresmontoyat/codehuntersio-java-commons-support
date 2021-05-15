package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.StateJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StateJpaRepository extends JpaRepository<StateJpaEntity, Long>, JpaSpecificationExecutor<StateJpaEntity> {

}
package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.NeighborhoodJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighborhoodJpaRepository extends JpaRepository<NeighborhoodJpaEntity, Long>, JpaSpecificationExecutor<NeighborhoodJpaEntity> {

}
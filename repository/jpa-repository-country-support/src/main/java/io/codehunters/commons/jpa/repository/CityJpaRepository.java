package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.CityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CityJpaRepository extends JpaRepository<CityJpaEntity, Long>, JpaSpecificationExecutor<CityJpaEntity> {

}
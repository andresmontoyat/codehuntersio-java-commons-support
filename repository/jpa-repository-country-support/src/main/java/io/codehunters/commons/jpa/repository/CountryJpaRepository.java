package io.codehunters.commons.jpa.repository;

import io.codehunters.commons.jpa.repository.domain.CountryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryJpaRepository extends JpaRepository<CountryJpaEntity, Long>, JpaSpecificationExecutor<CountryJpaEntity> {
}
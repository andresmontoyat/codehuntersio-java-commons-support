package io.codehunters.commons.jpa.repository.cors;

import io.codehunters.commons.jpa.repository.cors.domain.CorsJpaEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsJpaRepository extends JpaRepository<CorsJpaEntities, Long>, JpaSpecificationExecutor<CorsJpaEntities> {

}

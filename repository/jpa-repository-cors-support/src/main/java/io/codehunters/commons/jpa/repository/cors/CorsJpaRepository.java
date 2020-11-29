package io.codehunters.commons.jpa.repository.cors;

import io.codehunters.commons.jpa.repository.cors.domain.CorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorsJpaRepository extends JpaRepository<CorsEntity, Long> {

    @Query("SELECT c FROM CorsEntity c WHERE c.clientId = :clientId")
    Optional<CorsEntity> findByClientIdEquals(@Param("clientId") String clientId);

    @Query("SELECT c FROM CorsEntity c WHERE c.parameter1 = :parameter1")
    Optional<List<CorsEntity>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT c FROM CorsEntity c WHERE c.parameter1 = :parameter1 AND c.parameter2 = :parameter2")
    Optional<List<CorsEntity>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT c FROM CorsEntity c WHERE c.parameter1 = :parameter1 AND c.parameter2 = :parameter2 AND c.parameter3 = :parameter3")
    Optional<List<CorsEntity>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
}

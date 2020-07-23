package io.codehunters.commons.repository.cors.support;

import io.codehunters.commons.repository.cors.support.domain.CORS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CORSRepositiry extends PagingAndSortingRepository<CORS, Long> {

    @Query("SELECT c FROM CORS c WHERE c.enabled = :enabled")
    Optional<List<CORS>> findAllByEnabledEquals(@Param("enabled") Boolean enabled);

    @Query("SELECT c FROM CORS c WHERE c.clientId = :clientId")
    Optional<List<CORS>> findAllByClientIdEquals(@Param("clientId") String clientId);

    @Query("SELECT c FROM CORS c WHERE c.parameter1 = :parameter1")
    Optional<List<CORS>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT c FROM CORS c WHERE c.parameter1 = :parameter1 AND c.parameter2 = :parameter2")
    Optional<List<CORS>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT c FROM CORS c WHERE c.parameter1 = :parameter1 AND c.parameter2 = :parameter2 AND c.parameter3 = :parameter3")
    Optional<List<CORS>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
}

package io.codehunters.commons.repository.cors.support;

import io.codehunters.commons.repository.cors.support.domain.Cors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CORSRepositiry extends PagingAndSortingRepository<Cors, Long> {

    @Query("SELECT c FROM Cors c WHERE c.clientId = :clientId")
    Optional<List<Cors>> findAllByClientIdEquals(@Param("clientId") Long clientId);

    @Query("SELECT c FROM Cors c WHERE c.enabled = :enabled")
    Optional<List<Cors>> findAllByEnabledEquals(@Param("enabled") Boolean enabled);

    @Query("SELECT c FROM Cors c WHERE c.clientId = :clientId AND c.enabled = :enabled")
    Optional<List<Cors>> findAllByClientIdEqualsAndEnabledEquals(@Param("clientId") Long clientId, @Param("enabled") Boolean enabled);
}

package io.codehunters.commons.repository.audit.support;

import io.codehunters.commons.repository.audit.support.domain.Audit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuditRepository extends PagingAndSortingRepository<Audit, Long> {

    @Query("SELECT a FROM Audit a WHERE a.username = :username")
    Optional<List<Audit>> findAllByUsernameEquals(@Param("username") String username);

    @Query("SELECT a FROM Audit a WHERE a.eventType = :eventType AND a.createdBy BETWEEN :startDate AND :endDate")
    Optional<List<Audit>> findAllByEventTypeEqualsAndCreatedByBetween(@Param("eventType") String eventType, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT a FROM Audit a WHERE a.eventType = :eventType AND a.username = :username AND a.createdBy BETWEEN :startDate AND :endDate")
    Optional<List<Audit>> findAllByEventTypeEqualsAndUsernameEqualsAndCreatedByBetween(@Param("eventType") String eventType, @Param("username") String username, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT a FROM Audit a WHERE a.eventType = :eventType AND a.username = :username AND a.createdBy BETWEEN :startDate AND :endDate AND UPPER(a.message) LIKE UPPER(:message)")
    Optional<List<Audit>> findAllByEventTypeEqualsAndUsernameEqualsAndCreatedByBetweenAndMessageLike(@Param("eventType") String eventType, @Param("username") String username, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("message") String message);
}

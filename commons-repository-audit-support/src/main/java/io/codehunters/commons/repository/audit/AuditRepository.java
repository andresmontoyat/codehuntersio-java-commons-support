package io.codehunters.commons.repository.audit;

import io.codehunters.commons.repository.audit.domain.Audit;
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

    @Query("SELECT a FROM Audit a WHERE a.type = :eventType")
    Optional<List<Audit>> findAllByTypeEquals(@Param("type") String type);

    @Query("SELECT a FROM Audit a WHERE a.type = :type AND a.createdBy BETWEEN :startDate AND :endDate")
    Optional<List<Audit>> findAllByTypeEqualsAndCreatedByBetween(@Param("type") String type, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT a FROM Audit a WHERE a.type = :type AND a.username = :username AND a.createdBy BETWEEN :startDate AND :endDate")
    Optional<List<Audit>> findAllByTypeEqualsAndUsernameEqualsAndCreatedByBetween(@Param("type") String type, @Param("username") String username, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT a FROM Audit a WHERE a.type = :type AND a.username = :username AND a.createdBy BETWEEN :startDate AND :endDate AND UPPER(a.message) LIKE UPPER(:message)")
    Optional<List<Audit>> findAllByTypeEqualsAndUsernameEqualsAndCreatedByBetweenAndMessageLike(@Param("type") String type, @Param("username") String username, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("message") String message);

    @Query("SELECT a FROM Audit a WHERE a.parameter1 = :parameter1")
    Optional<List<Audit>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT a FROM Audit a WHERE a.parameter1 = :parameter1 AND a.parameter2 = :parameter2")
    Optional<List<Audit>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT a FROM Audit a WHERE a.parameter1 = :parameter1 AND a.parameter2 = :parameter2 AND a.parameter3 = :parameter3")
    Optional<List<Audit>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
}

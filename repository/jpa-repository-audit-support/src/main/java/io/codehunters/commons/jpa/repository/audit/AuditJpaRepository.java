package io.codehunters.commons.jpa.repository.audit;

import io.codehunters.commons.jpa.repository.audit.domain.AuditEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuditJpaRepository extends JpaRepository<AuditEntities, Long> {

    @Query("SELECT a FROM AuditEntities a WHERE a.username = :username")
    Optional<List<AuditEntities>> findAllByUsernameEquals(@Param("username") String username);

    @Query("SELECT a FROM AuditEntities a WHERE a.type = :eventType")
    Optional<List<AuditEntities>> findAllByTypeEquals(@Param("type") String type);

    @Query("SELECT a FROM AuditEntities a WHERE a.type = :type AND a.createdBy BETWEEN :startDate AND :endDate")
    Optional<List<AuditEntities>> findAllByTypeEqualsAndCreatedByBetween(@Param("type") String type, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT a FROM AuditEntities a WHERE a.type = :type AND a.username = :username AND a.createdBy BETWEEN :startDate AND :endDate")
    Optional<List<AuditEntities>> findAllByTypeEqualsAndUsernameEqualsAndCreatedByBetween(@Param("type") String type, @Param("username") String username, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT a FROM AuditEntities a WHERE a.type = :type AND a.username = :username AND a.createdBy BETWEEN :startDate AND :endDate AND UPPER(a.message) LIKE UPPER(:message)")
    Optional<List<AuditEntities>> findAllByTypeEqualsAndUsernameEqualsAndCreatedByBetweenAndMessageLike(@Param("type") String type, @Param("username") String username, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("message") String message);

    @Query("SELECT a FROM AuditEntities a WHERE a.parameter1 = :parameter1")
    Optional<List<AuditEntities>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT a FROM AuditEntities a WHERE a.parameter1 = :parameter1 AND a.parameter2 = :parameter2")
    Optional<List<AuditEntities>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT a FROM AuditEntities a WHERE a.parameter1 = :parameter1 AND a.parameter2 = :parameter2 AND a.parameter3 = :parameter3")
    Optional<List<AuditEntities>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
}

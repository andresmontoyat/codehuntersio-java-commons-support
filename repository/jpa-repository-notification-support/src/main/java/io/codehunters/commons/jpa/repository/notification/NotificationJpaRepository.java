package io.codehunters.commons.jpa.repository.notification;

import io.codehunters.commons.jpa.repository.notification.domain.NotificationEntities;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationJpaRepository extends PagingAndSortingRepository<NotificationEntities, Long> {

    @Query("SELECT n FROM NotificationEntities n WHERE n.parameter1 = :parameter1")
    Optional<List<NotificationEntities>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT n FROM NotificationEntities n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2")
    Optional<List<NotificationEntities>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT n FROM NotificationEntities n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2 AND n.parameter3 = :parameter3")
    Optional<List<NotificationEntities>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
}

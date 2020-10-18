package io.codehunters.commons.repository.notification;

import io.codehunters.commons.repository.notification.domain.NotificationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationJpaRepository extends PagingAndSortingRepository<NotificationEntity, Long> {

    @Query("SELECT n FROM NotificationEntity n WHERE n.parameter1 = :parameter1")
    Optional<List<NotificationEntity>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT n FROM NotificationEntity n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2")
    Optional<List<NotificationEntity>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT n FROM NotificationEntity n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2 AND n.parameter3 = :parameter3")
    Optional<List<NotificationEntity>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);
}

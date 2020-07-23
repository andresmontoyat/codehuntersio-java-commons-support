package io.codehunters.commons.repository.notification.support;

import io.codehunters.commons.repository.notification.support.domain.Notification;
import io.codehunters.commons.repository.notification.support.domain.enums.NotificationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends PagingAndSortingRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.type = :type")
    Optional<List<Notification>> findAllByTypeEquals(@Param("type") NotificationType type);

    @Query("SELECT n FROM Notification n WHERE n.parameter1 = :parameter1")
    Optional<List<Notification>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT n FROM Notification n WHERE n.parameter1 = :parameter1 AND n.type = :type")
    Optional<List<Notification>> findAllByParameter1EqualsAndTypeEquals(@Param("parameter1") String parameter1, @Param("type") NotificationType type);

    @Query("SELECT n FROM Notification n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2")
    Optional<List<Notification>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT n FROM Notification n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2 AND n.type = :type")
    Optional<List<Notification>> findAllByParameter1EqualsAndParameter2EqualsAndTypeEquals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("type") NotificationType type);

    @Query("SELECT n FROM Notification n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2 AND n.parameter3 = :parameter3")
    Optional<List<Notification>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

    @Query("SELECT n FROM Notification n WHERE n.parameter1 = :parameter1 AND n.parameter2 = :parameter2 AND n.parameter3 = :parameter3 AND n.type = :type")
    Optional<List<Notification>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3EqualsAndTypeEquals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3, @Param("type") NotificationType type);
}

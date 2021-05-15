package io.codehunters.commons.jpa.repository.notification;

import io.codehunters.commons.jpa.repository.notification.domain.NotificationJpaEntities;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationJpaRepository extends PagingAndSortingRepository<NotificationJpaEntities, Long>, JpaSpecificationExecutor<NotificationJpaEntities> {

}

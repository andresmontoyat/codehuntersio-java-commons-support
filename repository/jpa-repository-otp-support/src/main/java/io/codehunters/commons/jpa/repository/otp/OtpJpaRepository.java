package io.codehunters.commons.jpa.repository.otp;

import io.codehunters.commons.jpa.repository.otp.domain.OtpJpaEntities;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpJpaRepository extends PagingAndSortingRepository<OtpJpaEntities, Long>, JpaSpecificationExecutor<OtpJpaEntities> {

}

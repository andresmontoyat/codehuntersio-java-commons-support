package io.codehunters.commons.repository.otp.support;

import io.codehunters.commons.enums.otp.support.OtpStatus;
import io.codehunters.commons.repository.otp.support.domain.Otp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OtpRepository extends PagingAndSortingRepository<Otp, Long> {

    @Query("SELECT o FROM Otp o WHERE o.username = :username")
    Optional<List<Otp>> findAllByUsernameEquals(@Param("username") String username);

    @Query("SELECT o FROM Otp o WHERE o.username = :username AND o.otp = :otp")
    Optional<Otp> findByUsernameEqualsAndOtpEquals(@Param("username") String username, @Param("otp") String otp);

    @Query("SELECT o FROM Otp o WHERE o.username = :username AND o.otpStatus IN (:statuses)")
    Optional<Otp> findByUsernameEqualsAndOtpEquals(@Param("username") String username, @Param("statuses") List<OtpStatus> statuses);

}

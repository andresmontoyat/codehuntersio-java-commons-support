package io.codehunters.commons.repository.otp;

import io.codehunters.commons.repository.otp.domain.OTP;
import io.codehunters.commons.repository.otp.domain.enums.OTPStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OTPRepository extends PagingAndSortingRepository<OTP, Long> {

    @Query("SELECT o FROM Otp o WHERE o.username = :username")
    Optional<List<OTP>> findAllByUsernameEquals(@Param("username") String username);

    @Query("SELECT o FROM Otp o WHERE o.username = :username AND o.otp = :otp")
    Optional<OTP> findByUsernameEqualsAndOtpEquals(@Param("username") String username, @Param("otp") String otp);

    @Query("SELECT o FROM Otp o WHERE o.username = :username AND o.status = :status")
    Optional<List<OTP>> findByUsernameEqualsAndStatusEquals(@Param("username") String username, @Param("status") OTPStatus OTPStatus);

    @Query("SELECT o FROM Otp o WHERE o.parameter1 = :parameter1")
    Optional<List<OTP>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT o FROM Otp o WHERE o.parameter1 = :parameter1 AND o.parameter2 = :parameter2")
    Optional<List<OTP>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT o FROM Otp o WHERE o.parameter1 = :parameter1 AND o.parameter2 = :parameter2 AND o.parameter3 = :parameter3")
    Optional<List<OTP>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

}

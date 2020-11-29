package io.codehunters.commons.jpa.repository.otp;

import io.codehunters.commons.jpa.repository.otp.domain.OtpEntity;
import io.codehunters.commons.jpa.repository.otp.domain.enums.OtpStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OtpJpaRepository extends PagingAndSortingRepository<OtpEntity, Long> {

    @Query("SELECT o FROM Otp o WHERE o.username = :username")
    Optional<List<OtpEntity>> findAllByUsernameEquals(@Param("username") String username);

    @Query("SELECT o FROM Otp o WHERE o.username = :username AND o.otp = :otp")
    Optional<OtpEntity> findByUsernameEqualsAndOtpEquals(@Param("username") String username, @Param("otp") String otp);

    @Query("SELECT o FROM Otp o WHERE o.username = :username AND o.status = :status")
    Optional<List<OtpEntity>> findByUsernameEqualsAndStatusEquals(@Param("username") String username, @Param("status") OtpStatus OTPStatus);

    @Query("SELECT o FROM Otp o WHERE o.parameter1 = :parameter1")
    Optional<List<OtpEntity>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT o FROM Otp o WHERE o.parameter1 = :parameter1 AND o.parameter2 = :parameter2")
    Optional<List<OtpEntity>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT o FROM Otp o WHERE o.parameter1 = :parameter1 AND o.parameter2 = :parameter2 AND o.parameter3 = :parameter3")
    Optional<List<OtpEntity>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

}

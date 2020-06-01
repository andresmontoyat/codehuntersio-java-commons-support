package io.codehunters.commons.repository.devicemetadata.support;

import io.codehunters.commons.repository.devicemetadata.support.domain.DeviceMetadata;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceMetadataRepository extends PagingAndSortingRepository<DeviceMetadata, Long> {

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username AND d.serialId = :serialId")
    Optional<DeviceMetadata> findByUsernameEqualsAndSerialIdEquals(@Param("username") String username, @Param("serialId") String serialId);

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username")
    Optional<List<DeviceMetadata>> findAllByUsernameEquals(@Param("username") String username);

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username AND d.ip = :ip")
    Optional<List<DeviceMetadata>> findAllByUsernameEqualsAndIpEquals(@Param("username") String username, @Param("ip") String ip);

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username AND d.ip = :ip AND UPPER(d.location) = UPPER(:location)")
    Optional<List<DeviceMetadata>> findAllByUsernameEqualsAndIpEqualsAndLocation(@Param("username") Long userId, @Param("ip") String ip, @Param("location") String location);

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username AND d.ip = :ip AND UPPER(d.location) = UPPER(:location) AND d.userAgent = :userAgent")
    Optional<List<DeviceMetadata>> findAllByUsernameEqualsAndIpEqualsAndLocationAndUserAgentEquals(@Param("username") String username, @Param("ip") String ip, @Param("location") String location, @Param("userAgent") String userAgent);

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username AND UPPER(d.location) = UPPER(:location)")
    Optional<List<DeviceMetadata>> findAllByUsernameEqualsAndLocation(@Param("username") String username, @Param("location") String location);

    @Query("SELECT d FROM DeviceMetadata d WHERE d.username = :username AND UPPER(d.location) = UPPER(:location) AND d.userAgent = :userAgent")
    Optional<List<DeviceMetadata>> findAllByUsernameEqualsAndLocationAndUserAgentEquals(@Param("username") String username, @Param("location") String location, @Param("userAgent") String userAgent);
}

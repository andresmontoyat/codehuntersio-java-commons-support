package io.codehunters.commons.jpa.repository.devicemetadata;

import io.codehunters.commons.jpa.repository.devicemetadata.domain.DeviceMetadataJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMetadataJpaRepository extends JpaRepository<DeviceMetadataJpaEntity, Long>, JpaSpecificationExecutor<DeviceMetadataJpaEntity> {

}

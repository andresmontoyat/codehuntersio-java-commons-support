package io.codehunters.commons.jpa.repository.audit;

import io.codehunters.commons.jpa.repository.audit.domain.AuditJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditJpaRepository extends JpaRepository<AuditJpaEntity, Long>, JpaSpecificationExecutor<AuditJpaEntity> {

}

package io.codehunters.commons.jpa.repository.menuui;

import io.codehunters.commons.jpa.repository.menuui.domain.MenuUIJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuUIJpaRepository extends JpaRepository<MenuUIJpaEntity, Long>, JpaSpecificationExecutor<MenuUIJpaEntity> {

}

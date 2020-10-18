package io.codehunters.commons.repository.menuui;

import io.codehunters.commons.repository.menuui.domain.MenuUIEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuUIJpaRepository extends JpaRepository<MenuUIEntity, Long> {

    @Query("SELECT m FROM MenuUIEntity m WHERE m.parameter1 = :parameter1")
    Optional<List<MenuUIEntity>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT m FROM MenuUIEntity m WHERE m.parameter1 = :parameter1 AND m.parameter2 = :parameter2")
    Optional<List<MenuUIEntity>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT m FROM MenuUIEntity m WHERE m.parameter1 = :parameter1 AND m.parameter2 = :parameter2 AND m.parameter3 = :parameter3")
    Optional<List<MenuUIEntity>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

}

package io.codehunters.commons.repository.menuui;

import io.codehunters.commons.repository.menuui.domain.MenuUI;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuUIRepository extends PagingAndSortingRepository<MenuUI, Long> {

    @Query("SELECT m FROM MenuUI m WHERE m.enabled = :enabled")
    Optional<List<MenuUI>> findAllByEnabledEquals(@Param("enabled") Boolean enabled);

    @Query("SELECT m FROM MenuUI m WHERE m.parameter1 = :parameter1")
    Optional<List<MenuUI>> findAllByParameter1Equals(@Param("parameter1") String parameter1);

    @Query("SELECT m FROM MenuUI m WHERE m.parameter1 = :parameter1 AND m.parameter2 = :parameter2")
    Optional<List<MenuUI>> findAllByParameter1EqualsAndParameter2Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2);

    @Query("SELECT m FROM MenuUI m WHERE m.parameter1 = :parameter1 AND m.parameter2 = :parameter2 AND m.parameter3 = :parameter3")
    Optional<List<MenuUI>> findAllByParameter1EqualsAndParameter2EqualsAndParameter3Equals(@Param("parameter1") String parameter1, @Param("parameter2") String parameter2, @Param("parameter3") String parameter3);

}

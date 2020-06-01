package io.codehunters.commons.repository.menuui;

import io.codehunters.commons.repository.menuui.domain.MenuUI;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuUIRepository extends PagingAndSortingRepository<MenuUI, Long> {
}

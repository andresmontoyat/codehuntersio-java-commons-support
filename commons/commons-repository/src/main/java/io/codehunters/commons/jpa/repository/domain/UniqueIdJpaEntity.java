package io.codehunters.commons.jpa.repository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class UniqueIdJpaEntity<I extends Serializable> extends JpaEntities<I> {

    @Column(name = "unique_Id", nullable = false, unique = true, length = 80)
    private String uniqueId;
}

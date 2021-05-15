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
public abstract class ParamsJpaEntity<I extends Serializable> extends JpaEntities<I> {

    @Column(name = "parameter_1", length = 200)
    private String parameter1;

    @Column(name = "parameter_2", length = 200)
    private String parameter2;

    @Column(name = "parameter_3", length = 200)
    private String parameter3;
}

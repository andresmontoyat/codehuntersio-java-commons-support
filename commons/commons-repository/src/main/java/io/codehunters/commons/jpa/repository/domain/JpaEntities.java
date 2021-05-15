package io.codehunters.commons.jpa.repository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class JpaEntities<I extends Serializable> extends AuditableJpaEntity implements Persistable<I> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected I id;

    @Override
    public I getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return (id == null);
    }
}
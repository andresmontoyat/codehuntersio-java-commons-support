package io.codehunters.commons.jpa.repository.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class JpaEntities<ID extends Serializable> extends AuditableJpaEntity implements Persistable<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return Optional.ofNullable(this.id).isPresent();
    }
}
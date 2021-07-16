package io.codehunters.commons.jpa.repository.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@MappedSuperclass
public abstract class JpaEntity<I extends Number> extends AuditableJpaEntity implements Persistable<I> {

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
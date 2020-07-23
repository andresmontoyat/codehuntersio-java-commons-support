package io.codehunters.commons.repository.domain.support;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class JpaEntities<ID extends Serializable> extends JpaAuditable implements Persistable<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected ID id;

    @Column(name = "enabled", nullable = false)
    protected Boolean enabled;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
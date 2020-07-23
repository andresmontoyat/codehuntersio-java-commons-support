package io.codehunters.commons.repository.domain.support.embeddables;

import io.codehunters.commons.util.Util;
import lombok.Data;

@Data
public abstract class JpaEmbeddables<T> {

    protected T id;

    protected Boolean enabled;

    @SuppressWarnings("unchecked")
    public JpaEmbeddables() throws NoSuchFieldException {
        if (Util.isNull(id)) {
            if (this.getClass().getField("id").getType().isAssignableFrom(String.class))
                this.id = (T) Util.uuid();
            else if (this.getClass().getField("id").getType().isAssignableFrom(Long.class))
                this.id = (T) Long.valueOf(System.currentTimeMillis());
        }
    }

    public abstract <T extends JpaEmbeddables> T withId(String id);

    public boolean isNew() {
        return (this.id == null);
    }

    public boolean isEnabled() {
        return enabled;
    }
}

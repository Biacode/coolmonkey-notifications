package com.sfl.coolmonkey.notifications.queue.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 17:25
 */
public class AbstractUuidAwareQueueModel extends AbstractQueueModel {
    private static final long serialVersionUID = -1731479723356862049L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;
    //endregion

    //region Constructors
    public AbstractUuidAwareQueueModel() {
    }

    public AbstractUuidAwareQueueModel(final String uuid) {
        this.uuid = uuid;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractUuidAwareQueueModel)) {
            return false;
        }
        final AbstractUuidAwareQueueModel that = (AbstractUuidAwareQueueModel) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(uuid)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }
    //endregion
}

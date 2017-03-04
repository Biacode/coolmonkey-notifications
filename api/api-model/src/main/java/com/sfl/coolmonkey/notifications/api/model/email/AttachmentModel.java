package com.sfl.coolmonkey.notifications.api.model.email;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 3/24/16
 * Time: 2:52 PM
 */
public class AttachmentModel implements Serializable {
    private static final long serialVersionUID = 4379503558932765673L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("name")
    private String name;
    //endregion

    //region Constructors
    public AttachmentModel() {
    }

    public AttachmentModel(final String uuid, final String name) {
        this.uuid = uuid;
        this.name = name;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AttachmentModel)) {
            return false;
        }
        final AttachmentModel that = (AttachmentModel) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(uuid)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .append("name", name)
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    //endregion
}

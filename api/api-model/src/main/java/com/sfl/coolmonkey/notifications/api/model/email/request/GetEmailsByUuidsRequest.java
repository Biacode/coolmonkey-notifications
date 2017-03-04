package com.sfl.coolmonkey.notifications.api.model.email.request;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/5/16
 * Time: 3:46 PM
 */
public class GetEmailsByUuidsRequest extends AbstractRequestModel {
    private static final long serialVersionUID = 909384240983035617L;

    //region Properties
    private List<String> uuids;
    //endregion

    //region Constructors
    public GetEmailsByUuidsRequest() {
    }

    public GetEmailsByUuidsRequest(final List<String> uuids) {
        this.uuids = uuids;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetEmailsByUuidsRequest)) {
            return false;
        }
        final GetEmailsByUuidsRequest that = (GetEmailsByUuidsRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uuids, that.uuids)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(uuids)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuids", uuids)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(final List<String> uuids) {
        this.uuids = uuids;
    }
    //endregion
}

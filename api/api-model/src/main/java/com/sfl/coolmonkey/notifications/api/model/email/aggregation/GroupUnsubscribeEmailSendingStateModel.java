package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:36 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupUnsubscribeEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = -6960862477221910763L;

    //region Properties
    @JsonProperty("useragent")
    private String userAgent;

    @JsonProperty("ip")
    private String ip;
    //endregion

    //region Constructors
    public GroupUnsubscribeEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.GROUP_UNSUBSCRIBE);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GroupUnsubscribeEmailSendingStateModel)) {
            return false;
        }
        final GroupUnsubscribeEmailSendingStateModel that = (GroupUnsubscribeEmailSendingStateModel) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(userAgent, that.userAgent)
                .append(ip, that.ip)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(userAgent)
                .append(ip)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userAgent", userAgent)
                .append("ip", ip)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(final String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }
    //endregion
}

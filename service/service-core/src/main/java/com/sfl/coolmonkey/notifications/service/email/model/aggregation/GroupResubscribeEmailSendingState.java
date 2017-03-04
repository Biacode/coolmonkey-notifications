package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:38 PM
 */
public class GroupResubscribeEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = -6560228004047792856L;

    //region Properties
    @Field("userAgent")
    private String userAgent;

    @Field("ip")
    private String ip;
    //endregion

    //region Constructors
    public GroupResubscribeEmailSendingState() {
        super(EmailSendingEventType.GROUP_RESUBSCRIBE);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GroupResubscribeEmailSendingState)) {
            return false;
        }
        final GroupResubscribeEmailSendingState that = (GroupResubscribeEmailSendingState) o;
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

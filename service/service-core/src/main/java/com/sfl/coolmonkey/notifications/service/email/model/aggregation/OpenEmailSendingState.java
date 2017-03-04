package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 11:59 AM
 */
public class OpenEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = 346952726690670603L;

    //region Properties
    @Field("ip")
    private String ip;

    @Field("userAgent")
    private String userAgent;

    @Field("newsletter")
    private EmailSendingNewsletter newsletter;
    //endregion

    //region Constructors
    public OpenEmailSendingState() {
        super(EmailSendingEventType.OPEN);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OpenEmailSendingState)) {
            return false;
        }
        final OpenEmailSendingState that = (OpenEmailSendingState) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(ip, that.ip)
                .append(userAgent, that.userAgent)
                .append(newsletter, that.newsletter)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(ip)
                .append(userAgent)
                .append(newsletter)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ip", ip)
                .append("userAgent", userAgent)
                .append("newsletter", newsletter)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(final String userAgent) {
        this.userAgent = userAgent;
    }

    public EmailSendingNewsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletter newsletter) {
        this.newsletter = newsletter;
    }
    //endregion
}

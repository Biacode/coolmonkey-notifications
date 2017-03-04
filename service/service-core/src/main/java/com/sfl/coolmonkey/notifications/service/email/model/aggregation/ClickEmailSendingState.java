package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 11:25 AM
 */
public class ClickEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = -6668155867848733376L;

    //region Properties
    @Field("ip")
    private String ip;

    @Field("userAgent")
    private String userAgent;

    @Field("url")
    private String url;

    @Field("newsletter")
    private EmailSendingNewsletter newsletter;
    //endregion

    //region Constructors
    public ClickEmailSendingState() {
        super(EmailSendingEventType.CLICK);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClickEmailSendingState)) {
            return false;
        }
        final ClickEmailSendingState that = (ClickEmailSendingState) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(ip, that.ip)
                .append(userAgent, that.userAgent)
                .append(url, that.url)
                .append(newsletter, that.newsletter)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(ip)
                .append(userAgent)
                .append(url)
                .append(newsletter)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ip", ip)
                .append("userAgent", userAgent)
                .append("url", url)
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

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public EmailSendingNewsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletter newsletter) {
        this.newsletter = newsletter;
    }
    //endregion
}

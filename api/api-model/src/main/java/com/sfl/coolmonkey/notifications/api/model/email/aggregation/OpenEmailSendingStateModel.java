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
 * Time: 11:59 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = 346952726690670603L;

    //region Properties
    @JsonProperty("ip")
    private String ip;

    @JsonProperty("useragent")
    private String userAgent;

    @JsonProperty("newsletter")
    private EmailSendingNewsletterModel newsletter;
    //endregion

    //region Constructors
    public OpenEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.OPEN);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OpenEmailSendingStateModel)) {
            return false;
        }
        final OpenEmailSendingStateModel that = (OpenEmailSendingStateModel) o;
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

    public EmailSendingNewsletterModel getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletterModel newsletter) {
        this.newsletter = newsletter;
    }
    //endregion
}

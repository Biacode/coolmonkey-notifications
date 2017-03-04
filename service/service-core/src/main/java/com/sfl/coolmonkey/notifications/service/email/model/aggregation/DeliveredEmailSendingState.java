package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 11:48 AM
 */
public class DeliveredEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = -1358302801721908626L;

    //region Properties
    @Field("response")
    private String response;

    @Field("smtpId")
    private String smtpId;

    @Field("newsletter")
    private EmailSendingNewsletter newsletter;

    @Field("ip")
    private String ip;

    @Field("tls")
    private String tls;

    @Field("certError")
    private String certError;
    //endregion

    //region Constructors
    public DeliveredEmailSendingState() {
        super(EmailSendingEventType.DELIVERED);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeliveredEmailSendingState)) {
            return false;
        }
        final DeliveredEmailSendingState that = (DeliveredEmailSendingState) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(response, that.response)
                .append(smtpId, that.smtpId)
                .append(newsletter, that.newsletter)
                .append(ip, that.ip)
                .append(tls, that.tls)
                .append(certError, that.certError)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(response)
                .append(smtpId)
                .append(newsletter)
                .append(ip)
                .append(tls)
                .append(certError)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("response", response)
                .append("smtpId", smtpId)
                .append("newsletter", newsletter)
                .append("ip", ip)
                .append("tls", tls)
                .append("certError", certError)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getResponse() {
        return response;
    }

    public void setResponse(final String response) {
        this.response = response;
    }

    public String getSmtpId() {
        return smtpId;
    }

    public void setSmtpId(final String smtpId) {
        this.smtpId = smtpId;
    }

    public EmailSendingNewsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletter newsletter) {
        this.newsletter = newsletter;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public String getTls() {
        return tls;
    }

    public void setTls(final String tls) {
        this.tls = tls;
    }

    public String getCertError() {
        return certError;
    }

    public void setCertError(final String certError) {
        this.certError = certError;
    }
    //endregion
}

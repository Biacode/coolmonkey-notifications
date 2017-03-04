package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 10:57 AM
 */
public class BounceEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = 1019896337395052481L;

    //region Properties
    @Field("status")
    private String status;

    @Field("smtpId")
    private String smtpId;

    @Field("newsletter")
    private EmailSendingNewsletter newsletter;

    @Field("reason")
    private String reason;

    @Field("type")
    private BounceType type;

    @Field("ip")
    private String ip;

    @Field("tls")
    private String tls;

    @Field("certError")
    private String certError;
    //endregion

    //region Constructors
    public BounceEmailSendingState() {
        super(EmailSendingEventType.BOUNCE);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BounceEmailSendingState)) {
            return false;
        }
        final BounceEmailSendingState that = (BounceEmailSendingState) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(status, that.status)
                .append(smtpId, that.smtpId)
                .append(newsletter, that.newsletter)
                .append(reason, that.reason)
                .append(type, that.type)
                .append(ip, that.ip)
                .append(tls, that.tls)
                .append(certError, that.certError)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(status)
                .append(smtpId)
                .append(newsletter)
                .append(reason)
                .append(type)
                .append(ip)
                .append(tls)
                .append(certError)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("smtpId", smtpId)
                .append("newsletter", newsletter)
                .append("reason", reason)
                .append("type", type)
                .append("ip", ip)
                .append("tls", tls)
                .append("certError", certError)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
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

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public BounceType getType() {
        return type;
    }

    public void setType(final BounceType type) {
        this.type = type;
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

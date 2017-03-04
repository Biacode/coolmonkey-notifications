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
 * Time: 11:32 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeferredEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = -3607007640355510054L;

    //region Properties
    @JsonProperty("response")
    private String response;

    @JsonProperty("smtp-id")
    private String smtpId;

    @JsonProperty("attempt")
    private Integer attempt;

    @JsonProperty("newsletter")
    private EmailSendingNewsletterModel newsletter;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("tls")
    private String tls;

    @JsonProperty("cert_error")
    private String certError;
    //endregion

    //region Constructors
    public DeferredEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.DEFERRED);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeferredEmailSendingStateModel)) {
            return false;
        }
        final DeferredEmailSendingStateModel that = (DeferredEmailSendingStateModel) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(response, that.response)
                .append(smtpId, that.smtpId)
                .append(attempt, that.attempt)
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
                .append(attempt)
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
                .append("attempt", attempt)
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

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(final Integer attempt) {
        this.attempt = attempt;
    }

    public EmailSendingNewsletterModel getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletterModel newsletter) {
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

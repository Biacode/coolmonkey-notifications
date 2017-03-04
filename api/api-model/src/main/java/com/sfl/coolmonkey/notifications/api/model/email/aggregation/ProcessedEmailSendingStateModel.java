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
 * Time: 12:03 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessedEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = 8202116774064098776L;

    //region Properties
    @JsonProperty("smtp-id")
    private String smtpId;

    @JsonProperty("newsletter")
    private EmailSendingNewsletterModel newsletter;

    @JsonProperty("send_at")
    private Integer sendAt;
    //endregion

    //region Constructors
    public ProcessedEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.PROCESSED);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessedEmailSendingStateModel)) {
            return false;
        }
        final ProcessedEmailSendingStateModel that = (ProcessedEmailSendingStateModel) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(smtpId, that.smtpId)
                .append(newsletter, that.newsletter)
                .append(sendAt, that.sendAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(smtpId)
                .append(newsletter)
                .append(sendAt)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("smtpId", smtpId)
                .append("newsletter", newsletter)
                .append("sendAt", sendAt)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getSmtpId() {
        return smtpId;
    }

    public void setSmtpId(final String smtpId) {
        this.smtpId = smtpId;
    }

    public EmailSendingNewsletterModel getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletterModel newsletter) {
        this.newsletter = newsletter;
    }

    public Integer getSendAt() {
        return sendAt;
    }

    public void setSendAt(final Integer sendAt) {
        this.sendAt = sendAt;
    }
    //endregion
}

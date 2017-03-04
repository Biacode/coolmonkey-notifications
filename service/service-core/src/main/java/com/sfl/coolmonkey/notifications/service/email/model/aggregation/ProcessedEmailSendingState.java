package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:03 PM
 */
public class ProcessedEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = 8202116774064098776L;

    //region Properties
    @Field("smtpId")
    private String smtpId;

    @Field("newsletter")
    private EmailSendingNewsletter newsletter;

    @Field("sendAt")
    private Integer sendAt;
    //endregion

    //region Constructors
    public ProcessedEmailSendingState() {
        super(EmailSendingEventType.PROCESSED);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessedEmailSendingState)) {
            return false;
        }
        final ProcessedEmailSendingState that = (ProcessedEmailSendingState) o;
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

    public EmailSendingNewsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(final EmailSendingNewsletter newsletter) {
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

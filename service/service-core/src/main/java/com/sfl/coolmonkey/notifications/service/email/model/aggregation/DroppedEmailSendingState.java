package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 11:54 AM
 */
public class DroppedEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = 1558592902570898974L;

    //region Properties
    @Field("smtpId")
    private String smtpId;

    @Field("reason")
    private String reason;
    //endregion

    //region Constructors
    public DroppedEmailSendingState() {
        super(EmailSendingEventType.DROPPED);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DroppedEmailSendingState)) {
            return false;
        }
        final DroppedEmailSendingState that = (DroppedEmailSendingState) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(smtpId, that.smtpId)
                .append(reason, that.reason)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(smtpId)
                .append(reason)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("smtpId", smtpId)
                .append("reason", reason)
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

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }
    //endregion
}

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
 * Time: 11:54 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DroppedEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = 1558592902570898974L;

    //region Properties
    @JsonProperty("smtp-id")
    private String smtpId;

    @JsonProperty("reason")
    private String reason;
    //endregion

    //region Constructors
    public DroppedEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.DROPPED);
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DroppedEmailSendingStateModel)) {
            return false;
        }
        final DroppedEmailSendingStateModel that = (DroppedEmailSendingStateModel) o;
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

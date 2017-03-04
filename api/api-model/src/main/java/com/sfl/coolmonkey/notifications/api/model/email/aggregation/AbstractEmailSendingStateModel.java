package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sfl.coolmonkey.commons.api.model.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 10:50 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "event")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BounceEmailSendingStateModel.class, name = "bounce"),
        @JsonSubTypes.Type(value = ClickEmailSendingStateModel.class, name = "click"),
        @JsonSubTypes.Type(value = DeferredEmailSendingStateModel.class, name = "deferred"),
        @JsonSubTypes.Type(value = DeliveredEmailSendingStateModel.class, name = "delivered"),
        @JsonSubTypes.Type(value = DroppedEmailSendingStateModel.class, name = "dropped"),
        @JsonSubTypes.Type(value = OpenEmailSendingStateModel.class, name = "open"),
        @JsonSubTypes.Type(value = ProcessedEmailSendingStateModel.class, name = "processed"),
        @JsonSubTypes.Type(value = SpamReportEmailSendingStateModel.class, name = "spamreport"),
        @JsonSubTypes.Type(value = UnsubscribeEmailSendingStateModel.class, name = "unsubscribe"),
        @JsonSubTypes.Type(value = GroupUnsubscribeEmailSendingStateModel.class, name = "group_unsubscribe"),
        @JsonSubTypes.Type(value = GroupResubscribeEmailSendingStateModel.class, name = "group_resubscribe")
})
public abstract class AbstractEmailSendingStateModel implements ApiModel {
    private static final long serialVersionUID = -2326785297214020373L;

    //region Properties
    @JsonProperty("emailUuid")
    private String emailUuid;

    @JsonProperty("event")
    private EmailSendingEventTypeModel event;

    @JsonProperty("sg_event_id")
    private String sgEventId;

    @JsonProperty("sg_message_id")
    private String sgMessageId;

    @JsonProperty("timestamp")
    private Integer timestamp;

    @JsonProperty("email")
    private String email;

    @JsonProperty("category")
    private String category;

    @JsonProperty("asm_group_id")
    private Integer asmGroupId;
    //endregion

    //region Constructors
    public AbstractEmailSendingStateModel(final EmailSendingEventTypeModel event) {
        this.event = event;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractEmailSendingStateModel)) {
            return false;
        }
        final AbstractEmailSendingStateModel that = (AbstractEmailSendingStateModel) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(emailUuid, that.emailUuid)
                .append(event, that.event)
                .append(sgEventId, that.sgEventId)
                .append(sgMessageId, that.sgMessageId)
                .append(timestamp, that.timestamp)
                .append(email, that.email)
                .append(category, that.category)
                .append(asmGroupId, that.asmGroupId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(emailUuid)
                .append(event)
                .append(sgEventId)
                .append(sgMessageId)
                .append(timestamp)
                .append(email)
                .append(category)
                .append(asmGroupId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("emailUuid", emailUuid)
                .append("event", event)
                .append("sgEventId", sgEventId)
                .append("sgMessageId", sgMessageId)
                .append("timestamp", timestamp)
                .append("email", email)
                .append("category", category)
                .append("asmGroupId", asmGroupId)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getEmailUuid() {
        return emailUuid;
    }

    public void setEmailUuid(final String emailUuid) {
        this.emailUuid = emailUuid;
    }

    public EmailSendingEventTypeModel getEvent() {
        return event;
    }

    public void setEvent(final EmailSendingEventTypeModel event) {
        this.event = event;
    }

    public String getSgEventId() {
        return sgEventId;
    }

    public void setSgEventId(final String sgEventId) {
        this.sgEventId = sgEventId;
    }

    public String getSgMessageId() {
        return sgMessageId;
    }

    public void setSgMessageId(final String sgMessageId) {
        this.sgMessageId = sgMessageId;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public Integer getAsmGroupId() {
        return asmGroupId;
    }

    public void setAsmGroupId(final Integer asmGroupId) {
        this.asmGroupId = asmGroupId;
    }
    //endregion
}

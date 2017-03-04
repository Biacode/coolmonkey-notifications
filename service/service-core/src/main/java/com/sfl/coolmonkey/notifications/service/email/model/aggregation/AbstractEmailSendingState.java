package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

import com.sfl.coolmonkey.notifications.service.common.model.AbstractDomainRootDocumentEntityModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 10:50 AM
 */
public abstract class AbstractEmailSendingState extends AbstractDomainRootDocumentEntityModel {
    private static final long serialVersionUID = -2326785297214020373L;

    //region Properties
    @Field("event")
    private EmailSendingEventType event;

    @Field("sgEventId")
    private String sgEventId;

    @Field("sgMessageId")
    private String sgMessageId;

    @Field("timestamp")
    private Integer timestamp;

    @Field("email")
    private String email;

    @Field("category")
    private String category;

    @Field("asmGroupId")
    private Integer asmGroupId;
    //endregion

    //region Constructors
    public AbstractEmailSendingState(final EmailSendingEventType event) {
        super();
        this.event = event;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractEmailSendingState)) {
            return false;
        }
        final AbstractEmailSendingState that = (AbstractEmailSendingState) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
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
    public EmailSendingEventType getEvent() {
        return event;
    }

    public void setEvent(final EmailSendingEventType event) {
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

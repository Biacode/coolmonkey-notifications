package com.sfl.coolmonkey.notifications.service.email.model;

import com.sfl.coolmonkey.notifications.service.common.model.AbstractDomainRootDocumentEntityModel;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.AbstractEmailSendingState;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/17/15
 * Time: 7:15 PM
 */
public class Email extends AbstractDomainRootDocumentEntityModel {
    private static final long serialVersionUID = -7618144550914823567L;

    //region Properties
    @Field("uuid")
    @Indexed(name = "email_uuid_idx", direction = IndexDirection.ASCENDING, unique = true)
    private String uuid;

    @Field("to")
    private String to;

    @Field("from")
    private String from;

    @Field("senderName")
    private String senderName;

    @Field("replyEmail")
    private String replyEmail;

    @Field("subject")
    private String subject;

    @Field("content")
    private String content;

    @Field("attachments")
    private List<String> attachments;

    @Field("cc")
    private List<String> cc;

    @Field("bcc")
    private List<String> bcc;

    @Field("emailSendingStates")
    private List<AbstractEmailSendingState> emailSendingStates;

    @Field("origin")
    private EmailOrigin origin;
    //endregion

    //region Constructors
    public Email() {
        setInstanceDefaultProperties();
    }
    //endregion

    //region Utility methods
    private void setInstanceDefaultProperties() {
        uuid = UUID.randomUUID().toString();
        emailSendingStates = new ArrayList<>();
        attachments = new ArrayList<>();
        this.origin = EmailOrigin.UNKNOWN_ORIGIN;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Email)) {
            return false;
        }
        final Email email = (Email) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uuid, email.uuid)
                .append(to, email.to)
                .append(from, email.from)
                .append(senderName, email.senderName)
                .append(replyEmail, email.replyEmail)
                .append(subject, email.subject)
                .append(content, email.content)
                .append(attachments, email.attachments)
                .append(cc, email.cc)
                .append(bcc, email.bcc)
                .append(emailSendingStates, email.emailSendingStates)
                .append(origin, email.origin)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(uuid)
                .append(to)
                .append(from)
                .append(senderName)
                .append(replyEmail)
                .append(subject)
                .append(content)
                .append(attachments)
                .append(cc)
                .append(bcc)
                .append(emailSendingStates)
                .append(origin)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .append("to", to)
                .append("from", from)
                .append("senderName", senderName)
                .append("replyEmail", replyEmail)
                .append("subject", subject)
                .append("content", content)
                .append("attachments", attachments)
                .append("cc", cc)
                .append("bcc", bcc)
                .append("emailSendingStates", emailSendingStates)
                .append("origin", origin)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(final String senderName) {
        this.senderName = senderName;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(final String replyEmail) {
        this.replyEmail = replyEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(final List<String> attachments) {
        this.attachments = attachments;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(final List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(final List<String> bcc) {
        this.bcc = bcc;
    }

    public List<AbstractEmailSendingState> getEmailSendingStates() {
        return emailSendingStates;
    }

    public void setEmailSendingStates(final List<AbstractEmailSendingState> emailSendingStates) {
        this.emailSendingStates = emailSendingStates;
    }

    public EmailOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(final EmailOrigin origin) {
        this.origin = origin;
    }
    //endregion
}

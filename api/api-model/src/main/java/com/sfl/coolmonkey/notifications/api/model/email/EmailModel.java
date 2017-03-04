package com.sfl.coolmonkey.notifications.api.model.email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.ApiModel;
import com.sfl.coolmonkey.notifications.api.model.email.aggregation.AbstractEmailSendingStateModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/21/15
 * Time: 7:02 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailModel implements ApiModel {
    private static final long serialVersionUID = 5667354601125847196L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("to")
    private String to;

    @JsonProperty("from")
    private String from;

    @JsonProperty("senderName")
    private String senderName;

    @JsonProperty("replyEmail")
    private String replyEmail;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("content")
    private String content;

    @JsonProperty("attachments")
    private List<String> attachments;

    @JsonProperty("cc")
    private List<String> cc;

    @JsonProperty("bcc")
    private List<String> bcc;

    @JsonProperty("emailSendingStates")
    private List<AbstractEmailSendingStateModel> emailSendingStates;

    @JsonProperty("origin")
    private EmailOriginModel origin;
    //endregion

    //region Constructors
    public EmailModel() {
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailModel)) {
            return false;
        }
        final EmailModel that = (EmailModel) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .append(to, that.to)
                .append(from, that.from)
                .append(senderName, that.senderName)
                .append(replyEmail, that.replyEmail)
                .append(subject, that.subject)
                .append(content, that.content)
                .append(attachments, that.attachments)
                .append(cc, that.cc)
                .append(bcc, that.bcc)
                .append(emailSendingStates, that.emailSendingStates)
                .append(origin, that.origin)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
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

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(final String senderName) {
        this.senderName = senderName;
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

    public List<AbstractEmailSendingStateModel> getEmailSendingStates() {
        return emailSendingStates;
    }

    public void setEmailSendingStates(final List<AbstractEmailSendingStateModel> emailSendingStates) {
        this.emailSendingStates = emailSendingStates;
    }

    public EmailOriginModel getOrigin() {
        return origin;
    }

    public void setOrigin(final EmailOriginModel origin) {
        this.origin = origin;
    }
    //endregion
}

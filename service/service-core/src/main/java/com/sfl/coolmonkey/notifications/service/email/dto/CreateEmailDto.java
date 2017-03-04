package com.sfl.coolmonkey.notifications.service.email.dto;

import com.sfl.coolmonkey.notifications.service.common.dto.AbstractDomainEntityModelDto;
import com.sfl.coolmonkey.notifications.service.email.model.EmailOrigin;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/17/15
 * Time: 7:16 PM
 */
public class CreateEmailDto extends AbstractDomainEntityModelDto {
    private static final long serialVersionUID = 4682263292961757396L;

    //region Properties
    private String to;

    private String from;

    private String senderName;

    private String replyEmail;

    private String subject;

    private String content;

    private List<String> attachments;

    private List<String> cc;

    private List<String> bcc;

    private EmailOrigin origin;
    //endregion

    //region Constructors
    public CreateEmailDto() {
    }

    public CreateEmailDto(final String to,
                          final String from,
                          final String senderName,
                          final String replyEmail,
                          final String subject,
                          final String content,
                          final List<String> attachments,
                          final List<String> cc,
                          final List<String> bcc,
                          final EmailOrigin origin) {
        this.to = to;
        this.from = from;
        this.senderName = senderName;
        this.replyEmail = replyEmail;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
        this.cc = cc;
        this.bcc = bcc;
        this.origin = origin;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateEmailDto)) {
            return false;
        }
        final CreateEmailDto that = (CreateEmailDto) o;
        return new EqualsBuilder()
                .append(to, that.to)
                .append(from, that.from)
                .append(senderName, that.senderName)
                .append(replyEmail, that.replyEmail)
                .append(subject, that.subject)
                .append(content, that.content)
                .append(attachments, that.attachments)
                .append(cc, that.cc)
                .append(bcc, that.bcc)
                .append(origin, that.origin)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(to)
                .append(from)
                .append(senderName)
                .append(replyEmail)
                .append(subject)
                .append(content)
                .append(attachments)
                .append(cc)
                .append(bcc)
                .append(origin)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("to", to)
                .append("from", from)
                .append("senderName", senderName)
                .append("replyEmail", replyEmail)
                .append("subject", subject)
                .append("content", content)
                .append("attachments", attachments)
                .append("cc", cc)
                .append("bcc", bcc)
                .append("origin", origin)
                .toString();
    }
    //endregion

    //region Properties getters and setters
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

    public EmailOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(final EmailOrigin origin) {
        this.origin = origin;
    }
    //endregion
}

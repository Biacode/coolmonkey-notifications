package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 11:13 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailSendingNewsletterModel implements Serializable {
    private static final long serialVersionUID = -2023032944941768196L;

    //region Properties
    @JsonProperty("newsletter_id")
    private Long newsletterId;

    @JsonProperty("newsletter_send_id")
    private Long newsletterSendId;

    @JsonProperty("newsletter_user_list_id")
    private Long newsletterUserListId;
    //endregion

    //region Constructors
    public EmailSendingNewsletterModel() {
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailSendingNewsletterModel)) {
            return false;
        }
        final EmailSendingNewsletterModel that = (EmailSendingNewsletterModel) o;
        return new EqualsBuilder()
                .append(newsletterId, that.newsletterId)
                .append(newsletterSendId, that.newsletterSendId)
                .append(newsletterUserListId, that.newsletterUserListId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(newsletterId)
                .append(newsletterSendId)
                .append(newsletterUserListId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("newsletterId", newsletterId)
                .append("newsletterSendId", newsletterSendId)
                .append("newsletterUserListId", newsletterUserListId)
                .toString();
    }
    //endregion

    //region Equals, HashCode and ToString
    public Long getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(final Long newsletterId) {
        this.newsletterId = newsletterId;
    }

    public Long getNewsletterSendId() {
        return newsletterSendId;
    }

    public void setNewsletterSendId(final Long newsletterSendId) {
        this.newsletterSendId = newsletterSendId;
    }

    public Long getNewsletterUserListId() {
        return newsletterUserListId;
    }

    public void setNewsletterUserListId(final Long newsletterUserListId) {
        this.newsletterUserListId = newsletterUserListId;
    }
    //endregion
}

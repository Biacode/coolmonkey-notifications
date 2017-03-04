package com.sfl.coolmonkey.notifications.api.model.email.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/5/16
 * Time: 3:52 PM
 */
public class GetEmailsByUuidsResponse extends AbstractResponseModel {
    private static final long serialVersionUID = -3426067813818491438L;

    //region Properties
    @JsonProperty("emails")
    private List<EmailWithAttachmentsModel> emails;
    //endregion

    //region Constructors
    public GetEmailsByUuidsResponse() {
    }

    public GetEmailsByUuidsResponse(final List<EmailWithAttachmentsModel> emails) {
        this.emails = emails;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetEmailsByUuidsResponse)) {
            return false;
        }
        final GetEmailsByUuidsResponse that = (GetEmailsByUuidsResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(emails, that.emails)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(emails)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("emails", emails)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public List<EmailWithAttachmentsModel> getEmails() {
        return emails;
    }

    public void setEmails(final List<EmailWithAttachmentsModel> emails) {
        this.emails = emails;
    }
    //endregion
}

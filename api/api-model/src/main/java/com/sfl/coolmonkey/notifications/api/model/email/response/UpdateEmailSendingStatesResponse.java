package com.sfl.coolmonkey.notifications.api.model.email.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 2:34 PM
 */
public class UpdateEmailSendingStatesResponse extends AbstractResponseModel {
    private static final long serialVersionUID = -1175054724231646469L;

    //region Properties
    @JsonProperty("emails")
    private List<EmailModel> emails;
    //endregion

    //region Constructors
    public UpdateEmailSendingStatesResponse() {
    }

    public UpdateEmailSendingStatesResponse(final List<EmailModel> emails) {
        this.emails = emails;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateEmailSendingStatesResponse)) {
            return false;
        }
        final UpdateEmailSendingStatesResponse that = (UpdateEmailSendingStatesResponse) o;
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
    public List<EmailModel> getEmails() {
        return emails;
    }

    public void setEmails(final List<EmailModel> emails) {
        this.emails = emails;
    }
    //endregion
}

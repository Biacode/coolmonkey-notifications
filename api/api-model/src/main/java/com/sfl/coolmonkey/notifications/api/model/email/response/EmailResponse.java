package com.sfl.coolmonkey.notifications.api.model.email.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/12/16
 * Time: 6:33 PM
 */
public class EmailResponse extends AbstractResponseModel {
    private static final long serialVersionUID = 6912037056887988511L;

    //region Properties
    @JsonProperty("email")
    private EmailModel email;
    //endregion

    //region Constructors
    public EmailResponse() {
    }

    public EmailResponse(final EmailModel email) {
        this.email = email;
    }
    //endregion

    //region Equals, HasCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailResponse)) {
            return false;
        }
        final EmailResponse that = (EmailResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(email, that.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(email)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", email)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public EmailModel getEmail() {
        return email;
    }

    public void setEmail(final EmailModel email) {
        this.email = email;
    }
    //endregion
}

package com.sfl.coolmonkey.notifications.api.model.email.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import com.sfl.coolmonkey.notifications.api.model.email.aggregation.AbstractEmailSendingStateModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 2:32 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateEmailSendingStatesRequest extends AbstractRequestModel {
    private static final long serialVersionUID = 5649636514435701684L;

    //region Properties
    private List<AbstractEmailSendingStateModel> models;
    //endregion

    //region Constructors
    @JsonCreator
    public UpdateEmailSendingStatesRequest(final List<AbstractEmailSendingStateModel> models) {
        this.models = models;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateEmailSendingStatesRequest)) {
            return false;
        }
        final UpdateEmailSendingStatesRequest that = (UpdateEmailSendingStatesRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(models, that.models)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(models)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("models", models)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    @JsonValue
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public List<AbstractEmailSendingStateModel> getModels() {
        return models;
    }

    // this setters is useful only in tests
    public void setModels(final List<AbstractEmailSendingStateModel> models) {
        this.models = models;
    }
    //endregion
}

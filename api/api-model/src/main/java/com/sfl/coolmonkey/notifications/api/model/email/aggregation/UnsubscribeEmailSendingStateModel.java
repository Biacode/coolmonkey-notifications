package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:30 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribeEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = 551965330074640830L;

    //region Properties
    //endregion

    //region Constructors
    public UnsubscribeEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.UNSUBSCRIBE);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}

package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:21 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpamReportEmailSendingStateModel extends AbstractEmailSendingStateModel {
    private static final long serialVersionUID = -9137347058614941046L;

    //region Properties
    //endregion

    //region Constructors
    public SpamReportEmailSendingStateModel() {
        super(EmailSendingEventTypeModel.SPAM_REPORT);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}

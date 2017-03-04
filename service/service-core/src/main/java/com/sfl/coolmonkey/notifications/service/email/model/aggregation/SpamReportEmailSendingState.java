package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:21 PM
 */
public class SpamReportEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = -9137347058614941046L;

    //region Properties
    //endregion

    //region Constructors
    public SpamReportEmailSendingState() {
        super(EmailSendingEventType.SPAM_REPORT);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}

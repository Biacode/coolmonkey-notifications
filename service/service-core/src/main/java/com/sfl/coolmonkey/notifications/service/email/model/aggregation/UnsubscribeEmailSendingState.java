package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 12:30 PM
 */
public class UnsubscribeEmailSendingState extends AbstractEmailSendingState {
    private static final long serialVersionUID = 551965330074640830L;

    //region Properties
    //endregion

    //region Constructors
    public UnsubscribeEmailSendingState() {
        super(EmailSendingEventType.UNSUBSCRIBE);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}

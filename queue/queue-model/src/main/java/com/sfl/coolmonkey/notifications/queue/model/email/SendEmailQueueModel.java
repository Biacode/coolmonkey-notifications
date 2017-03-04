package com.sfl.coolmonkey.notifications.queue.model.email;

import com.sfl.coolmonkey.notifications.queue.model.common.AbstractUuidAwareQueueModel;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:35
 */
public class SendEmailQueueModel extends AbstractUuidAwareQueueModel {
    private static final long serialVersionUID = 2594241224629183186L;

    //region Properties
    //endregion

    //region Constructors
    public SendEmailQueueModel() {
    }

    public SendEmailQueueModel(final String uuid) {
        super(uuid);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}

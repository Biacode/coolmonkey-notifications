package com.sfl.coolmonkey.notifications.service.email.model.aggregation;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 10:51 AM
 */
public enum EmailSendingEventType {
    BOUNCE,
    CLICK,
    DEFERRED,
    DELIVERED,
    DROPPED,
    OPEN,
    PROCESSED,
    SPAM_REPORT,
    UNSUBSCRIBE,
    GROUP_UNSUBSCRIBE,
    GROUP_RESUBSCRIBE
}

package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 10:51 AM
 */
public enum EmailSendingEventTypeModel {

    @JsonProperty("bounce")
    BOUNCE,

    @JsonProperty("click")
    CLICK,

    @JsonProperty("deferred")
    DEFERRED,

    @JsonProperty("delivered")
    DELIVERED,

    @JsonProperty("dropped")
    DROPPED,

    @JsonProperty("open")
    OPEN,

    @JsonProperty("processed")
    PROCESSED,

    @JsonProperty("spamreport")
    SPAM_REPORT,

    @JsonProperty("unsubscribe")
    UNSUBSCRIBE,

    @JsonProperty("group_unsubscribe")
    GROUP_UNSUBSCRIBE,

    @JsonProperty("group_resubscribe")
    GROUP_RESUBSCRIBE,
}

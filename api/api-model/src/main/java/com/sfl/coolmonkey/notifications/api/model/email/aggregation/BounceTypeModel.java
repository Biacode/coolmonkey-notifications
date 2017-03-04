package com.sfl.coolmonkey.notifications.api.model.email.aggregation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 11:19 AM
 */
public enum BounceTypeModel {

    @JsonProperty("bounce")
    BOUNCE,

    @JsonProperty("blocked")
    BLOCKED,

    @JsonProperty("expired")
    EXPIRED,
}

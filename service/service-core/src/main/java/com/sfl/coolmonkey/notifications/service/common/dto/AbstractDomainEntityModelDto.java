package com.sfl.coolmonkey.notifications.service.common.dto;

import org.joda.time.MutableDateTime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/14/15
 * Time: 2:16 PM
 */
public abstract class AbstractDomainEntityModelDto implements Serializable {
    private static final long serialVersionUID = 994996008376762751L;

    //region Constructors
    public AbstractDomainEntityModelDto() {
    }
    //endregion

    //region Utility methods
    public static Date cloneDateIfNotNull(final Date date) {
        if (date == null) {
            return null;
        }
        final MutableDateTime mutableDateTime = new MutableDateTime(date);
        return mutableDateTime.toDate();
    }
    //endregion

    public static Double getDoubleValueOrNull(final BigDecimal value) {
        return value != null ? value.doubleValue() : null;
    }

    //region Abstract methods
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}

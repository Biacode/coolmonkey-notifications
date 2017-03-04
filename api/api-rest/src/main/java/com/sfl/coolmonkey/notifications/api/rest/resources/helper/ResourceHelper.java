package com.sfl.coolmonkey.notifications.api.rest.resources.helper;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import org.springframework.util.Assert;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/21/15
 * Time: 6:54 PM
 */
public final class ResourceHelper {

    //region Constructors
    private ResourceHelper() {
    }
    //endregion

    //region Public methods
    public static void assertRequestNotNull(final AbstractRequestModel request) {
        Assert.notNull(request);
    }

    public static void assertRequestNotNull(final EmailRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getEmail());
    }
    //endregion

}

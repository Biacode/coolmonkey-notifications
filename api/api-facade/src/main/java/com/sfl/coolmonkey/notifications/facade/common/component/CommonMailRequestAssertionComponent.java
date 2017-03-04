package com.sfl.coolmonkey.notifications.facade.common.component;


import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/21/15
 * Time: 6:58 PM
 */
public interface CommonMailRequestAssertionComponent {
    void assertCommonMailRequest(@Nonnull final EmailRequest request);
}

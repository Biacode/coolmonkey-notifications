package com.sfl.coolmonkey.notifications.facade.common.component.impl;

import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import com.sfl.coolmonkey.notifications.facade.common.component.CommonMailRequestAssertionComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/21/15
 * Time: 6:59 PM
 */
@Component
public class CommonMailRequestAssertionComponentImpl implements CommonMailRequestAssertionComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonMailRequestAssertionComponentImpl.class);

    //region Dependencies
    //endregion

    //region Constructors
    public CommonMailRequestAssertionComponentImpl() {
        LOGGER.debug("Initializing common mail request assertion component");
    }
    //endregion

    //region Public methods
    @Override
    public void assertCommonMailRequest(@Nonnull final EmailRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getEmail());
        final EmailModel emailModel = request.getEmail();
        Assert.hasText(emailModel.getTo());
        Assert.hasText(emailModel.getFrom());
    }
    //endregion

    //region Utility methods
    //endregion
}

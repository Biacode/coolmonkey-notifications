package com.sfl.coolmonkey.notifications.service.common.component.impl;

import com.sfl.coolmonkey.notifications.service.common.component.CommonAssertionComponent;
import com.sfl.coolmonkey.notifications.service.common.exception.ServicesRuntimeException;
import com.sfl.coolmonkey.notifications.service.common.model.AbstractDomainEntityModel;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/18/15
 * Time: 12:00 PM
 */
@Component
public class CommonAssertionComponentImpl implements CommonAssertionComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonAssertionComponentImpl.class);

    //region Dependencies
    //endregion

    //region Constructors
    public CommonAssertionComponentImpl() {
        LOGGER.debug("Initializing common assertion component");
    }
    //endregion

    //region Public methods
    @Override
    public void assertUuidNotBlank(@Nonnull final String uuid) {
        Assert.hasText(uuid);
    }

    @Override
    public void assertObjectIdNotNull(@Nonnull final ObjectId id) {
        Assert.notNull(id);
    }

    @Override
    public <T extends AbstractDomainEntityModel> void assertDomainModelNotNullForId(@Nonnull final ObjectId id, final T domainModel) {
        if (domainModel == null) {
            LOGGER.error("Can not find domain model for id - {}", id);
            throwServiceRuntimeException("Can not find domain model for id - " + id);
        }
    }

    @Override
    public <T extends AbstractDomainEntityModel> void assertDomainModelNotNullForUuid(@Nonnull final String uuid, final T domainModel) {
        if (domainModel == null) {
            LOGGER.debug("Can not find domain model for uuid - {}", uuid);
            throwServiceRuntimeException("Can not find domain model for uuid - " + uuid);
        }
    }
    //endregion

    //region Utility methods
    private void throwServiceRuntimeException(final String message) {
        throw new ServicesRuntimeException(message);
    }
    //endregion
}

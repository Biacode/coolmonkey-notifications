package com.sfl.coolmonkey.notifications.service.common.component;

import com.sfl.coolmonkey.notifications.service.common.model.AbstractDomainEntityModel;
import org.bson.types.ObjectId;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/18/15
 * Time: 11:58 AM
 */
public interface CommonAssertionComponent {
    void assertUuidNotBlank(@Nonnull final String uuid);

    void assertObjectIdNotNull(@Nonnull final ObjectId id);

    <T extends AbstractDomainEntityModel>
    void assertDomainModelNotNullForId(@Nonnull final ObjectId id, final T domainModel);

    <T extends AbstractDomainEntityModel>
    void assertDomainModelNotNullForUuid(@Nonnull final String uuid, final T domainModel);
}

package com.sfl.coolmonkey.notifications.service.email;

import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.AbstractEmailSendingState;
import org.bson.types.ObjectId;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/17/15
 * Time: 7:16 PM
 */
public interface EmailService {
    /**
     * Gets email by id
     *
     * @param id the id
     * @return by id
     */
    Email getById(@Nonnull final ObjectId id);

    /**
     * Gets email by uuid
     *
     * @param uuid the uuid
     * @return by uuid
     */
    Email getByUuid(@Nonnull final String uuid);

    /**
     * Creates email for dto
     *
     * @param dto the dto
     * @return email email
     */
    Email create(@Nonnull final CreateEmailDto dto);

    /**
     * Add email sending state.
     *
     * @param uuid  the uuid
     * @param state the state
     * @return the email
     */
    Email addEmailSendingState(@Nonnull final String uuid, @Nonnull final AbstractEmailSendingState state);

    /**
     * Gets emails by provided uuid list
     *
     * @param uuids the uuids
     * @return by uuids
     */
    List<Email> getByUuids(@Nonnull final List<String> uuids);
}

package com.sfl.coolmonkey.notifications.queue.consumer.email;

import com.sfl.coolmonkey.notifications.queue.model.email.SendEmailQueueModel;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:54
 */
public interface EmailSendingConsumer {
    /**
     * Consumes email sending event.
     *
     * @param model the model
     */
    void consumeEmailSendingEvent(@Nonnull final SendEmailQueueModel model);
}

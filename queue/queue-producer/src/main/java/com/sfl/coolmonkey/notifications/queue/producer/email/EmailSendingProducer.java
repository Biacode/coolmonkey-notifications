package com.sfl.coolmonkey.notifications.queue.producer.email;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:29
 */
public interface EmailSendingProducer {
    /**
     * Produces email sending event
     *
     * @param emailUuid the email uuid
     */
    void produceEmailSendingEvent(@Nonnull final String emailUuid);
}

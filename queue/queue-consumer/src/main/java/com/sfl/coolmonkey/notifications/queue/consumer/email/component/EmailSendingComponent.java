package com.sfl.coolmonkey.notifications.queue.consumer.email.component;

import com.sfl.coolmonkey.notifications.service.email.model.Email;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 14:57
 */
public interface EmailSendingComponent {
    /**
     * Process email sending.
     *
     * @param email the email
     */
    void processEmailSending(@Nonnull final Email email);
}
